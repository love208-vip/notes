public class DataSourceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    /**
     * �����ж�����������Ϊ:readOnly�ķ�����
     */
    private List<String> slaveMethodPattern = new ArrayList<String>();

    /**
     * Ĭ�ϵĶ���,��������ͷ
     */
    private static final String[] DEFAULT_SLAVE_METHOD_START = new String[]{ "query", "find", "get" ,"load"};

    /**
     * �ֶ�ָ�����ⷽ��ǰ׺
     */
    private String[] slaveMethodStart;

    /**
     * ��ȡ��������еĲ���
     * @param txAdvice
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void setTxAdvice(TransactionInterceptor txAdvice) throws Exception {
        if (txAdvice == null) {
            // û����������������
            return;
        }
        //��txAdvice��ȡ������������Ϣ
        TransactionAttributeSource transactionAttributeSource = txAdvice.getTransactionAttributeSource();
        if (!(transactionAttributeSource instanceof NameMatchTransactionAttributeSource)) {
            return;
        }
        //ʹ�÷����ȡ��NameMatchTransactionAttributeSource�����е�nameMap����ֵ
        NameMatchTransactionAttributeSource matchTransactionAttributeSource = (NameMatchTransactionAttributeSource) transactionAttributeSource;
        Field nameMapField = ReflectionUtils.findField(NameMatchTransactionAttributeSource.class, "nameMap");
        nameMapField.setAccessible(true); //��������
        //��ȡnameMap��ֵ
        Map<String, TransactionAttribute> map = (Map<String, TransactionAttribute>) nameMapField.get(matchTransactionAttributeSource);
        //����nameMap
        for (Map.Entry<String, TransactionAttribute> entry : map.entrySet()) {
            if (!entry.getValue().isReadOnly()) {
                continue;
            }
            //������ReadOnly�Ĳ��Է�������,���뵽slaveMethodPattern
            slaveMethodPattern.add(entry.getKey());
        }
    }

    /**
     * �ڽ���Service����֮ǰִ��
     * @param point
     */
    public void before(JoinPoint point) {

        // ��ǰִ�еķ�����
        String methodName = point.getSignature().getName();

        //flag
        boolean isSlave = false;

        if (slaveMethodPattern.isEmpty()) {
            // ��ǰSpring������û������������ԣ����÷�����ƥ�䷽ʽ
            isSlave = isSlave(methodName);
        } else {
            // ʹ�ò��Թ�����,ֻ�����Եķ���������ƥ��
            for (String mappedName : this.slaveMethodPattern) {
                if (this.isMatch(methodName, mappedName)) {
                    isSlave = true;
                    break;
                }
            }
        }
        if (isSlave) {
            // ���Ϊ����
            DynamicDataSourceHolder.markSlave();
            LOGGER.info("[��̬����Դ] {} = ����",methodName);
        } else {
            // ���Ϊд��
            DynamicDataSourceHolder.markMaster();
            LOGGER.info("[��̬����Դ] {} = д��",methodName);
        }
    }

    /**
     * �ж��Ƿ�Ϊ����
     * @param methodName
     * @return
     */
    private Boolean isSlave(String methodName) {
        if(methodName == null){
            return false;
        }
        //��Ĭ��,����IOC�����õĹ������ƥ��
        for(String name : this.getSlaveMethodStart()){
            if(methodName.startsWith(name)){
                return true;
            }
        }
        return false;
    }

    /**
     * ͨ���ƥ��
     * @param methodName
     * @param mappedName
     * @return
     */
    protected boolean isMatch(String methodName, String mappedName) {
        return PatternMatchUtils.simpleMatch(mappedName, methodName);
    }

    /**
     * ָ��slave�ķ�����ǰ׺
     * @param slaveMethodStart
     */
    public void setSlaveMethodStart(String[] slaveMethodStart) {
        this.slaveMethodStart = slaveMethodStart;
    }

    public String[] getSlaveMethodStart() {
        if(this.slaveMethodStart == null || this.slaveMethodStart.length == 0){
            // û��ָ����ʹ��Ĭ��
            LOGGER.info("slaveMethodStart,δ����,ʹ��Ĭ�Ϸ������ƹ��� = {}",Arrays.toString(DEFAULT_SLAVE_METHOD_START));
            return DEFAULT_SLAVE_METHOD_START;
        }
        return slaveMethodStart;
    }
}

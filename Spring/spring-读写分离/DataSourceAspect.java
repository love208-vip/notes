import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
/**
 * DynamicDataSource AOP ����
 * */
public class DataSourceAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);
	/**
	 * ����,��ʶΪ���������ķ�������ͷ
	 * */
	private String[] readOnlyMethodNames = null;
	/**
     * �ڽ���Service����֮ǰִ��
     * */
    public void before(JoinPoint point) {
        // ��ȡ����ǰִ�еķ�����
        String methodName = point.getSignature().getName();
        LOGGER.debug("��д��������,ҵ��㷽��={}",methodName);
        if (isSlave(methodName)) {
            // ���Ϊ����
        	LOGGER.debug("��� == > ����");
            DynamicDataSourceHolder.markSlave();
        } else {
            // ���Ϊд��
        	LOGGER.debug("��� == > д��");
            DynamicDataSourceHolder.markMaster();
        }
    }

    /**
     * �ж��Ƿ�Ϊ����
     * */
    private Boolean isSlave(String methodName) {
    	if(StringUtils.isEmpty(methodName)){
    		return false;
    	}
    	for(String name : this.getMethodNames()){
    		if(methodName.startsWith(name)){
    			//ƥ������,����Ϊ�Ǽ�������
    			return true;
    		}
    	}
    	return false;
    }

	public String[] getMethodNames() {
		if(this.readOnlyMethodNames == null || this.readOnlyMethodNames.length == 0){
			//Ĭ��
			this.readOnlyMethodNames = new String[]{"query","get","find","load"};
		}
		return this.readOnlyMethodNames;
	}
	public void setMethodNames(String[] readOnlyMethNames) {
		this.readOnlyMethodNames = readOnlyMethNames;
	}
}

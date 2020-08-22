public class DynamicDataSourceHolder {

    //д���ʶ
    public static final String MASTER = "master";

    //�����ʶ
    private static final String SLAVE = "slave";

    //ʹ��ThreadLocal��¼��ǰ�̵߳�����Դ��ʶ
    private static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    /**
     * ��������Դ��ʶ
     **/
    private static void putDataSourceKey(String key) {
        HOLDER.set(key);
    }

    /**
     * ��ȡ����Դkey
     **/
    public static String getDataSourceKey() {
        return HOLDER.get();
    }

    /**
     * ���д��
     */
    public static void markMaster(){
        putDataSourceKey(MASTER);
    }

    /**
     * ��Ƕ���
     */
    public static void markSlave(){
        putDataSourceKey(SLAVE);
    }

    /**
     * �Ƿ�������
     * */
    public static boolean isMaster() {
        return  MASTER.equals(HOLDER.get());
    }
}

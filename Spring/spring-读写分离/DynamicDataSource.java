import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * ��̬����Դ��ʵ��ͨ������Spring�ṩ��AbstractRoutingDataSource(DataSourceʵ��),ֻ��Ҫʵ��determineCurrentLookupKey��������
 * ����DynamicDataSource�ǵ�����,�̲߳���ȫ�ģ����Բ���ThreadLocal��֤�̰߳�ȫ,��DynamicDataSourceHolder���
 * */
public class DynamicDataSource extends AbstractRoutingDataSource{
	/**
	 * �÷����ķ���ֵ,����Ϊһ��Map<String,DataSource>�е�key,ȥ��ȡ��Ӧ������Դ.
	 * ����,ÿ������.ֻҪ�ı����key,�Ϳ��Ըı䵵������,�ڳ־ò�Ự��ע�������Դ,ʵ���Զ��Ķ�д����
	 * */
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceHolder.getDataSourceKey();
	}
}


-------------------------------
����ģ�����					|
-------------------------------

public List<?> all(Class<?> clazz);
	* ���������еļ�¼

public List<?> all(Class<?> clazz,int start,int size);
	* ���������еļ�¼,����ҳ

public int allCount(Class<?> clazz);
	* ��ȡ��¼����

public List<T> template(T t);
	* ���ݷǿղ������������������ļ�¼
	* �ü�����ʽ,��������ʱ���,Ҳ����������

public List<T> template(T t,int start,int size);
	* ͬ��,����ҳ��

public T templateOne(T t) ;
	* ����ģ���ѯ������һ����������û���ҵ�������null

public long templateCount(T t) 
	* ��ȡ���������ĸ���



-------------------------------
����SQLID�����м���				|
-------------------------------
	public List select(String sqlId, Class clazz, Map paras) 
		* ����sqlid����ѯ�������Ǹ�map
	
	public List select(String sqlId, Class clazz, Map paras, int start, int size)
		* ͬ��,���ӷ�ҳ

	public List select(String sqlId, Class clazz, Object paras) 
		* ����sqlid����ѯ�������Ǹ�pojo
	
	public List select(String sqlId, Class clazz, Object paras, int start, int size) 
		* ͬ�����ӷ�ҳ

	public List select(String sqlId, Class clazz) 
		* ����sqlid����ѯ���޲���
	
	public T selectSingle(String id,Object paras, Class target) 
		* ����sqlid��ѯ��������Pojo������Ӧ��Ψһֵӳ���ָ����taget�������δ�ҵ����򷵻ؿա�
		* ��Ҫע���ʱ����ʱ�����������ǿգ���ʱ����ʹ��unique
	public T selectSingle(String id,Map paras, Class target) 
		* ����sqlid��ѯ��������Map������Ӧ��Ψһֵӳ���ָ����taget����
		* ���δ�ҵ����򷵻ؿա���Ҫע���ʱ����ʱ�����������ǿգ���ʱ����ʹ��unique

	public T selectUnique(String id,Object paras, Class target) 
		* ����sqlid��ѯ��������Pojo������Ӧ��Ψһֵӳ���ָ����taget����
		* ���δ�ҵ������׳��쳣
	public T selectUnique(String id,Map paras, Class target) 
		* ����sqlid��ѯ��������Map������Ӧ��Ψһֵӳ���ָ����taget����
		* ���δ�ҵ������׳��쳣

	public Integer intValue(String id,Object paras) 
		* ��ѯ���ӳ���Integer������Ҳ���������null��������object
	
	public Integer intValue(String id,Map paras) 
		* ��ѯ���ӳ���Integer������Ҳ���������null����
		* ����map���������� 'longValue'��'bigDecimalValue'
	
	public T unique(Class clazz,Object pk) 
		* ����������ѯ�����δ�ҵ����׳��쳣.

-------------------------------
��ҳ����API						|
-------------------------------
	public void pageQuery(String sqlId,Class clazz,PageQuery query)
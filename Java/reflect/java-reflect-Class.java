---------------------
java.reflect.Class	 |
---------------------

---------------------
ʵ������			 |
---------------------
	
	<A extends Annotation> AgetAnnotation(Class<A> annotationClass);
		* ��ȡָ�����͵�ע��,�������δ��ʶ,�򷵻�null
	
	Annotation[] getAnnotations();
		* ��ȡ�������ϱ�ʶ������ע��
	
	boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) 
		* ���ָ�����͵�ע�ʹ����ڴ�Ԫ���ϣ��򷵻� true�����򷵻� false�� 

	ClassLoader getClassLoader();
		* ��ȡ�������
	
	Constructor<T> getConstructor(Class<?>... parameterTypes) 
		* ����һ�� public ���ε� Constructor (������)���� ,�Ǹ��ݲ�������ȡ
	
	Constructor[] getConstructors() ;
		* ��ȡ���еĹ������췽������

	Field getField(String filedName);
		* ��ȡָ�����Ƶ��ֶζ���,������ public ���ε�,�����׳��쳣

	Field getDeclaredField(String filedName);
		* ��ȡָ�����Ƶ��ֶζ���,�������κ�Ȩ�����η����ε�
	
	Field[] getFields();
		* ���ظ������� public ���ε��ֶζ���

	Field[] stsgetDeclaredFields()
		* ���ظ������е��ֶζ���
	
	Method getMethod(String name, Class<?>... parameterTypes);
		* ���ݷ�������,�Լ�������������ȡһ����������
	
	Method[] c.getMethods();
		* ���ص������е� public  ����,�������Ӹ���̳е�

	T newInstance();
		* ʹ���޲ι���������һ���µĶ���
	
	boolean isInterface();
		* �ж��Ƿ��ǽӿ�

	boolean isEnum();
		* �ж��Ƿ���ö��
	
	boolean isArray();
		* �Ƿ�������

	Class<?>[] getInterfaces()
		* ��ȡ��ǰ��ʵ�ֵ����нӿ�
	
	InputStream getResourceAsStream(String name);
		* ��'/'��ͷʱĬ���ǴӴ������ڵİ���ȡ��Դ
		* ��'/'��ͷ���Ǵ�ClassPath���»�ȡ����ֻ��ͨ��path����һ������·�������ջ�����ClassLoader��ȡ��Դ�� 
	
	boolean isAssignableFrom(Class clazz);
		* �жϵ�ǰ Class,�Ƿ��� clazz �ĸ���,����ͬ��
		* ˵����,�����ж��Ƿ����ǿת
	
	T[] getEnumConstants()
		* ����� Class ���󲻱�ʾö�����ͣ��򷵻�ö�����Ԫ�ػ� null�� 
		* ������˳�򷵻�һ�����飬������������ɴ� Class ��������ʾ��ö�����ֵ�������ڴ� Class ���󲻱�ʾö������ʱ���� null


---------------------
��̬����			 |
---------------------
	Class forName(String className);
		* ����ָ�����ൽ�ڴ�,����ȡ��Class����
	
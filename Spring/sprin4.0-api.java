-----------------------
Index					|
-----------------------
	# IOC����
		ApplicationContext
			|-ConfigurableApplicationContext
				* ��չ��ApplicationContext,����������Ҫ�ķ���
				* ����Ƕ�����һ���ӿ�,ֻ�Ǹ�ǿ��.
				* refresh();	//��������ˢ��������
				* close();		//�ر�������
			|-ClassPathXmlApplicationContext
				* ����·���¼��������ļ�
				* ����ͬʱ���ض�������ļ�
				* new ClassPathXmlApplicationContext("beans1.xml","beans2.xml");
			|-FileSystemXmlApplicationContext
				* ���ļ�ϵͳ���������ļ�
			|-WebApplicationContext
				* ��ר��ΪWEBӦ�ö�׼����,������������WEB��Ŀ¼��·������ɳ�ʼ������
	
	# Bean�����������
		ApplicationContextAware
			# Bean�������ڽӿ�,ʵ�ָýӿڿ��Ի�ȡApplicationContext
		BeanNameAware
			# Bean�������ڽӿ�,��ѵ�ǰBean��Bean����ͨ�����󷽷�ע�����
		InitializingBean
			# Bean�������ڽӿ�,ʵ�ָýӿ�,��������ע����Ϻ���ó��󷽷�
		BeanPostProcessor
			# Bean�������ڽӿ�,ʵ�ָýӿ�,����Bean��ʼ����'ǰ��'���ö�Ӧ�ĳ��󷽷�
			|-Object postProcessBeforeInitialization(Object var1, String var2) throws BeansException;
			|-Object postProcessAfterInitialization(Object var1, String var2) throws BeansException;
		DisposableBean
			# Bean�������ڽӿ�,ʵ�ָýӿ�,����IOC�رյ�ʱ����ó��󷽷�
	
	# ��̬������
		Environment
			# ��������

		Resource
			# ��Դ������
			|-ClassPathResource

		ClassUtils
			# ����Class�Ĺ�����

		StringUtils
			# ����String�Ĺ�����

		ReflectionUtils
			#���乤����

		CollectionUtils
			# �������ϵĹ�����
	
-----------------------
ApplicationContextAware	|
-----------------------


-----------------------
Environment				|
-----------------------
	# org.springframework.core.env.Environment
	# �������κεط�ע��,�����е�ǰ������һЩ����,�������ⲿ�����ļ��ı���

	environment.getProperty("bbs.dbPassowrd");

---------------------
Resource			 |
---------------------
	# spring �Ķ���,��һ���ӿ�
	# org.springframework.core.io.Resource
	# ����
		ClassPathResource	 
			# classpath�µ���Դ������
				Resource resource = new ClassPathResource("/xxx.properties");
				Properties props = PropertiesLoaderUtils.loadProperties(resource);
				* �Ѽ��ص�����Դ,ӳ��� Properties

---------------------
ClassUtils			 |
---------------------
	

---------------------
StringUtils			 |
---------------------
	# ��̬����
	String trimAllWhitespace(String str);
		* ȥ���ַ����е����пո�
	
---------------------
ReflectionUtils		 |
---------------------
	# ��̬����
	Field ReflectionUtils.findField(Clazz class, String fieldName);
		* �����ȡ��ָ�� Class ��ָ���ֶ�,���Ի�ȡ��˽�е��ֶ�

---------------------
CollectionUtils		 |
---------------------
	

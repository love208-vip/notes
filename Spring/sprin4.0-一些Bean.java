BeanPostProcessor
	# ���ô�����,һ���ӿ�
	# ʵ�ַ���
		public Object postProcessAfterInitialization(Object obj, String str);
		public Object postProcessBeforeInitialization(Object obj, String str);
	# ��Bean�ĳ�ʼ������ִ�е�ǰ��,�����Bean���ݸ���Ӧ�ķ���,���ǿ����Լ�����һЩ����Ĵ���
	# ��һ����������Beanʵ��,�ڶ���������Bean��ID������name

ApplicationContextAware
	# һ���ӿ�
	# ʵ�ַ���
		public void setApplicationContext(ApplicationContext applicationContext)
	# ʵ�ָýӿں�,���ҽ���IOC�����.IOC����� setApplicationContext ������IOC����ע�����

InitializingBean
	# һ���ӿ�
	# ʵ�ַ���
		public abstract void afterPropertiesSet()throws Exception;
	# ��IOC�������Beanʵ��,��Bean��ʼ�����,���е����Զ�ע����Ϻ����ø÷���
	# �������ȼ��� init-method ����,��ִ����Ϻ�Ż�ִ�� init-method

DisposableBean
	# һ���ӿ�
	# ʵ�ַ���
		 void destroy() throws Exception;
	# ��IOC�������Beanʵ��,��IOC�������رյ�ʱ��,Ҳ�����������ٵ�ʱ��,����� destroy ����
	# �������ȼ��� destory-method ����,������ִ����Ϻ�Ż�ȥִ�� destory-method
	# ����Ҫ��֤����IOC���������� close ����,�Ż�ȥִ��
	# �������ٷ�����IOC����ִ�йر�,�йرչ��ܵ�����������ConfigurableApplicationContext.�� ApplictionContext��һ���ӽӿ�
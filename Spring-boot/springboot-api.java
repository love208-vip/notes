SpringApplication


WebMvcConfigurerAdapter
	# Webϵ�е�����
	# ע��,Spring Interceptor
		public void addInterceptors(InterceptorRegistryregistry);
	# ���,��̬��Դӳ��·��
		public void addResourceHandlers(ResourceHandlerRegistry registry);
	# ���� Converter ��Ϣת����
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters);
	# �����ͼӳ��
		public void addViewControllers(ViewControllerRegistry registry) 
	# ���corsӳ��
		public void addCorsMappings(CorsRegistry registry) { registry.addMapping("/api/*").allowedOrigins("*"); }

SpringBootServletInitializer
	# ������war��ʽ������Servlet������֧��
	# ��д����
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
			//ָ�� @SpringBootApplication ������
			return application.sources(Main.class);
		}

ServletContextInitializer
	# Servlet��ʼ��������Bean
	# ���Խ������ó�ʼ�� context-param 

EmbeddedServletContainerCustomizer
	# ͳһ�� Servlet ��������

EmbeddedServletContainerFactory
	# �����ر�������ĸ���
	# ����
		TomcatEmbeddedServletContainerFactory
		JettyEmbeddedServletContainerFactory



-------------------------------
Spring-boot						|
-------------------------------
	# Spring Boot ͨ��java config������ beetl
	# ��Ҫ�� BeetlGroupUtilConfiguration���� BeetlSpringViewResolver��
		* BeetlGroupUtilConfiguration����
		* BeetlSpringViewResolver��

	# spring boot������Ҫע�����Ҫ���spring-devtools.properties�ļ�,����������ѡ��
		restart.include.beetl=/beetl-xxx.jar
		restart.include.beetlsql=/beetlsql-xxx..jar
		* spring-devtools.properties Ϊspring boot�������ļ�,λ��META-INFĿ¼��

	# Ҳ������� beetl.properties ȥ���һЩ����
		* ��Ҫע�����,�����Ͳ�Ҫ�� beetl.properties ȥ���� RESOURCE.root=/templates/ ����,Ҳ��Ҫ����

-------------------------------
Spring-boot		�ٷ�			|
-------------------------------
	1,������
		@Configuration
		public class BeetlConfiguration {

			/**
			 * ģ���Ŀ¼
			 */
			@Value("${beetl.templatesPath}")
			private String templatesPath;

			@Bean(initMethod = "init", name = "beetlConfig")
			public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
				BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
				//��ȡSpring Boot ��ClassLoader
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				if(classLoader == null){
					classLoader = BeetlConfiguration.class.getClassLoader();
				}
				//beetlGroupUtilConfiguration.setConfigProperties(extProperties);
				ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader(classLoader, templatesPath);
				beetlGroupUtilConfiguration.setResourceLoader(classpathResourceLoader);
				beetlGroupUtilConfiguration.init();
				//���ʹ�����Ż����������漰���ֽ����������Ҫ���ClassLoader
				beetlGroupUtilConfiguration.getGroupTemplate().setClassLoader(classLoader);
				return beetlGroupUtilConfiguration;
			}

			@Bean(name = "beetlViewResolver")
			public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
				BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
				beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
				beetlSpringViewResolver.setOrder(0);
				//beetlSpringViewResolver.setPrefix("/");
				beetlSpringViewResolver.setSuffix(".html");
				beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
				return beetlSpringViewResolver;
			}
		}
	
	2,����
		beetl.templatesPath=templates
	
	3,Controller
		return new ModelAndView("/index/index");
	
	4,include
		include('/common/common_header.html',{}){}

-------------------------------
Spring-boot		�ҵ�			|
-------------------------------
	1,������
		/**
		 * Created by KevinBlandy on 2017/3/2 11:24
		 */
		@Configuration
		public class BeetlConfiguration {
			
			/**
			 * ģ���Ŀ¼ 
			 */
			@Value("${beetl.templatesPath}") 
			private String templatesPath;		
			
			@Bean(initMethod = "init", name = "beetlConfig")
			public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
				BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
				try {
					//ʹ�� ClasspathResourceLoader
					System.err.println(templatesPath);
					ClasspathResourceLoader cploder = new ClasspathResourceLoader(BeetlConfiguration.class.getClassLoader(),templatesPath);
					beetlGroupUtilConfiguration.setResourceLoader(cploder);
					return beetlGroupUtilConfiguration;
				} catch (Exception e) {
						throw new RuntimeException(e);
				}

			}
			@Bean(name = "beetlViewResolver")
			public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
					BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
					beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
					beetlSpringViewResolver.setOrder(0);
					//beetlSpringViewResolver.setPrefix("/");
					beetlSpringViewResolver.setSuffix(".html");
					beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
					return beetlSpringViewResolver;
			}
		}
	
	2,����
		beetl.templatesPath=classpath:/templates/
	
	3,Controller
		return new ModelAndView("index/index");
	
-------------------------------
Spring-boot-starter		ע��	|
-------------------------------
	<dependency>
		<groupId>com.ibeetl</groupId>
		<artifactId>beetl-framework-starter</artifactId>
		<version>1.1.16.RELEASE</version>
	</dependency>

	* starter				�Զ�������btl��β����ͼ,ģ���Ŀ¼��Spring BootĬ�ϵ�templatesĿ¼,�������ÿ����޸�beetl��������
	* beetl-beetlsql.dev	Ĭ��Ϊtrue,���Զ����ģ��仯
	* beetl.suffix			Ĭ��Ϊbtl,��btl��β����ͼ����Beetl������Ⱦ

	|-templates
		|-index
			|-index.btl

	ModelAndView m = new ModelAndView("/index/index.btl");


-------------------------------
Spring-boot		ע��			|
-------------------------------
	# Spring boot ��warģʽ��ģ���ļ��޷����ص�����
		* application.properties
			beetl.templatesPath=templates/

		* controller
			ModelAndView INDEX = new ModelAndView("index/index");
		
		* template
			@ include('/common/common_header.html'){}
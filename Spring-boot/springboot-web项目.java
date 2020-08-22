--------------------------------
Spring-boot WEB��Ŀ				|
--------------------------------
	# Spring boot ��WEB�Ŀ����ṩ��֧��
	# spring-boot-starter-web,�ṩ��Ƕ��ʽ��Tomcat��Springmvc������
	# Web��ص��Զ�������:spring-boot-autoconfigure.jar �� org.springframework.boot.autoconfigure.web ��
		ServerPropertiesAutoConfiguration �� ServerProperties
			* �Զ�������ǶServlet����
		
		HttpEncodingAutoConfiguration �� HttpEncodingProperties
			* �Զ�����http�ı���
		
		MultipartAutoConfiguration �� MultipartProperties
			* �Զ������ϴ��ļ�������

		JacksonHttpMessageConvertersConfiguration 
			* ����,mappingJackson2HttpMessageConverter �� mappingJackson2XmlHttpMessageConverter
		
		WebMvcAutoConfiguration �� WebMvcProperties
			* ����spring mvc


--------------------------------
Spring-boot ������				|
--------------------------------
	# spring boot������Ĭ���� 
		HandlerInterceptorAdapter
		AbstractHandlerMapping
		UserRoleAuthorizationInterceptor
		LocaleChangeInterceptor
		ThemeChangeInterceptor


	2.����spring mvc�������� WebMvcConfigurerAdapter 
		* �Զ�����̳� WebMvcConfigurerAdapter 
			* ������Ϊ������,Ӧ����� :@Configuration ע��
			* Ҳ����ֱ���� @SpringBootApplication ȥʵ��
		
		* ��д addInterceptors ����,���������������

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				// ������������һ����������
				// addPathPatterns ����������ع���
				// excludePathPatterns �û��ų�����
				registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**").excludePathPatterns("/test/**");
				registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**").excludePathPatterns("/test/**");
				super.addInterceptors(registry);
			}

--------------------------------
Spring-boot ��̬��Դ			|
--------------------------------
	# �Զ��������: addResourceHandlers �����ж��������¾�̬��Դ���Զ�����
	# ��·���ļ�
		* /static 
		* /public
		* /resources
		* /META-INF/resources
	# �����ļ����еľ�̬�ļ�,ֱ�ӿ���ӳ��Ϊ��̬�ļ���Ŀ¼,�����з���
	
	# webjar,�ľ�̬��Դӳ��
		* webjar,����jar����jar.
		* /META-INF/resources/webjars/ �µľ�̬�ļ�ӳ��Ϊ: /web/jar/**						*/

	# ��̬��Դ����ʧ��

		* �������һ
			* �Զ���������,ʵ�� WebMvcConfigurerAdapter ,��д����
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
				super.addResourceHandlers(registry);
			}
			* �÷��������Է����ⲿ�ļ�(ʹ��"file:"��ͷ))
				registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ TaleUtils.getUplodFilePath()+"upload/");

		* ���������
			* ��application.properties �������
				spring.mvc.static-path-pattern=/static/**								*/
				*  'ע��,���治���пո�,������ȫ��Ϊ�˴���� /** Java��ע�ͳ�ͻ'

--------------------------------
Spring-boot ��ͼӳ��			|
--------------------------------
	# �Զ���������,ʵ�� WebMvcConfigurerAdapter
	# ��д����
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/demo.html").setViewName("/demo.jsp");
		}

--------------------------------
Spring-boot View				|
--------------------------------
	# Jsp����Ƕ��Servlet����������Ҳ����һЩ����(�ٷ�������)
	# ���Խ�����������ģ������������
	# ���� ��ͼ�㼼�������бʼǽ�


--------------------------------
Spring-boot ���context-param	|
--------------------------------
	# ע�� ServletContextInitializer
	1,ȫ�ֵ�context-param
		@Bean
		public ServletContextInitializer initializer() {
			return new ServletContextInitializer() {
				public void onStartup(ServletContext servletContext) throws ServletException {
					servletContext.setInitParameter("ClassLoaderLeakPreventor.threadWaitMs", "1000");
				}
			};
		}

--------------------------------
Spring-boot ����֧��			|
--------------------------------
	@Configuration  
	public class CorsConfig extends WebMvcConfigurerAdapter {  
		@Override  
		public void addCorsMappings(CorsRegistry registry) {  
			registry.addMapping("/**")  
					.allowedOrigins("*")  
					.allowCredentials(true)  
					.allowedMethods("GET", "POST", "DELETE", "PUT")  
					.maxAge(3600);  
		}  
	}  

--------------------------------
Spring-boot ע��WEB�������		|
--------------------------------
	# ��ʹ��Ƕ��ʽ��Servlet����,��Ҫʹ�����������ʱ��,�����ַ�ʽ

	# ��Servlet,Filter,Listenner ����ΪSpring Bean ���ﵽע���Ч��
		@Bean
		public XxxServlet xxxServlet(){
			return new XxxServlet();
		}
		@Bean
		public XxxFilter xxxFilter(){
			return new XxxFilter();
		}
		@Bean
		public XxxListenner xxxListennr(){
			return new XxxListenner();
		}

	# ע���Ӧ�� RegistrationBean
		* ���ǿ��Խ���'����'���õȲ���
		* ServletRegistrationBean
		* FilterRegistrationBean
		* ServletListenerRegistrationBean
		
		@Configuration
		public class ServletConfig {
			/**
			 * ע��Servlet
			 * @return
			 */
			@Bean
			public ServletRegistrationBean myServlet(){
				return new ServletRegistrationBean(new TestServlet(),"/test/test");
			}
			
			/**
			 * ע��Filter
			 * @return
			 */
			@Bean
			public FilterRegistrationBean myFilter(){
				FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
				filterRegistrationBean.setFilter(new TestFileter());
				filterRegistrationBean.setOrder(2);
				return filterRegistrationBean;
			}
			
			/**
			 * ע��Listnner
			 * @return
			 */
			@Bean
			public ServletListenerRegistrationBean<MyListenner> myListenner(){
				return new ServletListenerRegistrationBean(new MyListenner());
			}
		}
	
	# ʹ��servlet3.0��ע��
		@ServletComponentScan
			# �� SpringBootApplication ��ʹ��@ServletComponentScan 
			# Servlet��Filter��Listener ����ֱ��ͨ�� @WebServlet��@WebFilter��@WebListener ע���Զ�ע�ᣬ�����������롣
------------------------
JSONP					|
------------------------
	# ����˵,��д Converter ���
	# Ԥ����JSONPʵ��
		AbstractJsonpResponseBodyAdvice
		 <bean class="org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice">
			<constructor-arg>
				<list>
					<value>callback</value>
					<value>jsonp</value>
				</list>
			</constructor-arg>
		</bean>
	
	# FastjsonҲ�ж�Ӧ��ʵ��
		FastJsonpResponseBodyAdvice

	# Spring4.1��JSON�����֧��
		* MappingJackson2JsonView�ṩ��֧�� 

		<bean class="org.springframework.web.servlet.view.json.MappingJackson2JsonView">  
			<property name="jsonpParameterNames">  
				<set>  
					<value>jsonp</value>  
					<value>callback</value>  
				</set>  
		   </property>  
		</bean>  
 
	* ��ʹ��HttpMessageConverter��@ResponseBody��֧�� 
		@Order(2)  
		@ControllerAdvice(basePackages = "com.github")  
		public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {  
			public JsonpAdvice() {  
				super("callback", "jsonp"); //ָ��jsonpParameterNames  
			}  
		}  

------------------------
CORSЭ��				|
------------------------
	# HTML5���¶���
	# ������˻��� ajax,һ����,�����������ǿ���,��������Զ����һЩ���������ͷ
	# �����һ������AJAX�����Դ���ͻ��Զ����һЩ���ӵ�ͷ��Ϣ����ʱ������һ�θ��ӵ����󣬵��û������ио���
	# ��ˣ�ʵ��CORSͨ�ŵĹؼ��Ƿ�������ֻҪ������ʵ����CORS�ӿڣ��Ϳ��Կ�Դͨ�š�
	# �����Ƿ���˵�����
	# HTTP ����ͷ
		
	# HTTP ��Ӧͷ

	
	
	# �����ʱ��,��CookieҲ���͸������
		* �ͻ�������(XMLHttpRequest)
		xhr.withCredentials = true;
		* �������Ӧ
			header("Access-Control-Allow-Credentials: true");
			* ����������˵���Ӧ�У����û�з��� Access-Control-Allow-Credentials: true ����Ӧͷ����ô��������������Ӧ������ݸ���������Ľű������Ա�֤��Ϣ�İ�ȫ��

------------------------
ע������				|
------------------------
	# Spring ����
		* ��Ҫ4.2.x���ϵİ汾��֧��
		* @CrossOrigin
			@AliasFor("origins")
			String[] value() default {};
				* ������Щ����������������ǰ��Դ,����ʹ��ͨ���

			@AliasFor("value")
			String[] origins() default {};
				* ������Щ����������������ǰ��Դ,����ʹ��ͨ���

			String[] allowedHeaders() default {};
				* ����ͻ�������Я��������ͷ
				* 
			String[] exposedHeaders() default {};
				* ����ͻ��˷��ʵ���Ӧͷ,��ָ��,��ֻ�ܷ���Ĭ�ϵ�6��
				* Cache-Control,Content-Language,Content-Type,Expires,Last-Modified,Pragma

			RequestMethod[] methods() default {};
				* ��������ķ���

			String allowCredentials() default "";
				* ��Ҫ��Cookieֵ

			long maxAge() default -1;

		1,�� @Controller/@RequestMapping �����ע��,����ʶ֧�ֿ���
			@CrossOrigin(origins = "http://kbiao.me")



------------------------
��������				|
------------------------
	# ��������1
		import org.springframework.context.annotation.Bean;
		import org.springframework.context.annotation.Configuration;
		import org.springframework.web.cors.CorsConfiguration;
		import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
		import org.springframework.web.filter.CorsFilter;

		@Configuration
		public class CorsConfig {

			private CorsConfiguration buildConfig() {
				CorsConfiguration corsConfiguration = new CorsConfiguration();
				corsConfiguration.addAllowedOrigin("*"); // 1
				corsConfiguration.addAllowedHeader("*"); // 2
				corsConfiguration.addAllowedMethod("*"); // 3
				return corsConfiguration;
			}

			@Bean
			public CorsFilter corsFilter() {
				UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
				source.registerCorsConfiguration("/**", buildConfig()); // 4
				return new CorsFilter(source);
			}
		}
	
	#��������2 
		* SpringBoot���������
		public class CorsConfigurerAdapter extends WebMvcConfigurerAdapter{ 
			@Override public void addCorsMappings(CorsRegistry registry) { 
				registry.addMapping("/api/*").allowedOrigins("*"); 
			} 
		}

	# xml����
		<bean id="corsConfiguration" class="org.springframework.web.cors.CorsConfiguration">
			<property name="allowCredentials" value=""/>
			<property name="allowedHeaders" value=""/>
			<property name="allowedMethods" value=""/>
			<property name="allowedOrigins" value=""/>
			<property name="exposedHeaders" value=""/>
			<property name="maxAge" value=""/>
		</bean>
		<bean id="corsFilter" class="org.springframework.web.filter.CorsFilter">
			<constructor-arg index="0">
				<bean class="org.springframework.web.cors.UrlBasedCorsConfigurationSource">
					<property name="corsConfigurations">
						<map key-type="java.lang.String" value-type="org.springframework.web.cors.CorsConfiguration">
							<!-- һ�� key (url), ��Ӧһ�� corsConfiguration (��������)-->
							<entry key="/**" value-ref="corsConfiguration"/>
						</map>
					</property>
				</bean>
			</constructor-arg>
		</bean>



------------------------
�ٷ�mvc��ǩ����			|
------------------------
	* ��ҪschemaLocation��4.3����
	<mvc:cors>
		<mvc:mapping path="/api/**"
			allowed-origins="http://domain1.com, http://domain2.com"
			allowed-methods="GET, PUT"
			allowed-headers="header1, header2, header3"
			exposed-headers="header1, header2" allow-credentials="false"
			max-age="123" />

		<mvc:mapping path="/resources/**"
			allowed-origins="http://domain1.com" />
	</mvc:cors>


------------------------
ԭ��Servlet				|
------------------------
    public static void setCorsHeader(HttpServletRequest request,HttpServletResponse response) {
    	String origin = request.getHeader("Origin");
    	if (origin == null) {
    		origin = "*";
    	}
    	response.addHeader("Access-Control-Allow-Origin", origin);
    	response.addHeader("Access-Control-Allow-Headers", "Origin, x-requested-with, Content-Type, Accept,Authorization");
    	response.addHeader("Access-Control-Allow-Credentials", "true");
    	response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,DELETE");
    	/**
    	 * ����ͻ��˻�ȡ��������Ӧͷ,��Ȼ,����ֻ�ܷ���6���̶���:Cache-Control,Content-Language,Content-Type,Expires,Last-Modified,Pragma
    	 */
    	//response.addHeader("Access-Control-Expose-Headers", "");	
    }


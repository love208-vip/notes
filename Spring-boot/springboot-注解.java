----------------------------
Spring-Boot ע��			|
----------------------------
	@EnableAutoConfiguration
		# ����
			Class<?>[] exclude() default {};
			String[] excludeName() default {};

		# �� spring boot ������·���е� jar ������,Ϊ��ǰ��Ŀ�����Զ�����
		# ����
			* ����� spring-boot-starter-web ����,�ͻ��Զ����Tomcat��springmvc�����Զ�������
			* ����� spring-boot-statter-data-jpa ����,�ͻ��Զ�����JPA��ص�����
	
	@Configuration (spring)
		# ��@Configurationע���ʶ���࣬ͨ����Ϊһ�������࣬���������һ��xml�ļ�����ʾ�ڸ����н�����BeanԪ���ݣ�
		# ������������Spring����application-context.xml�������ļ����� @Bean ��ǩ���������ڸ�xml�ļ��У�������һ��beanʵ���� 
	
	@SpringBootApplication
		# ��������
			Class<?>[] exclude() default {};
				* �������е� Class ����,�ᱻ�ر��Զ�����

		# ����һ�����ע��,�����һ�µ�ע��
			* @SpringBootConfiguration		
				* �յ�ע��,��ע���ϱ�ʶ��:@Configuration
			* @EnableAutoConfiguration 
			* @ComponentScan (��ɨ��·��)
		# spring boot �����Զ�ɨ���ע���ʶ�����ڰ�,ͬ����,�Լ��Ӱ���Bean
			* �����JPA��Ŀ,������ɨ���ע@Entity��ʵ����
		# �����������õ�λ���� grouId + arctifactId ��ϵİ�����
	

	@ConfigurationProperties
		# ����
			prefix
				* ָ��properties������ͳһ��ǰ׺
			ignoreUnknownFields 
				* �Ƿ����δƥ�䵽������

		# ��ע���ʶ��ĳ��bean,���ڰ��ⲿ�����ļ��е�����,ע�뵽bean��������
		# �����Ա�ע�� @Configuration ���е�ĳ��������,�÷���(�÷���ͬʱҲҪ��ע@Beanע��Żᱻspring����)���ض��������ֵҲ�����ɸ�ע��ע��(prefix����ָ��ǰ׺)
	

	@EnableConfigurationProperties
		# ����
			Class<?>[] value() default {};
		# ��һ�� �� @ConfigurationProperties ��ʶ����,���뵽IOC����
	
			
	@ServletComponentScan
		# �� SpringBootApplication ��ʹ��@ServletComponentScan
		# ע���Servlet��Filter��Listener ����ֱ��ͨ�� @WebServlet��@WebFilter��@WebListener ע���Զ�ע�ᣬ�����������롣
	



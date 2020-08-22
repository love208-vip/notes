--------------------------
Springboot-ԭ��				|
--------------------------


--------------------------
Springboot-�Զ�����ԭ��		|
--------------------------
	# ����spring-boot�Զ����õ�Դ�붼��:spring-boot-autoconfigure-1.5.1.RELEASE.jar ��
	# ����뿴��spring-boot�Զ�Ϊ����������Щ����,������������ʱ����Ӳ���,Ҳ������ȫ�������ļ�����Ӳ���
		java -jar xxx.jar --debug
		debug=true
		* Positive matches: ����Ϊ���õ��Զ�����
		* Negative matches:	����Ϊδ���õ��Զ�����
		
	0,@SpringBootApplication ע��	EnableAutoConfigurationImportSelector
	1,@EnableAutoConfiguration ע��
	2,@Import(EnableAutoConfigurationImportSelector.class) ע��
	3,EnableAutoConfigurationImportSelector ��
		# ʹ�� SpringFactoriesLoader.loadFactoryNames(Class<?> factoryClass, ClassLoader classLoader);������ɨ����� META-INF/spring.factories ��jar��
			* public static List<String> loadFactoryNames(Class<?> factoryClass, ClassLoader classLoader)
			* spring-boot-autoconfigure-1.5.1.RELEASE.jar �о��� META-INF/spring.factories
		# META-INF/spring.factories ����������һЩ�Զ�������

	
	4,����һ�� XxxxAutoConfiguration ��,һ�㶼��������ע��,�� org.springframework.boot.autoconfigure.condition ����
		@ConditionalOnBean
			* ��������ָ����bean��������
		@ConditionalOnClass
			* ������·������ָ�����������
		@ConditionalOnCloudPlatform
		@ConditionalOnExpression
			* ����SpEL���ʽ��Ϊ�ж�����
		@ConditionalOnJava
			* ����JVM�汾��Ϊ�ж�����
		@ConditionalOnJndi
			* ��JNDI���ڵ������²���ָ����λ��
		@ConditionalOnMissingBean
			* ����������û��ָ��Bean�������
		@ConditionalOnMissingClass
			* ����·����û��ָ������������
		@ConditionalOnNotWebApplication
			* ��ǰ��Ŀ����Web��Ŀ��������
		@ConditionalOnProperty
			* ָ���������Ƿ���ָ����ֵ
		@ConditionalOnResource
			* ��·���Ƿ���ָ����ֵ
		@ConditionalOnSingleCandidate
			* ��ָ���� Bean ��������ֻ��һ��,������Ȼ�ж��,����ָ����ѡ��Bean
		@ConditionalOnWebApplication
			* ��ǰ��Ŀ��WEB��Ŀ��������

		* ���ע�ⶼ������� @Conditional(spring) Ԫע��,ֻ��ʹ���˲�ͬ������
	
--------------------------
Springboot-�Զ���AutoConfiguration |
--------------------------
	1,׼������Bean,���Ҷ�ȡproperties�ļ�
		* һ�㶼����: xxxProperties ����
		* ����ǵ����������ģ��(maven),������Ҫ����spring boot�� autoconfigure ģ��:

			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-autoconfigure</artifactId>
				<version>XXXXX</version>
				<scope>compile</scope>
			</dependency>

	2,���� XxxxAutoConfiguration ��,��ͨ�������һЩע��������Ƿ�Ҫע��һЩ���
		* ��ʶ������һ�������� @Configuration
		* �� ������ xxxProperties ���뵽IOC EnableConfigurationProperties(xxxProperties.class) ,�Ϳ�����ҳ���� @Autowired ע��ʹ��
		* ĳ��ע�� @Bean �ķ�����ȥʹ��ע������ж�(�������һ���˾���)
		* �ѷ��ص�Beanע�뵽IOC
			
		
	3,�� src/main/resource Ŀ¼�´����ļ��к��ļ�
		META-INF/spring.factories


		org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
		com...xxxx,\
		com...x...,\
		
		* ����Զ��ŷָ�
	

		
		
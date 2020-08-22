

����У��
	@InitBinder 
	* ����ע���ʶ�ķ���,���Զ�WebDataBinder������г�ʼ��
	* WebDataBinder��DataBinder������,��������ɱ��ֶε�JavaBean���Եİ�
	* �÷��������з���ֵ,'������void'
	* InitBinder�����Ĳ���ͨ����WebDataBinder
		@InitBinder
		public void inteBinder(WebDataBinder binder)
		{
			
		}

	* ���Խ������ݵ�'����ת��,��ʽ��,У��'.
	* WebDataBinder ���ַ���
		setDisallowedFields("name");	//ָ����������POJO���ĸ�����,������ֵ.��������������Ժ�,��ô�������β��е�User��name�ֶ�.���ᱻ��ֵ.�����ǿͻ����ύ��name����
	

	////////////////////////////


SpringMVCУ������
	* ע��У��
	* ������Ϣ
	* ������Ϣת��

	JSR 303
		* JSR 303 ��JavaBean,���ݺϷ���У��ı�׼���.�Ѿ�������JAVAEE6.0��
		* JSR 303 ͨ����javaBean�����ϱ�ע������ @NotNull,@Max �ȱ�׼��ע��ָ��У�����.��ͨ����׼����֤�ӿڶ�Bean������֤
		* 'ע�ⶼ����һ��:message����,��У��ʧ�ܵ�ʱ��.����ͨ�� getDefaultMessage ��ȡ�������ʾ��Ϣ'
	
		@Null				����Ϊnull
		@NotNull			����Ϊnull
		@AssertTrue			����Ϊtrue
		@AssertFalse		����Ϊfalse
		@Min(value)			������һ������,�ұ�����ڵ���value
		@Max(value)			������һ������,�ұ���С�ڵ���value
		@DecimalMin(value)	..
		@DecimalMax(value)	..
		@Size(max,min)		������һ������,����ֵ��max��min֮��
		@Digits(integer,fraction)..
		@Past				������һ����ȥ������,ֻ�ܱ�������
		@Future				������һ��δ��������,ֻ�ܱ�������
		@Pattern(value)		����... ...

		@Length(min=6,max=20)		//�ַ�������.��С6λ,���20λ.message��ʾ��ʾ��Ϣ

	HibernateValidator ��JSR303 ��һ���ο�ʵ��,����֧�����б�׼��У��ע����,��֧��һЩ��������չע��
		@Email				������һ��������ʽ
		@Length				�ַ������ȱ�����ָ���ķ�Χ��
		@NotEmpty			��ע�͵��ַ�������ǿ�
		@Range				��ע�͵��ַ��������ں��ʵķ�Χ��

	1,SpringMVC��<mvc:annotation-driven />,��Ĭ�ϵ�װ���һ��'LocalValidatorFactoryBean',
	  ��ע @Vliad ע��,�Ϳ�����SpringMVC ��������ݰ󶨺�ִ������У�鹤��.
	
	2,���Ѿ���ע��JSR303ע��ı�/��������ǰ,��עһ�� @Vliad,��ܾͻ������������ǰ,����ע��.������У��
	3,�����:ͨ��,�Դ�����ǩ���Ĺ�Լ������У����.
		* ǰһ����/��������У�������浽�����β���,�������У�������βα�����'BindingResult'��'Errors'����.�����඼��:org...validation����
	

	У�鲽��
		1,�������ļ���,���<mvc:annotation-driven />����!
		2,����Hibernate validator��֤���,���jar��
		3,��javaBean�����������ע��
		4,��Ŀ�귽��javaBeand���͵�ǰ����� @Valid ע��
			public void demo(@Valid User user BindingResult result)
			{}
			* У�������Ϣ,�ͻ����reulst
			* ���밤��,�м䲻����������Ԫ��
		
		* ��ô�ж��Ƿ��д���?
			if(result.hasErrors())
			{
				List<ObjectError> errors = result.getAllErrors();
				for (ObjectError e : errors )
				{
					System.out.println(e.getDefaultMessage());
				}
			}
		* ��ô��JSPҳ����ʾ
			model.addAttribute("errors",errors);	//����request��
			<form:errors path="userName"/>
		* ������Ϣ���ʻ�

		����ȥ���,̫������!����Щ����.�����Լ�дУ����붼д������!
		
=========================

	<!-- ע������ -->
	<mvc:annotation-driven validator="validate"/>
	<!-- У���� -->
	<bean id="validate" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean">
		<!-- JSP303У����,Hibernate -->
		<property name="providerClass"/>
		<!-- ������Ϣ��Դ�ļ�,��ָ����Ĭ�ϼ���classpath:ValidationMessages.properties -->
		<property name="validationMessageSource" ref="messageSource"/>
	</bean>
	<!-- ������Ϣ��Դ�ļ� -->
	<bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
		<!-- ��Դ�ļ��� -->
		<property name="basename">
			<list>
				<value>classpath:ValidationErrorMessage</value>
			</list>
		</property>
		<!-- ��Դ�ļ������ʽ -->
		<property name="fileEncodings" value="utf-8"/>
		<!-- ����Դ�ļ����ݻ���ʱ��,��λΪ�� -->
		<property name="cacheSeconds" value="120"/>
	</bean>
	
	��POJO�����У�����
	

	����У��
		* ÿ��Controller����ʹ�ò�ͬ��У�����
	������У�����(����һ��JAVA�ӿ�),����Ҫ�����κη���,�����ǶԲ�ͬ��У�������з���

	public interface ValidGroupA
	{
		//����У���ֶγ���
	}
	public interface ValidGroupB
	{
		//����У���ַ��ǿ�
	}

	��POJO��У��ע����һ������:group={ValidGroupA.class}	//��ע���У�������ĸ�����?���Զ���������
	��Controller������ָ������У��
	@Validated(value={ValidGroupA.class})User user
	//ָ��ʹ����������У��




----------------------------------У��ʵս
	1,������ص�����
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>5.2.4.Final</version>
		</dependency>
	
	
	2,
		��ʵ��bean�����ע��


1,��һ�ַ�ʽ,��д���
	<context:property-placeholder location="classpath:jdbc.properties"/>
	<context:property-placeholder location="classpath:upload.properties"/>
	
	# �����ļ��г����˶��<context:property-placeholder/>
		���ж�Ҫ����ignore-unresolvable="true"��һ������Ҳ�ǲ��е�

2,�ڶ��ִ�ͳ��ʽ
<!-- ʹ��spring�Դ���ռλ���滻���� ,¥���Ǽ�д-->
	<bean
		class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<!-- ������JVM���� -->
		<property name="systemPropertiesModeName" value="SYSTEM_PROPERTIES_MODE_OVERRIDE"/>	
		<!-- ����δ�ҵ����ļ�,����˵����ļ�������,���ᱨ�� -->
		<property name="ignoreResourceNotFound" value="true" />									
		<property name="locations">
			<list>
				<value>classpath:jdbc.properties</value>
				<value>classpath:upload.properties</value>
			</list>
		</property>
	</bean>
		
	

	�������ǿ�����xml��ʹ��'${...}'��bean�����Խ���עֵ(jdbc)

	��JAVA�����п���ʹ��ע��ֱ�ӽ���ע��ֵ
		* ʹ�� @Value ע��
		* value���Ե�ֵ,���������ļ��е�'${key}',

			@Value(value="${userName}")
			private String userName;		

			@Value(value="${passWord}")
			private String passWord;		
		
		* @Value���
			
			1,ʲôʱ��ע����Ӧ��ֵ
				> ��spring����������bean��ɳ�ʼ����ִ��

			2,�и��ǳ�����ĵط�
				> 'ֻ���ڵ�ǰspring�����в������ò���'
				> ɶ��˼��
					* ��� @Value ע���ʶ����,��ע�ᵽ���ĸ�IOC����?
					  ����,�ͻ������IOC�����е����ص�properties�ļ�,��������ֵ
					  ����IOC���ص�.properties�ļ�,һ�ɲ���
			3,���Ĭ��ֵ
				@Value( "${jdbc.url:aDefaultUrl}" )
			

----------------------------
ActiveMQ-xml����			|
----------------------------
	<!-- ���ӹ��� -->
	<bean id="connectionFactory" class="org.apache.activemq.ActiveMQConnectionFactory">
		<!-- borker��ַ -->
		<property name="brokerURL" value="tcp://123.207.122.145:61616"/>
	</bean>
	
	<!-- JMS ���� -->
	<bean id="jmsFactory" class="org.apache.activemq.pool.PooledConnectionFactory" destroy-method="stop">
		<!-- ע�����ӹ��� -->
		<property name="connectionFactory" ref="connectionFactory"/>	
		<!-- ��������� -->
		<property name="maxConnections" value="100"/>
	</bean>
	
	<!-- JMSTemplate -->
	<bean id="jmsTemplate" class="org.springframework.jms.core.JmsTemplate">
		<!-- ע�� JMS ���� -->
		<property name="connectionFactory" ref="jmsFactory"/>
		<!-- ע��Ĭ�϶���/���� -->
		<property name="defaultDestination" ref="topic"/>
		<!-- ע����Ϣת���� -->
		<property name="messageConverter">
			<bean class="org.springframework.jms.support.converter.SimpleMessageConverter"></bean>
		</property>
	</bean>
	
	<!-- topic -->
	<bean id="topic" class="org.apache.activemq.command.ActiveMQTopic">
		<!-- ����ע�뻰���� -->
		<constructor-arg index="0" value="spring-topic"/>
	</bean>
	
	<!-- jms Container -->
	<bean id="jmsContainer" class="org.springframework.jms.listener.DefaultMessageListenerContainer">
		<!-- ע�����ӹ��� -->
		<property name="connectionFactory" ref="jmsFactory"/>
		<!-- ע��topic -->
		<property name="destination" ref="topic"/>
		<!-- ע����� -->
		<property name="messageListener" ref="messageListener"/>
	</bean>
	
	<!-- listener���� -->
	<bean id="messageListener" class="com.kevin.demo.activemq.spring.listener.Listenner"></bean>


----------------------------
ActiveMQ-Provider			|
----------------------------
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
		try{
			//��ȡtmplateģ��
			JmsTemplate jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate");
			//����send����ִ�з���
			jmsTemplate.send(new MessageCreator() {
				//�����ڲ���
				public Message createMessage(Session session) throws JMSException {
					//�����ı���Ϣ,�����ûỰ����,Ҳ�����Լ�newʵ��
					TextMessage message = session.createTextMessage();
					message.setText("Hello,Spring");
					return message;
				}
			});
		}finally{
			if(applicationContext != null){
				applicationContext.close();
			}
		}
	}


----------------------------
ActiveMQ-Consumer			|
----------------------------
	public static void main(String[] args) {
		/**
		 * ֱ������������OK,�����ļ��Ѿ�ָ������Ϣ�¼�����
		 * */
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
//		try{
//			//��ȡtmplateģ��
//			JmsTemplate jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate");
//		}finally{
//			if(applicationContext != null){
//				applicationContext.close();
//			}
//		}
	}
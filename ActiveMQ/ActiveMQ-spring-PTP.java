----------------------------
ActiveMQ-����Spring���		|
----------------------------
	# ��Ҫ������
		<dependency>
	    	<groupId>org.apache.activemq</groupId>
		    <artifactId>activemq-all</artifactId>
		    <version>5.14.1</version>
		</dependency>

		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-jms</artifactId>
		    <version>4.3.3.RELEASE</version>
		</dependency>

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
		<!-- ע��Ĭ�϶��� -->
		<property name="defaultDestination" ref="destination"/>
		<!-- ע����Ϣת���� -->
		<property name="messageConverter">
			<bean class="org.springframework.jms.support.converter.SimpleMessageConverter"></bean>
		</property>
	</bean>
	
	<!-- Queue -->
	<bean id="destination" class="org.apache.activemq.command.ActiveMQQueue">
		<!-- ����ע��������� -->
		<constructor-arg index="0" value="spring-queue"/>	
	</bean>


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
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
		try{
			//��ȡtmplateģ��
			JmsTemplate jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate");
			while(true){
				String message = (String) jmsTemplate.receiveAndConvert();
				System.err.println(message);
			}
		}finally{
			if(applicationContext != null){
				applicationContext.close();
			}
		}
	}
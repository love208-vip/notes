---------------------------------
ActiveMQ-����Spring����ܽ�	-���|
---------------------------------
	# ���ӹ���,�ɵ����������ṩ.��ײ�����ӹ���
		<bean id="targetConnectionFactory" class="org.apache.activemq.ActiveMQConnectionFactory">
			<!-- borker��ַ -->
			<property name="brokerURL" value="tcp://123.207.122.145:61616"/>
			<!--�û���-->
			<property name="userName" value="kevin"/>
			<!--���� -->
			<property name="password" value="a12551255"/>
		</bean>
		* �û������������������,��ʹ��Ĭ�ϵ�
	
	# ���ӳ�,�ѳ��̵Ĺ������гػ�.�������
		<bean id="pooledConnectionFactory" class="org.apache.activemq.pool.PooledConnectionFactory" destroy-method="stop">
			<!-- ע�����ӹ��� -->
			<property name="connectionFactory" ref="targetConnectionFactory"/>	
			<!-- ��������� -->
			<property name="maxConnections" value="100"/>
		</bean>
	
	# spring�ṩ�����ӹ���,����ʵ�������Ĺ���.ע����������ʹ��.�������ӳ�.�൱��һ����������ӹ���,���ڹ��������� ConnectionFactory �� ConnectionFactory
		<bean id="connectionFactory" class="org.springframework.jms.connection.SingleConnectionFactory">
			<property name="targetConnectionFactory" ref="pooledConnectionFactory"/>
		</bean>

	# Template,Spring�ṩ�Ĺ�����,���Զ���Ϣ�����շ�,��������N���.������Ҫ.����ע��
		<!-- JMSTemplate -->
		<bean class="org.springframework.jms.core.JmsTemplate">
			<!-- ע�����ӹ��� -->
			<property name="connectionFactory" ref="connectionFactory"/>
			<!-- ע��Ĭ�϶���/���� -->
			<property name="defaultDestination" ref="topic"/>
			<!-- ֱ�����ö��е�����,��ע��.��Ĭ�ϵ�����һ��ָ�����ƵĶ���-->
			<property name="defaultDestinationName" value="ququ#1"/>
			<!-- ע����Ϣת���� -->
			<property name="messageConverter">
				<bean class="org.springframework.jms.support.converter.SimpleMessageConverter"></bean>
			</property>
		</bean>
	
	# ������,��ר��Ϊ������׼����.��һ������.���������˶���/����,���ӹ���,��������Ϣ
		<bean id="defaultMessageListenerContainer" class="org.springframework.jms.listener.DefaultMessageListenerContainer">
			<!-- ע�����ӹ��� -->
			<property name="connectionFactory" ref="connectionFactory"/>
			<!-- �����Ķ���/����-->
			<property name="destination" ref="queue"/>
			<!-- ����bean,Ҳ�����߼�����-->
			<property name="messageListener" ref="listenner"/>
		</bean>
		* ������,ֻҪ����IOC����.���������յ���Ϣ.�ͻ�ȥ���� listenner ��� onMessage ����
		* �������ö��,Ҳ����˵һ��Ӧ��,������N��Ķ��л��߻���
	
	# ����,Ҳ����ʵ���ϵ�ҵ���߼�����Bean
		<bean id="listenner" class="com.kevin.demo.activemq.spring.listener.Listenner"></bean>
		* ��ͨ��bean����,���Ǳ���Ҫʵ�� MessageListener �ӿ�.������Spring ��

	# Topic,��ʵ����һ��Bean,������IOC����ͺ�.�ĸ�Template ��Ҫ,�͸���
		<bean id="topic" class="org.apache.activemq.command.ActiveMQTopic">
			<!-- ����ע�뻰���� -->
			<constructor-arg index="0" value="spring-topic"/>
		</bean>
	
	# Queue,��ʵ����һ��Bean,������IOC����ͺ�.�ĸ�Template ��Ҫ,�͸���
		<bean id="queue" class="org.apache.activemq.command.ActiveMQQueue">
			<!-- ����ע��������� -->
			<constructor-arg index="0" value="spring-queue"/>	
		</bean>
	



	# ����������ӳ�֮��Ĺ�ϵ,ֻ�Ǹо��е㸴��
		ActiveMQConnectionFactory
					| ע��
		PooledConnectionFactory(connectionFactory)
					| ע��
		SingleConnectionFactory(targetConnectionFactory)		//�����ʵ�����յ� ConnectionFactory,ע�����Ҫ ConnectionFactory�����


---------------------------------
ActiveMQ-PTP-Provider			 |
---------------------------------
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
		try{
			//��IOC�л�ȡtmplateģ��
			JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
			/**
			 * ����ģ���send����ִ�з���
			 * 	send������N������,����:������ִ�з��͵�ʱ��ָ������/����
			 * ������ MessageCreator �ӿڵ�����,һ�㶼��ֱ�������ڲ�����
			 * */
			jmsTemplate.send(new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					/**
					 * message����ͨ���β�session����,Ҳ����ֱ��new��ʵ��.
					 * TextMessage message = new ActiveMQTextMessage();
					 * */
					TextMessage message = session.createTextMessage("Hello Spring");
					return message;		//�������message
				}
			});
		}finally{
			if(applicationContext != null){
				applicationContext.close();
			}
		}
	}

---------------------------------
ActiveMQ-PTP-Consumer			 |
---------------------------------
	# ����OK,ֱ������IOC�ͺ�.����Ϣ.�ͻ�֪ͨ����bean




---------------------------------
ActiveMQ-�ܽ�					 |
---------------------------------
	# Spring  �� ActiveMQ ������,��ʵ�������̶����൱�ļ�,���ұȽ�����
		* ���԰Ѷ�����xml�����ø�ģ��,Ҳ���԰Ѷ���ע�뵽ҵ����,��ģ��ִ��send������ʱ��,�ֶ���ָ������
	

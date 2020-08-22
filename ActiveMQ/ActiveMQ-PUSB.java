----------------------------
������						|
----------------------------
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://123.207.122.145:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
		Destination destination = session.createTopic("topic#1");
		MessageProducer messageProducer = session.createProducer(destination);
		//���� - ��Ϣͷ
		messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
		TextMessage message = new ActiveMQTextMessage();
		message.setText("����һ���㲥");
		messageProducer.send(message);
		session.commit();
		connection.close();
	}

----------------------------
������-�ǳ־û�����			|
----------------------------
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://123.207.122.145:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
		Destination destination = session.createTopic("topic#1");
		MessageConsumer messageConsumer = session.createConsumer(destination);
		while(true){
			ActiveMQTextMessage message =  (ActiveMQTextMessage) messageConsumer.receive();
			System.out.println("�ǳ־ö�����B,�յ���Ϣ:"+message.getText());
			message.acknowledge();
		}
	}

----------------------------
������-�־û�����			|
----------------------------
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://123.207.122.145:61616");
		Connection connection = connectionFactory.createConnection();
		/** ����IDֵ **/
		connection.setClientID("ID#1");
		connection.start();
		Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
		/** ���ĵ�һ��topic **/
		Topic topic = session.createTopic("topic#1");
		/** �����־ö��� ���ö�������**/
		TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "t1");
		while(true){
			ActiveMQTextMessage message =  (ActiveMQTextMessage) topicSubscriber.receive();
			System.out.println("�־ö�����C,�յ���Ϣ:" + message.getText());
			message.acknowledge();
		}
	}
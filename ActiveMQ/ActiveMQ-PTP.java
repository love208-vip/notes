----------------------------
������						|
----------------------------
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://123.207.122.145:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
		Destination destination = session.createQueue("queue#1");
		MessageProducer producer = session.createProducer(destination);
		// ��Ϣͷ���� - ��Ϣ�־û�
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);		
		TextMessage message = new ActiveMQTextMessage();
		// ��Ϣ�������� 
		message.setStringProperty("name", "KevinBlandy");
		//��������
		message.setText("Hello World");
		//ִ�з���
		producer.send(message);
		session.commit();
		connection.close();
	}


----------------------------
������						|
----------------------------
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://123.207.122.145:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
		Destination destination = session.createQueue("queue#1");
		MessageConsumer messageConsumer = session.createConsumer(destination);
		//messageConsumer.setMessageListener(new Listener());		//����ģʽ
		while(true){
			ActiveMQTextMessage message =  (ActiveMQTextMessage) messageConsumer.receive();
			System.out.println("�յ���Ϣ:"+ message.getText());
			message.acknowledge(); //ǩ����Ϣ
			System.out.println(message.getStringProperty("name"));
		}
	}
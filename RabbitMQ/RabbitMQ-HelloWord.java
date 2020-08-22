----------------------------
RabbitMQ-HelloWord			|
----------------------------
	# �򵥵�ģʽ:��Ϣ������������Ϣ,��Ϣ������������Ϣ
	# �ṹ
		P -- > [][][]  -- > C
			p	:��Ϣ������
			[]	:����
			C	:��Ϣ������
	
	/**
		������
	*/
	public static Connection getConnection() throws Exception {
		//�������ӹ���
		ConnectionFactory factory = new ConnectionFactory();
		//���÷����ַ
		factory.setHost("localhost");
		//�˿�
		factory.setPort(5672);
		//�����˺���Ϣ���û��������롢vhost
		factory.setVirtualHost("/kevinblandy");
		factory.setUsername("kevin");
		factory.setPassword("a12551255");
		// ͨ�����̻�ȡ����
		Connection connection = factory.newConnection();
		return connection;
	}
	/**
		���Ͷ�
	*/
    private final static String QUEUE_NAME = "test_queue";			//��������
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        // �������д���ͨ��
        Channel channel = connection.createChannel();
        /*
			����������������
			��Ϣ��������ڶ���
		*/
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // ��Ϣ����
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //�ر�ͨ��������
        channel.close();
        connection.close();
    }
	/**
		���ն�
	*/
	private final static String QUEUE_NAME = "test_queue";			//��������
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        /*
			��������
			���������߶���,��ʵ�������п�����ȷ�����д�������º��Ըò���
			����,Ϊ�˱������,Ҳ���Խ�����������.������κεط������κε�Ӱ��
		*/
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // ������е�������
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // ��������
        channel.basicConsume(QUEUE_NAME, true, consumer);
        /*
			��ȡ��Ϣ,��������
			����һ����һ��,��˵�е��ĺ󼴷�
		*/
        while (true) {
			/*
				��Ϊ������Ե��,�������д���,��һֱ����.ֱ���յ���Ϣ
			*/
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        }
    }
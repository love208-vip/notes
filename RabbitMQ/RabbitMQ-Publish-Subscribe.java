----------------------------
RabbitMQ-Publish / Subscribe|
----------------------------
	# ����ģʽ
	# һ����Ϣ������,N����Ϣ������
					 [][][]	-> C1
		P - > X - > 
					 [][][]	-> Cn
			p	:��Ϣ������
			X	:Exchanges(����)
			[]	:����
			C	:��Ϣ������
		
		* ����ģʽ������ֱ�Ӱ���Ϣ���͵�����,���Ƿ��͵�������
		* ÿ�������߶���һ���Լ��Ķ���,ÿ�����ж��󶨵�������
		* �����߷��͵���Ϣ,����������.�������,ʵ��'һ����Ϣ���������������'��Ŀ��
	
	# '�������Ϣ���͵�,δ���κεĶ��еĽ�����ʱ,��ô����Ϣ���ᶪʧ'
		* ��������û�д洢��Ϣ������,��Ϣֻ�ܴ洢�ڶ���
	



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
		��Ϣ������
	*/
	private final static String EXCHANGE_NAME = "test_exchange_fanout";		//����������
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        /*
			����exchange,�����Զ���
		*/ 
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        // ��Ϣ����
        String message = "Hello World!";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
	/**
		������1
	*/
	private final static String QUEUE_NAME = "test_queue_work";				//��������
    private final static String EXCHANGE_NAME = "test_exchange_fanout";		//����������
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // �󶨶��е�������
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        // ͬһʱ�̷�����ֻ�ᷢһ����Ϣ��������
        channel.basicQos(1);
        // ������е�������
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // �������У��ֶ��������
        channel.basicConsume(QUEUE_NAME, false, consumer);
        // ��ȡ��Ϣ
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
            Thread.sleep(10);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
	/**
		������N
	*/
	private final static String QUEUE_NAME = "test_queue_work2";				//��������
    private final static String EXCHANGE_NAME = "test_exchange_fanout";			//����������
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // �󶨶��е�������
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        // ͬһʱ�̷�����ֻ�ᷢһ����Ϣ��������
        channel.basicQos(1);
        // ������е�������
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // �������У��ֶ��������
        channel.basicConsume(QUEUE_NAME, false, consumer);
        // ��ȡ��Ϣ
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }

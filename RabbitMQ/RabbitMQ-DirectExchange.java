----------------------------
RabbitMQ-Routing			|
----------------------------
	# ��˵�е�·��ģʽ
	
			  -	error ->	
			 |-	info  ->	[][][]	C1
		P -> X	
			 |- error ->
			 |- info  ->	[][][]	Cn
			  - warn  ->
		
			p	:��Ϣ������
			X	:������(������:direct(·��))
			C1	:������1
			C2	:������N
		
		* �����߰���Ϣ���͸�������(·������)
		* �����ߴ���N������,ָ��һ��'·��key',�󶨵�������
		* �����߲�����Ϣ��ʱ��,����Ҫָ��'·��key'
		* ��Ϣ���ｻ������ʱ��,�ͻ���ݲ�ͬ��'·��key',����Ϣ���͵���ͬ�������߶���.�������͵�N��'��ͬ·��key'�Ķ���
		* ����һ����ѡ���Ե���Ϣ����
		* ��˵�е�'·��key',��ʵ���Ǹ��ַ���... ...

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
		������
	*/
	private final static String EXCHANGE_NAME = "test_exchange_direct";	//����������
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ����exchange,������ direct
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        // ��Ϣ����
        String message = "Hello World!";
		/**
			������Ϣ��·��.����ָ�� ·��key = "key2"
		*/
        channel.basicPublish(EXCHANGE_NAME, "key2", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
	/**
		������1
	*/
	private final static String QUEUE_NAME = "test_queue_work_direct1";
    private final static String EXCHANGE_NAME = "test_exchange_direct";
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        /*
			�󶨶��е�������
			����ָ����һ��·��key = "update"
		*/
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "update");
		/*
			�ٰ�һ������
			����ָ����һ��·��key = "delete"
			 channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "delete");
		*/
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
	private final static String QUEUE_NAME = "test_queue_work_direct2";
    private final static String EXCHANGE_NAME = "test_exchange_direct";
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        /*
			�󶨶��е�������
			����ָ����һ��·��key = "key2"
		*/
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "key2");
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
		
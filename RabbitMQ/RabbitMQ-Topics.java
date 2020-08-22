----------------------------
RabbitMQ-Topics				|
----------------------------
	# ͨ��ģʽ
	# ��ʵ��·��ģʽ(Routing)һ������
	# �������
		1,Routing����Ϣ��key�Ͷ��е�key������ȫһ��
		2,������ֻ��Ҫ����ƥ��Ĺ���
	
	# ƥ�����
		* ͨ���������
			1,#
				һ�����߶���ʶ�
			2,*
				ֻ����һ���ʶ�
	
	
	# ͼ��
			  -	error.* ->	
			 |-	info.#  ->	[][][]	C1
		P -> X	
			 |- *.error ->
			 |- #.info  ->	[][][]	Cn
			  - #warn*  ->
		
			p	:��Ϣ������
			X	:������(������:direct(·��))
			C1	:������1
			C2	:������N
	/**
		����
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
	private final static String EXCHANGE_NAME = "test_exchange_topic";
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ����exchange(������)
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        // ��Ϣ����
        String message = "Hello World!";
		/**
			����Ϣ key = key.1
		*/
        channel.basicPublish(EXCHANGE_NAME, "key.1", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
	/**
		������1
	*/
	private final static String QUEUE_NAME = "test_queue_topic_work";
    private final static String EXCHANGE_NAME = "test_exchange_topic";
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        /*
			�󶨶��е�������
			����ָ��ͨ���  = key.*
		*/ 
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "key.*");
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
	private final static String QUEUE_NAME = "test_queue_topic_work2";
    private final static String EXCHANGE_NAME = "test_exchange_topic";
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        /*
			�󶨶��е�������
			����ָ��ͨ��� = *.*
		*/ 
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "*.*");
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
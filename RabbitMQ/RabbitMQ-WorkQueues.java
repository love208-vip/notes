----------------------------
RabbitMQ-Work queues		|
----------------------------
	# Work ģʽ
	# һ��������������Ϣ,N��������������Ϣ
						-> C1
		P	-> [][][]
						-> C2
			p	:��Ϣ������
			[]	:����
			C	:��Ϣ������
	
	# 'ֻ����һ�������߻�ȡ����Ϣ'
		* ��ô��? ----  ��,����

	# ��������ܽ�
		* ������1��������2��ȡ������Ϣ�����ǲ�ͬ��,Ҳ����˵һ����Ϣֻ�ܱ�һ��������������
		* ������1��������2��ȡ������Ϣ��Ŀ��һ����.���ݷ��͵�����(���ֵ���),����һ��������������,һ��������ż��
		* �����������1,ÿ10�����������һ����Ϣ,������2ÿ1����ܴ���һ����Ϣ.�������Ǵ������Ϣ������һ����.�ⲻ��ƽ
		* �������߶���,Ҳ����˵.˭���ѿ�,˭�����Ѷ�,���������п���:   channel.basicQos(1);

	
	
	# �ܽ�
		1,һ�������߶�N��������
		2,��ؼ���һ�����(��������)
			channel.basicQos(1);
			* ������д���,�����߶���
			* �����/ע��.����¶��մ
		

			
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
	private final static String QUEUE_NAME = "test_queue_work";
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 100; i++) {
            // ��Ϣ����
            String message = "" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            Thread.sleep(i * 10);
        }
        channel.close();
        connection.close();
    }
	/**
		������1
	*/
	private final static String QUEUE_NAME = "test_queue_work";
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        /*
			ͬһʱ�̷�����ֻ�ᷢһ����Ϣ��������
			Ҳ��˵ͬһʱ��,MQ������ֻ�����ǰ������һ����Ϣ,����������,���ڸ�
			Ҳ�������ѿ����,���Ѷ�,���þ�������
		*/
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
            //����10����
            Thread.sleep(10);
            // ����ȷ��״̬
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
	/**
		������n
	*/
	private final static String QUEUE_NAME = "test_queue_work";
    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        /*
			ͬһʱ�̷�����ֻ�ᷢһ����Ϣ��������
			Ҳ��˵ͬһʱ��,MQ������ֻ�����ǰ������һ����Ϣ,����������,���ڸ�
			Ҳ�������ѿ����,���Ѷ�,���þ�������
		*/ 
        channel.basicQos(1);
        // ������е�������
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // �������У��ֶ��������״̬
        channel.basicConsume(QUEUE_NAME, false, consumer);
        // ��ȡ��Ϣ
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
            // ����1��
            Thread.sleep(1000);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
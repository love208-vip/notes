------------------------
RocketMQ-API-Producer	|
------------------------
	DefaultMQProducer
		# Ĭ����Ϣ�����߶���
		# new DefaultMQProducer(String producerGroupName);
		void setNamesrvAddr(String address);
			* ����nameserver��ַ,�����ַ�÷ֺ�(;)�ָ�
		
		void start();
			* ����
		
		SendResult send(Message message);
			* ������Ϣ,����SendResult
		
		void send(Message message, long timeout);
			* ִ����Ϣ����,'����ָ����ʱʱ��',û�з���ֵ.
			* �����ʱ,��Ϣ��δ����.����Ϊ��Ϣʧ��.����� retryTimesWhenSendFailed ������Ϣ�ط�

		void setRetryTimesWhenSendFailed(int type);
			* ���õ���Ϣ����ʧ�ܵ�ʱ��,�ط�����

	Message
		# ��ͨ��Ϣ����
		# new Message(String topic,String tag,byte[] message);

	
	SendResult
		# ��Ϣ���ͽ������

------------------------
RocketMQ-API-Consumer	|
------------------------
	DefaultMQPushConsumer
		# Ĭ����Ϣ���ն���
		# new DefaultMQPushConsumer("quickstart_consumer");
		void setNamesrvAddr(String address);
			* ����nameserver��ַ,����� ';' �ֺŷָ�

		void consumer.setConsumeFromWhere(ConsumeFromWhere where);
			* ����Consumer��'��һ������',�Ǵ�ͷ����ʼ����,���Ǵ�β����ʼ����
			* ���'�����ǵ�һ������',��ô�ᰴ���ϴ����ѵ�λ�ý�������
		
		void consumer.subscribe(String topic, String tags);
			* ���ö���,�Լ���ǩ
			* �����ǩ֮���� || �ָ�("tag1 || tag2 || tag3")
			* ��ǩҲ����ʹ��ͨ��� "*",��ʾ����
		
		void registerMessageListener(MessageListenerConcurrently listener);
			* ע�������
		
		void setConsumeThreadMax(int max);
			* Ĭ�� 20
			* ��������,������Ϣ�̳߳ص�����߳���
		
		void setConsumeThreadMin(int min);
			* Ĭ�� 10
			* ��������,������Ϣ�̳߳ص���С�߳���
	
		void setConsumeMessageBatchMaxSize(int size);
			* Ĭ�� 1
			* ����һ���Դӷ�������ȡ��������Ϣ
			* ������ȡ�����,����������.customer������,broker������Ϣ�ѻ�,��ʱ.����������ȡ��Ϣ
			* ����������ļ���״̬,brokerû�жѻ�,��ô�������ļ�ʱ����,��һ������һ��
			* ���������,����ʵ����ÿ����ȡ������,����������ڵ������

		void setAllocateMessageQueueStrategy(AllocateMessageQueueStrategy allocateMessageQueueStrategy);
			* ���ؾ������,��N����
				AllocateMessageQueueAveragely			
					* ���ؾ������
				AllocateMessageQueueAveragelyByCircle
					* ��ѯ����

				AllocateMessageQueueByConfig
				AllocateMessageQueueByMachineRoom
				

		
		void setMessageModel(MessageMode model);
			* ��������ģʽ
			* MessageModel.CLUSTERING,��Ⱥ����('Ĭ��')
			* MessageModel.BROADCASTING,�㲥����

		void setPullInterval(long time);
			* Ĭ��Ϊ 0,��λ�Ǻ���
			* ��Ϣ��ȡ�߳�,ÿ�������ȡһ����Ϣ
		
		void setPullThresholdForQueue(int max);
			* Ĭ�� 1000
			* ����,��ȡ��Ϣʱ,���ض��л�����Ϣ���������
		
		void setPullBatchSize(int size);
			* Ĭ�� 32 
	
	MessageListenerConcurrently
		# ��Ϣ��������,��һ���ӿ�.��Ҫ�Լ�ʵ��
		public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,ConsumeConcurrentlyContext context);
			* ��Ϣ�¼�����
			* ����ֵ
				ConsumeConcurrentlyStatus.CONSUME_SUCCESS
					> ��ʾ��Ϣ���ѳɹ�
				ConsumeConcurrentlyStatus.RECONSUME_LATER
					> ��ʾ��Ϣ����ʧ��'����Ҫ��Brokerһ��ʱ����ط���Ϣ'
					> ����Ǽ�ʱ����,��ֻ�ط���ǰ��Ϣ
					> �������������,�� msgs ����������Ϣ���ᱻ�ط�

	MessageListenerOrderly
		# ��Ϣ��������,��һ���ӿ�.��Ҫ�Լ�ʵ��
		public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) ;
		# ����'˳������Consumer'�ļ���,ֻ������������ܱ�֤˳������




------------------------
RocketMQ-API-Other		|
------------------------
	
	
---------------------------
RocketMQ-��Ⱥ����			|
---------------------------
	# '���Consumerû��ָ������ģʽ,��ôĬ�Ͼ��Ǽ�Ⱥ����'
	# һ����Ϣ,ֻ�ܱ���Ⱥ�е�һ��Consumer����.
	# ͨ�����ؾ������,��ѯ���������㷨����
	# Consumer���ü�Ⱥ����
		consumer.setMessageModel(MessageModel.CLUSTERING);

---------------------------
RocketMQ-�㲥����			|
---------------------------
	# һ����Ϣ,��Ⱥ�е����е�Consumer��Ҫ����
	# Consumer���ù㲥����
		consumer.setMessageModel(MessageModel.BROADCASTING);
	

	# �򵥴���

		public static void main(String[] args) throws MQClientException{  
			DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("quickstart_consumer");
			consumer.setNamesrvAddr("192.168.250.199:9876;192.168.250.277:9876");
			consumer.setMessageModel(MessageModel.BROADCASTING);
			consumer.subscribe("TopicQuickstart", "*");
			consumer.registerMessageListener(new MessageListenerConcurrently() {
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,ConsumeConcurrentlyContext context) {
					//�����߼�
				}
			});
			consumer.start();		
			System.out.println("����������");
		}

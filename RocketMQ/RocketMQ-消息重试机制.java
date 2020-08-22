--------------------------------
RocketMQ-��Ϣ���Ի���			|
--------------------------------
	# RocketMQ��Ϣ���Դ��·�Ϊ Producer ��,�� Customer ��



--------------------------------
RocketMQ-��Ϣ����-Producer		|
--------------------------------
	# �����߶���Ϣ����
		* Producer �� Broker ������Ϣʧ��
		* ��ʵ,Producer Ĭ�Ͼ�����Ϣ���Ի���,Ĭ�������� 3 ��

	# ������Ϣ���ͽ���ж��Ƿ��ͳɹ�
		SendResult sendResult = producer.send(message,1000);

		sendResult.SendStatus.SEND_OK;				
		sendResult.SendStatus.FLUSH_DISK_TIMEOUT,
		sendResult.SendStatus.FLUSH_SLAVE_TIMEOUT,
		sendResult.SendStatus.SLAVE_NOT_AVAILABLE,
	
	# Procuder ������Ϣʧ���ط�����
		void setRetryTimesWhenSendFailed(int type);
	
		

--------------------------------
RocketMQ-��Ϣ����-Consumer		|
--------------------------------
	# �����߶���Ϣ���Է�Ϊ����
		* Broker �� Consumer ������Ϣʧ��(��ʱ)
		* Consumer ����ʧ��(�����쳣/ҵ���߼�)

	1,Broker��Ϣ����
		* ֻҪû���յ� Consumer �� CONSUME_SUCCESS ���� RECONSUME_LATER.����Ϊ��ʧ��
		* ���ֻ����������ƴ�����,��� broker �� Consumer Ͷ����Ϣ��ʱ,��ô������ѡ��Ⱥ�е���һ�� Consumer ������ϢͶ��
		* ֻҪ�����Ϣû�гɹ�'����',��һֱͶ��,Ͷ��... ...
		* ǧ��Ҫ������,������Ե���˼��'Broler ������Ϣ,Consumer û���յ���Ϣ,������û���յ� Consumer �Ļظ�'
		* Consumer��ִ�����ѵĹ�����,崻�.û�з��ؽṹ.Ҳ�ᴥ�� Broker ����Ϣ���Ի���
		* ��Ϊ��Ϣ���Ի���,���Կ��ܻ����'�ظ����ѵĿ���'
		
	2,Customer��Ϣ����
		* ��Ϣ������ Consumer ,������Ϊҵ���߼�,��Ҫ��������������Ϣ,�����Ǵ����׳����쳣.ͨ��������������Ϣ����

		# ͨ�� consumeMessage(List<MessageExt> msgs,ConsumeConcurrentlyContext context); ��������ֵ��ȷ���Ƿ��ط���Ϣ
			return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				* ��ʾ�ɹ�����������Ϣ

			return ConsumeConcurrentlyStatus.RECONSUME_LATER;
				* ��ʾ�����쳣,��Ҫ��������
				* ����Ǽ�ʱ������,��������Ե�ǰ��Ϣ
				* �����������Ϣ(broker�ѻ�),�����Ե�ǰ��ȡ��һ����Ϣ
		
		# �������Դ�������ʱ��
			* ��һ����Ϣ����ʧ��,������Ϣ���Ե�ʱ��.����ʱ������
			����		���
			1			10��
			2			30��
			3			1����
			4			2����
			5			3����
			6			4����
			..			..
			12			10����
			13			20����
			14			30����
			15			1Сʱ
			16			2Сʱ

		# ��ȡ��ǰ��Ϣ�������˶��ٴ�
			* ����ͨ�� MessageExt �� reconsumeTimes ����,����ȡ����Ϣ�Ѿ������˶��ٴ�,�����ֵΪ 0,���ʾ����Ϣ��δ�����Թ�
				MessageExt [queueId=1, storeSize=182, queueOffset=129, sysFlag=0, bornTimestamp=1480145809942, bornHost=/192.168.250.171:60428, storeTimestamp=1480145783086, storeHost=/192.168.250.227:10911, msgId=C0A8FAE300002A9F0000000000018C1E, commitLogOffset=101406, bodyCRC=721375870, reconsumeTimes=0, preparedTransactionOffset=0, toString()=Message [topic=TopicQuickstart, flag=0, properties={MIN_OFFSET=0, MAX_OFFSET=135, CONSUME_START_TIME=1480145818965, UNIQ_KEY=C0A8FAAB05D073D16E93818580160039, WAIT=true, TAGS=TagA}, body=14]]
				int times = message.getReconsumeTimes();
			
		# ������Ϣ,����������Ѷ��ٴ�
			* ����ͨ�� message.getReconsumeTimes(); ������,'��һ����Ϣʧ��N�˺�,��д����־.Ȼ�󷵻� SUCCESS,����Broker������Ϣ�ɹ�����.���ټ���������'
				try{
					//�߼�����
				}catch(Exception e){
					if(message.getReconsumeTimes() == 10){
						//������������10��,ִ�д�����־��¼
						doErrorLog(message);
						//���Ҹ���Broker,����Ϣ������Ϣ����
						return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
					}
					//��Ϣδ�ظ�10��,go on
					return ConsumeConcurrentlyStatus.RECONSUME_LATER;
				}
		


			
			
			
			
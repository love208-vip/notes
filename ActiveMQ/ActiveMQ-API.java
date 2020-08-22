Connection
	* JMS����Ľӿ�,�����MQ��������һ������,ͨ��һ��������ֻ�ö���һ���ӿ�
	* ��һ�� Connection �����ʱ��,Ĭ���ǹر�״̬.��Ҫ�ֶ�����
	* һ�� Connection ���Դ���N��� Session
	* ������ִ�����,Ӧ�ùر� Connection,�����Զ���ȥ�ر� Session,MessageProducer �� MessageConsumer
	

Session
	* JMS����Ľӿ�,�� Connection ����,һ�����߶��. Session ��һ���շ���Ϣ���߳�
	* ����ʹ�� Session ���� MessageProducer,MessageConsumer��Message
	* Session ���Ա�����,���߷�����,ͨ���򴴽� Session �ķ���,���� boolean ��������
		Session session = connection.createSession(boolean transacted, int acknowledgeMode);
			transacted:�Ƿ񴴽�����session
				'��������'
				�������������ַ���,�ύ���߻ع�
				��һ�������ύ,��Ϣ������,�����������һ������ʧ��,����ͻع�.�����������ִ�еĶ������ᱻ����.
				�ڷ�����Ϣ���Ҳ����Ҫ�� session.commit();������ʾ�ύ����
				'��ν������ع�,��ʵ����---��������Ϣ��message,�ڻع�/�ύ֮ǰ.����Խ��д�������Ϣд����л�����������,�ύ��ȥ�˷�����,�ع���ɶҲû��'

			acknowledgeMode:��Ϣǩ��ģʽ
				Session.AUTO_ACKNOWLEDGE
					�������ߴ�receive����onMessage�ɹ�����ʱ,Session�Զ�ǩ��������������Ϣ������
					'�Զ���ǩ����Ϣ'

				Session.CLIENT_ACKNOWLEDGE
					������ͨ��������Ϣ(Message)��acknowledge����ǩ����Ϣ
					���������,ǩ�շ����� Session ����
					ǩ��һ���Ѿ����ѵ���Ϣ,���Զ���ǩ����� Session �����Ѿ���Ϣ������
					'�ֶ���ǩ����Ϣ'

				Session.DUPS_OK_ACKNOWLEDGE
					�����,Session����ȷ���Դ�����Ϣ��ǩ��,������������Ϣ���ظ�,���ǽ�����Session�Ŀ���
					ֻ�������������ظ�����Ϣ,��ʹ��
					'��ִ��ǩ��,N�������߿��ܻ�����ͬһ����Ϣ,����һ���������ظ�����ͬһ����Ϣ'


MessageProducer
	* ��һ���� Session �����Ķ���,������ Destination ������Ϣ
	* session����
		MessageProducer createProducer(Destination destination)
	* ������Ϣ
		void send(Message message)
		void send(Message message, int deliveryMode, int priority, long timeToLive)
		void send(Destination destination,Message message)
		void send(Destination destination,Message message,int deliveryMode,int priority,long timeToLive)
		* ��������
			deliveryMode
				* ��Ϣ����ģʽ(�Ƿ�־û�)
					DeliveryMode.NON_PERSISTENT			//���־û�,���ܺ�.�����׶�ʧ
					DeliveryMode.PERSISTENT(Ĭ��)		//�־û�,���ܲ�.���ݲ��׶�ʧ

			priority
				* ��Ϣ���ȼ�
					���ȼ��� 0-9 һ��ʮ������(Ĭ��ֵ=4),JMS��Ҫ���ϸ���10�����ȼ�������Ϣ
					0-4	��ͨ��Ϣ		//
					5-9	�Ӽ���Ϣ		//����Ϣ,���ۻ����ͨ��Ϣ�ȵ���.ע��Ӵ,������

			timeToLive
				* ����ʱ��
					Ĭ�������,��Ϣ��Զ�������,�����Ҫ��Ϣ��һ��ʱ����ʧȥ����,��ô�������ø�ѡ��
					��λ�Ǻ���
	

MessageConsumer
	* ��һ���� Session �����Ķ���,������ Destination ������Ϣ
	* session����
		MessageConsumer createConsumer(Destination destination);
		MessageConsumer createConsumer(Destination destination,String messageSelector);
		MessageConsumer createConsumer(Destination destination,String messageSelector,boolean NoLocal);
		* ��������
			messageSelector
				* ��Ϣѡ����(������)
				* �ǻ��� SQL92���﷨,��ʵ����ĳ�ֹ�����ַ���(����:����)

			NoLocal
				* Ĭ��Ϊ false
				* Ϊ true �Ļ�,ֻ�ܽ��պ��Լ���ͬ����(Connection)����������Ϣ,�˱�ʶ����'����������,�������ڶ���'
			name
				* ��ȷ,���������ʱ��,�����Ķ�������.�־ö���ʱ��Ҫ�˲���
			

		TopicSubscriber createDurableSubscriber(Topic topic,String name);
		TopicSubscriber createDurableSubscriber(Topic topic,String name,String messageSelector,boolean noLocal)
	

----------------------------
RocketMQ-Ȩ��				|
----------------------------
	# Consumer ��Ⱥ�е�Ȩ������

	# Consumer ��������
		void setAllocateMessageQueueStrategy(AllocateMessageQueueStrategy allocateMessageQueueStrategy);

		
	# N�ֲ���
		AllocateMessageQueueAveragely			
			* ��ʵ�Ǹ�������,��ƽ������ĸ��ؾ���

		AllocateMessageQueueAveragelyByCircle
			* ��ѯ����,abcd,������.һ��һ���ķַ�
			* consumer.setAllocateMessageQueueStrategy(new AllocateMessageQueueAveragelyByCircle());

		AllocateMessageQueueByConfig

		AllocateMessageQueueByMachineRoom
			
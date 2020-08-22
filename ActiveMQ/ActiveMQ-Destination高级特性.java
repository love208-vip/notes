-------------------------------------
ActiveMQ-Destination�߼�����		 |
-------------------------------------


-------------------------------------
ActiveMQ-Wildcards					 |
-------------------------------------
	# Wildcards ͨ���
	# �ⶫ��������JMS�Ĺ淶,����ActiveMQ����չ
	# ActiveMQ֧��һ������:wildcards
	��:".",������Ϊ·�������ּ�ķָ���
	��:"*",����ƥ���κ�����
	��:">",���ڵݹ�ƥ���κ���������ֿ�ʼ�� Destination


-------------------------------------
ActiveMQ-Composite Destinations		 |
-------------------------------------
	# ��϶���
	# ��϶���,������һ������� Destination ������ Destination
	# ˵���˾���,ͬʱ���������,���� topic ������Ϣ
	# ����
		/**
			�˴����Ǵ����˴����������е�һ�� Queue
			���Queue�ö��Ÿ���
		*/
		Queue queue = new ActiveMQQueue("queue#1,queue#2,queue#3");
		/**
			ͨ�����,������Ϣ������
		*/
		MessageProducer producer = session.createProducer(queue);
	
	# Ҳ���Ի�Ϸ���,����һ�� Queue ���治���ж���,���� Topic
	# ����
		Queue queue = new ActiveMQQueue("queue#1,topic://topic#1");
		MessageProducer producer = session.createProducer(queue);
		* ��������ʵһ������,�޷Ǿ���.����ĸ�ʽ����: topic://   
	
	# Ҳ����ͨ�����������...������ɵ��,��ѧ


-------------------------------------
ActiveMQ-Delete Inactive Destination |
-------------------------------------
	# �Զ�ɾ������
	# һ�������,ActiveMQ,�� Queue,�ڲ�ʹ��֮��,����ͨ��WEB����,����JMX�ķ�ʽ������ɾ��
	# Ҳ����ͨ������,��MQ�Զ�̽�⵽���õĶ���(һ��ʱ����Ϊ�յĶ���),����ɾ��.�ͷ���Դ

		<broker schedulePeriodForDestinationPurge="10000">
			<destinationPolicy>
				<policyMap>
					<policyEntries>											 
						<policyEntry queue=">" gcInactiveDestinations="true" inactiveTimoutBeforeGC="30000"/>
					</policyEntries>
				</policyMap>
			</destinationPolicy>
		</broker>
		
		* schedulePeriodForDestinationPurge		:�೤ʱ����һ��,��������Ϊ10S,Ĭ��Ϊ0
		* inactiveTimeoutBeforGC				:�� Destination Ϊ�պ�,�೤ʱ�䱻ɾ��,������30s,Ĭ��Ϊ60
		gcInactiveDestinations					:����ɾ��������Ķ���,Ĭ��Ϊ false

-------------------------------------
ActiveMQ- Destination Options		|
-------------------------------------
	# ����ѡ��,�ⶫ��Ҳ������JMS�淶�еĶ���
	# ��ʵ����˵�����ڶ������ƺ�����HTTP��URL����һ������һЩ����
	# ������
		consumer.prefetchSize
			* consumer�־õ�δack�������Ϣ����,Ĭ��ֵΪ variable
		consumer.maximumPendingMessageLimit
			* �������Ʒǳ־û���topic�ڴ����������ߵ�����¶���������
		consumer.noLocal
			* Ĭ��Ϊ false
		consumer.dispatchAsync
			* �Ƿ��첽�ַ�,Ĭ��Ϊ true
		consumer.retroactive
			* �Ƿ����������,Ĭ��Ϊ false
		consumer.selector
			* JMS��selector,Ĭ��Ϊ null
		consumer.exclusive
			* �Ƿ�Ϊ��ռ������,Ĭ��Ϊ false
		consumer.priority
			* ���������ߵ����ȼ���,Ĭ�� 0
	
	# Demo
		Queue queue = new ActiveMQQueue("queue#1?consumer.exclusive=false&consumer.priority=4");
		MessageConsumer messageConsumer = session.createConsumer(queue);
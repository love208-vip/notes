------------------------
ActiveMQ-��������		|
------------------------
	# ActiveMQ��networkConnector��ʲô?
		* ��һЩ������,��Ҫ���ActiveMQ��Broker����Ⱥ,��ô���漰��Broker֮���ͨ��,�����:ActiveMQ��networkConnector

	# ActiveMQ��networkConnectorĬ���ǵ����,Ҳ����һ��broker��,һ��broker��.������ν�� �Ž�

	# ActiveMQҲ֧��˫������,����һ��˫���ͨ��,��������broker,����ʹ��ͬһ��ͨ�����շ���Ϣ,ͨ��ʹ�� duplex connector��ӳ��

	

------------------------
ActiveMQ-��̬��������	|
------------------------
	# static networks
		static networkConnector�����ڴ���һ����̬������,���������еĶ��broker.����Э�����ڸ���url,һ������url�������url��ַ.��ʽ����
			static:(uri1,uri2,uri3...)?key=value
	
	# ��������
		<networkConnectors>
			<networkConnector name="lcal network" uri="static://(tcp://ip:port,tcp://ip:port)"/>
		</networkConnectors>
		* ���û���ֳɵı�ǩ,��Ҫ�Լ�ȥ����
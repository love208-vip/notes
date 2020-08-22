----------------------------
ActiveMQ-����Э��			|
----------------------------
	# ˵����,ҪôTCPҪôNIO... ...

	# Connector 
		* ActiveMQ �ṩ,����ʵ�����ӵ�ͨѶ���ܰ���
			client-to-broker
			broker-to-broker
		* ActiveMQ ����ͻ���ʹ�ö���Э��������
	
	# ���� Transport Connector
		* ��./conf/activemq.xml ��

		<transportConnectors>
			 <!-- DOS protection, limit concurrent connections to 1000 and frame size to 100MB -->
			 <transportConnector name="openwire" uri="tcp://0.0.0.0:61616?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
			 <transportConnector name="amqp" uri="amqp://0.0.0.0:5672?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
			 <transportConnector name="stomp" uri="stomp://0.0.0.0:61613?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
			 <transportConnector name="mqtt" uri="mqtt://0.0.0.0:1883?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
			 <transportConnector name="ws" uri="ws://0.0.0.0:61614?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
		 </transportConnectors>
	
	# ActiveMQ ֧�ֵ� client-broker ͨѶЭ������
		TCP (Ĭ��)
			* Ĭ�ϵ�Broker����,����Ҫ���л�����.��Ϣ��ͨ��һ���� wrie protocol �����л��ֽ���
			* Ĭ�������,ActiveMQ�� wire protocol ���� OpenWire ,����Ŀ���Ǵ�ʹ������Ч�ʺ����ݿ�ݽ���
			* tcp������ʽ:tcp://ip:port?key=value&key=value
			* tcp���ŵ�
				1,�ɿ��Ը�,�ȶ���ǿ
				2,�ֽ�����������,Ч�ʸ�
				3,֧���κ�ƽ̨

		NIO
			* NIOЭ���TCPЭ������,��NIO�������ڵײ�ķ��ʲ���.����������Ա��ͬһ��Դ���и����client���úͷ�����и���ĸ���
			* �ʺ�NIO�ĳ���
				1,�д�����Clientȥ���ӵ�broker��
					* һ�������,������clientȥ����broker�Ǳ�����ϵͳ���߳��������Ƶ�.���,NIO��ʵ��,Ҫ��TCP��Ҫ���ٵ��߳�ȥ����.���Խ���ʹ��NIO
				2,���ܶ�Broker��һ���ܳٶ۵����紫��
					* NIO��TCP�ṩ���õ�����
			* NIO������ʽ:nio://ip:port?key=value&key=value
			* ����ʾ��
				<transportConnectors>
					<transportConnector name="tcp" uri="tcp://0.0.0.0:1883"/>			//tcp	
					<transportConnector name="nio" uri="nio://0.0.0.0:61684"/>			//nio
				</transportConnectors>
		UDP
			* �ⶫ��ͨ�����ڿ������ݴ����Ҳ������ݶ�ʧ�����
			* ������ʽ����һ������,ֻ��ǰ��Э�����Ʋ�ͬ
			* ����ʾ��
				<transportConnectors>
					<transportConnector name="udp" uri="udp://0.0.0.0:61684"/>			//udp
				</transportConnectors>
		SSL	
			* ����
		HTTP/HTTPS
			* MQ�����м��,������û��ɵ�ƻ������WEB������ʹ

		VM(����ͻ��˺�broker��һ��������ڵĻ�,����ʹ������Э����ٿ���)
	

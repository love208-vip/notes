-------------------------------
ActiveMQ-����������				|
-------------------------------
	1,��������conf�ļ���,��������Ϊ:conf2
	2,�޸������activemq.xml�ļ�
		��,brokerName �����ظ�
		��,���ݴ�ŷ��ļ����Ʋ����ظ�,����
			<kahaDB directoty="${activemq.data}/kahadb_2"/>
		�������漰�� TransportConnectors �Ķ˿�,�������ظ�
	3,�޸�jetty.xml,��Ҫ�����޸Ķ˿�
		<property name="port" value="8181"/>
	4,����binĿ¼,����һ��activemq�����ű�,������Ϊ acticemq2
		��,�޸ĳ���ID,�����ظ�
			* ACTIVEMQ_PIDFILE ="$ACTIVEMQ_DATA/activemq2-`hostname`.pid"
		��,�޸������ļ�·��
			* ACTIVEMQ_CONF="$ACTIVEMQ_BASE/conf2"
		��,�޸Ķ˿�,�����и�TCP��61616�Ķ˿�,������ͬ,��Ϊ��activemq.xml��ͬ����
		��,Ȼ��Ϳ���ִ����

-------------------------------
ActiveMQ-��������&����			|
--------------------------------
	# �޸�WEB�������̨�Ķ˿�
		* �޸�confĿ¼�е�jetty.xml
			<bean id="jettyPort" class="org.apache.activemq.web.WebConsolePort" init-method="start">
				 <!-- the default port number for the web console -->
				<property name="host" value="0.0.0.0"/>
				<!-- �޸���������� 8161,��Ϊ�㿪�ĵ����־�OK -->
				<property name="port" value="8161"/>
			</bean>
	
	# �޸���Ϣ�������Ķ˿�
		* �޸�conf/activemq.xml�ļ�,��Ӧ�ÿ��Կ����������޸Ķ˿�
		<transportConnectors>
			<transportConnector name="openwire" uri="tcp://10.42.220.72:61618"discoveryUri="multicast://default"/>
		</transportConnectors>
	
	# �޸ĺ�̨�����û����û�����������
		* �޸�confĿ¼�е�jetty-realm.properties�ļ�
			admin: admin, admin
			user: user, user
	

	# ������Ϣ���ȼ�
		* �޸�confĿ¼��,activemq.xml
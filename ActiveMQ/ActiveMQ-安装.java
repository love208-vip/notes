-------------------------------
ActiveMQ-Windows��װ			|
--------------------------------
	


-------------------------------
ActiveMQ-Linux��װ				|
--------------------------------
	1,����
		* �Լ�ȥ�����ҵ�ַ
	
	2,��ѹ
		* ����
	
	3,����activeMQ
		/usr/local/activemq/apache-activemq-5.14.1/bin/linux-x86-64/activemq start
		* �ҵ��ű�,ִ��
	
	4,����ǽ����
		* vim /etc/sysconfig/iptabls
			-A INPUT -m state --state NEW -m tcp -p tcp --dport 8161 -j  ACCEPT   
			-A INPUT -m state --state NEW -m tcp -p tcp --dport 61616 -j  ACCEPT  
		* service iptables restart





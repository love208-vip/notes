-------------------------------
Linux-Tomcat					|
-------------------------------
	1,����,�ϴ�,��ѹ
		# ���ǲ���,������
		wget http://mirrors.cnnic.cn/apache/tomcat/tomcat-8/v8.5.6/bin/apache-tomcat-8.5.6.tar.gz
		

	2,����8080�˿�
		# vim /etc/sysconfig/iptables
			---------------------------------------------------
			-A INPUT -m state --state NEW -m tcp -p tcp --dport 20 -j ACCEPT			//�����20�����ο�
			-A INPUT -m state --state NEW -m tcp -p tcp --dport 8080 -j ACCEPT
		# service iptables restart		//������������Ч

	4,������,���ö˿�ת��
		* ��SB�ƶܻ����80
			iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 8080
				> ������,���80������ת����8080ȥ����,������û����
			service iptables save
				> д��iptables,������Ч

	5,��������
		# �༭/etc/rc.d/rc.local �ļ�
		# ���úñ�����Tomcat��Ŀ¼,�Լ������ű���Ŀ¼
		
			export JAVA_HOME=/usr/local/java/jdk1.8.0_101
			export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
			export PATH=$JAVA_HOME/bin/:$PATH

			export CATALINA_HOME=/usr/local/tomcat/apache-tomcat-8.5.4
			/usr/local/tomcat/apache-tomcat-8.5.4/bin/startup.sh

			* ע��,����Ҫ����JRE_HOME
			* ����Ҫע��,CLASSPATH������Ҫ��/etc/sysconfig/profile �е����ö�
			


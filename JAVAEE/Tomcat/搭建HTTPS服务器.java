----------------------------
Tomcat-�HTTPS������		|
----------------------------
	# ����HTTPS,���ڱ���.
	
	1,Ϊ��վ��������֤��
		
		* ʹ�õ���$JAVA_HOME/bin/keytool ����(JAVA�����Դ��Ĺ���)

		* keytool -genkey -alias tomcat -validity 36500 -keystore D:\home\tomcat.keystore -keyalg RSA

			* -genkey		:��ʾ������Կ��
			* -alias		:��ʾ�������
			* -keyalg		:ָ����Կ�㷨
			* -validity		:��Կ��Чʱ��,Ĭ��Ϊ90��,36500.��ʾ100��
			* -keystore		:ָ����Կ�����·��

		
	
		* ���� keystore ����
			������֤��,ϵͳ��ʹ��һ����Կ��������,�������������Կ�������
		
		* ����������������ʲô?
			��һ������Ҫ,��ʾΪ�ĸ���վ��������֤��,��д����
		
		* ������֯��λ������ʲô��
			* ����
		
		* ������֯������ʲô��
			* ����
		
		* �����ڵĳ��л�������������ʲô?
			* ����
		
		* �����ڵ���,��ʡ����ʲô?
			* ����
		
		* �õ�λ������ĸ���Ҵ�����ʲô?
			* ����
		
		* CN=localhost,OU=Unknow,O=Unknow,L=Unknow,ST=Unknow,C=Unknow ��ȷ��?
			* ȷ������: y
		
		* ���� <tomcat> ��������(����� keystore ������ͬ,ֱ�ӻس�)
			* ����֤�����Կ,����Կ��������Ƿ���ͬ.
			* �����Ϊ��Ҫ������tomcat�����ļ���ʹ�ã�����������keystore������һ�£�������������Ҳ����
		
		* OK,��~Ŀ¼��,������ .keystore һ��֤���ļ�
			* ����,֤�鴴���ɹ�
	
	2,���÷�����
		* �� .keystore �ļ����Ƶ� $TOMCAT_HOME/conf Ŀ¼��
		* �޸�server.xml,�����ж��Ѿ�ע�͵���
			  <Connector
				port="8443" 
				protocol="org.apache.coyote.http11.Http11Protocol"
				maxThreads="150" 
				SSLEnabled="true" 
				scheme="https" 
				secure="true"
				clientAuth="false" 
				sslProtocol="TLS"  
				keystoreFile="conf/.keystore"		//ָ����Կ�ļ�
				keystorePass="123456"/>				//ָ����Կ�������
			

			
			
----------------------------
Tomcat-������				|
----------------------------
	

		
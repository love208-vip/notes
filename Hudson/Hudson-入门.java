------------------------
Hudson-����				|
------------------------
	# �Զ�������,����,����

	# Hudsonֻ��һ���������ɷ�����(�������ɹ���)
	# �һ�������ĳ������ɹ���ƽ̨,����ҪSVN,Maven��
	# Hudson ֧��war����������ڲ���ϵͳ��RMP��װ
		* Ϊ��ͨ���Ժ�Ǩ����,һ�㶼�ǲ���WAR��,������Tomcat����

	1,����,��ѹ
		wget http://ftp.jaist.ac.jp/pub/eclipse/hudson/war/hudson-3.3.3.war

	2,���û�������
		export HUDSON_HOME=/usr/local/hudson
		
	3,Hudson�Ƚ������ڴ�,����Ӧ������Tomcat��JVM��Ϣ
		* �༭bin/catalina.sh
		JAVA_OPTS='-Xms512m -Xmx2048m'
	
	
	
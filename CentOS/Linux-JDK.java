	# ̫��,����˵



	1,�����ļ�
		jdk-8u101-linux-x64.tar.gz
	2,�ϴ��� /usr/local/java ��
	3,��ѹ:tar -xvf jdk-8u101-linux-x64.tar.gz
	4,ɾ��ԭ�ļ�:rm jdk-8u101-linux-x64.tar.gz
	5,�޸�/etc/profile�ļ�(ע��汾)
		#JDK
		export JAVA_HOME=/usr/local/java/jdk1.8.0_131
		export JRE_HOME=/usr/local/java/jdk1.8.0_131/jre
		export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools/jar:$JRE_HOME/lib:$CLASSPATH
		export PATH=$JAVA_HOME/bin/:$PATH





----------------------------
Dubbo-���					|
----------------------------
	# ������ĵ�����
		* ���������ߺ��ṩ��,���ڴ���ͳ�Ƶ��ô���.��ʱÿ���ӷ���һ��ͳ�����ݵ��������
		* Ϊ�������ά�ṩ����
		
	# ��������ǿ�ѡ��(�Ǳ���)
		
	# ������Ŀ����Զ��忪��
		

----------------------------
Dubbo-���׼�����İ�װ		|
----------------------------
	# dubbo-monitor-simple-2.5.3-assembly.tar
		* �����Լ������������,Ҳ���Դ���������
	
	# ������Ǹ������г���
		bin			//�ű�Ŀ¼
		conf		//�����ļ�
		lib			//��������
	
	# �޸������ļ�
		dubbo.container=log4j,spring,registry,jetty
		dubbo.application.name=simple-monitor
		dubbo.application.owner=
		dubbo.registry.address=zookeeper://192.168.250.157:2181?client=zkClient
			* �޸�Ϊzookeeper��ַ,����ͨ��?���ò���,client=zkClient
		dubbo.protocol.port=7070
		dubbo.jetty.port=8080
			* web����̨�˿�
		dubbo.jetty.directory=${user.home}/monitor
		dubbo.charts.directory=${dubbo.jetty.directory}/charts
		dubbo.statistics.directory=${user.home}/monitor/statistics
		dubbo.log4j.file=logs/dubbo-monitor-simple.log
		dubbo.log4j.level=WARN
	
	# ��dubbo�����ü��
		<!-- ��ط��� ,��ע�������Զ����Ҽ�ط���-->
		<dubbo:monitor protocol="registry"/>
		* �����������ṩ��
	
	# ����
		* binĿ¼��,���ݲ���ϵͳ������ͬ�Ľű�
	
	# ����������
		http://ip:8080
----------------------------
Dubbo-�������̨			|
----------------------------
	# dubbo�ṩ��һ�����߹�����������Ĺ���,�������̨Ϊ�����ڲ����˸��
	# ��Դ���ܰ���
		·�ɹ���
		��̬����
		���񽵼�
		���ʿ���
		Ȩ�ص���
		���ؾ���
		...
	
----------------------------
Dubbo-�������̨��װ		|
----------------------------
	# �������̨�����Լ�����,Ҳ����ȥ����
		dubbo-admin-2.5.3
		* �ⶫ��������Ǹ�WEB����,��Ҫ������������
	
	# �޸������ļ�
		* ./WEB-INF/dubbo.properties
		dubbo.registry.address=zookeeper://192.168.250.157:2181?client=zkclient
		dubbo.admin.root.password=root
			* ���� root �û�������
		dubbo.admin.guest.password=guest
			* ���� guest �û�������



----------------------------
Dubbo-�������̨��������	|
----------------------------		
	# ��JDK8��,���� 2.5.3 �Ŀ���̨,����һ���쳣.���Ը���JDK7,���

	# ���� Zookeeper ��Ⱥ
		dubbo.registry.address=zookeeper://ip:port?backup=ip:port,ip:port


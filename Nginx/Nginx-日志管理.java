--------------------
Nginx-��־����		|
--------------------
	# Nginx������Բ�ͬ��Server����ͬ��log
	# ȫ�ֵ�log����


--------------------
Nginx-Servlet������־|
--------------------
	# ������Server�� 
		#access_log  logs/host.access.log  main;
		* main����һ����ʽ,���Ѿ�����õ�

	server{
		...
		/*
			����÷������־��¼�ļ�,���ʽ,�뻺������С
			��Ҫ,����ʹ�� main ��ʽ,��ôconf�����main,�����Ҫ���ע��
		*/
		access_log logs/ywp.access.log main buffer=32k;
	}

--------------------
Nginx-log_formatָ��|
--------------------
	
	# ������־��ʽ����
		log_format mylog "....";
	
	$http_x_forwarded_for 
	remote_user 
		���ڼ�¼IP��ַ
	$remote_user 
		������¼Զ�̿ͻ����û�����
	$time_local 
		������¼,����ʱ���Լ�ʱ��
	$request
		������¼�����URL��HTTPЭ��
	$status
		������¼�����״̬(HTTP��Ӧ��),
	$body_bytes_sent
		���ڼ�¼��Ӧ�ͻ��˵������ļ���С
	$http_referer��
		�ڼ�¼�Ǵ��ĸ�ҳ����
	$http_user_agent
		���ڼ�¼�ͻ���������������Ϣ

	

--------------------
Nginx-��־�и�		|
--------------------
	# �����������,��־�ļ������,��Ҫ�и�
	# shell�ű�,��Linux�Ķ�ʱ����
		... ... ���Ӳ���
	
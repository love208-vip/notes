-------------------------------
RabbitMQ-��װ Windows			|
-------------------------------
	# ��װע��
		* ����ʹ��Ĭ��·��
		* ϵͳ�û���������Ӣ��
		* ��װ·�����ܳ���Ӣ��
		* �������������Ӣ��
		* ��ǰ��װ�û������ǹ���Ա

	1,�����ص�ַ,����Windos�汾(exe����)
		http://www.rabbitmq.com/download.html

	2,��װErlang����
		* ���ص�ַ http://www.erlang.org/downloads(����windows�汾,exeִ�г���)
		* ����ϵ��,ȫ��Ĭ��.һֱ��һ��
		* ���ܳ��ֵ��쳣
			Erlang OPT XX Setup
			Error opening file for writing
			...
			* �������,���Լ���
	
	4,��װRabbitMQ
		* ��һ������,ȫ����(Ĭ��)
		* �ڶ�������Ĭ��·��
		* ɵ��ʽ����һ��
	
	5,�򿪿���̨
		* �����Wind7,ֱ�ӽ��밲װĿ¼.�ҵ�:RabbitMQ Command Prompt ���cmd,���м���
		* �����Win8--��
		* ���˵û�����ҵ�?(���鷽��)
			1,���밲װ·��
				C:\Program Files\RabbitMQ Server\rabbitmq_server-3.6.5\sbin
				* �����Ŀ¼,�Թ���Ա��ݴ�CMD,���CMD�������Ǹ�Ҳ��һ����
	
	6,ִ������
		rabbitmq-plugins enable rabbitmq_management
		* ��������
		* ������������OK
			Applying plugin configuration to rabbit@DESKTOP-UHNU5C4... started 6 plugins.
	
	
	7,�������
		http://127.0.0.1:15672
		
	8,ʹ��Ĭ���˻���¼
		guest/guest
		* �������Ǹ�����Ȩ��,��ʵ��RabbitMQ������Ȩ��

	9,�����¼�ɹ�,���ʾ��װ�ɹ�

	# ���˵ Windows ��װʧ��,�ͳ����� Linux,����ʹ�ñ����ṩ��MQ����

	
-------------------------------
RabbitMQ-��װ Linux				|
-------------------------------
	1,��������
		yum install gcc gcc-c++
		yum install zlib zlin-devel

	2,��װErlang����
		yum -y install erlang

	3,���ذ�װ��
		http://www.rabbitmq.com/releases/rabbitmq-server/v3.6.5/rabbitmq-server-3.6.5-1.noarch.rpm

	4,��װ
		rpm -ivh rabbitmq-server-3.6.5-1.noarch.rpm
			* service rabbitmq-server start
			* service rabbitmq-server stop
			* service rabbitmq-server restart
		* �����װ�쳣,���ڰ�װ�����̨��Ӳ���: --force --nodeps


	5,��������
		chkconfig rabbitmq-server on

	6,���������ļ�
		cd /etc/rabbitmq																		//���������ļ�Ŀ¼
		cp /usr/share/doc/rabbitmq-server-3.4.1/rabbitmq.config.example /etc/rabbitmq/			//����ָ��Ŀ¼�µİ������õ���ǰĿ¼
		mv rabbitmq.config.example rabbitmq.config												//����
	
	7,�����û�Զ�̿ɷ���
		vim /etc/rabbitmq/rabbitmq.config
		 {loopback_users, []}
			* ȥ������ǰ���ע�ͷ���"%%",����ɾ�������Ķ���','

	8,����WEB���������
		rabbitmq-plugins enable rabbitmq_management
		service rabbitmq-server restart

	9,����ǽ����15672�˿�
		/sbin/iptables -I INPUT -p tcp --dport 15672 -j ACCEPT
		/etc/rc.d/init.d/iptables save



	# ���yumԴ�޷���װerlang,����Ҫ���yumԴ֧��
		wget http://packages.erlang-solutions.com/erlang-solutions-1.0-1.noarch.rpm
		rpm -Uvh erlang-solutions-1.0-1.noarch.rpm
		rpm --import http://packages.erlang-solutions.com/rpm/erlang_solutions.asc

		

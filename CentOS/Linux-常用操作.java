-------------------------------
Linux-���ò���					|
-------------------------------
	# �鿴����IP��ַ
		ifconfig

	# �ػ�

	# ����

	# �л���root�˻�
		su root
	
	# ��root���ִ������
		su [����]
	
	# �鿴ָ������İ�����Ϣ
		man [����]
	
	# �鿴ĳ�������ļ�����Ϣ
		man [�����ļ�]
		* ע��,ֱ��д�����ļ�������.����������.��Ҫд·��

	# �鿴ϵͳ�Ѿ��������ж��
		uptime
	
	# ����ִ��һ������
		��ʵ���Ƕ������֮��ʹ�� && ����,������ִ��.ע���пո�
	
	# wget
		* ֱ�Ӵ�Զ�̵ĵ�ַ��������
		* ���� 
			-b								//�ں�̨����
			-O name							//�����ļ����������
			--no-check-certificate			//�����HTTPS����,����ʹ�øò�����
	
	# rpm ��װ�쳣
		warning: rabbitmq-server-3.6.5-1.noarch.rpm: Header V4 RSA/SHA1 Signature, key ID 6026dfca: NOKEY
		error: Failed dependencies:socat is needed by rabbitmq-server-3.6.5-1.noarch

		* �ڰ�װ�������Ӳ���:--force --nodeps
			 rpm -ivh xxxxx.rpm  --force --nodeps
	
	# Linuxֱ���ļ�����
		1,��������
			scp ѡ�� Դ�ļ�/Ŀ¼ �û���@Զ�̵�ַ:/Ŀ���ļ�/Ŀ¼

			scp -P22 -v /usr/local/music.mp3 root@www.kevinblandy.com:/home/kevinblandy/music.mp3

		
		2,������ȡ
			scp ѡ�� �û���@Զ�̵�ַ:/Ŀ���ļ�/Ŀ¼ Դ�ļ�/Ŀ¼ 
			scp root@www.kevinblandy.com:/home/root/others/1.mp3  /home/space/music/1.mp3 
	
		-P	:ָ���˿�(SSH�˿�)
		-v	:��ʾ��ϸ��Ϣ
		-r	:����Ŀ¼

	# ��̨���г���
		* ֱ���ڽű������ & ����
		* �������ַ�ʽ,��ǰ�û��˳��ն�,����ͻ�ֹͣ
		* ʹ�� nohup ����
			nohup [��������] [����]
		* demo
			nohup ./command.sh > output
				* �ѱ�׼���������� output �ļ�
			
			nohup ./command.sh 2> output 
				* �Ѵ���,����� output �ļ�

			nohup ./command.sh > output 2>&1 & 
				* �ѱ�׼����ʹ���,�������output�ļ�
			
			nohup ./command.sh > /dev/null 2>&1 
				* �����е�����������޵׶�
	
	# �鿴��¼��¼
		last
			* �����û�����¼ʱ��
		lastlog
			* ��ǰ�û�����¼ʱ��

	

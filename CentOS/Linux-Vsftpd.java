------------------------
Linux-vsftpd			|
------------------------
	1,��鱾���Ƿ��Ѿ���װVSFTPD
		rmp -qa | grep -i vsftpd
			# ж��:yum -y remove [��ѯ���İ���]
	
	3,���߰�װ
		yum -y install vsftpd
	
	3,�����ļ�
		# �޸������ļ�:/etc/vsftpd/vsftpd.cnf
		anonymous_enable=NO
			> ��ֹ�����û�����
		

		listen=YES
			> ����ΪYES,�����ͻ�������
		
		annon_root=/home/ftp
			>
		
		no_anon_password=YES

		write_enable=YES
		anon_upload_enable=YES
		anon_mkdir_write_enable=YES


vsftpd.cnf
	anonymous_enable=NO
	local_enable=YES
	write_enable=YES
	local_umask=022
	dirmessage_enable=YES
	xferlog_enable=YES
	connect_from_port_20=YES
	xferlog_std_format=YES
	chroot_local_user=YES
	chroot_list_enable=YES
	chroot_list_file=/etc/vsftpd/chroot_list
	listen=YES
		* ��Centos7��Ҫ�޸�ΪNO
	pam_service_name=vsftpd
	userlist_enable=YES
	tcp_wrappers=YES


chroot_list			//д���������,���Է����Լ���Ŀ¼���Ŀ¼,����ļ�����Ҫ�Լ�������
	root
	#ftpuser

ftpusers			//Ҫ��¼����,����д������
	# Users that are not allowed to login via ftp
	#root
	bin
	daemon
	adm
	lp
	sync
	shutdown
	halt
	mail
	news
	uucp
	operator
	games
	nobody

user_list			//Ҫ��¼����,����д������
	#root
	bin
	daemon
	adm
	lp
	sync
	shutdown
	halt
	mail
	news
	uucp
	operator
	games
	nobody



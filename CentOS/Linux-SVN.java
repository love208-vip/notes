------------------------
Linux-SvnServlet		|
------------------------
	1,�鿴�Ƿ�װ��svnserve
		rpm -qa | grep -i svnserve

	2,��װsvn����
		yum -y install subversion

	3,����svn
		service svnserve start
		# SVN��CentOS�еķ���������:'svnserve'

	4,����һ���ֿ�
		svnadmin create /repository
	
	5,�޸�����
		/repository/conf/
	
		svnserve.cnf			//svn��������
			password-db = passwd	
				* ָ��passwd�ļ������õ���Щ�˲��ܷ���SVN������
			anon-access = none
				* �Ƿ�������������(Ĭ��Ϊread,Ҳ����ֻ��)
				* ����Ϊ:none ,��������������
		passwd					//svn�û�������������
			username=password
				* ǰ�����û���,����������
		authz
			username=r			//svn�û���дȨ�޿���
				* ��ָ���û����������Ȩ��

			username=rw
				* ��ָ���û������дȨ��
			--------------------
			[/]
			Litch=rw
			Rocco=r
		
		* 'ע��,���������,ǰ�涼�����пո�,��ȻSVN�޷�����'
		
	6,���ÿ�������
		chkconfig svnserve on
	
	7,�޸�Ĭ�ϼ����˿�
		# svnĬ�϶˿�:3690
	
	8,Centos7�Ļ�,Ҫ�ֶ��Ĵ��� /var/svn Ŀ¼,��Ȼ����ʧ��

	9,Centos7 ����svn 
		svnserve -d -r /repository
	


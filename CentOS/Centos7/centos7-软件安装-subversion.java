--------------------------
subversion					|
--------------------------
	1,��װ
		yum -y install subversion

	2,����Ŀ¼
		mdir /var/svn

	3,��ʼ��һ���ֿ�
		svnadmin create /var/svn/repository
		* repository ���ǲֿ������

	4,����
		* /var/svn/repository/conf/
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
			
			* 'ע��,���������,ǰ�涼�����пո�,��ȻSVN�п����޷�����'

	5,������
		systemctl enable svnserve.service

	6,Զ������
		svn://ip/repository

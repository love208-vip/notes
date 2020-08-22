----------------------------
Svn-Linux��װ				|
----------------------------
	1,�����ĸ���ϵͳ
		yum update

	2,����
		reboot now

	3,��װApache
		yum -y install httpd httpd-devel

		Service httpd start	//����
		chkconfig httpd on	//��������

	4,�޸������ļ�
		/etc/httpd/conf/httpd.conf

		ServerName localhost:80
			* �� ServerName ��Ϊ localhost:80

	5,����80�˿�
		��
	
	6,��װSVN
		yum -y install mod_dav_svn subversion
			*���밲װ mod_dav_svn ģ��,��Ҫ����Apache
		
		* ��װOK�����:/etc/httpd/conf.d Ŀ¼�¶��һ�� subversion.conf �������ļ�
		
	7,����Apache
		Service httpd restart
	
	8,�����Ƿ�װSVNģ��
		ls /etc/httpd/modules | grep svn

		mod_authz_svn.so
		mod_dav_svn.so
		* ������ʾ,��OK

		svn --version
		* �鿴�汾
	
	9,����SVN����Ŀ¼
		* ���ģʽ,һ�������ļ���������
		mkdir /svn
	
	10,�༭�����ļ�
		* ��װ mod_dav_svn �������ļ�
			/etc/httpd/conf.d/subversion.conf

		* ����������������
		#Include /svn/httpd.conf
		<Location /svn/>
			DAV svn
			SVNListParentPath on
			SVNParentPath /svn
				* ��ʾ����Ŀ¼,�Ժ����еĿⶼ�����Ŀ¼����Ŀ¼
			AuthType Basic
			AuthName "Subversion repositories"
			AuthUserFile /svn/passwd.http
				* Svn���û��ļ�,ָ���û���������,��Ҫ�Լ�����
			AuthzSVNAccessFile /svn/authz
				* �û�����Ȩ,��Щ�û����Խ���RW����,��Ҫ�Լ�����
			Require valid-user
		</Location>
		RedirectMatch ^(/svn)$ $1/
			* ����·��
			
	11,���������ļ�
		* ����/svn/passwd.http ��/svn/authz
		touch /svn/passwd.http
		touch /svn/authz
	
	12,����Apache
		service httpd restart

	13,��װJsvnadmin
		Jsvnadmin
			* JAVA������һ������SVN��������Ŀ��WEBӦ��
			* ����OK��,����ͨ��WEB�����������SVN��Ŀ,�û�,Ȩ��
			* ʹSVN�Ĺ����ü�,������ÿ�ζ�ȥ�޸������ļ�
		
			* Svn��Ŀ����������,���������ݿ�(֧��MYSQL/ORACLE)
			* ����Ա�����������Ȩ��
			* '��Ҫ�õ�mysql���ݿ�,���Ҿ���������װ.ר��ΪSVN�ṩ����--����MYSQL��ô��װ,����Ӧ�ʼ�'
		
			* '��Ҫʹ�õ�Tomcat7/8,'
	
	14,��װTomcat
		* ����˵,������.
			1,�޸Ķ˿�(�Ǳ���)
			2,������������
				<Connector port="8080" protocol="HTTP/1.1"
				connectionTimeout="20000"
				redirectPort="8443" URIEncoding="UTF-8" />
		
	15,�ϴ�Jsvnadmin��Tomcat
		svnadmin-3.0.5.zip
		* ��ѹ����и� svnadmin.war,ֱ�Ӳ����������о�OK
	
	16,�޸�WEB-INFĿ¼�µ� jdbc.properties �����ļ�
		* һ���Ͷ�,ָ�������ݿ�,����JDBC��OK
	
	17,���ݿ⵼����Ӧ������
		* ��ʼ�����ݿ��һЩ����
			db/mysql5.sql 
			db/lang/en.sql
		* ��svnadmin-3.0.5.zip�ļ���dbĿ¼��
	
	18,����Tomcat
		��
	
	19,����ҳ��
		http://123.207.122.145:8080/svnadmin/
		* �˴���ʹ��Apache�������Ķ˿ڽ�����Ŀ���ʵ�

	
---------------------------
Jsvnadmin-ʹ��				|
---------------------------
	# �����Ŀ
		��Ŀ
			* �����Զ���
			* demo
		·��
			* ����·��,��SVN��Ŀ¼��ͷ
			* ���,���еĿ�,��Ӧ����svn��ͷ
			* /svn/demo
		URL
			* http://http://123.207.122.145/svn/demo
			* �˿���Apache�����Ķ˿�
		����
			* ��Ŀ�򵥵�����
		
		* ע��,�½���,һ��Ҫ�Ը�Ŀ¼����Ȩ�޲���
			chmod 777 demo

		
	

	

		
	
			
	

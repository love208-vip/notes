----------------------------
MySQL-5.7.x ��װ			|
----------------------------
	1,��װ���뻷��
		yum -y install cmake ncurses ncurses-devel bison bison-devel boost boost-devel
		yum install -y gcc
		yum install -y gcc-c++

	2,Դ�����ص�ַ
		http://ftp.ntu.edu.tw/MySQL/Downloads/MySQL-5.7/
		http://ftp.ntu.edu.tw/MySQL/Downloads/MySQL-5.7/mysql-5.7.17.tar.gz
	
	3,�����ѹĿ¼��,ִ�б�������
		* ���boost���ع���������
		* ����������(tar.gz��)��ָ����Ŀ¼(-DWITH_BOOST����Ŀ¼)
			http://www.boost.org/
			https://nchc.dl.sourceforge.net/project/boost/boost/1.59.0/boost_1_59_0.tar.gz
			http://sourceforge.net/projects/boost/files/boost/1.59.0/boost_1_59_0.tar.gz
				
		cmake \
			-DCMAKE_INSTALL_PREFIX=/usr/local/mysql  \              [MySQL��װ�ĸ�Ŀ¼]
			-DMYSQL_DATADIR=/usr/local/mysql/data  \                   [MySQL���ݿ��ļ����Ŀ¼]
			-DSYSCONFDIR=/etc \                                     [MySQL�����ļ�����Ŀ¼]
			-DMYSQL_USER=mysql \                                    [MySQL�û���]   
			
			-DWITH_MYISAM_STORAGE_ENGINE=1 \                        
			-DWITH_INNOBASE_STORAGE_ENGINE=1 \                      
			-DWITH_ARCHIVE_STORAGE_ENGINE=1 \                       
			-DWITH_FEDERATED_STORAGE_ENGINE=1 \						[MySQL�����ݿ�����]
			-DWITH_BLACKHOLE_STORAGE_ENGINE=1 \
			-DWITH_MEMORY_STORAGE_ENGINE=1 \                        
			-DWITH_PARTITION_STORAGE_ENGINE=1  \				
			
			-DWITH_READLINE=1 \                                     [MySQL��readline library]
			-DMYSQL_UNIX_ADDR=/var/run/mysql/mysql.sock \           [MySQL��ͨѶĿ¼]
			-DMYSQL_TCP_PORT=1124 \                                 [MySQL�ļ����˿�]
			-DENABLED_LOCAL_INFILE=1 \                              [���ü��ر�������]
			-DENABLE_DOWNLOADS=1 \                                  [����ʱ����������������ļ�]
			-DEXTRA_CHARSETS=all \                                  [ʹMySQL֧�����е���չ�ַ�]
			-DDEFAULT_CHARSET=utf8mb4 \                             [����Ĭ���ַ���Ϊutf8]
			-DDEFAULT_COLLATION=utf8mb4_general_ci \                [����Ĭ���ַ�У��]
			-DWITH_DEBUG=0 \                                        [���õ���ģʽ]
			-DMYSQL_MAINTAINER_MODE=0 \
			-DWITH_SSL:STRING=bundled \                             [ͨѶʱ֧��sslЭ��]
			-DWITH_ZLIB:STRING=bundled \                            [����ʹ��zlib library]
			-DDOWNLOAD_BOOST=1 \
			-DWITH_BOOST=/usr/local/mysql/boost_1_59_0				[boost�ⰲװĿ¼]
		
cmake \
-DCMAKE_INSTALL_PREFIX=/usr/local/mysql \
-DMYSQL_DATADIR=/usr/local/mysql/data \
-DSYSCONFDIR=/etc \
-DMYSQL_USER=mysql \
-DWITH_MYISAM_STORAGE_ENGINE=1 \
-DWITH_INNOBASE_STORAGE_ENGINE=1 \
-DWITH_ARCHIVE_STORAGE_ENGINE=1 \
-DWITH_FEDERATED_STORAGE_ENGINE=1 \
-DWITH_BLACKHOLE_STORAGE_ENGINE=1 \
-DWITH_MEMORY_STORAGE_ENGINE=1 \
-DWITH_PARTITION_STORAGE_ENGINE=1 \
-DWITH_READLINE=1 \
-DMYSQL_UNIX_ADDR=/var/run/mysql/mysql.sock \
-DMYSQL_TCP_PORT=1124 \
-DENABLED_LOCAL_INFILE=1 \
-DENABLE_DOWNLOADS=1 \
-DEXTRA_CHARSETS=all \
-DDEFAULT_CHARSET=utf8mb4 \
-DDEFAULT_COLLATION=utf8mb4_general_ci \
-DWITH_DEBUG=0 \
-DMYSQL_MAINTAINER_MODE=0 \
-DWITH_SSL:STRING=bundled \
-DWITH_ZLIB:STRING=bundled \
-DDOWNLOAD_BOOST=1 \
-DWITH_BOOST=/usr/local/mysql/boost_1_59_0
	
	4,����OK��,ִ�б��밲װ	
		make && make install
	
		* ����������ڴ治�������
			dd if=/dev/zero of=/swapfile bs=64M count=16
				//dd if=/dev/zero of=/swapfile bs=1k count=2048000
			mkswap /swapfile
			swapon /swapfile

			�������֮��
			
			swapoff /swapfile
			rm /swapfile -f
	
	5,��MySQL���ݿ�Ķ�̬���ӿ⹲����ϵͳ���ӿ�
		* ����MySQL����Ϳ��Ա��������������
		ln -s /usr/local/mysql/lib/libmysqlclient.so.20 /usr/lib/libmysqlclient.so.20 
	
	6,��ӻ�������
		PATH=/usr/local/mysql/bin:/usr/local/mysql/lib:$PATH
		export PATH
		
		source /etc/profile

	7,���������ű�
		cp /usr/local/mysql/support-files/mysql.server /etc/init.d/mysql
	
	8,�༭�����ļ�
		* �ȸ��Ƶ�Ŀ¼
			cp /usr/local/mysql/support-files/my-default.cnf /etc/my.cnf

		* �༭
			basedir = /usr/local/mysql
			datadir = /usr/local/mysql/data
			port = 1124
			server_id = 1
			socket = /var/run/mysql/mysql.sock 

	9,ִ����Ȩ����
		chown mysql /usr/local/mysql -R
		chmod 775 /usr/local/mysql -R

		mkdir /var/run/mysql
		chown mysql /var/run/mysql -R
		chmod 775 /var/run/mysql -R
	
	10,ִ�����ݿ��ʼ��/���ÿ�������
		mysqld --initialize-insecure --user=mysql --basedir=/usr/local/mysql --datadir=/usr/local/mysql/data 
		chkconfig mysql on
	
	11,����mysql
		service mysql start
		* �������ʧ��,�ȼ���Ƿ�mariadb�Ѿ�ɾ��
			rpm -qa | grep mariadb 
			yum -y remove mariadb-libs-5.5.52-1.el7.x86_64
	
	12,ִ�е�¼/�޸�����
		mysql -uroot
		ALTER USER 'root'@'localhost' IDENTIFIED BY 'new_password';

	13,�޸�����/��¼Ȩ��
		GRANT ALL PRIVILEGES ON *.* TO root@'%' IDENTIFIED BY 'new_password';
		FLUSH PRIVILEGES;
	
	14,�������ʶ˿�
		firewall-cmd --add-port=1124/tcp --permanent 
		firewall-cmd --reload  

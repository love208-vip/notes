


1,��װremi���Դ
	rpm -Uvh http://rpms.famillecollet.com/enterprise/remi-release-6.rpm  
2,�鿴mysql�汾��
	yum --enablerepo=remi,remi-test list mysql mysql-server  
3,��װ
	yum --enablerepo=remi,remi-test install mysql mysql-server  


/etc/init.d/mysqld start			//��������
service mysqld start				//��������(��һ�ַ���)
chkconfig --levels 235 mysqld on	//��������



# /etc/init.d/mysql stop
# mysqld_safe --user=mysql --skip-grant-tables --skip-networking &				//��������Զ�̵�¼
# mysql -u root mysql
	mysql> UPDATE user SET Password=PASSWORD('newpassword') where USER='root';	//����root�û�������
	mysql> FLUSH PRIVILEGES;
	mysql> quit

# /etc/init.d/mysql restart														//����
# mysql -uroot -p
Enter password: <�������������newpassword>




�޸��ַ�����
		[client]
		default-character-set = utf8
		[mysqld]
		character-set-server = utf8
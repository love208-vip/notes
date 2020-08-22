
---------------------
pymysql				 |
---------------------
	* ��������
		1,ͨ�� pymysql ��ȡ connection ���Ӷ���
		2,ͨ�� connection ���Ӷ����ȡ cursor �α����
		3,ͨ�� cursor ִ�� CRUD ����
		4,ͨ�� connection �ύ����

---------------------
pymysql				 |
---------------------
	connect()
		* ��ȡmysql������
		* ��������
			host
				* ���ӵ�ַ
			port
				* ���Ӷ˿�
			user
				* �����û���
			password
				* ��������
			db
				* ���ݿ�����
			charset
				* ���ݿ���ַ���
			cursorclass
				* ��ֵ������ִ�� SELECT �󷵻ص� tuple ���� tuple(Ĭ��) ���� dict(key��DB�ֶ�����)
				* ��ѡֵ
					pymysql.cursors.DictCursor	
						* ������ᱻӳ��Ϊ  dict

---------------------
Connection			 |
---------------------
	cursor(cursor)
		* ��ȡִ��SQL���α�
		* ����������ִ�� SELECT �󷵻ص� tuple ���� tuple(Ĭ��) ���� dict(key��DB�ֶ�����),�ò����߱�Ĭ��ֵ
		* ��ѡ����
			pymysql.cursors.DictCursor	
						* ������ᱻӳ��Ϊ  dict
	autocommit()
		* ���������ύ��ʽ�Ƿ��Զ��ύ,Ĭ���ֶ��ύ
		* ����Ϊ bool ֵ

	begin()
		* ��ʼ����
	commit()
		* �ύ����
	rollback()
		* �ع�����
	close()
		* �ر�����

---------------------
cursor				 |
---------------------
	execute(sql,param)
		* ִ��SQL���
		* parma ��һ������,���sql�е� %s ռλ��
		* ���ؽ�����ܵ�Ӱ�������
	
	executemany(sql,params)
		* ִ��SQL���
		* params ��һ��Ƕ������,��ѭ�������ռλ�� %s ����ִ�� sql
		* ���ؽ�����ܵ�Ӱ�������
		* ���� tuple

	tuple cursor.fetchall()
		* ��ȡ���е�����
		* �α���ƶ������
		* ���� tuple
	
	tuple fetchmany(num)
		* ��ȡָ������������,�α����num����λ
		* ���num������������,��ᱻ����
		* ���� tuple

	tuple fetchone()
		* ��ȡ��һ������,�α���ǰ�ƶ�һ����λ
		* ���α��û�����ݵ�ʱ��,���� None
	
	None scroll(num,mode)
		* �ƶ��α�,num,�����ƶ��ĵ�λ
		* �ؼ��ֲ���
			mode
				* ��ֵ�������α���ƶ�ģʽ
				* relative	�����ڵ�ǰλ�ý����ƶ�
				* absolute	�����ھ���λ�ý����ƶ�
		* demo
			cursor.scroll(-1,mode='relative')
				* �ڵ�ǰλ��,ָ����ǰ�ƶ�һλ
			cursor.scroll(0,mode='absolute')
				* ָ���Ƶ���ͷ
	
	close()
		* �ر��α����

	rowcount
		* ������ֵΪ,�ܵ�Ӱ�������

	lastrowid
		* ������ֵΪִ�� INSERT �����һ����¼��'������idֵ'


				
---------------------
demo				 |
---------------------

import pymysql
import time

db_host = '59.110.167.11'        
db_port = 1124
db_user = 'root'
db_pass = 'KevinBlandy_mysql'
db_database = 'demo'
db_charset = 'utf8mb4'
db_cursorclass = pymysql.cursors.DictCursor

# �������Ӷ���
conn = pymysql.connect(host=db_host,port=db_port,user=db_user,passwd=db_pass,db=db_database,charset=db_charset,cursorclass=db_cursorclass)

# ͨ�����Ӷ���,�����α�
cursor = conn.cursor()

# ͨ���α�ִ�� INSERT ����,������Ӱ�������
for i in range(100):
    affected_rows = cursor.execute('INSERT INTO `demo`(`id`,`name`,`age`,`phone`,`create_date`) VALUES(%s,%s,%s,%s,%s)',(i,'KevinBlandy',23,'18523570974',time.localtime()))

# ͨ���α�ִ�� SELECT ����,���ؼ���������������
cursor.execute('SELECT * FROM `demo`')

#ͨ���α��ȡִ�к�Ľ��
for row in cursor.fetchall():
    print(row)

# ͨ���α�ִ�� UPDATE ����,������Ӱ�������
cursor.execute('UPDATE `demo` SET `name` = %s WHERE `id` = %s',('������',0))

# ͨ���α�ִ�� DELETE ����,������Ӱ�������
cursor.execute('DELETE FROM `demo` WHERE 1=1')
    
# ͨ�����Ӷ���,�ύ����
conn.commit()
# �ͷ�����
conn.close()
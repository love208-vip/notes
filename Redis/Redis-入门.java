-----------------------
Redis-����				|
-----------------------
	* Redis-NoSql���ݿ�
	* MySQL:�ļ��洢��Ӳ����
	* Redis:�ļ��洢���ڴ���,���ǿ������л���Ӳ��
	* ����
		Redis(Remote Dictionary Server,Զ�����ݷ���)����д
		��һ��������˿�����,�ڴ���ٻ������ݿ�
		ʹ��C���Ա�д,����ģ��Ϊkey-value
		֧�ַḻ�����ݽṹ
			String			//�ַ���,�����Ƕ���������
			List			//����ģ����к�ջ�ṹ
			Hash			//��ϣ��
			Set				//���򼯺�
			Sorted			//���򼯺�
		���Գ־û�,��֤�����ݵİ�ȫ
	* ����
		���ݻ���
		ҳ�滺��(smarty)
	* key����������
		* ɶ������,�����ǻ���,�ո�
		* ������,Ҳ�����Լ�����key�ĸ�ʽ
			object-type:id:field
	* ����Ƕ���֧�������ڴ�
		* ���ǰ�Ӳ�̵��ڴ�,��һ�����.��������ڴ�ʹ��
	* ֧�ֲַ�ʽ
		* һ�����
		* һ�Ӷ���
	* ֧�ֶ��ķ�������
	* һ̨������������N�� Redisʵ��
		- ���ز�ͬ�������ļ�����.
		- �����ļ���Ҫ���ò�ͬ�Ķ˿ں�PID�ļ�λ��

-----------------------
Redis-��װ				|
-----------------------
	Linux(CentOS6.4)
		* ���ļ���ͨ��FTP�ϴ���Linux������,������ĳ��Ŀ¼��
		* ��װ��������
			yum -y install gcc tcl
		* tar zxvf redis-x.x.xx.tar.gz	//��ѹ��ɺ������һ���ļ���Ŀ¼��
		* cd redis-x.x.xx				//�����ѹ����ļ���Ŀ¼
			* ���ð�װĿ¼ ./configure --prefix=/usr/local/redis
		* make							//ִ��ִ�б���ָ���
		* make install					//����û������,ִ�а�װ


		* cd src						//����srcĿ¼
			* redis-check-aof			
			* redis-check-dump
			* redis-cli					//�ն˽ű�
			* redis-sentinel
			* redis-server				//����redis����Ľű�
		* mkdir /usr/local/redis		//����reids����Ŀ¼
		* cp redis-cli redis-server /usr/local/redis	//�����ļ�������Ŀ¼
		* cd ..							//�˻ص���ѹ�ļ�Ŀ¼
			* redis.conf				//�����ļ�
		* cp redis.conf /usr/local/redis//���������ļ���redis������Ŀ¼
		* cd /usr/loacl/redis			//����redis����Ŀ¼
		* ./redis-server				//��������,ǰ̨��ʽ
		//��̨����redis����
		* vim redis.conf				//�������ļ�
			* daemonize no				//17�д����Լ,no:����ǰ̨����,yes�����̨����
		* ./redis-server redis.conf		//�������������ļ�,��ʵ��̨�Ѿ�������redis����
		* ps -A | grep redis			//�鿴redis�����Ƿ�����
		//��¼redis����
		* ./redis-cli
		//��¼Զ�̵�redis������
		./redis-cli -h localhost -p 6379 -a password
			* ipĬ��Ϊ����
			* �˿�Ĭ����6379
	Windows
		* ֱ�ӽ�ѹ��OK
		* �ڽ�ѹĿ¼�ֶ��Ĵ��������ļ�:redis.conf
		* ��������
			* ֱ��˫��redis-server.exe ��������
			* ���������ļ���������:redis-server.exe redis.conf
		* ˫��redis-cli �����ͻ���

-----------------------
Redis-֧�ֵ���������	|
-----------------------	
	Strings		(Binary-safe strings)
	Lists		(Lists of binary-safe strings)
	Sets		(Sets of binary-safr strings)
	Sorted sets	(Sorted sets of binary-safe strings)
	Hash

-----------------------
Redis-��������			|
-----------------------	
	redis��������
		redis-server ./redis.conf

	
	redis�رշ���
		1,redis-cli shutdown		//ͨ���ͻ��˹رշ���
		2,killall redis-server		//ͨ���������̹رշ���
		

	1,��Redis�İ�װ���(Դ��)���ص�����,�ϴ���Linux������
	2,��ѹtar.gz�ļ�
		* tar -zxvf redis.tar.gz
		* ��ѹ��ɺ�,���ڵ�ǰ��Ŀ¼����һ��ͬ���ļ���
	3,�����ѹĿ¼,���б���Դ��,���Ұ�װ�ļ�
		* make
		* ���û��װC++�ı��뻷��,��ô��Ҫ�Ƚ��а�װ
	4,����ɹ���,����srcĿ¼
		* һ�󲨶���,���Ӳ���,����Ҫ�ļ����ļ�(��ɫ��)
	5,�Ѽ�����ɫ���ļ����Ƶ�ָ����Ŀ��Ŀ¼
		1,redis-benchmark		//ѹ�����Թ���
		2,redis-check-aof		//���aof�ļ������ԵĹ���
		3,redis-check-dump		//��������ļ��������Թ���
		4,redis-sentinel		//��ؼ�Ⱥ����״̬
		5,redis-server			//�����
		6,redis-cli				//�ͻ���
	6,��Ŀ��Ŀ¼���������ļ�/����Ӱ�װĿ¼���и���
		* redis-conf
	7,��װ���,��������
		* ./redis-server redis.conf			//ָ���������������ص������ļ�

-----------------------
Redis-���ڰ汾��		|
-----------------------
	Redis�İ汾����
		�ΰ汾��(��һ��С����������),Ϊż����,�����ȶ���.Ϊ���������Ƿ��ȶ���
	
	# Windows �ٷ��ǲ�֧��Windosƽ̨��,��������ʹ�õ�Windosƽ̨��Redis,��΢���Լ���github�ϰ�Դ�������,����,����,ά����!
	  ����,windos�� Redis�İ汾������� Linux ��


-----------------------
Redis-��װ-���3.0		|
-----------------------
	1,����
	2,��ѹ
	3,copy �� /usr/local/redisĿ¼
	4,make				//����,�п��ܻ��������.����ȱʡ.��Ҫ��װ����
	5,make install		//��װ
	6,OK~


-----------------------
Redis-��̨����			|
-----------------------
	1,��������������� & ��
		./redis-server ./redis.conf &

	2,�޸������ļ�
		daemonize no				
		* 17�д����Լ,no:����ǰ̨����,yes�����̨����
		redis-server ./redis.conf	


-----------------------
Redis-�����ļ�			|
-----------------------
		port 6379						//ָ���˿�
		pidfile	/var/run/redis.pid		//ָ��PID�ļ���ַ
		daemonize no					//�Ƿ��ں�̨����
		requirepass	xxx					//����Redis����
		slaveof ip port					//��������

		
	
		
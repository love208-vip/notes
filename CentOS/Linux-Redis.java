-----------------------
Redis-��װ				|
-----------------------
	Linux(CentOS6.4)
		* ���ļ���ͨ��FTP�ϴ���Linux������,������ĳ��Ŀ¼��
		* tar zxvf redis-x.x.xx.tar.gz	//��ѹ��ɺ������һ���ļ���Ŀ¼��
		* cd redis-x.x.xx				//�����ѹ����ļ���Ŀ¼
			* ���ð�װĿ¼ ./configure --prefix=/usr/local/redis
		* make							//ִ��ִ�б���ָ���OK
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
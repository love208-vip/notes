1,��������
	https://redis.io/
2,��ѹ
3,�����ѹĿ¼
4,ָ����װĿ¼,����,��װ
	make PREFIX=/usr/local/redis install
	* ע��:PREFIX�Ǵ�д
	* ����ָ��Ŀ¼������Ŀ¼
	bin
		redis-benchmark
		redis-check-aof
		redis-check-rdb
		redis-cli
		redis-sentinel -> redis-server
		redis-server
5,���������ļ���Ŀ¼
	��Դ�ļ�Ŀ¼�¸���
	redis.conf
	* cp ./redis.conf /usr/local/redis/conf/

6,����Ϊ����,���������ļ�
	��ԴĿ¼�¸����ļ��� /etc/ini.d Ŀ¼��,����Ϊredis
	cp ./utils/redis_init_script /etc/init.d/redis

7,�༭����
	vim /etc/init.d/redis

	

	
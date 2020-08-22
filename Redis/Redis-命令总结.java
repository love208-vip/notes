-------------------
Redis-key�Ĳ���		|
-------------------
	set key value NX
		# ���ָ��key�Ѿ�����,��ô�ò������ʧЧ
		# ���ܸ���,����һ������:SETNX key value,�ɹ�����1,ʧ�ܷ���0
	set key value XX
		# ���ָ����key������,��ô�ò������ʧЧ
		# ���븲��
	keys *
		# ����һ�����ʽ��ȡ��ƥ��ɹ���key,�����*��,�򷵻����е�key
	expire key 200
		# ָ��һ��key�Ĺ���ʱ��,����ʱ����ôkey�ᱻɾ��
		# �ò�����λ����,Ҳ����������������Ը���:unixʱ���,�����ʱ�䵥λ����������
		# �Ը�ֵ�����������õ�ʱ��,��ȡ����ʱɾ��

	ttl key
		# ����key��ʣ�����ʱ��
		# �������ֵ��:
			-1,û����������ʱ��,������Ч
			-2,���ʾ��key������,�����Ѿ���ɾ��
	del key
		# ɾ��ָ����key
	del key1 key2...
		# ����ɾ��ָ����key
	getset key newvalue
		# ��ָ����key����һ���µ�value,���ҷ��ؾɵ�value
	exists key
		# ����ָ����key�Ƿ����
		# ���ڷ���1,�����ڷ���0 

	rename oldkey newkey
		# ������key
	dbsize
		# ���ص�ǰ���ݿ��key������
	flushdb
		# ��յ�ǰ���ݿ��е�����key
	flushall
		# ������е����ݿ��е�key
	select index
		# ��ת��ָ�������ݿ�(Ĭ��0-15,һ��16�����ݿ�)
	move key index
		# ��ָ����key�ƶ���ָ���±�����ݿ�
	strlen key
		# ����ָ��key��value�ĳ���(length)
	type key
		# ����ָ�����ݵ�,��������

-------------------
Redis-String����		|
-------------------
	set key value
		# ����ֵ��value,���key�Ѿ�����.��ô�ͻḲ��ԭֵ,value����ѡ��ʹ��˫����(���value�д��ڿո�,��ô����Ҫʹ��˫����)
	setnx key value 
		# ���ָ����key�Ѿ�����,��ô�ò���ʧЧ,��ֹ����
	mset key value key value...
		# һ�������ö��key��value
	msetnx key value key value...
		# һ�������ö��key��value
		# ע��,����ò�������һ��key���Ѿ����ڵ�.��ô,�����������ȫ��ʧЧ
	get key
		# ��ȡָ��key��value
	mget key key key...
		# һ���Ի�ȡ���ָ��key��ֵ
	incr key
		# ��ָ����key��value����++����,���������,��ôĬ�ϸ�key��ֵ0,����+1
		# ���key���������ͷ�����,��ô���׳��쳣
	decr key
		# ��ָ����key����--����,����ͬ��
	incrby key Integer
		# ��ָ��key,���ָ����ֵ
		# ͬ��
	decrby key Integer
		# ��ָ��key��ȥָ��ֵ
		# ͬ��
	append key value
		# ��ָ��key׷��ָ����value
		# ���Զ��ַ���������Ӻ�׺����
	substr key start end
		# ���ؽ�ȡ����ַ���
		# �ӵڼ����ַ���ʼ,���ڼ����ַ�����,������ʼλ��,Ҳ��������λ��
-------------------
Redis-List����		|
-------------------
	# listԪ�ؿ��ظ�
	lpush key string
		# ��key��Ӧ��listͷ������ַ���Ԫ��,ִ�гɹ����ظ�list��Ӻ�ĳ���
		# �����key��list������,��ô�ʹ���
	rpush key string
		# ��key��Ӧ��listβ������ַ���Ԫ��
	lpop key
		# ��listͷ��ɾ��Ԫ��
	rpop key
		# ��listβ��ɾ��Ԫ��
	llen key
		# ����list�ĳ���,key�����ڷ���0,key��Ӧ�����Ͳ���list�ᱨ��
	lrange key start end
		# ����ָ�������ڵ�Ԫ��,�±��0��ʼ
		# ����ʹ�ø���:-1��������һ��,-2������2��...����
		# lrange list 0 -1  :���Ǵӵ�һ����ʼ,��ȡ�����һ��
		# �û�ȡ����,�Ȱ�����ʼԪ��,Ҳ��������Ԫ��
	ltrim key start end
		# ��ȡlist,������ָ��������Ԫ��
	lrem key count value
		# ��ָ���ļ���(key)��ɾ��,ָ��ֵ(value).��������,ɾ��ָ��������(index)		
		# ���countΪ0,��Ӹü�����ɾ������ָ��value��key
	lindex key index
		# ����ָ�����ϵ�ָ���Ǳ��value,�ǲ���ɾ��Ԫ�ص�

-------------------
Redis-Set	����		|
-------------------
	# Ԫ�ز����ظ�
	sadd set value
		# ���һ��Ԫ�ص�set������
		# �ɹ�����1,��Ԫ���Ѿ����ڷ���0
	srem set value
		# ��set���Ƴ�ָ����Ԫ��,�ɹ�����1
	smove set1 set2 value
		# ��set1�ļ������Ƴ�value,��ӵ�set2
	scard set
		# ����set�е�Ԫ�ظ���
	sismember set value
		# �ж�value�Ƿ���ָ����set��
	sinter set set...set
		# ��������set�Ľ���
	sunion set set...keyn
		# ��������set�Ĳ���
	sdiff set set ...set
		# ��������set�Ĳ
	smembers set
		# ����key��Ӧ��set������Ԫ��,���ؽ������,������˳��һ��
	
-------------------
Redis-SortedSet	����	|
-------------------
	# ���������set,ÿ��value������һ��Ȩ��
	zadd key score value
		# ���Ԫ�ص�����,Ԫ���ڼ����д�������¶�Ӧscore
		# score,Ҳ�������������ֵ,��˵�е�Ȩ��
		# ������ֵͬ�Ĵ���,���ǲ�����member��ͬ,�Ѿ����ڻᱻ�滻��
	zrem key value 
		# ɾ��ָ��Ԫ��,1.��ʾɾ���ɹ�,���Ԫ�ز����ڷ���0
	zincrby key incr value
		# ����incr�������Ӷ�Ӧvalue��scoreֵ,�������Ӻ�scoreֵ
	zrank key value
		# ����ָ��Ԫ���ڼ����е�����(�±�),����Ԫ���ǰ���С���������
	zrevrank key value
		# ͬ�ϵ���ʱ�ļ���ȷʵ�Ӵ�С�����
	zrange key start end
		# ����lrange �����Ӽ�����ָ�������Ԫ��,���ص���������,Set����������
		# ע��,�����ʼ����ֵ���±�
	zrevrange key start end
		# ͬ��,���ؽ���������
	zcard key
		# ���ؼ�����Ԫ�صĸ���
	zscore key value
		# ���ظ���Ԫ�ض�Ӧ��score 
	zremrangebyrank key min max
		# ɾ��������,ָ���±��Ԫ��,�����Ǵ�С��������ġ�
		# �Ұ�����ʼ,Ҳ��������
	
-------------------
Redis-Hash	����		|
-------------------
	hset key filed value
		# ����hash��fielΪָ��ֵ,���key������,���ȴ���
	hmset key filed1 value1...filedn valuen
		# ͬʱ��ָ����key���ö��ֵ
	hget key filed
		# ��ȡָ����hash��ָ��,field��value
	hmget key filed1...filedn
		# ��ȡ���ָ����hash filed
	hincrby key filed integer
		# ��ָ��Key��ָ��filed,����ָ����ֵ
	hexists key filed
		# ����ָ��key��ָ��filed�Ƿ����,���ڷ���1,�����ڷ���0
	hdel key filed
		# ɾ��ָ��key��ָ��filed
	hlen key
		# ����ָ��key��filed����
	hkeys key
		# ����ָ��key������filed
	hvals key
		# ����ָ��key������filed��ֵ
	hgetall key
		# ����ָ��key������filed��value
		# ���ص����ݸ�ʽ,��һ��Ϊkey,�ڶ���Ϊvalue,������Ϊkey,���ĸ�Ϊvalue... ...����


	
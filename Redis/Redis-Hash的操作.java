-----------------------
Redis-Hash�Ĳ���		|
-----------------------
	* Hash,�������ʹ洢��������mysql���ݿ��д洢��һ����¼�ǳ�����
	* �����ﲻ�漰�㷨֮���,�����Ǹ��������Ͷ���

	
	hset key filed value
		* ����hash��fielΪָ��ֵ,���key������,���ȴ���
	hmset key filed1 value1...filedn valuen
		* ͬʱ��ָ����key���ö��ֵ
	hget key filed
		* ��ȡָ����hash field
	hmget key filed1...filedn
		* ��ȡȫ��ָ����hash filed
	hincrby key filed integer
		* ��ָ��Key��ָ��filed,����ָ����ֵ
	hexists key filed
		* ����ָ��key��ָ��filed�Ƿ����,���ڷ���1,�����ڷ���0
	hdel key filed
		* ɾ��ָ��key��ָ��filed
	hlen key
		* ����ָ��key��filed����
	hkeys key
		* ����ָ��key������filed
	hvals key
		* ����ָ��key������filed��ֵ
	hgetall key
		* ����ָ��key������filed��value
	

	* key ����һ������,filed,������������
	* key Ҳ���������һ������,������ֶ�(filed)������������,���Բ�������value
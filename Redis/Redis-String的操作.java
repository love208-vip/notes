-----------------------
Redis-string����		|
-----------------------
	* string ��redis�����������
	  redis��string���԰����κ�����:ͼƬ(����������),���л��Ķ���
	  ����valueֵ����������1GB
	  �������ֻ��string����,redis�Ϳ�������Ǽ����˳־û����ܵ�memcache
	set key value
		* ������,ֵ������string
	mset key1 value1 key2 value2 ..keyn valuen 
		* һ������N��
	mset key1 key2...keyn
		* һ�λ�ȡ���
	incr key
		* ��key��ֵ��++������,������ֵ
		* ���key�������ֵĻ�,�ᱨ��
		* ���Բ�����key,���߾�key.�������key,�Ǻ���Ȼֵ����1��
	decr key
		* ��key��ֵ��--������,������ֵ
		* ͬ��
	incrby key Integer
		* ��ָ��key,���ָ����ֵ
		* ͬ��
	decrby key Integer
		* ��ָ��key��ȥָ��ֵ
		* ͬ��
	append key value
		* ��ָ��key׷��ָ����value
	substr key start end
		* ���ؽ�ȡ����ַ���
		* �ӵڼ����ַ���ʼ,���ڼ����ַ�����,������ʼλ��,Ҳ��������λ��
	
-----------------------
Redis-Set���ϵĲ���		|
-----------------------
	* Redis ��set ��String���͵�'���򼯺�'(��JAVA�ǲ��Ǻ���)
	* Set���Ͽ��԰���2��32����-1��Ԫ��
	* ���˻�������ɾ�Ĳ����֮��,����'�������ϵ�ȡ����'����
	* ���н���,��Ȳ���
	* ÿ�������е�Ԫ��,�����ظ�
	
	sadd key value
		* ���һ��Ԫ�ص�key��Ӧ��set������

		* �ɹ�����1,��Ԫ���Ѿ����ڷ���0,������set������,�׳��쳣

	srem key value
		* ��key��Ӧ��set���Ƴ�������Ԫ��,�ɹ�����1

	smove key1 key2 value
		* ��key1�ļ������Ƴ�value,��ӵ�key2

	scard key
		* ����setԪ�صĸ���

	sismember key value
		* �ж�value�Ƿ���ָ����set��

	sinter key1 key2...keyn
		* ��������key�Ľ���

	sunion key1 key2...keyn
		* ��������key�Ĳ���

	sdiff key1 key2 ...keyn
		* ��������key�Ĳ

	smembers key
		* ����key��Ӧ��set������Ԫ��,���ؽ������
	

	//�Բ�,�����ñʼǱ����̸о��ò���Ϥ������
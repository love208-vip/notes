-----------------------
Redis-List�������		|
-----------------------
	* List ��������
	* ��ʵ�� LinkedList ����ͬ��

	lpush key string
		* ��key��Ӧ��listͷ������ַ���Ԫ��

	rpush key string
		* ��key��Ӧ��listβ������ַ���Ԫ��

	lpop key
		* ��listͷ��ɾ��Ԫ��

	rpop key
		* ��listβ��ɾ��Ԫ��

	llen key
		* ����list�ĳ���,key�����ڷ���0,key��Ӧ�����Ͳ���list�ᱨ��

	lrange key start end
		* ����ָ�������ڵ�Ԫ��,�±��0��ʼ

	ltrim key start end
		* ��ȡlist,������ָ��������Ԫ��
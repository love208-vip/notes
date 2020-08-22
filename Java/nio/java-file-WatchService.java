-----------------------
�ļ�����				|
-----------------------
	# ����ĳ��Ŀ¼
		* �ļ�����
		* ɾ��
		* �޸�

-----------------------
Demo					|
-----------------------
	//WatchService ���̰߳�ȫ�ģ������ļ��¼��ķ���һ�����ö����߳���������
    public static void watchRNDir(Path path) throws Exception {
        //���� WatchService ����
        WatchService watchService = FileSystems.getDefault().newWatchService();
        //��path·�������ļ��۲����
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
        // ��ʼ����·��
        while (true) {
            //�߳�����
            final WatchKey key = watchService.take();
            //��ȡ�¼�����
            List<WatchEvent<?>> watchEventList = key.pollEvents();
            //����
            for (WatchEvent<?> watchEvent : watchEventList) {
                // ��ȡ�¼�
                final WatchEvent.Kind<?> kind = watchEvent.kind();
                // handle OVERFLOW event
                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }
                //�����¼�
                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {

                }
                //�޸��¼�
                if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {

                }
                //ɾ���¼�
                if (kind == StandardWatchEventKinds.ENTRY_DELETE) {

                }
                //�ѵ�ǰ�¼�ǿ��ת������Ϊ Path ���¼�
                final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
                //��ȡ�¼��ļ�����
                final Path filename = watchEventPath.context();
                // print it out
                System.out.println(kind + " -> " + filename);
            }
            // reset the keyf
            boolean valid = key.reset();
            // exit loop if the key is not valid (if the directory was
            // deleted, for
            if (!valid) {
                break;
            }
        }
    }
------------------------------------
WatchService						|
------------------------------------	
	# ����
		WatchService watchService = FileSystems.getDefault().newWatchService();
	# ����
		WatchKey		take();
			* �������Ƴ���һ��watch key����û�пɼ�������������

------------------------------------
WatchKey							|
------------------------------------	
	# ����
		ͨ�� WatchService ʵ���� take()������ȡ
	# ����
		List<WatchEvent<?>>		pollEvents();
			* �������Ƴ����и�watch key

------------------------------------
WatchEvent							|
------------------------------------
	# ����
	# ����
		Kind<?>			kind();
			* �����¼�����
		

------------------------------------
Kind								|
------------------------------------
	# ����
		String	name();
			* �����¼�������
	
------------------------------------
StandardWatchEventKinds				|
------------------------------------	
	# �¼���
	# ��̬�ֶ�
		OVERFLOW
		ENTRY_CREATE	
		ENTRY_DELETE
		ENTRY_MODIFY


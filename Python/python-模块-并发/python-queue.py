----------------------------
queue						|
----------------------------
	* Python�Դ�����Ϣ����ģ��
	* ģ���е���Ϣ������
		Queue
		LifoQueue
		PriorityQueue
		

----------------------------
queue-ģ������				|
----------------------------

----------------------------
queue-ģ�麯��				|
----------------------------
	Queue(maxsize=0)
		* �Ƚ��ȳ�
		* ��������,maxsize ָ��������Ϣ����

	LifoQueue(maxsize=0)
		* ������
		* ��������,maxsize ָ��������Ϣ����

	PriorityQueue(maxsize=0)
		* ����������Ϣ���ȼ��Ķ���
		* ��������,maxsize ָ��������Ϣ����

----------------------------
queue.Queue					|
----------------------------
	* ʵ��API
		None put(item, block=True, timeout=None)
			* ������ݵ���Ϣ����
			* ��������Ѿ�������,�÷���������
			* Ĭ�ϲ���
				block:��ֵĬ���� True,����� False,��ô��ִ��put��ʱ��,�����������,���׳��쳣������
		bool full()
			* �ö����Ƿ��Ѿ�װ��������
		bool empty()
			* �ö����Ƿ��ǿն���
		int qsize()
			* ������Ϣ����
		item get(block=True, timeout=None)
			* ��������,���̻߳�����,ֱ���յ�����Ϊֹ
			* Ĭ�ϲ���
				block:��ֵĬ���� True,����� False,��ô��ִ��get��ʱ��,�������û������,���׳��쳣������

		item get_nowait()
			* ��������,�̲߳�������,���û�����ݻ��׳��쳣

----------------------------
queue.LifoQueue				|
----------------------------
	* ʵ��API
----------------------------
queue.PriorityQueue			|
----------------------------
	* ʵ��API
		None put(tuple)
			* ������һ��Ԫ��
			* ��һ��Ԫ�ؾ��� int ���͵�Ȩ�� ,�ڶ���Ԫ���� item 
		
		tuple get(block=True, timeout=None)
			* ��������,���̻߳�����,ֱ���յ�����Ϊֹ
			* Ȩ��ԽС��,�ͻ�Խ�ȱ�����

	
	* demo
		import queue
		q = queue.PriorityQueue()
		q.put((1,'Kevin'))
		q.put((9,'Litch'))
		q.put((5,'Rocco'))
		print(q.get())# (1, 'Kevin')
		print(q.get())# (5, 'Rocco')
		print(q.get())# (9, 'Litch')



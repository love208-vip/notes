----------------------------
Selector					|
----------------------------
	# ��·������,����NIO��̵Ļ���,�ǳ���Ҫ.��·������,�ṩ'ѡ���Ѿ����������������'
	# ��˵,Selector �᲻�ϵ���ѯ,ע�������ϵ�ͨ�� Channel,���ĳ��ͨ�������˶�д����.���ͨ���ʹ��ھ���״̬.�ᱻ Selector ��ѯ����,Ȼ��ͨ�� SelectionKey ���� ȡ�þ����� Channel ����,�Ӷ����к����Ĳ���
	# һ����·������,���Ը����ǧ����� Channel ͨ��,û������.��Ҳ��JDKʹ�� epoll�����˴�ͳ Selectʵ��,��ȡ���Ӿ��û������,��ζ������ֻ��Ҫһ���̸߳��� Selector ����ѯ.�Ϳ��Խ����ǧ����Ŀͻ���,�����JDK NIO��ľ޴����
	# Selector �߳̾�������һ��������(Master),�����ǧ���ͨ��,Ȼ����ѯ���ĸ�ͨ���Ѿ�׼����.֪ͨCPUִ��I/O����
	# Selector ģʽ:��IO�¼�(�ܵ�)ע�ᵽѡ������,Selector ������ÿ���ܵ�һ�� key ֵ,��ǩ.Selector ��ѯע��Ĺܵ�,���ܵ�������, select�ͻ�ʶ��,ͨ��keyֵ���ҵ���Ӧ�Ĺܵ�.����������ݴ������.(д��,���߶���������)
	# ÿ���ܵ������ѡ����ע�᲻ͬ���¼�״̬,�Ա�ѡ��������

		SelectionKey.OP_ACCEPT	//�����׽��ֽ��ܲ����Ĳ�����λ��
		SelectionKey.OP_CONNECT //�����׽������Ӳ����Ĳ�����λ��
		SelectionKey.OP_READ	//���ڶ�ȡ�����Ĳ�����λ��
		SelectionKey.OP_WRITE	//����д������Ĳ�����λ��
	
	# Selector�����̴߳����� Channel��
	# ������Ӧ�ô��˶�����ӣ�ͨ��������ÿ�����ӵ��������ܵͣ�ʹ��Selector�ͻ�ܷ��㡣
	# ���磬��һ������������С�������һ�����߳���ʹ��һ��Selector����3��Channel��ͼʾ��
				Thread
				  |
			   Selector
			|----|----|
		Channel Channel Channel
	
----------------------------
Selector-����				|
----------------------------
	Selector selector = Selector.open();

----------------------------
Selector-ע��ͨ��(Channel)	|
----------------------------
	# Ϊ�˽�Channel��Selector���ʹ�ã����뽫channelע�ᵽselector�ϡ�
	# ��Selectorһ��ʹ��ʱ��Channel���봦�ڷ�����ģʽ�¡�
	# ����ζ��'���ܽ�FileChannel��Selectorһ��ʹ�ã���ΪFileChannel�����л���������ģʽ�����׽���ͨ��������'��
	# ͨ��SelectableChannel.register()������ʵ��

		Selector selector = Selector.open();
		channel.configureBlocking(false);		//���÷�����ģʽ
		SelectionKey key = channel.register(selector,Selectionkey.OP_READ);

		* ��һ������,���� channel Ҫע��� selector
		* �ڶ�������,�Ǽ������¼�,ö��ֵ,��˼����ͨ��Selector����Channelʱ��ʲô�¼�����Ȥ�����Լ������ֲ�ͬ���͵��¼���
			SelectionKey.OP_ACCEPT	
			SelectionKey.OP_CONNECT 
			SelectionKey.OP_READ	
			SelectionKey.OP_WRITE

	# ͨ��������һ���¼���˼�Ǹ��¼��Ѿ�������
		* ĳ��channel�ɹ����ӵ���һ����������Ϊ"���Ӿ���"��
		* һ��server socket channel׼���ý����½�������ӳ�Ϊ"���վ���"��
		* һ�������ݿɶ���ͨ������˵��"������"��
		* �ȴ�д���ݵ�ͨ������˵��"д����"��
	
	# �����Ҫע�����¼�,����λ�Ʋ����������¼�
		int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;


----------------------------
Selector-SelectionKey		|
----------------------------
	# ����Selectorע��Channelʱ��register()�����᷵��һ��SelectionKey����������������һЩ����
		interest����
		ready����
		Channel
		Selector
		���ӵĶ��󣨿�ѡ��
	
	# interest����
		interest����������ѡ��ĸ���Ȥ���¼����ϡ�����ͨ�� SelectionKey ��дinterest����
		int interestSet = selectionKey.interestOps();
		boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
		boolean isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
		boolean isInterestedInRead    = interestSet & SelectionKey.OP_READ;
		boolean isInterestedInWrite   = interestSet & SelectionKey.OP_WRITE;
		
		* ���Կ�������"λ��"����interest ���Ϻ͸�����SelectionKey����������ȷ��ĳ��ȷ�����¼��Ƿ���interest �����С�
	
	# ready����
		# ready ������ͨ���Ѿ�׼�������Ĳ����ļ��ϡ�
		# ��һ��ѡ��(Selection)֮��������ȷ������ready set��Selection������һС�ڽ��н��͡�������������ready����
			int readySet = selectionKey.readyOps();
		# ����������interest���������ķ����������channel��ʲô�¼�������Ѿ����������ǣ�Ҳ����ʹ�������ĸ����������Ƕ��᷵��һ����������
			selectionKey.isAcceptable();		//�Ƿ���Խ��տͻ��˵�����
			selectionKey.isConnectable();		//�Ƿ��пͻ�������
			selectionKey.isReadable();			//�Ƿ�ɶ�
			selectionKey.isWritable();			//�Ƿ��д

	# ���� Channel �� Selector
		Channel  channel  = selectionKey.channel();
		Selector selector = selectionKey.selector();
	

	# ���ӵĶ���
		* ���Խ�һ��������߸�����Ϣ���ŵ�SelectionKey�ϣ��������ܷ����ʶ��ĳ��������ͨ����
		* ���磬���Ը�����ͨ��һ��ʹ�õ�Buffer�����ǰ����ۼ����ݵ�ĳ������ʹ�÷������£�
			selectionKey.attach(theObject);						//���ø��Ӷ���
			Object attachedObj = selectionKey.attachment();		//��ȡ���Ӷ���
		* Ҳ������ͨ��ע���ʱ�����ø��Ӷ���('���һ������')
			SelectionKey key = channel.register(selector,Selectionkey.OP_READm,attachedObj);

	# API
		
----------------------------
Selector-ѡ��ͨ��			|
----------------------------
	# һ����Selectorע����һ����ͨ�����Ϳ��Ե��ü������ص�select()������
	# ��Щ����������������Ȥ���¼��������ӡ����ܡ�����д���Ѿ�׼����������Щͨ����
	# ���仰˵�������ԡ�����������ͨ������Ȥ��select()�����᷵�ض��¼��Ѿ���������Щͨ����
	#��select ����
		int select();
			* ������������һ��ͨ������ע����¼��Ͼ����ˡ�
		int select(long timeout);
			* ��select()һ���������������timeout����(����)��
		int selectNow();
			* ��������������ʲôͨ�����������̷���
			* �˷���ִ�з�������ѡ�����������Դ�ǰһ��ѡ�������û��ͨ����ɿ�ѡ��ģ���˷���ֱ�ӷ����㡣

----------------------------
Selector-API				|
----------------------------
	
----------------------------
�������					|
----------------------------
	# ping,Pong
	# ������Я�� 125 �ֽڴ�С������,��ʵ��,��Ӧping��Ϣ��pong��Ϣ�е���������С,������ping��Ϣ��ͬ
	# ���ڲ��������Ƿ�����,����������'�������ӵĻ�Ծ',��Ϊһ����ʱ,���Ӿͻᱻ�ر�
		long session.getMaxIdleTimeout();
	
	# Ping��Ϣ�Ĵ���
		* ����Ping
			* ���յ�ping��Ϣ��ʱ��,WebSocketʵ�ֻ�Ĭ�ϵ���Ӧpong��Ϣ,�����ֶ���ȥ����ping��Ϣ�Լ��ֶ��Ľ���pong��Ϣ��Ӧ

		* ����Ping��Ϣ
			void RemoteEndopoint.sendPing(ByteBuffer applicationData) throws IOException, IllegalArgumentException;
		
	
	# pong��Ϣ�Ĵ���
		* ע��ʽ����
			@OnMessage
			public void catchPong(PongMessage pongMessage){
				//TODO
			}
		
		* ���ʽ����
			PongMessage
			session.addMessageHandler(new MessageHandler.Whole<PongMessage>() {
				public void onMessage(PongMessage message) {
					//TODO
				}
			});
		
		* ����pong��Ϣ
			* ����������pong��Ϣ,��ʵ����Ϊһ�൥������
			* �Ǳ������ӵ�һ�ַ�ʽ,����������̽ʧЧ������
			* 'WebSocket�ж���,pong��Ϣ����һ��û������Ҫ��������pong��ϢӦ��,���Ե������ķ�����pong��Ϣ,һ���ָ������Ӧ��'
			* '��Ȼ,��Ҳ����ȥ����pong��Ϣ(����������),Ȼ���ֶ��ĵ���API��Ӧ'
				void RemoteEndopoint.sendPong(ByteBuffer applicationData) throws IOException, IllegalArgumentException;

----------------------------
��Ϣ������					|
----------------------------
	# �ڷ�����Ϣ��ʱ��,Ӧ����Ϊ�Ѿ��������Ϣ�ķ���.��ʵû��,��Ϣ���ɼ�����
	# ���ɼ�����Ϣ����ĳ���ٽ���,�ͻᰴ��˳�����ͳ�ȥ
	# ���ַ�ʽ�������һ��������,�������Ҫ�ü���,��Ҫ����һ��API
		* RemoteEndpoint
			void setBatchingAllowed(boolean allowed) throws IOException;
		* ������Ҫ��֤����,WebSocker��ʵ��(Servlet����)֧����Ϣ��������,��Ȼ�����ǵ�����Ҳû��
	
	# ��ص�API
		* RemoteEndpoint
			void setBatchingAllowed(boolean allowed) throws IOException;
				* ������Ϣ������
			boolean getBatchingAllowed();
				* �Ƿ�������Ϣ������
			void flushBatch() throws IOException;
				* ǿ��ˢ����Ϣ���������Ѿ��ɼ�,δ���͵���Ϣ

	# ��ʹ����Ϣ�������ʱ��,�ܴ����ܸĽ�,��������������
		* Ӧ�÷�����Ϣ�Ĵ�С
		* Ӧ�÷�����Ϣ��Ƶ��
		* Ӧ�÷�����Ϣ���ض�����
		* ������Ϣ�ĶԵȶ�WebSocketʵ�ֵ���������
	
	# ���첽��Ϣ�����������ʱ��
		* SendHandler�Ļص���Future��get()��������Ϣ��д���������ʱ��ͷ���
		* ������ʵ�����Ѿ�����Ϣд��ײ�����,Ҳ�п���ûд��

----------------------------
����,��Ϣ��Ƭ,����֡		|
----------------------------
	# WebSocketЭ����԰��ı���Ϣ,��������Ϣ���Ϊһϵ�е�С����֡
	# ʹ�ÿ��Ի�����������������������WebSocker�����Ͻ���ʵ�ʵķ���
	# ע��ʽ
		@OnMessage		//��Ƭ��Ϣ
		public void (String message,boolean isLast){}
			* ͨ���÷�����ȡ������Ƭ��,�����͵�Ƭ���п��ܲ�һ��
			* �յ���Ƭ��,Ҳ���Ƕ��Ƭ����ɵ�Ƭ��,ֻҪ�����һ�� isLast ���� true
		@OnMessage		//�Ƿ�Ƭ��Ϣ
		public void (String message){}
			* ���ͨ������Ϣ����ȡ����Ƭ��
			* WebSocketʵ��û��ѡ��,ֻ�������ڲ�����������е�Ƭ�κ�,�����ø÷���
	
	# ���ʽ
		MessageHandler.Partial<T>		//��Ƭ��Ϣ
		void onMessage(T messagePart, boolean last);
			* ͬ��
		MessageHandler.Whole<T>			//�Ƿ�Ƭ��Ϣ
		void onMessage(T messagePart);
			* ͬ��
	
	# ������Ϣ�������Ĵ�С
		* ��һ�ַ�ʽ,���ڱ��ʽ��ע��ʽ��������,ͨ��Session��API�����
			Session
				int session.getMaxBinaryMessageBufferSize();
					* ����Ķ�������Ϣ����󳤶�
				int session.getMaxTextMessageBufferSize();
					* ������ı���Ϣ����󳤶�
		
		* �ڶ��ַ�ʽ,����ע��ʽ����
			@OnMessage ע���һ������
				public long maxMessageSize() default -1;
			
			* ��ֵĬ��Ϊ-1,��ʾû������,��λ���ֽ�

----------------------------
��֤��Ϣ����				|
----------------------------
	# WebSocketЭ�鲢���ܱ�֤�����͵�WebSocket��Ϣ�ܹ������ӵ���һ����ȷ�Ľ���
	# �ڴ�����������,������Ϣ�з�������,WebSocketʵ�ֽ���֪��,������Ϣ��û�д��ݸ���һ��,��û���κδ�����������Ҳ�з���
	# �ڱ��ʱ����ĳ�ֻ�ִ,��ʾ�ɹ��Ľ��յ��ķ����ߵ���Ϣ
	# �� @OnMessage ��������ӷ���ֵ




--------------------------------
WebSocket-��������				|
--------------------------------
	# ���¼�
	# ��Ϣ�¼�
	# �����¼�
	# �ر��¼�

--------------------------------
WebSocket-ע��					|
--------------------------------
	@OnOpen
		# ����
			Session
			EndpointConfig
			@PathParam

	@OnMessage
		# ���ý�����Ϣ�Ĳ���
			String
				* �����ı���Ϣ
			byte[]
				* �����������Ϣ
			ByteBuffer
				* �����������Ϣ
			PongMessage(�ӿ�)
				|-WsPongMessage(ʵ��)
				* ����pong��Ϣ
			InputStream
				* ��������
			Reader
				* �ı���
			Object
				* �Լ���װ����Ϣ����('�߼�����'),��Ҫ������
			Integer,Double....
				* �����������͵İ�װ��,�ᱻ�ڲ�Ԥ����Ľ���������ɽ���
			boolean isLast
				* ����Ϣ����Ƭ��ʱ��,������滹����Ϣ,���ֵΪ false,��ǰ��ϢΪ���һ����Ϣ,��ֵΪ true	
				* '�ò�����������û���κ�����,������ֻ����':String,byte[],ByteBuffer ����������������ڲ�����Ϣ��Ƭ������

		# ��������
			Session
			EndpointConfig

		# ��������
			* �������з���ֵ��ʱ��,websocket��ʵ��,�����ѷ����ķ���ֵ��Ϊ��Ϣ���ظ��ͻ���
			String
				* ���ͻ����ı�����
			byte
				* ���ͻ��˶���������
			ByteBuffer
				* ���ͻ��˶���������
			Integer,Double....
				* �����������͵İ�װ��,�ᱻ�ڲ�Ԥ����Ľ���������ɽ���
			Object
				* �Լ���װ�Ķ���('�߼�����'),��Ҫ������

    @OnError
		# ����
			Throwable
				* �������쳣����
	
	@OnClose
		# ����
			CloseReason
				* �����ر�ԭ��,�ȵȴ�������Ϣ
			

--------------------------------
WebSocket-���ʽ				|
--------------------------------
	# �̳� Endpoint ������
		* ֻ��Ҫ��д onOpen ��������,����������ʵ�ǿ�ʵ��

	public abstract void onOpen(Session session, EndpointConfig config);

	public void onClose(Session session, CloseReason closeReason) {|

	public void onError(Session session, Throwable thr) {}
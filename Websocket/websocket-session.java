----------------------------
Sesssion					|
----------------------------
	# ÿ���µ����Ӷ��ᴴ���µ�Session
	# ÿ��Session�ڵ�ǰ��Endpoint����һ��Ψһ��IDֵ
		* ����ͨ�� getId();����ȡ
		* 'ͬһ��������򿪶����ͬҳ��idֵ������ͬ,����.ͬһ��ҳ��,F5ˢ�º�,IDֵҲ�᲻ͬ,Ҳ����˵���Ӳ�ͬ��,F5֮ǰ�����ӻᱻ�رյ�'
		* '0-9','a-f','1a-1f','20-29','2a-2f','30-39','3a-3f'... ...

----------------------------
Sesssion-MessaegHandler		|
----------------------------
	# ��Ȼ������ڱ��ʽ����,ע��ʽ������MessageHandler����ʽ��
	# ���MessageHandler ����ǰSession
		public void addMessageHandler(MessageHandler handler) throws IllegalStateException;
			* ���һ����Ϣ������,�����Ƿ�Ƭ��Ϣ���߷Ƿ�Ƭ��Ϣ
		public <T> void addMessageHandler(Class<T> clazz, MessageHandler.Whole<T> handler);
			* ���һ���Ƿ�Ƭ��Ϣ������
		public <T> void addMessageHandler(Class<T> clazz, MessageHandler.Partial<T> handler);
			* ���һ����Ϣ��Ƭ������

	# ��ȡ���е�MessageHandler
		Set<MessageHandler> getMessageHandlers();
		
	# �Ƴ�һ��MessageHandler
		void removeMessageHandler(MessageHandler handler);

----------------------------
Sesssion-RemoteEndpoint		|
----------------------------
	RemoteEndpoint.Basic getBasicRemote();
		* ��ȡ RemoteEndpoint.Basic ����

	RemoteEndpoint.Async getAsyncRemote();
		* ��ȡ RemoteEndpoint.Async ����

----------------------------
Sesssion-Session����		|
----------------------------
	boolean session.isOpen();
		* �÷����жϵ�ǰ�����Ƿ��Ѿ��ر�
	Set<Session> getOpenSessions();
		* ��ȡ��ǰ�˵������Ѿ��򿪵���������
	void close() throws IOException;
		* �ر�session
		* �ڹر���Session��,���ô������SessionAPI�����׳��쳣
	void close(CloseReason closeReason) throws IOException;
		* �ر�session,���Ҵ���ԭ��,����������

----------------------------
Sesssion-����				|
----------------------------
	int session.getMaxBinaryMessageBufferSize();
		* ����Ķ�������Ϣ����󳤶�
	int session.getMaxTextMessageBufferSize();
		* ������ı���Ϣ����󳤶�
	long session.getMaxIdleTimeout();
		* ������ʱ��,��ʱ��Socket�ᱻ�ر�
	List<Extension> session.getNegotiatedExtensions();
		* �������ڼ�Э�̺õ�WebSocket��չ�б�
		* '��ֵ�����޸�'
	String session.getNegotiatedSubprotocol();
		* �������ڼ�Э�̺õ�WebSocket��Э���б�
		* '��ֵ�����޸�'
	String session.getProtocolVersion();
		* ʹ�õ�WebSocket����Э��汾
		* '��ֵ�����޸�'
	Principal session.getUserPrincipal();
		* �Ѿ���֤���û��� Java UserPrincipal
		* '��ֵ�����޸�'
	boolean session.isSecure();
		* �ײ������Ƿ����
	Map<String, Object> getUserProperties();
		* �ײ������д���µ�map

	
----------------------------
Sesssion-·������			|
----------------------------
	URI getRequestURI();
		* ��ȡ�����������WEBӦ�������ĸ������·��
		* @Endpoint(value="/test");
		* ws:/ip/��Ŀ��/test?k=v
		* url = "/��Ŀ��/test?k=v"
	
	Map<String, String> getPathParameters();
		* ��ȡģ��·����ӳ��ֵ
		* @Endpoint(value="/test/{k1}/{k2}");
		* ws:/ip/test/v1/v2							
		* map = [k1:v1,k2:v2]
		* ע��ʽ�����Ļ�,ģ��ֵ���Ը��� @PathParam ע������ȡ
	
	String getQueryString();
		* ��ȡ��������Ĳ���,���ǽ�ȡ�ʺź�����ַ���
		* @Endpoint(value="/test");
		* ws:/ip/test?k=v
		* string = "k=v";
	
	Map<String, List<String>> getRequestParameterMap();
		* ��ȡ����Ĳ���
		* ��ʵ���������Ǹ����еķ�װ.ÿ��keyҲ����ж������,����value�� List ��ʽ

	


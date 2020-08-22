---------------------------
ע��						|
---------------------------
	@ServerEndpoint
		# ��ʾ��ǰ����һ�� WebSocket ������
		# ����ÿ��WebSocket������,���ᴴ���µĶ���ȥά��(��ζ��,����ͨ����Ա����������һЩ����,�����õ��Ĳ�������)
		# ����
			value
				* ӳ��·��,������"/"k��ͷ
			subprotocols
				* ��Э��,��һ�� String[]  �Ĳ���
			decoders
				* ������,����Ӧ���ͻ��˵Ķ���,����Ϊ��Ϣ
			encoders
				* ������,�ѿͻ��˴���������Ϣ,����Ϊ����
			configurator
				* �ò���Ĭ��ֵΪ:ServerEndpointConfig.Configurator.class;
				* ������:ServerEndpointConfig.Configurator ����������
			
	@OnMessage
		# ��ʾ�÷���Ϊ���տͻ�����Ϣ�ķ���
		# �÷����ķ���ֵ,���Ա���Ϊ��Ӧ��������������,Ҳ�����ڸ÷����е����ض���API��������Ϣ������
		# ����
			public long maxMessageSize() default -1;
				* ��Ϣ�Ļ�������С

	@OnOpen
		# �÷�����������ʱ����

	@OnClose
	@OnError
	@PathParam
		# ����ע��URIģ�������ֵ,���ԶԻ����������ͽ����Զ���ת��
		# demo
			@ServerEndpoint("/ws/{demo}")
			..
			@OnMessage
			public void onMessage(@PathParam("demo") Integer demoId){
				//���԰�URIģ�������ֵӳ�䵽�β�
			}
			


	@ClientEndpoint



---------------------------
�������					|
---------------------------
	ServerApplicationConfig
	EndpointConfig
		|-ServerEndpointConfig
			ServerEndpointConfig.Builder
			ServerEndpointConfig.Configurator
		|-ClientEndpointConfig
			ClientEndpointConfig.Builder
			ClientEndpointConfig.Configurator
	Endpoint
	RemoteEndpoint
		|-RemoteEndpoint.Basic
		|-RemoteEndpoint.Async
	Session
	MessageHandler
		|-MessageHandler.Whole<T>
		|-MessageHandler.Partial<T>
	SendHandler
	CloseReason
	PongMessage
		|-WsPongMessage
	Encoder
		|-Text<T>
		|-TextStream<T>
		|-Binary<T>
		|-BinaryStream<T>
	Decoder
		|-Text<T>
		|-TextStream<T>
		|-Binary<T>
		|-BinaryStream<T>
	HandshakeRequest
	HandshakeResponse
	Extension
		|-Extension.Parameter

---------------------------
���						|
---------------------------
	ServerApplicationConfig
		# ��һ���ӿ�,��Ŀ����ʱ,���Զ���������ִ����ʵ����,����:ContentListenner
		# ��WebSocket�ĺ���������
		# ������������
		# ����
			public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> scanned);
				* scanned����,�����Խӿ���ʽ����(Endpoint)��WebSocket Class
				* ������Ҫ��������й���,�Լ��������ǵ�URI
				* ����
					Set<ServerEndpointConfig> result = new HashSet<>();
					if (scanned.contains(EchoEndpoint.class)) {
						result.add(ServerEndpointConfig.Builder.create(EchoEndpoint.class,"/websocket/echoProgrammatic").build());
					}
					if (scanned.contains(DrawboardEndpoint.class)) {
						result.add(ServerEndpointConfig.Builder.create(DrawboardEndpoint.class,"/websocket/drawboard").build());
					}
					return result;

			Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned);
				* scanned����,������ע����ʽ(@ServerEndpoint)���ڵ�WebSocket Class
				* ����
					Set<Class<?>> results = new HashSet<>();
					for (Class<?> clazz : scanned) {
						if (clazz.getPackage().getName().startsWith("websocket.")) {
							results.add(clazz);
						}
					}
					return results;
		# ��������ֵ,�Ż�ȷ����ǰϵͳ�е����� SocketServer
		
	EndpointConfig
		# �˵��һЩ������Ϣ 
		# �����ͻ��˹���Ķ˵������
		# ʹ�ø������Ϣ���㷨�����ö˵�
		# ����һ������,���еĶ˵�ʵ��ֻ����һ��EndpointCongfig
		# ����˵�����
			ServerEndpointConfig
				# �Ƚ���Ҫ��һ�����,������Ϊ���ʽ�˵��URI����
				# ServerEndpointConfig serverEndpointConfig = ServerEndpointConfig.Builder.create(Xxxxx.class,"/websocket/echoProgrammatic").build()
				|-Builder
						create(Class clazz,String path);
							* ����һ���˵����
							* clazz Ϊ Endpoint ��ʵ����,path��ʾӳ���·��
						configurator(ServerEndpointConfig.Configurator configurator);
							* ����һ�� configurator,���δ����,���ʹ��Ĭ�ϵ�
		# �ͻ��˵�����
			ClientEndpointConfig
				# 

	Endpoint
		# ������,Ӧ�ñ����е� WebSocket ������ʵ��
		# ����
			public abstract void onOpen(Session session, EndpointConfig config);
				* ���󷽷�,�����Ӵ򿪵�ʱ�򴥷�
			public void onClose(Session session, CloseReason closeReason) {
			}
				* ��ʵ�ַ���,�ڹرյ�ʱ�򴥷�

			public void onError(Session session, Throwable thr) {
			}
				* ��ʵ�ַ���,���쳣��ʱ�򴥷�
	
	RemoteEndpoint
		# ��������(���͸��ͻ���)����Ϣ,һ�����ֻ��һ��,��sessionά��
		# ��һ���ӿ�,��һЩ����.�������������ӿ�,���������ӿڶ�ʵ���� RemoteEndpoint �ӿ�
		# ����
			void setBatchingAllowed(boolean allowed) throws IOException;
			boolean getBatchingAllowed();
			void flushBatch() throws IOException;
			void sendPing(ByteBuffer applicationData) throws IOException, IllegalArgumentException;
				# ����ping����,���125�ֽ�
			void sendPong(ByteBuffer applicationData) throws IOException, IllegalArgumentException;
				# ����pong����,���125�ֽ�
		# RemoteEndpoint.Basic
			* ͬ�����͵� RemoteEndpoint
			* ִ����Щ�����ķ���,Ҫ�ȴ�������Ϣ����OK��,�Ż� return
			void sendText(String message);
				* ��ͻ�����Ӧ�ı���Ϣ
			 void sendText(String partialMessage, boolean isLast);
				* ��ͻ��˷�����Ϣ,���������Ϣ�Ƿ�Ƭ��,ͨ�� isLast ֵ��ȷ����ǰ��Ϣ�Ƿ������һ��
			void sendBinary(ByteBuffer data);
				* ��ͻ�����Ӧ����������
			void sendBinary(ByteBuffer partialByte, boolean isLast) throws IOException; 
				* ��ͻ�����Ӧ����������,���������Ϣ�Ƿ�Ƭ��,ͨ�� isLast ֵ��ȷ����ǰ��Ϣ�Ƿ������һ��
			Writer getSendWriter();
				* ��ȡ�ͻ��˵�writer
			OutputStream getSendStream();
				* ��ȡ�ͻ��˵Ķ�����Out��,�����Ϣд�����Ҫ�ر���,һ�����ر�.��Ϣ�ͻᱻ���͵��ͻ���
			void sendObject(Object data);
				* ֱ����Ӧһ������

		# RemoteEndpoint.Async
			* �첽���͵� RemoteEndpoint
			* ���ǵķ���������ʼ����Ϣ�ķ�����Ϊ,����OK��,������Щ�����ķ����� return,����������ֱ������OK
	

	Session
		# һ�����ӻỰ,��socket�رյ�ʱ��,��Ҳ��ر�
		# ����
			String getId();
				* ��ȡ��ǰSession��ΨһIDֵ
				* 'ͬһ��������򿪶����ͬҳ��idֵ������ͬ,����.ͬһ��ҳ��,F5ˢ�º�,IDֵҲ�᲻ͬ,Ҳ����˵���Ӳ�ͬ��,F5֮ǰ�����ӻᱻ�رյ�'
				* '0-9','a-f','1a-1f','20-29','2a-2f','30-39','3a-3f'... ...
			RemoteEndpoint.Basic getBasicRemote();
				* ��ȡ RemoteEndpoint.Basic ����
			RemoteEndpoint.Async getAsyncRemote();
				* ��ȡ RemoteEndpoint.Async ����
			addMessageHandler(MessageHandler handler);
				* ���һ��messsage Handler,һ�㶼���ڱ��ʽ�˵�,���Ӵ�(onopen)��ʱ�����
				* ֻһ������(������/�ı�/pong)����Ϣ������,ֻ�����һ��
			
	MessageHandler
		# ����ͻ���(���͸������)����Ϣ,������һ�����߶��.��sessionά��
		# �ýӿڶ����˱��ʽ�˵�,������վ��Ϣʱ,ע������Ȥ�����з�ʽ.
		# ����ʹ�øýӿ���ѡ���ǽ����ı���Ϣ,���Ƕ�������Ϣ
		# Ҳ���Խ���������Ϣ,�����ǵ���Ϣ����ʱ���ս�С��Ƭ��(��Ϣ�ر���ʱ��)
		# �ýӿ�,�ڲ��������ӿ�(��ʵ����MessageHandler),������Ҫʵ�ָýӿ���,�Ľӿ�ʵ��
			interface Whole<T> extends MessageHandler {
				void onMessage(T message);		//ÿ�οͻ�����Ϣ���׵�ʱ��,������ø÷���
			}
			interface Partial<T> extends MessageHandler {

				void onMessage(T partialMessage, boolean last);
			}
		# Demo
			new MessageHandler.Whole<String>(){		//�����ı�����
				public void onMessage(String message){
					System.out.println(message);
				}
			};
			new MessageHandler.Whole<ByteBuffer>(){	//�������������
				public void onMessage(ByteBuffer message){
					System.out.println(message);
				}
			};

	CloseReason
		#
	
	
	HandshakeRequest
		# �ͻ�����������ʱЯ������Ϣ����
		# API
			HttpSession getHttpSession();
				* ��ȡHTTP��Session
			
	
		
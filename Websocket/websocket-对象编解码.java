-------------------------------
websocket-�������				|
-------------------------------	
	# �ѿͻ��˴��ݵ���Ϣ,����Ϊ�����Զ���Ķ���
	# �Զ�����������,��Ҫ��ʵ�ֽӿ� javax.websocket.Decoder �ж���Ľӿ�
	# ���صķ��� T,�������ձ���ĺ�Ķ���
		* Decoder �ӿڷ���
			void init(EndpointConfig config);
				* �����ӽ�����ʱ��ִ��
			void destroy();
				* �����ӹرյ�ʱ��ִ��
		* Dcoder �ӽӿ�
			//���ַ�����Ϣת��Ϊ JAVA����
			interface Text<T> extends Decoder {
				T decode(String s) throws DecodeException;
				boolean willDecode(String s);
			}
			//���ַ�������Ϣת��ΪJAVA����
			interface TextStream<T> extends Decoder {
				T decode(Reader reader) throws DecodeException, IOException;
			}
			//�Ѷ���������ת��ΪJAVA����
			interface Binary<T> extends Decoder {
				T decode(ByteBuffer bytes) throws DecodeException;
				boolean willDecode(ByteBuffer bytes);
			}
			//�Ѷ�����������ת��ΪJAVA����
			interface BinaryStream<T> extends Decoder {
				T decode(InputStream is) throws DecodeException, IOException;
			}
	
	# WebSocket API Ϊ������������(�Լ���װ��),�ṩ��Ĭ�ϵı�����
		@OnMessage
		public void onMessage(Integer mesage){
			//ԭString���͵�message�ᱻת��Ϊ Integer ����,�ȼ��� new Integer(message);
			System.out.pritnln("�յ���Ϣ:" + message);
		}
	
	# ע��ʽ�˵����ý�����
		@ServerEndpoint(value="/test",decoders={xxx.Class})
	
	# ���ʽ�˵����ý�����
		ServerEndpointConfig.Builder.create(XxxxEndPoint.class, "/test").decoders(coders).build();
		* decoders,��һ������ List<Class<? extends Decoder>> decoders
	
	# ʹ��
		* ��ע��ʽ��ʹ��,��˵��.ֱ�ӰѶ�������β�.�ͻ��Զ��Ľ��з�װ
		* �ڱ���ʽ�˵���ʹ��
			* �ڱ���ʽ����ʲô��ʽ������������,ȡ���� MessageHandler �ӿں�����������
			* ͨ������ T ��������Ҫ����ɶ����,���������Զ����Object
				String,
				Reader,
				Byte[],
				ByteBuffer,
				InputStream,
				Object,(�Զ���Ķ���)
			//��Ϣδ��Ƭ�ν�����
			interface Whole<T> extends MessageHandler {
				void onMessage(T message);
			}
			//��Ϣ��Ƭ�ν�����
			interface Partial<T> extends MessageHandler {
				void onMessage(T partialMessage, boolean last);
			}
			
			* ��� Handler �� session
				session.addMessageHandler(MessageHandler handler);
			
-------------------------------
websocket-�������				|
-------------------------------
	# ��������Ӧ���ͻ��˵�POJO,����Ϊ��������Ϣ�������ı���Ϣ
	# ����������Java��������(������װ������),��ᱻת��Ϊһ���ַ���(toString())
	# ������Զ���� Object ����,��ô��Ҫ׼��������,ʵ�ֽӿ� java.websocket.Encoder �ж���Ľӿ�
	# ����T,�������Զ���� Object ����
		* Encoder �ӿڷ���
			void init(EndpointConfig config);
				* �����Ӵ򿪵�ʱ��ִ��
			void destroy();
				* �����ӹرյ�ʱ��ִ��
		* Encoder �ӽӿ�
			//�Ѷ������Ϊ�ı���Ϣ
			interface Text<T> extends Encoder {
				//����ֵ��Ϊ��Ӧ���ͻ��˵�����
				String encode(T object) throws EncodeException;			
			}
			//�Ѷ������Ϊ�ı���
			interface TextStream<T> extends Encoder {
				//ͨ�� writer ��������Ӧ���ͻ���
				void encode(T object, Writer writer) throws EncodeException, IOException;
			}
			//�Ѷ������Ϊ��������Ϣ
			interface Binary<T> extends Encoder {
				//����ֵ��Ϊ��Ӧ���ͻ��˵�����
				ByteBuffer encode(T object) throws EncodeException;
			}
			//�Ѷ������Ϊ��������
			interface BinaryStream<T> extends Encoder {
				//ͨ�� OutputStream ��������Ӧ���ͻ���
				void encode(T object, OutputStream os) throws EncodeException, IOException;
			}
	
	# WebSocket API Ϊ������������(�Լ���װ��),�ṩ��Ĭ�ϵı�����
		@OnMessage
		public Integer onMessage(Integer mesage){
			//balabala.....
		}
	

	# ע��ʽ�˵����ý�����
		@ServerEndpoint(value="/test",encoders={xxx.Class})
	
	# ���ʽ�˵����ý�����
		ServerEndpointConfig.Builder.create(XxxxEndPoint.class, "/test").encoders(coders).build();
		* coders,��һ������ List<Class<? extends Encoder>>
	

	# ʹ��
		* �첽
			Future<Void>  RemoteEndpoint.async(Object data, SendHandler handler);
			void RemoteEndpoint.async(Object data, SendHandler handler);

		* ͬ��
			void RemoteEndpoint.Basic.sendObject(Object data) throws IOException, EncodeException;
		
		* ֱ�ӷ���(ֻ����ע��ʽ)
			@OnMessage 
			public MyClass onMessage(){
				///balalalal
			}


-------------------------------
websocket-�����������������	|
-------------------------------
	# ϵͳ������ʱ��,�ᴴ�����е� encoder�Լ�decoderʵ��
	# ÿ���µ�����,���ᴴ���µ�ʵ��,
	# �ڵ�һ�����ӵ�ʱ����� init ����,�����ӹرյ�ʱ����� destroy ����

-------------------------------
websocket-���������ܽ�		|
-------------------------------


	1,�ͻ�����Ϣ�������
		* ���������,ʵ�ֽӿ�,���;��������Զ���ı����Ķ���
		* ��ӵ�ϵͳ
		* ���messageHandler,����ķ���,���������Զ�������Ķ���
		* ϵͳ���Զ��ĵ��ñ�����������Ϣ���б���,��������������Ķ���
	
	2,����˵��ͻ���
		* ���������,ʵ�ֽӿ�,���;��������Զ���Ķ���
		* ��ӵ�ϵͳ
		* ������ֱ�ӷ��ظö���,�����ǵ���API���ض����ʱ��,�ͻ����ָ���Ľ�����ȥ����

	3,�����ͬ���͵ı������ͬʱ����
		# �ڷ��͵�ʱ����ֶ����ͬ�Ľ�����
			* ����:һ�������Ƶ�Banner��������һ���ı�����Banner������ͬʱ����,����Ӧ�ͻ��� Banner ��ʱ��,���ĸ�?
			* ˭�ȱ����,��ʹ��˭
		
		# �ڽ��յ�ʱ��,���ֶ����ͬ���͵ı�����
			* ����ͻ��˷��͵��Ƕ���������,
			* �����decoders��ƥ�䵽���Դ������������'��һ��'������,���Ҽ������willDecode�Ƿ�Ϊ true,���Ϊ false,�������ʣ�µ��б���Ѱ��
			* �ı���Ϣͬ��
			* ˵����,�ȸ��ݿͻ��˴������ݵ�����������ƥ��(ע�� willDecode)...�ж��,�ٸ��ݱ�����������������

	
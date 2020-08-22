----------------------------
EndpointConfig				|
----------------------------
	# ������һ���ӿ�,��ʾ����
	# ������ʵ�ʵ�Ӧ�����Ե�������ʽ����,ÿ�� @Endpoint ����ֻ����һ��ʵ��
	# ����˵�����	
		ServerEndpointConfig

	# �ͻ��˵�����
		ClientEndpointConfig
	
	# ����
		List<Class<? extends Encoder>> getEncoders();
			* ��ȡ�������б�
		List<Class<? extends Decoder>> getDecoders();
			* ��ȡ�������б�
		Map<String, Object> getUserProperties();
			* ��ȡһ��������Ա���������map,�������Ϊ�������ӵ�Session��,���Դ��һЩ����

----------------------------
ServerEndpointConfig		|
----------------------------
	# �������˵�����
	# �Ƚ���Ҫ��һ�����,������Ϊ���ʽ�˵��URI����
		* ServerEndpointConfig serverEndpointConfig = ServerEndpointConfig.Builder.create(Xxxxx.class,"/websocket/echoProgrammatic").build()

	# �����ֿ�����ʽ�е�ʹ��(��ȡ)
		1,ע��ʽ����
			* ֱ�Ӱ���������������ڷ���(һ�㶼�� @Onopen ,���Ӵ򿪾��������)�β��������ö���(���ݽӿ�)EndpointConfig,�Ϳ���ʹ��

		2,���ʽ����
			* �� ServerApplicationConfig ʵ����� getEndpointConfigs �����й���ʹ��
			* Endpoint �� onMessage �Ѿ������˸ò���

	# API
		serverEndpointConfig.getPath();
			* ��ȡ�˵��·�� ,Ҳ���� @ServerEndpoint ��valueֵ

        serverEndpointConfig.getEndpointClass();
			* ��ȡ�˵���

        serverEndpointConfig.getSubprotocols();
			* ��ȡ��Э���б�

        serverEndpointConfig.getExtensions();
			* ��ȡ�˵�֧�ֵ���չ�б�

        serverEndpointConfig.getConfigurator();
			* ��ȡ ServerEndpointConfig.Configurator(���ඨ���˿ͻ����������������) ������

	
		
	# ServerEndpointConfig.Configurator
		# ���ඨ���˿ͻ�����������˽�������
		# ���û����ʾ�ĸ�Ӧ�ý�������,��ᴴ��Ĭ�ϵ�
			* ServerEndpointConfig.Configurator
			* �����Լ�ȥʵ�ָ���,����һЩ�ص������
		# ע��ʽ����
			@ServerEndpoint(configurator=...)
				* public Class<? extends ServerEndpointConfig.Configurator> configurator() default ServerEndpointConfig.Configurator.class;)
		# ���ʽ����
			ServerEndpointConfig.Builder.create(Xxx.class, "/socket").configurator(new ServerEndpointConfig.Configurator());

		# ����
			public String getNegotiatedSubprotocol(List<String> supported, List<String> requested) {
				return this.getContainerDefaultConfigurator().getNegotiatedSubprotocol(supported, requested);
			} 
				* ��һ������,�ǵ�ǰ�����֧�ֵ���Э���б�
				* �ڶ�������,�ǵ�ǰ�ͻ��˷�����������ʱ֧�ֵ���Э���б�
				* ���û����д�÷���,websocket���� supported �� requested ��ѡһ����֧�ֵ���Э��,���һ����û,���ؿ��ַ���
				* ����ж����ͬ����Э��,��ͻ���˭����ǰ,��ѡ˭
			
			public List<Extension> getNegotiatedExtensions(List<Extension> installed, List<Extension> requested) {
				return this.getContainerDefaultConfigurator().getNegotiatedExtensions(installed, requested);
			}
				* ��������,�������ڼ�.����ø÷�����ȷ��ʹ��websocket����չ
				* ���û����д�÷���,���ڿͻ����������չ�б�,�ͷ�����Ѿ���װ�ķ�����չ��ѡ���е�
				* ���������չ�б�˳��Ϊ׼,��չ�ķ���˳�����Ҫ

			public boolean checkOrigin(String originHeaderValue) {
				return this.getContainerDefaultConfigurator().checkOrigin(originHeaderValue);
			}
				* ���е�������ͻ����ںͷ���˽����������ֵ�ʱ��,����Я��HTTP����ͷ,�����жϿͻ����Ƿ�����HTTPҳ��
				* һ�㲻�ù���
			
			public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
				return this.getContainerDefaultConfigurator().getEndpointInstance(endpointClass);
			} 
				* ��ȡ��Endpoint�˵�ʵ��
				* �÷����᷵��һ���µ� Endpoint ʵ��
			
			public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
				// nothing.
			}
				* '��ţ�Ƶĸ�д��
				* �÷������������Ķ�ȡ�ͻ��˷������������
				* Ҳ��������Ӧ���ͻ���֮ǰ,����Щ���ݽ��������Ķ�д

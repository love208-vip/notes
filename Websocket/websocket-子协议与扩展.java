--------------------------------
WebSocket - ��Э����		
--------------------------------
	# ���е�WebSocket���ᶨ��һЩ�ض��ھ���Ӧ�õ���Ϣ��ʽ,����,�������Э��,
	# WebSocket ����Э��ʹ���ַ�������ʶ
	# �� www.iana.org ���Ѿ��������N����Э��
	# ��ȡ�˵�֧�ֵ���Э���б�
		List<String> getSubprotocols();		//ServerEndpointConfig
	


--------------------------------
WebSocket - ��չ				|
--------------------------------
	# ��ȡ�˵�֧�ֵ���չ�б�
		 List<Extension> getExtensions();	//ServerEndpointConfig
		
	# Extension
		* ����չ���Ե�һ����������
		* Դ��
			public interface Extension {
				String getName();
				List<Parameter> getParameters();
				interface Parameter {
					String getName();
					String getValue();
				}
			}

--------------------------------
ServerEndpointConfig.Configurator|
--------------------------------
	# ServerEndpointConfig.Configurator
	# ���ඨ���˿ͻ�����������˽�������
	# ���û����ʾ�ĸ�Ӧ�ý�������,���ʹ��Ĭ�ϵ�
		* ServerEndpointConfig.Configurator

	# ע��ʽ����
		@ServerEndpoint(configurator=...)

	# ���ʽ����
		* ��ServerApplicationConfig�й���� ServerEndpointConfig ���������
		ServerEndpointConfig.Builder.configurator(new ServerEndpointConfig.Configurator());
	

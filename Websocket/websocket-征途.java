
# ��������
	* Encoder
	* Decoder
	* ��������
		* ������������ʱ�򴴽�ʵ��
		* ÿ�����ӽ����ᴴ��һ��ʵ��
		* �ڵ�һ�����ӵ�ʱ��ִ�� init,�����ӹرյ�ʱ��ִ�� destroy

# ��Ϣ����������
	* һ��Endpoint ��ע��ʽ�ж�Ӧ���͵� message(������/�ı�/pong),ֻ����һ�� @OnMessage ����
	* һ��Endpoint �ڱ��ʽ�ж�Ӧ���͵� message(������/�ı�/pong),ֻ����һ�� MessageHandler����( MesssageHandler,addMessageHandler(MessageHandler handler));

# WebSocket ��Ϣͨ�ź��߳�
	* ÿһ���µ�����,���ᴴ���µ� Endpoint ʵ��
	* ÿ��WebSocket�˵�ʵ��,������ʱ�̶�ֻ�ܱ�һ���̵߳���
	* ����Ϣ�ʷ�Ƭ��ʽ�����ʱ��,WebSocket API �ᱣ֤����ȷ��˳�������Ӧ�Ķ˵�,������Ϣ��������������Ϣ����

# ��Ҫ��API
	* ServerEndpointConfig
		ServerEndpointConfig.Configurator
	

# Session

# ��Ϣ�߼�����
	* ping/pong
	* ͬ����Ϣ/�첽��Ϣ
	* ��Ϣ������

# ��ȡHTTP���
	* �Զ��� ServerEndpointConfig.Configurator ��,��д����:modifyHandshake
	* �����β�:HandshakeRequest ��API HttpSession getHttpSession(); ����ȡ��HTTP,Session
	* ����Session������ӵĶ���,��ö�ȥʵ�ּ�����,�����Ļ�,��SessionʧЧ,�Ϳ���ͨ��������֪ͨ��WebSocket


	
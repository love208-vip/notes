--------------------------------
WebSocket Java�����			|
--------------------------------
	# �����˵�����ַ�ʽ
		1,���ע�� @ServerEndpoint
			* ֱ��ͨ��ע��Ϳ���ӳ��URI,����Ҫ ServerApplicationConfig ʵ�ֵĴ���
			* ����Ҫʵ�� MessageHandler �Ϳ��Դ�������

		2,ʵ�ֳ����� Endpoint
			* ����Ҫͨ��������(ServerEndpointConfig)�����URI��ӳ��,Ҳ���Ǳ���Ҫ ServerApplicationConfig ��ʵ�������
			* ����Ҫ�Զ��� MessageHandler ����������

	# �����˵�Ĺ���
		1,�����Ȼ�ɨ������ @ServerEndpoint ע����,�Լ� ServerEndpointConfig ����
		2,��ɨ�� ServerApplicationConfig ʵ��,���һ��ʵ�ֵ�������,��ȷ����ǰϵͳ�����ж˵�
			* ���������ж�� ServerApplicationConfig ��ʵ�ִ���,���������ʵ�ֵķ���
		
	
	# ����ͼ��			
									<-		RemoteEndpoint
									|					|
		Client   <------------- SESSION				Server
									|					|
									->		MessageHandler
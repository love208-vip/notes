------------------------
WebSocket-js			|
------------------------
	# ����Ȼ����JS�Ķ���
	# ���������Ƿ�֧��WebSocket
		function loadDemo() {  
			if (window.WebSocket) {  
				//֧��  
			} else {  
				//��֧��
			}  
		}  


------------------------
WebSocket-WebSocket		|
------------------------
	# ���� WebSocket ����
		var Socket = new WebSocket(url,[protocol]);
			* url:��ʾ���ӵĵ�ַ,ͨ����Э��:"ws://"����"wss://"(��ȫ��websocket)Э�鿪ͷ
			* protocol:��һ������,���Խ���һ�����߶����Э��,�ò��������Ǳ����
	
	# ����
		Socket.readyState	
			* ֻ������ readyState ��ʾ����״̬������������ֵ
			0 - ��ʾ������δ������
			1 - ��ʾ�����ѽ��������Խ���ͨ�š�
			2 - ��ʾ�������ڽ��йرա�
			3 - ��ʾ�����Ѿ��رջ������Ӳ��ܴ򿪡�
	
		Socket.bufferedAmount	
			* ֻ������ bufferedAmount �ѱ� send() �������ڶ����еȴ����䣬���ǻ�û�з����� UTF-8 �ı��ֽ�����

			
	# �¼�
		* �¼�������,������һ�� event ����
		Socket.onopen	
			* ���ӽ���ʱ����
		Socket.onmessage	
			* �ͻ��˽��շ��������ʱ����
		Socket.onerror	
			* ͨ�ŷ�������ʱ����
		Socket.onclose	
			* ���ӹر�ʱ����
	
	# ����
		Socket.send()	
			* ʹ�����ӷ�������
		Socket.close()	
			* �ر�����
	



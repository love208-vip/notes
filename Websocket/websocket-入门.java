--------------------------------
WebSocket						|
--------------------------------
	# HTML5���¶���,����JS��̵ķ���
	# WebSocket������������������ͷ�����ͨ��,Ҳ����������������
	# �ٷ��ṩ�� websocket �ӿ� �淶
		<dependency>
			<groupId>javax.websocket</groupId>
			<artifactId>javax.websocket-api</artifactId>
			<version>1.1</version>
		</dependency>

	# ע��, Tomcat8 ϵ���Ѿ�֧��WebSocket,�����Լ���libĿ¼���Ѿ�����socket-api.jar,ʵ�ʷ�����ʱ��,������Ӧ����provided

	# ���������Ƿ�֧��WebSocket
		function loadDemo() {  
			if (window.WebSocket) {  
				//֧��  
			} else {  
				//��֧��
			}  
		}  
	

--------------------------------
WebSocket ����ͷ/��Ӧͷ			|
--------------------------------
	# ������
		Upgrade:WebSocket
			* ��ʾ����һ������� HTTP ���������Ŀ�ľ���Ҫ���ͻ��˺ͷ������˵�ͨѶЭ��� HTTP Э�������� WebSocket Э�顣

		Connection: Upgrade
			* ��Ȼ�ǹ̶��ģ����߿ͻ��˼����������� Websocket Э�飬������mozillasocket��lurnarsocket����shitsocket��

		Sec-WebSocket-Protocol
			*  ��Э�顣
		
		Sec-WebSocket-Extensions
			& ��չ
	
	# �ͻ���
		Sec-WebSocket-Key
			* ��һ�� Base64 encode ��ֵ������������������ɵ�
			* ���߷���������ú����Ҫ�����ѣ���Ҫ��֤���ǲ��������Websocket����

		Sec-WebSocket-Version
			* �Ǹ��߷�������ʹ�õ� Websocket Draft��Э��汾��
			* �������ʱ��WebsocketЭ�黹�� Draft �׶Σ���������ֵֹ�Э�鶼�У����һ��кܶ�������ֲֹ�ͬ�Ķ�����ʲôFirefox��Chrome�õĲ���һ���汾֮��ģ�����WebsocketЭ��̫�����һ�������⡣���������ڻ��ã��Ѿ���������~��Ҷ�ʹ�õ�һ������
		Origin:htt://www.kevinBlandy.com/socket								*/
			* ����Ȼ,Ŀ��socket��ַ
	
	# �����
		WebSocket-Accept
			* ������Ǿ���������ȷ�ϣ����Ҽ��ܹ���� Sec-WebSocket-Key �� 


--------------------------------
WebSocket - Э��				|
--------------------------------
	# ��Ҫ���͵�֡
		1,����֡
			* �ر�֡
			* ping֡(���125�ֽ�)
			* pong֡(���125�ֽ�)

		2,����֡
			* �ı���
			* ��������
		2,����֡
	

		

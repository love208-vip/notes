----------------------------
socketserver				|
----------------------------
	* ��ģ����,������������,��ʵ���Ƕ� socket ��һ����װ
	* ģ����
		BaseServer(Server�����)
			|-TCPServer
				|-ThreadingTCPServer(֧�ֶ��̵߳�TCPServer)
				|-ForkingTCPServer(֧�ֶ���̵�TCPServer,������unix��Ч)
				|-UnixStreamServer
				|-UDPServer
					|-ThreadingUDPServer(֧�ֶ��̵߳�UDPServer)
					|-ForkingUDPServer(֧�ֶ���̵�UDPServer,������unix��Ч))
					|-UnixDatagramServer
		BaseRequestHandler(Handle������)

----------------------------
BaseServer					|
----------------------------
	* �����������Ķ������
	* ʵ������
		fileno()
			* �����ļ�������
		handle_request()
			* ����������
		serve_forever(poll_interval=0.5)
			* ����N������
			* �ؼ��ֲ���
				poll_interval	# Ĭ�ϵ�0.5,��˼��ÿ��0.5����,���һ��,�ǲ��Ǹ��ҷ����� shutdown ���ź�
		service_actions()
			* 
		shutdown()
			* �رշ���

		server_close()
			* �رշ���
		

----------------------------
socketserver-TCPServer		|
----------------------------
	* tcp 
	* ��������
		1,������������,�̳���:socketserver.BaseRequestHandler ��
			class BaseRequestHandler:
				def __init__(self, request, client_address, server):
					self.request = request					# �ͻ���socket����
					self.client_address = client_address	# �ͻ��˵�ַ 
					self.server = server					# ��ǰServer
					self.setup()							# �ڴ���֮ǰִ��
					try:
						self.handle()						# ִ���߼�����
					finally:
						self.finish()						# �ٴ���֮��ִ��

				def setup(self):
					pass

				def handle(self):
					pass

				def finish(self):
					pass

		2,��д: handle() ����,����ҵ���߼�����
		3,ʵ���� TCPServer Server
		4,ִ�� handle_request()/serve_forever(),׼�����տͻ�������

	* TCPServer ʵ������
		TCPServer(server_address, RequestHandlerClass, bind_and_activate=True)
			* �󶨱��ص�ַ & �����˿�, tuple
			* RequestHandlerClass �����Զ������������
			* bind_and_activate
	
	* TCPServer ʵ������
		handle_request()
			* ��������һ������,ִ����Ϻ��˳�����
		
		serve_forever(poll_interval=0.5)
			* ����������
			* �ؼ��ֲ���
				poll_interval	# 
		
		server_close()
			* �رշ���
	* demo
		import socketserver
		class Handler(socketserver.BaseRequestHandler):
			def handle(self):
				self.request			# �ͻ���socket����
				# socket.socket fd=552, family=AddressFamily.AF_INET, type=SocketKind.SOCK_STREAM, proto=0, laddr=('127.0.0.1', 1024), raddr=('127.0.0.1', 3875)>
				
				self.client_address		# �ͻ��˵�ַ 
				# ('127.0.0.1', 3875)
				
				self.server				# ��ǰServer
				# <socketserver.TCPServer object at 0x029583D0>

		server = socketserver.TCPServer(('localhost',1024),Handler)
		server.serve_forever()	# ����������
	
	* ÿһ������,���ᴴ��һ�� handle ʵ��,���ҵ��� handle() ����ִ���߼�����
	* ��Ȼ�ǵ��߳�,��������ȫ�����������߳�(MainThread)ִ��
	* �����Ҫʹ�ö��߳�,�� ���Դ���: ThreadingTCPServer ʵ��
	* �����Ҫʹ�ö����,�� ���Դ���: ForkingTCPServer ʵ��(������unix��Ч))

----------------------------
socketserver-UDPServer		|
----------------------------
	* udp
	* ��Tcpһ��,�����Ǵ���Serverʵ���ķ�����һ��
	* demo
		import socketserver
		class Handler(socketserver.BaseRequestHandler):
			def handle(self):
				self.request			# �ͻ���socket����
				self.client_address		# �ͻ��˵�ַ 
				self.server				# ��ǰServer
		server = socketserver.ThreadingUDPServer(('localhost',1024),Handler)



	
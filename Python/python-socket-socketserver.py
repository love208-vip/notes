---------------------------
socketserver				|
---------------------------
	* socketserver ģ���Ƕ� socket �ķ�װ
	* �е��¼���������˼
	* ����ϵ
		BaseServer(Server�����)
			|-TCPServer
				|-ThreadingTCPServer(֧�ֶ��̵߳�TCPServer)
				|-ForkingTCPServer(֧�ֶ���̵�TCPServer,������unix��Ч)
				|-UnixStreamServer
				|-UDPServer
					|-ThreadingUDPServer(֧�ֶ��̵߳�UDPServer)
					|-ForkingUDPServer(֧�ֶ���̵�UDPServer,������unix��Ч))
					|-UnixDatagramServer
				|-HTTPServer
					|-WSGIServer
		BaseRequestHandler(Handle������)
			|-StreamRequestHandler
				|-BaseHTTPRequestHandler
					|-WSGIRequestHandler
	
	* BaseServer ��һЩ����,�������������ʱ������Լ���д
		server_bind()
			* �󶨼���
	
	* BaseServer ��һЩ����
		allow_reuse_address
			* Ĭ��Ϊ False,�Ƿ�����˿ڸ���

---------------------------
tcp							|
---------------------------
	import socketserver
	class Handler(socketserver.BaseRequestHandler):
		def handle(self):
			self.request			# �ͻ���socket����
			# socket.socket fd=552, family=AddressFamily.AF_INET, type=SocketKind.SOCK_STREAM, proto=0, laddr=('127.0.0.1', 1024), raddr=('127.0.0.1', 3875)>
			
			self.client_address		# �ͻ��˵�ַ 
			# ('127.0.0.1', 3875)
			
			self.server				# ��ǰServer
			# <socketserver.TCPServer object at 0x029583D0>

	server = socketserver.ThreadingTCPServer(('localhost',1024),Handler)
	server.serve_forever()

---------------------------
udp							|
---------------------------
	import socketserver
	class Handler(socketserver.BaseRequestHandler):
		def handle(self):
			self.request			# �ͻ���socket����,��һ����������udp������
			# (b'Hello,Python', <socket.socket fd=200, family=AddressFamily.AF_INET, type=SocketKind.SOCK_DGRAM, proto=0, laddr=('127.0.0.1', 3025)>)
			
			self.client_address		# �ͻ��˵�ַ 
			# ('127.0.0.1', 3875)
			
			self.server				# ��ǰServer
			# <socketserver.TCPServer object at 0x029583D0>

	server = socketserver.ThreadingUDPServer(('localhost',1024),Handler)
	server.serve_forever()

---------------------------
http�ļ�Ŀ¼				|
---------------------------
	from http.server import SimpleHTTPRequestHandler
	import socketserver

	httpd = socketserver.TCPServer(('localhost', 3025), SimpleHTTPRequestHandler)
	httpd.serve_forever()

---------------------------
�ļ��ϴ�					|
---------------------------
# �ͻ���
import socket
import os
client = socket.socket()
client.connect(('localhost',1024))
target_file = "D:\\eclipse-jee-oxygen-M7-win32-x86_64.zip"
with open(target_file,'rb') as file:
    print('�ļ���С:%s'%(os.stat(target_file).st_size))
    client.sendall(file.read())
    client.shutdown(socket.SHUT_WR)


# �����
from socketserver import ThreadingTCPServer,BaseRequestHandler
target_file = "E:\\eclipse-jee-oxygen-M7-win32-x86_64.zip"
class Handle(BaseRequestHandler):
    def handle(self):
        request = self.request
        with open(target_file,'wb') as file:
            while True:
                data = request.recv(2048)
                print('�Ѿ�����:%s'%(len(data)))
                if len(data) == 0:
                    break
                file.write(data)
                file.flush()
        request.close()
server = ThreadingTCPServer(('localhost',1024),Handle)
server.serve_forever()
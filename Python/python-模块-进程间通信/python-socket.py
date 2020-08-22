--------------------------------
socket							|
--------------------------------

--------------------------------
socket-ģ������					|
--------------------------------
	* �����
		socket.AF_UNIX		# ����(Unix/Linuxϵͳ���и�����,�����ڲ�ͬ����֮���ͨ��)
		socket.AF_INET      # IPV4
		socket.AF_INET6     # IPV6
	
	* �����
		socket.SOCK_STREAM  
			* tcp

		socket.SOCK_DGRAM   
			* udp

		socket.SOCK_RAW     
			* ԭʼ�׽���(��ͨ�׽��ֲ��ܴ���ICMP,IGMP�ȱ���,��������)
			* ��Ҳ���Դ��������IPV4����
			* ���ø��׽���,����ͨ�� IP_HDRINCL �׽���ѡ��,�۸�IPͷ(α��IP��ַ)
		
		socket.SOCK_RDM
			* �ɿ���UDP,��֤������Ϣ,���ǲ���֤����˳��

	
--------------------------------
socket-ģ�鷽��					|
--------------------------------
	socket.socket socket()
		* ʵ����socket����
		* ��ʼ������
			 family=AF_INET		# ��ַ��
			 type=SOCK_STREAM	# ��������(tcp/udp),Ĭ��tcp
			 proto=0			# ��Э��
			 fileno=None		# δ֪
	
	str gethostname()
			* ��ȡ����������

--------------------------------
socket-socket					|
--------------------------------
	
	# about client
		None connect(tuple)
			* ��Ϊtcp�ͻ�������Զ�̵�ַ
			* �����쳣,���׳�
			* tuple,��һ���������ַ����͵�IP,�ڶ���������int���͵Ķ˿�

		int connect_ex()	
			* connect()��������չ�汾,����ʱ���س�����,�������׳��쳣
	
	# about server
		None class bind(tuple)
			* �󶨱�����Ϣ
			* tuple,��һ���������ַ����͵�IP,�ڶ���������int���͵Ķ˿�
		
		None listen(timeout)
			* ��ʼ����
			* timeout,��ָ����ϵͳ���Թ���������������
			* ��ֵ����Ϊ1,�󲿷�Ӧ�ó�����Ϊ5�Ϳ�����
		
		setblocking(flag)	
			* ���flagΪ0,���׽�����Ϊ������ģʽ
			* �����׽�����Ϊ����ģʽ(Ĭ��)
			* ������ģʽ��,������� recv() û�з����κ�����,�� send() �����޷�������������,��ô������ socket.error �쳣
		
		tuple accept()
			* �����߳�,ֱ���пͻ��˵�����,�ͻ᷵�� tuple
			* ��һ��Ԫ�ؾ���,�ͻ��˵� socket ����,�ڶ���Ԫ��,����һ��Ԫ��
				(	<
						socket.socket 
						fd=276, 
						family=AddressFamily.AF_INET,	# �ͻ���IP & �˿�
						type=SocketKind.SOCK_STREAM,	# TCP
						proto=0,				
						laddr=('127.0.0.1', 1024),		# ���ط�����IP & �˿�
						raddr=('127.0.0.1', 50142)		# �ͻ���IP & �˿�
					>, 
					('127.0.0.1', 50142)				# �ͻ���IP & �˿�
				)

	# common
		None setsockopt()
			* ���� socket ��һЩ����(����:�˿�����)
			* demo
				setsockopt(socket.SOL_SOCKET,socket.SO_REUSEADDR,1) # ���ö˿ڿ�������

		int send(bytes)
			* �������ݵ�Ŀ��,��һ��һ���ԾͰ����ݷ������,Ӧ��ʹ�� sendall()
			* �����Ѿ����͵��ֽڳ���
		
		bytes recv(length)
			* ����tcp����������ֽ�����,һ��Ҳ����ղ���,Ӧ��ѭ������
			* length,��������Ҫ���ն೤������
		
		int sendto(data,tuple)	
			* ����UDP����
			* data,�Ƕ���������,tuple,����Զ�̵�ַ,��ʽΪ(ipaddr,port)��Ԫ��
			* ����ֵ�Ƿ��͵��ֽ���

		tuple recvform()	
			* ����UDP����,�� recv()���� ������ֵ��(data,address)��Ԫ��
			* ���� data �ǰ����������ݵ��ַ���,address�Ƿ������ݵ��׽��ֵ�ַ
			* (b'Hello,Python', ('127.0.0.1', 61207))
		
		None sendall()	
			* ��������TCP����,��������TCP����,����ѭ���� send()
			* ��string�е����ݷ��͵����ӵ��׽���,���ڷ���֮ǰ�᳢�Է�����������
			* �ɹ�����None,ʧ�����׳��쳣
		
		None close()
			* �ر���Զ�̷�������TCP����
		
		None shutdown(socket.SHUT_WR)
			* ��ʾ���ݷ���/�������
			* ��ʾ����IO���
			* ���� 
				SHUT_RDWR	�رն�д��������ʹ��send/write/recv/read��
				SHUT_RD		�رն���������ʹ��read/recv��
				SHUT_WR		�ر�д���ܣ�������ʹ��send/write��

		tuple getpeername()	
			* ���������׽��ֵ�Զ�̵�ַ
			* ����ֵͨ����Ԫ��(ipaddr,port)
		
		tuple getsockname()
			* �����׽����Լ��ĵ�ַ
			* ��һ��Ԫ��(ipaddr,port)
		
		setsockopt(level,optname,value)	
			* ���ø����׽���ѡ���ֵ
		
		getsockopt(level,optname[.buflen])	
			* �����׽���ѡ���ֵ
		
		settimeout(timeout)	
			* �����׽��ֲ����ĳ�ʱ��
			* timeout��һ��������,��λ����
			* ֵΪNone��ʾû�г�ʱ��
			* һ��,��ʱ��Ӧ���ڸմ����׽���ʱ���ã���Ϊ���ǿ����������ӵĲ���(�� connect())

		gettimeout()	
			* ���ص�ǰ��ʱ�ڵ�ֵ,��λ����,���û�����ó�ʱ��,�򷵻�None
		
		fileno()	
			* �����׽��ֵ��ļ�������
			* Demo
				print(socket.socket())
				<socket.socket fd=408, family=AddressFamily.AF_INET, type=SocketKind.SOCK_STREAM, proto=0>
				* fd ֵ ����socket�� fileno()
		
		makefile()	
			* ����һ������׽�����������ļ�
	
		

		
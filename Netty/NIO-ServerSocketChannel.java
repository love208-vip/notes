---------------------------------
ServerSocketChannel				 |
---------------------------------
	# ServerSocketChannel ��һ�����Լ����½�����TCP���ӵ�ͨ��,
	# �����׼IO�е�ServerSocketһ����ServerSocketChannel���� java.nio.channels���С�
	# Demo	
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(9999));	//�󶨶˿�
		while(true){
			SocketChannel socketChannel = serverSocketChannel.accept();
			//do something with socketChannel...
		}
	# accept(); ��һֱ�����߳�,ֱ�����µĿͻ������ӽ���


---------------------------------
ServerSocketChannel-������ģʽ	 |
---------------------------------
	# ServerSocketChannel�������óɷ�����ģʽ��
	# �ڷ�����ģʽ�£�accept() ���������̷��أ������û���½���������,���صĽ���null�� ��ˣ���Ҫ��鷵�ص�SocketChannel�Ƿ���null.
	# Demo
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(9999));
		serverSocketChannel.configureBlocking(false);		//����Ϊ������ģʽ
		while(true){
			SocketChannel socketChannel = serverSocketChannel.accept();
			if(socketChannel != null){
				//do something with socketChannel...
			}
		}


---------------------------------
ServerSocketChannel-API			 |
---------------------------------
	
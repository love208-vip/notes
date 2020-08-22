-------------------------------
SocketChannel					|
-------------------------------
	# SocketChannel��һ�����ӵ�TCP�����׽��ֵ�ͨ����
	# ����ͨ������2�ַ�ʽ����SocketChannel��
		1,��һ��SocketChannel�����ӵ��������ϵ�ĳ̨��������				
		2,һ�������ӵ���ServerSocketChannelʱ���ᴴ��һ��SocketChannel��
	# �� SocketChannel
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
	
	# �ر� SocketChannel
		socketChannel.close();
	
	# �� SocketChannel �ж�ȡ����

		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		int bytesRead = socketChannel.read(byteBuffer);

		* ����һ��Buffer����SocketChannel��ȡ�������ݽ���ŵ����Buffer�С�
		* Ȼ�󣬵���SocketChannel.read()���÷��������ݴ�SocketChannel ����Buffer�С�
		* read()�������ص�intֵ��ʾ���˶����ֽڽ�Buffer�������ص���-1����ʾ�Ѿ�����������ĩβ�����ӹر��ˣ���
	
	# д�����ݵ� SocketChannel
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		buf.clear();					//��ջ�����
		buf.put(newData.getBytes());	//�������
		buf.flip();						//��λ,limit = position,position = 0
		while(buf.hasRemaining()) {		//ȷ����������,����д��
			channel.write(buf);
		}
		* ע��SocketChannel.write()�����ĵ�������һ��whileѭ���еġ�
		* Write()�����޷���֤��д�����ֽڵ�SocketChannel�����ԣ������ظ�����write()ֱ��Bufferû��Ҫд���ֽ�Ϊֹ��
	
	
	# ������ģʽ��ѡ����
		* ������ģʽ��ѡ��������Ṥ���ĸ��ã�ͨ����һ����SocketChannelע�ᵽSelector������ѯ��ѡ�����ĸ�ͨ���Ѿ�׼�����˶�ȡ��д��ȡ�
		* Selector��SocketChannel�Ĵ���ʹ�û��ں����꽲��


-------------------------------
SocketChannel-��				|
-------------------------------

-------------------------------
SocketChannel-д				|
-------------------------------

-------------------------------
SocketChannel-������ģʽ		|
-------------------------------
	# �������� SocketChannel Ϊ������ģʽ��non-blocking mode��.����֮�󣬾Ϳ������첽ģʽ�µ���connect(), read() ��write()�ˡ�
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
		
	# write();
		* ������ģʽ�£�write()��������δд���κ�����ʱ���ܾͷ����ˡ�
		* ������Ҫ��ѭ���е���write()��ǰ���Ѿ��������ˣ�����Ͳ�׸���ˡ�

	# read();
		* ������ģʽ��,read()��������δ��ȡ���κ�����ʱ���ܾͷ����ˡ�
		* ������Ҫ��ע����int����ֵ������������ȡ�˶����ֽڡ�
	

-------------------------------
SocketChannel-Selector			|
-------------------------------

-------------------------------
SocketChannel-API				|
-------------------------------
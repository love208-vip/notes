----------------------------
DatagramChannel				|
----------------------------
	# DatagramChannel��һ�����շ�UDP����ͨ����
	# ��ΪUDP�������ӵ�����Э�飬���Բ���������ͨ��������ȡ��д�롣�����ͺͽ��յ������ݰ���
	# �� DatagramChannel 
		DatagramChannel channel = DatagramChannel.open();
		channel.socket().bind(new InetSocketAddress(9999));	//�򿪵� DatagramChannel������UDP�˿�9999�Ͻ������ݰ���


----------------------------
DatagramChannel-��������	|
----------------------------
	DatagramChannel channel = DatagramChannel.open();
	channel.socket().bind(new InetSocketAddress(9999));
	ByteBuffer buf = ByteBuffer.allocate(48);
	buf.clear();
	channel.receive(buf);

	* receive()�����Ὣ���յ������ݰ����ݸ��Ƶ�ָ����Buffer. 
	* ���Buffer�ݲ����յ������ݣ���������ݽ���������
	

----------------------------
DatagramChannel-��������	|
----------------------------
	DatagramChannel channel = DatagramChannel.open();
	channel.socket().bind(new InetSocketAddress(9999));
	String newData = "New String to write to file..." + System.currentTimeMillis();
	ByteBuffer buf = ByteBuffer.allocate(48);		//����Buffere
	buf.clear();									//position = 0
	buf.put(newData.getBytes());					//�������,position = newData.length;
	buf.flip();										//��λ,��ΪҪ�������ȡ���� position = 0
	int bytesSent = channel.send(buf, new InetSocketAddress("jenkov.com", 80));
	
----------------------------
���ӵ��ض��ĵ�ַ			|
----------------------------
	# ���Խ�DatagramChannel'����'�������е��ض���ַ�ġ�
	# ����UDP�������ӵģ����ӵ��ض���ַ��������TCPͨ����������һ�����������ӡ���
	# ֻ��סDatagramChannel ������ֻ�ܴ��ض���ַ�շ����ݡ�
		DatagramChannel channel = DatagramChannel.open();
		/**
			�� Channel ����ĳ��ͨ����
			Ҳ����ʹ��read()��write()�������������ô�ͳ��ͨ��һ����
		*/
		channel.socket().bind(new InetSocketAddress(9999));
		int bytesRead = channel.read(buf);
		int bytesWritten = channel.write(but);



----------------------------
DatagramChannel-API			|
----------------------------
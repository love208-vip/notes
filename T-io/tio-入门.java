-----------------------
tio-����				|
-----------------------
	# ����
	# http://www.t-io.org:9292/
	# ����AIOͨѶ���
	# Maven��ַ
		<dependency>
		    <groupId>org.t-io</groupId>
		    <artifactId>tio-core</artifactId>
		    <version>1.6.9.v20170408-RELEASE</version>
		</dependency>


-----------------------
tio-����AIP��ϵ			|
-----------------------	
	AioServer			//�������˶���

	AioClient			//�ͻ��˶���
	
	ReconnConf			//�ͻ�����������

	Node				//Ŀ�����˵�
	
	ChannelContextFilter			//�����ӿ�,���ڹ���ͨ��

	Packet							//���ݰ��ӿ�
		|-EncodedPacket		

	ChannelContext					//���ӹܵ������Ľӿ�
		|-ClientChannelContext
		|-ServerChannelContext

	AioListener						//�����ӿ�
		|-ClientAioListener
		|-ServerAioListener
	
	GroupContext					//GroupContext
		|-ClientGroupContext
		|-ServerGroupContext
	
	AioHandler						//Handler
		|-ClientAioHandler
		|-ServerAioHandler
	
	GroupStat						//ͳ�Ʋ��
		|-ClientGroupStat
		|-ServerGroupStat


-----------------------
tio-�ͻ������Ӳ���		|
-----------------------
	1,�������ӽڵ�
		Node
	2,�����ͻ���Handler(��Ϣ�崦��,����,����)
		ClientAioHandler
	3,�����¼�����(�Ǳ���,����Ϊnull)
		ClientAioListener
	4,������������(�Ǳ���,����Ϊnull)
		ReconnConf
	5,�����ͻ���Group������
		ClientGroupContext(ClientAioHandler,ClientAioListener,ReconnConf);
	6,�����ͻ��˶���
		AioClient(ClientGroupContext);
	7,�ͻ��˶���ִ������,��ȡ�� ClientChannelContext ����
		connect(Node);
	8,������Ϣ��
		Package
	9,ʹ�� AIO ��̬����,�����Ϣ����
		Aio.send(ClientChannelContext, Package);
	
	
	//1,Ŀ��ڵ�
	Node node = new Node("localhost",1024);
	//2,�ͻ���Hanlder
	ClientAioHandler<Object,DataPacket,Object> clientHandler = new ClientHandler();
	//3,�ͻ��˼���
	ClientAioListener<Object,DataPacket,Object> clientAioListener = null;
	//4,�ͻ�������
	ReconnConf<Object,DataPacket,Object> reconnConf = null;
	//5,�ͻ���GroupContext
	ClientGroupContext<Object,DataPacket,Object> clientGroupContext = new ClientGroupContext<Object,DataPacket,Object>(clientHandler,clientAioListener,reconnConf);
	//6,�ͻ��˶���
	AioClient<Object,DataPacket,Object> aioClient = new AioClient<Object,DataPacket,Object>(clientGroupContext);
	//7,������,��ȡ�ܵ�������
	ChannelContext<Object,DataPacket,Object> clientChannelContext = aioClient.connect(node);
	//8,�������ݰ�
	DataPacket dataPacket = new DataPacket();
	for(int x = 1;x > 0; x++){
		Thread.sleep(1000);
		dataPacket.setData(("���ǿͻ��˵�"+x+"����Ϣ").getBytes(DataPacket.CHARSET));
		//9,ִ�з���
		Aio.send(clientChannelContext, dataPacket);
	}

-----------------------
tio-�������������		|
-----------------------
	1,������������Handler,(��Ϣ�崦��,����,����)
		ServerAioHandler
	2,�����¼�����(�Ǳ���,����Ϊnull)
		ServerAioListener
	3,���������������
		ServerGroupContext(ServerAioHandler,ServerAioListener);
	4,��������˶���
		 AioServer(ServerGroupContext);
	5,��������˶���
		start("ip",�˿�);
	
	//1,������������Hanlder
	ServerAioHandler<Object, HelloPacket, Object> aioHandler = new HelloServerAioHandler();
	//2,�����¼�����
	ServerAioListener<Object, HelloPacket, Object> aioListener = null;
	//3,�����������������
	ServerGroupContext<Object, HelloPacket, Object> serverGroupContext = new ServerGroupContext<Object, HelloPacket, Object>(aioHandler, aioListener);
	//4,��������˶���
	AioServer<Object, HelloPacket, Object> aioServer = new AioServer<Object, HelloPacket, Object>(serverGroupContext);
	//5,��������
	aioServer.start(null,1024);

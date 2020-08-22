-------------------------
GroupContext			 |
-------------------------
	# GroupContext<SessionContext, P extends Packet, R>
	# ������,������
	# ����
		ClientGroupContext<SessionContext, P extends Packet, R> 
		ServerGroupContext<SessionContext, P extends Packet, R>

	# ����
		//final����
		public static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 1;

		public static final long DEFAULT_HEARTBEAT_TIMEOUT = 1000 * 120;		
			* Ĭ�ϵ�������ʱʱ��,��λ,����
		
		public static final int READ_BUFFER_SIZE = Integer.getInteger("tio.default.read.buffer.size", 2048);
			* Ĭ�Ͻ������ݵ� BufferSize
			* �� System.setProperty("tio.default.read.buffer.size",2048);�ж�ȡ
			* ���û��ֵ,����ת���쳣,��ʹ��Ĭ��ֵ:2048
		
		public static final long KEEP_ALIVE_TIME = 9000000L;
			* �������ӵ�ʱ��
		
		private final static AtomicInteger ID_ATOMIC = new AtomicInteger();
		
		
		//����������
		private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
			* Buffer����
		
		protected long heartbeatTimeout = DEFAULT_HEARTBEAT_TIMEOUT;
			* ������ʱʱ��
		
		protected int readBufferSize = READ_BUFFER_SIZE;
			* �������ݵ�BuffereSize
		
		protected ReconnConf<SessionContext, P, R> reconnConf;
			* ��������
		
		private SynThreadPoolExecutor<SynRunnableIntf> handlerExecutorNormPrior = null;
			* �����ȼ���'ҵ����'�̳߳�
		
		private SynThreadPoolExecutor<SynRunnableIntf> sendExecutorNormPrior = null;
			* �����ȼ���'��Ϣ����'�̳߳�
		
		private ThreadPoolExecutor closePoolExecutor = null;
		
		protected ClientNodes<SessionContext, P, R> clientNodes = new ClientNodes<>();
		protected ChannelContextSetWithLock<SessionContext, P, R> connections = new ChannelContextSetWithLock<>();
		protected ChannelContextSetWithLock<SessionContext, P, R> connecteds = new ChannelContextSetWithLock<>();
		protected ChannelContextSetWithLock<SessionContext, P, R> closeds = new ChannelContextSetWithLock<>();
		protected Groups<SessionContext, P, R> groups = new Groups<>();
		protected Users<SessionContext, P, R> users = new Users<>();
		protected ChannelContextMapWithLock<SessionContext, P, R> syns = new ChannelContextMapWithLock<>();
		 
		private boolean isEncodeCareWithChannelContext  = true;
			* packet�����bytebufferʱ���Ƿ���ChannelContext���
			* false: packet������ChannelContext�޹�
		
		protected String id;
	
		private boolean isStopped = false;

		

-----------------------------
ClientGroupContext			 |
-----------------------------
	# ClientGroupContext<SessionContext, P extends Packet, R>
	# ����
		private ExecutorService groupExecutor = null;

		private ClientAioHandler<SessionContext, P, R> clientAioHandler = null;

		private ClientAioListener<SessionContext, P, R> clientAioListener = null;

		private ClientGroupStat clientGroupStat = new ClientGroupStat();
		
		private ConnectionCompletionHandler<SessionContext, P, R> connectionCompletionHandler = new ConnectionCompletionHandler<>();
	
	# ����
		

	# ���췽��
		public ClientGroupContext(ClientAioHandler<SessionContext, P, R> aioHandler, ClientAioListener<SessionContext, P, R> aioListener)
		public ClientGroupContext(ClientAioHandler<SessionContext, P, R> aioHandler, ClientAioListener<SessionContext, P, R> aioListener, ReconnConf<SessionContext, P, R> reconnConf)
		public ClientGroupContext(ClientAioHandler<SessionContext, P, R> aioHandler, ClientAioListener<SessionContext, P, R> aioListener, ReconnConf<SessionContext, P, R> reconnConf, ExecutorService groupExecutor)
	

-----------------------------
ServerGroupContext			 |
-----------------------------
	# ServerGroupContext<SessionContext, P extends Packet, R>
	# ����
		private ThreadPoolExecutor groupExecutor = null;

		private AcceptCompletionHandler<SessionContext, P, R> acceptCompletionHandler = null;

		private ServerAioHandler<SessionContext, P, R> serverAioHandler = null;

		private ServerAioListener<SessionContext, P, R> serverAioListener = null;

		protected ServerGroupStat serverGroupStat = new ServerGroupStat();

		private Thread checkHeartbeatThread = null;
	
	# ����
		
		
	# ���췽��
		public ServerGroupContext(ServerAioHandler<SessionContext, P, R> aioHandler, ServerAioListener<SessionContext, P, R> aioListener);
		public ServerGroupContext(ServerAioHandler<SessionContext, P, R> aioHandler, ServerAioListener<SessionContext, P, R> aioListener, ThreadPoolExecutor groupExecutor);



	
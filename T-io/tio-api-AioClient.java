---------------------------
AioClient					|
---------------------------
	# AIO�ͻ��˶���


---------------------------
AioClient-����				|
---------------------------

	private AsynchronousChannelGroup channelGroup;

	private ClientGroupContext<SessionContext, P, R> clientGroupContext;

---------------------------
AioClient-����				|
---------------------------
	# ��Ա����
		void asynConnect(Node serverNode);
			* �첽����

		void asynConnect(Node serverNode, Integer timeout);
			* �첽����

		void asynConnect(Node serverNode, String bindIp, Integer bindPort, Integer timeout);
			* �첽����

		ClientChannelContext<SessionContext, P, R> connect(Node serverNode);
			* ͬ������

		ClientChannelContext<SessionContext, P, R> connect(Node serverNode, String bindIp, Integer bindPort, Integer timeout);
			* ͬ������

		AsynchronousChannelGroup getChannelGroup();
			* ��ȡ�첽ͨ��Group
			
		ClientGroupContext<SessionContext, P, R> getClientGroupContext();
			* ��ȡ�ͻ���Group

		reconnect(ClientChannelContext<SessionContext, P, R> channelContext, Integer timeout);
			* ��������

		void setClientGroupContext(ClientGroupContext<SessionContext, P, R> clientGroupContext);
			* ���ÿͻ���Group

		boolean stop();
			* ֹͣ
			

	# ���췽��
		public AioClient(final ClientGroupContext<SessionContext, P, R> clientGroupContext) throws IOException{
			super();
			this.clientGroupContext = clientGroupContext;
			ExecutorService groupExecutor = clientGroupContext.getGroupExecutor();
			this.channelGroup = AsynchronousChannelGroup.withThreadPool(groupExecutor);
			startHeartbeatTask();
			startReconnTask();
		}
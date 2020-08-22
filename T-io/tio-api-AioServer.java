--------------------------------
AioServer						|
--------------------------------
	# AioServer<SessionContext, P extends Packet, R>
	# ����˶���


--------------------------------
AioServer-����					|
--------------------------------
	
	private ServerGroupContext<SessionContext, P, R> serverGroupContext;

	private AsynchronousServerSocketChannel serverSocketChannel;

	private Node serverNode;

	private boolean isWaitingStop = false;

--------------------------------
AioServer-����					|
--------------------------------
	# ��Ա����
		ServerGroupContext<SessionContext, P, R> getServerGroupContext();

		setServerGroupContext(ServerGroupContext<SessionContext, P, R> serverGroupContext);

		AsynchronousServerSocketChannel getServerSocketChannel();
		
		start(String serverIp, int serverPort);

		boolean stop();

		Node getServerNode();

		boolean isWaitingStop();

		void setWaitingStop(boolean isWaitingStop);


	# ���췽��
		AioServer(ServerGroupContext<SessionContext, P, R> serverGroupContext){
			super();
			this.serverGroupContext = serverGroupContext;
		}
------------------------
Netty�������			|
------------------------
	# �����������

------------------------
Bootstrap				|
------------------------
	# һ��Netty�������� Bootstrap��ʼ,����Ҫ��������'��������Netty����,������������'

	Bootstrap	
		# client
	ServerBootstrap
		# server

------------------------
Channel					|
------------------------
	# ������һ��Socket����,��������IO������ص����
	# ��EventLoopһ����������IO����

------------------------
Future					|
------------------------
	# ��Netty�����е�IO���������첽�ģ���ˣ��㲻�����̵�֪��Ϣ�Ƿ���ȷ����
	# ���ǿ��Թ�һ�����ִ����ɻ���ֱ��ע��һ������
	# �����ʵ�־���ͨ�� Future �� ChannelFutures,���ǿ���ע��һ������,������ִ�гɹ���ʧ��ʱ�������Զ�������
	# ��֮�����еĲ������᷵��һ��ChannelFuture��

------------------------
handler					|
------------------------
	# Ϊ��֧�ָ���Э��ʹ������ݵķ�ʽ���㵮����Handler�����Handler��Ҫ������������¼�
		* ����
		* ���ݽ���
		* �쳣
		* ����ת����...

	# ChannelHandler
		* ���Ľӿ�
		
		ChannelInitializer<C extends Channel>
			# ������,���ڹ������Handler
			# ��һ�����ӽ���ʱ��������Ҫ֪����ô�����ջ��߷������ݣ���Ȼ�������и��ָ�����Handlerʵ������������
			# ChannelInitializer ��������������ЩHandler��
			# �����ṩһ�� ChannelPipeline,���� Handler ���뵽 ChannelPipeline
				# Ψһ���󷽷�
				protected abstract void initChannel(C ch) throws Exception;
				
		ChannelInboundHandler
			# һ����õ�Handler�ӿ�
			# ���Handler�����þ��Ǵ�����յ�����ʱ���¼���Ҳ����˵�����ǵ�ҵ���߼�һ�����д�����Handler����
			# ChannelInboundHandler ���������������ǵĺ���ҵ���߼���
			# һЩʵ����
				ChannelInboundHandlerAdapter
					# ʵ����

		ChannelOutboundHandler
			#��һ����õ�Handler�ӿ�
			# ���Handler�����þ��Ǵ�����Ӧ�ͻ�������ʱ���¼�
			# һЩʵ����
				ChannelOutboundHandlerAdapter
					# ʵ����

------------------------
ChannelPipeline			|
------------------------
	# һ��NettyӦ�û���ChannelPipeline���ƣ����ֻ�����Ҫ������ EventLoop �� EventLoopGroup,��Ϊ�������������¼������¼�������ء�
	# ChannelPipeline������Handler��˳����ִ��
	# �ö����ȡ��ʽ
		SocketChannel socketChannel =  ...;
		ChannelPipeline channelPipeline = socketChannel.pipeline();

	# ����
		ChannelPipeline addLast(ChannelHandler... handlers);
			* 

------------------------
EventLoops				|
------------------------
	# Ŀ����ΪChannel����IO����,һ��EventLoop����Ϊ���Channel����
	# EventLoopGroup �������� EventLoop
	# ������ʽ
		EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
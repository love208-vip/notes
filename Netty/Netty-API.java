NioEventLoopGroup
	# ����������I/O�����Ķ��߳��¼�ѭ����
	# Netty �ṩ����಻ͬ�� EventLoopGroup��ʵ����������ͬ�Ĵ��䡣

AbstractBootstrap
	# io.netty.bootstrap.AbstractBootstrap

ChannelHandlerAdapter 
	# io.netty.channel.ChannelHandlerAdapter

ChannelHandler
	# io.netty.channel.ChannelHandler
	# handler �����Ľӿ�



SimpleChannelInboundHandler
	# io.netty.channel.SimpleChannelInboundHandler
	# Client��Handler�̳�
	# ���յ����ݺ���Զ�release������ռ�õ�Bytebuffer��Դ(�Զ�����Bytebuffer.release())��

ChannelInboundHandlerAdapter
	# io.netty.channel.ChannelInboundHandlerAdapter
	# Server��Handler�̳�
	# �����ʵ���� ChannelInboundHandler �ӿ�
	# ���ڽ���ֻ��Ҫ�̳� ChannelInboundHandlerAdapter ����������Լ�ȥʵ�ֽӿڷ���


ChannelInboundHandler
	# io.netty.channel.ChannelInboundHandler
	#  ChannelInboundHandler �ӿ��ṩ������¼�����Ľӿڷ�����Ȼ������Ը�����Щ������


ByteToMessageDecoder
	# ChannelInboundHandler ��һ��ʵ���࣬�������ڴ������ݲ�ֵ������ϱ�úܼ�

ReferenceCountUtil
	# io.netty.util.ReferenceCountUtil
	# ��̬����
		public static boolean release(Object msg);
		public static boolean release(Object msg, int decrement);

ServerBootstrap
	# ����
	option(ChannelOption.SO_BACKLOG,128);
		* ϵͳ�ں�,TCPά���������еĳ��ȵĺ�

		
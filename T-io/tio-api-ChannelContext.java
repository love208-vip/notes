----------------------------
ChannelContext				|
----------------------------
	# ChannelContext<SessionContext, P extends Packet, R>
	# ͨ��������,������
	# ����
		ClientChannelContext<SessionContext, P extends Packet, R> 
		ServerChannelContext<SessionContext, P extends Packet, R> 

	# ����

	# ���췽��
		public ChannelContext(GroupContext<SessionContext, P, R> groupContext, AsynchronousSocketChannel asynchronousSocketChannel);
		

		
----------------------------
ClientChannelContext		|
----------------------------
	# �ͻ���
	# ����
	# ����
	# ���췽��
		public ClientChannelContext(GroupContext<SessionContext, P, R> groupContext, AsynchronousSocketChannel asynchronousSocketChannel);


		
----------------------------
ServerChannelContext		|
----------------------------
	# �����
	# ����
	# ����
	# ���췽��
		public ServerChannelContext(GroupContext<SessionContext, P, R> groupContext, AsynchronousSocketChannel asynchronousSocketChannel);

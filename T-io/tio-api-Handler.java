----------------------------
AioHandler					|
----------------------------
	# AioHandler<SessionContext, P extends Packet, R>
	# �ӿ�,�ǿͻ��˺ͷ���� Hanlder �Ķ������
	# ���󷽷�
		R handler(P packet, ChannelContext<SessionContext, P, R> channelContext) throws Exception;
			* ������Ϣ��

		ByteBuffer encode(P packet, GroupContext<SessionContext, P, R> groupContext, ChannelContext<SessionContext, P, R> channelContext);
			* ����,�Ѷ���ת��Ϊ Buffer

		P decode(ByteBuffer buffer, ChannelContext<SessionContext, P, R> channelContext) throws AioDecodeException;
			* ����,�� Buffer ת��Ϊ����
	
	# �ӽӿ�	
		ClientAioHandler <SessionContext, P extends Packet, R>
			* �ͻ���Handler�ӿ�
		ServerAioHandler <SessionContext, P extends Packet, R> 
			* �����Handler�ӿ�
		
	
----------------------------
ClientAioHandler			|
----------------------------
	# �ͻ���Hander
	# �� AioHandler �Ļ�����,���������һ�����������ĳ��󷽷�
	# ���󷽷�
		P heartbeatPacket();
			* ����������

----------------------------
ServerAioHandler			|
----------------------------
	# �����Handler
	# �� AioHandler �Ļ�����,δ����κεĳ��󷽷�

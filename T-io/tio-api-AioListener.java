-----------------------
AioListener				|
-----------------------
	# AioListener<SessionContext, P extends Packet, R>
	# �ӿ�
	# �ӽӿ�
		 ClientAioListener <SessionContext, P extends Packet, R> 
			* �ͻ��˼���
		 ServerAioListener <SessionContext, P extends Packet, R>
			* ����������

	# ���󷽷�
		void onAfterConnected(ChannelContext<SessionContext, P, R> channelContext, boolean isConnected, boolean isReconnect) throws Exception;
			* ���ӽ����󴥷�,���Ӳ�һ���ǽ����ɹ���,��Ҫ��ע���� isConnected
			* channelContext	
			* isConnected		�Ƿ����ӳɹ�,true:��ʾ���ӳɹ���false:��ʾ����ʧ��
			* isReconnect �Ƿ�������, true: ��ʾ�����������ӣ�false: ��ʾ���ǵ�һ������

		void onAfterSent(ChannelContext<SessionContext, P, R> channelContext, P packet, boolean isSentSuccess) throws Exception;
			* ��Ϣ�����ͺ󴥷��÷���
			* channelContext
			* packet
			* isSentSuccess	true:���ͳɹ���false:����ʧ��

		void onAfterReceived(ChannelContext<SessionContext, P, R> channelContext, P packet, int packetSize) throws Exception;
			* ����ɹ��󴥷�������
			* channelContext
			* packet
			* packetSize

		void onAfterClose(ChannelContext<SessionContext, P, R> channelContext, Throwable throwable, String remark, boolean isRemove) throws Exception;
			* ���ӹر�ǰ�󴥷�������
			* channelContext
			* throwable		�п���Ϊ��
			* remark		�п���Ϊ��
			* isRemove		�Ƿ���ɾ��

-----------------------
ClientAioListener		|
-----------------------
	# �ͻ��˼����ӿ�
	# ��ǰ�汾δ�����κγ��󷽷�
	
-----------------------
ServerAioListener		|
-----------------------
	# ����˶˼����ӿ�
	# ��ǰ�汾δ�����κγ��󷽷�

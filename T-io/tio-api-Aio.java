--------------------------------
Aio								|
--------------------------------
	# ����AIP,˽�л����캯��,�޷�����ʵ��
	# ���Ǿ�̬����

--------------------------------
Aio-��̬����					|
--------------------------------	
	# ��Ϣ�������
		void send(ChannelContext<SessionContext, P, R> channelContext, P packet);
			* ��������

		void send(GroupContext<SessionContext, P, R> groupContext, String ip, int port, P packet);
			* ָ���˵�����

		void sendToAll(GroupContext<SessionContext, P, R> groupContext, P packet,ChannelContextFilter<SessionContext, P, R> channelContextFilter);
			* ����Ϣ����������
			* ͨ�� channelContextFilter ������ͨ��

		void sendToGroup(GroupContext<SessionContext, P, R> groupContext, String groupid, P packet);
			* ������Ϣ����������
			* ������ ���� groupId Ϊ groupid ������

		void sendToGroup(GroupContext<SessionContext, P, R> groupContext, String groupid, P packet,ChannelContextFilter<SessionContext, P, R> channelContextFilter);
			* ������Ϣ����������
			* ������ ���� groupId Ϊ groupid ������
			* channelContextFilter �ٴι�������

		void sendToSet(GroupContext<SessionContext, P, R> groupContext,ObjWithLock<Set<ChannelContext<SessionContext, P, R>>> setWithLock, P packet, ChannelContextFilter<SessionContext, P, R> channelContextFilter);
			* ����Ϣ��ָ������

		void sendToUser(GroupContext<SessionContext, P, R> groupContext, String userid, P packet);
			* ������Ϣ��ָ��������
			* �����Ӱ��û� userid Ϊ,userid

		<SessionContext, P extends Packet, R> P synSend(ChannelContext<SessionContext, P, R> channelContext, P packet, long timeout);
			* ͬ����Ϣ����
	
	# ��ȡͨ�����������
		ChannelContext<SessionContext, P, R> getChannelContextByClientNode(GroupContext<SessionContext, P, R> groupContext,String clientIp, Integer clientPort);
			* ���ݶ˵���Ϣ(ip&port)��ȡͨ��

		ChannelContext<SessionContext, P, R> getChannelContextByUserid(GroupContext<SessionContext, P, R> groupContext,String userid);
			* �����û�ID��ȡͨ��

		ObjWithLock<Set<ChannelContext<SessionContext, P, R>>> getChannelContextsByGroup(GroupContext<SessionContext, P, R> groupContext, String groupid);
			* �����û���ID,��ȡһ��ͨ��

		ChannelContext<?, ?, ?> getChannelContextById(String id);
			* ����ͨ��ID��ȡͨ��
		
		 
			

	# �Ƴ�ͨ�����������
		void remove(ChannelContext<SessionContext, P, R> channelContext, String remark);
			
		void remove(ChannelContext<SessionContext, P, R> channelContext, Throwable throwable, String remark);
			
		void remove(GroupContext<SessionContext, P, R> groupContext, String clientIp, Integer clientPort, Throwable throwable,String remark);
			

	# ��Դ�ر����
		void close(ChannelContext<SessionContext, P, R> channelContext, String remark);
			* �ر���Դ,����ע��Ϣ

		void close(ChannelContext<SessionContext, P, R> channelContext, Throwable throwable, String remark);
			* �ر���Դ,����ע&�쳣

		void close(GroupContext<SessionContext, P, R> groupContext, String clientIp, Integer clientPort, Throwable throwable,String remark);
			* �ر���Դ��Ϣ,����ע,�ͻ���IP,�˿�,�쳣...����Ϣ
	
	# �����
		void bindGroup(ChannelContext<SessionContext, P, R> channelContext, String groupid);
			* ��ָ����ͨ����ָ����Ⱥ��

		void bindUser(ChannelContext<SessionContext, P, R> channelContext, String userid);
			* ��ָ����ͨ����ָ�����û�
	
	# ��������
		void unbindGroup(String group, ChannelContext<SessionContext, P, R> channelContext);
			* ���'ָ��ͨ����ָ��Ⱥ��'�İ�

		void unbindGroup(ChannelContext<SessionContext, P, R> channelContext);
			* ���'ָ��ͨ��������Ⱥ��'����Ϣ

		void unbindUser(ChannelContext<SessionContext, P, R> channelContext);
			* ���'ָ��ͨ�����û�'����Ϣ
		
	



	



	






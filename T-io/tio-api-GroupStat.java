--------------------
GroupStat			|
--------------------
	# ר������ͳ�����ݵĲ��
	# ���ò��
		* ͨ���ͻ��˺ͷ������˵� GroupContext ������
		ClientGroupContext
		ServerGroupContext

	# ����
		ClientGroupStat
		ServerGroupStat

	# ����
		private AtomicLong closed = new AtomicLong();
			* �ر��˶�������

		private AtomicLong receivedPacket = new AtomicLong();
			* ���յ�����Ϣ��
		private AtomicLong receivedBytes = new AtomicLong();
			* ���յ�����Ϣ�ֽ���

		private AtomicLong handledPacket = new AtomicLong();
			* �����˵���Ϣ����

		private AtomicLong sentPacket = new AtomicLong();
			* �����˵���Ϣ����
		private AtomicLong sentBytes = new AtomicLong();
			* �����˵��ֽ���

	# ����
		getter & setter

--------------------
ClientGroupStat		|
--------------------
	# �ͻ���ͳ�Ʋ��
	# ����
		* Ŀǰ�汾δ����µ�����

--------------------
ServerGroupStat		|
--------------------
	# �����ͳ�Ʋ��
	# ����
		private AtomicLong accepted = new AtomicLong();
			* �����˶�������
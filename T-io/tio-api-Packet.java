---------------------------
Packet						|
---------------------------
	# ��Ϣ����ĸ���
	# ����
		EncodedPacket
	# Packet-����
		private Integer synSeq = 0;
			* ͬ������ʱ����Ҫ��ͬ�����к�
		private ByteBuffer preEncodedByteBuffer = null;	
			* Ԥ�������bytebuffer
			* �����ֵ��Ϊnull�����������ԭ����encode()(����ת��ΪBuffer)����

	# Packet-����	
		ByteBuffer getPreEncodedByteBuffer();
		Integer getSynSeq();
		String logstr()
		void setPreEncodedByteBuffer(ByteBuffer preEncodedByteBuffer);
		void setSynSeq(Integer synSeq);

---------------------------
EncodedPacket				|
---------------------------
	# Packet ����
	# ����
		private byte[] bytes;

	# ����
		public EncodedPacket(byte[] bytes){
			this.bytes = bytes;
		}

		public byte[] getBytes(){
			return bytes;
		}
		public void setBytes(byte[] bytes){
			this.bytes = bytes;
		}
------------------------
Node					|
------------------------
	# ��ʾĿ�����ڵ�

------------------------
Node-����				|
------------------------
	private String ip;
	private int port;

------------------------
Node-����				|
------------------------
	# ���췽��
		public Node(String ip, int port){
			super();
			if (StringUtils.isBlank(ip) || "0:0:0:0:0:0:0:0".equals(ip)){
				ip = "0.0.0.0";
			}
			this.setIp(ip);
			this.setPort(port);
		}
	
	# ��ͨ����
		* ����getter&setter
	

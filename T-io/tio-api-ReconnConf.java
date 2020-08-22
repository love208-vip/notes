----------------------------
ReconnConf					|
----------------------------
	# ��������

----------------------------
ReconnConf-����				|
----------------------------
	private long interval = 5000;
		* �����ļ��ʱ�䣬��λ����

	private int retryCount = 0;
		*  ��������������������������ô��ζ�ʧ��ʱ������������0�͸�����һֱ����

	LinkedBlockingQueue<ChannelContext<SessionContext, P, R>> queue = new LinkedBlockingQueue<ChannelContext<SessionContext, P, R>>();

	private ThreadPoolExecutor threadPoolExecutor = null;
		* �����������̳߳�

----------------------------
ReconnConf-����				|
----------------------------
	# ��̬����
		void put(ClientChannelContext<SessionContext, P, R> clientChannelContext);
		boolean isNeedReconn(ClientChannelContext<SessionContext, P, R> clientChannelContext, boolean putIfTrue);
	
	# ��Ա����
		long getInterval();
		void setInterval(long interval);
		
		void setRetryCount(int retryCount);
		int getRetryCount();

		ThreadPoolExecutor getThreadPoolExecutor();
		LinkedBlockingQueue<ChannelContext<SessionContext, P, R>> getQueue();

		
	# ���췽��
		public ReconnConf(){
			if (threadPoolExecutor == null){
				synchronized (ReconnConf.class){
					if (threadPoolExecutor == null){
						threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), 60L, TimeUnit.SECONDS,
								new LinkedBlockingQueue<Runnable>(), DefaultThreadFactory.getInstance("t-aio-client-reconn"));
					}
				}

			}

		}

		public ReconnConf(long interval){
			this();
			this.setInterval(interval);
		}
		public ReconnConf(long interval, int retryCount){
			this();
			this.interval = interval;
			this.retryCount = retryCount;
		}
----------------------
logging					|
----------------------	
	* ��־���
	* logging ��¼���Ļ�ȡ
		1,�������ȡ�Զ���� Logger,��Ĭ��ʹ�õ�����Ϊ: 'rootLogger' ����־��¼��

	* logger ϵͳ��ϵ
		1,����ְ��	
			logger 
				* ��־��¼��,���������־��¼

			handler
				* ��־������,��ͬ��hanlder,����ݲ�ͬ��ʽ������־
				* һ�� logger �����ж�� handler
			
			Filter
				* ��־������,��������һЩ���˹���
				* ������������������,logger �Ż�ִ����־��¼
				* һ�� logger �����ж�� Filter

		2,��ϵͼ
			logger(��־��¼��)
				|-handler(��־������)
					|-formatter(��־��ʽ��ģ��)
					|-setLevel(��־�ȼ�)
				|-filter(��־������)
				|-level(��־�ȼ�)


	* handlers
		# ϵͳԤ����Handler
		StreamHandler 
		FileHandler 
		BaseRotatingHandler 
		RotatingFileHandler 
		TimedRotatingFileHandler 
		SocketHandler 
		DatagramHandler
		SMTPHandler 
		SysLogHandler
		NTEventLogHandler 
		MemoryHandler 
		HTTPHandler 
		WatchedFileHandler
		QueueHandler 
		NullHandler 
	

----------------------
logging-��������		|
----------------------	
	int DEBUG
		* 10
	int INFO
		* 20
	int WARNING
		* 30
	int ERROR
		* 40
	int CRITICAL
		* 50

----------------------
logging-ģ�麯��		|
----------------------	
	None debug()
	None info()

	None warning()
		* Ĭ�ϼ���
	None error()
	None critical()
		* ��־���,����ȼ��ɵ͵���
	
	# Logger
	logging.Logger getLogger(loggername)
		* ��ȡһ��ָ�����Ƶ���־��¼��
		* '��λ�ȡͬ����Logger,���صĶ�ֻ��ͬһ��'
		* �����ָ������,�򷵻�����Ϊ 'rootLogger' ��logger
		* ��������
			level	# ָ����־����
	
	# Handler ���
	logging.Formatter Formatter(format)
		* ��ȡһ����ʽ������־��Ϣ�� Formatter,����ָ����ʽ��ģ��
		* ��������
			fmt		# ָ����ʽ��ģ��
			datefmt	# ָ�����ڸ�ʽ����ģ��
		
	logging.FileHandler FileHandler(logfile)
		* ��ȡһ���ļ�Handler,����ָ����־�ļ���ַ
		* ��������
			encoding	# ָ�������ʽ
		
	logging.StreamHandler StreamHandler()
		* ��ȡһ����׼IO����� Handler
	
	#  Filter
	logging.Filter filter()
		* ��ȡһ�� logger filter
		* ����ָ�� logger �Ĺ��˹���
		* ���˹���,���ַ�����ʽָ��,����ִ����־��¼�ļ�¼������,���,ʹ�� '.'�ָ�
			filter = logging.Filter('mylogger.child1.child2')
			
----------------------
logging.Logger			|
----------------------	
	None debug()
	None info()

	None warning()
		* Ĭ�ϼ���
	None error()
	None critical()
		* ��־���,����ȼ��ɵ͵���

	addHandler(Handler)
		* ���һ�� Handler ����ǰ��־��¼��
	
	addFilter(logging.Filter)
		* ���һ�� filter ����ǰ��־��¼��
		* ֻ������ filter ���˹���ļ�¼��,�Ż�ִ����־��¼
		
	None setLevel(level)
		* ���õ�ǰ��־��¼������־����

	basicConfig()
		* �Ե�ǰ��־��¼��,���л���������
		* ��������
			level
				* ������־����,logging ģ��߱�5����־����ĳ���

			format
				* ��ʽ����־��Ϣ,ʹ���ַ�����:�ֵ�ؼ��ָ�ʽ��
				* �ؼ���
					name		# logger������
					asctime		# ��־����ʱ��
					filename	# Python�ű��ļ�����
					lineno		# ��־�����к�
					levelname	# ��־����
					levelno		# ��־�����������Ϣ
					pathname	# ��־����������ģ��,����·��(�п���Ϊ��)
					module		# ��־������ģ����
					funcName	# ��־�����ĺ�����
					message		# ��־����
				* demo
					"ʱ��:%(asctime)s �ļ�����:%(filename)s �к�:%(lineno)s ��־����:%(levelname)s ��־����:%(message)s"
					ʱ��:2017-06-11 18:17:40 �ļ�����:Main.py �к�:18 ��־����:CRITICAL ��־����:critical
			
			datefmt
				* ���ڸ�ʽ����ʽ
			
			filename
				* �����ָ�����ļ�
				* ��ָ�����ļ���,��־�����������׼�����(��Ļ)
			
			filemode
				* ����ļ���IOģʽ
					a	# Ĭ��ģʽ,���
					w	# дģʽ

----------------------
logging.handler			|
----------------------	
	setFormat(logging.Formatter)
		* ������־��Ϣ�� Formatter
	
	setLevel(level)
		* ����Hanlder����־�ȼ�
		
----------------------
logging-Demo			|
----------------------	
# ��ȡLogger,����ģʽ
	import logging
	def get_logger(name,*,file,encoding,**kws):
		logger = None
		def func():
			nonlocal logger
			if(logger):
				return logger
			logger = logging.getLogger(name)
			logger.setLevel(kws['level'] if 'level' in kws else logging.DEBUG)
			
			streamHandler = logging.StreamHandler()
			fileHandler = logging.FileHandler(file,encoding = encoding)
			
			formatter = logging.Formatter(fmt = "ʱ��:%(asctime)s �ļ�����:%(filename)s �к�:%(lineno)s ��־����:%(levelname)s ��־����:%(message)s",datefmt = "%Y-%m-%d %H:%M:%S")
			
			streamHandler.setFormatter(formatter)
			fileHandler.setFormatter(formatter)
			
			logger.addHandler(streamHandler)
			logger.addHandler(fileHandler)
			print('����logger')
			return logger
		return func

	get_logger = get_logger("vin",**{'file':"E:\\python.log",'encoding':"UTF--8",'level':logging.DEBUG})

	print(get_logger())
	print(get_logger())
	print(get_logger())
	print(get_logger())
	# ����logger
	# <Logger vin (DEBUG)>
	# <Logger vin (DEBUG)>
	# <Logger vin (DEBUG)>
	# <Logger vin (DEBUG)>
----------------------------
Log4j-����					|
----------------------------
	# log for (4) java


	log4j2	ʹ��.xml������
	log4j1	ʹ��.properties

----------------------------
Log4j-��־����				|
----------------------------
	fatal(������)
	error
	warn
	info
	debug 
	trace(��ջ)

----------------------------
Log4j-Log4j1				|
----------------------------
	1,����־���л�ȡ��logger����
		Logger logger = Logger.getLogger(LogDemo.class);
	2,����Ҫ����ĵط�,���в�ͬ�������־���
		logger.fatal("�����Ĵ���");
		logger.error("error");
		logger.warn("����");
		logger.info("INFO");
		logger.debug("DEBUG");
		logger.trace("��ջ");

	3,���������ļ�[�������]
		log4j.rootLogger=ERROR,demo
			# ������־�ļ���,�Լ�������Щ���úõ���Ϣ

		log4j.appender.demo=org.apache.log4j.ConsoleAppender
			# ����һ��׷����
			# ConsoleAppender:ָ����־Ҫ���������̨
			# demo:��ʵ��֪������,�����Լ�����

		log4j.appender.demo.Target=System.err
			# ʹ�����涨���console��:Target����
			# ����������ĵĸ�ʽ/System.err����out

		log4j.appender.demo.layout=org.apache.log4j.PatternLayout
			# ʹ�����涨���console��:layout����
			#	�����岼��
			#	PatternLayout:һ�ֲ���

		log4j.appender.demo.layout.ConversionPattern=[%-5p][%d{yyy-MM-dd HH:mm:ss}] %C %L %m%n
			# ʹ�����涨���console��:layout���Ե�:ConversionPattern	ģʽ�����������ʽ
	
	4,���������ļ�[������ı�]
		log4j.appender.demo=org.apache.log4j.FileAppender
			# ����׷����,��������ı���
		
		log4j.appender.demo.File=c:/log.txt
			# ������־�ļ���λ��

		log4j.appender.demo.layout=org.apache.log4j.PatternLayout
			# ���岼��

		log4j.appender.demo.layout.ConversionPattern=[%-5p][%d{yyy-MM-dd HH:mm:ss}] %C %L %m%n
			# ���������ʽ
		
		# ���ַ�ʽ,��־�ļ��᲻�ϵĵ���,���Խ��Խ��

	
	5,���������ļ�[������־�ļ�]
		* Ҳ�ǰ���־������ļ�,ֻ����־���Թ�������ʽ�洢
		* �ﵽָ����С��,�����½����ļ�

		log4j.appender.demo=org.apache.log4j.RollingFileAppender
			# ����׷����,�ǹ��������

		log4j.appender.demo.File=c:/log.txt
			# ������־�ļ�λ��

		log4j.appender.demo.MaxFileSize=10KB
			# �����ļ�����С
		
		log4j.appender.demo.layout=org.apache.log4j.PatternLayout
			# ���岼��
		
		log4j.appender.demo.layout.ConversionPattern=[%-5p][%d{yyy-MM-dd HH:mm:ss}] %C %L %m%n
			# ���������ʽ

----------------------------
Log4j-Log4j2				|
----------------------------
	# ����汾,��ʹ��xml��ʽ����Ϊ�����ļ���
		* ������ѹ���ļ�����ʽ���洢��־�ļ�

	# Maven
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>2.6.2</version>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
			<version>2.6.2</version>
		</dependency>
	
	# ����汾�� Logger ��ȡ������һ��
		private static Logger logger = LogManager.getLogger();
	
	# ����xml����,�Ǹ�ֻ�Ǳ��˸���ʽ.������û��ô��

----------------------------
Log4j-slf4j					|
----------------------------
	#  һ����Ŀֱ�����������OK�ˣ���Ϊ�����Զ�������LO4J

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
	* ע�ⶼ�� slf4j������

	# ��������DEBUG,���滷����INFO

	LOGGER.debug("�����µ���Ʒ:"+item+"	����:"+desc);

	LOGGER.debug("�����µ���Ʒ:{},����{}",ItemDTO,desc);
		> "{}",����ռλ��,��Ѻ���ڶ���������䵽��һ��"{}",
		> ���������������ڶ���"{}",
		> ��������... ...
	
	# ʵ�ʿ����л���Ҫ�Ӹ��ж�
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("�����µ���Ʒ:"+item+"	����:"+desc);
		}
		* ��Ϊִ�е�����,�����INFO����Ļ�,��ô������������ǻ���ȥִ�����,�˷�����
		* ����������ʹ��ǰ���ԼӸ��ж�,�Ƿ��� DUBUG����,�ǵĻ���ִ����־,���ǵĻ�����
		* ��Ϊ�ж��������ܱȽϵ�
		* ����	LOGGER.isDebugEnabled() �ж��Ƿ��� DEBUG������,���������ļ����ж�,�����е�
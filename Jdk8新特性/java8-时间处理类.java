----------------------------
JAVA8������-ǰ��			|
----------------------------
	# ԭ��ʱ��API���ڵ�����
		* ԭ����API
			Calendar
			Date
			SimpleDateFormat

		* ������
		* ���Ҷ������̰߳�ȫ��

	# �µ����
		java.time		
			* ʱ��API
			LocalDate			//��������
			LocalTime			//����ʱ��
			LocalDateTime		//��������ʱ��
			Instant				//ʱ���
			OffsetDateTime		//����ʱ��ƫ��
			OffsetTime			//ʱ��ƫ��
			Period				//������������֮��ļ��
			Duration			//��������ʱ��֮��ļ��

		java.time.zone
			* ʱ��API
			ZoneId				//ʱ��
			ZoneOffset			//ʱ��ƫ��
				ZoneOffset.ofHours(8);
		java.time.temporal
			* ʱ�������API
			
		java.time.format
			* ��ʽ��API
			DateTimeFormatter
			DateTimeFormatterBuilder
			DecimalStyle
		
		TemporalAdjuster
			* ʱ��У����,��ʵ���ǵ���ʱ��
		TemporalAdjusters


----------------------------
JAVA8������-LocalDate		|
----------------------------
	* LocalDate��ʹ��ISO������ʾ������.
	* ���÷���
		LocalDate LocalDate.now();
			* ��ȡϵͳ��ǰ����

		LocalDate LocalDate.of(int year,int month,int dayOfMonth);
			* ����ָ�����ڴ���LocalDate����

		int getYear();
			* ���������е����

		Month month = localDate.getMonth();
			* ���������е��·�,����ֵ�� Month ����

		int getMonthValue();
			* ���������е��·�,����ֵ�� int 

		int getDayOfMonth();
			* �����·��е���

		boolean isLeapYear();
			* �Ƿ�������

		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
			* ��ȡ���ڼ�,����ֵ�� DayOfWeek ����

		int get(ChronoField chronoField);
			* ���ݲ���(ö��),����ָ�����͵�����
			* ��ѡֵ 
				ChronoField.YEAR				//���
				ChronoField.MONTH_OF_YEAR		//��
				ChronoField.DAT_OF_MONYH		//��

		LocalDate parse(String date);
			* �����ַ���,������LocalDate����
			* LocalDate date = LocalDate.parse("2014-03-18");
		
		LocalDate parse(String time,DateTimeFormatter matter);
			* �����ַ����� matter �ĸ�ʽ,������LocalDate����

		atTime(hour,minute,second);
			* ���� ʱ����,���� LocalDateTime ����
		
		atTime(time);
			* ���� LocalTime ����,���� LocalDateTime ����
		
		LocalDate withYear(int year);
			* ����һ���µ� LocalDate ����,�¶������ year���޸�,�����Ķ���ԭ�����������һ��һ��
		
		LocalDate withDateOfMonth(int day);
			* ͬ��,���ص��ǲ�ͬ�·ݵ� LocalDate
		
		with(ChronoField filed,int num);
			* ͬ��,�޸ĵ��� filed ��ʾ�Ĳ���,num Ϊ�޸ĵ�ֵ
		
		LocalDate plusWeeks(int num);
			* ��ǰʱ��,���n��
		
		LocalDate minusYears(int num);
			* ��ǰʱ���ȥn��
		
		plus(int num,ChronoField filed);
			* ���� filed ��ʾ�Ĳ���,��� num ����λ

		LocalDate plusYears(int year);
			* ��Ӷ�����
		LocalDate plusMonths(int month);
			* ��Ӷ��ٸ���
			* '���кܶ����ʱ�����API,��һ��'
		
		String formar(DateTimeFormatter matter);
			* ���� DateTimeFormatter ���ر���ʽ�����ʱ���ַ���

	* ��������ɸ� Calendar ��Ⱦ��ǱȽϾ�ȷ
	  Calendar ��ȡ��������,�·ݻ�Сһ����,������Ҫ��1����.������Ͳ�����

----------------------------
JAVA8������-LocalTime		|
----------------------------
	* LocalTime��������ʾһ���е�ʱ��
	* �󲿷ַ������� LocalDate ����,��������ҩ
	* ���÷���
		LocalTime LocalTime.now();
			* ��ȡϵͳ��ǰʱ��,ע��'�ᾫȷ�����뼶��'
			* 22:34:43.851
		LocalTime LocalTime.of(int hour,int minute,int second);
			* ����ָ��ʱ�䴴��LocalTime����
		int getHour();
			* ����Сʱ
		int getMinute();
			* ���ط���
		int getSecond();
			* ������
		LocalTime parse(String time);
			* �����ַ���,������LocalDate����
			* LocalTime time = LocalDate.parse("13:25:11");

		LocalTime parse(String time,DateTimeFormatter matter);
			* �����ַ���,��matter�ĸ�ʽ,������LocalDate����

		atDate(date);
			* ����date����.���� LocalDateTime ����
		
		String formar(DateTimeFormatter matter);
			* ���� DateTimeFormatter ���ر���ʽ�����ʱ���ַ���
		
		LocalTime plusHours(int year);
			* ��Ӷ���Сʱ
		LocalTime plusMinutes(int month);
			* ��Ӷ��ٷ���
			* '���кܶ�������API,��һ��'

----------------------------
JAVA8������-LocalDateTime	|
----------------------------
	* LocalDateTime���ʾϵͳ�����ں�ʱ����
	* ���÷���
		LocalDateTime LocalDateTime.now();
			* ��ȡϵͳ��ǰʱ��
			* 2016-05-24T22:41:30.852
		LocalDateTime LocalDateTime.of(int year,int month,int dayOfMonth,int hour,int minute,int second);
			* ����ָ�������ں�ʱ�䷵��LocalDateTime����
		int getYear();
			* ���������е����
		int getMonth();
			* ���������е��·�
		int getDayOfMonth();
			* �����·��еĵڼ���
		int getHour();
			* ����Сʱ
		int getMinute();
			* ���ط���
		int getSecond();
			* ������
		LocalDateTime withDayOfMonth(int num);
			* �������е�����
		LocalDateTime with(TemporalAdjusters temporalAdjusters);
			* ����ʱ��У�������޸�ʱ��
		LocalDate toLocalDate();
			* ת��Ϊ LocalDate ����
		LocalTime toLocalTime();
			* ת��Ϊ LocalTime ����
		String formar(DateTimeFormatter matter);
			* ���� DateTimeFormatter ���ر���ʽ�����ʱ���ַ���
		LocalDateTime plusYears(int year);
			* ��Ӷ�����
		LocalDateTime plusMonths(int month);
			* ��Ӷ��ٸ���
			* '���кܶ����ʱ�����API,��һ��'

----------------------------
Instant						|
----------------------------
	# ʱ���(1970-1-1)������
	# ��̬����
		Instant now();
			* ���ص�ǰʱ�������
			* Ĭ��ʱ���ȡ����UTCʱ��(��������ʱ��)Ϊ������
		Instant ofEpochSecond(long sencend);
			* ��ȡ1970-1-1 ����ָ���������ʱ�������

			
	# ʵ������
		OffsetDateTime atOffset(ZoneOffset zoneOffset);
			* ���ش�ƫ����(ʱ��)��ʱ������
		long toEpochMilli();
			* ����ʱ�����Ӧ�ĺ���ֵ
		


-------------------------------
JAVA8������-DateTimeFormatter	|
-------------------------------
	* DateTimeFormatter �������ڰ��ַ�������Ϊʱ����
	* ���÷���
		DateTimeFormatter DateTimeFormatter.ofPatterm("yyy-MM-dd");
			* ����ָ����ʱ���ʽ,���� DateTimeFormatter ����
		
	* ��̬�ֶ�(Ԥ�������)
		DateTimeFormatter.BASIC_ISO_DATE;
		DateTimeFormatter.ISO_LOCAL_DATE
			* �������ڸ�ʽ


	* Demo
		DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE;
		LocalDate localDate = LocalDate.parse("1993-12-09",format);
		System.out.println(localDate.toString());
		* ��������LocalDateTime,�����LocalDateTime�Ļ��ͱ���Ҫ���ݽ�������ʱ�����ʽ�����ַ���
		
-------------------------------
JAVA8������-ZonedDateTime��		|
-------------------------------
	* ZonedDateTime�ദ�����ں�ʱ������Ӧ��ʱ��
	* ���÷���
		ZonedDateTime.now();
			* ��ȥϵͳ��ǰ���ں�ʱ��
			* 2016-05-24T22:58:18.475+08:00[Asia/Shanghai]
		String format(DateTimeFormatter formatter);
			* ����ָ�����ڶ������õĸ�ʽ,ת��Ϊ�ַ���
-------------------------------
Duration						|
-------------------------------
	# ����ʱ��֮��ļ��
	# ��̬����
		Duration between(Instant instant1,Instant instant2);
			* ��������ʱ���֮��ļ��
		
		Duration between(LocalTtime localTtime1,LocalTtime localTtime2);
			* ��������ʱ��֮��ļ��
	# ����
		long toMillis();
			* ���غ���ֵ
		


-------------------------------
Preiod							|
-------------------------------
	# ��������֮��ļ��
	# ��̬����
		Preiod between(LocalDate locaDate1,LocalDate localDate2);
			* ������������֮��ļ��

	# ����
		getYears();
			* ��ȡ���
		getMonths();
			* ��ȡ�·�
		getDays();
			* ��ȡ����
		
-------------------------------
TemporalAdjusters				|
-------------------------------
	# ʱ�������
	# 
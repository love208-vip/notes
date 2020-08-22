------------------------------
JDBC						  |
------------------------------
	# JDBC����һЩ�ӿڹ��ɵ�API(Java Data Base Connectivity,java���ݿ�����);
	# �������ݿ�Ĳ���
		��ע������(ֻ��һ��)
		�ڽ�������(Connection)
		�۴���ִ��SQL���(Statement)
		��ִ�����
		�ݴ���ִ�н��(ResultSet)
		���ͷ���Դ
	# MySql����url��ʽ
		* JDBC:��Э��:������//������:�˿�/���ݿ���?������=����ֵ&
		* ��������:"jdbc:mysql://www.cqsic.com:3366/wuyedb?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true"
		
------------------------------
JDBC-API					  |
------------------------------
	DriverManager
		# ��̬����
			Connection getConnection(String url, String user, String password) ;
				* ����URL�û�����,��ȡһ������
	Connection
		# ����һ�����ݿ�����
		# ʵ������
			Statement createStatement(); 
				* ����һ��Statement����
			PreparedStatement prepareStatement(String sql); 
				* ����SQL������һ��PreparedStatement����
			CallableStatement prepareCall(String sql);
				* ����һ��CallableStatement�������������ݿ�洢����
			setAutoCommit(boolean transaction);
				* �����ֵΪ false �����ֶ�����,��Ҫ�ֶ�ִ�� commit �Ż��ύ
			commit();
				* �ύ����
			rollback();
				* �ع�����

	Statement
		# ��һ���ӿ�,����ʹ������ִ��SQL���
		# ʵ������
			boolean execute(String sql) ;
				* ִ��SQL
			ResultSet executeQuery(String sql); 
				* ִ�и����� SQL ���� ��䣬����䷵�ص��� ResultSet ���� 
			int executeUpdate(String sql) 
				* ִ�и��� SQL ��䣬��������Ϊ INSERT��UPDATE �� DELETE ��䣬���߲������κ����ݵ� SQL ��䣨�� SQL DDL ��䣩�� 
				* ������Ӱ�������
		|-PreparedStatement
			# Ԥ����SQL��,statement,���Է�ֹSQLע��
			# ʵ������
				 setString(int index, String param);
					* ����һ���ʺŸ�ֵ
					* ��N������(setXxx),���Ը�ֵ��ͬ����������
					* ע��'?'�ŵĽǱ��Ǵ�1��ʼ,������0
				boolean execute() 
					* ִ��SQL�������������κ������ SQL ��䡣 
				ResultSet executeQuery();
					* ִ�м���,�����ظò�ѯ���ɵ� ResultSet ���� 
				int executeUpdate()  
					* ִ�в�������޸����

		|-CallableStatement
			# ���ô洢���̵� statement
	ResultSet
		# SQLִ�н����
		# ʵ������
			first() 
				* ������ƶ����� ResultSet ����ĵ�һ�С�
			next();
				* ָ���Ƶ���һ��,�������һ�з��� true,��֮���� false
			previous(); 
				* ָ���Ƶ���һ��
			getObject(int columnIndex);
				* ��ȡָ�� index �е�����,��Object��ʽ����
			getObject(String columnLabel);
				* ��ȡָ�� ������ ������,��Object��ʽ����
			getString(String columnName); 
				* ��ȡָ���ֶε�String����ֵ
			getString(int columnIndex); 
				* ��ȡָ��������String����ֵ
			* �д����� getXxx();����,������JAVA���ֻ����������͵ķ���ֵ

	Blob 
		# ���������ݶ���
		# ����
			Blob blob = new SeriaBlob(byte[] bytes);	
		# ʵ������
			InputStream blob.getBinaryStream();
				* ��ȡ�� Blob �����еĶ�ȡ��
		

------------------------------
JDBC-��������������			  |
------------------------------
	# "��׼SQL"���ṩ�����������������Ķ�������������
		tinyblob	256B	-- ������(�ֽ�)
		blob		64k
		mediumblob	16M
		longblob	4G
	# "��׼SQL"���ṩ�������������������ı���������
		tinyclob	256B
		clob		645KB
		mediumclob	16MB
		longclob	4G

	# "MYSQL"�ж���Ĵ������ַ�����
		tinytext	256B
		text		64KB
		mediumtext	16MB
		longtext	4G
	
		* һ��,��MYSQL�д���������ݵ�ʱ����Ҫ����my.ini������������
		* max.allowed packet=10485760
		* ��ʾ����MYSQL�����ݴ洢��С
	
	# JAVA��������������
		* ��Ҫ�� Blob blob = new SeriaBlob(byte[] bytes); ����
		* ����
			public static void set()throws Exception 
			{
				Connection conn = JDBCUtils.getConnection();
				String sql = "insert into tab_bin values(?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 1);				//���ݿ�ID�ֶ�
				pstmt.setString(2, "����.mp3");	//����
				/**
				 * ��Ҫ�õ�Blob����
				 * 1,���ļ�,Ŀ����Blob
				 * 3,���ļ����byte[]����
				 * */
				File f = new File("D:\\Demo.mp3");
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
				byte[] bytes = new byte[in.available()];//�����ļ���С���ֽ�����
				in.read(bytes);						
				Blob blob = new SerialBlob(bytes);
				pstmt.setBlob(3, blob);//�������ļ�
				pstmt.executeUpdate();
			}
		* ��ȡ
			public static void get()throws Exception 
			{
				//������Ӷ���
				Connection conn = JDBCUtils.getConnection();
				String sql = "select * from tab_bin";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//pstmtִ�в�ѯ�õ�ResultSet
				ResultSet rs = pstmt.executeQuery();
				//��ȡrs����ΪDate��������
				if(rs.next())
				{
					Blob blob = rs.getBlob("data");
					/**
					 * �� blob���Ӳ���ϵ��ļ�
					 * */
					InputStream in = blob.getBinaryStream();
					BufferedOutputStream bufr = new BufferedOutputStream(new FileOutputStream(new File("C:\\test.mp3")));
					byte[] b = new byte[1024];
					int len = 0;
					while((len = in.read(b)) != -1)
					{
						bufr.write(b, 0, len);
						bufr.flush();
					}
				}
			}
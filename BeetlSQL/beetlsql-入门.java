----------------------------
Beetlsql-����				|
----------------------------


----------------------------
Beetlsql-HelloWorld			|
----------------------------
	//����Դ
	ConnectionSource connectionSource = ConnectionSourceHelper.getSimple(DRIVER,URL,USERNAME,PASSWORD);
	//���ݿ�����
	DBStyle dbStyle = new MySqlStyle();
	//SQL��Դ������
	SQLLoader sqlLoader = new ClasspathLoader("/sql");
	//����ƥ�����
	UnderlinedNameConversion underlinedNameConversion = new UnderlinedNameConversion();
	//SQLManager
	SQLManager sqlManager = new SQLManager(dbStyle,sqlLoader,connectionSource,underlinedNameConversion,new Interceptor[]{new DebugInterceptor()});

	//������¼
	User user = new User();
	user.setAge(23);
	user.setName("KevinBlandy");
	sqlManager.insert(user);

	//������������
	int id = 1;
	user = sqlManager.unique(User.class,id);
	System.out.println(user);

	//���ݷǿղ�������
	User updateUser = new User();
	updateUser.setId(1);
	updateUser.setAge(22);
	sqlManager.updateTemplateById(updateUser);

	//���ݷǿղ�������
	User queryUser = new User();
	queryUser.setName("KevinBlandy");
	List<User> users = sqlManager.template(queryUser);

	//ʹ��md/sql�ļ����м���
	User query = new User();
	query.setName("KevinBlandy");
	List<User> userList = sqlManager.select("user.select",User.class,query);



ConnectionSource
	# ����Դ
	# ֱ�Ӵ���
		ConnectionSource source = ConnectionSourceHelper.getSimple(String driverClass, String url, String userName, String passWord);
	# ͨ�����е�����Դ����
		ConnectionSource source = ConnectionSourceHelper.single(DataSource dataSource);
	# �������������Դ
		ConnectionSource source = ConnectionSourceHelper.getMasterSlave(DataSource master,DataSource[] slaves)
	
DBStyle
	# 

SQLLoader
	# 

UnderlinedNameConversion
	# 

SQLManager
	# ����
		genPojoCodeToConsole(String tableName);
			* �������ݱ�����,����POJO,���ҰѴ������������̨
		genSQLTemplateToConsole(String tableName);
			* �������ݱ����ƴ���templateģ��,���Ұ�SQL���������̨
		

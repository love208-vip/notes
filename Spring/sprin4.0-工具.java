---------------------------------------
Resource								|
---------------------------------------
	# ���Լ��� classpath Ŀ¼�µ���Դ�ļ�
		Resource resource = new ClassPathResource("/zhsq-core.properties");
		Properties props props = PropertiesLoaderUtils.loadProperties(resource);
	

---------------------------------------
Environment								|
---------------------------------------
	# org.springframework.core.env.Environment

---------------------------------------
DigestUtils								|
---------------------------------------
	# ���ܽ��ܹ�����
	# ���Ǿ�̬����
	# md5����
		md5DigestAsHex("Kevin".getBytes())

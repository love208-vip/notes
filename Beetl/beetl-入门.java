-----------------------
Beetl-����				|
-----------------------
	# ���˿�Դģ������
	# ��ţ��˵������Freemarker��6��,JSP������
	# ����
		http://www.ibeetl.com/
	# ����:��.��
	# Maven
		<dependency>
			<groupId>com.ibeetl</groupId>
			<artifactId>beetl</artifactId>
			<version>2.7.13</version>
		</dependency>
	
	# Hello World
		StringTemplateResourceLoader stringTemplateResourceLoader = new StringTemplateResourceLoader();
		Configuration configuration = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(stringTemplateResourceLoader,configuration);
		Template template = groupTemplate.getTemplate("hello,${name}");
		template.binding("name","KevinBlandy");
		String result = template.render();
		System.out.println(result);


-----------------------
Beetl-��������			|
-----------------------
	DELIMITER_STATEMENT_START=@
	DELIMITER_STATEMENT_END=
	RESOURCE.root= /
		* ģ��Ŀ¼
	RESOURCE.autoCheck = TRUE
		* ���ߵ�ʱ��,�ǵ��޸�Ϊfalse,�����������������
	DIRECT_BYTE_OUTPUT = TRUE
		* ָ��IO���ģʽ��Ĭ����FALSE,��ͨ�����ַ������
		* �ڿ��Ǹ���������£��������ó�true����ϸ��ο��߼��÷�

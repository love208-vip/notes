----------------------------
Beetl-ģ����Դ������		|
----------------------------
	# ��Դ�������Ǹ���Stringֵ��ȡResourceʵ���Ĺ�����
	# ͬʱ��Դ��������Ҫ������Ӧģ������ѯ��ģ���Ƿ�仯�ĵ��á�
	# ����������˵�����迼��ģ����Դ���������ʵ�֣�ֻ��Ҫ�����Լ�����ѡ��ϵͳ�ṩ������ģ����Դ����������

----------------------------
Beetl-�ַ���ģ����Դ������	|
----------------------------
	# StringTemplateResourceLoader
	# �ڴ��� GroupTempalte ������,���������� StringTemplateResourceLoader
	# ������ͨ������ getTemplate(String template); ��uoquģ��ʵ������
		StringTemplateResourceLoader stringTemplateResourceLoader = new StringTemplateResourceLoader();
		Configuration configuration = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(stringTemplateResourceLoader,configuration);
		Template template = groupTemplate.getTemplate("hello,${name}");
	
----------------------------
Beetl-�ļ���Դģ����Դ������|
----------------------------
	# FileResourceLoader
	# ͨ�������,ģ����Դ�����ļ���ʽ�����,���з���ĳһ���ļ�Ŀ¼��
		* ��: webapp/WEB-INF/template
	# ��˿���ʹ�� FileResourceLoader ������ģ��ʵ��
		String root = "E:\\workspace\\kevin-beetl\\src\\main\\resources\\template";
		/*
			ָ���ļ���Ŀ¼,����Ĭ�Ͼ���UTF-8.���Բ���ָ��
		*/
		FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");
		Configuration configuration = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, configuration);
		/*
			��Ŀ¼�л�ȡģ���ļ�,Ҳ�����Ƕ༶Ŀ¼,ʹ��Ŀ¼�ָ���
		*/
		Template template = groupTemplate.getTemplate("/hello.txt");
		template.binding("name","KevinBlandy");
		String result = template.render();
		System.out.println(result);

		* hello.txt
			helo,${name}
	
--------------------------------
Beetl-Classpath��Դģ�������	|
--------------------------------
	# ClasspathResourceLoader
	# ͨ�������,ģ����Դ�Ǵ����jar�ļ����ߺ�Class����һ��
	# ����ʹ��ClasspathResourceLoader������ģ��ʵ��
		/*
			classpathĿ¼�µ�  template,Ҳ���� src/main/resources/template
			�˴��ÿչ��캯������ʾ����·���Ǹ�·�������ַ���Ĭ���ַ���UTF-8.
		*/
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("/template");
		Configuration configuration = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, configuration);
		/*
			templateĿ¼�µ� hello.txt�ļ�
		*/
		Template template = groupTemplate.getTemplate("/hello.txt");
		template.binding("name","KevinBlandy");
		String result = template.render();
		System.out.println(result);

		* * hello.txt
			helo,${name}

--------------------------------
Beetl-WebApp��Դģ�������		|
--------------------------------
	# WebAppResourceLoader
	# ����webӦ�õ���Դģ���������Ĭ�ϸ�·����WebRootĿ¼��
	# Ҳ����ͨ���ƶ�root���������������WebRoot�ĵ�ģ���·��
	# �Ӱ�ȫ�ǿ��ǣ�����ŵ�WEB-INFĿ¼��
		Configuration configuration = Configuration.defaultConfiguration();
		WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader();
		GroupTemplate groupTemplate = new GroupTemplate(webAppResourceLoader, configuration);
	# WebAppResourceLoader �ٶ� beetl.jar ��λ�� WEB-INF/lib Ŀ¼�£���ˣ�����ͨ��WebAppResourceLoader���·�����ƶϳ�WebRoot·���Ӷ�ָ��ģ���·����
	# �������ϻ���һ�㶼����ˣ�����ǿ������������������������ϴ˼��裬����Ҫ���� resourceLoader.setRoot() ��ָ��ģ���·��

--------------------------------
Beetl- ʹ�ö������Դ������		|
--------------------------------
	# ĳЩ����£�ģ����Դ��ֹһ����GroupTemplate������һ��Ĭ�ϵ���Դ��������
	# ���ͨ��gt.getTemplate(key),������Ĭ�ϵ�ResourceLoader����ȡģ�����ݣ�Ȼ��ת��Ϊbeetl�ű����뵽�����
	# ��Ҳ���Դ���������Դ����������ģ�壬ͨ������gt.getTemplate(key,otherLoader)�����;

	GroupTemplate gt = new GroupTemplate(conf,fileLoader)
	//�Զ��壬�ο���һ��
	MapResourceLoader dbLoader = new MapResourceLoader(getData());
	Template t = gt.getTemplate("db:1", dbLoader);

	private Map getData(){
			Map data = new HashMap();
			data.put("db:1", "${a}");
			return data;
	}
	���ڸ����ӵ�ģ����Դ��Դ��Ҳ�����Զ���һ����Դ��������ɣ�

--------------------------------
�Զ�����Դģ�������			|
--------------------------------
	# ��ʱ��ģ����������ļ�ϵͳ��ͬĿ¼������ģ��һ��������ĳ���ļ�ϵͳ������һ�����������ݿ⣬
	# ���е����ģ������Ǽ��ܻ�����ģ�壬��ʱ��Ҫ�Զ�����Դ����
	# �̳� ResouceLoader����ʵ��ģ�幦�ܣ������бʼ�
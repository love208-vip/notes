StringTemplateResourceLoader 
	# �ַ���ģ������������ڼ����ַ���ģ��
FileResourceLoader
	# �ļ�ģ�����������Ҫһ����Ŀ¼��Ϊ��������
ClasspathResourceLoader
	# �ļ�ģ���������ģ���ļ�λ��Classpath��
WebAppResourceLoader
	# ����webapp���ɣ��ٶ�ģ���Ŀ¼����WebRootĿ¼
MapResourceLoader 
	# ���Զ�̬����ģ��
CompositeResourceLoader 
	# ���ʹ�ö��ּ��ط�ʽ

Configuration
	# Ĭ�������,�������ǻ���ȥ����Ĭ�ϵ��ļ�
	# Ĭ���ļ���ַ:/org/beetl/core/beetl-default.properties
	configuration.addPkg(String package);
		* ��� package ��ַ,��ģ����ֱ�ӵ��øð��µ�JAVA�಻��Ҫ��Ӱ���,ֱ��д����

GroupTemplate 
	setSharedVars(Map<String, Object> sharedVars);
		* ���ù������,���κ�ģ��,�κεط������Է��ʵ�
	enableStrict();
		* ���ýű�,��ʵ���ǿ������ϸ�MVCģʽ
	registerVirtualAttributeClass(Class<?> clazz,VirtualClassAttribute virtualClassAttribute);
		* Ϊĳһ����,ע����������
	registerVirtualAttributeEval(VirtualAttributeEval virtualAttributeEval);
		* Ϊĳһ����ע����������
	registerTag(String tagName,Class<?> clazz);
		* ע��һ��tag,tagName ��ʾ��ǩ����,clazz��ʾ Tag ʵ����

Template 
	tempalte.render() 
		* ������Ⱦ���
	template.renderTo(Writer writer) 
		* ��Ⱦ��������Writer��
	template.renderTo(OutputStream outputStream) 
		* ��Ⱦ��������OutputStream��

Context
	# ���Զ��巽��,��ʽ��������ʵ�ֽӿڵĲ���
	# ����ģ��������
		getGlobal(String key);
			* ��ȡȫ�ֱ���
			* UserEntity userEntity = (UserEntity) ((SessionWrapper) context.getGlobal("session")).get(SessionCode.LOGIN_USER);




BeetlGroupUtilConfiguration 
	# ����Spring/spring bootʱ��Ҫ��IOC�����Bean
	setResourceLoader(ResourceLoader resourceLoader)
		* Beetl��Դ�����������δָ�������Զ�����ApplicationContext�������ļ�ʶ��
		* 

BeetlSpringViewResolver 
	# ����Spring/spring bootʱ��ͼ������
	setContentType(String contentType);
		* �������
	


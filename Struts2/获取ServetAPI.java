����������������������������������������������������������������
һ,���							|
����������������������������������������������������������������
	struts2,��һ������ʽ��WEB/MVC���!����ʹ�õ�ʱ��,��װ��һ�е�ServletAPI��
		* Session,request,response,application... ...
	ʹ�ÿ��,������ֱ��ȥʹ����Щ,�������ܻ��ǱȽ��Ѻ�!���Ҫ��,�һ��Ǹ�����!

����������������������������������������������������������������
��,��IOC						|
����������������������������������������������������������������
1,ActionContext	��ȡ Map
	* ͨ���������,���Ի�ȡ������������Map<String,Object>����!
	ActionContext ctx = ActionContext.getContext();
		* �ö�����ֱ�ӷ��ʹ��캯������,˵���˲���new
	get(String name);//����һ��Object,��ʵ���Ǵ�request������ȡ������
	put(String,Object);//��request���������һ������ 
	getApplication();//��ȡServletContext�����Map������
	getSession();//��ȡSession�����Map������
	getParameter(String name);//��ȡ�������
		* ���ص��� Map<String,Object>,���Object��ʵ�Ǹ�����!���������request.getParameterMap();��ʵ��һ������!
	
2,ServletActionContext	��ȡ�������������
	* ͨ���������,���Ի�ȡ��Servlet��������,�Լ�response,������jsp�������,PageContext��������API!
	* ����Ƕ�����new,��������̬��,ֱ���þ���!
	HttpServletRequest	request = ServletActionContext.getRequest();
	HttpSession			session = ServletActionContext.getRequest().getSession();
	ServletContext		application = ServletActionContext.getServletContext();
	HttpServletResponse	response = ServletActionContext.getResponse();
	PageContext			pageContext = ServletActionContext.getPageContext();
	* ����漰��ʹ��Cookie֮���,���б�Ҫͨ�������ȡresponse����ͻ�����ӦCookie

����������������������������������������������������������������
��,IOCע��						|
����������������������������������������������������������������
	��ν��IOCע��,��ʵ����ʵ�ֽӿ�,��д����!
	��ܻ���ݽӿڰѶ�Ӧ��ServletAPI�������Map������ͨ���������ݵ�Action!
1,��ȡMap
	RequestAware,ResponseAware,ContextAware
	* �ⶫ������ô������,���ǻ�ȡ�ӿ�,������Ķ�����֪������ô��!
	* ����ע�����:Map<String,Object>


2,��ȡ�����Ķ�������
	'�ӿ�'						'����'
	ServletRequestAware			setServletRequest(HttpServletRequest request)	
	ServletContextAware			setServletContext(ServletContext context)
	ServletResponseAware		setServletResponse(HttpServletResponse response)
	
	* ��д����,������Action������API������!�ڷ����н��и�ֵ!
	* ����Session����,�Լ�ͨ��request����ȡ!
	
	'��չ',����ʵ��!
		��ʵ���ע����ʹ��struts2�е�һ��interceptorʵ�ֵ�!Ҳ����strutsl.default.xml�е�!
		<interceptor name="servletConfig" class="org.apache.struts2.interceptor.ServletConfigInterceptor"/>
		* ������ interceptor()����,��action�������ж�,���������ĳ���ӿڵ�����,�͵��ýӿڷ���,עֵ
		if(action instanceof xxxx){}
		if(action instanceof xxxx){}
		
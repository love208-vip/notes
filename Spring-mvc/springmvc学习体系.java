1,Spring���ԭ��
	> ǰ�˿�����,������ӳ����,������������,��ͼ������
2,Spring����
	> ��ע��Ĵ�����ӳ����,������������
	> ע��Ĵ�����ӳ����,������������
3,Spring��mybatis/Hibernate/struts2����
4,Springע�⿪��
	> ����ע��
	> ������(������,POJO,����)
	> �Զ��������
5,SpringMVC��struts2����
6,Spring�߼�Ӧ��
	> ������
	> ���ݻ���
	> �ϴ�ͼƬ
	> json���ݽ���
	> RESTful֧��
	> ������
������������������������������������������������������������������������������������
		С��							  |
������������������������������������������������������������������������������������
	['XML��ϵ']
		1,ǰ�˿�����
			DispatcherServlet
				* Ӧ��Ϊ���ṩһ���ֲ���ʼ������:contextConfigLocation
				* ����ֵ�������·���µ������ļ���ַ:classpath:xxx.xml
				* Ĭ�ϼ����ļ�����:DispatcherServlet.properties

		2,������ӳ����
			* ���еĴ�����ӳ�䶼��ʵ����'HandlerMapping'�ӿ�
			BeanNameUrlHandlerMapping
				* ����ӳ��,Ҫ��Controllerʹ��id����name����url·��
			SimpleUrlHandlerMapping
				* ���ӳ��,Ҫ��Controller��עid����name,��ӳ�����������in����name����ʾurl·��

		3,������������
			SimpleControllerHandlerAdapter
				* �����������õ�HandlerҪ��ʵ��'Controller'�ӿ�.
				* �ӿڷ�������һ��ModelAndView
			HttpRequestHandlerAdapter
				* �����������õ�handlerҪ��ʵ��'HttpRequestHandler'�ӿ�.
				* �ӿڷ������޷���ֵ,�ṩ��request,response.���Խ���ajax����json�Ȳ���

		4,��ͼ������
			InternalResourceViewResolver

	
	['ע����ϵ']
		1,ǰ�˿�����
			DispatcherServlet
				* Ӧ��Ϊ���ṩһ���ֲ���ʼ������:contextConfigLocation
				* ����ֵ�������·���µ������ļ���ַ:classpath:xxx.xml
				* Ĭ�ϼ����ļ�����:DispatcherServlet.properties

		2,������ӳ����
			DefaultAnnotationHandlerMapping
				* 3.1֮ǰʹ�õ�ע��ӳ����
			RequestMappingHandlerMapping
				* '3.1֮��ʹ�õ�ע��ӳ����'

		3,������������
			AnnotationMethodHandlerAdapter
				* 3.1֮ǰʹ�õ�ע��������
			RequestMappingHandlerAdapter
				* '3.1֮��ʹ�õ�ע��������'

		<mvc:annotation-driven/>
			* һ������,ֱ��������!������ȫ���'ӳ����'�Լ�'������'!
			* ʵ�ʿ��������������.����Ĭ�ϵļ����˺ܶ�����İ󶨷���,����json��ת��������,����Ĭ�ϼ�����
			* ʹ�����,��������ӳ����,������.���һ������˸���Ķ���.
			
		4,��ͼ����
			InternalResourceViewResolver
	
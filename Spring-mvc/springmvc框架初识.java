	SpringMVC,��ʵ����Spring��һ��ģ��!SpringMVC��Spring������ͨ���м����ϲ����������ϵ�!
		* �����ʵ�����,����.ǰ��ѧ��spring����ʵ��mvc�齨,ֻ������û��.�õ�struts2����
	SpringMVC,��һ������MVC�Ŀ��!

	Spring3.0�Ժ�ȫ�泬Խ��Struts2,��Ϊ���������MVC���

---------------------------------------------------------
���ͼ��...(��,û��)
---------------------------------------------------------
	MVC��һ�����ģʽ!
		> ��B/Sϵͳ�µ�Ӧ��
		> ��C/S...����,�㲻ѧ!
	POJO
	Action
	Servlet
	Service
	Dao	
		---����������ΪMVC�е�M!

	----SpringMVC���ԭ������(��������)
	request--->ǰ�˿�����(DispatcherServlet)
				|
				|	--> �������Handler
				��
		|------	������ӳ����(HandlerMapping)------------|
		|			|			|
		|			|			|
	Controller1(Handler)	Controller2(Handler)	Controller3(Handler)
	...(̫����,�ܶණ��û��!��ͼ��,���ֶ�)
---------------------------------------------------------
��ܴ�������,����˵��
---------------------------------------------------------
	1,��������ǰ�ο�����(DispatcherServlet)
	2,ǰ�˿�����,����HandlerMapping����Handler
		> ���Ը���xml����
		> ���Ը���ע��
	3,������,ӳ����HandlerMapping��ǰ�˿���������Handler
	4,ǰ�˿���������,������������ȥִ��Handler
	5,������������,ִ��Handler
	6,Handlerִ�����,��������������,����ModelAndView
	7,������������,��ǰ�˿���������ModelAndView
		> ModelAndView:��SpringMVC��ܵ�һ���ײ����,������Model��View
	8,ǰ�˿�����������ͼ������,������ͼ����
		> �����߼���ͼ��,����������������ͼ(jsp)
	9,��ͼ��������,ǰ�ο���������View
	10,ǰ�˿�����,������ͼ��Ⱦ
		> ��ģ������(ModelAndView),��䵽request��
	11,ǰ�˿�����,�ѽ����Ӧ���ͻ���(response)
---------------------------------------------------------
��Щ��Ҫ���齨(��Ҫ)
---------------------------------------------------------
	1,ǰ�˿�����(DispatcherServlet)
		����:��������,��Ӧ���.�൱��һ��ת�����������봦����
		> �����������齨֮�����϶�
	2,������ӳ����(HandlerMapping)
		����:���������url,������Handler(ͨ������/ע��)
	3,������������(HandlerAdapter)
		����:�����ض��Ĺ���(HandlerAdapterҪ��Ĺ���),ִ��Handler
		ע��:�ڱ�д,����Hanlder��ʱ��,Ҫ����HandlerAdapter��Ҫ��ȥ����(�̳�/ʵ��һ����,���߽ӿ�֮��Ĺ���..)
	4,��ͼ������()
		����:������ͼ����,�����߼���ͼ��,��������������ͼ(View)
	5,��ͼ(View)
		View,��һ���ӿ�!����ʵ����,֧�ֲ�ͬ��View����(jsp,freemarker,pdf)

	----��Ҫ����ʨ�Լ����п������齨
	Handler	
		> ����HandlerAdapter�Ĺ���ȥ��д
	View
		> ��Ҫ����JSP

---------------------------------------------------------
��������
---------------------------------------------------------
	springMVC�汾:3.2
	��ҪSpring3.2����jar��(һ��Ҫ����:spring-webmvc-3.2.0.RELEASE.jar)
	
	1,SpringMVC����
	2,SpringMVC��HelloWorld
	3,ʹ�� @RequestMapping ӳ������
	4,ӳ��������� & ����ͷ
	5,����ģ������
	6,��ͼ����ͼ������
	7,RESTful CRUD
	8,SpringMVC����ǩ & ����̬��Դ
	9,����ת�� & ���ݸ�ʽ�� & ����У��
	10,����JSON:ʹ��HttpMessageConverter
	11,���ʻ�
	12,�ļ��ϴ�
	13,������
	14,�쳣����
	15,SpringMVC��������
	16,��Spring������ʹ��SpringMVC
	17,SpringMVC�Ա�Struts2

	18,schema
		<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xmlns="http://www.springframework.org/schema/beans" 
			xmlns:aop="http://www.springframework.org/schema/aop"
			xmlns:context="http://www.springframework.org/schema/context" 
			xmlns:tx="http://www.springframework.org/schema/tx"
			xmlns:mvc="http://www.springframework.org/schema/mvc" 
			xmlns:cache="http://www.springframework.org/schema/cache" 
			xmlns:p="http://www.springframework.org/schema/p"
			xsi:schemaLocation="http://www.springframework.org/schema/beans 
				http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
				http://www.springframework.org/schema/aop
				http://www.springframework.org/schema/aop/spring-aop-4.0.xsd
				http://www.springframework.org/schema/mvc 
				http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd 
				http://www.springframework.org/schema/context
				http://www.springframework.org/schema/context/spring-context-4.0.xsd
				http://www.springframework.org/schema/tx
				http://www.springframework.org/schema/tx/spring-tx-4.0.xsd
				http://www.springframework.org/schema/cache http://www.springframework.org/schema/cache/spring-cache-4.0.xsd">
				
		</beans>
	






















































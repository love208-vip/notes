����������������������������������������������������������������
һ,Spring �����WEBӦ����ʹ��	|
����������������������������������������������������������������
1,Spring �����WEBӦ����ʹ��
	> jar������һ������ͬ,������Ҫ����������WEB��صİ�(��ʵǰ������һֱ������)
	> spring �����ļ�,ûʲô��ͬ!
	> ����IOC����(AppicationContext)
		��,��WEBӦ����main�����д���
		��,WEBӦ��,Ӧ����WEBӦ�ñ�����������ʱ�ʹ���IOC����
	* Ҳ����˵����������������ʹ���������������ServletContextListener ,������
	> IOC���ŷ���������������֮��,��WEBӦ���������齨,��ô������?
	* ��IOC����,���õ�Application����!Ҳ����ServletContext��
�ܽ�
	> ��appication���������г�ʼ�������д���IOC����
	> ��IOC��������,application��
	* ���԰� Spring �����ļ���λ��,�Գ�ʼ����������ʽ������web.xml��!
	* �ڼ�������,��ȡServletContext,�ٻ�ȡ��ʼ������,Ȼ��� ClassPathXmlApplicationContext();ȥ����,�õ�ApplicationContext

��չ
	��ʵ, Spring ��һ�������Ŀ��!������Ϊ�����ṩ��һ�� ContextLoaderListener
	* Spring-web-x.x.x.RELEASE.jar ���µĶ���
	* org.springframework.web.context.ContextLoaderListener
	* ����,��� Spring �ṩ�ļ�����,������Ƹ�Ϊ�Ͻ�!���Կ���ʹ����!
	������Ѿ���ʵ���� SerlvetContextListener(application��������),����ֻ��Ҫ��web.xml��ע�����ͺ�
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	> ע��ɹ���,���ͻ���Ҵ���IOC����,���ҷ��õ�application��,���������е㳤,���ǿ���ͬ���ṩ�ķ���ȡ����

	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);

	> �����һ��ServletContext����,�Ҿͻ���һ��IOC��������!��Ȼǰ����:������ Spring �ṩ�ļ�����
	* ʹ�����������Ҫ����İ�
		org.springframework.web.context.support.WebApplicationContextUtils
		org.springframework.context.ApplicationContext

	* Ĭ�ϼ��صľ���WEB-INF�µ�:applicationContext.xml�ļ�,������xml�ļ���������λ��,��ô����Ҫ��web.xml������ȫ�ֳ�ʼ����������,���������!
	contextConfigLoaction
		> �ò����Ǽ������е�һ����Ա����,ָ����xml�������ļ���ַ.����ͨ����ʼ������������xml�ļ��ĵ�ַ
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:beans.xml</param-value>
	</context-param>

	Ҳ��������

	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/classes/applictionContext.xml</param-value>
	</context-param>
	

����������������������������������������������������������������
��,Spring �������Struts2		|
����������������������������������������������������������������
['����Ŀ��']
	1,ʹ��IOC����,������struts2��Action
['���ϲ���']
	1,��������struts2,�Լ�����
	2,�� Spring ��IOC����������struts2��Action
		* �� Spring ������struts2��actionʱ,Ҫע���޸�scope="prototype"!action,�����ǵ�����!
	3,����struts2�������ļ�
		* ��Ȼ��Spring��������,����action������struts2����
	<action name="demo" class="Spring�����ļ���action��bena��idֵ" method="execute">
		<result name="success">/index.jsp</result>
	</action>
	4,���һ��jar��,�Բ���.֮ǰû˵!ϣ����û����Ϊ��ʵ��Ҳʶ��ҵ���
	struts2-spring-plugin.jar
	5,OK��û������.�����Ķ���������������!

['��չ']
	struts.xml�ļ���һ������:
	<constant name="struts.objectFactory" value="spring"/>
	struts.objectFactory�����������˵��Struts2�� ����ش���������Struts2Ҳ���Լ��Ķ���أ�����Spring�������������ļ�����������ö�����еĶ�������Խ�����Spring�еĶ���أ�
	����Ҫ�õ�Spring�еĶ����ʱ������struts.objectFactoryΪSpring�Ķ���ع�������....
	* һ���ȥ����!

����������������������������������������������������������������
��,Spring �������Struts2  �ܽ� |
����������������������������������������������������������������
Spring 
	1,Spring ��IOC�������ŷ���������������,ע�� Spring �ṩ�ļ�����.
	2,��� Spring �й���WEB��jar��
	3,Spring �����ļ���������
	4,�� Spring �������� struts2��action ��ʱ��Ҫע��.�����ǵ���
struts2
	1,���˺���jar�����������һ��'struts2-spring-plugin.jar'
	2,������<action></action>��ʱ��Ҫע��,class ������'spring �����ļ���,��Ӧ��action��bean��id����ֵ'!Ҳ����˵,action����spring������
	3,��ô��action,����Ͳ�Ҫ�� new ֮��Ĳ���!ͳͳ�Ľ��� Spring ��!��������
	

����������������������������������������������������������������
��,Spring ����Struts2  ԭ��     |
����������������������������������������������������������������
	Struts2�����jar���ǳ�����,�����ṩ��һ��xml�ļ�
	struts2-spring-plugin.jar ----> struts.plugin.xml
	�������ļ��и�����
	<constant name="struts.objectFactory" value="spring"/>
	> ���󹤳��ͱ����org.apache.struts2.spring.StrutsSpringObjectFactory
	* Ĭ�ϵĲ�û�п���,��struts-default.properties�п����ҵ��������

	����������:
		����������ĳ���(��������,�ο�:�����˿���ģʽ��,��������������Ҳ��true,��ϸ��ӡ������Ϣ��)
	struts.objectFactory.spring.autoWire=name
		* Ĭ���ǰ���������װ��
		* name
		* type			//����
		* auto			//������
		* constructor	//�Զ�

	�Զ�װ��,�����ṩget/set!

	<constant name="struts.objectFactory" value="spring"/>
	<constant name="struts.objectFactory" value="spring"/>




	





	
	
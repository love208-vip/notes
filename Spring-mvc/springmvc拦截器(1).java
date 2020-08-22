

/////////////////////////////////
	1,�������Ķ���
		* ʵ�ֽӿ�
			org.springframework.web.servlet.HandlerInterceptor
		* ��д��������
		public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception 
			1,�����󵽴�Handler����֮ǰִ��
				request
				response
				handler
			2,���������֤,�����Ȩ
				* ���ݸ÷����� Boolean ���͵ķ���ֵ��ȷ���Ƿ����,ִ��Handler

		public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception
			1,��Handlerִ����Ϻ�,ModelAndView����֮ǰ
				request
				response
				handler
				modelAndView
			2,���Ի�ȡ��ModelAndView,Ҳ����˵,���������������������,��ͳһ���һЩ���õ�ģ������!
			3,ֻ�е�һ����������true��ʱ��Ż�ִ��
			4,����ͼ��Ⱦ֮ǰִ��

		public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception exception)throws Exception 
			1,��Handler����MoldelAndView֮��ִ��
				request
				response
				handler
				exception
			2,Handlerִ����Ϻ�,ִ�д˷���.���Խ���:��־����,�쳣��Ϣ��¼,
			3,��������һ������ֵΪtrue��ʱ��ִ�С�
			3,���ڶ���Դ��������

	* ���������ǻ���AOPʵ�ֵ�!
	* SpringMVC ����������� HandlerMapping������������,�����ĳ��HandlerMapping ����������.������HandlerMapping,ӳ��ɹ���Handler,���ղ�ʹ�ø�������

	* SpringMVC����ȫ��������,SpringMVC��ܽ����õ�������ȫ�ֵ�������ע�뵽ÿ��Handler��


����������:
	<bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping">
		<property name="interceptors">
			<ref bean=""/>	<!-- ������1 -->
			<ref bean=""/>	<!-- ������2 -->	
		</property>
	</bean>

	* ���ַ�ʽ���Ƽ�ʹ��

	ȫ�ֵ�����(�Ƽ�ʹ��)

	<!-- ������,���������˳��ִ�� -->
	<mvc:interceptors>
		<!-- ��һ�������� -->
		<mvc:interceptor>
			<mvc:mapping path="/**"/>
			<mvc:exclude-mapping path="/hello.do"/>			//hello.do��ִ������
			<bean class="com.kevin.interceptor.MyInterceptor"/>
		</mvc:interceptor>
		<!-- �ڶ��������� -->
		<mvc:interceptor>
			<mvc:mapping path="/**"/>
			<mvc:exclude-mapping path="/hello.do"/>			//hello.do��ִ������
			<bean class="com.kevin.interceptor.MyInterceptor"/>
		</mvc:interceptor>
	</mvc:interceptors>

	* ���ֱ�Ӱ�Bean��������interceptors����,��ô���������е�����
	

	/**																						*/
		> ��ʾ����URL������URL·��
	/*																						*/
		> ��ʾֻ����ָ��·������һ����·��

	ִ�в��Խ��... ...
	ǰ��������ִ��
	A������===ǰ������ִ��ִ��
	B������===ǰ������ִ��ִ��
	B������===��������ִ��ִ��
	A������===��������ִ��ִ��
	����������ִ��
	B������===��������ִ��ִ��
	A������===��������ִ��ִ��
	����������ִ��

	�ܽ�:�е���ص�,

	������1����,������2����
	������2ִ����,������1ִ����,
	������2����ִ��,������1����ִ��

	����:��¼��֤������Ӧ�÷��ڵ�һ��λ��,Ȩ����֤����������Ӧ�÷��ڵڶ���λ��


	ֻҪ��һ��������������,�κ�postHandle���������.

-------------------------------
�߼�							|
-------------------------------
	1,���������л�ȡ���󷽷�/Controller
		HandlerMethod handlerMethod = (HandlerMethod) handler;		//��handler����ǿת
	    Method method = handlerMethod.getMethod();					//��ȡ�����󷽷�����

		* ���˵����Ĳ���Controller,����:����̬��Դ������������.���ǿת�ᱨ��
	
	2,ͬ��Ҳ�ǻ�ȡ���󷽷�
		
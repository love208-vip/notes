
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/jsp/"/>
		<property name="suffix" value=".jsp"/>
	</bean>

	����Ŀ�귽�������κ�����:String,ModelAndView... ...���ᱻ���ת��ΪModelAndView
	View
		* ��ͼ�ӿ�,�кܶ�ľ���ʵ��
	ViewResolver
		* ��ͼ������!

	�����Ŀ��ʹ����JSTL��ǩ.��ܻ��Զ�����ͼInternalResourceView ת��ΪJstlView
	���ʹ�õ���JSTL��fmt��ǩ���й��ʻ�,����Ҫ��springmvc�������ļ�������'���ʻ���Դ�ļ�'

	
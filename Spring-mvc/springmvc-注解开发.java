��������������������������������
һ,������������ |
��������������������������������

������������ע������

1,��xml�����
	<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>
	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
		> �����spring3.1֮��,ʹ�õ�ע����!��3.1֮ǰ����ʹ�õ����!

2,ʹ���������,������������
	<mvc:annotation-driven>
				
	</mvc:annotation-driven>

		> �������������ȫ�����'ӳ����'�Լ�'������'������,����Ĭ���ṩ�˸���Ĳ����󶨵ķ���!
		> ����:json��ת���Ľ�����--�����Ĭ�ϼ�����!
		> ʹ��������Ͳ������������'1'!������ӳ��������������!�ⶫ��һ������!
		> ʵ�ʿ���,����������!


��������������������������������
��,������������ |
��������������������������������
����ӳ������ע������

	1,��xml�ļ�������
		<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>
		org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
			> ��������spring3.1֮��ע��ʹ�õ�����!3.1֮ǰ�����õ����

	2,ʹ���������,������������
	<mvc:annotation-driven>
				
	</mvc:annotation-driven>

		> �������������ȫ�����'ӳ����'�Լ�'������'������,����Ĭ���ṩ�˸���Ĳ����󶨵ķ���!
		> ����:json��ת���Ľ�����--�����Ĭ�ϼ�����!
		> ʹ��������Ͳ������������'1'!������ӳ��������������!�ⶫ��һ������!
		> ʵ�ʿ���,����������!

<mvc:annotation-driven/> �������
	* �ⶫ�����Բο�һ�°����ĵ�!
	* �ⶫ�����Զ���ע�Ἰ��Bean
		RequestMappingHandlerMapping			//ע��ӳ����
		RequestMappingHandlerAdapter			//ע��������
		ExceptionHandlerExceptionResolver(�쳣������)
	* �ⶫ�����ṩ����֧��
		֧��ʹ�� ConversionService ʵ���Ա�������������ת��
		֧��ʹ�� @NumberFormatannotation,@DateTimeFormat ע������������͵ĸ�ʽת��
		֧��ʹ�� @Valid ע���javaBeanʵ������JSR303��֤
		֧��ʹ�� @RequestBody �� @ResponseBody ע��			//json����֧��
				
	
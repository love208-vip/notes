-------------------------------
�Զ��������					|
-------------------------------
	* �������̸��Զ���tagһ��һ��
	* �������������� {% if %}�ȱ�ǩ,tag����
	* ���˽������Դ���һ��ֵ,tag���Դ���n��
	* ֻ�������ط���ͬ
		1,װ������ͬ
			@register.simple_tag	-> @register.filter
		
		2,���÷�ʽ��ͬ
			{% my_demo name %}		-> {{ name|my_filter }}
			* ����ֵ�ĵ���
				{{ name|my_filter:'KevinBlandy' }}	# ����
				{{ name|my_filter:var }}			# �����ı���
	
	* dmeo
		from django import template
		from django.utils.safestring import mark_safe

		# �������ƹ̶�,�����޸�
		register = template.Library()

		'''
			ʹ�� @register.filter ��ϵͳע��һ��������
		'''
		@register.filter
		def my_filter(value,arg):	# value,���ǵ��ù�����ʱ���ݾ����Ĳ���,arg��ͨ��":"���ݽ����Ĳ���
			mark_safe(value)		# mark_safe()���ԶԺ���HTML��ǩ���ַ�������ת��
			return "filter" + value


	
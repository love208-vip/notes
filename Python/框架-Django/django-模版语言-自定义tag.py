--------------------------------
ģ�������Զ����ǩ				|
--------------------------------
	1,��app�д���Ŀ¼:templatetags
		* ��Ŀ¼���ƹ̶�,�����޸�
	
	2,�ڸ�Ŀ¼�����������Ƶ�py�ļ�,���ڱ�дtag����
		from django import template
		from django.utils.safestring import mark_safe

		# �������ƹ̶�,�����޸�
		register = template.Library()
		'''
			ʹ�� @register.simple_tag ��ϵͳע��һ����ǩ
			����
				takes_context
					* Ĭ��ΪNone,��ֵ���ΪTrue,�����ִ�б�ǩ����ʱ���������Ķ���,��ϵͳ����
		'''
		@register.simple_tag(takes_context=True)
		# �����������Ǳ�ǩ����,
		# ���takes_context=True,��ô��һ���������� context,���Ʋ��ܱ�
		# �����ǩ�����˶��ֵ,��ô�����ж�Ӧ�������βα���������
		def my_demo(context,value):
			mark_safe(value)    # mark_safe()���ԶԺ���HTML��ǩ���ַ�������ת��
			print(context)
			return value + " test"	# ����ֵ��Ϊ��Ⱦ�Ľ��
	
	2,��djangoϵͳע�ᵱǰ����Ŀ
		* ��settings.py�ļ��н���ע�ᵱǰapp
		INSTALLED_APPS = [
			'django.contrib.admin',
			'django.contrib.auth',
			'django.contrib.contenttypes',
			'django.contrib.sessions',
			'django.contrib.messages',
			'django.contrib.staticfiles',
			'root',		# ��ǰapp������
		]

	3,��ģ����ʹ�ñ�ǩ
		{% load tag_file.py %}		# ʹ��load��ǩ�����Զ���ı�ǩ��,tag_file �����Զ����ǩ��py�ļ�����
		
		{% my_demo 'KevinBlandy' 'Kevin'%}	# ֱ�Ӵ��ݳ���ֵʹ�ñ�ǩ,���Դ����ֵ,ʹ�ÿո�ָ�
		{% my_demo name%}					# ���ߴ����������еı���ʹ�ñ�ǩ
	
	* tag ��������{% if %}�ȱ�ǩ,��Ϊ��������Ǹ���ǩ
	* tag ���Դ��ݶ��ֵ,����������


		

	
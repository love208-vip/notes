----------------------------
ȡֵ						|
----------------------------
	* ��ͨȡֵ
		{{name}}
			* ����һ����ȫ��ȡֵ���ʽ
	
	* ����ȡֵ
		{{names.0}}
			* ����.�±�
			* û��,������ô����˼
	
	* �ֵ�ȡֵ
		{{name.key}}
			* ��,ͨ��.���е���
	
	* ���ڸ�ʽ��
	* ��������ȡֵ
		* ֱ��.����,������
	

		

----------------------------
ѭ��/����					|
----------------------------
	{% for key in seria %}
		{{key.name}}
	{% endfor %}

	* ����ǩ����һ�� reversed ʹ�ø��б����������
		{% for key in seria reversed %}
			...
		{% endfor %}
	
	* ѭ����ǩ����Ƕ��ʹ��
	* ѭ������ֵ
		{% for i in users%}
			{{forloop.counter}}
		{% endfor %}

		forloop.counter
			* ��ǰ�����������ݸ���,�Ǵ�1��ʼ(���±�)
		
		forloop.counter0
			* ��ǰ�����������ݸ���,�Ǵ�0��ʼ(���±�)
		
		forloop.revcounter
			* �����ӡ�������ݸ���,��1����
			* 9,8,7,6,5,4,3,2,1
		
		forloop.revcounter0
			* �����ӡ�������ݸ���,��0����
			* 8,7,6,5,4,3,2,1,0

		forloop.first	
			* ��������Ԫ��Ϊ��һ��ʱΪ��
		forloop.last	
			* ��������Ԫ��Ϊ���һ��ʱΪ��
		forloop.parentloop	
			* ����Ƕ�׵� for ѭ����,��ȡ��һ�� for ѭ���� forloop
		


----------------------------
�ж�						|
----------------------------

	{% if condition %}
		
	{% elif condition %}
		
	{% else %}
		
	{% endif %}

	* {% if %} ��ǩ���� and , or ���� not �ؼ������Զ���������ж� ,���߶Ա���ȡ��(not)
		{% if athlete_list and coach_list %}
			 athletes �� coaches �������ǿ��õ�
		{% endif %}
	
	
----------------------------
�Ƚ�						|
----------------------------
	{% ifequal %} 

	{% endifequal %}

	* ��ǩ�Ƚ�����ֵ,���������ʱ����ʾ�� {% ifequal %} �� {% endifequal %} ֮�����е�ֵ
		{% ifequal user currentuser %}
			<h1>Welcome!</h1>
		{% endifequal %}

	* �� {% if %} ����,{% ifequal %} ֧�ֿ�ѡ�� {% else %} ��ǩ
		{% ifequal section 'sitenews' %}
			<h1>Site News</h1>
		{% else %}
			<h1>No News Here</h1>
		{% endifequal %}

	
----------------------------
ע��						|
----------------------------
	{# ����һ��ע�� #}

----------------------------
������						|
----------------------------
	{{name|lower}}
	
	* ��ʵ���ǿ�ݷ�������,��name���ݸ���lower����,ת��Ϊ��Сд
	* ���˹ܵ����Ա��׽�,����˵,һ���������ܵ�������ֿ�����Ϊ��һ���ܵ�������
		{{ name|first|upper }}
	
	* ��Щ�������в���, �������Ĳ�������ð��֮����������˫���Ű���
		{{ name|truncatewords:"30" }}
	
	* ���ù�����
		first	
			* ��ȡ��һ���ַ�
		upper
			* ȫ��ת��Ϊ��д
		lower
			* ȫ��ת��ΪСд
		capfirst
			* ����ĸת��Ϊ��д
		add:''
			* ������������Ӧ��ֵ
			* add ��ֵ������ int/str
			* �ù������������ֵ��ת��Ϊ int �������Ӳ���
		addslashes
			* �������е�����ǰ����б��
		cut:''
			* ���ַ������Ƴ�ָ�����ַ�
		date:''
			* ��ʱ��(datetime)���и�ʽ��
		default:''
			* ���ֵΪ False,�ͻᱻ�滻Ϊ�ù�������ֵ
		default_if_none:''
			* ���ֵ�� None ,���滻�ɸù��������õ�ֵ
		length
			* ���ȡ�����ݵĳ���
		safe
			* ��ת��HTML,ȷ���ǰ�ȫ��HTML��ǩ


----------------------------
����						|
----------------------------
	{% include "nav.html" %}

	* {% include %} ��ǩ������ģ���а���������ģ�������

----------------------------
�̳�						|
----------------------------
	* ����ģ��,�Լ����Ա���д�� block
		{% block [name]%}
			body..
		{% endblock %}
	
	* �̳�ģ��,���Ҹ�дָ�����Ƶ� block
	* extends ��ǩ��������ģ��ĵ�һ��,����������
		{% extends [template]%}
		{% block [name] %}
			Override body...
		{% endblock %}


	* ģ������ü̳еķ�ʽ��ʵ�ָ���

		<body>
			<h1>Hello World!</h1>
			<p>����̳� Django ����</p>

			{% block mainbody %}
				<p>original</p>
			{% endblock %}

		</body>
		* ��Ϊ mainbody �� block ��ǩ�ǿ��Ա��̳������滻���Ĳ���
		* {% block %} ��ǩ����ģ������,��ģ�����������Щ����
			# base.html
				<body>
					<h1>Hello World!</h1>
					<p>����̳� Django ���ԡ�</p>
					{% block mainbody %}
					   <p>original</p>
					{% endblock %}
				</body>
			
			#extend.html
				{% extends "base.html" %}
				{% block mainbody %}
					<p>�̳��� base.html �ļ�</p>
					{{ block.super }}	# ʹ�� block.supe ħ���������ʸ���ģ���е�����(<p>original</p>)
				{% endblock %}
	
		* ���ʸ���ģ���еı���,
			{{ block.super }}
----------------------------
html��ǩת����Ⱦ			|
----------------------------
	* ����ͨ��ȡֵ����,����ֵ��HTML��ǩ,Ҳ����ڰ�ȫ����,����Ⱦʱ�ᱻ��ȾΪHTML�е���ͨ�ַ���
	* ˵����,���HTML�������ǩ����ת�����
		name = "<a href='http://javaweb.io'>name</a>"
		{{name}}
		#  &lt;a href=&#39;http://javaweb.io&#39;&gt;name&lt;/a&gt;
	* ���Թر���������
		{% autoescape off %}
            {{ name }}
			#  <a href='http://javaweb.io'>name</a>
		{% endautoescape %}
	
	* ʹ�� safe ������Ҳ�������
		{{name|safe}}

----------------------------
��ֹ��Ⱦ					|
----------------------------
	{% verbatim %}
		{{name}}
	{% endverbatim %}
		* {{name}},��ԭ�����,���ᱻ��Ⱦ

----------------------------
��̱�����					|
----------------------------
	{% with name = longname %}
		{{ name }}
	{% endwith %}
		* �����ƹ����ı���,��������



----------------------------
���ر�ǩ��					|
----------------------------
	{% load %}
		* ���ر�ǩ��

----------------------------
Ԥ����ֵ��ǩ				|
----------------------------

	{%csrf_token%}
		* ��������һ����ֹcsrf������tokenֵ
		*  <input type='hidden' name='csrfmiddlewaretoken' value='8MBu2xfM6Xn10rTV1jfu0MZ05w33rrRFSUBPF0cNVzhGRt9EVJRQiAjqN3W8EimN' />
	
	{% url %}
		* ��ǰURL

	
	

	

	

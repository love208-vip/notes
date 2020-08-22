-------------------------------
jinja2							|
-------------------------------
	* Flask ʹ�� Jinja 2 ��Ϊģ������
	* ��Ȼ,��Ҳ��������ʹ��������ģ������
	* ��'����Flask������Ȼ��ҪJinja2����,������ø���չ�Ǳ�Ҫ��,��չ��������Jinja2����'
	* ����ֻ�ǿ��ٵؽ��� Jinja2 ����μ��ɵ� Flask �е�, �������Ҫ�������ģ�����汾�����Ϣ,��ο��ٷ�Jinja2ģ���ĵ�

-------------------------------
jinja2-����						|
-------------------------------
	* Ĭ�ϵ�����
		* ��ʹ��render_template()ʱ,������չ��Ϊ .html, .htm, .xml�Լ�.xhtml��ģ��Ὺ���Զ�ת��
		* ��ʹ��render_template_string()ʱ,�����ַ����������ֵ�ת��
		* ģ���������{% autoescape %}��ǩѡ���Զ�ת��Ŀ��ء�
		* Flask �� Jinja2 �������в����˼���ȫ�ֺ���������,���⻹��һЩ Ԥ����ֵ

-------------------------------
jinja2-Ԥ����ֵ					|
-------------------------------
	config
		* ��ǰ�����ö��� (flask.config)

	request
		* ��ǰ��������� (flask.request), ��ģ�治���ڻ����������������Ⱦʱ�������������

	session
		* ��ǰ�ĻỰ���� (flask.session), ��ģ�治���ڻ����������������Ⱦʱ�������������

	g
		* ������ص�ȫ�ֱ��� (flask.g), ��ģ�治���ڻ����������������Ⱦʱ�������������

	url_for()
		* flask.url_for() url���캯��

	get_flashed_messages ()
		* flask.get_flashed_messages() ����

-------------------------------
jinja2-������					|
-------------------------------
	tojson 
		* ��������Ѹ����Ķ���ת��Ϊ JSON ��ʾ
	
	safe 
		* ��ȫ�����,��ת��HTML
	
	* ��������������ʹ��()
		{% for x in users|reverse('Kevin') %}	# reverse('Kevin')
            {{ x.name }} - {{ x.age }}
        {% endfor %}

-------------------------------
jinja2-��ǩ						|
-------------------------------
	* ѭ������
		{% for x in users %}
            {{ x.name }} - {{ x.age }}
        {% endfor %}
		
	* ת��HTML����
		{% autoescape false %}
			<p>autoescaping is disabled here
			<p>{{ will_not_be_escaped }}
		{% endautoescape %}

		* autoescape �Ƿ�ת��HTML����,ͨ������ false / true ������

	

-------------------------------
jinja2-�����Ĵ�����				|
-------------------------------
	* Flask �����Ĵ������Զ���ģ����������в����±���
	* �����Ĵ�������ģ�� ��Ⱦ֮ǰ����,���ҿ�����ģ���������в�����ֵ
	* �����Ĵ�������һ�������ֵ�ĺ���,ʹ��@app.context_processor ��ʶ
	* ����ֵ�ļ�ֵ���ս�����Ӧ��������ģ���������

		@app.context_processor
		def inject_user():
			return dict({'name':'Kevin'})
		* ����������Ĵ�����ʹ��ģ�����ʹ��һ����Ϊ name  ֵ:	 
				{{ name }}	# Keviin

	* ������������ֵ,�����Ĵ�����Ҳ����ʹĳ��������ģ���п���(���� Python �� ���ݺ���)

		@app.context_processor
		def utility_processor():
			def say_hello(some):
				return 'hello,' + some
			return dict({'say_hello':say_hello})

		* ����������Ĵ�����ʹ�� say_hello ����������ģ���п���
			{{ say_hello('KevinBlandy') }}	# hello,KevinBlandy
		

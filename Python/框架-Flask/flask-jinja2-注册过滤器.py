----------------------------
ע�������					|
----------------------------
	* �����Ҫ�� Jinja2 ��ע�����Լ��Ĺ�����,�������ַ���
	* �����ַ�ʽע�������
	1,ʹ��װ����
		
		# ʹ�� app.template_filter װ������ע��
		# �����װ����û�д��ݲ���(@app.template_filter),����Ըú�������Ϊװ����������
		@app.template_filter('reverse')
		def reverse_filter(s):
			return s[::-1]
	
	2, ��ӵ� jinja_env ������

		# ���崦����
		def reverse_filter(s):		
			return s[::-1]
		
		# ע�ᵽ��������,��������
		app.jinja_env.filters['reverse'] = reverse_filter

	* ��ʹ��װ�����������,��������Ժ�������Ϊ��������,�����ǿ�ѡ��
	* ע��֮��, �������ģ������ʹ�� Jinja2 ���ù�����һ��ʹ����Ĺ�����,������������������ һ����Ϊ mylist �� Python �б�:

		{% for x in mylist | reverse %}
			
		{% endfor %}
----------------------------
EasyUI-datetimebox			|
----------------------------
	# ����ʱ�������
	# ���� databox���˸�΢���Ķ���
	# ��չ��$.fn.datebox.defaults��ʹ��$.fn.datetimebox.defaults��дĬ��ֵ����
	# �̳й�ϵ
		datebox 
		timespinner
 
----------------------------
EasyUI-datetimebox����		|
----------------------------
	'����ʱ���������չ��datebox(���������)������ʱ��������������������£�'
	currentText
		* ��ʾ'��ǰʱ��'����ť���ı�
	
	closeText
		* ��ʾ'�ر�'����ť�ı�
	
	okText
		* ��ʾ'OK'����ť�ı�
	
	spinnerWidth
		* ����datetimebox���Ƕ���ʱ��΢�����Ŀ�ȡ�
		* ������һ����ֵ,Ĭ��ֵ: 100%
	
	showSeconds
		* �����Ƿ���ʾ������Ϣ��
	
	timeSeparator
		* ������Сʱ�����Ӻ���֮���ʱ��ָ��ַ���
	

----------------------------
EasyUI-datetimebox�¼�		|
----------------------------
	

----------------------------
EasyUI-datetimebox����		|
----------------------------
	'����ʱ�������ķ�����չ��datebox(���������)������ʱ���������д�ķ������£�'
	options
		* ���ز�������
	
	spinner
		* ����ʱ��΢��������
	
	setValue
		* �߱�һ������.�������õ��ַ���ֵ

	cloneFrom
		* ��¡һ��datetimebox�ؼ���
		* �߱�һ������.����һ�� form������
		* demo
			<input id="from" class="easyui-datetimebox">
			// ��¡һ�����ڵ�datebox���
			$('.dt').datetimebox('cloneFrom', '#from');

		
		

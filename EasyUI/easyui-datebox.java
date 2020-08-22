---------------------------
EasyUI-datebox				|
---------------------------
	# ��չ��$.fn.combo.defaults��ʹ��$.fn.datebox.defaults��дĬ��ֵ����
	# �̳й�ϵ
		combo 
		calendar 


---------------------------
EasyUI-datebox����			|
---------------------------
	panelWidth
		* �������������
	
	panelHeight
		* �����������߶�
	
	currentText
		* ��ʾ���찴ť,�������ַ�������.��Ϊ�ı���ʾ����ť��
	
	closeText
		* ��ʾ�ر���ť,�������ַ�������.��Ϊ�ı���ʾ����ť��
	
	disabled
		* ������Ϊ true ��ʱ��,���ø��ֶ�
	
	buttons
		* ������������ʾһ����ť
		* ������һ����ť����
		* demo
			var buttons = $.extend([], $.fn.datebox.defaults.buttons);
				buttons.splice(1, 0, {
				text: 'MyBtn',
				handler: function(target){
					alert('click MyBtn');
				}
			});
			$('#dd').datebox({
				buttons: buttons
			});
	
	sharedCalendar
		* ��һ�������ؼ���������datebox�ؼ�ʹ�á�
		* �߱���������
		* demo
			<input class="easyui-datebox" sharedCalendar="#sc">
			<input class="easyui-datebox" sharedCalendar="#sc">
			<div id="sc" class="easyui-calendar"></div>

	formatter
		* �ú������ڸ�ʽ������
		* demo
			$.fn.datebox.defaults.formatter = function(date){
				var y = date.getFullYear();
				var m = date.getMonth()+1;
				var d = date.getDate();
				return m+'/'+d+'/'+y;
			}
	
	parser
		* �ú������ڽ���һ�������ַ���������һ��'date'�ַ����������һ᷵��һ���������͵�ֵ�������һ������չʾ�������дĬ�ϵ�parser����
		* demo
			$.fn.datebox.defaults.parser = function(s){
				var t = Date.parse(s);
				if (!isNaN(t)){
					return new Date(t);
				} else {
					return new Date();
				}
			}
	
	

---------------------------
EasyUI-datebox�¼�			|
---------------------------
	onSelect
		* ���û�ѡ����һ�����ڵ�ʱ�򴥷��� 
		* �߱�һ������.�����û�ѡ�������
			$('#dd').datebox({
				onSelect: function(date){
					alert(date.getFullYear()+":"+(date.getMonth()+1)+":"+date.getDate());
				}
			});
	

---------------------------
EasyUI-datebox����			|
---------------------------
	'������չ�� combo(�Զ���������)�������������д�ķ������£�'
	options
		* �������Զ���
	
	calendar
		* ��ȡ�������������������ʾ�������ȡ�����������´�������
		* demo
			// ��ȡ��������
			var c = $('#dd').datebox('calendar');
			// ����һ�ܵĵ�һ�������ڼ���0�����գ�1����һ��
			c.calendar({
				firstDay: 1
			});
	
	setValue
		* �����������ֵ
		* demo
			$('#dd').datebox('setValue', '6/1/2012');	// ��������������ֵ
			var v = $('#dd').datebox('getValue');		// ��ȡ����������ֵ
	
	cloneFrom
		* ��¡һ��datebox�ؼ���
		* demo
			<input id="from" class="easyui-datebox">
			// ��¡һ�����ڵ�datebox���
			$('.dt').datebox('cloneFrom', '#from');




----------------------------
EasyUI-combogrid			|
----------------------------
	# ���ݱ�����������˿ɱ༭�ı���ؼ����������ݱ�����ؼ����ÿؼ������û����ٲ��Һ�ѡ�񣬲��Ҹÿؼ��ṩ�˼��̵���֧�֣����н���ɸѡ��
	# �̳й�ϵ
		combo
		datagrid

----------------------------
EasyUI-combogrid		����|
----------------------------
	'���ݱ���������������չ��combo(�Զ���������)��datagrid(���ݱ��)�����������������������£�'
	loadMsg
		* �����ݱ�����Զ�����ݵ�ʱ����ʾ����ʾ��Ϣ
	
	idField
		* ID�ֶ�����
	
	textField
		* Ҫ��ʾ���ı����е��ı��ֶ�
	
	mode
		* ���ܼ���
		* �������ı��ı��ʱ����ζ�ȡ�����������ݡ�����Ϊ'remote'�����ݱ�񽫴�Զ�̷������������ݡ�������Ϊ'remote'ģʽ��ʱ���û����뽫�ᷢ�͵���Ϊ'q'��http���������������������µ����ݡ�
	
	filter
		* ������'mode'����Ϊ'local'��ʱ�����ѡ�񱾵�����.���� true,��ѡ�����
		* demo
			$('#cc').combogrid({
			filter: function(q, row){
					var opts = $(this).combogrid('options');
					return row[opts.textField].indexOf(q) == 0;
				}
			});
	

----------------------------
EasyUI-combogrid		�¼�|
----------------------------
	'���ݱ���������¼���ȫ��չ��combo(�Զ���������)��datagrid(���ݱ��)��'

----------------------------
EasyUI-combogrid		����|
----------------------------
	'���ݱ��������ķ�����չ��combo(�Զ���������)�����ݱ����������������д�ķ������£�'

	options
		* �������Զ���
	
	grid
		* �������ݱ�����
		* demo
			//��ȡѡ�����
			var g = $('#cc').combogrid('grid');	// ��ȡ���ݱ�����
			var r = g.datagrid('getSelected');	// ��ȡѡ�����
			alert(r.name);

	setValues
		* �������ֵ����
		* demo
			$('#cc').combogrid('setValues', ['001','007']);
			$('#cc').combogrid('setValues', ['001','007',{id:'008',name:'name008'}]);
	
	setValue
		* �������ֵ
		* demo
			$('#cc').combogrid('setValue', '002');
			$('#cc').combogrid('setValue', {id:'003',name:'name003'});
	
	clear
		* ��������ֵ

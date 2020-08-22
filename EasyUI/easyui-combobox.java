-------------------------
EasyUI-ComboBox			 |
-------------------------
	# ������,�Ǻ�
	# ������ϵ
		combo
	# ֧�ֱ�ǩ
		<select class="easyui-combobox"></select>
		<input class="easyui-combobox"/>

	# JSON��ʽ
		
		{
			id:'123',		//ֵ(����)
			text:'Kev',		//��ʾ���ı�
			selected:true	//�Ƿ�ѡ��
		}
-------------------------
EasyUI-ComboBox����		 |
-------------------------
	'�����б��������չ��combo(�Զ���������)�������б���������������£�'

	url
		* ָ��Զ�����ݵ������ַ
	
	valueField
		* ��ӦJSON�е�,value�ֶ� 
	
	textField
		* ��ӦJSON�е�,text�ֶ� .������ʾ���ı�
	
	method
		* ����ʽ,Ĭ��Ϊ'POST'
	
	mode
		* ֵΪ:'remote'
		* ��������������Ժ�,�û�ִ�����κε�����.���ᱻ���ݵ���̨.url���ǵ�ǰ��url,������Ϊ:q
		* ��ȡ����Ӧ��,�����µļ�������б�
		* ��ʵ����ģ��ƥ��
		* ֵҲ������'local',Ĭ��ֵ������.��ʾ�����Ǵӱ��ػ�ȡ��.����ҪURL����

	
	groupField
		* ָ��������ֶ�����
	
	groupFormatter
		* ���ظ�ʽ����ķ��������ı�
		* demo
			$('#cc').combobox({
				groupFormatter: function(group){
					return '<span style="color:red">' + group + '</span>';
				}
			});

	method
		* ��������Զ�����ݵ����󷽷�,Ĭ��ֵΪ:'POST'
	
	data
		* ���������������,������һ��json��������
		* demo
			<input class="easyui-combobox" data-options="
				valueField: 'label',
				textField: 'value',
				data: [{
					label: 'java',
					value: 'Java'
				},{
					label: 'perl',
					value: 'Perl'
				},{
					label: 'ruby',
					value: 'Ruby'
				}]" />
	
	queryParams
		* ����Զ�̷�����ʱ�����ύ������
			$('#cc').combobox({
				url : "127.0.0.1/xxx",
				queryParams: {
					"age" : 25,
					"order" : "desc"
				}
			});

	showItemIcon
		* ��ֵ���Ϊ true .��ʾѡ�����ͼ�ꡣ
	
	groupPosition
		* ��λ����ѡ�����ֵ��:'static'��'sticky'��
		* ������Ϊ��sticky��ʱ�Ὣ����ѡ���ǩ�̶�����������
	
	filter
		* ���嵱'mode'����Ϊ'local'ʱ��ι��˱������ݣ�������2������
			q	//�û�������ı���
			row	//�б������ݡ�
		* ����true��ʱ����������ʾ
		* demo
			$('#cc').combobox({
				filter: function(q, row){
					var opts = $(this).combobox('options');
					return row[opts.textField].indexOf(q) == 0;
				}
			});
	
	formatter
		* ������ν�����Ⱦ,�߱�һ������:row
			$('#cc').combobox({
				formatter: function(row){
					var opts = $(this).combobox('options');
					return row[opts.textField];
				}
			});
	
	loader
		* ��������δ�Զ�̷�������������,���� false ������ֹ�¼�
		* loader : function(param,success,error){}
			//param:���ݵ�Զ�̷������Ĳ�������
			//�ڼ������ݳɹ���ʱ����øûص�����
			//�ڼ�������ʧ�ܵ�ʱ����øûص�������
	
	loadFilter
		* ���ع��˺�����ݲ���ʾ��
		* function(data){}
	

-------------------------
EasyUI-ComboBox�¼�		 |
-------------------------
	'�����б���¼��̳���combo(�Զ���������)�������б���������¼����£�'

	onBeforeLoad
		* �������������֮ǰ����������falseȡ���ü��ض����� 
		* �߱�һ������
			$('#cc').combobox({
				onBeforeLoad: function(param){
					param.id = 2;
					param.language = 'js';
				}
			});
	
	onLoadSuccess
		* �ڼ���Զ�����ݳɹ�ʱ����,û�в���
	
	onLoadError
		* �ڼ���Զ�������쳣ʱ����,û�в���
	
	onChange
		* �ڲ��������仯��ʱ�򴥷�.�߱���������.��һ������ֵ,�ڶ����Ǿ�ֵ
	
	onSelect
		* ���û�ѡ���б��ʱ�򴥷�.�߱�һ������:record,�ò�������,�û��������Ǹ�ѡ�����
	
	onUnselect
		* ���û�ȡ���б��ʱ�򴥷�.�߱�һ������:record,�ò�������,�û��������Ǹ�ѡ�����
	


-------------------------
EasyUI-ComboBox����		 |
-------------------------
	'�����б����չ��combo(�Զ���������)�������б����������д�ķ������£�'

	options
		* �������Զ���
	
	getData
		* ���ؼ��ص�����
	
	loadData
		* ��ȡ��������,�������ݶ���
	
	reload
		* ���¼�������.��������URL,���ԵĻ�.ʹ��Ĭ�ϵ�URL
		demo
			$('#cc').combobox('reload');      // ʹ�þɵ�URL���������б�����
			$('#cc').combobox('reload','get_data.php');  // ʹ���µ�URL���������б�
	
	setValues
		* �����������ֵ
		* demo
			$('#cc').combobox('setValue', '001');
	
	clear
		* ����������ֵ
	
	select
		* ѡ��ָ����ѡ��
		* ��һ������:value ,����ѡ��ĵ�ֵ
	
	unselect
		* ȡ��ѡ��ָ����ѡ��


	reload
		* ������������.��һ��url,����.����ʡ��,�����д,�����þɵ�URL,����������µĲ���,�����µ�URL
		$('#cc').combobox('reload','get_data/load');  // ʹ���µ�URL���������б�����
	
	getData
		* ��ȡ��ǰcombobox����������
		* ��һ���������,�����������������������
	

	
	
-------------------------
EasyUI-ComboBox����		 |
-------------------------
	��������
		<input id="cc1" class="easyui-combobox" data-options="    
			valueField: 'id',    
			textField: 'text',    
			url: 'get_data1.php',    
			onSelect: function(rec){    
				//��ȡ����ڵ��ID
				var url = 'get_data2.php?id='+rec.id;    
				//׼��URL,�ύ�Ĳ���ֵΪ���ID.Ȼ������URL���õ�ָ����input��,ִ��reload����.��ôָ��input��ĵ�����,������Դ��ǰ����Ľڵ�
				$('#cc2').combobox('reload', url);    
			}" />   
		<input id="cc2" class="easyui-combobox" data-options="valueField:'id',textField:'text'" />  

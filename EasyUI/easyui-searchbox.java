------------------------
EasyUI-searchbox		|
------------------------
	# ������
	# ��������ʾ�û���Ҫ����������ֵ�������Խ��һ���˵��������û�ѡ��ͬ������������û����»س�����������ұߵ�������ť��ʱ���ִ������������
	# �̳й�ϵ
		textbox
		menubutton

------------------------
EasyUI-searchbox����	|
------------------------
	width
		* ������
	
	height
		* ����߶�
	
	prompt
		* ���������ʾ����ʾ��Ϣ
	
	value
		* ������е�ֵ
	
	menu
		* �������Ͳ˵���ÿ���˵���߱�һ�����ԣ�
			name		//�����������ơ�
			selected	//�Զ���Ĭ��ѡ�е������������ơ� 
		* demo
			<input class="easyui-searchbox" style="width:300px" data-options="menu:'#mm'" />
			<div id="mm" style="width:150px">
				<div data-options="name:'item1'">Search Item1</div>
				<div data-options="name:'item2',selected:true">Search Item2</div>
				<div data-options="name:'item3'">Search Item3</div>
			</div>
	
	searcher
		* ���û�����������ť��س�����ʱ�����searcher������
		* �����ԵĲ�����һ��: function(value,name){}
	
	disabled
		* �Ƿ����������
	
------------------------
EasyUI-searchbox�¼�	|
------------------------


------------------------
EasyUI-searchbox����	|
------------------------
	options
		* �������Զ���
	
	menu
		* �����������Ͳ˵����������������ʾ�˸��Ĳ˵���ͼ�ꡣ
		* demo
			var m = $('#ss').searchbox('menu');                    // ��ȡ�˵���var item = m.menu('findItem', 'Sports News');     // ���Ҳ˵���
			// ���Ĳ˵���ͼ��
			m.menu('setIcon', {
				target: item.target,
				iconCls: 'icon-save'
			});
			// ѡ������������
			$('#ss').searchbox('selectName', 'sports');
	
	textbox
		* �����ı������
	
	getValue
		* ���ص�ǰ����ֵ
	
	setValue
		* �����µ�����ֵ
		* ������ String
	
	getName
		* ���ص�ǰ������������

	selectName
		* ѡ��ǰ����������
		* ������������������
		* demo
			$('#ss').searchbox('selectName', 'sports');

	destroy
		* ���ٸÿؼ�
	
	resize
		* ���ÿؼ��Ŀ��,������ Number
	
	disable
		* ����������
	
	enable
		* ����������
	
	clear
		* ���������
	
	reset
		* ����������


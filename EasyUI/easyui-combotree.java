-----------------------
EasyUI-combotree		|
-----------------------
	# ������������ѡ��ؼ����������ؼ�������combobox(�����б��)���ƣ����ǽ������б����б��滻�������οؼ����ÿؼ�֧����״̬��ѡ�򣬷����ѡ������ 
	# �̳й�ϵ
		combo
		tree
-----------------------
EasyUI-combotree	����|
-----------------------
	'����������������չ��combo(�Զ���������)��tree(���οؼ�)��������������д���������£�'
	editable
		* �����û��Ƿ����ֱ�Ӱ��ı����뵽�ֶ���.Ĭ��ֵ�� false

-----------------------
EasyUI-combotree	�¼�|
-----------------------
	'�ÿؼ����¼���ȫ�̳���combo(�Զ���������)��tree(���οؼ�)��'

-----------------------
EasyUI-combotree	����|
-----------------------
	'���������򷽷���չ��combo(�Զ���������)��������������������д�ķ������£�'

	options
		* �������Զ���
	
	tree
		* �������ζ���
		* demo
			//���µ�������ʾ����εõ�ѡ������ڵ㡣 
			var t = $('#cc').combotree('tree');	// ��ȡ������
			var n = t.tree('getSelected');		// ��ȡѡ��Ľڵ�
			alert(n.text);

	loadData
		* ��ȡ������������
		* demo
			$('#cc').combotree('loadData', [{
				id: 1,
				text: 'Languages',
				children: [{
					id: 11,
					text: 'Java'
				},{
					id: 12,
					text: 'C++'
				}]
			}]);
	
	reload
		* �ٴ�����Զ������,ͨ��'url'������д����ĵ�ַ

	clear
		* ��տؼ���ֵ
	
	setValues
		* �������ֵ��ֵ�����ǽڵ��'id'ֵ��'id'��'text' ��ֵ�ԡ�
		* demo
			$('#cc').combotree('setValue', 6);
			// set value with {id,text} pairs
			$('#cc').combotree('setValue', {
				id: 61,
				text: 'text61'
			});

	setValue
		* �������ֵ����
		* demo
			$('#cc').combotree('setValues', [1,3,21]);
			$('#cc').combotree('setValues', [1,3,21,{id:73,text:'text73'}]);
	

			
			
	
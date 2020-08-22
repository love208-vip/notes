-------------------------
EasyUI-treegrid			 |
-------------------------
	# ���α��������ʾ�ֲ����ݱ�����ǻ������ݱ��������ؼ��Ϳɱ༭������α�������û������ɶ��Ƶġ��첽չ���к���ʾ�ڶ����ϵķֲ����ݡ� 
	# �̳й�ϵ
		datagrid

-------------------------
EasyUI-treegrid		���� |
-------------------------
	'���α����չ��datagrid(���ݱ��)�����α���������������£�'
	idField
		* ����ؼ��ֶ�����ʶ���ڵ㡣������ģ�
	
	treeField
		* �������ڵ��ֶΡ�������ģ�
	
	animate
		* �����ڽڵ�չ�����۵���ʱ���Ƿ���ʾ����Ч����
	
	checkbox
		* ������ÿһ���ڵ�ǰ��ʾ��ѡ��Ҳ����ָ��һ����������ָ̬���Ƿ���ʾ��ѡ�򣬵���������true��ʱ������ʾ��������ʾ��
		* demo
			$('#tg').treegrid({
				checkbox: function(row){
					var names = ['Java','eclipse.exe','eclipse.ini'];
					if ($.inArray(row.name, names)>=0){
						return true;
					}
				}
			})
	
	cascadeCheck
		* �Ƿ������
	
	onlyLeafCheck
		* �Ƿ����Ҷ�ӽڵ���ʾ��ѡ��
	
	lines
		* �����Ƿ���ʾtreegrid�С�
	
	loader
		* �����Ժ��ַ�ʽ��Զ�̷�������ȡ���ݡ�����false���Ժ��Ըö������ú�������һ�²�����
			param			//���ݵ�Զ�̷������Ĳ�������
			success(data)	//���������ݳɹ���ʱ����õĻص�������
			error()			//����������ʧ�ܵ�ʱ����õĻص�������
	
	loadFilter
		* ���ع��˺�����ݽ���չʾ��
		* function(data,parentId){}


-------------------------
EasyUI-treegrid		�¼� |
-------------------------
	'���α����¼���չ��datagrid(���ݱ��)�����α��������ʱ�����£�'
	onClickRow
		* ���û�����ڵ��ʱ�򴥷���
		* ����:row

	onDblClickRow
		* ���û�˫���ڵ��ʱ�򴥷���
		* ����:row
	
	onClickCell
		* ���û������Ԫ���ʱ�򴥷���
		* ����:field,row
	
	onDblClickCell
		* ���û�˫����Ԫ�����ʱ�򴥷�
		* ����:field,row
	
	onBeforeLoad
		* ���������ݼ���֮ǰ����������false����ȡ�����ض�����
		* ����:row, param
	
	onLoadSuccess
		* ���ݼ������֮�󴥷���
		* ����:row, data
	
	onLoadError
		* ���ݼ���ʧ�ܵ�ʱ�򴥷���������jQuery��$.ajax()������'error'�ص�����һ����
	
	onBeforeSelect
		* ���û�ѡ��һ��֮ǰ����������false��ȡ���ö�����
		* ����:row
	
	onSelect
		* ���û�ѡ���ʱ�򴥷�������false��ȡ���ö�����
		* ����:row
	
	onBeforeUnselect
		* ���û�ȡ��ѡ��һ��֮ǰ����������false��ȡ���ö�������
		* ����:row
	
	onUnselect
		* ���û�ѡ��һ�нڵ�֮ǰ����������false��ȡ���ö���
		* ����:row
	
	onBeforeCheckNode
		* ���û�ѡ��һ�нڵ�֮ǰ����������false��ȡ���ö���
		* ����:row,checked
	
	onCheckNode
		* ���û�ѡ��һ�нڵ��ʱ�򴥷�������false��ȡ���ö�����
		* ����:row,checked
	
	onBeforeExpand
		* �ڽڵ�չ��֮ǰ����������false����ȡ��չ���ڵ�Ķ�����
		* ����:row

	onExpand
		* �ڽڵ㱻չ����ʱ�򴥷���
		* ����:row
	
	onBeforeCollapse
		* �ڽڵ��۵�֮ǰ����������false����ȡ���۵��ڵ�Ķ�����
		* ����:row
	
	onCollapse
		* �ڽڵ㱻�۵���ʱ�򴥷���
		* ����:row
	
	onContextMenu
		* ���Ҽ�����ڵ��ʱ�򴥷���
		* ����:e, row
	
	onBeforeEdit
		* ���û���ʼ�༭�ڵ��ʱ�򴥷���
		* ����:row
	
	onAfterEdit
		* ���û���ɱ༭��ʱ�򴥷���
		* ����:row,changes
	
	onCancelEdit
		* ���û�ȡ���༭�ڵ��ʱ�򴥷���
		* ����:row
	

-------------------------
EasyUI-treegrid		���� |
-------------------------
	'�ܶ෽����ʹ��'id'������������'id'�����������ڵ��ֵ�� '

	options
		* �������α������
	
	resize
		* �������α���С��options����2�����ԣ�
			width	//���α����¿�ȡ�
			height	//���α����¸߶ȡ�
	
	fixRowHeight
		* ����ָ�����иߡ�
		* ����:id
	
	load
		* ��ȡ����ʾ��ҳ����
		* ����:param
		* demo
			// ��ȡ�������������
			$('#tg').treegrid('load', {
				q: 'abc',
				name: 'name1'
			});
	
	loadData
		* ��ȡ���α�����ݡ�
		* ����:data
	
	reload
		* ���¼������α�����ݡ����'id'������ֵ������������ָ�������У������������������С� 
		* demo
			$('#tt').treegrid('reload', 2);	// ��������ֵΪ2����
			$('#tt').treegrid('reload');	// ��������������
	
	reloadFooter
		* ��������ҳ�����ݡ�
		* ����:footer
	
	getData
		* ��ȡ�������ݡ�
	
	getFooterRows
		* ��ȡҳ�����ݡ�
	
	getRoot
		* ��ȡ���ڵ㣬���ؽڵ����
	
	getRoots
		* ��ȡ���и��ڵ㣬���ؽڵ����顣
	
	getParent
		* ��ȡ���ڵ㡣
		* ����:id
	
	getChildren
		* ��ȡ�ӽڵ�
		* ����:id
	
	getSelected
		* ��ȡѡ��Ľڵ㲢�����������û�нڵ㱻ѡ���򷵻�null��
	
	getSelections
		* ��ȡ����ѡ��Ľڵ㡣
	
	getLevel
		* ��ȡָ���ڵ�ȼ���
		* ����:id
	
	find
		* ����ָ���ڵ㲢���ؽڵ����ݡ�
		* ����:id
	
	select
		* ѡ��һ���ڵ㡣
		* ����:id
	
	unselect
		* ��ѡһ���ڵ㡣
		* ����:id
	
	selectAll
		* ѡ�����нڵ㡣
	
	unselectAll
		* ��ѡ���нڵ㡣
	
	collapse
		* ���һ���ڵ�
		* ����:id
	
	expand
		* չ��һ���ڵ㡣
		* ����:id
	
	collapseAll
		* �۵����нڵ㡣
		* ����:id
	
	expandAll
		* չ�����нڵ㡣
		* ����:id
	
	expandTo
		* �򿪴Ӹ��ڵ㵽ָ���ڵ�֮������нڵ㡣
		* ����:id
	
	toggle
		* �ڵ�չ��/�۵�״̬��������
	
	append
		* ׷�ӽڵ㵽һ�����ڵ㣬'param'���������������ԣ�
			parent	//���ڵ�ID�����δָ����׷�ӵ����ڵ㡣
			data	//���飬�ڵ����ݡ�
	
		* demo
			// ׷�����ɽڵ㵽ѡ�нڵ�ĺ���var node = $('#tt').treegrid('getSelected');
			$('#tt').treegrid('append',{
				parent: node.id,  // the node has a 'id' value that defined through 'idField' property
				data: [{
					id: '073',
					name: 'name73'
				}]
			});
	
	insert
		* ����һ���½ڵ㵽ָ���ڵ㡣'param'��������һ�²�����
			before	//����ָ���ڵ�IDֵ֮ǰ��
			after	//����ָ���ڵ�IDֵ֮��
			data	//�½ڵ����ݡ� 
		* demo
			// ����һ���½ڵ㵽ѡ��Ľڵ�֮ǰ
			var node = $('#tt').treegrid('getSelected');
			if (node){
				$('#tt').treegrid('insert', {
					before: node.id,
					data: {
						id: 38,
						name: 'name38'
					}
				});
			}
	
	remove
		* �Ƴ�һ���ڵ�����������ӽڵ㡣
		* ����:id
	
	pop
		* ���������ؽڵ������Լ������ӽڵ�֮��ɾ����
		* ����:id

	refresh
		* ˢ��ָ���ڵ㡣
		* ����:id
	
	update
		* ����ָ���ڵ㡣'param'���������������ԣ�
			id		//Ҫ���µĽڵ��ID��
			row		//�µ�������
	
		* demo
			$('#tt').treegrid('update',{
				id: 2,
				row: {
					name: '������',
					iconCls: 'icon-save'
				}
			});
	
	beginEdit
		* ��ʼ�༭һ���ڵ㡣
		* ����:id
	
	endEdit
		* �����༭һ���ڵ㡣
		* ����:id
	
	cancelEdit
		* ȡ���༭һ���ڵ㡣
		* ����:id
	
	getEditors
		* ��ȡָ���б༭����ÿ���༭���������������ԣ�
			actions	//�༭��ִ�еĶ�����
			target	//Ŀ��༭����jQuery����
			field	//�ֶ����ơ�
			type	//�༭�����͡�
	
	getEditor
		* ��ȡָ���༭����'param'��������2�����ԣ�
			id		//�нڵ�ID��
			field	//�ֶ����ơ�
	
	showLines
		* ��ʾtreegrid�С�



	

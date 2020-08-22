----------------------------
EasyUI-datagrid				|
----------------------------
	# DataGrid
	# DataGrid�Ա����ʽչʾ���ݣ����ṩ�˷ḻ��ѡ�����򡢷���ͱ༭���ݵĹ���֧�֡�DataGrid������������̿���ʱ�䣬����ʹ������Ա����Ҫ�߱��ض���֪ʶ���������������ҹ��ܷḻ����Ԫ��ϲ������б��⡢�����к�ҳ��ֻ�����е�һС���ֹ��ܡ�
	# ������ϵ
		panel
		resizable
		linkbutton
		pagination


----------------------------
EasyUI-datagrid����			|
----------------------------
	columns
		* �ص�,�������ݵ���ʾ.
		* ����������Կ�'columns'����
		* ֵ��һ����ά����,ÿһ������,����һ����ͷ.֧�ֶ༶��ͷ
			columns:[
						[	
							{field:'labelid',title:'��������',width:100,align:'center',sortable:true},    
							{field:'name',title:'��ǩ����',width:100,align:'center',sortable:true},    
							{field:'code',title:'��ǩ��',width:100,align:'center',sortable:true},
							{field:'createdate',title:'����ʱ��',width:100,align:'center',sortable:true},    
							{field:'modifydate',title:'�޸�ʱ��',width:100,align:'center',sortable:true},    
							{field:'createuser',title:'�����û�',width:100,align:'center',sortable:true},
							{field:'status',title:'��¼״̬',width:100,align:'center',sortable:true},    
							{field:'remark',title:'��ע',width:100,align:'center',sortable:true}    
						]
					]
		* field:JSON���ֶ�
		* title:����/����
		* align:���ֱ��������λ��
		* sortable:�Ƿ��ǿ������ֶ�

	frozenColumns
		* ������һ��,������Щ�лᱻ����
		* ������,��������ԵĻ�,�Ͳ�����'fitColumns'�������,����ֵΪfalse
		* ����ָ�����ж��ᱻ����.���治���й���������.����������ǳ�������Ļ,�ͻ���ֹ�����
			frozenColumns:[
				[
					{field:'labelid',title:'��������',width:100,align:'center',sortable:true},    
					{field:'name',title:'��ǩ����',width:100,align:'center',sortable:true},    
					{field:'code',title:'��ǩ��',width:100,align:'center',sortable:true},
					{field:'createdate',title:'����ʱ��',width:100,align:'center',sortable:true},   
				]
			]

	fitColumns
		* true / false
		* true:����·�������ֹ�����,�����Ⱦ��ϻ�����Ӧ�����Ŀ��
		* ���˵����̫��,����ͽ����� false ��
	
	resizeHandle
		* �����е�λ��
		* ���õ�ֵ�У�'left','right','both'��
		* ��ʹ��'right'��ʱ���û�����ͨ���϶��Ҳ��Ե���б�������У��ȵȡ�
	
	autoRowHeight
		* ���������еĸ߶�.�����ݸ��е����ݡ�����Ϊfalse������߸������ܡ�
		* ����˵��һ�����ݹ����,�ǲ���Ҫ������ʾ
	
	toolbar
		* ֵ��һ������,����һ��ѵĹ���.����ť��ʽ����
		* ���Ĳ�����������һ��ѡ����.ָ��ĳһ��'div'��Ϊtoolbar����ʽ����
		* toolbar:[
					{
						text:'���',
						iconCls:'icon-add',
						handler:function(){
							alert('�����ť')
						}
					},'-',
					{
						text:'�༭',
						iconCls:'icon-edit',
						handler:function(){
							alert('�༭��ť')
						}
					},'-',
					{
						text:'ɾ��',
						iconCls:'icon-remove',
						handler:function(){
							alert('ɾ����ť')
						}
					},
				]
	
	striped
		* �Ƿ���ʾ������Ч��
	
	method
		* ����Զ�����ݵ���������
	
	nowrap
		* ���Ϊtrue������ͬһ������ʾ���ݡ�����Ϊtrue������߼������ܡ�
	
	idField
		* ָ����������һ�������Ǽ�¼�� primarykey
		* ֻҪ�������,�����ѡ��N����¼,�����Ƿ�ҳ.Ҳ�ܸ����ס.ͳһ�Ĳ���.��ҳɾ��
	
	data
		* ���ݼ���
		* demo
			$('#dg').datagrid({
				data: [
					{f1:'value11', f2:'value12'},
					{f1:'value21', f2:'value22'}
				]
			});
	
	loadMsg
		* ��������ʱ�����ʾ����
	
	pagination
		* �����ֵΪ true,���ڵײ���ʾһ�� ��ҳ��
	
	rownumbers
		* �����ֵΪ true,����ʾ�к�
	
	singleSelect
		* �����ֵΪ true,��ֵֻ����ѡһ��
	
	ctrlSelect
		* �����ö���ѡ���ʱ������ʹ��Ctrl��+������ķ�ʽ���ж�ѡ������
	
	checkOnSelect
		* ���Ϊtrue�����û�����е�ʱ��ø�ѡ��ͻᱻѡ�л�ȡ��ѡ�С�
		* ���Ϊfalse�����û����ڵ���ø�ѡ���ʱ��Ż���ѡ�л�ȡ����
	
	selectOnCheck
		* ���Ϊtrue��������ѡ����Զѡ���С�
		* ���Ϊfalse��ѡ���н���ѡ�и�ѡ��
	
	pagePosition
		* �����ҳ����λ��
		* ��ѡֵ:'top','bottom','both'
	
	pageNumber
		* �����÷�ҳ���Ե�ʱ���ʼ��ҳ�롣
	
	pageSize
		* �����÷�ҳ���Ե�ʱ���ʼ��ҳ���С��
	
	pageList
		* ֵ��һ������,��ʾ��������Щ��ʾ(����)ѡ��
		* pageList:[10,20,30,40,50,60,70,80,90,100]
	
	queryParams
		* ������Զ�����ݵ�ʱ��,������ύ�Ĳ�����
		* $('#table').datagrid({
			queryParams:{
				key:value,
				key:value
			}
		});
	
	sortName
		* �����������
	
	sortOrder
		* �������򷽷�.ֵ��'asc'��'desc'��
	
	multiSort
		* �Ƿ����ж�������
	
	remoteSort
		* �Ƿ�ӷ����������ݽ�������
	
	showHeader
		* �����Ƿ���ʾ��ͷ
	
	showFooter
		* �����Ƿ���ʾҳ��
	
	scrollbarSize
		* �������Ŀ��(���������Ǵ�ֱ��ʱ��)��߶�(����������ˮƽ��ʱ��)��
	
	rowStyler
		* ��һЩ����,��Ҫ'�ر�����עĿ',�ľͿ���ͨ�����������
		* ������ʽ��'background:red'����2�������ĺ�����
			index		//����������0��ʼ
			row			//������Ӧ�ļ�¼�С� 
		* demo
			$('#dg').datagrid({
				rowStyler: function(index,row){
					if (row.listprice>80){
						return 'background-color:#6293BB;color:#fff;';
					}
				}
			});

			$('#dg').datagrid({
				rowStyler: function(index,row){
					if (row.listprice>80){
						return 'rowStyle';    // rowStyle��һ���Ѿ������˵�ClassName(����)
					}
				}
			});
	
	loader
		* ������δ�Զ�̷������������ݡ�����false���Է�������������
		* �ú����������²�����
			param			//�������󴫵ݸ�Զ�̷�������
			success(data)	//���������ݳɹ���ʱ�����øûص�������
			error()			//����������ʧ�ܵ�ʱ�����øûص�������
	
	loadFilter
		* ���ع���������ʾ���ú�����һ������'data'����ָ��Դ���ݣ�������ȡ������Դ������Json���󣩡������Ըı�Դ���ݵı�׼���ݸ�ʽ������������뷵�ذ���'total'��'rows'���Եı�׼���ݶ��� 
		* demo
			// ��Web Service��asp.net��java��php�ȣ������JSON�������Ƴ�'d'����
			$('#dg').datagrid({
				loadFilter: function(data){
					if (data.d){
						return data.d;
					} else {
						return data;
					}
				}
			});
	
	editors
		* ����༭�е�ʱ��ʹ�õı༭��
	
	view
		* ����DataGrid����ͼ��




----------------------------
EasyUI-������				|
----------------------------
	# DataGrid����һ��������󣬸�Ԫ��Ҳ��һ���������Ԫ�����������Ԫ����һ�����ö�������������ÿһ�����ֶΡ� 
	
	title
		* �б����ı�,�ȷ� :name
	
	field
		* ���ֶ�����,�ȷ� :kevin
	
	width
		* �еĿ��
		* ���û�ж��壬��Ƚ��Զ���������Ӧ�����ݡ�
	
	rowspan
		* ָ����ռ�ö����е�Ԫ�񣨺ϲ��У���
	
	colspan
		* ָ����ռ�ö����е�Ԫ�񣨺ϲ��У���
	
	align
		* ָ����ζ��������ݡ�����ʹ�õ�ֵ�У�'left','right','center'��
	
	halign
		* ָ����ζ����б��⡣����ʹ�õ�ֵ�У�'left','right','center'��
		* ���û��ָ��������align���Խ��ж��롣
	
	sortable
		* �����ֵΪ true,�������������
	
	order
		* Ĭ�ϵ���������,ֻ����'asc'��'desc'
	
	resizable
		* ���Ϊtrue�������иı��С��
	
	fixed
		* ���Ϊtrue����"fitColumns"����Ϊtrue��ʱ����ֹ������Ӧ��ȡ�
	
	hidden
		* ���Ϊtrue���������С�
	
	checkbox
		* ���Ϊtrue������ʾ��ѡ�򡣸ø�ѡ���й̶���ȡ�
	
	formatter
		* ��Ԫ��formatter(��ʽ����)��������3��������
			value	//�ֶ�ֵ��
			row		//�м�¼���ݡ�
			index	//�������� 
	
	styler
		* ��Ԫ��styler(��ʽ)������������'background:red'�������Զ��嵥Ԫ����ʽ�ַ������ú�����3��������
				value	//�ֶ�ֵ��
				row		//�м�¼���ݡ�
				index:	//�������� 
		
		* demo
			$('#dg').datagrid({
				columns:[[
					{field:'listprice',title:'List Price', width:80, align:'right',
						styler: function(value,row,index){
							if (value < 20){
								return 'background-color:#ffee00;color:red;';
							}
						}
					}
				]]
			});

	sorter
		* ����������������Զ����ֶ�����������2��������
			a		//��һ���ֶ�ֵ��
			b		//�ڶ����ֶ�ֵ�� 
		* demo
			$('#dg').datagrid({
				remoteSort: false,
				columns: [[
					{field:'date',title:'Date',width:80,sortable:true,align:'center',  
						sorter:function(a,b){  
							a = a.split('/');  
							b = b.split('/');  
							if (a[2] == b[2]){  
								if (a[0] == b[0]){  
									return (a[1]>b[1]?1:-1);  
								} else {  
									return (a[0]>b[0]?1:-1);  
								}  
							} else {  
								return (a[2]>b[2]?1:-1);  
							}  
						}  
					}
				]]
			});
	editor
		* ָ���༭����
		* ָ���༭���͡����ַ���ָ���༭���͵�ʱ�򣬶������2�����ԣ�
			type
				�ַ������ñ༭���Ϳ���ʹ�õ������У�text,textarea,checkbox,numberbox,validatebox,datebox,combobox,combotree��
			options
				����object, �ñ༭�����Զ�Ӧ�ڱ༭���͡� undefined .��ʵ������������Ե�����
			
	
----------------------------
EasyUI-Editor				|
----------------------------	
	'ÿһ���༭����������Ķ�����'
	init
		* ��ʼ���༭��,�����ض���
		* ����:container, options
	
	destroy
		* ����б�Ҫ,���ٱ༭��
		* ����:target
	
	getValue
		* �ӱ༭���л�ȡֵ
		* ����:target
	
	setValue
		* ��༭����д��ֵ
		* ����:target , value

	resize
		* ����б�Ҫ,�����༭����С
		* ����:target , width

----------------------------
EasyUI-DataGrid View		|
----------------------------
	'����ͼ��һ�����󣬽�����DataGrid�����Ⱦ�С��ö�����붨�����к�����'
	render
		* ���ݼ���ʱ���á�
		* �߱���������:
			target		//DOM����DataGrid����
			container	//��������
			frozen		//ָ�������Ⱦ����������
	
	renderFooter
		* ����һ��ѡ��������Ⱦ��ҳ�š�
		* ����:target, container, frozen
	
	renderRow
		* row ����һ�����Թ��ܣ�������render������ 
		* ����:target, fields, frozen, index, row
		
	refreshRow
		* �������ˢ��ָ�����С�
		* ����:target, index
	
	onBeforeRender
		* ����ͼ������֮ǰ����
		* ����:target, rows
	
	onAfterRender
		* ����ͼ����֮�󴥷�
		* ����:target

	
----------------------------
EasyUI-datagrid�¼�			|
----------------------------
	onLoadSuccess
		* �����ݼ��سɹ���ʱ�򴥷�
		* ����:data
	
	onLoadError
		* ��Զ�����ݼ����쳣��ʱ�򴥷�
	
	onBeforeLoad
		* ������������������֮ǰ�������������false����ֹ�������ݲ�����
	
	onClickRow
		* ���û����һ�е�ʱ�򴥷�������������
			index	//������е�����ֵ��������ֵ��0��ʼ��
			row		//��Ӧ�ڵ���еļ�¼��
	
	onDblClickRow
		* ���û�˫��һ�е�ʱ�򴥷�,����������
			index	//������е�����ֵ��������ֵ��0��ʼ��
			row		//��Ӧ�ڵ���еļ�¼��
		
	onClickCell
		* ���û�����һ����Ԫ���ʱ�򴥷�
		* ����:index, field, value
	
	onDblClickCell
		* ���û�˫��һ����Ԫ���ʱ�򴥷�
		* ����:index, field, value
		* demo
			// ��˫��һ����Ԫ���ʱ��ʼ�༭�����ɱ༭����Ȼ��λ���༭�����������
			$('#dg').datagrid({
				onDblClickCell: function(index,field,value){
					$(this).datagrid('beginEdit', index);
					var ed = $(this).datagrid('getEditor', {index:index,field:field});
					$(ed.target).focus();
				}
			});
	
	onBeforeSortColumn
		* ���û�����һ����֮ǰ����
		* ���� false,������ֹ���¼�
		* ����:sort, order
		
	onSortColumn
		* ���û�����һ���е�ʱ�򴥷�
		* sort, order
	
	onResizeColumn
		* ���û������д�С��ʱ�򴥷�
		* ����:field, width
	
	onBeforeSelect
		* ���û�ѡ��һ��֮ǰ����.����false��ȡ���ö���
	
	onSelect
		* ���û�ѡ��һ�е�ʱ�򴥷�������������
			index	//ѡ����е�����ֵ��������0��ʼ��
			row		//��Ӧ��ȡ��ѡ���еļ�¼��
	
	onBeforeUnselect
		* ���û�ȡ��ѡ��һ�еĵ�ʱ�򴥷�,����false��ȡ���ö�����
		* ����:index, row
	
	onUnselect
		* ���û�ȡ��ѡ��һ��֮ǰ����,������������
			index		//ѡ����е�����ֵ��������0��ʼ��
			row			//��Ӧ��ȡ��ѡ���еļ�¼��
	
	onSelectAll
		* ���û�ѡ�������е�ʱ�򴥷�
		* ����:rows
	
	onUnselectAll
		* ���û�ȡ��ѡ�������е�ʱ�򴥷�
		* ����:rows
	
	onBeforeCheck
		* ���û�У��һ��֮ǰ����,����false��ȡ���ö�����
		* ����:index, row
	
	onCheck
		* ���û���ѡһ�е�ʱ�򴥷�
		* ����:index, row
	
	onBeforeUncheck
		* ���û�ȡ��У��һ�е�ʱ�򴥷�
		* ����:index, row
	
	onUncheck
		* ���û�ȡ����ѡһ�е�ʱ�򴥷�������������
			index	//ѡ�е���������������0��ʼ��
			row		//��Ӧ��ȡ����ѡ�еļ�¼��

	onCheckAll
		* ���û���ѡ�����е�ʱ�򴥷���
		* ����:rows
	
	onUncheckAll
		* ���û�ȡ����ѡ�����е�ʱ�򴥷�
		* ����:rows
	
	onBeforeEdit
		* ���û���ʼ�༭һ�е�ʱ�򴥷�������������
			index	//�༭�е�������������0��ʼ��
			row		//��Ӧ�ڱ༭�еļ�¼��
	
	onBeginEdit
		* ��һ�н���༭ģʽ��ʱ�򴥷�
		* ����:index, row
	
	onEndEdit
		* ����ɱ༭,���Ǳ༭����û���ٵ�ʱ�򴥷�
		* ����:index, row, changes

	onAfterEdit
		* ���û���ɱ༭һ�е�ʱ�򴥷�������������
			index		//�༭�е�������������0��ʼ��
			row			//��Ӧ����ɱ༭���еļ�¼��
			changes		//���ĺ���ֶ�(��)/ֵ�ԡ�
	
	onCancelEdit
		* ���û�ȡ���༭һ�е�ʱ�򴥷�������������
			index		//�༭�е�������������0��ʼ��
			row			//��Ӧ�ڱ༭�еļ�¼��
	
	onHeaderContextMenu
		* ������һ�DataGrid���ͷ��ʱ�򴥷���
		* ����:e, field
	
	onRowContextMenu
		* �Ҽ��¼�,����˵�һ�ĳһ������,�ᴥ�����¼� - һ�㶼�����һ��˵�
		* ����������:e:�¼�,rowIndex:�к�,��0��ʼ.rowData:�һ�����һ�е�����
			onRowContextMenu : function(e,rowIndex,rowData){
				//e:���¼�.��Ҫͨ��������ֹ��������Ҽ�����
				//��ֹ������Ҽ��¼�
				e.preventDefault();
				//ȡ������ѡ��
				$(this).datagrid('unselectAll');
				//ѡ��ָ������(�϶����ǵ������һ��)
				$(this).datagrid('selectRow',rowIndex);
				//�ҵ��˵�,ִ��'show'����
				$('#menu').menu('show',{
					//���ò˵����ֵ�λ��,��ֵͨ��e��������ȡ
					left:e.pageX,
					top:e.pageY
				})
			}
			<div id="menu">

			</div>
	

	
----------------------------
EasyUI-datagrid����			|
----------------------------
	options
		* �������Զ���
	
	getPager
		* ����ҳ�����
	
	getPanel
		* ����������
	
	getColumnFields
		* �������ֶΡ����������frozen����Ϊtrue�������ع̶��е��ֶ�����
		* demo
			var opts = $('#dg').datagrid('getColumnFields');               // ��ȡ�ⶳ��
			var opts = $('#dg').datagrid('getColumnFields', true);       // ��ȡ������

	getColumnOption
		* ����ָ��������
		* ������:field
	
	resize
		* �������Ͳ���
		* ������:param

	load
		* ���¼��ر�����.�Ե�ǰҳΪҳ��
		* �����ύһЩ��������̨,��ִ�б���ѯ��ʱ����õ�.һ���ύ�˲���,��ҳ���Ǵ�1��ʼ
			$('#table-user').datagrid('load',{
				key:value,		//�ύ����̨�Ĳ���
				key:value
			});
	
	reload
		* ��������ʵ��һ����
		* '����������ס��ǰҳ,���ܴ���ʲô����.�����Ե�ǰҳΪҳ����в�ѯ'
	
	reloadFooter
		* ����ҳ���С�����ʾ���� 
		// ����ҳ���е�ֵ��ˢ��var rows = $('#dg').datagrid('getFooterRows');
		rows[0]['name'] = 'new name';
		rows[0]['salary'] = 60000;
		$('#dg').datagrid('reloadFooter');

		// ����ҳ���в�����������$('#dg').datagrid('reloadFooter',[
			{name: 'name1', salary: 60000},
			{name: 'name2', salary: 65000}
		]);
	
	loading
		* ��ʾ����״̬
	
	loaded
		* ��������״̬
	
	fitColumns
		* ʹ���Զ�չ��/���������ʵ�DataGrid��ȡ�
	
	fixColumnSize
		* �̶��д�С�����'field'����δ���ã������д�С�����ǹ̶��ġ�
		* demo
			$('#dg').datagrid('fixColumnSize', 'name');        // �̶�'name'�д�С
			$('#dg').datagrid('fixColumnSize');                    // �̶������д�С
	
	fixRowHeight
		* �̶�ָ���и߶ȡ����'index'����δ���ã������и߶ȶ��ǹ̶��ġ�
	
	freezeRow
		* ����ָ���У���DataGrid������¹�����ʱ��ʼ�ձ��ֱ����������ʾ�ڶ���
	
	autoSizeColumn
		* �Զ������п������Ӧ���ݡ�
	
	loadData
		* ���ر������ݣ��ɵ��н����Ƴ���
		* ����:data
	
	getData
		* ���ؼ�����Ϻ�Ķ���
	
	getRows
		* ���ص�ǰҳ������
	
	getFooterRows
		* ����ҳ���С�
	
	getRowIndex
		* ����ָ���е������ţ����еĲ���������һ�м�¼��һ��ID�ֶ�ֵ��
	
	getChecked
		* �ڸ�ѡ����ѡ�е�ʱ�򷵻�������
	
	getSelected
		* ���ص�һ����ѡ�е��л����û��ѡ�е����򷵻�null.
	
	getSelections
		* �������б�ѡ�е��У���û�м�¼��ѡ�е�ʱ�򽫷���һ�������顣
	
	clearSelections
		* �������ѡ����С�

	clearChecked
		* ������й�ѡ����
	
	scrollTo
		* ������ָ�����С�
	
	gotoPage
		* ��ת��ָ��ҳ
		* demo
			// ��ת����3ҳ
			$('#dg').datagrid('gotoPage', 3);

			// ��ת����3ҳ��ִ�лص�����
			$('#dg').datagrid('gotoPage', {
				page: 3,
				callback: function(page){
					console.log(page)
				}
			})
	
	highlightRow
		* ����һ�С�
		* ����:index
	
	selectAll
		* ѡ��ǰҳ��������
	
	unselectAll
		* ȡ��ѡ�����е�ǰҳ�����е��С�
	
	selectRow
		* ѡ��һ�У���������0��ʼ��
	
	selectRecord
		* ͨ��IDֵ����ѡ��һ�С�
		* ����Ϊ ID
	
	unselectRow
		* ȡ��ѡ��һ��
	
	checkAll
		* ��ѡ��ǰҳ�е������С�
	
	uncheckAll
		* ȡ����ѡ��ǰҳ�е�������
	
	checkRow
		* ��ѡһ�У���������0��ʼ
	
	uncheckRow
		* ȡ����ѡһ�У���������0��ʼ��
	
	beginEdit
		* �����༭ģʽ,����:index
	
	endEdit
		* �����༭һ��,����:index
	
	cancelEdit
		* ȡ���༭��,����:index
	
	getEditors
		* ��ȡָ���еı༭����ÿ���༭�������������ԣ�
			actions		//�༭������ִ�еĶ�����ͬ�༭�����塣
			target		//Ŀ��༭����jQuery����
			field		//�ֶ����ơ�
			type		//�༭�����ͣ����磺'text','combobox','datebox'�ȡ�
	

	getEditor
		* ��ȡָ���༭����options����2�����ԣ�
			index	//��������
			field	//�ֶ����ơ� 
		* demo
			// ��ȡ���������༭������������ֵ
			var ed = $('#dg').datagrid('getEditor', {index:1,field:'birthday'});
			$(ed.target).datebox('setValue', '5/4/2012');
	
	refreshRow
		* ˢ��ָ����,����Ϊ:index
	
	validateRow
		* ��ָ֤����,������:index.�����֤ͨ��.�򷵻� true
	
	updateRow
		* ����ָ���У����������������ԣ�
			index		//ִ�и��²�������������
			row			//�����е������ݡ� 
		* demo
			$('#dg').datagrid('updateRow',{
				index: 2,
				row: {
					name: '������',
					note: '����Ϣ'
				}
			});
	
	appendRow
		* ׷��һ�����С����н�����ӵ�����λ�á� 
		* ����:row
		* demo
			$('#dg').datagrid('appendRow',{
				name: '������',
				age: 30,
				note: '����Ϣ'
			});
	
	insertRow
		* ����һ�����У���������һ�����ԣ�
			index	//Ҫ����������������������ֵδ���壬��׷�����С�
			row		//�����ݡ�
		* demo
			$('#dg').datagrid('insertRow',{
				index: 1,	// ������0��ʼ
				row: {
					name: '������',
					age: 30,
					note: '����Ϣ'
				}
			});
	
	deleteRow
		* ɾ����
		* ����:index
	
	getChanges
		* ����һ�ε��ύ��ȡ�ı�������С����Ͳ���ָ������Щ���͸ı���У�
		* ����ʹ�õ�ֵ�У�inserted,deleted,updated�ȡ�
		* �����Ͳ���δ���õ�ʱ�򷵻����иı���С�
	
	acceptChanges
		* �ύ���дӼ��ػ�����һ�ε���acceptChanges��������ĵ����ݡ�
	
	rejectChanges
		* �ع����дӴ���������һ�ε���acceptChanges��������ĵ����ݡ�
	
	mergeCells
		* �ϲ���Ԫ��options�����������ԣ�
			index	//��������
			field	//�ֶ����ơ�
			rowspan	//�ϲ���������
			colspan	//�ϲ���������
	
	showColumn
		* ��ʾָ������
		* ����:field
	
	hideColumn
		* ����ָ������
		* ����:field
	
	sort
		* ����datagrid���
		* ����:param
		* demo
			$('#dg').datagrid('sort', 'itemid');    // ����һ����
			$('#dg').datagrid('sort', {				// ָ��������˳�����
				sortName: 'productid',
				sortOrder: 'desc'
			});



	

	
----------------------------
EasyUI-datagrid����			|
----------------------------
	����µļ�¼
		1,����toolbar
		2,���'���',��ʾ���ص�panel,������һ��form��
		3,�����Ϻ����ݺ�.�ύ->У��.
		4,��ӳɹ���.��ձ����� -> ���ر� -> ʹ��datagrid reload(ȷ�����ڵ�ǰҳ) ����������������
		5,messager������ʾ
	
	�༭һ����¼
		1,����toobar
		2,���'�༭',���� datagrid �� 'getSelections'����,��ȡ��ѡ�����.
			* ������������Ǹ�����.����ǿ�����.����ûѡ��,��������
			* ���length != 1,�Ǿ���ѡ���˶���.��������
		3,��ȡ���������¼��idֵ,�Ӻ�̨��������
		4,load ������.
		5,�༭OK,�ύ - > У��
		6,ʹ��datagrid reload(ȷ�����ڵ�ǰҳ) ����������������
		7,messager������ʾ
	
	ɾ��N����¼	
		1,����toobar
		2,���'ɾ��',���� datagrid �� 'getSelections'����,��ȡ��ѡ�����.
			* ������ص��ǿ�����.�򵯳�����:'����ѡ��һ��'
		3,ѭ������.��ȡIDֵ,ƴ���ַ���.(�ǵ�ɾ�����һ���ָ��ַ���)������̨.��̨�и�.ɾ������
		4,ʹ��datagrid reload(ȷ�����ڵ�ǰҳ) ����������������
		5,messager������ʾ
		6,ע��,ɾ���ɹ���.һ��Ҫ�ǵ����:idfiled
			* ����ѡ����һ��һ����¼��,��ܻ��¼������¼��IDֵ.����������¼��ɾ����.�������IDֵ��Ȼ���ڴ���
			* �����ٴ�ִ��ĳЩѡ�������ʱ��.���IDֵ���ᱻ����.
			$('#users').datagrid('unselectAll');		//ִ��ȡ��ѡ��ǰҳ�е�������
		
	

	# ��������ͳһ��ʽ
		loadFilter:function (data) {
			if(!data.success){
				TD.showAlert(data.message);
				//���ؿ�Ԫ��
				return {total:0,rows:[]};
			}
			return data.data;
		},

------------------------
Easyui-tabs				|
------------------------
	# ѡ�
	# ������ϵ
		panel
		linkbutton

------------------------
Easyui-tabs����			|
------------------------
	width
		* ѡ��������
	
	height
		* ѡ������߶�
	
	plain
		* ����Ϊ true ��ʱ�򽫲���ʾ������屳����
	
	fit
		* ����Ϊ true ��ʱ��.ѡ��Ĵ�С�����������ڵ�������
	
	border
		* ����Ϊ true ��ʱ��,����ʾѡ������߿�
	
	scrollIncrement
		* ѡ�������ÿ�ι���������ֵ
	
	scrollDuration
		* ÿ�ι��������ĳ���ʱ��.��λ�Ǻ���
	
	tools
		* �����������ѡ����ͷ�������Ҳࡣ
		* ������ֵ������������ʽ
			1, һ�����߲˵����飬ÿ������ѡ���linkbutton��ͬ��
				$('#tt').tabs({
					tools:[{
						iconCls:'icon-add',
						handler:function(){
							alert('���')
						}
					},{
						iconCls:'icon-save',
						handler:function(){
							alert('����')
						}
					}]
				});

			2, һ��ָ��<div/>�������߲˵���ѡ������
				$('#tt').tabs({
					tools:'#tab-tools'
				});
				<div id="tab-tools">
					<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add"></a>
					<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-save"></a>
				</div>

	toolPosition
		* ���ù�������λ��
		* ��ѡֵ:'left','right'
	
	tabPosition
		* ����ѡ�λ��
		* ����ֵ��'top','bottom','left','right'
	
	headerWidth
		* ѡ�������
		* ��tabPosition��������Ϊ'left'��'right'��ʱ�����Ч
	
	tabWidth
		* ��ǩ���Ŀ��
	
	tabHeight
		* ��ǩ���ĸ߶�
	
	selected
		* ��ʼ��ѡ��һ����ǩҳ
		* ��ֵ��һ�� Number
		* ��ֵΪ��ǩҳ�� index
	
	showHeader
		* ����Ϊ true ʱ,��ʾ��ǩҳ����
	
	justified
		* �����ֵΪ true ,��ô���б�ǩҳ�ı��ⶼ��һ����
		* ���б���ƽ�ֿ��,�ŵ�������С
	
	narrow
		* �����ֵΪ true ,��ôÿ����ǩҳ֮����û�м�϶��
	
	pill
		* �����ֵΪ true ,ѡ�������ʽ��Ϊ����״��



------------------------
Easyui-tabs�¼�			|
------------------------
	onLoad
		* ��һ������:panel,��ajaxѡ���������Զ�����ݵ�ʱ�򴥷���
	
	onSelect
		* ���û�ѡ��һ������ʱ�򴥷�
		* ����������:title,index
	
	onUnselect
		* �û���ȡ��ѡ��һ��ѡ�����ʱ�򴥷�.
		* ����������:title,index

	onBeforeClose
		* ��һ��ѡ��رյ�ʱ�򴥷�,���� false,������ֹ���¼�
		* ����������:title,index
		* demo
			$('#tt').tabs({
				onBeforeClose: function(title){
					return confirm('��ȷ����Ҫ�ر� ' + title);
				}
			});
			// ʹ���첽ȷ�϶Ի���
			$('#tt').tabs({
			  onBeforeClose: function(title,index){
				var target = this;
				$.messager.confirm('ȷ��','��ȷ����Ҫ�ر�'+title,function(r){
					if (r){
						var opts = $(target).tabs('options');
						var bc = opts.onBeforeClose;
						opts.onBeforeClose = function(){};  // �������ڹر�
						$(target).tabs('close',index);
						opts.onBeforeClose = bc;  // ��ԭ�¼�����
					}
				});
				return false;	// ��ֹ�ر�
			  }
			});

	onClose	
		* ���û��ر�һ������ʱ�򴥷�
		* ������:title,index
	
	onAdd
		* ������һ������ʱ�򴥷�
		* ������:title,index
	
	onUpdate
		* �ڸ���һ��ѡ�����ʱ�򴥷�
		* ������:title,index
	
	onContextMenu
		* ���һ�һ��ѡ�����ʱ�򴥷�
		* ����:e, title,index

------------------------
Easyui-tabs����			|
------------------------
	options
		* ����ѡ�����
	
	tabs
		* ��������ѡ����
	
	resize
		* ����ѡ�������С�Ͳ���
	
	add
		* ���һ����ѡ���壬ѡ�������һ�����ö���.�鿴ѡ�������Եĸ���ϸ�ڡ�
		* �����һ����ѡ�����ʱ��������ɿ�ѡ�ġ�
		* ���һ����ѡ��״̬��ѡ����ʱ���ǵ�����'selected'����Ϊfalse��
		* demo
			// ���һ��δѡ��״̬��ѡ����
			$('#tt').tabs('add',{
				title: '��ѡ����',
				selected: false
				//...
			});
			// ������Ϊ2��λ���ϲ���һ��ѡ����
			$('#tt').tabs('add',{
				title: '�����ѡ����',
				index: 2
			});
	
	close
		* �ر�һ��ѡ����
		* ����������ѡ���������(index)�����Ǳ���(title)
	
	getTab
		* ��ȡһ��ѡ����
		* ����������ѡ���������(index)�����Ǳ���(title)
	
	getTabIndex
		* ��ȡָ��ѡ���������
		* ��������һ��ѡ�����
	
	getSelected
		* ��ȡ��ѡ���ѡ����
		* demo
			var tab = $('#tt').tabs('getSelected');			//��ȡ��ѡ���ѡ�����
			var index = $('#tt').tabs('getTabIndex',tab);	//ʹ��getTabIndex��ȡ����ѡ����±�
			alert(index);
		
	select
		* ѡ��һ�����
		* �������������������������±�
	
	unselect
		* ȡ��ѡ��һ�����
		* �������������������������±�
	
	showHeader
		* ��ʾѡ��ı�ǩͷ
	
	hideHeader
		* ����ѡ�Կ���ǩͷ
	
	showTool
		* ��ʾ������
	
	hideTool
		* ���ع�����
	
	exists
		* �ж�ָ��������Ƿ����.������ڷ��� true
	
	update
		* ����ָ��ѡ����
		* ������һ������
			tab		//Ҫ���µ�ѡ���塣
			type	//�������ͣ�����ֵ�У�'header', 'body', 'all'�����ò�����1.4.1�濪ʼ���ã�
			options	//�������ԡ�
	
		* demo
			// ����ѡ��������±��������
			var tab = $('#tt').tabs('getSelected');  // ��ȡѡ������
			$('#tt').tabs('update', {
				tab: tab,
				options: {
					title: '�±���',
					href: 'get_content.php'  // �����ݵ�URL
				}
			});

			// ���� 'refresh' ��������ѡ���������
			var tab = $('#tt').tabs('getSelected');  // ��ȡѡ������tab.panel('refresh', 'get_content.php');
	
	enableTab
		* ����ָ����ѡ�Կ����
		* �����ǿ��������ı�������������±�
	
	disableTab
		* ����ָ�������
		* �����ǿ������ı�������������±�
	
	scrollBy
		* ����ѡ�����ָ����������������ֵ�����ҹ�������ֵ���������
		* demo
			// ����ѡ����⵽���
			$('#tt').tabs('scroll', 10);
	


-----------------------------
ѡ��������				 |
-----------------------------
	'ѡ����������panel������ԵĶ������ƣ�������2�������һЩ�������ԡ�'

	id
		* ����ID����
	
	title
		* ѡ������ı���
	
	content
		* ѡ�����������
	
	href
		* ��URL����Զ�����ݵ����
	
	cache
		* ���Ϊtrue����'href'������������Чֵ��ʱ�򻺴�ѡ���塣
	
	iconCls
		* ָ������Сͼ��
	
	width
		* ѡ�Կ����Ŀ��
	
	height
		* ѡ����ĸ߶�
	
	collapsible
		* �����ֵΪ true ,������ѡ�Կ�����۵�
	

	'�������ѡ���������Ҷ��е����ԡ�'
	closable
		* �����ֵΪ true,����ʾһ���ر���ť
	
	selected
		* �����ֵΪ true,��ѡ�����ᱻѡ��
	
	disabled
		* �����ֵΪ true,��ѡ����ᱻ����
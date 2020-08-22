------------------------
EasyUI-menu				|	
------------------------
	# �˵����ͨ�����ڿ�ݲ˵������ǹ��������˵�����ıر�������������磺menubutton��splitbutton�������������ڵ�����ִ�����

------------------------
EasyUI-menu	�˵���		|	
------------------------
	id
		* �˵���ID����
	
	text
		* �˵����ı�
	
	iconCls
		* ��ʾ�ڲ˵�������16x16����ͼ���CSS��ID
	
	href
		* ���õ���˵���ʱ���ҳ��λ�á�
	
	disabled
		* �����Ƿ���ʾ�˵���Ŀ
	
	onclick
		* ����˵�ʱ,ִ�еĻص�����


------------------------
EasyUI-menu	�˵�����	|	
------------------------
	zIndex
		* ������ Number
		* �˵�z-index��ʽ����������ֵ��
	
	left
		* �˵�����߾�λ��
	
	top
		* �˵����ϱ߾�λ��
	
	align
		* �˵��Ķ��뷽ʽ.
		* ������:'left' �� 'right'
	
	minWidth
		* �˵�����С���
	
	itemHeight
		* �˵���߶�
	
	duration
		* ���ز˵��ĳ���ʱ��
		* ��λ�Ǻ���
	
	hideOnUnhover
		* ����Ϊ true ��ʱ��,������뿪�˵���ʱ���Զ����ز˵���
	
	inline
		* ������ boolean
		* ������Ϊtrueʱ���˵�������ڸ�����ǩ���ж�λ�����������body���ж�λ��
	
	fit
		* ������Ϊtrueʱ���˵��ߴ罫�Զ����丸����
	
	noline
		* ������Ϊtrueʱ���˵�������ʾͼ�������֮��ķָ��ߡ�
	


------------------------
EasyUI-menu	�¼�		|	
------------------------
	onShow
		* �ڲ˵���ʾ֮�󴥷�
	
	onHide
		* �ڲ˵�����֮�󴥷�
	
	onClick
		* �ڲ˵�������ʱ�򴥷�
		* demo
			//�����������ʾ����δ������в˵���ĵ����
			<div class="easyui-menu" data-options="onClick:menuHandler" style="width:120px;">
				<div data-options="name:'new'">�½�</div>
				<div data-options="name:'save',iconCls:'icon-save'">����</div>
				<div data-options="name:'print',iconCls:'icon-print'">��ӡ</div>
				<div class="menu-sep"></div>
				<div data-options="name:'exit'">�˳�</div>
			</div>
			<script type="text/javascript">
				function menuHandler(item){
					alert(item.name)
				}
			</script>
	


------------------------
EasyUI-menu	����		|	
------------------------
	options
		* �������Զ���
	
	show
		* ��ʾ�˵���ָ����λ��
		* ������һ������{left:15,top:55}
	
	hide
		* ���ز˵�
	
	destroy
		* ���ٲ˵�
	
	getItem
		* ��ȡָ���Ĳ˵���õ�����һ���˵����DOMԪ�ء�
		* demo
			//���������չʾ����θ���ID��ȡָ����� 
			<div id="mm" class="easyui-menu" style="width:120px">
				<div>New</div>
				<div id="m-open">Open</div>
				<div>Save</div>
			</div>

			var itemEl = $('#m-open')[0];  // ��ȡ�˵���
			var item = $('#mm').menu('getItem', itemEl);
			console.log(item);
	
	setText
		* ����ָ���˵�����ı�
		* ������һ������:{target:xx,text:'�ַ���'}
		* demo
			var item = $('#mm').menu('findItem', '����');
			$('#mm').menu('setText', {
				target: item.target,
				text: '�޸�'
			});
	
	setIcon
		* ����ָ���˵���ͼ�ꡣ'param'��������2�����ԣ�
			target		//DOM����Ҫ���õĲ˵��
			iconCls		//�µ�ͼ��CSS��ID�� 
		* demo
			$('#mm').menu('setIcon', {
				target: $('#m-open')[0],
				iconCls: 'icon-closed'
			});
	
	findItem
		* ����ָ���Ĳ˵���,���صĶ����getItem������һ���ġ� 
		* demo
			// ���ҡ��򿪡��������
			var item = $('#mm').menu('findItem', '��');
			$('#mm').menu('disableItem', item.target);
	
	appendItem
		* ׷���µĲ˵���,'options'���������²˵������ԡ�Ĭ���������ӵ����ڲ˵���Ķ�����׷��һ���Ӳ˵��'parent'����Ӧ������ָ���ĸ���Ԫ�أ����Ҹø���Ԫ�ر������Ѿ�������ҳ���ϵġ� 
		* demo
			// ׷��һ�������˵�
			$('#mm').menu('appendItem', {
				text: '�²˵���',
				iconCls: 'icon-ok',
				onclick: function(){alert('��ʾ���²˵��')}
			});
			// ׷��һ���Ӳ˵���
			var item = $('#mm').menu('findItem', '��');  // ���ҡ��򿪡���
			$('#mm').menu('appendItem', {
				parent: item.target,  // ���ø��˵�Ԫ��
				text: '��Excel�ĵ�',
				iconCls: 'icon-excel',
				onclick: function(){alert('��ʾ����Excel�ĵ���')}
			});
	
	removeItem
		* �Ƴ�ָ���˵���
		* ����:itemEl
	
	enableItem
		* ���ò˵���Ŀ
		* ����:itemEl
	
	disableItem
		* ���ò˵���
		* ����:itemEl
	
	showItem
		* ��ʾ�˵���
		* ����:itemEl
	
	disableItem
		* ���ò˵���
		* ����:itemEl
	
	showItem
		* ��ʾ�˵���
		* ����:itemEl
	
	hideItem
		* ���ز˵���
		* ����:itemEl
	
	resize
		* ����ָ���Ĳ˵���
		* ����:itemEl











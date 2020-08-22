------------------------
EasyUI-pnael			|
------------------------
	# ���������
	# �ܶ�������Ǽ̳�����
	# ���,��Ϊ�����������ݵ�����(layout,tabs,accordion��),���ṩ���۵�,�ر�,���,��С�����Զ�����Ϊ.
	# �����Ժ����׵�Ƕ�뵽WEBҳ����κ�λ��
	# ����
		easyui-panel
	
------------------------
EasyUI-�ؼ�����			|
------------------------
	id
		* ��panel����һ��Ψһ��ʶ��IDֵ
		* ������String
	
	title
		* ��嶥����ʾ�ı���
	
	iconCls:'icon-reload'
		* �����Ͻǳ���һ��Сͼ��.
		* ֵ��һ��class����,�Ǵ�:icon.css�л�ȡ��
	
	width
	height
		* ��߲���˵.��������������

	left
	top
		* ����Ҳ����������,�������������(x),�Լ�����(y)�ľ���

	cls
		* ָ��һ��css�ൽ���
	
	headerCls
		* ���һ��css�ൽ���Ķ���
	
	bodyCls
		* ���һ��css�ൽ��������


	style
		* ���һ����ʽ���������
		* ע��,ֵ��һ������
			style:{borderWidth:2}

	fit:true
		* Ĭ��ֵ��false,����Ӧ.�ŵ�����Ԫ��һ����
	
	border
		* �Ƿ���ʾ���ı߿�

	doSize
		* �������Ϊtrue,����屻������ʱ�����ô�С�����²��֡�
	
	noheader
		* �������Ϊtrue����ô�����ᴴ�������⡣
	
	content
		* ������������
	
	collapsible
		* �Ƿ���ʾ���۵���ť
	
	minimizable
		* �Ƿ���ʾ��С����ť
	
	maximizable
		* �Ƿ���ʾ�����ť
	
	closable
		* �Ƿ���ʾ�ر���ť
	
	tools
		* �Զ��幤����,������һ���������
		* tools:[
				{
					iconCls:'icon-add',
					handler:function(){alert('add')}
				},{
					iconCls:'icon-edit',
					handler:function(){alert('edit')}
				}]

	header
		* �������ı���,�����ֵ��һ��selectѡ����.ָ���������ĸ�
		* demo
			<div class="easyui-panel" style="width:300px;height:200px"
					title="�ҵ����">
				<header>������</header>
			</div>
	
	footer
		* �������ҳ��
			<div class="easyui-panel" style="width:300px;height:200px"
				title="�ҵ����" data-options="iconCls:'icon-ok',tools:[
                        {
                                    iconCls:'icon-add',
                                    handler:function(){alert('���')}
                        },{
                                    iconCls:'icon-edit',
                                    handler:function(){alert('�༭')}
                        }]">
			</div>
	
	openAnimation
		* ��������Ķ���
		* ��ѡֵ:'slide','fade','show'
	
	closeAnimation
		* ����ر����Ķ���
		* ��ѡֵ:'slide','fade','show'

	openDuration
		* ��������ĳ���ʱ��.������ Number
	
	closeDuration
		* ����ر����ĳ����¼�.������ Number
	
	collapsed
		* �����Ƿ��ڳ�ʼ����ʱ���۵����
	
	minimized
		* �����Ƿ��ڳ�ʼ��������С�����
	
	maximized
		* �����Ƿ��ڳ�ʼ����ʱ��������
	
	closed
		* �����Ƿ��ڳ�ʼ����ʱ��ر����
	
	href
		* ��Զ�̵�ַ��ȡ���ݵ����
		* ע�⣺���ݽ����ᱻ���룬ֱ�����򿪻������ڴ����ӳټ������ʱ�Ƿǳ����õ�
		* demo
			<div id="pp" class="easyui-panel" style="width:300px;height:200px"
					data-options="href='get_content.php',closed:true">
			</div>
			<a href="#" onclick="javascript:$('#pp').panel('open')">Open</a>
	

	cache
		* ���ֵΪtrue,�ڳ���������ʱ����������ݡ�
	
	loadingMessage
		* �ڼ���Զ�����ݵ�ʱ����ʾ����Ϣ
	
	extractor
		* ������δ�ajaxӦ����������ȡ���ݣ�������ȡ���ݡ�
		* demo
			extractor: function(data){
				var pattern = /<body[^>]*>((.|[\n\r])*)<\/body>/im;
				var matches = pattern.exec(data);
				if (matches){
					return matches[1];	// ����ȡ��������,������<body></body>�е�����
				} else {
					return data;
				}
			}
	
	method
		* ����Զ�̵�ַʱʹ�õ����󷽷�
	
	queryParams
		* ������Զ�̵�ַʱ������ӵĲ���
	
	loader
		* ��������δ�Զ�̷�������������ҳ���ú����������²�����
		*	param�����������͸�Զ�̷�������
			success(data)���ڼ������ݳɹ���ʱ����õĻص�������
			error()���ڼ�������ʧ�ܵ�ʱ����õĻص�������

------------------------
EasyUI-�ؼ��¼�			|
------------------------
	onBeforeLoad
		* �ڼ�������ҳ֮ǰ����������false�����Ըö�����
	
	onLoad
		* �ڼ���Զ�����ݵ�ʱ�򴥷�
	
	onLoadError
		* �ڼ��������쳣��ʱ�򴥷�
	
	onBeforeOpen
		* �ڴ����֮ǰ����,���� false,������ֹ�ö���
	
	onOpen
		* �ڴ����֮�󴥷�
	
	onBeforeClose
		* �ڹر����֮ǰ����,���� false ����ȡ���ر�������
		* <div class="easyui-panel" style="width:300px;height:200px;"
				title="My Panel" data-options="onBeforeClose:function(){return false}">
			��彫���ܹر�
		</div>
	
	onClose
		* �ڹر����֮�󴥷�
	
	onBeforeDestroy
		* ���������֮ǰ����.���� false ������ֹ�ö���
	
	onDestroy
		* ���������֮�󴥷�
	
	onBeforeCollapse
		* ������۵�֮ǰ����,���� false ������ֹ�ö���
	
	onCollapse
		* ������۵�֮�󴥷�
	
	onBeforeExpand
		* �����չ��֮ǰ����,���� false ������ֹ�ö���
	
	onExpand
		* �����չ��֮�󴥷�
	
	onResize
		* �ڵ���������С֮�󴥷�
		* ����������:width, height һ�����µĿ��ֵ���µĸ߶�ֵ
	
	onMove
		* ������ƶ�֮�󴥷�
		* ����������:left,top һ�����µ�left(x)ֵ,һ�����µ�top(y)ֵ
	
	onMaximize
		* �ڴ������֮�󴥷�
	
	onRestore
		* �ڴ��ڻָ���ԭʼ��С�󴥷�
	
	onMinimize
		* �ڴ�����С��֮�󴥷�
	

------------------------
EasyUI-�ؼ�����			|
------------------------
	options
		* �������Զ���
	
	panel
		* ����������
	
	header
		* �������ͷ������
	
	footer
		* �������ҳ�Ŷ���
	
	body
		* ��������������
	
	setTitle
		* �������ͷ���ı�������
	
	open
		* �����.�߱�һ�� boolean �Ĳ���.�����ֵΪ true,����������� onBeforeOpen �¼�
	
	close
		* �ر����.�߱�һ�� boolean �Ĳ���.�����ֵΪ true,����������� onBeforeClose �¼�
	
	destroy
		* �������.�ٱ�һ�� boolean �Ĳ���.�����ֵΪ true,����������� onBeforeDestory �¼�
	
	clear
		* ����������
	
	refresh
		* ����ˢ���������.
		* ��һ������.��һ��URL,�����ָ��.��ʹ�þɵ�URL������ˢ�²���
		* demo
			// �������ˢ�������ݡ�
			$('#pp').panel('open').panel('refresh');
			// ˢ��һ���µ�URL����$('#pp').panel('open').panel('refresh','new_content.php');
	
	resize
		* �������Ĵ�С
		* ������һ�����Զ���
		* �����б�
			width		//�µ�����ȡ�
			height		//�µ����߶ȡ�
			left		//�µ������߾�λ�á�
			top			//�µ�����ϱ߾�λ�á� 
		* demo
			$('#pp').panel('resize',{
					width: 600,
					height: 400
				});

	doLayout
		* ���������������Ĵ�С��
	
	move
		* �ƶ���嵽һ���µ�λ��
		* ������һ������.������������
			left		//�µ���߾�λ�á�
			top			//�µ��ϱ߾�λ�á�
	
	maximize
		* �����嵽�����Ĵ�С
	
	minimize
		* ��С�����
	
	restore
		* �ָ�������ص�ԭ���Ĵ�С��λ�á�
	
	collapse
		* �۵��������
	
	expand
		* չ���������
	

	




	



----------------------------
EasyUI-layout				|
----------------------------
	* ������panel
	* ʹ�� ʹ������ҳ�洴������
		<body class="easyui-layout">   
			<div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>   
			<div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>   
			<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>   
			<div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>   
			<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>   
		</body> 

	* ͨ����ǩ��������(��DIV���:easyui-layout ����)
		<div id="cc" class="easyui-layout" style="width:600px;height:400px;">   
			<div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>   
			<div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>   
			<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>   
			<div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>   
			<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>   
		</div>  
	
	* ��廹����Ƕ��ʹ��

	* center �������������ݼ���õ���.����center�ǲ��е�

	# �̳й�ϵ
		panel
		resizable
 
		
	
----------------------------
EasyUI-layout����			|
----------------------------
	fit
		* �����ֵΪ true,���������������Ĵ�С���Զ�������
		* Ĭ��ֵΪ false ,Ҳ��˵�����ǲ��������������С�������ŵ�
		* '��ʹ��'body'��ǩ�������ֵ�ʱ������ҳ����Զ����'

----------------------------
EasyUI-layout�¼�			|
----------------------------
	onCollapse 
		* ����:region ���۵���������ʱ�򴥷���

	onExpand 
		* ����:region ��չ����������ʱ�򴥷���
		
	onAdd 
		* ����:region ��������������ʱ�򴥷��� 

	onRemove 
		* ����:region ���Ƴ���������ʱ�򴥷��� 


	
----------------------------
EasyUI-layout����			|
----------------------------
	resize
		* ���ò��ֵĴ�С
	
	panel
		* ��ȡָ����ģ��
		* ������ѡ:'north','south','east','west','center'
			var north = $('#body').layout('panel','north');
			north.panel({
				title:'��������'
			});

	collapse
		* �۵�ָ�������
		* ������ String,��ѡֵ:'north','south','east','west','center'
	
	expand
		* չ��ָ�������
		* ������ String,��ѡֵ:'north','south','east','west','center'
	
	add
		* ������
		* ���Բ�����һ��'���ö���'������ϸ����鿴ѡ�������ԡ�
	
	remove
		* �Ƴ����,����ֵ�У�'north','south','east','west'��
	
	split
		* �ָ�ָ�������
		* ����ֵ : 'north','south','east','west'��
	
	unsplit
		* �Ƴ����,����ֵ�У�'north','south','east','west'��



----------------------------
EasyUI-�����������			|
----------------------------
	'����������Զ�����panel������ƣ�������ǹ����ĺ����������ԣ�'
	title
		* ����������
	
	region
		* ��������λ��
		* ��ѡֵ:north, south, east, west, center
	
	border
		* ��ֵΪtrue��ʱ��,��ʾ�������ı߿�

	split
		* ��ֵΪ true ��ʱ��,�û����Ը������Ĵ�С
	
	iconCls
		* ָ������ͼ��,����ͼ�꽫����ʾ���������ϡ�����˵
	
	href
		* ���ڶ�ȡԶ��վ�����ݵ�URL����,ע��.����ֻ���ȡ<body>�е�����</body>,���Ҳ�����  body
	
	collapsible
		* �Ƿ���ʾ�۵���ť
	
	minWidth
		* ��С�����
	
	minHeight
		* ��С���߶�
	
	maxWidth
		* ��������
	
	maxHeight
		* ������߶�
	
	expandMode
		* �ڵ���۵����ʱ�����չģʽ������ֵ�У�"float","dock"��null
		float		//������彫չ���������ڶ���������꽹���뿪���ʱ���Զ����ء�
		dock		//������彫չ������������ϣ�����꽹���뿪���ʱ�����Զ����ء�
		null		//ʲôҲ���ᷢ����
	
	collapsedSize
		* �����۵��������С
	
	hideExpandTool
		* Ϊtrueʱ�����۵�����ϵ���չ��幤�ߡ���
	
	hideCollapsedContent
		* Ϊtrueʱ�����۵�����ϵı�������
	
	collapsedContent
		* �������۵������Ҫ��ʾ�������ݡ�
		* ��������һ�� function,��� function ��һ���������Ǳ����ı�
		* demo
			collapsedContent: function(title){
				var region = $(this).panel('options').region;
				if (region == 'north' || region == 'south'){
					return title;
				} else {
					return '<div class="mytitle">'+title+'</div>';
				}
			}
	



	


	



	
------------------------
EasyUI-combo			|
------------------------
	# ������
	# �ⶫ����ǿ��֮������,������Ķ���������ͼƬ����Ϣ,��һ��ֻ������
	# ������ϵ
		textbox
		panel
	# ��ʼ������
		//ֱ�Ӷ�input���г�ʼ��
		<input id="cc" value="001">  
		$('#cc').combo({    
			required:true,    
			multiple:true   
		});  
		//��panle���г�ʼ��


------------------------
EasyUI-combo����		|
------------------------
	'������չ��validatebox(��֤��)���Զ�����������������������'

	width
		* ����Ŀ��
	
	height
		* ����ĸ߶�
	
	panelWidth
		* �������Ŀ��
	
	panelHeight
		* �������ĸ߶�
	
	panelMinWidth
		* ����������С���
	
	panelMaxWidth
		* �������������
	
	panelMinHeight
		* ����������С�߶�
	
	panelMaxHeight
		* �����������߶�
	
	panelAlign
		* ���Ķ��뷽ʽ
		* ����ֵ�У�'left','right'
	
	multiple
		* ����ֵΪ true,���ѡ��֧�ֶ�ѡ
	
	separator
		* �����ѡ��ʱ��,���ѡ��֮��ʹ�õķָ���

	selectOnNavigation
		* �Ƿ����ʹ�ü���������ѡ��
	
	editable
		* �û��Ƿ���������������������
	
	disabled
		* �Ƿ���ø��ֶ�
	
	readonly
		* �Ƿ���ֻ��ģʽ
	
	hasDownArrow
		* �����Ƿ���ʾ���µ�һ����ͷ��ť
	
	value
		* ���ֶε�Ĭ��ֵ
	
	delay
		* ִ���������ӳ�.�����û��������ݺ�.�ӳٶ�÷��͵����������м���
	
	keyHandler
		* ���û����¼���ʱ�����һ���������ð���������������Ϊ��
			keyHandler: {
				up: function(e){},
				down: function(e){},
				left: function(e){},
				right: function(e){},
				enter: function(e){},
				query: function(q,e){}
			}

------------------------
EasyUI-combo�¼�		|
------------------------
	onShowPanel	
		* ����������ʱ�򴥷�
	
	onHidePanel
		* ����������ʱ�򴥷�
	
	onChange
		* ���ֶ�ֵ�ı��ʱ�򴥷�
		* ����������:newValue,oldValue ��ֵ�;�ֵ
	

------------------------
EasyUI-combo����		|
------------------------
	'�Զ���������ķ�����չ��validatebox(��֤��)���Զ��������������ķ�������'
	options
		* �������Զ���

	panel
		* ��������������
	
	textbox
		* �����ı������
	
	destroy
		* ���ٸ����
	
	resize
		* ����������
		* �߱�һ������,��������Ŀ��ֵ
	
	showPanel
		* ��ʾ�������
	
	hidePanel
		* �����������
	
	disable
		* �������
	
	enable
		* �������
	
	readonly
		* ����ֻ��ģʽ,�߱�һ�� boolean ����
		* demo
			$('#cc').combo('readonly');			// ����ֻ��ģʽ
			$('#cc').combo('readonly', true);	// ����ֻ��ģʽ
			$('#cc').combo('readonly', false);	// ����ֻ��ģʽ
		
	validate
		* ��֤�����ֵ
	
	isValid
		* ������֤�Ľ��
	
	clear
		* ��տؼ���ֵ
	
	reset
		* ���ÿؼ���ֵ
	
	getText
		* ��ȡ������ı�
	
	setText
		* ����������ı�
	
	getValues
		* ��ȡ���ֵ������
	
	setValues
		* �������ֵ������
	
	getValue
		* ��ȡ���ֵ
	
	setValue
		* �������ֵ
	


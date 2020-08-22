-------------------------
Window					 |
-------------------------
	# Ext.window.Window
	# ������


-------------------------
����					 |
-------------------------
	title
		* ����
	width
		* ���
	minWidth
		* ��С���
    height
		* �߶�
	minHeight
		* ��С�߶�
	layout
		* ����ģʽ(Ĭ��Auto)
	renderTo
		* ��Ⱦ������
	constrain
		* �����ֵΪ true,��ô���ֻ�������������ƶ�,Ĭ��Ϊ false
	constrainHeader
		* �����ֵΪ true, �����иô��ڵı��ⳬ������
	modal
		* �Ƿ�Ϊģ̬����,Ĭ��Ϊ false
	plain
		* �����ֵΪ true,�򴰿ڵı�����͸��.Ĭ��Ϊ false
	x
		* ���ھ������Ͻ�����λ��
	y
		* ���ھ������Ͻ�����λ��
	onEsc
		* ��дonEsc����,Ĭ���������Esc����رմ���
		* ��������Esc����ʱ��,Ĭ��ִ�йرմ���,���ǿ��Ը�д

	closeAction
		* ��ִ�йرյ�ʱ��,���еĲ���.
		* ö��ֵ
			destroy(Ĭ��)		//�������
			hide				//�������
	autoScroll
		* �����ֵΪ true,��ô�����е����������,�������
	html
		* ��������ʾ������,������html����
	icon
		* ����ͼ��,������ͼƬ��·��
	iconCls
		* ����ͼ��,������һ��css��ʽ
	draggable
		* �����Ƿ������϶�
	resizable
		* �Ƿ�����ı��С
	closeable
		* �Ƿ���ʾ���ϽǵĹر� x ͼ�� Ĭ�� true
	collapsible
		* �Ƿ���ʾ������ť Ĭ�� false
	maximizable
		* �Ƿ���ʾ�����ť Ĭ�� false
	minimizable
		* �Ƿ���ʾ��С����ť Ĭ�� false
	shadow
		* �����Ƿ�����Ӱ,�����ֵΪ true,��ô���Զ�����һ��  Ext.Shadow ����
		* Ҳ�����Լ�ָ����Ӱģʽ Ext.Shadow.mode
	bodyStyle
		* �Զ�����ʽ�������body��,������һ��css��������,Ҳ����ֱ�Ӿ���css�ַ���
	bodyPadding
		* ����ڱ߾�
	items 
		* ������һ���齨����,������һ���������
		* ���û������layout���ԣ�Ĭ���ǰ�˳���������Ⱦ���������У�������������Ĵ�С�Ͷ�λ��
	tbar
		* �ڴ���Ķ���,��ӹ�����,��һ������,��һ���ǵ�����ť,Ҳ���������������
		* ��һ�ֶ��巽ʽ
			tbar: [
				{ xtype: 'button', text: 'Button 1' }
			]
		* �ڶ��ֶ��巽ʽ 
			dockedItems: [{
					xtype: 'toolbar',
					dock: 'top',
					items: [
						{ xtype: 'button', text: 'Button 1' }
					]
			}]
	bbar
		* ͬ��,�������������ڵײ�
	lbar
		* ͬ��,�����������������
	rbar
		* ͬ��,���������������ұ�
	fbar
		* ͬ��,�������������ڵײ�(���������֮�����)
							
	

-------------------------
����					 |
-------------------------
	

-------------------------
����					 |
-------------------------
	show
		* ��ʾ���
	up
		* ���Ҹ������
		* ��������������� xtype,������ѡ����

	down
		* ͬ��,���������ڲ��������
	
	destroy
		* ���ٵ�ǰ����

-------------------------
�¼�					 |
-------------------------


-------------------------
ע���					 |
-------------------------

-------------------------
��������				 |
-------------------------
	# windowGroup
		* ��ʵ���� Ext.ZIndexManager
		* ���������,ȥ�����������

	var windowGroup = new Ext.WindowGroup();
	

-------------------------
ʵս					 |
-------------------------
	/**
		�������window,���ÿ�ζ������µ�
	*/
	Ext.onReady(function(){
		//��ȡ��btnԪ��,�Ǿ���ext��װ�����ext dom����
		var btn = Ext.get("btn");
		//�󶨵���¼�
		btn.on('click',function () {
			//���id=1����������ھʹ���
			if(!Ext.getCmp("1")){
				Ext.create('Ext.window.Window',{
					id:'1',
					title:"����",
					width:500,
					height:300,
					layout:'fit',
					renderTo:Ext.getBody(),
					modal:true,
					constrainHeader:true,
					//�ر����,�������
					closeAction:'destroy'
				}).show();
			}
		});
	});
	/**
		�������window,ͬһ�����,����ʹ��
	*/
	Ext.onReady(function(){
		//��������
		var win = Ext.create('Ext.window.Window',{
			id:'1',
			title:"����",
			width:500,
			height:300,
			layout:'fit',
			renderTo:Ext.getBody(),
			modal:true,
			constrainHeader:true,
			//�ر����,�������
			closeAction:'hide'
		});
		//��ȡ��btnԪ��,�Ǿ���ext��װ�����ext dom����,�󶨵���¼�
		Ext.get('btn').on('click',function () {
			win.show();
		});
	});



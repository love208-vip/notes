-------------------------
Panel					 |
-------------------------
	# �������
	# ����
		var panel = new Ext.Panel({

		});



-------------------------
����					 |
-------------------------
	autoLoad
		* ��Ч��URL,��ʵ���Ǽ���Զ��HTMLҳ��
		* ��������<body><body/>�е�����
	autoScroll
		* �����ֵΪ true ��ô�������,����ʾ������.Ĭ��Ϊ false
	autoShow
		* �����ֵΪ true,��ô��ʾ��Ϊ "x-hidden"��Ԫ��,Ĭ��Ϊ false
	bbar
		* �ײ���,��ʾ��������
		* ��ֵ������һ������
			[{text:"��ť1"},{text:"��ť2"}]
		* ��ֵҲ������Ext.toobar
			[new Ext.Toolbar.Button({
				text:"��ť",
				handler:function(){
					Ext.MessageBox.alert("��ʾ","�����һ����ť");
				}
			})],
	tbar
		* ������,��ʾ��������
		* ��ֵ������һ������
			[{text:"��ť1"},{text:"��ť2"}]
		* ��ֵҲ������Ext.toobar
			[new Ext.Toolbar.Button({
				text:"��ť",
				handler:function(){
					Ext.MessageBox.alert("��ʾ","�����һ����ť");
				}
			})],
	buttons
		* ��ť����,�Զ���ӵ�footer,footer��ʾ��������
	buttonAlign
		* footer����ť��λ��,ö��:left,rigth,center
	collapsible
		* �����ֵΪ true,����ʾ��С����ť,Ĭ�� false
	draggable
		* �����ֵΪ true,������϶�,Ĭ��Ϊ false
	html
		* ��������
	id
		* �������IDֵ,����ͨ��ID�ҵ�������
	width
		* ���
	heigth
		* �߶�
	title
		* ����
	titleCollapse
		* �����ֵΪ true,����������κεط�,��������С��.Ĭ��Ϊ false
	applyTo
		* �������ĸ�HTMLԪ������(IDֵ)
	renderTo
		* �������ĸ�HTMLԪ������(IDֵ) ,��������Ƕ�һ��
	contentEl
		* �����ĸ�HTMLԪ������(IDֵ),��EL�ڵ����ݳ���
		* ��Ϲ,�������,�������:'��ǰpanel,�ڵ�����,���������ĸ����(idֵ)'
	
	
-----------------------
EasyUI-dialog			|
-----------------------
	# ������ϵ
		window 
		linkbutton
	
	# �Ի���

-----------------------
EasyUI-dialog����		|
-----------------------
	'�Ի��򴰿ڵ�������չ��window(����)���Ի��򴰿����¶�����������£�'
	title		
		* ����
	collapsible
		* �Ƿ����۵���ť
	minimizable
		* �Ƿ�����С����ť
	maximizable
		* �Ƿ��������ť
	resizable
		* �Ƿ���Ը��Ĵ�С
	toolbar
		* �ڶ�������һ�ѹ�����ť,������һ������
		* ����Ҳ������һ��һ��ѡ����:'#tools'
		toolbar:[
			{
				text:'�༭',
				iconCls:'icon-edit',
				handler:function(){
					//����¼�
					alert('edit');
				}
			}
		]
		toolbar:'tools'	//ָ����������ָ���ڵ����ṩ

	buttons
		* �Ի���ײ���ť
		* ������һ������,������һ��ѡ����
		buttons:[
			{
				text:'����',
				iconCls:'icon-save',
				handler:function(){...}
			}
		]
		buttons:'#buttons'
	

-----------------------
EasyUI-dialog�¼�		|
-----------------------
	'�Ի��򴰿��¼���ȫ�̳���window(����)��'

-----------------------
EasyUI-dialog����		|
-----------------------
	'�Ի��򴰿ڵķ�����չ��window(����)���Ի��򴰿������ķ�������'
	dialog
		* �����ⲿ�Ի����ڶ���

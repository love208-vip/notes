---------------------
WindowGroup			 |
---------------------
	# Ext.WindowGroup
	# ����:Ext.ZIndexManager
	# ֻҪ���ܸ��������,�����Խ���������ͳһ,�����Ĺ���
	# ����
		var windowGroup = Ext.create('Ext.WindowGroup');


---------------------
����				 |
---------------------
	register
		* ע��һ��window�����������
		* ��������һ���������
	
	hideAll
		* �������б���������
	
	each
		* ѭ��������������
		* demo
			windowGrou.each(function(item){
				item.show();
			});
	
	show
		* ��ʾ��������������
	
	get
		* ͨ��id,��ȡ��ע������
	
	getAcitve
		* ��ȡ���������,�Ѿ����������
	
	bringToFront
		* �����ǹ�������е���������ĵ�IDֵ
		* ���ָ�������,��ʾ����ǰ��

	sendToBack
		* ��ָ��IDֵ�����,�ŵ������,�������෴
	
	unregister
		* ����IDֵ,�Ƴ�ָ�������
	
	create
		* 
	
-----------------
Ext				 |
-----------------
	# Ext��һ��ȫ�ֵĵ�������


-----------------
����(��̬)		 |
-----------------
	application
	get
		* ������һ��dom�ڵ��idֵ
		* ��ȡ��һ����Ext��װ����� dom����
		* ext dom����Ĳ���
			* ���¼�
				on('�¼�',function(){
			
				});
			* ��ȡԭʼ��dom����
				.dom;
	
	getCmp
		* ������һ�������idֵ
		* ��ʵ���� Ext.ComponentManager.get();����д

	define
		* ����һ���Զ�����
		* �������ʼǽ���
	
	widget
		* ��������,��ʹ�ñ�������ʽ����.�漰�� xtype ����

	createWidget
		* ������һ����,�����Ǽ�д
		
	apply
		* ��������,ԭ����,��ǿ����,������Ϣ
		* �÷���,��Ҫ����Ϊ������չ���Ժͷ���
			 //ԭʼ����
			var src = {name:"vin",age:23};
			//��ǿ����
			var config = {name:"hah",sex:"��"};
			Ext.apply(src,config);
			println(src.name + ":" + src.sex)//hah:��
		* �����ǰ���������,ԭ�����Ѿ�����.��ôԭ����Ļᱻ����

	applyIf
		* ͬ��,���������������ֻ�Ḵ��ԭ����û�еķ���

	typeOf
		* ��ԭ��JS��  typeof ��ʵ���
	
	iterate
		* ������,һ���Ͷ�
			Ext.iterate(arr,function(item){
				console.log(item);
			});
	
	override
		* ��дָ�����ָ������
		* һ���Ͷ�
			Ext.override(user,{
				say:function(){
					alert("���Ǹ����˵�say����");
				}
			});
	

	-----Ext-more.js (��Ext����������)


-----------------	
����			 |
-----------------
	ComponentManager
		* ��̬����,ֻҪ��Ext�������id��ʶ�����,���ᱻ��������
	

----------------------------
define						|
----------------------------
	# ����Ext4.X��˵,�������¶������ define����,�����������ɰ汾��extend����
	# Ext.define(classname,properties,callback);
		classname	:����
		properties	:���ò���
		callback	:�ص�����,�����ഴ��OK��ִ��

	# ����Զ�����,δ�̳��κ���(extend),��ô��Ĭ�ϼ̳� : Ext.Base �����


----------------------------
properties �������			|
----------------------------
	# �ò���ʵ������������ Ext.Class

	config
		* �����������,���Զ��İ����е�ÿ�����Լ���get/set����
			config:{
				name:"KevinBlandy",
				age:23,
				jobe:"java"
			}

	extend
		* �̳�,���ַ�������ʽָ����,��ô�Ϳ��԰Ѹ�������԰������캯������̳й���

	alias
		* ����

	alternateClassName
		* ������,��ʵ�� alias ���һ������

	requires
		* ������Ҫ�������,��һ������
		* ��ǰ�౻��ʼ��֮ǰ����

	uses
		* ������Ҫ�������,��һ������
		* ���ڵ�ǰ�౻��ʼ��֮�����

	constructor
		* ������Ĺ�����
			constructor:function (config) {
				var me = this;
				//��ʼ��
				me.initConfig(config);
			}
		* Ŀ����Ϊ��Ҫ��ʼ����Ϣ,һ�㶨���඼��ҪҪ��
		* configӦ����һ������,���������Ӧ����Ҫ���ø����������,����������һ��
		* new ��������,ͨ���βδ��ݳ�ʼֵ
			var vin = new Kevin({name:"Kevin"});
		* Ext.create ��������,ͨ�����ò��������ݳ�ʼֵ
			var vin = Ext.create("Kevin",{name:"Kevin"});

	mixins
		* ����,������.��һ�����Զ�̳е�����
		* key�Զ���,valueָ����.
		* �ײ����,Ext.ClassManager
			mixins:{
				foo:"ָ����"
			}
		* �̳е�ָ����s������,����.��ʵ���Ƕ�̳�

	statics
		* ���徲̬�����Ի����Ƿ���,����'���ܱ�����̳�'
			statics:{
				id:"123"
			}	
		* 'ǧ��ע��,ʵ���������޷�ʹ�þ�̬���Ի򷽷���'

	inheritableStatics
		* ���徲̬�����Ի����Ƿ�������'���Ա�����̳�'

	singleton
		* �����ֵΪ true,��ô��ǰ��ͻᱻ������������
		* Ext.create();�õ��Ļ��ǵ�������



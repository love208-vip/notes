------------------------
����					|
------------------------
	# ˵����,����ֻ��һ�������ģʽ.������
	# ��ģʽ��ʵ����4�ַ���
		1.�򵥵���
		2.�հ�����
		3.���Ե���
		4.��֧����


------------------------
�򵥵���				|
------------------------
	# ֱ�Ӵ����Ķ���,���ǵ���
	var TD = {};
	TD.Singleton = {
		sayName : function(){
			alert("����");
		}
	};
	TD.Singleton.sayName();


------------------------
�հ�����				|
------------------------
	# ����Ȼ,��˼����ͨ���հ�����������
	var TD = {};
	/**
	 * �ѿ鼶�������ִ�н����ֵ���������
	 */
	TD.Singleton = (function(){
		//˽������
		var arr1 = '��';
		var arr2 = 18523570974;
		var arr3 = function(){
			return "����˽�к���Ӵ";
		}
		return {
			name : 'KevinBlandy',
			age : 23,
			say : function(){
				alert(this.name);
			},
			sex : arr1,
			phone : arr2,
			test : arr3(),
		};
	})();

------------------------
���Ե���				|
------------------------
	# ��ʵ���ǵ������ģʽ�е�,����ʽ
	# �ӳټ���
	var Ext = {};
	Ext.Base = (function(){
		//˽�б���,���Ʒ��صĵ������
		var uniq ;
		
		//ִ�г�ʼ��,����ʵ������
		function init(){
			var arr1 = 10;
			var arr2 = true;
			var fun1 = function(){
				alert("���Ƿ���1");
			};
			var fun2 = function(){
				alert("���Ƿ���2");
			};
			return {
				p1 : arr1,
				p2 : arr2,
				p3 : fun1,
				p4 : fun2,
			}
		}
		
		return {
			getInstance : function(){
				if(!uniq){
					//��������
					uniq = init();
				}
				return uniq;
			}
		};
	})();

	var singeton = Ext.Base.getInstance();

------------------------
��֧����				|
------------------------
	# �����жϳ���ķ�֧(���������ļ��)
	# ��ʵ����,��N�������.Ȼ���ظ����߼��Ĳ�ͬ,���ز�ͬ��ʵ��

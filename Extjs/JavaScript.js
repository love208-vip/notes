------------------------
JavaScript				|
------------------------
	# û��,����JS,�����

------------------------
��������				|
------------------------
	Number
		var a = 10;
		var b = 1.2;
		var c = .6;		//��ʵ����0.6
		var d = 070;	//0��ͷ,ע��,�ǰ˽���
		var e = 0XFF;	//0x��ͷ,ע����ʮ������
		var f = 1/0;	//������
		var g = window.parseInt("10sdqwdq");		//�����10
		var h = window.parseInt("dqwdqwdq");		//�����NaN

	String

	Boolean
	
	Object
		var date = new Date();		//���ڶ���
		var arr = new Array();		//�������
		var obj = {name:"KevinBlandy",age:"23"};
		# ������ͨ�÷���(����Java��Object�ķ���)

		constructor
			* ���ض������ڵĹ�����

		hasOwnProperty
			* �жϸ������Ƿ����Լ������
			obj.hasOwnProperty("name");

		isPrototypeOf

		propertyIsEnumerable

		toLocalString

		toSource

		toString

		valueOf

	
	Undefind
		* ����������,����û�б���ֵ,��ʵҲ��ͬ�� null

	Null
		* ��ʾһ���ն��������
	
	Function
		* ��������,�� Js �бȽ�����,�ҹ����һ������
		
		function fun (){
			console.log("fun...");
		}

------------------------
����					|
------------------------
	# ȫ��
		* �����ڷ����ⲿ
		* JS������ʹ��ȫ�ֱ���(���ҵ�ʱ��Ч�ʱȽϵ�,�����ڴ��ͳ�����Ҳ����ȫ)

	# �ֲ�
		* �����ڷ����ڲ�


------------------------
����					|
------------------------
	# ����Ҳ��JS�е�һ�ֶ���,�Ƚϳ��õĶ���
	# ���Դ洢��ͬ���͵�����,���ȿɱ�
	# ���÷���
		push
		pop
		shift
		unshift
		splice
		slice
		concat
		join
		sort
		reverse

	# �µ�ѭ������
		var arr = [1,2,3,4,5,6,7,8];
		arr.forEach(function(item){
			console.log(item);
		});
	# ����
		var arr = [1,2,3,4,5,6,7,8];
		//���˵�С��5������
		var newArr = arr.filter(function(item){
			if(item > 5){
				return true;
			}
			return false;
		});

------------------------
����					|
------------------------
	# ��������Ҳ��һ����������
	# �������������ַ���
		function fun (x , y ){
			return x + y;
		};
		var fun = function(x ,y){
			return x + y;
		};

		* �������ֵ���Ҫ����,'JS���͵�ʱ����ͬ'
		* ��һ��,JS������ȥֱ�Ӿͻ�ȥ��,�����Ĵ���,���Ǵ�������˳��ִ��
		* ͨ�����:��һ��д��,������������÷���,�������ҵ��ɹ�����.�ڶ���.�������д���˺���ǰ��,��ô�ͻ�undefind


		var fun = new Function('x','y','return x + y;');
		* �����ֲ�����

	# arguments
		* ÿ�������ڲ�������һ�� arguments ����
		* arguments,��һ������,��װ�˺������β�ֵ
		* ����
			var current = aguments.callee();
			* ��ʾ���õ�ǰ��������
	
	# this �ؼ���
		* this,��JS����,����ָ�������.˭����,this ��ָ��˭
		
		
	# call,apply ��ʹ��
		* ����������Ҫ���ڵײ�,���ڰ󶨺�����������
		* call
			var color = "red";
			var obj = {color:"yello"};

			function showColor(x,y){
				alert(this.color);
			}

			showColor();				//�����red
			showColor.call(window,5,10);//�����red
			showColor.call(obj,5,10);	//�����yello
		
		* apply
			* �� callһ��,ֻ��˵,���ݵĲ���������
			showColor();					//�����red
			showColor.call(window,[5,10]);	//�����red
			showColor.call(obj,[5,10]);		//�����yello
	# ��
		* ��JS������ʵû�п�ĸ���
		(function(){
			alert("ִ��");
		})();
	
	# �հ�
		* ִ�л���
		* ��������
		* ��������


------------------------
�������				|
------------------------
	# ���ڸ߼�����,JAVA,�϶���ͨOOP���˼��
	# Json�����ʹ��
		var obj = {name:"Kevin",age:23};

		obj.sex = "��";		//��������
		obj.age = 24;		//�޸�����
		delete obj.name;	//ɾ������

		for(var attr in obj){
			//ö�ٶ�������
			console.log(arr + ":" + obj[attr]);
		}

	# �������ĸ���
		//����һ����
		var Persion = function(name,age){
			this.name = name;
			this.age = age;
		
			//˽������,����һ���� _ ��ͷ
			var _sex = "��";
			//��ȡֵ
			this.getSex = function(){
				return _sex;
			}
			//����ֵ
			this.setSex = function(sex){
				_sex = sex;
			}
		}
		//ʵ����һ������
		var p = new Persion("KevinBlandy",23);
		p.setSex("��");
		
		//��չһ������
		Persion.prototype.id = 10;
		//��չһ������
		Persion.prototype.method = function(){
			alert(this.age);
		}
		
		//��Ϊ��ݵ�����/������չ��ʽ
		//����Ҫע��,��չԭ�Ͷ����ʱ��,��Ѵ���һ��Ҫ����ԭ�Ͷ���ǰ��
		Persion.prototype = {
			//ԭ�Ͷ���Ĺ���������ָ��ǰ�����ģ��
			constructor:Persion,
			id:10,
			method:function(){
				alert(this.age);
			}
		}
			
	# ����ģʽ
		var Ext = Ext || {};
		* ������EXT����,��ôֱ�Ӹ�ֵ,�����ھ͸�ֵΪһ���ն���


		

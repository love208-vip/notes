
----------------------------
����-Object					|
----------------------------
	# ����,��һ��������������,��JAVA��Object�е�����
	# ���еĶ��󶼾߱�һЩ�����������뷽��
	# ����
		constructor
			* ���ص�ǰ����Ĺ��캯��
			* ���Ǵ����˵�ǰ�������ĺ���
		
	# �������ԵĲ���
		* ʵ������
			hasOwnProperty();
			isPrototypeOf();
			propertyIsEnumerable();
			���� in ����
				* �ж�ָ�������Ƿ�����ڶ���
				* '����ԭ�ͼ̳й���������'

		* Object��̬����
			create();
				* ��������
			keys(obj);
				* ��ȡָ���������������,��������ö�ٵ�����,��������
			getOwnPropertyNames(obj);
				* ��ȡָ���������������,����������ö������,��������
			defineProperty(); 
				* ��������ָ�������ָ�����Ե�����
			defineProperties();
				* ͬ��,һ�������ö�����Ե�����
			getOwnPropertyDescriptor(obj,prop);
				* ��ȡָ����������Ե�����
			
----------------------------
����-����					|
----------------------------
	var obj = new Object();
		* �������û�й��캯��,�ǿ���ʡ��С���ŵ�
		* new Object
	var obj = {};
	
	var obj = Object.create(Object.prototype);

----------------------------
����-����					|
----------------------------
	# ��������
		obj.name = "KevinBlandy";
		obj["name"] = "KevinBlandy";
			* ��̬���������

	
	# ��������
		var name = obj.name;
		var name = obj["name"];
	
	# ɾ������
		* ɾ���ɹ��᷵��boolean
		* ��������ɾ���Լ�������,����ɾ����ԭ�Ͷ����ϼ̳е�����
		delete obj.age;
		delete obj["age"];
	
	# ��������
		* ����ֻ�ܱ�����ö�ٵ�����
		for(var x in obj) {
			//x				:��ʾ�����������,���ַ���
			//����[����]	:��ȡָ��������ֵ
			console.log(x);
			console.log(obj[x]);
		}
	
----------------------------
����-����					|
----------------------------
	# ���巽��
		obj.say = function(){

		}
		* ��Ȼ,�϶�Ҳ���Զ������
	
	# ���÷���
		obj.say();
	
	# ɾ������
		* ɾ���ɹ��᷵��boolean
		delete obj.say;
		delete obj["say"];


----------------------------
����-˽������				|
----------------------------
	# ��������˽�г�Ա,����ֻ��Ҫ��'�����ڲ���������'(�ֲ�����),�ͺ�
	function User(){
		var sex = "����";
		var doSome = function(){
			console.log("˽�з���");
		};
		this.getSex = function(){		//�������˽�����Եķ���
			return sex;
		};
	};
	var user = new User();
	var sex = user.getSex();
	
----------------------------
����-getter/setter			|
----------------------------
	# ��������Է�Ϊ����
		1,��������,�������϶��������,������ͨ������
		2,��ȡ������
	# getter/setter ����(��ȡ������)
	# ������ʽ
		get ��������(){
			//code �ڻ�ȡֵ��ʱ�����,��סǧ����ʹ�� this.��ǰ��������
		},
		set ��������(value){
			//code ���������Ե�ʱ�����,��סǧ����ʹ�� this.��ǰ�������� ,
		}

	# ������������get��ʱ��,�����Ծ�ֻ�ܶ�ȡ(ʵ��.����),������и�ֵ����,��û��Ч��(ʵ��.���� = ֵ)
		* ���ϸ�ģʽ�л��ᱨ��
	
	# ��ȡ�������ǿ��Ա��̳е�

	# �����д�ȡ�����ԵĶ���
		var user = {
				get name(){
					out("��ȡname");		//�� ʵ��.name ��ʱ��ִ��
					return name;
				},
				set name(value){
					out("����name:"+value)	//�� ʵ��.name = xx ��ʱ��ִ��
					name = value;
				}
		}
		user.name = "KevinBlandy";		//�����µ�����
		println(user.name);


	# �����ж��������/�޸Ĵ�ȡ������
		* ע��:get�����ð��
		var user = {x:5};
		Object.defineProperty(user,"x",{
			get:function(){
				return (this.y) ? "Ĭ��ֵ": this.y;
			},
			set:function(value){
				this.y = value;
			}
		}); 

----------------------------
����-���Ե�����				|
----------------------------
	# ��ȡ���Ե�����
		Object.getOwnPropertyDescriptor(obj,prop);		
			* ��ȡָ������,ָ�����Ե�...����
			* ���ǲ���1�������Ĳ���2�����Ե�һЩ����(ֻ��...�ȵ�)
			* ���ܼ���ԭ�ͼ̳е�����
			* Object.getOwnPropertyDescriptor(user,"name")

	# ���Ե�����
		configurable	�����ܷ�ɾ���������¶���
		enumerable		���������ʱ�������Ƿ�ɼ�	
		value			����ֵ��'�����ú�������get��set'	
		writable		�����ܷ�ı�,���ø�ֵ��,ִ�� :ʵ��.���� �����з�ӳ
		get				����ȡ���Ե�ʱ�򴥷�,��סǧ����ʹ�� this.��ǰ��������	
		set				���������Ե�ʱ�򴥷�,��סǧ����ʹ�� this.��ǰ��������

		

	# ���ö�������Ե�����
		1,������ʱ������
			Object.create();
				* ֱ�Ӵ�����һ������
				* ��һ�������������ø��ö����ԭ�Ͷ���
				* �ڶ�������,���ڶԶ������Խ��и���ϸ������
				var user = Object.create(Object.prototype,{
					x:{
						get : function(){
							return 15;
						}
					}
				});
		
		2,���Ѿ������Ķ�������Խ�������
			Object.defineProperty();		//������������
				* ��ָ���Ķ�����������
				* ��������
					1,Ҫ�������ԵĶ���
					2,����ʲô����(���ַ�����ʾ���Ե�����)
					3,Options������({})
					Object.defineProperty(user,"x",{
						get:function(){
							return (this.y) ? "Ĭ��ֵ": this.y;
						},
						set:function(value){
							this.y = value;
						}
					}); 
		
			Object.defineProperties();		//��������������
				* ������һ��,ֻ����������
				* �Զ�������������������,����
				* ��һ���������Ƕ���,�ڶ�������,������һ�Ѷ���,key����������,value����һ������,�������Ե�����
					Object.defineProperties(user,{
						x:{
							get:function(){
								return (this.y) ? "Ĭ��ֵ": this.y;
							},
							set:function(value){
								this.y = value;
							}
						},
						y:{
							value:2
						}
					});
	

----------------------------
����-return	�Զ����Ӱ��	|
----------------------------
	# return ����Ĳ����޷�ִ��
	# �Դ����Ķ���û��Ӱ��
	# Demo
		function User(name,age){
			this.name = name;
			this.age = age;
			return 123;
			this.sex = "��";		//�����Ի�
		}
		var user = new User("Kevin",23);






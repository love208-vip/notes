----------------------------
js-ԭ��						|
----------------------------
	# prototype
		* ÿһ�� function(��) ����һ�� prototype ����,������ָ��һ������
		* �ö�����������Ժͷ���,�����Ա��� function �����ж��� ����
	
		function User(name,age,gender){
			this.name = name;
			this.age = age;
			this.gender = gender;
		}
		//��ȡָ�����ԭ�Ͷ���
		var prototype = User.prototype;
		//ԭ�Ͷ���Ĺ�����,������Ĺ�����
		console.log(prototype.constructor);
		//instanceof ������,Ϊ false
		console.log(prototype instanceof User);
		//�����ȴ�������
		var user1 = new User("K",23,"��");
		var user2 = new User("K",23,"��");
		//��ָ�����ԭ�Ͷ�������ӷ���
		prototype.say = function(){
			alert(this.name + "," + this.age + "," + this.gender);
		}
		//����ʵ����ԭ�Ͷ��󷽷�,����֮ǰ,�÷������븳ֵ��ԭ�Ͷ���
		user1.say();
		//����������,ԭ�Ͷ���ķ���.����ͬһ������,== ������Ϊ true
		console.log(user1.say == user2.say);
	
	# ͨ��ʵ����������ȡԭ�Ͷ���
		* ʹ��Object�ľ�̬����:	getPrototypeOf(); 
		var user = new User();
		//��ȡ User��ԭ�Ͷ���
		var prototype = Object.getPrototypeOf(user);
	
	# ԭ�Ͷ���Ķ�̬��
		* ��ԭ��
			* '����ν�Ⱥ󴴽�����,ֻҪ��֤�������Ե�ʱ��,��������֮ǰ�Ѿ���ֵ��ԭ�Ͷ���'
			function User(){
			}
			//1,�ȴ�������
			var user = new User();		
			//2,ԭ�Ͷ���ֵ����
			User.prototype.say = function(){
				alert("����say");
			}
			//3,����ԭ�ͷ���
			user.say();		
		
		* ��дԭ��
			* '����Ҫ��֤����Ĵ���,����ԭ�ͱ���д��'
			function User(){
			}
			//1,ԭ�Ͷ���д
			User.prototype = {
				say : function(){
					alert("����say");
				}
			}
			//2,��������
			var user = new User();
			//3,����ԭ�͸�д����ķ���
			user.say();


	# ����ԭ�Ͷ���
		* ԭ�Ͷ�����Ա����ǵ�
		* User.prototype = {name:'123456'}	
		* ���ַ�����ı�ԭ�Ͷ���Ĺ��캯��(function Object() { [native code] })
			//�ֶ��ķ�ʽ������ԭ�͹��캯���仯������
			//������� constructor �ᱻ in ������ö�ٳ���
			User.prototype = {
				constructor:User			
			}
		* Object�ľ�̬����:Object.defineProperty(); 
		* ����Ϊԭ�Ͷ������¶��幹����,���ҿ���ͨ��������ʹ���������ᱻö��
			Object.defineProperty(User.prototype,'constructor',{
				enumerable:false,		//���ɱ�ö��
				value:User
			}); 

	# ��ԭ�Ͷ�����������ʵ�������������Ƴ�ͻ
		* ʵ������,�Ḳ��ԭ�Ͷ����е�ͬ������(��д)
		* ʵ����Ҫ��ȡԭ�Ͷ��������ֵ,����ִ�� delete ���ɾ�����ö��������,�ٵ�������
		* ������ֱ��ͨ�� ����.���� ������/�޸Ĵ�ԭ�Ͷ���̳е�����
			function User(){}
			User.prototype.x = 5;
			var user1 = new User();
			var user2 = new User();
			user1.x = 9;		//��������user1.x ,�������޸�ԭ���е�x,���ڵ�ǰ��������/��������
			out(user1.x);		//9
			out(user2.x)		5

	# �ж�ʵ��������ֵ�Ƿ���ԭ�Ͷ��������ֵ
		* ʹ��Object��ʵ������:	hasOwnProperty();�������ڵ�ǰʵ���м�������,���������ԭ�Ͷ����е�����
		* in ������,����������ʵ������,����ȥ���ԭ�Ͷ��Ƿ�߱�ָ������ֵ
		* �������������������,�����ж������Ƿ���ԭ������

	# �ж��Ƿ�ʵ��,�Ƿ������ԭ�Ͷ����� 
		* isPrototypeOf(var obj);
		* ���obj���Ƕ���,���� this ���󲻳����� obj ��ԭ������,��÷�������false
		* demo
			function User(name,age,gender){
				this.name = name;
				this.age = age;
				this.gender = gender;
			}
			//��ȡԭ�Ͷ���
			var prototype = User.prototype;
			//��������
			var user = new User("Kevin",23,"��");
			//�ж϶�����,�Ƿ�̳���ԭ�Ͷ���
			console.log(prototype.isPrototypeOf(user));				//true
			

			//�½�һ�������ԭ�Ͷ���
			var outherPrototype = {
				test:'213'
			}
			//����ԭ�ȵ�ԭ�Ͷ���
			User.prototype = outherPrototype;
			var user1 = new User("Litch",23,"��");
			console.log(outherPrototype.isPrototypeOf(user1));		//true
	
	# ԭ�ͼ̳�
		* ��ԭ�Ͷ���,����һ�����͵�ʵ��
			//����
			function Sup(name){
				this.name = name;
			}

			//����
			function Sub(age){
				this.age = age;
			}

			//����ԭ�͸�д
			Sup.prototype = {
				constructor:Sup,
				sayName : function(){
					console.log(this.name);
				}
			}
			//����ԭ�Ͷ���,�Ǹ����ʵ��
			Sub.prototype = new Sup("KevinBlandy");
			//�����������
			var sub = new Sub(23);
			//���ø��෽��
			sub.sayName();		//KevinBlandy

		* �����ԭ�Ͷ���,���ڸ����ʵ��,��ô��������˸�������з���������,��������ԭ�͵ķ���������

-------------------------
ԭ�Ͷ����ÿ���ģʽ	 |
-------------------------
	# ԭ�Ͷ���,��Ϊ�����е�ʵ������,����Ҳ����һЩ����
		* ���ж���,�������޸�����,������һЩ'��������'
	
	# ����һ�����ʹ�ù��캯����ԭ��ģʽ
		* ʵ�ʿ�������ʹ����㷺
		* ��ʵ����'�����İ�ֻ��������/������ӵ�ԭ��'
		//���캯��
		function User(name,age,frends,job){
			this.name = name;
			this.age = age;
			this.frends = frends;
			this.job = job;
		}
		//ԭ�͸�д
		User.prototype = {
			constructor : User,
			sayName : function(){
				console.log("����:"+this.name);
			}
		};
		var user = new User("Kevin",23,["Litch"],"����Ա");
		user.sayName();
	
	# ��̬ԭ��ģʽ
		*  �����д��붼��װ��һ��
		function User(name,age,frends,job){
			this.name = name;
			this.age = age;
			this.frends = frends;
			this.job = job;
			if(typeof this.sayName != 'function'){
				//����Ĵ���,�������ڵ�һ�δ��������ʱ��ִ��
				User.prototye.sayName = function(){
					console.log("����:"+this.name);
				}
			}
		}
		
	# ���׹��캯��ģʽ
		* durable object(���׶���),�ǳ���ȫ�Ļ�����
		* ͨ�����
			* û�й�������
			* ����ʹ�� this ����
		* ʵ���ڰ�ȫ�Ļ�����ʹ��,�������԰�ȫҪ��Ƚϸ�,���Կ���ʹ������ģʽ
		
		function User(name,age,job){
			var user = new User();
			user.name = name;
			user.age = age;
			user.job = job;
			//����˽�еı���
			var gender = '��';
			//��Ӷ���ķ���
			user.mySex = function(){
				alert(gender);		//������this
			};
			return job;
		}
	
		
	

-------------------------
�ܽ�					 |
-------------------------
	1,ԭ�Ͷ��������һ������,���ֻ�ȡ��ʽ
		* ��ʵ����ȡ,ֱ������.prototype
		* ʵ����ȡ,ͨ��Object�ľ�̬����:getPrototypeOf(); ����ȡ
	2,������(ԭ�Ͷ���)��(���캯��) constructor ������Ĺ��캯��,Ҳ�Ǹ����κ�ʵ���Ĺ��캯��(===)
	3,������(ԭ�Ͷ���) instanceof ��,��� �� false
	4,�ö���(ԭ�Ͷ���) typeof ����,����� Object
	5,ԭ�Ͷ����ж���ķ���,����,�����еĶ�����,����һ����(===)
	6,ԭ�Ͷ�����Ա�����,User.prototype = {name:'123456'}	
		* ���ǻᵼ��ԭ�Ͷ���Ĺ��캯����仯Ϊ: function Object() { [native code] }
		* �����ֶ����������ù��캯��
			User.prototype = {
				constructor : User		//��ö��
			}
		* ʹ�� Object.defineProperty();���������ù��캯��,����ʹ�䲻�ܱ�ö��
			Object.defineProperty(User.prototype,'constructor',{
				enumerable:false,
				value:User
			}); 
			
	7,ʵ������,�Ḳ��ԭ�Ͷ����е�ͬ������(��д)
		* ʵ������,����ͨ��  ����.���� �޸Ĵ�ԭ�Ͷ���̳е�ֵ
	8,ʹ�� in �� hasOwnProperty(); ���ж������Ƿ�������ԭ�Ͷ���
	9,ԭ�Ͷ���Ķ�̬��
		* ��ͨԭ��-ʵ���Ĵ�������νǰ��
		* ��дԭ��-ʵ���Ĵ���������ԭ�Ͷ��󱻸�д��
		
	10,ԭ�ͼ̳�
		* �����ԭ�Ͷ���,���ڸ����ʵ��
		* ��ô����ʵ�������˸�������з���������,��������ԭ�͵ķ���������




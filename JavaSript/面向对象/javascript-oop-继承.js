-------------------------------
JavaScript-�̳�					|
-------------------------------
	# ����Ȼ,���Ǹ߼����Բ��е�����
	# JSʵ�ּ̳еķ���
		* ԭ�ͼ̳�(��ԭ�ͱʼ�)
		* ����̳�
		* ��ϼ̳�

	

	
	# ԭ�ͼ̳�
		* ��ԭ�ͱʼ�
		* ���Լ̳и���ķ�������,�Լ�����ԭ�͵ķ�������
		* ���ּ̳з�ʽ,����������ʵ�������ʱ���ʼ���Ӹ���̳е�����


	# ��̳�,�����̳�ģ��,���̳�ԭ��
		* ���ַ�ʽ,���ܼ̳и���ԭ���е����Ժͷ���
		* ����������ʵ�������ʱ��ʼ���Ӹ���̳еĲ���

		function Persion(name ,age){
			this.name = name;
			this.age = age;
		}
		function Boy(name,age,sex){
			/*
			 * ִ�и��ຯ��,���ڵ�ǰ����
			 * ����,��ʵ���Ǹ�����,����Ĺؼ���,���Ǹ�������ʹ����this
			 * ʹ�� call �ı���this��ָ��,ִ����,�����������ĸ�ֵ
			 */
			Persion.call(this,name,age);
			this.sex = sex;
		}


		var boy1 = new Boy("������",23,"��");
		var boy2 = new Boy("Ф�ĺ�",24,"��");
	
	# ��ϼ̳�
		* ԭ�ͼ̳� + ��̳� = ��ϼ̳�
		* ���Լ̳и���ķ�������,�Լ�����ԭ�͵ķ�������
		* ����������ʵ�������ʱ��ʼ���Ӹ���̳еĲ���

		* ȱ��:��̳�2�θ����ģ��,�̳�һ�θ���ԭ��
			��̳д���̳�һ�θ���ģ��
			����ԭ�͸�д��,��̳�һ�θ���ģ��
			����ԭ�͸�д��,��̳�һ�θ���ԭ��

			//����
			function Persion(name ,age){
				this.name = name;
				this.age = age;
			}
			//����ԭ����Ӻ���
			Persion.prototype.sayName = function(){
				alert(this.name);
			}
			//����
			function Boy(name,age,sex){
				//ʹ����̳� - ���þ��Ǽ̳и����(����)ģ��
				Persion.call(this,name,age);
				this.sex = sex;
			}
			/*
				ʹ��ԭ�ͼ̳� - ���þ��Ǽ̳и����ԭ�Ͷ���
			*/
			Boy.prototype = new Persion();
			//Boy.prototype = Persion.prototype;

			var boy = new Boy("������",23,"��");
			boy.sayName();
			console.log(boy);


-------------------------------
JavaScript-ģ��Ext�ײ�ļ̳�	|
-------------------------------
	# �����ϼ̳е����μ̳�����
	//���常��
	function Persion(name,age){
		this.name = name;
		this.age = age;
	}

	//���常��ԭ�ͷ��� sayHello
	Persion.prototype = {
		sayHello : function(){
			console.log("Hello");
		}
	}

	//��������
	function Boy(name,age,sex){
		//��ȡ���б����ԭ�Ͷ���.���캯��,ִ��ģ��̳�
		Boy.superPrototype.constructor.call(this,name,age);
		this.sex = sex;
	}

	//ִ��ԭ�ͼ̳�,���̳�ģ��
	extend(Boy,Persion);

	//��������ԭ�ͷ��� sayHello
	Boy.prototype.sayHello = function(){
		console.log("Hi");
	}

	//�����������
	var boy = new Boy("������",23,"��");

	out(boy.name);					//��������

	out(boy.sex);					//��������

	Boy.superPrototype.sayHello();	//����ԭ�ͷ��� sayHello

	boy.sayHello();					//����ԭ�ͷ��� sayHello

	/**
	 * ԭ�ͼ̳�,���̳�ģ��
	 * @Param	sub ����
	 * @Param	sup	����
	 */
	function extend(sub,sup){
		//1,����պ������ڹ���  
		var F = new Function();
		//2,�Ѹ����ԭ�Ͷ���,���պ�����ԭ�Ͷ���
		F.prototype = sup.prototype;
		//3,�����ԭ��,���ڿպ�����ʵ��
		sub.prototype = new F();
		//4,�޸������ԭ�͵Ĺ�����
		sub.prototype.constructor = sub;
		//5,���游���ԭ�Ͷ������ྲ̬����,���ڽ���,��ȡ�����ԭ�Ͷ���
		sub.superPrototype = sup.prototype;
		//6,��֤����ԭ�Ͷ���Ĺ��������Ǹ��౾��
		if(sup.prototype.constructor != sup){
			sup.prototype.constructor = sup;
		}
	}

	function out(obj) {
		console.log(obj);
	}
------------------------
JS�����������			|
------------------------
	# JS��һ�Ż��ڶ��������
	# ����JS����ģ��������������Ե�����

------------------------
JS�������				|
------------------------
	# ������������,����һ����ĸ���,����ͨ����������N���������ͬ���Ժͷ����Ķ���
	# ����JS��û����
	# ���ǿ���ͨ��һЩ���ģʽ,��ģ���������
		1,����ģʽ
			function createUser(name,age,sex){
				var user = new Object();
				user.name = name;
				user.age = age;
				user.gender = sex;
				user.say = function (){
					alert(this.name + "," + this.age + "," + this.gender);
				}
				return user;
			}
			//����ͨ�����ù�������,���ݲ�ͬ��������������ͬ�Ķ���

		2,���캯��ģʽ
			//�Զ���,������������,�Ǻ����Ļ�.����������ĸΪ��д
			function User(name,age,gender){
				this.name = name;
				this.age = age;
				this.gender = gender;
				this.say = function(){
					alert(this.name + "," + this.age + "," + this.gender);
				}
			}
			* ������ʽһ,ֱ�� new
				var user1 = new User("K",23,"��");
				var user2 = new User("v",22,"Ů");
			
			* ������ʽ��
				* ����һ���������������ȥ�����෽��
				var o = new Object();
				User.call(o,"V",23,"��");
				console.log(o);

		3,��̬ԭ��ģʽ
		4,��������ģʽ
		5,���׹�ģʽ
	
	# ʹ�� instanceof �ؼ����ж϶����Ƿ�����'���ʵ��'
		user instanceof  User
		* �κζ����� Object,�����κζ��� instanceof Object ���� true
	

	
----------------------------
django-model				|
----------------------------
	* �ο�URL
		http://www.jianshu.com/p/c10be59aad7a

	* Django �Ը������ݿ��ṩ�˺ܺõ�֧��
		PostgreSQL
		MySQL
		SQLite
		Oracle��
	* Django Ϊ��Щ���ݿ��ṩ��ͳһ�ĵ���API,���Ը����Լ�ҵ������ѡ��ͬ�����ݿ�
	* Django�涨,���Ҫʹ��ģ��,����Ҫ����һ��app(python manage.py startapp [app])


----------------------------
django-model�Ĵ���			|
----------------------------
	* ��django�� settings.py �ű��� INSTALLED_APPS ������,���ַ�����ʽ��ӵ�ǰapp������
	* ��appĿ¼�´��� models.py
	* ��models.py�ű��д���modelʵ������
	* ͨ�������������ݿ�
		python manage.py makemigrations
			* ����ͬ�����ݿ�Ľű�
			* ��Ҫ��װ:pip install mysqlclient
	
		python manage.py migrate
			* ͬ�����ݿ�
	
----------------------------
django-modelʵ���򵥶���	|
----------------------------
	from django.db import models

	models.CharField()

	class User(models.Model):	# ����̳�models.Model
		# varchar
		name=models.CharField(max_length=15)
		# int,����Ϊ��
		age=models.IntegerField(max_length=100,null=True)
	
	* ��Ҫע��Model�����Բ�Ҫʹ����API���ͻ���ֶ�������clean,save��delete
	

----------------------------
django - FieldTypes			|
----------------------------
	* �ֶ�
	* ���Ƕ��̳���:django.db.models.fields.Field
	* �����Զ�����ȥ��д��Щ�ֶ���Ϣ
	CharField
	IntegerField
	BooleanField
		* tinyint(1)
	AutoField
	DateField

------------------------------
django-	FieldType Options	  |
------------------------------
	* �ֶ�ͨ�õ�����
	null
		* ���Ϊ True ,Django �����ݿ��лὫ��ֵ(empty)�洢Ϊ NULL ,Ĭ��Ϊ False 

	blank
		* ���ֶ��Ƿ����Ϊ��,Ĭ��Ϊ False (������Ϊ��)
		* ����null�����ݿ�ķ�Χ,��blank��������֤
		* ���һ���ֶε� blank=True ,Django �ڽ��б�������֤ʱ,��������ֶ��ǿ�ֵ,����ֶε� blank=False ,���ֶξ��Ǳ����
	
	choices
		* ����һ���ɵ����Ķ�Ԫ��(����,�б����Ԫ��)
		* �������ֶ��ṩѡ����,��������� choices, Django����ʾѡ���,�����Ǳ�׼���ı���
		* �������ѡ����ѡ����� choices �е�Ԫ��
		* demo
			SHIRT_SIZES = (
				('S', 'Small'),
				('M', 'Medium'),
				('L', 'Large'),
			)
			shirt_size = models.CharField(max_length=1, choices=SHIRT_SIZES)
			p = Person(name="Fred Flintstone", shirt_size="L")
			p.save()

			p.shirt_size				# L
			p.get_shirt_size_display()	# Large

	primary_key
		* ���ֶ��Ƿ�Ϊpk,���������Ϊ True,��ϵͳ����Ĭ�ϵĴ���id�ֶ�,Ĭ��Ϊ False
		* Ĭ�ϻᴴ��:id = models.AutoField(primary_key=True)
	
	db_index
		* ���ֶ��Ƿ�������,Ĭ��Ϊ False
	
	default
		* Ĭ��ֵ,������һ�������ֵҲ������һ������,ÿ�ε��ôλᴴ��һ���µĶ���
	
	help_text
		* ���ӵİ�����Ϣ,��ʹ�ñ�ʱ����ʾ���ֶ�����
		* ��ʹ��ʹ�ñ�Ҳ�������������ĵ�������
	
	unique
		* ���Ϊ True ,��ô�ֶ�ֵ�ͱ�����ȫ��Ψһ��
	
	verbose field names
		* ��ϸ����
		* ÿ���ֶε�����,����ForeignKey, ManyToManyField �� OneToOneField�ⶼ�߱�(������ר�ŵĹؼ�������������:verbose_name)
		* λ�ڵ�һλ�ò���,����������ڱ���ֶε���ϸ����
		* ���Verbose field namesû����ʾ�ĸ���,Django���Զ�������һ�ֶ����Խ��ֶ����е�"_"ת���ɿո�
			first_name = models.CharField("person's first name", max_length=30)	--> person's first name
			first_name = models.CharField(max_length=30)						--> first name

	


------------------------------
django-	dbԪ��Ϣ:Meta			|
------------------------------
	* �����Լ�������������/�����Ƶ���Ϣ
	* ֱ����Model���涨����һ�� class:Meta
		class UserRole(models.Model):
			user=models.ForeignKey("User")
			role=models.ForeignKey("Role")

			class Meta:
				db_table = 'root_role_user'         # ������
				unique_together = ("role", "user")  # ָ���ĸ�����������ΨһԼ��

	* Ҳ���Լ̳�ָ����Ԫ��
			class Meta(BaseModel.Meta):
				db_table = 'root_role_user'         
				unique_together = ("role", "user") 
		
		* ��model���ܷ��ʵ���model��Meta,Ȼ��Ҳ�������������,��model��Ӹ�model�м̳�һЩ��Ϊ
		* ������modelû��ָ�� ordering �� get_latest_by����,��ô�ͻ�Ӹ�model�м̳�
	
	* Meta������
		ordering
			* ����

		db_table
			* �ַ�������,�ֶ���ָ�����ݱ������

		unique_together
			* ��������Ψһ����,������ֵӦ����һ������
		
		abstract
			* Ĭ��Ϊ False,��ʾ��ǰ���Ƿ��ǳ����
			* ����ǳ�����򲻻ᴴ����,��������ý����ǳ�ȡ���˹������ֶ�,��������̳�
		
		proxy 
			* ��ǰ��,�Ƿ��Ǵ�����,����model����̳�һ���ǳ���model
			* ����,��ΪPerson model���һ��������
				from django.db import models
				class Person(models.Model):
					first_name = models.CharField(max_length=30)
					last_name = models.CharField(max_length=30)

				class MyPerson(Person):
					class Meta:
						proxy = True

					def do_something(self):
						# ...
						pass
				* MyPerson����ཫ�����ڸ���Person����Ӧ����ʵ���ݱ�,��ͨ��MyPerson����������Ӧ�Ĳ���
				* MyPerson����ѯPerson����ʱ,���ص�QuerySet��Ȼ����Person�������͵ļ���
				* ʹ�ô���ģʽ��model������ԭʼmodel��,��ԭʼmodel����չ,���������������model

			* Ҳ����ʹ�ô���ģʽ������model�Ĳ�ͬĬ������
				class OrderedPerson(Person):
					class Meta:
						ordering = ["last_name"]# ʹ��ԭʼmodel��ѯʱ����������,��ʹ��OrderedPerson���в�ѯʱ����last_name��������
						proxy = True
		
			
------------------------------
django - ���һ ForeignKey		|
------------------------------



------------------------------
django - ��Զ� ManyToManyField	|
------------------------------


------------------------------
django - һ��һ ManyToManyField	|
------------------------------

------------------------------
django - Model����				|
------------------------------
	objects
		* ����model����Ҫ��Manager����,ͨ������ѯ���ݿⲢ��model֮���γ�ӳ��
		* ���û���Զ���manager,Ĭ������Ϊobjects
		* managersֻ��ͨ��model��,������ͨ��model��ʵ��������
		* ���Է���
			create()
				* ����һ����¼,����Ϊdict,��ʾdb���ֶ� & ֵ

------------------------------
django - Model����				|
------------------------------
	* modelʵ���̳���models.Model,���Զ��߱������ķ���
	* ���Զ����ǽ��и�д
	save()
		* ����
		* ��д��ʱ��,��Ҫ�ر�ע���Ҫ�ǵõ��ø���ķ���--super(Blog, self).save(args, *kwargs)
		* ��ȷ��������Ȼ�����浽���ݿ���,��������ǵ��ø���ķ���,Ĭ�ϵ���Ϊ���ᷢ��,���ݿ�Ҳ���ᷢ���ı�

	delete()
		* ɾ��
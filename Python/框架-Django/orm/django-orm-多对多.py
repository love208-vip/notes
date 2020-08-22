---------------------------
��Զ�-Model����			|
---------------------------
	# ����
	class Country(models.Model):
		name = models.CharField(max_length=15)


	# �û�
	class User(models.Model):
		name=models.CharField(max_length=15)
		country=models.ForeignKey("Country")          # һ�Զ��ϵ,һ���û�ֻ������һ������,һ�����ҿ����ж���û�(ForeignKey,д�ڶ��һ��)
		#roles=models.ManyToManyField("Role")          # ��Զ��ϵ,һ���û������ж����ɫ,һ����ɫҲ�����ж���û�


	# ��ɫ
	class Role(models.Model):
		name=models.CharField(max_length=15)
		users=models.ManyToManyField("User")          # ��Զ��ϵ,һ����ɫ�����ж���û�,һ���û�Ҳ�����ж����ɫ

	# ���֤
	class Card(models.Model):
		num=models.IntegerField(null=False)
		user=models.OneToOneField("User")             # һ��һ��ϵ,һ����Ƭֻ�ܶ�Ӧһ���û�,һ���û�ֻ����һ����Ƭ(OneToOneField,д���ķ�,��������ķ�)

---------------------------
��Զ�-ManyToManyField		|
---------------------------
	* ���˫���������˶�Զ���ֶ���ô�ͻ�����2���м��,��TM����(�û�����߱��ֶ�:roles=models.ManyToManyField("Role"))
		`root_user_roles`	# �û�������ɫ
			`id` 
			`user_id`
			`role_id` 
		
		`root_role_users`	# ��ɫ�����û�
			`id` 
			`role_id`
			`user_id`

	* �м������Լ���ID�ֶ�,��Զ��ֶ��������ĸ�����,������ƾͻ��Ըö�����������
		`root_role_users`	# ��ɫ�����û�
			`id` 
			`role_id`
			`user_id` 

	ManyToManyField(to, related_name=None, related_query_name=None,
					 limit_choices_to=None, symmetrical=None, through=None,
					 through_fields=None, db_constraint=True, db_table=None,
					 swappable=True, **kwargs)
		* ��Զ��ϵ,���ֶλ������˫��
		* �������
			to
				* '�������'
				* ��Զ����һ��
				* django�����м������Ӷ�Ӧ��ID�ֶ�
		
		* �ؼ��ֲ������
			related_name
			related_query_name
			limit_choices_to
			symmetrical
				* ��ʹ���м�ģ��������һ�����Լ��Ķ�Զ��ϵ��ģ��ʱ,�����ʹ��symmetrical=False

			through
				* ����ͨ��django�������м��,��ô����ͨ����������ָ��һ��'�м����'
				* ���м������Ǿ߱�������һ�Զ��ϵ�Ķ���

			through_fields
				* ����м�������������ϵ��������
				* ����Ҫ����through_fields,��������У�����
				
			db_constraint
			db_table
				* �����ֶ���ָ���м�������

			swappable


---------------------------
��Զ�-create				|
---------------------------
	* ��˫������һ����
	* ˫����Զ������ֵӦ����һ������,��Ϊ���ܻ��ж��
	* ��Զ��еĲ���,����Ҫʹ�� oop �ķ�ʽ
	* ʵ���������߱�IDֵ
	
		role = Role(1)
		role.users.add(User(1,'KevinBlandy'))
		#role.users.remove(User(1,'KevinBlandy'))	�Ƴ�
		role.save()
		
		* ��Զ������ֶ�����,�����Ͼ���һ������,ֱ�ӿ����ü��ϵ�api���в���

	
	* �����뷴��
		* ���м���ǽ����� django �����ʱ��,����ָ����
			
		# �û�
		class User(models.Model):
			name=models.CharField(max_length=15)

		# ��ɫ
		class Role(models.Model):
			name=models.CharField(max_length=15)
			users=models.ManyToManyField("User")          # ��Զ��ϵ,һ����ɫ�����ж���û�,һ���û�Ҳ�����ж����ɫ

		# ����--------------------------------------(��ν������,��ʵ���Ǵ� ManyToManyField ���ڵĶ���ȥ������һ�Ѷ���)
			# ��ȡid=1�Ľ�ɫ��Ϣ
			role = Role.objects.filter(id=1)[0]
			# ��ȡid > 1�������û���Ϣ
			users = User.objects.filter(id__gt=1)
			# �������û���ӵ���ɫ�е��û��б�
			role.users.add(*users)
			role.save()

		# ����-------------------------------------(��ν������,��ʵ������û�� ManyToManyField �Ķ����������һ�����صĹ�������,����ͨ����������������Զ���������� )
			# ��ȡid=1���û���Ϣ
			user = User.objects.filter(id=1)[0]
			# ��ȡid > 1�����н�ɫ��Ϣ
			roles = Role.objects.filter(id__gt=1)
			# �����еĽ�ɫ,��ӵ��û��еĽ�ɫ�б�
			'''
				Userû�� role �������,����Ϊ��Զ�Ĺ�ϵ,�Զ����ɵ�
				���ݶ�Զ����һ��������(Role),Сд�� _set
			'''
			user.role_set.add(*roles)
			user.save()
---------------------------
��Զ�-delete				|
---------------------------
	* ��Զ��е�ɾ��,Ĭ���Ǽ���ɾ��
		User.objects.filter(id=1).delete()
		* ɾ��id=1���û�,�ἶ����ɾ������Զ������������user_i=1�ļ�¼
	

	



---------------------------
��Զ�-�ֶ�������Զ�		|
---------------------------
	* ��ʵ��������,����ֻ��ͨ��һ���м�Ĺ�������(��һ�Զ�����),������˶�Զ��ӳ��
		# �û�
		class User(models.Model):
			name=models.CharField(max_length=15)

		# ��ɫ
		class Role(models.Model):
			name=models.CharField(max_length=15)
		
		# ��������
		class UserRole(models.Model):
			user=models.ForeignKey("User")		# һ�Զ�Ĺ����û�
			role=models.ForeignKey("Role")		# һ�Զ�Ĺ�����ɫ
			
	
	* ���ַ�ʽ,�Ϳ���ʹ�÷�OOP�ķ�ʽ������/�޸Ķ�Զ��ӳ���ϵ(����һ�Զ�ʼ�)
	* ���ַ�ʽ��������ManyToManyField�ֶ�
	* ������Ҫͨ������ManyToManyField�ֶεķ�ʽ��ʵ��,��ô���ֶ���һ������ֵ(through),���������м�����
		class Role(models.Model):
			name=models.CharField(max_length=15)
			users=models.ManyToManyField("User",through="UserRole") 
	

---------------------------
һ�Զ�-Model����			|
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
һ�Զ�-ForeignKey			|
---------------------------
	models.ForeignKey(to, on_delete=None, related_name=None, related_query_name=None,
						 limit_choices_to=None, parent_link=False, to_field=None,
						 db_constraint=True, **kwargs)
		* ����һ�Զ��ϵ,���ֶ����ڶ��һ��
		* �������
			to
				* '�������'
				* һ��һ��Class�����
				* django��Ĭ�ϵĸ����ֶμ����»���id(country=models.ForeignKey(Country) ==> country_id)


		* �ؼ��ֲ������
			on_delete
			related_name
			related_query_name
			limit_choices_to
			parent_link
			to_field
				* ָ����ǰ�ֶ�(���),�Ƕ෽���е��ĸ��ֶ�(����),Ĭ��Ϊpk

			db_constraint


---------------------------
һ�Զ�-create				|
---------------------------
	* ����Ȼ,�ڲ���ʱ����Ҫע��Ľ����Ƕ��һ��
	1,ֱ�Ӳ���IDֵ
		Model.objects.create()
			* ����Ϊdb���ֶ����� & value
			* Model.objects.create(name='KevinBlandy',age=23,country_id=1)
	
		model = Model('KevinBlandy',23,1)
		model.save()
			* Ҳ����ֱ�ӳ�ʼ����ʱ��,������ֶν���ֵ�ĳ�ʼ��
			* ����modelʵ������,ֱ�ӵ���ʵ����save()����
		
		* ����ֶ�,ֱ������Ϊһ��һ����IDֵ����,ע��,���������Ĺؼ��ֲ�������'������db���ֶ���,���Ƕ����������'(country_id)
	
	2,oop�ķ�ʽ
		Model.objects.create()
			* ����Ϊʵ�����Եļ�ֵ��
			* Model.objects.create(name='KevinBlandy',age=23,country=Country(1,'China'))
	
		model = Model('KevinBlandy',23,Country(1,'China'))
		model.save()
			* Ҳ����ֱ�ӳ�ʼ����ʱ��,������ֶν���ֵ�ĳ�ʼ��
			* ����modelʵ������,ֱ�ӵ���ʵ����save()����
		
		* ʵ���������߱�IDֵ
		* ����ֶ�,����Ϊ���һ���Ķ���ʵ��,ע��,���������Ĺؼ��ֲ�������'�Ƕ��������������,��db�ֶ�����'(Country)
			
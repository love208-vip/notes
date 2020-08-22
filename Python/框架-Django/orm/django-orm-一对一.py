---------------------------
һ��һ-Model����			|
---------------------------
	# ����
	class Country(models.Model):
		name = models.CharField(max_length=15)


	# �û�
	class User(models.Model):
		name=models.CharField(max_length=15)
		country=models.ForeignKey("Country")          # һ�Զ��ϵ,һ���û�ֻ������һ������,һ�����ҿ����ж���û�(ForeignKey,д�ڶ��һ��)
		#roles=models.ManyToManyField("Role")         # ��Զ��ϵ,һ���û������ж����ɫ,һ����ɫҲ�����ж���û�


	# ��ɫ
	class Role(models.Model):
		name=models.CharField(max_length=15)
		users=models.ManyToManyField("User")          # ��Զ��ϵ,һ����ɫ�����ж���û�,һ���û�Ҳ�����ж����ɫ

	# ���֤
	class Card(models.Model):
		num=models.IntegerField(null=False)
		user=models.OneToOneField("User")             # һ��һ��ϵ,һ����Ƭֻ�ܶ�Ӧһ���û�,һ���û�ֻ����һ����Ƭ(OneToOneField,д���ķ�,��������ķ�)


---------------------------
һ��һ-OneToOneField		|
---------------------------
	OneToOneField(to, on_delete=None, to_field=None, **kwargs)
		* ����һ��һ�Ĺ�ϵ
		* OneToOneField ����һ��,���������һ��
		* ����
			to
				* һ��һ��Ŀ�����

		* �ؼ��ֲ���
			on_delete
			to_field

		
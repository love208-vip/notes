
------------------------
����-����				|
------------------------
	* ����(<class 'function'>)�Ľṹ
		def [��������]([�����б�]):
			[�߼�����]
			[����ֵ]
	
	* python�к������߱���������,�����ͬ��������ֱ�Ӹ�����ǰ����ĺ���

	
------------------------
����-����				|
------------------------
	1,�������
		* ִ�е��õ�ʱ��,һһ��Ӧ,���ܶ�,������
			def fun(var1,var):
				pass
		* ���õ�ʱ��,����ֱ�ӰѼ���/����/Ԫ��,ת��Ϊ��Ӧ�Ĳ���,�ڵ���ʱ,����ǰ�����'*'����
			def fun(a,b,c,d):
				print(a,b,c,d)	# 1 2 3 4
			fun(*[1,2,3,4])
				
	2,Ĭ�ϲ���
		* �߱�Ĭ��ֵ�Ĳ���,ִ��ʱ,��λ�ÿ��Դ���ֵ,���߲�����
		* 'Ĭ�ϲ���,����ʹ�ò��ɱ����'
		* �����Ͳ���,�ڱ��������
			def fun(age,name="Kevin"):
				print(name)	# kevin
				print(age)	# 23
			fun(23)
						
		
	3,�ɱ����
		* ��Java�еĿɱ����һ��
		* ���Դ���һ�����߶������ֵ
		* ����λ����Ĭ�ϲ���֮��
		* �ں������ڲ�,ʵ������һ�� Ԫ�� (tuple)
			def fun(name,*hobys):
				print(name)			# Kevin
				print(hobys)		# ('Java', 'Linux', 'Python')
				print(type(hobys))	# <class 'tuple'>

			fun("Kevin",'Java','Linux','Python')

		* ���õ�ʱ��,����ֱ�ӰѼ���/����/Ԫ��,ת��Ϊ����,�ڵ���ʱ,����ǰ�����'*'����
		* �����ڲ�������ȡ����һ�ݿ���,���� dict ����������
			def fun(name,*hobys):
				print(name)
				print(hobys)
				print(type(hobys))
			hobys = {'Java','Linux','Python'}
			fun("Kevin",*hobys)
		

	4,��������
		* �÷�ʽ�������Ʋ����ĸ���������
		* �ò���Ӧ�����ڿɱ����֮��,ʹ��'*'�ŷָ�
		* ����������������õ�˳����Բ�ͬ
		* ����ָ��Ĭ��ֵ,���δָ��,����ʱ���봫��,�����쳣
		* 'Ĭ��ֵ,����ʹ�ò��ɱ����'
			def fun(*,name,age):
				pass
			fun(name="Kevin",ag=23)
			
		* ����ò���ǰ�滹����������,ʹ��һ�� '*',�ŷָ�����
			def fun(var,*,name="Kevin",age=35):
			fun()
		
		* ����ò���ǰ��,��'�ɱ����',����Ҫʹ�� '*' �ŷָ�
			def fun(var,*hobys,name="kevin",age=35):
				pass
			fun('var',1,2,3,4,5,6,name='Litch',age=23)
			
		* ���Ѿ����ڵ� dict ��Ϊ�ؼ��ֲ�������,����ǰ�����'**'����
		* �����ڲ�������ȡ����һ�ݿ���,���� dict ����������
		* ��Ϊ������ dict �����������������β��б���ȫƥ��,dict ��ʹ���ַ�����ʾ��������
			def fun(*,hobby1,hobby2):
				print(hobby1)
				print(hobby2)
			fun(**{'hobby1':'Java','hobby2':'Python'})
		
	5,�ؼ��ֲ���
		* �ؼ��ֲ��������㴫��0������������������Ĳ���
		* ��Щ�ؼ��ֲ����ں����ڲ��Զ���װΪһ��dict,ʵ�ε�key,�����ַ�������
		* ���������ظ�,�׳��쳣
		* �����Ͳ�����������������֮��
			def fun(**info):
				print(info)			# {'name': 'Kevin', 'age': 23}
				print(type(info))	# <class 'dict'>
			fun(name='Kevin',age=23)
			
		* ���Ѿ����ڵ� dict ��Ϊ�ؼ��ֲ�������,����ǰ�����'**'����
		* �����ڲ�������ȡ����һ�ݿ���,���� dict ����������
			def fun(**info):
				print(info)
				print(type(info))
			info = {'name':'Kevin','age':23}
			fun(**info)

		* '�ؼ��ֲ�������������ͬʱ����,ִ��ʱ,����ƥ��:��������,���۴��ݵ�˳��'
			def fun(*,name,**dic):
				print(name)	# Kevin
				print(dic)	# {'dic1': '1', 'dic2': '2'}

			fun(dic1='1',name="Kevin",dic2="2")
			fun(**{'dic1':'1','name':"Kevin",'dic2':"2"})
			

	* ���������Ķ���˳��
		1,�������
		2,Ĭ�ϲ���
		3,�ɱ䳤����
		4,��������
		5,�ؼ��ֲ���

	* �������⺯����������ͨ������ fun(*args, **kw)����ʽ������,�������Ĳ�������ζ����.
	* *args�ĳ��ȴ���Ŀ�꺯���ı������,Ĭ�ϲ���,�䳤����ֻ��...����Ĳ��ֱ�ɾ��
		def fun(a,b,c,d,e='Ĭ�ϵ�',*f):
			print(a,b,c,d,e,f)  # a b c d e ('f1', 'f2', 'f3')
		fun(*['a','b','c','d','e','f1','f2','f3'])


------------------------
����-����ֵ				|
------------------------
	* ʹ�� return ���ؽ��,���û�� return ���,Ĭ�� return None
	* �������� return �ؼ��ֺ�,��������,����ִ��ʣ�µĴ���

	* ���� return ���ֵ,
	* ����ֵ��ʵ��һ�� tuple,���﷨��,����һ�� tuple ����ʡ������,�������������ͬʱ����һ��tuple,��λ�ø�����Ӧ��ֵ
		def func():
			return 1,2,3,4,6
		result = func()
		print(result)       # (1, 2, 3, 4, 6)
		print(type(result)) # <class 'tuple'>

------------------------
����-������				|
------------------------
	1,Python�������Ϊ�������(��С����)
		* L,�ֲ�������,Ҳ���Ǻ����еı���
		* E,�����ϲ㺯����������,�����ں���Ƕ��ʱ
		* G,ȫ�ֱ���,Ҳ����ģ�鼶��ı���
		* B,ϵͳ�̶�ģ������ı���
		
	2,���ں�����������
		* �������ϼ���,�ҵ�Ϊֹ,�Ҳ������׳��쳣

	3,�����ж���ȫ�ֱ���
		* ʹ�� global �ؼ���,�ں����ڲ������ı���,�ͻᱻ����Ϊȫ�ֱ���
		* ֻ�к���������,��ȫ�ֱ����Żᱻ�����ڴ�
		* global ֻ�ܽ�������,����ͬʱ��ֵ,Ҳ��˵,Ҫ������,Ȼ��ſ��Ը�ֵ,�÷���������
			def fun():
				global num 
				num = 1
			fun()
			print(num)	# 1
		
	4,�������޸�ȫ�ֱ���
		* �ֲ���������ֱ���޸�ȫ�ֱ���
		* ֱ���޸�,û���κ�Ч��
		* �ں����������ı���,ȫ���Ǿֲ�����
			num = 5
			def func():
				num = 6
			func()
			print(num)	# 5

		* ʹ�� global �ؼ����Ƚ�������
		* ʹ�� global �ؼ���������,��ʾ�ñ������þֲ�����,����ʹ��ȫ�ֵ�,�����޸�
		* ����޸ķ� global ������ͬ��ȫ�ֱ���,�����������ھֲ�����ͬ������,�����޸�ȫ��
			num = 5
			def func():
				global num
				num += 1
			func()
			print(num)	# 6
	
	5,�������޸��ⲿ��������
		* ��ʵ�����޸�Ƕ��������
		* ֱ���޸�û���κ�Ч��
			def func1():
				num = 4
				def func2():
					num = 5
				func2()
				return num
			print(func1())	# 4

		* ʹ��Python3�ṩ�Ĺؼ���:nonlocal
			def func1():
				num = 4
				def func2():
					nonlocal num
					num = 5
				func2()
				return num
			print(func1())	# 5
	
	6,�����еı���,����Ҫ������,��ʹ��
		* ��JSһ������,Ҳ��һ������������ë��
		num = 5
		def func():
			print(num)
			num = 4
			print(num)
		func()
		# UnboundLocalError: local variable 'num' referenced before assignment
		# Ӧ���Ƚ��б���������,��ȫ�ֱ���,���Ǿֲ�����: global num / num = [ֵ]
	
	7,ʹ�� global �ؼ������������ȼ�
		* ����������Ҫִ��,�Ż��ʹ�� global �����ı�����Ϊȫ�ֺ���
		def func():
			global count
			count = 'ȫ�ֱ���'

			global inner
			def inner():
				print('ȫ�ֺ���')
			
		func()
		print(count)    # ȫ�ֱ���
		inner()         # ȫ�ֺ���

------------------------
����-lambda				|
------------------------	
	1,�﷨
		* lambda ����:������
		* ��������������Ȼ��:<class 'function'>
		* �����ǿ�ѡ��

	2,ϸ��
		* lambda ��������һ�����ʽ,������һ�������,��������lambda���ʽ�з�װ���޵��߼���ȥ
		* �����岻�ܰ���ѭ��,���԰����ж�
		* lambda ����ӵ���Լ������ֿռ�,���ܷ���ȫ�ֱ���,ֻ�ܷ����β��б��е�����
		* �����岻��ʹ�� for/while/return/yield,����ʹ�������ж�
		* ������ص���Ԫ��,�ǵ�ʹ��()��
		* lambda ���ʽ�Ľ������һ����������
	
			square = lambda x : x**2
				print(square(3))		# 9

			sum = lambda x, y : x + y
				 print(sum(2, 3))		# 5

		* ���������� lambda ���ʽ
			func = lambda : True
			print(func())

------------------------
����-�հ�				|
------------------------
	* �����һ���ڲ�������,�����ⲿ������(��������ȫ��������)�ı�����������,��ô�ڲ������ͱ���Ϊ�Ǳհ�(closure).
		def funcX(x):
			def funcY(y):
				return x * y
			return funcY
	
		# ִ����㺯��,��ȡ�ڲ㺯��,�ڴ溯���Ѿ�����㺯���Ĳ�����ֵ
		tempFunc = FuncX(3)

		# ִ���ڴ溯��,���ݲ���,����㺯����ֵ���м���
		result = tempFunc(5)

		print(result)            # 15
		
		# �򵥲���
		result = FuncX(3)(5)
		print(result)           # 15

------------------------
����-�ݹ�				|
------------------------
	* д������ͺ���,���±�����Զ���ݹ�
	def func(x):
		if(x == 1):
			return 1
		return x * func(x - 1)
	print(func(5))          #120


------------------------
����-װ����				|
------------------------
	* �ڴ��������ڼ䶯̬���ӹ��ܵķ�ʽ����֮Ϊ'װ����'-Decorator
	* ��JAVA�Ķ�̬�����е���,�����õ��˱հ�
	* ����ǿ
		# ������ǿ,����������Ҫ����ǿ��Ŀ�꺯��
		def log(func):
			# ������ǿ����,ʹ������Ͳ���
			def wrapper(*args, **kw):
				# ��ǿ��..............
				print('call %s():' % func.__name__)
				 # ����ǿ�����е���Ŀ�꺯�����ҷ�����ִ�н��,ʹ������Ͳ���
				return func(*args, **kw)
			# ������ǿ����
			return wrapper


		# ��Ŀ�꺯����������ǿ����
		@log
		def now():
			print('2015-3-25')

		# ����Ŀ�꺯��,�ͻ�ִ����ǿ
		now();

	* Ҳ����ֱ��ִ����ǿ����,��õ���ǿ��ķ���
	* ��Ϊ now ����,�� @log ����,�����ٴ�ִ��,��ִ��������ǿ����
		now = log(now);
		now()
	
	* ��������ǿ
	* ��ʵ��������ͨ��ǿǰ��������һ������

		def aopText(message):
			def aop(fun):
				def wrapper(*args,**kw):
					print('��ǿ��,��ȡ��Message' + message)
					return fun(*args,**kw)
				return wrapper
			return aop


		@aopText('3333333333333333')
		def nowText():
			print('2015-3-25')

		nowText()
		
		# ��ʵ������������,�ȴ���ֵ,�ٷ��غ�����ǿ�ıհ�
		nowText = aopText('execute')(nowText)
	
	* �������ǩ��������
		* ���ص��Ǹ� wrapper()�������־���'wrapper',����,��Ҫ��ԭʼ������ __name__ �����Ը��Ƶ�wrapper()������
		* ��Ȼ,��Щ��������ǩ���Ĵ���ִ�оͻ����
		* �漰�� functools �ķ���

		import functools
		def message(message):
			def aop(func):
				@functools.wraps(func)	# �������ǩ��������
				def wapper(*args,**kw):
					print("aop=",message)
					func(*args,**kw)
				return wapper
			return aop

		@message("Hello")
		def func(name):
			print(name)

		print(func.__name__)	# func,���û��ʹ��@functools.wraps(func),��ֵΪ wapper
	
	* =================	Demos	===========================
	* ��ͨװ��
		def aop(target):
			def wapper(*args,**kws):
				print("==== װ�δ� ====")
				return target(*args,**kws)
			return wapper
		@aop
		def func(name):
			print(name)

		func("���")
		# ==== װ�δ� ====
		# ���
	
	* ����װ��
		def text(arg):
			def aop(func):
				def wapper(*args,**kws):
					print("==== װ�δ� ====")
					print("==== ����:%s===="%(arg))
					func(*args,**kws)
				return wapper
			return aop

		@text('�Ҿ��ǲ���')
		def func(name):
			print(name)
			
		func('Hello')
		# ==== װ�δ� ====
		# ==== ����:�Ҿ��ǲ���====
		# Hello

------------------------
����-ƫ����				|
------------------------
	* Python�� functools ģ���ṩ�˺ܶ����õĹ���,����һ������ƫ����(Partial function)
	* functools.partial�����þ���,��һ��������ĳЩ�������̶�ס(Ҳ��������Ĭ��ֵ),����һ���µĺ���,��������º��������
	* �������Ĳ�������̫�࣬��Ҫ��ʱ,ʹ�� functools.partial ���Դ���һ���µĺ���
	* ����º������Թ̶�סԭ�����Ĳ��ֲ���,�Ӷ��ڵ���ʱ����
	* ����ƫ����ʱ,ʵ���Ͽ��Խ��� '��������','*args'��'**kw'��3������
		import functools
		def func(*,name,age,**infos):
			print(name)
			print(age)
			print(infos)
		fun1 = functools.partial(func, name='Kevin',info1='1',info2="2",info3="3")
		fun1(age=23)
		# Kevin
		# 23
		# {'info1': '1', 'info2': '2', 'info3': '3'}
	


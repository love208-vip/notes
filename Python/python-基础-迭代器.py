------------------------
������					|
------------------------

	* ��������ɵ�������
		1,Iterator,��ʾ������
		2,Iterable,��ʾ�ɵ���

		from collections import Iterator,Iterable

		arr = [1,2,3]
		print(isinstance(arr, Iterator))# arr ���ǵ����� (False)
		print(isinstance(arr, Iterable))# arr �ǿɵ������� (True)

		it = iter(arr)
		print(isinstance(it, Iterator))# it �ǵ�����(True)
		print(isinstance(it, Iterable))# it �ǿɵ�������(False)


	* �ɵ�������
		str
		list
		set
		dict
		tuple
		���������ǵ�����(��������һ����������)
	
	* ��ȡ������
		1, �ɵ������������͵��ڲ�������һ������:__iter__(),�÷������صľ��ǵ�����
			arr = [1,2,3]
			it = arr.__iter__()
			print(type(it))#<class 'list_iterator'>
			print(next(it))#1
			print(next(it))#2
			print(next(it))#3
			print(next(it))#StopIteration

		2, Ҳ����ʹ��ȫ�ֺ���:iter(),���Ѷ�Ӧ������ת��Ϊ������(��������ǲ��ɵ�����,�׳��쳣)
			arr = [1,2,3]
			it = iter(arr)
			print(type(it))#<class 'list_iterator'>
			print(next(it))#1
			print(next(it))#2
			print(next(it))#3
			print(next(it))#StopIteration
	
	* ����������
		1,ʹ��ȫ�ֺ��� next()����������,����ȡ��һ��Ԫ��
			* �������û�и���ɵ���Ԫ��,�׳��쳣:#StopIteration
			next(it)
		
		2,ʹ�� for in ������������
			* û�и���Ԫ��,�����׳��쳣
			* for ѭ�������ɵ������ݵ�ʱ��,��ʵ�ǽ�������������
				1,��ʵ���Ȱѿɵ���Ԫ��ͨ�� iter() ����ת��Ϊ������
				2,����ʹ�� next() ȥ���õ�����,��ȡ������
				3,���� StopIteration

			arr = [1,2,3]
			it = iter(arr)
			for x in it:
				print(x)

	* �ܽ�
		1,������ for in �Ķ��ǿɵ�����(Iterable)
		2,������ next() �Ķ��ǵ�����(Iterator)
		3,�ܶ��������Ͷ��� �ɵ�����(Iterable),����ͨ��������ȡ������(Iterator)	
			* __iter__()
			* iter()
		
			

	
------------------------
shelve					|
------------------------
	* pickle �ĸ߼���
	* ����Ϊ�������л����ֵ�,���Ҿ߱��ֵ�(dict)�Ĵ����API
	* ֻ��һ������
		shelve.DbfilenameShelf open(filename, flag, protocol, writeback)

	* shelve.DbfilenameShelf
		* һ���������ֵ����������
		* keyֻ�����ַ���(str)
		* value,�ǿ���Python��������������
	
	* demo
		# ��/�����ļ�
		var = shelve.open("E:\\shelve")
		
		# д������
		var['func'] = out
		var['dic'] = {'name':'Kevin','age':23}
		var['list'] = ['1','2','3']
		
		# ��ȡ����
		var['func']
		var.get('func')

		# ɾ������
		del var['func']

		# ��������
			 ������������
		for k,v in var.items():
			pass

------------------------
shelve-ģ������			|
------------------------

------------------------
shelve-ģ�麯��			|
------------------------
	shelve.DbfilenameShelf open(filename, flag, protocol, writeback)
		* �ļ�������,�ᴴ������������׺�����ļ�
			1,dat
			2,bak
			3,dir

			
------------------------
shelve-shelve.DbfilenameShelf|
------------------------
	close()
		* �ر���Դ

	get()

	clear()
		
	items()

	pop()

	popitem()

	sync()

	update()

	obj get(keys)
		* ����key��ȡֵ

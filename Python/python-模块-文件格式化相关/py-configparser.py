------------------------
configparser			|
------------------------
	* ���������ļ���ģ��
	* �е��� Java �е�, Properties<T>
	* �����ļ���ģʽ
		# ע����Ϣ
		[DEFAULT]
			key=value

		[ģ������]
		key=value

		[ģ������]
		key=value
		
		* 'DEFAULT' ��һ���ؼ�,�����ģ��,��ר�ŵ�API����
		* 'DEFAULT' ����ȫ����д,һ�ֲ���
		* 'DEFAULT' �ж��������,��������ģ��,�������,��Ȼ,���Ա�������ģ�鸲д

	* ConfigParser�Ľṹ
		# �е����Ǵ��ֵ�,Ƕ��С�ֵ�
		config['DEFAULT'] = {'name':'Kevin','age':23,'job':'Java'}
		config['kevin'] = {'name':'Kevin','age':23,'job':'Java'}
		config['licth'] = {'name':'Litch','age':24,'job':'Python'}
	
	* ����ʹ���ֵ���һ�ײ���������ConfigParser
		1,ʹ�� int �ж��Ƿ����
		2,���ʻ����޸�ʹ��[]
	
	* ����
		for x in config:
			print(x)# xΪcinfig�е�ģ������
			for y in config[x]:# y Ϊÿ��ģ���е� key
				print(y,config[x][y])
		

------------------------
configparser-��������	|
------------------------

------------------------
configparser-ģ�麯��	|
------------------------
	configparser.ConfigParser ConfigParser()
		* ��ȡһ�� ConfigParser ʵ������

------------------------
configparser.ConfigParser|
------------------------
	list read(file)
		* ����ָ���������ļ�
		* ���� list,Ҳ���Ǽ��ص��ļ��б�

	write(file)
		* ��������Ϣд��ָ�����ļ�
		* ������Ŀ���ļ�(����ʹ��open()��������):<class '_io.TextIOWrapper'>
		* demo
			[kevin]
			name = Kevin
			age = 23
			job = Java

			[licth]
			name = Litch
			age = 24
			job = Python
	
	list sections()
		* ��ȡ�����г��� 'DEFAULT' ģ������е�ģ������

	bool remove_section()
		* ɾ��ָ����ģ��
		* ɾ���ɹ�,���� True
		* ģ�����Ʋ�����,���� False
	
	bool remove_option(section,key)
		* ɾ��ָ��ģ���µ�ָ��key
		* ɾ���ɹ�,���� True
		* ģ�鲻����,�׳��쳣,key������,���� False
	
	bool has_section(section)
		* �ж��Ƿ���ָ�����Ƶ�ģ��

	bool has_option(section,key)
		* �ж��Ƿ���ָ��ģ��,�Լ���ģ�����Ƿ���ָ����key

	None set(section,key,value)
		* ��section����ӻ����޸� key & value
		* ��� section ������,�׳��쳣

	collections.OrderedDict defaults()
		* ���� 'DEFAULT' Ĭ��ģ�������,��һ�������ֵ�
		* demo
			[DEFAULT]
			name = default

			OrderedDict([('name', 'default')])


	

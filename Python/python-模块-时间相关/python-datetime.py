-----------------------
datetime				|
-----------------------
	* ������ʱ��
	* ǿ��֮��,���Զ�ʱ�����һЩ����
	* ���Խ���һЩʱ��� + - ����
		datetime.datetime.now() + datetime.timedelta(3)
			# ��ǰʱ���ȥ����3��,���Ϊ����,���Ǽ�ȥ3��
		
		datetime.datetime.now() + datetime.timedelta(hours=-15)
			# ��ǰʱ���ȥ15��Сʱ


----------------------
datetime-ģ�麯��		|
----------------------
	
	datetime.datetime datetime.datetime(y,m,d)
		* �Զ���ʱ�䴴��ʵ������
		* demo
			diy = datetime.datetime(2015, 4, 19, 12, 20)	# 2015-04-19 12:20:00

	datetime.datetime datetime.datetime.now()
		* ���ص�ǰʱ��,��ȷ������
		* �÷���ֵ,���Ժ�ָ���Ķ������ +  ����
		* demo
			var = datetime.datetime.now() # 2017-06-08 22:05:55.195936
		
	datetime.date datetime.date.fromtimestamp(timestamp)
		* ��ָ��ʱ������и�ʽ��,���� datetime.date  ����
		* Demo
			var = datetime.date.fromtimestamp(time.time()) # 2017-07-01
	
	datetime.datetime datetime.datetime.strptime(str,parten)
		* ���Ը��� parten ����ʽ��ʱ�� str
		* demo
			diy = datetime.datetime.strptime('2015-6-1 18:19:59', '%Y-%m-%d %H:%M:%S')

	datetime.timedelta datetime.timedelta(num)
		* ����һ�� ����,�ö�����Ը� datetime.datetime ʵ������ +  ����
		* ��һ������,��ʾҪ���/��ȥ����
		* �ؼ��ֲ���
			hours
				* ָ��Ҫ�Ӽ���Сʱ
			minutes
				* ָ��Ҫ�Ӽ��ķ���
	

----------------------
datetime-datetime		|
----------------------
	int timestamp()
		* �� datetime ת��Ϊʱ���

	tuple timetuple()
		* �� datetime ת��Ϊ�ṹ��ʱ��
	
	str strftime(str)
		* �� datetime,ת��Ϊstr��ʽ��ʱ���ַ���
		* demo
			datetime.datetime.now().strftime('%a, %b %d %H:%M') # Fri, Jul 14 09:44
	


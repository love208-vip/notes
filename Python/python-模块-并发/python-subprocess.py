----------------------------
subprocess					|
----------------------------
	* �����ӽ���,����ִ��ϵͳ����
	* �����ӽ��̹���

----------------------------
subprocess-����				|
----------------------------
	PIPE

----------------------------
subprocess-����				|
----------------------------
	Popen()
		* ����һ���ӽ���,ִ��һ��shell����,����һ�� Popen ����
		* ��������������,��һ��Ԫ��������,ʣ�µ������������
			Popen(["mkdir","t1"])
		* ����Ҳ����ֱ�Ӿ���һ������
			Popen("mkdir t2", shell=True)
		* �ؼ��ֲ���
			shell
				* bool ֵ
			stdout	
				* ö��ֵ,ָ������ִ�к�������ݵĹܵ�
				* subprocess.PIPE		:���ӽ���ת��������

	str getoutput(commond)
		* ִ��SHELL����,����ִ�к�Ľ��

	tuple getstatusoutput(commond)
		* ִ��shell����,����Ԫ��,��һ��������״̬intֵ,�ڶ���������ִ�к�Ľ��

----------------------------
subprocess.Popen			|
----------------------------
	* ʵ������
		stdout.read()
			* ��ȡִ�н��,���صĽ�����ֽ���������
			* ���������ַ���,��ʾ��������,����Ĭ��ʹ��ϵͳ����
	* demo
		import subprocess
		popen = subprocess.Popen('dir',shell=True,stdout=subprocess.PIPE)
		# stdout=subprocess.PIPE ����ӽ���ִ�еĽ������,���ݸ�������.���ո�ֵ��ִ�к�Ķ���.���û�иò���,��ֱ�Ӵ�ӡ,�����ض����ܶ�ȡ��ִ�н��
		result = popen.stdout.read()
		print(str(result,'GBK'))
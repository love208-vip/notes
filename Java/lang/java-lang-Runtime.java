-----------------------------
java.lang.Runtime			 |
-----------------------------
	# û�й��캯�������ܱ�ʵ������
	# ����ʵ��һ����������һ����̬���������Ի�ȡ���Ķ���
	# �÷����� Runtime runtime = Runtime.getRuntime(); 
	# Runtime 

		Process exec("CMD/shell����");
			* ����ִ��һ�ε�ǰ����ϵͳ�����

		long maxMemory() 
			* ���� Java �������ͼʹ�õ�����ڴ�����

		long totalMemory() 
			* ���� Java ������е��ڴ������� 
		
		int availableProcessors();
			* ���ص�������������õĴ���������,����С��һ��
	
	# Process
		void prop.destroy();
			* ɱ�����̡�(ֻ��Ū���������ĳ���)

		InputStream prop.getInputStream();
			* ���Ի�ȡ��cmd��һ��������,ִ����cmd��������Զ�ȡ��cmd��ʾ����������

		InputStream getErrorStream() 
			*  ��ȡ�ӽ��̵Ĵ�������
			
		InputStream getInputStream()  
			* ��ȡд����

		int exitValue();
			* �� Process �����ʾ���ӽ��̵ĳ���ֵ�����ݹ�����ֵ 0 ��ʾ������ֹ�� 

		int waitFor();
			* �����̻߳�һֱ����,ֱ�� Process �����ʾ�Ľ����Ѿ���
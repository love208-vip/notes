----------------------------------
Process								|
----------------------------------
	# Process,Ӧ���Ǵ���ϵͳ����
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
-------------------
Nginx-Gzipѹ��		|
-------------------
	# ������վ������
	# gzip�ǳ�����һ��ѹ���㷨,�Ǵ󲿷��������֧�ֵ��㷨
		* ��HTTP����ͷ�п��Կ��������֧�ֵľ���ѹ���㷨
	# �Ƚ�С���ļ���Ҫѹ��,�ر��Ƕ����ƾ͸�����ѹ����	
	# ������location

-------------------
Nginx-����ѹ��		|
-------------------
	# GZIP���ó��ò���
		gzip			on
			* ����ѹ��
		gzip_buffers	32 4k
			* ����,һ����໺��32��,ÿ���4K
		gzip_comp_level[1-9]
			* ѹ������,�Ƽ�6.�ü�����������Դ���ĳ�����
		gzip_disable [����]
			* ͨ������ƥ���URI������ѹ������
		gzip_min_length	1000;
			* ѹ����С���,��λ���ֽ�
		gzip_proxied	expired no-cache no-store private auth;
			* Ӧ��д��ʱ����������ص�ʱ��һЩ����
		gzip_types		text/plain application/xml;
			* ѹ���ļ�������
		gzip_vary on
			* �Ƿ���Ӧ�ͻ���GZIPѹ����ʶ
	

	# �������������
		# ����GZIPѹ��
		gzip on;
		# ���û���.32���,û���4K
		gzip_buffes 32 4k;
		# ����ѹ������,�Ƽ�6
		gzip_comp_level 6;
		# ��Сѹ�����
		gzip_min_length 200;
		# ��Ҫ��ѹ��������(Nginx�߰汾�ᱨ��)
		gzip_type text/css text/xml text/html application/x-javascript;

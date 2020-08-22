------------------------
Nginx-include			|
------------------------
	# �����õĲ��������,���԰���Щ���ö��Լ�ֵ�Ե���ʽ����������
	# Ȼ������Ҫ�ĵط�ͨ��include�������
	

------------------------
Nginx-demo				|
------------------------
	1,��nginx/conf���½�һ���ļ�:proxy.conf

	2,�ڸ��ļ������ô������
		proxy_next_upstream http_502 http_504 error timeout invalid_header;
		proxy_set_header Host $host;
		proxy_set_header X-Forwarded-For $remote_addr;
		proxy_set_header X-Real-IP $remote_addr;
		proxy_connect_timeout 90;
		proxy_send_timeout 90;
		proxy_read_timeout 90;
		proxy_buffer_size 4k;
		proxy_buffers 4 32k;
		proxy_busy_bufers_size 64k;
		proxy_temp_file_write_size 64k;

	3,��location������
		location / {
			...
			include proxy.conf;
		}
		
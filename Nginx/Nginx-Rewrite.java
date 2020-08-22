-----------------------
Nginx-Rewrite			|
-----------------------
	# rewrite
	# ����Ǵ�˵�еĵ�ַ��д
	# ϵͳ����Ͷ�����N��ı���,����ֱ��ʹ��
		conf/fastcgi.conf

	# ���Գ��ֵĵط�
	# ���ѭ���ض���,��������쳣
		* location
		* server
	
-----------------------
Nginx-��д�л�������ָ��|
-----------------------
	if (����){
		...
	}
			* if �ж�
	set $flag '1';
			* ���ñ���
	return 500;
			* ����״̬��
	break;
			* ����rewrite,��������ƥ����ɺ�,��ֹƥ��,����ƥ�����Ĺ���
	rewrite #��д
			* ... ...��д��
	
-----------------------
Nginx-if				|
-----------------------
	# �﷨
		if (����){
			//ִ����д
		}
		* 'ǧ��Ҫע��,if�����и��ո�'
	
	# ����
		~
			��ʾ���ִ�Сд��ĸƥ��
		!~
			��¥���෴
		~*
			��ʾ�����ִ�Сд��ĸƥ��
		!~*
			��¥���෴
		-f	!-f
			�ļ��Ƿ����
		-d	!-d
			Ŀ¼�Ƿ����
		-e	!-e
			�ж��ļ�����Ŀ¼,�Ƿ����
		-x	!-x
			�ж��ļ��Ƿ��ִ��
		
		# ֧�� $1 - $9 λ�û�����

	# ����
		location / {
			if ($remote_addr = 192.168.250.171){
				//��������ߵ�IP��192.168.250.171,ֱ����Ӧ404
				return 404;
			}
		}
	

-----------------------
Nginx-ϵͳԤ����ı���|
-----------------------
	# conf/fastcgi.cnf
		fastcgi_param  SCRIPT_FILENAME    $document_root$fastcgi_script_name;
		fastcgi_param  QUERY_STRING       $query_string;
		fastcgi_param  REQUEST_METHOD     $request_method;
		fastcgi_param  CONTENT_TYPE       $content_type;
		fastcgi_param  CONTENT_LENGTH     $content_length;

		fastcgi_param  SCRIPT_NAME        $fastcgi_script_name;
		fastcgi_param  REQUEST_URI        $request_uri;
		fastcgi_param  DOCUMENT_URI       $document_uri;
		fastcgi_param  DOCUMENT_ROOT      $document_root;
		fastcgi_param  SERVER_PROTOCOL    $server_protocol;
		fastcgi_param  REQUEST_SCHEME     $scheme;
		fastcgi_param  HTTPS              $https if_not_empty;

		fastcgi_param  GATEWAY_INTERFACE  CGI/1.1;
		fastcgi_param  SERVER_SOFTWARE    nginx/$nginx_version;

		fastcgi_param  REMOTE_ADDR        $remote_addr;
		fastcgi_param  REMOTE_PORT        $remote_port;
		fastcgi_param  SERVER_ADDR        $server_addr;
		fastcgi_param  SERVER_PORT        $server_port;
		fastcgi_param  SERVER_NAME        $server_name;
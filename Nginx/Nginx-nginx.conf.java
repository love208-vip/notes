------------------------
Nginx-nginx.conf�����ļ�|
------------------------
	* ��nginx��/confĿ¼��:nginx.conf
		
#user  nobody;

//�����ӽ�����,����ΪCPU�ĺ���������
worker_processes  1;

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#pid        logs/nginx.pid;

events {

	//IOģ��,������linux2.6�����ں�,���Դ�����nginx������
    use   epoll; 

	//������������������
    worker_connections  1024;
}

/*
	����HTTP������
*/
http {
		include       mime.types;
		default_type  application/octet-stream;
		/** 
			main��ʽ����־�����ʽ˵�� 
				$remote_addr			--> Զ��IP
				$body_bytes_sen			--> ��Ӧ�ֽڴ�С
				$http_referer			--> �Ǵ��ĸ�ҳ�����ӵ�����
				$http_user_agent		--> ������汾,����ϵͳ
				$http_x_forwarded_for	--> ... ...�Լ�ȥ��
			# �����Ҫ��server����ʹ�� main ��ʽ,��ô��Ҫ���ע��
		**/
		#log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
		#                  '$status $body_bytes_sent "$http_referer" '
		#                  '"$http_user_agent" "$http_x_forwarded_for"';

		#access_log  logs/access.log  main;

		sendfile        on;
		#tcp_nopush     on;

		#keepalive_timeout  0;
			
		keepalive_timeout  65;
			
		//�Ƿ�����ѹ��,�ڲ������ʱ��Ż����ֳ���Ч��
		#gzip  on;
		
		//���HTTP������
		client_max_body_size     500m;	

		//���HTTP����ͷ�����С
        client_body_buffer_size  218k;	
		
			
		//��������������
		server {
			//�����Ķ˿�	
			listen       80;

			//����������	
			server_name  localhost;

			#charset koi8-r;

			//��־�ļ�,�Լ������ʽ
			#access_log  logs/host.access.log  main;


			location / {
				root   html;
				index  index.html index.htm;
			}
			
			/* 404ҳ�� */
			#error_page  404              /404.html;

			# redirect server error pages to the static page /50x.html
			#
			/** 50Xҳ�� **/
			error_page   500 502 503 504  /50x.html;

			location = /50x.html {
				root   html;
			}

			# proxy the PHP scripts to Apache listening on 127.0.0.1:80
			#
			#location ~ \.php$ {
			#    proxy_pass   http://127.0.0.1;
			#}

			# pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
			#
			#location ~ \.php$ {
			#    root           html;
			#    fastcgi_pass   127.0.0.1:9000;
			#    fastcgi_index  index.php;
			#    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
			#    include        fastcgi_params;
			#}

			# deny access to .htaccess files, if Apache's document root
			# concurs with nginx's one
			#
			#location ~ /\.ht {
			#    deny  all;
			#}
		}


		# another virtual host using mix of IP-, name-, and port-based configuration
		#
		#server {
		#    listen       8000;
		#    listen       somename:8080;
		#    server_name  somename  alias  another.alias;

		#    location / {
		#        root   html;
		#        index  index.html index.htm;
		#    }
		#}

		/*		HTTPS��������		*/
		# HTTPS server
		#
		#server {
		#    listen       443 ssl;
		#    server_name  localhost;

		#    ssl_certificate      cert.pem;
		#    ssl_certificate_key  cert.key;

		#    ssl_session_cache    shared:SSL:1m;
		#    ssl_session_timeout  5m;

		#    ssl_ciphers  HIGH:!aNULL:!MD5;
		#    ssl_prefer_server_ciphers  on;

		#    location / {
		#        root   html;
		#        index  index.html index.htm;
		#    }
		#}
}

------------------------
Nginx-���ý⹹ͼ��		|
------------------------
			...		//ȫ������
			events{
				
			}
			http{
				server{
					...
				}
				server{
					...
				}
					...
			}

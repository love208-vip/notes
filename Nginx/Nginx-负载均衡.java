--------------------------------
Nginx-���ؾ���					|
--------------------------------
	# �ؼ���:upstream
	# ������httpģ����
	# upstream ���Ա������ǩ����

--------------------------------
Nginx-��򵥵ĸ��ؾ���			|
--------------------------------
		http {
				include				mime.types;
				default_type		application/octet-stream;
				sendfile			on;
				keepalive_timeout	65;

				upstream web_pools {
						server 127.0.0.1:8081 weight=2;
						server 127.0.0.1:8082 weight=3;
				}

				server {
						listen       80;
						server_name  192.168.250.165;
						location / {
								proxy_pass http://web_pools;
						}
				}
		}

--------------------------------
Nginx-upstream ���				|
--------------------------------
	# Nginx������⹦��������:ngx_http_upstream_module  ģ��
	# ֧�ֵĴ���ʽ��:proxy_pass,fastcgi_pass,memcached_pass
	# upstream server ���õĲ���
		weight
			# weight=2
			# Ȩ��,Ĭ��ֵ��1,Ȩ��Խ��,���ܵ�����Խ��

		max_fails
			# max_fails=2
			# �����ʧ�ܵĴ���,Ĭ��Ϊ1,�������Ϊ0,���ֹʧ�ܳ���
			# ���Ǹ���������жϷ������ǲ��ǹ���
			# �������ʧ�ܰ�,���Ǻ�˷�������Ngixn��Ӧ��һЩɶ500��ͷ��,400��ͷ��HTTP��

		fail_timeout
			# fail_timeout=3s
			# ��ʱʱ��,Ĭ����10s,ͨ����ʱʱ����ȷ���Ƿ�����ʧ��

		dowm
			# �÷�������Զ������
			# ���һ�����:ip_hash ��ʹ��

		backup
			# '�߿���',����
			# ���ùؼ��ֱ�ʶ��server,��ʾ.�÷�������һ�����ݷ�����.�������Ķ�崻���.�Ż�������
		
		max_conns
			# max_conns=10000
			# ���Ĳ���������,Ĭ��Ϊ0.��ʾû�������������
			# ����һ��'�����ڵ�ķ���',��ֹ������������



	# ͨ����������ĵ�ַ����дIP,ͨ��DNS�����������ؾ���

--------------------------------
Nginx-proxy_pass ���			|
--------------------------------
	# ���Ӧ���Ƿ������ķ���
	# prox_pass,ָ������:ngx_http_proxy_moduleģ��,��ģ����԰�����ת����ָ���ķ�����
	# ��ָ����ڵ�λ��
		* location
		* if in location
		* limit_except
	# ����
		proxy_set_header
			* �����ɺ�˵ķ�������ȡ�û���������������ʵ��IP��ַ,�Լ������ߵ�IP��ʵ��ַ
		
		proxy_next_upstream http_502 http_504 error timeout invalid_header;
			* �����˷���������502,504ִ�г�ʱ�ȴ���,�Զ�������ת�������ؾ����������ķ�����.ʵ�ֹ���ת��

		client_body_buffer_size
			* ����ָ���ͻ����������建������С,�������Ϊ.�ȱ��浽����,����Ӧ���ͻ���

		proxy_connect_timeout
			* ��ʾ���˷����������ӳ�ʱʱ��,���Ƿ������ֺ�ȴ���Ӧ�ĳ�ʱʱ��

		proxy_send_timeout
			* ��ʾ��˷��������ݻش���ʱ��,Ҳ����˵���������ָ����ʱ����,��˷��������봫�������е�����.����Nginx��Ͽ�����

		proxy_read_timeout
			* ����Nginx�Ӵ���ĵĺ�˷�������ȡ���ݵ�ʱ��,����Nginx���Ӻ�.�������������,�ȴ�����˵���Ӧʱ��.
		
		proxy_buffers
			* ���û������Ĵ�С,Nginx�Ӻ�˷�������ȡ��������,���ȴ���ڸû�������
		
		proxy_buffer_size
			* ���û����Ĵ�С,Ĭ�ϸû�������С����:proxy_bufers ���õĴ�С
		
		proxy_busy_buffers_size
			* ��������ϵͳ��æʱ,����ʹ�õ�:proxy_buffers��С.�ٷ��Ƽ���С��:proxy_buffers * 2
		
		proxy_temp_file_write_size
			* ָ��proxy������ʱ�ļ��Ĵ�С

	# ����ʾ
		location / {
			proxy_pass http://web_pool;
			//ת���ͻ��������������
			proxy_set_header Host $host;
			//ת���ͻ��˵���ʵIP
			proxy_set_header X-Forwarded-For $remote_addr;
			//����ת��
			proxy_next_upstream http_502 http_504 error timeout invalid_header;

			proxy_set_header X-Real-IP $remote_addr;
			proxy_connect_timeout 90;
			proxy_send_timeout 90;
			proxy_read_timeout 90;
			proxy_buffer_size 4k;
			proxy_buffers 4 32k;
			proxy_busy_bufers_size 64k;
			proxy_temp_file_write_size 64k;
		}
	 
--------------------------------
Nginx-���ؾ����㷨				|
--------------------------------
	# Ĭ���ǲ���'��ѯ�㷨'.
		* �ٷֱ�
		* �ٷֱ�,�����Ǽ���,���ǰ�����������հٷֱ��й��ɵķ����������
		* 
	
	# Hash�㷨
		* �ؼ���:ip_hash
		* ����˵,һ��IP(�ͻ���),�������ֻ��λ��һ̨����.
		* ע��,��ʹ����iphash�㷨��ʱ��,'backup',����ʹ��,�ᱨ��
		* Ȩ�ص����ò��ᱨ��,����ʧЧ.
		* '���ָ��ؾ���,��Ҫ���ǽ���Ự(SESSION)���ֵ�����'
		* ����,�ⶫ��Ҳ��ᵼ�·��ʲ���

		upstream web_pools {
			ip_hash; 
			server 127.0.0.1:8081 weight=2;
			server 127.0.0.1:8082 weight=3;
		}
	
	# fair(������),��̬�㷨
		* ���պ��'������RS����Ӧʱ��'����������,��Ӧʱ��̵�����
		* �����㷨����,����.Nginx����֧��fair,�����Ҫʹ�������㷨.��������Nginx��:upstream_fairģ��
		
		upstream web_pools {
			
		}
	
	# url_hash(������),�㷨
		* ����˷�����Ϊ�����������ʱ��Ч������.
		* ��ip_hash�е�����
	
	# least_conn �㷨
		* ����������,������ĸ���������������С.�ͷ�����ĸ�����
	
	# һ����HASH�㷨
		* ���ڸ߼�JAVAEE����ܹ�ʦ�ķ���


--------------------------------
Nginx-�ڵ㽡��					|
--------------------------------
	# Nginx ţ��֮�����ڿ��Լ�ؽڵ�.�Զ���ȥ�ж�.����ڵ�崻���,���Զ��޳�.����ָ���,�ּ���

--------------------------------
Nginx-���ڵ�״̬				|
--------------------------------
	# ��Ҫ�����ʵ��
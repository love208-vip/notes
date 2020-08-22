---------------------------
Linux-Դ�밲װ				|
----------------------------
	wget http://nginx.org/download/nginx-1.10.1.tar.gz

	# Դ�밲װ���������Ŀ�
		1,yum -y install gcc gcc-c++ autoconf automake
		2,yum -y install zlib zlib-devel openssl openssl-devel pcre-devel

	1,��������Դ���,�ϴ���������
		nginx-1.10.1.tar.gz
	2,��ѹԴ���
		tar zxvf nginx-1.10.1.tar.gz
	3,����Դ���Ŀ¼
		* ָ����װĿ¼,��鰲װ
			./configure --prefix=/usr/local/nginx 
	4,ȷ�������ֱ�Ӱ�װ
		make && make install
	
	5,��װ�ɹ���,�����ĸ�Ŀ¼
		conf
			> �����ļ�
		html
			> web�����Ŀ¼,��ҳ�ļ�
		logs
			> ��־
		sbin
			> �����ű�
		* ����ʱ��������һЩ��׺��Ϊ:_temp����ʱĿ¼

	# ��װ����
		 the HTTP rewrite module requires the PCRE library
			* ȱ��������[PCRE]�Ŀ�
			* �������,ֱ�Ӱ�װ����������
					yum install pcre
					yum install pcre-devel
		
		 the HTTP gzip module requires the zlib library.
			* ȱ��:zlib����
			* �������,ֱ�Ӱ�װ������
					yum install zlib
					yum install zlib-devel
	

	# zlib		:Nginx�ṩgzipģ��,��Ҫzlib���֧��
	# openssl	:Nginx�ṩssl����
	# pcre		:֧�ֵ�ַ��дrewrite����

	# �����û� & �û���
		groupadd -r nginx
				> -r ��ʾ��ϵͳ��
		useradd -r /sbin/nologin -g nginx
				> �����е�¼,����Ӵ��û���nginx�û���
------------------------
Nginx-����				|
------------------------
	* �ⶫ���ǳ���ţ��,����˹��д��
	* ��һ�������ܵ�HTTP�ͷ�����������
	* ֧�ֵĲ���ϵͳ�ڶ�:Windows,Linux,MacOS X
	* ����ʵ�ָ��ؾ���
	* Rewrite����ǿ��
	* ���̼ܹ��󲿷ֶ�����Nginx+Tomcat�ܹ�
	
	# WEB������	�� WEBӦ�÷�����������
		* WEB������ֻ�ܽ�����̬���ļ�
		* WEBӦ�÷�����,�ǿ��Խ�����̬�ű����Ե�(Tomcat)
	
	# �߲�������
		* �ٷ�����,����״̬��,����֧��5W����.ʵ�ʲ��Կ��Դ�3W����.ÿ����Դ������ڴε�����
		* ��������epoll(Linux2.6�ں�)��kqueue(feebsd)����IOģ��,��Apache���ô�ͳselectģ��
	
	# �ڴ�����С
	
------------------------
Nginx-���ص�ַ			|
------------------------
	# widows �汾
		http://nginx.org/en/download.html
		*	Mainline version:�ں˰�
		*	Stable version	:�ĵ���


------------------------
Nginx-��������			|
------------------------
	# Linux
		1,Դ�밲װ
			����
				./sbin/nginx
				* ֱ�Ӿ���·��ִ��nginx��OK
				
			�ر�
				./sbin/nginx -s stop
				* Ҳ�Ǿ���·��,-s ����,stop����,��ȻҲ����ʹ�� kill����
				kill -QUIT `cat /usr/local/nginx/logs/nginx.pid`
				* ���ַ�ʽ��ҵ���ǱȽ�רҵ��.����������һ�������.ִ�йر�

			���¼���
				./sbin/nginx -s reload
				* Ҳ�Ǿ���·��������

			��������
				*  ֱ��д��:/etc/rc.d/rc.local	�ļ�
			
			��������ļ��Ƿ�OK
				./sbin/nginx -t -c /usr/local/nginx/conf/nginx.conf
				* -t �Ǽ��,-c�������ļ�
			
			�鿴���밲װʱ����Ĳ���
				./ngin -V

			
		2,rpm��װ���ҾͲ�˵��
			service...
			chkconfig nginx on

		
		* Nginx�����ȫ
			https://www.nginx.com/resources/wiki/start/topics/tutorials/commandline/
		* ./nginx -h
			* ���Բ鿴Nginx�����ѡ��
	
	# Windows
		* ����NginxĿ¼
		* ��CMD����
		����	
			start nginx.exe

		ֹͣ	
			nginx.exe -s stop

		���¼���
			nginx.exe -s reload

		# Nginx��ʹ��Ŀ¼�в�Ҫ��������
		# ������������п�������Nginx�Ľ���,��ôNginx������������


------------------------
Nginx-һЩ֪ʶ			|
------------------------
	
	# ./nginx/logs/nginx.pid
		* ���ļ�����д����ǵ�ǰNginx���е�PID

	# ������ʾĿ¼�ṹ
		* ��������ӳ�䵽һ��Ŀ¼,��urlָ��Ŀ¼��ʱ��.û��ָ��index.�ᱨ403
		* ������location�������������

		autoindex on;				# ��ʾĿ¼
		autoindex_exact_size on;	# ��ʾ�ļ���С
		autoindex_localtime on;		# ��ʾ�ļ�ʱ��


	
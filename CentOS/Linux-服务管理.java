------------------------
Linux-�������			|
------------------------
	# Linux�ķ������
		1,RPM��Ĭ�ϰ�װ�ķ���(Ĭ��)
			* �����ķ���
			* ����xinetd(�����ػ�����)�ķ���(�м���ĸо�)
		2,Դ�����װ�ķ���

	# ����������������
		* ��������:�����ڵ�ǰϵͳ���������������,�����ṩ����
		* ��������:�÷���,�������������������
	
	# �鿴�������еķ���
		ps aux
		* ��ʵ����ǲ鿴����...
	
	# ���������ķ���
		/etc/init.d/[����������] [ѡ��]
		# ѡ��
			start
			stop
			status
			restart
		
		service [����������] [ѡ��]
		# �����Redhatϵ��ר��
		# ѡ��
			start
			stop
			status
			restart

	# �鿴���а�װ��RPM��,�ķ����״̬
		service --status-all
	
------------------------
Linux-RPM����װ�ķ���	|
------------------------
	# �鿴�Ѿ���װ�ķ���
		* ��������Բ鿴���е�RPM��װ���ķ���״̬,���ܲ鿴Դ�����װ�ķ���
		chkconfig --list

			NetworkManager  0:off   1:off   2:on    3:on    4:on    5:on    6:off
			abrt-ccpp       0:off   1:off   2:off   3:on    4:off   5:on    6:off
			abrtd           0:off   1:off   2:off   3:on    4:off   5:on    6:off
			acpid           0:off   1:off   2:on    3:on    4:on    5:on    6:off
			atd             0:off   1:off   2:off   3:on    4:on    5:on    6:off
			auditd          0:off   1:off   2:on    3:on    4:on    5:on    6:off
			blk-availability0:off   1:on    2:on    3:on    4:on    5:on    6:off
			bluetooth       0:off   1:off   2:off   3:on    4:on    5:on    6:off
			cpuspeed        0:off   1:on    2:on    3:on    4:on    5:on    6:off
			cups            0:off   1:off   2:on    3:on    4:on    5:on    6:off
			# 0-6�Ǵ���ϵͳĬ�ϵ�7�����м���
	
	# �鿴ָ�����������״̬
		chkconfig --list |grep httpd
	
	# RPM��װ��λ��
		/etc/init.d
			* (��������)�����ű�λ��
			* ���Ŀ¼��ʵ��:/etc/rc.d/init.d Ŀ¼������Ŀ¼
		/etc/sysconfig
			* ��ʼ�����������ļ���ַ
		/etc
			* �����ļ���ַ
		/etc/xinetd.conf
			* xinetd�����ļ�
		/etc/xinetd.d
			* ����xinetd����������ű�
		/var/lib
			* ������������ݷ�������
		/var/log
			* ��־
		# ����ֻ�ǳ����Ŀ¼,Ҳ��һЩRPM������һЩ�������������ĵط�

------------------------
Linux-Դ�����װ�ķ���	|
------------------------
	# �鿴��װ�ķ���
		* �鿴����װλ��,һ������/usr/local��
	
	# �������ļ�copy��/etc/rc.d/init.dĿ¼��,Ҳ�ǿ���ʹ��service��������������(��������ô��)
	
	# Դ�����װ�ķ�������
		* ʹ�þ���·�������������ű�(ÿ������������ű��϶���ͬ)
		/home/opt/tomcat/bin/start.sh
	
	# Դ���������
		* �༭:/etc/rc.d/rc.local �ļ�
		* ������������(�����ű��ľ���·��)
		/home/opt/apache2/apachectl start
	
	# ��Դ���������,�������������ʶ��
		# ��Service����֮���������Դ�����װ�ķ���
			* �ܼ�,����������,���ӵ�/etc/init.d�ͺ���
			ln -s [�����ű�·��] /etc/init.d/[�����ű�����]
	
	# ��ĳЩ�����ں�̨����
		* û��,�����нű��ĺ������һ��  & ���� ִ��
		/usr/local/redis/redis-server &

------------------------
Linux-RPM����������		|
------------------------
	# ����������
		1,ʹ������
			chkconfig --level [���м���] [����������] [on/off]
				* chkconfig --level 2345 httpd on
				* --level ����ʡ��,Ĭ�ϵľ���:2345	����ֱ��:chkconfig httpd off
				* ��֧��Դ�����װ�ķ���

		3,�޸������ļ�(��׼)
			/etc/rc.d/rc.local
			* ����ļ�,�������¼ϵͳ��ʱ�������û���������֮ǰ����(ִ��)
			* �����ǿ���д�����
			* ֱ��������д���׼���ļ���������,��ô���������ڵ�¼֮ǰ����������
				/etc/rc.d/init.d/[������] start

	# ����������
		* ʹ��ntsysv�����������������
		* ���ţ����,ͼ�λ�����.redhat�Ķ���
		* ��������ɶ,�����ĸ�ѡ��ǰ���*��.��֮ȥ���ͺ�
	
	# xinetd����������
		1,chkconfig telnet on
		2,Ҳ������ntsysv������
	

------------------------
Linux-�ܽ�				|
------------------------
	
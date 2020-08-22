------------------------
systemctl				|
------------------------
	# �汾�鿴
		systemctl --version
			# �鿴��ǰϵͳ�� systemctl �汾
		
	# ���ػ�
		systemctl reboot
			# ����

		systemctl halt
		systemctl poweroff
			# �ػ�
	
	# �������������ļ�
		systemctl daemon-reload
		* ���޸��� xx.service �����ļ���,ִ�и���������������

	# �������
		systemctl start xx.service
		systemctl stop xx.service
		systemctl restart xx.service
		systemctl reload xx.service
			# ���������,ֹͣ,����,��������

		systemctl enable xxx
			# ʹĳ������������
			# 6:chkconfig xxx on	
		
		systemctl is-enabled xxx.service
			# ���ĳ�������Ƿ���������

		systemctl disable xxx
			# �ر�ĳ�������������
			# 6:chkconfig xxx off
		
		systemctl status xxx.service 
			# ��ʾ�������ϸ��Ϣ
			# ����
				* is-active			//������ʾ��ķ���-	systemctl is-active xxx.service 
			# 6:service xxx status	
		
		systemctl list-unit-files --type=service
			# �г����з��񣨰������õĺͽ��õģ�

		systemctl --failed
			# ��ʾ������ʧ�ܵķ���
		

		systemctl kill xxx
			# ����Ҳ�������.service
			# ɱ������

	# ����
		systemd-analyze blame
			# �鿴���������������ѵ�ʱ��
		
		systemd-analyze critical-chain
			# ����ϵͳ�����Ľ��̹�ϵ��




------------------------
systemctl-�Զ������	|
------------------------
	# �ļ���ַ
		/usr/lib/systemd/system
		/etc/systemd/system

	[Unit]
		Description=mysql
		After=network.target remote-fs.target nss-lookup.target
	[Service]
		Type=forking
		PIDFile=/node.js/pid
		ExecStart=/etc/init.d/mysql start
		ExecReload=/etc/init.d/mysql restart
		ExecStop=/etc/init.d/mysql stop
		PrivateTmp=true
	[Install]
		WantedBy=multi-user.target

	[Unit]������Ҫ�Ƕ���������˵�������ݰ���Description��After��Description������������After���������������

	[Service]�����Ƿ���Ĺؼ����Ƿ����һЩ�������в��������ã�����Type=forking�Ǻ�̨���е���ʽ��PIDFileΪ���PID���ļ�·����ExecStartΪ����ľ����������ExecReloadΪ�������ExecStopΪֹͣ���PrivateTmp=True��ʾ����������������ʱ�ռ䣬ע�⣺[Service]���ֵ�������������ֹͣ����ȫ��Ҫ��ʹ�þ���·����ʹ�����·����ᱨ��

	[Install]�����Ƿ���װ��������ã�������Ϊ���û���

	����ű����������д��ɺ���754��Ȩ�ޱ�����/usr/lib/systemd/systemĿ¼�£���ʱ�Ϳ�������systemctl����������

	���ȣ�ʹ��systemctl start [��������Ҳ���ļ�����]�ɲ��Է����Ƿ���Գɹ����У�����������������ʹ��systemctl status [��������Ҳ���ļ�����]�鿴������Ϣ������������Ϣ��Ȼ����ݱ�������޸ģ�ֱ������start����������Ļ����Բ���restart��stop���

	���ţ�ֻҪʹ��systemctl enable xxxxx�Ϳ��Խ�����д�ķ�������������������ɡ�
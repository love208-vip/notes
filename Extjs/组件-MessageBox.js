-------------------------
MessageBox				 |
-------------------------
	# Ext.window.MessageBox
	# ��Ϣ��ʾ�����

-------------------------
����					 |
-------------------------
	alert(String titile,String message,function callback,Object scope);
		# ����һ����Ϣ��ʾ��
		# ����
			title
				* ��ʾ����ʾ�ı���
			message
				* ��ʾ����Ϣ
			callback(��ѡ����)
				* �ص����� function(e){},������ȷ��,��e="ok",�����x,��e="cancel"
			scope(��ѡ����)
				* �ص������ķ�Χ

	confirm(String titile,String mesage,function callback);
		# ����һ������"��"��"��"��ȷ����
		# ����
			title
				* ��ʾ����ʾ�ı���
			message
				* ��ʾ����Ϣ
			callback(��ѡ����)
				* �ص����� function(e){},������"��",��e="yes",�����"��",��e="no"

	prompt(String titile,String message,function fun,null none,boolean multiline,String initText);
		# ���ı���ĶԻ���
		# ����
			title
				* ��ʾ����ʾ�ı���
			message
				* ��ʾ����Ϣ
			fun
				 * �ص�ɾ��,function (btn, text) {}
				 * btn:�������ť
				 * text:�ı��������
			none
				* ֱ��дnull�Ȳ���
			multiline
				* �Ƿ�Ϊ�����ı��� 
				* ��ֵΪ boolean ������ Number(����),

			initText
				* �ı����еĳ�ʼ���ı�(Ĭ���ı�)

    },
	
	wait();
		# ����
			message
				* ��ʾ��Ϣ
			title
				* ����
			config
				* ���ö���
				* ������	
					interval: 500, 
						* ˢ��ʱ��
					duration: 50000,
						* ��������ʱ��
					increment: 15,
						* �������ĳ���,
					text: 'Updating...',
						* �������ı�
					scope: this,
						* ������
					fn
						* duration��Ϻ�ִ�еĶ���

	show();
		# �����Զ������͵ĶԻ���
		# ����,��һ��json����
			animEl
				* 
			buttons
				* ���������ť����,��Ҫ��һ�¼���
					Ext.Msg.OK,
					Ext.Msg.OKCANCEL,
					Ext.Msg.CAMCEL,
					Ext.Msg.YESNO,
					Ext.Msg.YESNOCANCEL
				* �ò�����һ������
			closable
				* �Ƿ���ʾ���Ͻǹر�x,Ĭ��true
			cls
				* �Զ����css
			defaultTextHeight
				* �����ı����ı��߶�
			fn
				* �رյ������ִ�еĺ���
			icon	
				* �������ͼ��,���õ�ͼ����
					Ext.MessageBox.INFO��
					Ext.MessageBox.ERROR,
					Ext.MessageBox.WARNING,
					Ext.MessageBox.QUESTION

			maxWidth
				* �����(Ĭ��600)
			minWidth
				* ��С���(Ĭ��100)
			modal
				* �Ƿ�ģ̬
			msg
				* ��Ϣ������
			multiline
				* �Ƿ��Ƕ����ı���
			progress
				* �Ƿ���ʾ������
			progressText
				* ����������ʾ���ı���Ϣ
			prompt
				* ����ʾ�����
			proxyDrag
				* �����ֵΪtrue,��Ϊ��ק��ʱ����ʾһ���������Ĵ������
			title
				* ����
			value
				* �ı����е�ֵ
			wait
				* ��ֵΪtrue,��̬��ʾ progress
			waitConfig
				* �ò�����json����,���ڿ�����ʾ progress
				*������
					interval
						* ���ȵ�Ƶ��,�ö��붯һ��
					duration
						* ִ�н��ȵĳ���ʱ�䣬�������ʱ���intervalʧЧ�����ٲ�������Ч���������ȿ�Ҳ������ʧ��
						* �����������������
					increment: 
						* �������ĳ���,
					scope
						* ������
					fn
						* duration��ʱ�䵽��ִ�еĺ���
			width
				* ������Ŀ��,������λ
	

	hide();
		# ���ضԻ���
	
	updateProgress(Number,progressText,msg);
		# ���½�����
		# ����
			Number
				* 0��1֮����κ��� (Ĭ��0),��������0.x - 1
			progressText
				* �������������ʾ���� (Ĭ��'')
			msg
				* ��Ϣ���������ݱ�ָ������Ϣ���� (Ĭ��û�ж���)
			Returns
				Ext.MessageBox
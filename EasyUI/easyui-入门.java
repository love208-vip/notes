------------------------
EasyUI-����				|
------------------------
	# ����ɶ?
		* ��ʵ����,����Jquery�ϵ�һ�Ѳ��
		* �ǳ�����ʵ��һЩҳ�泣����Ч��

	# Ŀ¼�ṹ
		demo						//��ʾ����
		demo-mobile					//�ֻ�����ʾ����
		locale						//���ʻ�
		plugins						//���
		src							//jquery easyui��Դ��
		themes
		changelog.txt
		easyloader.js
		jquery.easyui.min.js		//jqueryeasyui
		jquery.easyui.mobile.js		//�ֻ���
		jquery.min.js				//jquery
		license_freeware.txt
		readme.txt
	
	# ����������
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/easyui/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/easyui/themes/default/easyui.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/easyui/themes/icon.css">

		* jquery����Ҫ��������.
	
	# ����Demo��ʾ��ַ
		http://www.jeasyui.com/demo/main/index.php

------------------------
EasyUI-��Ⱦ��ʽ			|
------------------------
	# ��ʹ��JavaScript��Ⱦ
		<div id="div" title="����" class="easyui-dialog"></div>
		* ����ֱ����Ϊ����,д��HTML��ǩ��
	
	# ʹ��JavaScript��Ⱦ
		$(function(){
			$('#div').dialog({
				title:'����'
			});
		});
		* ������ΪJSON,���ݸ�����

------------------------
EasyUI-�ؼ�����������	|
------------------------
	# ������

------------------------
EasyUI-�ؼ������ĵ���	|
------------------------
	$('#div').panel('open');
		* ѡ��HTMLԪ��,Ȼ�����'�ؼ�����',�ڲ�����������'�ؼ�����'.��ɵ���
	

	$('#div').panel('open','param');
		* ѡ��HTMLԪ��,Ȼ�����'�ؼ�����',�ڲ�����������'�ؼ�����'.��ɵ���.�ڶ����������Ǵ��ݸ��ؼ������Ĳ���

------------------------
EasyUI-�ؼ��Ĺ�ϵ		|
------------------------
	�����Ĺ�ϵ,�е��� JAVA �е� extends .��������и������е���������,����,�¼�

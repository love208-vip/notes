------------------
Cookie				|
------------------
	# JS ����Cookie�Ĳ���
	# ʹ�� document ����



------------------
Cookie		����	|
------------------
	# ������
		document.cookie = "name=value";
		
		document.cookie = "SESSION=F8575532";

	
	# �����Ե�����
		document.cookie = "name=value;key=value;key-value;key-value;"

		document.cookie = "SESSION=F8575532;max-age=-1;";

------------------
Cookie		��ȡ	|
------------------
	document.cookie
		* �����Ի᷵�����е�Cookie,���ַ�������ʽ.�ָ��Ϊ:';'


------------------
Cookie		ɾ��	|
------------------
	# ��ʵ������������
		document.cookie = "SESSION=F8575532;max-age=0;";
		* ����ָ������Cookie,��ͬ����,·��,����ǿ�ֵ,���� max-age = 0


------------------
Cookie	-	Demo	|
------------------
	//��ȡ���е�Cookie
	function getCookies (){
		var cookie = {};
		var all = document.cookie;
		if(all === ''){
			return cookie;				
		}
		var list = all.split(';');
		for(var x = 0; x < list.length ; x++){
			var cookieStr = list[x];
			var point = cookieStr.indexOf('=');
			var name = cookieStr.substring(0,point);
			var value = decodeURIComponent(cookieStr.substring(point + 1));
			cookie[name] = value;
		}
		return cookie;
	}
------------------
location			|
------------------
	# �����������
	# window.location === document.location

------------------
location		����|
------------------
	href="http//:www.baidu.com";	
		* ���������ָ���ĵ�ַ
	href;							
		* ��ȡ����������ַ
	hostname 
		* ����WEB����������
	pathname 
		* ���ص�ǰҳ���·�����ļ���
	port 
		* ���� web �����Ķ˿� ��80 �� 443��
	protocol 
		* ������ʹ�õ� web Э�飨http:// �� https://��
	search
		* ����URL��Ĳ�ѯ����
		* ? ����Ĳ���

------------------
location		����|
------------------
	assign();
		* �����µ��ĵ�
		* ����ָ��URL
	
------------------
location		�¼�|
------------------
	

------------------
location		demo|
------------------
	//��ȡURI�е��������
	function urlArgs(){
		var args = {};
		//��ȡ�����ַ���,ɾ��?��
		var query = location.search.substring(1);
		//���� & ���Ϸָ��ַ���
		var pairs = query.split("&");
		for(var x = 0;x < pairs.length;x++){
			//����name=value
			var pos = pairs[x].indexOf("=");
			if(pos == -1){
				continue;
			}
			var name = pairs[x].substring(0,pos);
			var value = pairs[x].substring(pos + 1);
			//URI����
			value = decodeURIComponent(value);
			if(args.hasOwnProperty(name)){
				//�����Ѿ�����,��','�ŷָ�
				value = args[name] + "," + value;
			}
			args[name] = value;
		}
		return args;
	}


	
	//��ȡ��Ŀ�ĸ�·��
	getRootPath : function (){
		var pathName = window.document.location.pathname;
		var projectName = pathName.substring(0,pathName.substr(1).indexOf('/') + 1);
		return projectName;
	},
	
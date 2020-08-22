---------------------------
XMLHttpRequest				|
---------------------------
	# ����
		function createXMLHttpRequest(){
				try{
					//����������
					return new XMLHttpRequest();
				}catch(e){
					try{
						return new ActiveXObject("Msxml2.XMLHTTP");//IE6.0
					}catch(e){
						try{
							return new ActiveXObject("Microsoft.XMLHTTP");//IE5.5�Լ�����汾
						}catch(e){
							alert("Ϊ�˸��õ�����,������������������ʱ�վ");
							throw e;
						}
					}
				}
			}
		
	# ʵ������
		open(method,url,async)
			* ��һ������,
			* ��һ������,���ַ�������ʽָ������ʽ
			* �ڶ�������,���ַ���,URL,
			* ����������boolean,�Ƿ�Ϊ�첽(Ĭ��true)
		setRequestHeader(header,value)
			* ��������ͷ,��һ�������� ����ͷ��key,�ڶ�������������ͷ��value
		send()
			* ����������,�����GET����,��÷���Ӧ������Ϊnull(����������������)
			* ����������URL�������ַ���,Ҳ������ FormData ����
		
		getResponseHeader(name)
			* ��ȡָ�����Ƶ���Ӧͷ

		getAllResponseHeaders()
			* ��ȡ���е���Ӧͷ
		

	# ʵ������
		readyState
			* ����״̬��
				> 0״̬:�մ���,��û�е���oppen();����
				> 1״̬:����ʼ,������oppen();����,����û����send����
				> 2״̬:���������,��������send����
				> 3״̬:�������Ѿ���ʼ��Ӧ,������ʾ��Ӧ������
				> 4״̬:��������Ӧ����(ͨ������ֻ�������״̬...)
		status
			* HTTP��Ӧ��
		
		timeout
			* ��ʱʱ��,��λ(ms)
			* Ĭ�� 120 s
		
		responseTyper	
			* �����������Ӧ����������
			* ��ѡֵ
				arraybuffer,
				blog,	
				

		responseXML
			* ���ط�������Ӧ��XML����

		responseText
			* ���ط�������Ӧ��TEXT����

		withCredentials
			* �ڿ��������ʱ��,�Ƿ��CookieֵҲ���͵����������
		
		upload
			* ���ύ�ı����ļ�����ʱ��,�����Ի����
			* �����Կ��Լ���һ���ϴ��¼�:progress
			* Event����
					total;		//��ȡ�ϴ��ļ�����(����)��С
					loaded;		//��ȡ�Ѿ��ϴ����ļ���С
	
	# �¼�
		onreadyStatechange
			* ���첽�����״̬�����ı��ʱ�����
			* ��ʹ�� async=false ʱ�����ñ�д onreadystatechange ����,�Ѵ���ŵ� send() �����漴��

		
---------------------------
XMLHttpRequest-GET			|
---------------------------
	var xmlHttp = createXMLHttpRequest();
	xmlHttp.open("GET", "/test", true);
	xmlHttp.send(null);//GET����û��������,����ҲҪ����null,��ȻFireFox�����޷�����
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			//��ȡ����˵���Ӧ
			var text = xmlHttp.responseText;
		}
	}

---------------------------
XMLHttpRequest-POST			|
---------------------------
	var xmlHttp = createXMLHttpRequest();
	xmlHttp.open("POST", "/test", true);		
	//������ΪPOST��ʱ��,��Ҫ�ֶ������ͷ
	xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");	
	//������
	xmlHttp.send("userName=kevin&passWord=123456");				
	xmlHttp.onreadystatechange = function()	{					
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){	
			//��ȡ����˵���Ӧ
			var text = xmlHttp.responseText;
		}
	}

---------------------------
XMLHttpRequest-������		|
---------------------------
		var oReq = new XMLHttpRequest();
		oReq.open("GET", "/common/get/captcha", true);
		//��Ӧ��Ϊ�����Ƶ�blob
		oReq.responseType = "blob";
		oReq.onreadystatechange = function () {
				if (oReq.readyState == oReq.DONE) {
				//��ȡ����������
				var blob = oReq.response;
				var obj = {};
				obj.imgSrc = URL.createObjectURL(blob);
				console.log(obj.imgSrc);
			}
		}
		oReq.send(); 
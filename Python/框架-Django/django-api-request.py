---------------------------------------
django.core.handlers.wsgi.WSGIRequest	|
---------------------------------------

---------------------------------------
ʵ������								|
---------------------------------------
	dict environ
		* �鿴�ն˵�������Ϣ

	str method
		* ��ǰHTTP������ʽ,������������ str
		* 'GET','POST','DELETE','PUT'

	QueryDict POST
		* ��request.body���������ٷ�װ��request.POST����
		* ��ȡPOST�ύ�Ĺ�����key=value������
		* ������������ dict ����
	
	QueryDict GET
		* ��request.body���������ٷ�װ��request.POST����
		* ͬ��,��������GET����»�ȡ
	
	bytes body
		* ��ȡԭʼ��HTTP������,�Ƕ���������
		* 'Content-Type","application/json',�����������
		* ����ֱ��ʹ�� json.loads(),����ȡJSON������
	
	str path
		* ��ǰ������·��-URI
	
	dict COOKIES
		* ��ǰ��������� cookie,��ֵ��һ�� dict

	MultiValueDict FILES
		* ���ص����ϴ����ļ�����(dict),key����input="name",value ��һ���ļ���������(InMemoryUploadedFile)
		* value (InMemoryUploadedFile)����߱���������:
			name			str		�ļ�������
			size			int		�ļ��Ĵ�С
			content_type	str		�ļ���Content-Type
			file			BytesIO	�������ļ�ʵ�����

		* �ڶ��ļ��ϴ��������
			* �����ļ��ϴ�,Ҳ����ʹ�ø÷���
			* ͨ�� FILES(MultiValueDict)�� getlist(input_name),api����ȡָ�����Ƶ��ļ��������󼯺�(list)
				request.FILES.getlist('name')
			* �ļ��������� InMemoryUploadedFile	--> TemporaryUploadedFile
			* �����е�ÿ��Ԫ�ض���:TemporaryUploadedFile,�߱��� InMemoryUploadedFile һ��������
				name			str				�ļ�������
				size			int				�ļ��Ĵ�С
				content_type	str				�ļ���Content-Type
				file			TemporaryFile	�������ļ�ʵ�����(BytesIO	-->	TemporaryFile)
			
		* file �������ļ�ʵ����� api
			generator chunks()
				* ��ȡ���ļ�,�����ɿ��СΪ�ֽڵ��ֽ���(Ĭ��ΪUploadedFile.DEFAULT_CHUNK_SIZE ),
				* ���ص���һ��������
				* һ�����ڵ�����д���ļ�
					file = FILES.get('file')
					with open("E:\\updload.img",'wb') as target_file:
						for i in file.chunks():
							target_file.write(i)

	dict META
		* ���� dict,���������HTTP����ͷ�Ⱥܶ���Ϣ
		* ����HTTP����ͷ��Ϣ,���е�HTTP����ͷ����ת��Ϊ�˴�д,����ǰ������� HTTP_ ǰ׺
			HTTP_HOST localhost:8000
			HTTP_CONNECTION keep-alive
			HTTP_CACHE_CONTROL max-age=0
			HTTP_USER_AGENT Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36
			HTTP_UPGRADE_INSECURE_REQUESTS 1
			HTTP_ACCEPT text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
			HTTP_ACCEPT_ENCODING gzip, deflate, br
			HTTP_ACCEPT_LANGUAGE zh-CN,zh;q=0.8
			HTTP_COOKIE UM_distinctid=15dbf6268872dd-081fb9df4ae9be-323f5c0f-1fa400-15dbf626888485; CNZZDATA1263289496=695830195-1502152055-%7C1502152055; _ga=GA1.1.1468046053.1499215491
	
	str scheme
		* ����Э������.http/https
	
	str encoding
		* �����ʽ

	SimpleLazyObject user
		* TODO

	SessionStore session
		* django.contrib.sessions.backends.db.SessionStore
		* session�м��
	

---------------------------------------
ʵ������								|
--------------------------------------
	bool is_ajax()
		* �ж��ǲ���ajax����
		* Դ��
			def is_ajax(self):
				return self.META.get('HTTP_X_REQUESTED_WITH') == 'XMLHttpRequest'
	
	bool is_secure()
		* �ж��ǲ���https����
	
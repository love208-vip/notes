-----------------------
FileReader				|
-----------------------
	# H5���¶���


-----------------------
FileReader-����			|
-----------------------
	result 
		* ���

-----------------------
FileReader-����			|
-----------------------
	readAsBinaryString	
		* ����file	���ļ���ȡΪ�����Ʊ���

	readAsText	
		* ����:file,[encoding]	
		* ���ļ���ȡΪ�ı�

	readAsDataURL	
		* ����:file	
		* ���ļ���ȡΪDataURL,��ʵ���� Base64 ����

	abort	
		* �ն˶�ȡ����
	
-----------------------
FileReader-�¼�			|
-----------------------
	onabort	
		* �ж�
	onerror	
		* ����
	onloadstart	
		* ��ʼ
	onprogress	
		* ���ڶ�ȡ
	onload	
		* �ɹ���ȡ
	onloadend	
		* ��ȡ��ɣ����۳ɹ�ʧ��
	
	# event ����/����
		

-----------------------
FileReader-demo			|
-----------------------
	//��ȡ�����ļ�����ʾ
	//��ȡ�ļ�
	var file = document.getElementById("file").files[0];
	var reader = new FileReader();	//���� FileReader ����
	//����¼�
	reader.onload = function(e){ 
		//��ȡ����ȡ��Ľ��:this.result
		result.innerHTML = '<img src="'+this.result+'" alt=""/>' 
	} 
	reader.readAsDataURL(file);		//��ȡ�ļ�
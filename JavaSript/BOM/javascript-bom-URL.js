------------------
URL					|
------------------
	createObjectURL()
		* �����Ƕ�����ͼƬ��Ϣ/ͼƬ����,���ص���ͼƬ��BASE64����

------------------
URL	- Demo			|
------------------
	# WEB��ʾ����ͼƬ
		var url = window.URL.createObjectURL(files[0]);		//���ڴ��и����ı�������һ�������ƶ���
		$('#img').attr({'src':url});						//ֱ�Ӱ���������ƶ�����ʾ��img,Ҫע������ʾ֮��,�ͷŵ��ڴ�
		window.URL.revokeObjectURL(url);					//�ͷ��ڴ�
	
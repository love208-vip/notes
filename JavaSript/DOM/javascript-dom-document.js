-----------------------
document				|
-----------------------

-----------------------
����					|
-----------------------
	all			
		* �ṩ���ĵ��ж���HTMLԪ�صķ���,�����֧��,��������
	anchors
		* ���ض��ĵ������� Anchor ��������á�
	forms		
		* �����ĵ�������Form��������,��������
	images
		* ��������imgae����,��������
	body		
		* �ṩ��<body>Ԫ�ص�ֱ�ӷ���
	links
		* ��������links������,��������
	body	
		* �ṩ�� <body> Ԫ�ص�ֱ�ӷ��ʡ�
		* ���ڶ����˿�ܼ����ĵ������������������� <frameset>��
	cookie	
		* ���û򷵻��뵱ǰ�ĵ��йص����� cookie��
	domain	
		* ���ص�ǰ�ĵ���������
	lastModified	
		* �����ĵ�������޸ĵ����ں�ʱ�䡣
	referrer	
		* �������뵱ǰ�ĵ����ĵ��� URL��
	title	
		* ���ص�ǰ�ĵ��ı��⡣
	URL	
		* ���ص�ǰ�ĵ��� URL��

-----------------------
����					|
-----------------------
	querySelectorAll();
		* ���ݱ��ʽ����һ��ڵ�
		* ���ʽ
			* ��ǩ+��������
				'input.error'
					* ���� class ֵΪ error �� input ��
			* id + ��ǩ����
				'#results td'
					* ���� id Ϊ results Ԫ���µ����� td Ԫ��
			* �������
				'.hightClass','.lowClass'
					* �����ж��ƥ�����,ʹ�� | 
			* �¼�����
				'td:hover'
					* ���ص�ǰ hover ��td
					* �����¼�����

	querySelector();
		* �������ʽ����һ���ڵ�

	getElementById();
		* ���ݱ�ǩ��IDֵ��ȡ��ǩ

	getElementsByTagName();
		* ���ݱ�ǩ���ƻ�ȡ�ڵ�,����:HTMLCollection
		* ����ʹ��ͨ���: * ,�������еĽڵ���Ϣ
		* demo
			var nodes = getElementsByTagName("div");
			nodes[0];
			nodes.item(0);

	getElementsByName();
		* ����name����ֵ��ȡ�ڵ�,����:NodeList
		* demo
			var nodes = getElementsByName("foo");
			nodes[0];
			nodes.item(0);
	
	createElement();
		* ����һ��HTML�ڵ�

	createTextNode();
		* ����һ���ı��ڵ�

	createAttribute();
		* ����һ��ָ�����Ƶ����Խڵ����

	createComment();
		* ����ע�ͽڵ�


	write();
		* ��HTML�ĵ��������,�Ḳ��ԭ����
	close()	
		* �ر��� document.open() �����򿪵������������ʾѡ�������ݡ�
	open()	
		* ��һ���������ռ������κ� document.write() �� document.writeln() �����������
	write()	
		* ���ĵ�д HTML ���ʽ �� JavaScript ���롣
	writeln()
		* ��ͬ�� write() ��������ͬ������ÿ�����ʽ֮��дһ�����з���
	


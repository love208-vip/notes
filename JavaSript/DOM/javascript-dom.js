--------------------
Js-Dom				|
--------------------
	* Dom:Document Object Model	�ĵ�����ģ��
	* �ĵ�:���ı��ĵ�(���ı�����ĵ�)html,xml
	* ����:�ṩ�����Ժͷ���
	* ģ��:ʹ�����Ժͷ����������ı�������ĵ�
	* ����ʹ��js��dom�����ṩ�Ķ���,ʹ����Щ��������Ժͷ���,�Ա�����ĵ����в���
	* ��Ҫ�����ĵ�,��Ҫ���ĵ��е���������,����װ�ɶ���
	* һЩ��������
		document	����HTML�ĵ�����
		element		��ǩ����
		node		�ڵ����,�Ǳ�ǩ����ĸ�����
		�ı�����	���ܵ�������,�������ڱ�ǩ
		���Զ���	���ܵ�������,�������ڱ�ǩ

	* DHTML -- ��̬��HTML
	����ʵ�ǲ���һ�ּ���,���Ƕ��ּ����ĺ���
		dom html css javacropt   ����Щ
		html		--	��������ݽ��з�װ
		dom			--	�ѱ�ǩ��װ�ɶ���
		css			--	�����ǩ�����ݵ���ʽ
		javacript	--	�����߽����ں�,ͨ��������Ʒ�ʽ����ɶ�̬Ч����չ��/����

--------------------
Js-�ڵ�				|
--------------------
	Ԫ�ؽڵ�
	�ı��ڵ�
	���Խڵ�
	ע�ͽڵ�


--------------------
Js-�ڵ����			|
--------------------
	# ��ȡ�ڵ�
		getElementById();
			* ���ݱ�ǩ��IDֵ��ȡ��ǩ

		getElementsByName();
			* ���ݱ�ǩ���ƻ�ȡ�ڵ�,����:HTMLCollection
			* demo
				var nodes = getElementsByName("div");
				nodes[0];
				nodes.item(0);

		getElementsByClassName();
			* ����name����ֵ��ȡ�ڵ�,����:NodeList
			* demo
				var nodes = getElementsByClassName("foo");
				nodes[0];
				nodes.item(0);

	# �ڵ�ָ��
		NodeList	childNodes;		
						* ���������ӽڵ��б�
		Node		firstChild;		
						* ָ����childNodes�б��еĵ�һ���ڵ�
		Node		lastChild;		
						* ָ����ChildNodes�б��е����һ���ڵ�
		Node		parentNode;		
						* ���ظ��ڵ�
		Node		previousSibling;	
						* ָ��ǰһ���ֵܽڵ�,���������,����null
		Node		nextSibling;		
						* ָ���һ���ֵܽڵ�,���������,����null
	
	# �ڵ����
		* �����ڵ�
			createElement();
				* ����THML�ڵ�
			createAttribute();
				* �������Խڵ�
			createTextNode();
				* �����ı��ڵ�
		
		* ����ڵ�
			appendChild();
				* ����µ��ӽڵ�
			insertBefor(�½ڵ�,�ӽڵ�);
				* ��ָ�����ӽڵ�ǰ����һ���µĽڵ�
		
		* �滻�ڵ�
			replaceChild(�½ڵ�,�ɽڵ�);
				* ���½ڵ��滻�ɽڵ�
		
		* ���ƽڵ�
			cloneNode(boolean);
				* ���� ��¡�Ľڵ�,���ݲ��������Ƿ�Ҫ�����ӽڵ�
			
		* ɾ���ڵ�
			removeChild();
				* ɾ��ָ�����ӽڵ�
		
	# ���Բ���
		* ��ȡ����
			getAttribute(��������);
				* ��ȡָ�����Ƶ�����

		* ��������
			setAttribute(������,����ֵ);
				* ��������

		* ɾ������
			removeAttribute(�������ƺ�);
				* ɾ������


			
				
			

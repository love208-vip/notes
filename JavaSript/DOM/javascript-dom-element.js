-------------------
Node����			|
-------------------
	


------------------
����				|
------------------
	# ����Ľڵ�߱��ض�������
		<img/>
			* src
				* document.getElementsByTagName("IMG")[0].src = "";
		<form/>
			* action
			* method
		<p/>
			* textContent
		...

	# �ڵ����
		NodeList		childNodes;		
							* ���������ӽڵ��б�

		Node			firstChild;		
							* ָ����childNodes�б��еĵ�һ���ڵ�

		Node			lastChild;		
							* ָ����ChildNodes�б��е����һ���ڵ�

		Node			parentNode;		
							* ����һ�������ڵ�ĸ��ڵ�

		Node			previousSibling;	
							* ָ��ǰһ���ֵܽڵ�,���������,����null

		Node			nextSibling;		
							* ָ���һ���ֵܽڵ�,���������,����null
	
	# �������
		
		String			nodeName		
							* ���ؽڵ������,���ݽڵ�����Ͷ�����

		String			nodeValue		
							* ���ؽڵ��ֵ,���ݽڵ�����Ͷ�����

		String			value
							* ͬ��....�о�ûɶ��һ��

		Document		ownerDocument	
							* ָ������ڵ��������ĵ�

		String			className
							* ClassName

		Number			nodeType;			
							* ���ؽڵ�����ͳ���֮һ
								�ڵ�����:
								��ǩ�νڵ�		---		1
								���Խڵ�		---		2
								�ı��ͼ���		---		3 [ע��հ��ı�,����������]
								ע���ͽڵ�		---		8
								document�ڵ�	---		9

		NamedNodeMap	attributes
							* �����˴���һ��Ԫ�ص����Ե�Attr����,������Element�ڵ�
		
		String			id
							* ����IDֵ
		String			innerHTML
							* ����Ԫ������,����HTML��ǩ
		String			innerText
							* �����ı�����,������HTML��ǩ
	# ��ʽ
	CSSStyleDeclaration	style
							* ����Ԫ�ص�style����
		CSSClassList	classList
							* ���� class ���Զ��������


------------------
����				|
------------------			
	# �ӽڵ����
		hasChildNodes();	
			* �Ƿ����ӽڵ�,����Booleanֵ
			* �����ǿհ׵��ַ���,Ҳ�������ӽڵ�

		appendChild();
			* ���һ���ӽڵ�
		
		insertBefor(�½ڵ�,�ӽڵ�);
			* ��ָ���ӽڵ�ǰ�����µĽڵ�
		
		replaceChild(���ӽڵ�,���ӽڵ�);
			* ʹ����Ԫ��,�滻ָ���ľɽڵ�

		removeChild();
			* ɾ��ָ�����ӽڵ�

	
	# �����ڵ����
		cloneNode(boolean)
			* ���ص�ǰ�ڵ�Ŀ�¡�ڵ�,���ݲ��������Ƿ�Ҫ��¡�������ӽڵ�

	# ���Բ���
		
		setAttributeNode();
			* ����һ�����Խڵ����

		removeAttributeNode()	
			* �Ƴ�ָ�������Խڵ㣬�����ر��Ƴ��Ľڵ㡣

		getAttribute();
			* ��ȡָ���������Ե�����ֵ
		
		setAttribute(������,����ֵ);
			* ����������������ֵ
		
		removeAttribute();
			* ɾ��ָ�����Ƶ�����ֵ
		
		hasAttribute();
			* �жϽڵ��Ƿ�߱�ָ��������
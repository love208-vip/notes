------------------------
xml						|
------------------------
	* ����xml��api
	* ����ģ��	
		xml.etree.ElementTree

	* ���ڲ���
		1,����xml�ļ���ȡ�� tree ����
			xml.etree.ElementTree.ElementTree parse(file)

		2,��tree�����ȡroot�ڵ�
			getroot()
			* �ڵ�֧��ʹ�� for ѭ������
				root = getroot()
				for i in root:
					pass

		3,����һЩ�еĽڵ����
			str tag
				* ���ر�ǩ����

			dict attrib
				* ��ǩ����(dict)

			str text
				* ���ر�ǩ��
				* ��ֵ����,���ñ�ǩ��

			set(key,value)
				* ���ñ�ǩ����

			iter iter(tagname)
				* ���Ի�ȡ������ָ�����Ƶ��ӱ�ǩ(���ֲ��),���б�������
				* ���ص��ǵ�����

			findall(tagname)
				* ��ȡ��ǰ�ڵ��µ�ָ�����Ƶ�����һ���ڵ�
			
			find(tagname)
				* ��ȡ��ǰ�ڵ��µ�ָ�����Ƶĵ�һ��һ���ڵ�
			
			remove(tagname)
				* �Ƴ�һ���ӽڵ�

------------------------
xml-ģ������			|
------------------------

------------------------
xml-ģ�麯��			|
------------------------

------------------------
xml-xml.etree.ElementTree.ElementTree|
------------------------
	xml.etree.ElementTree.ElementTree parse(file)
		* ����xml�ļ�,���ض���
	
	xml.etree.ElementTree.Element getroot()
		* ���ظ��ڵ����
		* �ڵ����ɱ���
		* �߱�����
			str tag
				* ���ر�ǩ����

			dict attrib
				* ��ǩ����(dict)

			str text
				* ���ر�ǩ��
				* ��ֵ����,���ñ�ǩ��
		* ����
			set(key,value)
				* ���ñ�ǩ����

			iter iter(tagname)
				* ���Ի�ȡ������ָ�����Ƶ��ӱ�ǩ(���ֲ��),���б�������
					for node in root.iter('ta'):
						text = node.text		# ��ȡ�ı��ڵ��ֵ
						node.text = "text"		# ���ýڵ��ı�
						node.set("key","value")	# ���ýڵ�����

			findall(tagname)
				* ��ȡ��ǰ�ڵ��µ�ָ�����Ƶ�����һ���ڵ�
			
			find(tagname)
				* ��ȡ��ǰ�ڵ��µ�ָ�����Ƶĵ�һ��һ���ڵ�
			
			remove(tagname)
				* �Ƴ�һ���ӽڵ�

	writr(file)
		* ��xmlд���ļ�

------------------------
xml-SAX����				|
------------------------
	from xml.parsers.expat import ParserCreate

	# �Զ��� ����Handler������
	class DefaultSaxHandler(object):
		# ��������ǩ
		def start_element(self, name, attrs):
			print('sax:start_element: %s, attrs: %s' % (name, str(attrs)))

		# 
		def end_element(self, name):
			print('sax:end_element: %s' % name)

		def char_data(self, text):
			print('sax:char_data: %s' % text)

	xml = r'''<?xml version="1.0"?>
	<ol>
		<li><a href="/python">Python</a></li>
		<li><a href="/ruby">Ruby</a></li>
	</ol>
	'''
	handler = DefaultSaxHandler()
	# ��������������
	parser = ParserCreate()
	# ��ʼ������ǩ���¼�
	parser.StartElementHandler = handler.start_element
	# ������ϱ�ǩ�¼�
	parser.EndElementHandler = handler.end_element
	# ��������ǩ���¼�
	parser.CharacterDataHandler = handler.char_data
	# ��ʼ����
	parser.Parse(xml)

------------------------
xml-demo				|
------------------------

# ����========================================
import xml.etree.ElementTree as ElementTree

file = "E:\\pom.xml"

# ����xml
xml  = ElementTree.parse(file)

# ��ȡ���ڵ�
root = xml.getroot()

# ��ȡ���ڵ������
root.tag

# �ڵ����
for child in root:
    # �ӽڵ��ǩ��,��ǩ����
    print(child.tag,child.attrib)
    for i in child:


# �޸�========================================
import xml.etree.ElementTree as ElementTree

file = "E:\\pom.xml"

# ����xml
xml  = ElementTree.parse(file)

# ��ȡ���ڵ�
root = xml.getroot()

# ��ȡ�ýڵ�������ָ�����ƵĽڵ�(���ֲ��I)
for node in root.iter('name'):
    tag = node.tag              # ��ȡ��ǩ����
    attr = node.attrib          # ��ȡ����dict
    text = node.text            # ��ȡ��ǩֵ
    node.text = "yoyo"          # ���ñ�ǩֵ
    node.set("key","value")     # ���ñ�ǩ����

# ��д
xml.write(file)

# ɾ��========================================
import xml.etree.ElementTree as ElementTree

file = "E:\\pom.xml"

# ����xml
xml  = ElementTree.parse(file)

# ��ȡ���ڵ�
root = xml.getroot()

# ��ȡ�ýڵ�������ָ�����Ƶ�һ���ڵ�
for node in root.findall('name'):
    # ����ڵ��� delete����
    if('delete' in node.attrib):
        # ɾ���ڵ� 
        root.remove(node)
        
# ��д
xml.write(file)
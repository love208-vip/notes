---------------------------
Text						|
---------------------------
	* ���ڴ������ʾ�����ı���Ϣ,Ҳ������Ϊ�򵥵��ı���Ϣ
	* ���캯��
		def __init__(self, master=None, cnf={}, **kw)

---------------------------
Text-����					|
---------------------------
	width
		* ���,��ֵ�Ǳ�ʾ��������ɵ��ַ�����
	height
		* �߶�,��ֵ��ʾ�߶ȿ������ɵ��ַ�����
	undo
		* bool ֵ,�Ƿ�֧�ֳ�������,Ĭ�� False

	maxundo
		* �����Գ����Ĵ���

	autoseparators
		* bool ֵ,Ĭ��Ϊ True
		* Tkinter ������Ϊÿһ�������Ĳ���������,�Զ��Ĳ���һ��'�ָ���'
		* ����ָ������ɼ�
		* �������Ϊ'�����ָ���',�ܶණ��(����:undo)��Ҫ��ԭ����,��������
		* ����������Ĭ�ϵķ�ʽ������'�����ָ���',��������Ϊ False,���ֶ��ĵ��� edit_separator() ���Զ���Ĳ���һ�������ָ���

---------------------------
Text-����					|
---------------------------
	insert(index,content,tags)
		* �����ı�������Ϣ,index ��һ������ֵ
		* index ��ʾ�����λ��,����ʹ��Ԥ������� INSERT/END ����ʾ,�������/����λ��
		* index Ҳ����ʹ�� mark ����ʾҪ�����λ��
		* tags,Ӧ����һ��tupe,��ʾ���õ�tag��ǩ
	
	delete(b,e)
		* ��������,ɾ��ָ��������
		* b,��ʾ��ʼ�ĵط�(����),e��ʾ�����ĵط�(������)
	
	get(b,e)
		* ����������ȡ����
		* b,��ʾ��ʼ�ĵط�(����),e��ʾ�����ĵط�(������)
	
	window_create(index,window)
		* ����һ�� window ���,��window����� master Ӧ���ǵ�ǰText��ʵ������
		* index ,ʹ��Ԥ������� INSERT/END ����ʾ,�������/����λ��
		* window �ǹؼ�������,������ֵӦ���� window �����ʵ������
		* demo
			text = Text(root)
			button = Button(text,text='��ť')				# ������ťʵ��
			text.window_create(INSERT,window=button)		# ������ťʵ����Text
			text.pack()	
	
	image_create(index,image)
		* ͬ����,����һ��ͼƬ���(PhotoImageʵ��)��Text�����
		text = Text(root)
		photo = PhotoImage(file='D:\\Ȥͼ\\QQͼƬ20161226105344.gif')	# ����image���
		text.image_create(INSERT,image=photo)							# ���ø�������ı���
	
	index(exp)
		* �÷�������������ʽת��Ϊ�����˾�������λ��ֵ
		* demo
			text = Text(root)
			text.insert(INSERT,'123456789')
			text.index("1.end")	# 1.9
	mark_set(name,index)
		* markһ��λ��,indexӦ����һ���������ʽ,ָ����/��
	mark_unset(name)
		* ɾ��ָ����mark
	mark_gravity(markName,direction)
		* ����ָ��mark������,ö��ֵ:LEFT/RIGHT
		* ������������������mark����߻����ұ�,�Լ��������ݵ�����ʽ
	
	tag_add(tag_name,b,e)
		* ���һ����ǩ,tag_nameָ���˱�ǩ������
		* b ��ʾ��ʼ������λ��,e��ʾ����������λ��(��ͷ����β)
	tag_config(tag_name.**config)
		* ����ָ����ǩ�ı���������Ϣ
	tag_lower(tag_name)
		* �ڶ��tag����ͬһ���ı���Ϣ��ʱ��
		* ����ָ������tag�����ȼ�
	tag_bind(name,event,func)
		* Ϊָ����tag���¼�
		* �ص������е�һ���������� event ����
	
	str search()
		* search(self, pattern, index, stopindex=None,forwards=None, backwards=None, exact=None, regexp=None, nocase=None, count=None, elide=None)
		* ����ָ�����ı�,���ظ��ĵ�һ�γ��ֵ�����(��.��),û���ҵ����ؿ��ַ���
		* ����
			pattern		���ʽ
			index		��ʼ�����ĵط�
		* �ؼ��ֲ���
			stopindex	ֹͣ����������ֵ
	
	edit_undo()
		* ������һ���Ĳ���,������ Text ʵ���� undo ����ֵΪ True ��ʱ�������
		* ���û�п��Գ����Ĳ�����,��ô���׳��쳣
		* �ڲ�����һ������ջ

	edit_redo()
		* �ָ�����
	
	edit_separator()
		* �ֶ��Ĳ���һ�������ָ���

---------------------------
Text-���(Marks)			|
---------------------------
	* �����һ������Ƕ�뵽Text�ı������,���ɼ��Ķ���
	* ��Ҳ��ָ���ı��ַ�֮���λ��
	* ϵͳԤ���弶���mark
		INSERT
			* ��ǰ������ڵ�λ��
		CURRENT
			* ��Ӧ�ڵ�ǰ��������λ��
	* �Զ���mark
	* mark������������ͨ���ַ������
	* ʹ�� mark_set(name,index),�������,'��ǵ�����ֵ������insert,delete�Ĳ��������޸�'
	* �����mark��ǵ�λ��֮ǰ�����ɾ���ı�,��ômark�������һ���ƶ�(mark��һֱ�̶���ĳ���ַ���϶)
	* ʹ�� insert(mark,text) ����,������ mark ���'ǰ'�����µ�����ֵ
		text.insert(INSERT,'123456789')
		text.mark_set("here","1.2")	# ������ƽ��� here,��λ�ڵ�1�еĵ�2���ַ�(2�ĺ���)
		text.insert("here","Hello")	# ��here��ʾ������λ��(1.2)������ "Hello",��������
		# 12Hello3456789
		print(text.index("here"))	# ��ʱ,here��ʾ������λ���� 1.7
	* �ܽ�
		* insert ����������λ��,��������ƶ�,ʼ�չ̶���ָ���ַ���϶,������ֵ����Ϊ������Ե�ʷ����ı�,�൱�ڰ� insert �����ݲ��뵽�����������
		* ��� insert ,���������ݻ�������Ҳ���,�������θ���ָ�����ַ���϶�ƶ�
		* delete ɾ��ͬ��,����������Զ�����϶
	
	* ��mark��Ǻ��������,'���ַ�ʽ��mark��ʾ������ֵ��һֱ�̶�'
	* ʹ�� insert(mark,text) ����,������ mark ���'��'�����µ�����ֵ
	* ʹ�� mark_gravity(markName, direction=None) ����,���Կ����������ֵķ���,Ĭ���� RIGHT
		text.insert(INSERT,'123456789')
		text.mark_set("here","1.2")			# ������ƽ��� here,��λ�ڵ�1�еĵ�2���ַ�(2�ĺ���)
		text.mark_gravity("here",LEFT)		# ָ�� here ���,�ڱ�insertִ�в���ʱ,�����ַ�,���뵽 LEFT/RIGHT
		text.insert("here","YU")			# ��here��ʾ������λ��(1.2)������ "Hello",���������ƶ�
		# 12YU3456789
		print(text.index("here"))			# ��ʱ,here��ʾ������λ���� 1.2
		text.insert("here","YU")			# ��here��ʾ������λ��(1.2)������ "WEN"
		# 12WENYU3456789
		print(text.index("here"))			# ��ʱ,here��ʾ������λ���� 1.2
	* insert ����������λ��,�����ı�����뵽����λ�õ��ұ�(ȡ����mark_gravity �ĵڶ�������),�� mark ��ʾ������ֵ���ᷢ���ı�
	* ��� insert ,������������ݴ����������
	* delete ͬ��
	
	* ɾ��mark
		mark_unset(name)

---------------------------
Text-��ǩ(Tags	)			|
---------------------------
	* Tagsͨ�����ڸı�Text��������ݵ���ʽ�͹���
	* �����޸��ı�������,��ɫ,�ߴ�
	* ��������ı�,Ƕ��������ͼƬ����̵ĺ������¼�����
	* ���� user-definded tags(�û��Զ���tag),����һ��Ԥ��������� Tag:SEL
	* SEL('sel'),���ڱ�ʾ��Ӧѡ�е�����(����еĻ�)
	* �Զ���tag,tag��������ͨ�Ϸ����ַ���,֧��һ�����������tag,�κ�tagҲ�����������������ͬ���ı�����
		tag_add(tag_name,b,e)
	* ���ñ�ǩ�ı�������
		tag_config(tag_name,**config)
	* demo	
		text.insert(END,"123456789")
		# ѡ���� 12 �� 5 ȡ��ǩ����:tag1
		text.tag_add('tag1',1.0,1.2,1.4,1.5)		
		# ��tag1��ǩ��ʾ���ַ����������޸�,���ñ���ɫ��������ɫ
		text.tag_config('tag1',background='blue',foreground='red')

	* Ҳ������Ԥ����tag����,Ȼ���ڲ����ʱ���������
		# Ԥ����tag����
		text.tag_config('my_tag1',background='blue',foreground='red')
		# �ڲ����ı���ʱ��,ʹ������,ע��,tags������һ�� tuple,��ʾ���Դ��ݶ����ǩ����
		text.insert(INSERT,"Hello",("my_tag1",))
		
	* ͬһ���ı�,�ж��tag,��ô�������ͬ��tag��ʽ�Ḳ��ǰ���
	* ʹ�� tag_lower(tag_name),��������tagװ��һ�ζ��ı���ʱ��,tag���Ե����ȼ�
		tag_lower('my')

	* ֧���¼���,text.tag_bind()
		text.insert(END,"Javaweb���������� - ")

		# ����һ��tag,ǰ��ɫΪ��ɫ,�߱��»���
		text.tag_config('url',foreground='blue',underline=True)

		# �ڲ���URL��ʱ��,ָ��tag
		text.insert(END,'http://javaweb.io',('url',))

		# Ϊtag������¼�
		text.tag_bind('url','<Enter>',lambda e,t=text:t.config(cursor='arrow'))  # ���ָ��->��Ϊ��ͷ
		text.tag_bind('url','<Leave>',lambda e,t=text:t.config(cursor='xterm'))  # ���һ��->��Ϊ������
		# Ϊtag�󶨵���¼�
		text.tag_bind('url','<Button-1>',lambda e,:webbrowser.open('http://javaweb.io'))# ͨ�� webbrowser ��ָ����url����

		text.pack()
		

---------------------------
Text-����(Indexs)			|
---------------------------
	* Indexs������ָ��Text������ı���λ��,���������Ҳ�Ƕ�Ӧʵ���ַ�֮���λ��
	* Tkinter�ṩһϵ�в�ͬ����������
		"{line}.{column}"
			* ��/��(�кŴ�1��ʼ,�к����Ǵ�0��ʼ)
			* get("1.0","1.3"):��1�е�0���ַ���ʼ��1�е�3���ַ�����
			* Ҳ����ֱ��ʹ�ø����� get(1.0,1.3)
		"{line}.end"
			* ĳ��ĩβ
			* get(1.0,"1.end")
		INSERT
			* ��ֵ��ʾ������ڵ�λ��
		CURRENT
			* ��Ӧ�ڵ�ǰ��������λ��
		END
			* �ı���ĩβ����һ��λ��
		user-defined marks
		user-defined tags("tag.first","tag.last")
		window coordinate("@x.y")
		embedded object name(window,images)
		expressions
			* ����'�޸�'�κθ�ʽ������,���ַ�������ʽʵ���޸������ı��ʽ
			"+ count chars"
				* ��������ǰ ->�ƶ� count ���ַ�,����Խ������,���ǲ���Խ��END
			"- count chars"
				* ��������� <-�ƶ� count ���ַ�,����Խ������,���ǲ���Խ��1.0
			"+ count lines"
				* ��������ǰ�ƶ� count ��,�����ᾡ����֤��ͬһ����,�����һ�е�����̫��,������ֱ���Ƶ�ĩβ
			"- count lines"
				* ����������ƶ� count ��,�����ᾡ����֤��ͬһ����,�����һ�е�����̫��,������ֱ���Ƶ�ĩβ
			" linestart"
				* �������ƶ�����ǰ�����ڵĵ�һ��λ��,ע��,�ñ��ʽǰ���и��ո�
			" lineend"
				* �������ƶ�����ǰ�����ڵ����һ��λ��,ע��,�ñ��ʽǰ����и��ո�
			"wordstart"
				* �������ƶ�����ǰ�������ڵĵ��ʵĿ�ͷ
				* ���ʵĶ���:��ĸ,����,�»���,�κηǿհ��ַ������
			"wordend"
				* �������ƶ�����ǰ�������ڵĵ��ʵ�ĩβ
				* ���ʵĶ���:��ĸ,����,�»���,�κηǿհ��ַ������

	

---------------------------
Text-demo					|
---------------------------
	# ȫ�ļ���,��ȡָ�����������е�����Index
	text.insert(END,"Javaweb����������")
	def find():
		# ���忪ʼ������λ��,�ӵ�һ�еĵ�һ�п�ʼ����
		start = "1.0"
		while True:
			# ����ָ�����ݵ�һ�γ��ֵ�λ��
			pos = text.search("a", start, stopindex=END)
			if not pos: # û���ҵ�,���˳�
				break
			# ��ӡλ��
			print(pos)
			# �޸Ŀ�ʼ��ʼ������λ��,��ǰ�ƶ�һ���ַ�
			start = pos +"+ 1 chars"
	button = Button(root,text='�˳�',command=find)

	text.pack()
	button.pack()


	# �ڳ���������,һ��ֻ����һ���ַ�
	# autoseparators ����ΪFals,Ŀ����Ϊ���������Լ�����������ָ���
	text = Text(root,undo=True,autoseparators=False,maxundo=10)

	# �󶨰�������,��ÿһ��������ʱ��,�Ͳ���һ����������
	text.bind('<Key>',lambda e:text.edit_separator())

	text.insert(END,"Javaweb����������")

	# ����ť,ÿ�ε���ͷ�����һ��'����'
	button = Button(root,text='����',command=lambda x=text:x.edit_undo())

	text.pack()
	button.pack()
------------------
Label				|
------------------
	* ��ǩ,��ʵ���Ǵ��������Ϣ��һ������
	* ������ʾ��Ϣ
		label = Label(root,text='�������Ҫ��ʾ��������Ϣ')
	
	* ���캯��
		 def __init__(self, master=None, cnf={}, **kw)
			* master
				* ָ������
			*cnf
				* ���ڿ���ʵ����һЩ����
	
	* demo
		from tkinter import Tk,Label
		root = Tk()
		lable = Label(root,text='����',background='blue')
		lable.pack()
		root.mainloop()
	

------------------
Label-����			|
------------------
	text
		* ��ʾ���ı���Ϣ
	textvariable
		* ��ʾ���ı���Ϣ,�������ȼ��� text ���Ը�
		* ��ֵ�Ķ���Ӧ����һ�� tkvar ʵ������,ֱ�ӵ��øö����api,�����޸�����(ֱ���޸�Label�� text����Ҳ�����޸�)
	background
		* ����ɫ
	fg
		* ���ֵ���ɫ
	image
		* ָ�� PhotoImage ʵ������,������ʾͼƬ��Ϣ
		* text,������Ϣ�ᱻ���Ե�
	justify
		* ���ö���ʱ,���ֵĶ��뷽ʽ: left, right, or center
	cpmpound
		* ����ͼ�Ļ���
		* ��ѡֵ:LEFT, TOP, RIGHT, BOTTOM, CENTER(��ʾͼƬ��Ϊ����)
	font
		* ��������,��ֵ������һ�� tuple,����һ���Ե����� ����ʹ�С
		* font=('΢���ź�',25)


------------------
Label-����			|
------------------



------------------------
Scrollbar				|
------------------------
	* ���������
	* ������������ᵥ����ʹ��,����������������һ��ʹ�õ�
	* ���캯��
		 def __init__(self, master=None, cnf={}, **kw)
	* ʹ�ù������Ĳ���
		1,����������ʵ��
		2,����ʹ�ù���������������� yscrollcommand/xscrollcommand ����
			* �����Ե�ֵӦ����,������ʵ���� set ����
		3,ͨ��������ʵ���� config ����,���Թ�������������
			* command �ؼ��ֲ�����ֵӦ����,�ܹ��������Ƶ����ʵ���� yview ʵ������

------------------------
Scrollbar-����			|
------------------------

------------------------
Scrollbar-����			|
------------------------
	set(first, last)

	config()
		
------------------------
Scrollbar-demo			|
------------------------

from tkinter import *

root = Tk()

# 1,����������ʵ��,pack���ֿ���y���������
scrollbar = Scrollbar(root)
scrollbar.pack(side=RIGHT,fill=Y)

# 2,����ʹ�ù���������������� yscrollcommand/xscrollcommand ����
# �����Ե�ֵӦ����,������ʵ���� set ����
listbox = Listbox(root,selectmode=EXTENDED,yscrollcommand=scrollbar.set)

for i in range(20):
    listbox.insert(END,i)

# 3,ͨ��������ʵ���� config ����,���Թ�������������,
# command �ؼ��ֲ�����ֵӦ����,�ܹ��������Ƶ����ʵ���� yview ʵ������
scrollbar.config(command=listbox.yview)

listbox.pack()

root.mainloop()

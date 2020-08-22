----------------------------
oop	- ����					|
----------------------------
	* ˵��˵ȥ���ĸ�����
		getattr(obj,attr)
		getattr(obj,attr,default)
		hasattr(obj,attr)
		setattr(obj,attr,value)
		delattr(obj,attr)
	
	* ��Щ�������ɽ������Է����������,Ҳ���Բ���ģ��
		
	

----------------------------
oop	- Demo						|
----------------------------

class Foo():
    def __init__(self):
        self.name = 'Kevin'
        self.age = 23
    
    def say(self):
        print("���,����%s"%(self.name))
    

foo = Foo()
print(hasattr(foo, 'say'))  # true
print(hasattr(foo, 'name')) # true
say = getattr(foo, 'say')
say()                       # ���,����Kevin
none = getattr(foo, 'none','Ĭ��ֵ')
print(none)                 # Ĭ��ֵ

def func(var):
    print(var)
    
setattr(foo, 'getX', func)
foo.getX('��̬��ӵķ���')     # ��̬��ӵķ��� # Ĭ��ֵ
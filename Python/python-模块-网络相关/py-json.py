------------------------
json					|
------------------------
	* JSON�������
	* json����֧�ֵĻ���������
		None
			None�ᱻӳ��Ϊnull
		bool
			True �ᱻӳ��Ϊ true,False �ᱻӳ��Ϊ false
		int
		float
		string
		list
		tuple 
			Ԫ��()�ᱻӳ��Ϊ�б�[]

		dict
			�����ֵ�,json�����key���ַ���(�ֵ��е��κη��ַ���key�����ڱ���ʱת��Ϊ�ַ���)
			Ҫ����JSON�淶Ӧ��ֻ��python�б���ֵ���б���.����,��WEBӦ����,����������Ϊ�ֵ���һ�ֱ�׼����
	
	* �������Ͷ��ձ�
		Python		JSON
		dict		object
		list,tuple	array
		str			string
		int,float,int- & float-derived Enums	number
		True		true
		False		false
		None		null
	
	* �������Ͷ��ձ�
		object		dict
		array		list
		string		str
		number		(int)	int
		number		(real)	float
		true		True
		false		False
		null		None

------------------------
json-ģ������			|
------------------------
	
------------------------
json-ģ�麯��			|
------------------------
	str dumps(obj)
		* �ѿ�JSON���л�����ת��ΪJSON�ַ���
		* �ؼ��ֲ���
			default
				* ָ�� ת�� obj ����ʱ,��ת������
				* ���������һ�����ܽ���JSONת���Ķ���,��ô�ͻ���� default ָ���ĺ���������ת������,���ؽṹ���Ǹú������ص��ַ���
				* ���һ�� obj ���󴫵ݸ��ú����ĵ�һ������
			ensure_ascii
				* Ĭ��ֵ True,�Ƿ������ת��Ϊ Unicode ����

	
	str dump(obj,f)
		* �ѿ�JSON���л�����ת��ΪJSON�ַ���,����д�� f(open��ȡ) �ļ�
		* �ؼ��ֲ���
			default
				* ͬ��
			ensure_ascii
				* ͬ��

	dict loads(jsonstr)
		* ��JSON�ַ���ת��ΪPython�����ݽṹ
		* �ؼ��ֲ���
			object_hook
				* �����ֵ��Ϊ None,��ô�ͻ��JSON����(dict)���ݸ��ú���,�ɸú�������JSON�ķ����л�
				* ���ڸ��ӵķ����л�����ʹ��,����:�����л�Ϊ�Զ���Ķ���

	dict load(filePath)
		* ��ָ���ļ��ж�ȡ����,ת��ΪPython�����ݽṹ
		* �ؼ��ֲ���
			object_hook
				* ͬ��


------------------------
json-demjson			|
------------------------
	* ���JSON�ַ�����key��û�д�˫���ŵ�,�����ǵ����ŵ�,��ô�п��ܻ������л�ΪJSON��ʱ���׳��쳣
	* ����취����ʹ�õ������� demjson
		pip install demjson
		import demjson
		json_obj = demjson.decode("{name:\"KeviinBlandy\"}")

------------------------
json-demo				|
------------------------
# �Զ��������JSON֮���ת��
import json
class Obj():
    def __init__(self,name,age):
        self.name = name
        self.age = age
    
    def __str__(self):
        return "[name=%s,age=%s]"%(self.name,self.age)

    @classmethod
    def toJson(cls,obj):
        return {'name':obj.name,'age':obj.age};
    
    @classmethod
    def toObj(cls,json):
        # ֱ�ӷ���JSON�е������ֶ�,��ʱJSON��ʵ���Ǹ� dict
        return  Obj(json['name'],json['age']);

json_str = json.dumps(Obj('KevinBlandy',23),default=Obj.toJson) 
print("���л�:%s"%(json_str))      # ���л�:{"name": "KevinBlandy", "age": 23}

obj = json.loads(json_str,object_hook=Obj.toObj)
print("�����л�:%s"%(obj))          # �����л�:[name=KevinBlandy,age=23]

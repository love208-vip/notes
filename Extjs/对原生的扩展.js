------------------------
��ԭ������չ			|
------------------------
	# Ext��ԭ����JS���������һЩ�е���չ
	# ��չ������Ŀ¼
		src/core/src/lang
			Array.js
			Date.js
			Error.js
			Function.js
			Number.js
			Object.js
			String.js

--------------------------
Object						|
--------------------------
	# Ext.Object
	# ����
		chain
			* ����һ������,��õ�һ������.����µĶ���ԭ�;��Ǵ��������������

		each
			* ���õĵ�������,����һ������,����falseֹͣ����
				var person = {
					name: 'Jacky'
					hairColor: 'black'
					loves: ['food', 'sleeping', 'wife']
				};
				Ext.Object.each(person, function(key, value, myself) {
					console.log(key + ":" + value);
					if (key === 'hairColor') {
						return false; // ֹͣ����
					}
				});

		fromQueryString
			* ��URL����������һ������
			  var query = "name=kevin&age=22";
			  va obj =  Ext.Object.fromQueryString(query);//{name:'Kevin',age:'22'}
		
		toQueryString
			* ��һ������,ת��ΪURL����
			* ��ʵ���ǰ�һ������,�������������.��ת����GET�����еĲ���

		getKey
			* ����ָ����ֵ,����ָ����key
				var person = {
					name: 'Jacky',
					loves: 'food'
				};
				alert(Ext.Object.getKey(person, 'food')); // �������� 'loves'

		getKeys
			* ��ȡָ�����������������

		getSize
			
		getValues
			* ��ȡָ���������������ֵ

		merge
			
		toQueryObjects
			* 

	

------------------------
Number					|
------------------------
	# Ext.Number
	# ����
		Ext.Number.constrain(number,min,max);
			* ��� number �Ƿ��� max �� min ֮��,��������֮���򷵻ظ�ֵ
			* ���С���򷵻� min,��������򷵻� max
		
		Ext.Number.randomInt(form,to);
			* �������һ������,��ֵ ���� form,С�� to
		
		Ext.Number.toFixed(num,length);
			* ��num����ȡ��,�ᱣ�� lengthλ���ȵ�С����
			* �������������
		
	
------------------------
String					|
------------------------
	# Ext.String
	# ����
		Ext.String.capitalize(str);
			* ��������ĸ��д
		
		Ext.String.ellipsis(str,num);
			* ����strǰ num ���ַ�,����������������"..."
		
		Ext.String.trim(str);
			* ȥ���ַ������˵Ŀո�
		
	
------------------------
Array					|
------------------------
	# Ext.Array
	# ����
		Ext.Array.clean(arr);
			* ���˵�arr�еĿ�ֵ
			* ��ֵ�Ķ���� Ext.isEmpty
		
		Ext.clone
			* ��¡
		
		contains(arr,obj);
			* �ж�obj�Ƿ���arr��
		

	
		
	
------------------------
Function				|
------------------------

	
------------------------
Date					|
------------------------

	
------------------------
Error					|
------------------------




		



	
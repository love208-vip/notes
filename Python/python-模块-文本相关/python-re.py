------------------------
re						|
------------------------
	* ������ʽ
	* ���ڶ��ַ����Ĳ���
	* �� string ���漰������Ĳ���
		replace(reg,new)	# �滻
		find(reg,start,end)	# ����
		rfind(reg,start,end)# ����
		split(reg,coun)		# �и�
	* ���� string ���������������� api ����,��������Ҫ����̵�ƥ��,����Ҫʹ��  re ģ��
	* ������ϵ
		һ,ֱ��ʹ��reģ�麯�����������������
			* ��ģ�麯��

		��,�����������(pattern)�������������(Ч�ʱȽϸ�)
			1,��ȡ���������(pattern)
				_sre.SRE_Pattern compile(pattern,flags)
				var pattern = compile('')

			2,����ƥ��,��������
				_sre.SRE_Match match(str,start,end)
				_sre.SRE_Match search(str,start,end)
				callable_iterator finditer(str,start,end)
				...
			
			3,�ӽ�� _sre.SRE_Match �л�ȡ����
			

			
------------------------
re-��������				|
------------------------

------------------------
re-ģ�鼶����			|
------------------------
	list findall(pattern, string, flags)
		* ʹ�� pattern ���ʽȥƥ��� string �е����з��Ϲ����Ԫ��
		* flags,����ָ��ƥ��ģʽ,Ĭ��ֵΪ 0
		
	list split(pattern, string)
		* �ָ�
	
	str sub(pattern,repl,string,count=0,flags=0)
		* ����,Ŀ���ַ���,�滻ֵ,�滻���ٴ�

	callable_iterator finditer(pattern, string, flags)
		* ʹ�� pattern ���ʽȥƥ��� string �е����з��Ϲ����Ԫ��,���ص�����
	
	_sre.SRE_Match search(pattern, string, flags)
		* ���� string ��һ������ pattern ���Ӵ���,ƥ��ʧ��,���� None

	_sre.SRE_Match match(pattern, string, flags)
		* �ж� string �Ƿ���� pattern,���Ϸ��� _sre.SRE_Match ,���򷵻� None
		* '����ƥ�俪ͷ,ƥ��ɹ���,string����ʣ���ַ�,Ҳ��Ϊƥ��ɹ�'

	_sre.SRE_Pattern compile(pattern,flags)
		* ��һ���ַ�������� pattern ��������ƥ�������

------------------------
_sre.SRE_Pattern ����	|
------------------------
	_sre.SRE_Match match(str,start,end)
		* ƥ�� str �ַ���,ƥ��ɹ�,���� _sre.SRE_Match ����,ƥ��ʧ�ܷ��� None
		* start,end Ĭ��ֵΪ�ַ����ĵ�һ�����һ��
	
	_sre.SRE_Match search(str,start,end)
		* ���� str �ַ���,ƥ�䵽�ĵ�һ��ֵ,ƥ��ʧ�ܷ��� None
		* start,end Ĭ��ֵΪ�ַ����ĵ�һ�����һ��
		* '����ƥ�俪ͷ,ƥ��ɹ���,string����ʣ���ַ�,Ҳ��Ϊƥ��ɹ�'
	
	list findall(str,start,end)
		* ���� str �ַ���,ƥ�䵽������ֵ
		* start,end Ĭ��ֵΪ�ַ����ĵ�һ�����һ��
	
	callable_iterator finditer(str,start,end)
		* ���� str �ַ���,ƥ�䵽������ֵ,���ص���һ��������
		* start,end Ĭ��ֵΪ�ַ����ĵ�һ�����һ��

------------------------
_sre.SRE_Match ����		|
------------------------

	str group(num)
		* ���� match object �е��ַ���.
		* ÿһ�� ( ) ����һ������,�����Ŵ�1��ʼ,��������,ÿ����һ��������,������+1
		* �� 0 ���Ǵ��ڵ�,�������������ʽ(ԭ�ַ���)
		* û�в���ʱ,numĬ��Ϊ0��ʱ��������ƥ�䵽���ַ���
		* ָ��һ������(����)ʱ,���ظ÷���ƥ�䵽���ַ���
		* ָ���������ʱ,�������Ǽ�������ƥ�䵽���ַ�����ɵ� tuple
	
	tuple groups()
		* ��ȡ�����е�ƥ����
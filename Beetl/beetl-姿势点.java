-----------------------
Beetl-Ŀ¼				|
-----------------------
	1,�����÷�
	2,�߼�����
	3,WEB����
	5,��¼

-----------------------
Beetl-�����÷�			|
-----------------------
	# ģ����Դ������
		* �ַ���ģ����Դ������
		* �ļ���Դģ�������
		* Classpath��Դģ�������
		* WebApp��Դģ�������
		* �Զ�����Դģ�������
	
	# �������ռλ��
	# ע��
	# ��ʱ��������
	# ȫ�ֱ�������
	# �������
	# ģ�����	
	# ��������
	# ���Ը�ֵ
	# �������ʽ
	# �߼����ʽ
	# ѭ�����
		* for-in
		* for(exp;exp;exp)
		* while
		* else for
	# �������
		* if else
		* switch-calse
		* select-case
	# try-catch
	# ��������
	# ��������
	# ��ȫ���
		* �����Ƿ����
		* ��ȫ������ʽ
	# ��ʽ��
	# ��ǩ����			
	# HTML��ǩ		
	# �󶨱�����HTML��ǩ 
	# ֱ�ӵ���JAVA����������
	# �ϸ�MVC����
	# ָ��
	# ��������
	# ������
	# beetlС����
	# ���鹦��

-----------------------
Beetl-�߼�����			|
-----------------------
	# ���� GroupTemplate
	# �Զ��巽��
		* ʵ��Function
		* ʹ����ͨJAVA��
		* ʹ��ģ���ļ���Ϊ����
	# �Զ����ʽ������
	# �Զ����ǩ			
		* ��ǩ����			
	# �Զ�����������
	# ʹ�ö������Դ������
	# �Զ�����Դ������		'��'
	# ʹ��CompositeResourceLoader	'��'
	# �Զ����������		'��'
	# �Զ��尲ȫ������		'��'
	# ע��ȫ�ֹ������
	# ����					
	# �����Ż�
	# �ֲ�ʽ����ģ��		'��'
	# �������				'��'
	# ����ģ������			'��'
	# ֱ������Beetl�ű�		'��'

-----------------------
Beetl-WEB����			|
-----------------------
	# Web�ṩȫ�ֱ���
	# ���ɼ�������ָ��
	# Servlet����
	# Springmvc����
	# Spring boot����
	# jodd����
	# Jfinal3.0&Jfinal2.0���ɷ���
	# Nutz����
	# Struts2����
	# ֱ��WEB������Beetlģ��
	# ����Ajx�ľֲ���Ⱦ����
	# ��ҳ�����������ʾ��Ϣ


-----------------------
Beetl-��¼				|
-----------------------


-----------------------
Beetl-�������÷���		|
-----------------------
	# ���õ�
		date 
			* ����һ��java.util.Date���͵ı������� date() ����һ����ǰʱ��(��Ӧjava��java.util.Date);
			* ${date( "2011-1-1" , "yyyy-MM-dd" )} ����ָ������
		print 
			* ��ӡһ������ print(user.name);
		println 
			* ��ӡһ�������Լ��س����з��ţ��س����ŷ���ʹ�õ���ģ�屾��ģ������Ǳ���ϵͳ��.
			* ���������ӡһ�����з�����ֱ�ӵ���println() ����
		nvl 
			* ����nvl���������Ϊnull���򷵻صڶ������������򣬷����Լ� nvl(user,"������")
		isEmpty 
			* �жϱ������߱��ʽ�Ƿ�Ϊ�գ����������ڣ�����Ϊnull�������ǿ��ַ����������ǿռ��ϣ������ǿ����飬�˺�����������true
		isNotEmpty 
			* ͬ�ϣ��ж϶����Ƿ�Ϊ��
		has 
			* ������Ϊ�������ж��Ƿ���ڴ�ȫ�ֱ������� has(userList),������1.x�汾��exist("userList"),������Ҫ����������
		assert 
			* ������ʽΪfalse�����׳��쳣
		trunc 
			* ��ȡ���֣�����ָ����С��λ����trunc(12.456,2) �����12.45
		decode	
			* һ���򻯵�if else �ṹ��
			* decode(a,1,"a=1",2,"a=2","��֪����")},
			* ���a��1����decode���"a=1",���a��2�������"a==2", ���������ֵ�������"��֪����"
			* ��һ��ֵΪԭʼֵ,����ż��λ�Ķ��ǱȽ�ֵ,����λ����ǰż��ƥ�������ֵ
		debug 
			* �ڿ���̨���debugָ���Ķ����Լ�����ģ���ļ��Լ�ģ���е�������
			* ��debug(1),�����1 [��3��@/org/beetl/core/lab/hello.txt],
			* Ҳ��������������debug("hi",a),�����hi,a=123,[��3��@/org/beetl/core/lab/hello.txt]
		parseInt 
			* �����ֻ����ַ�����Ϊ���� �� parseInt("123");
		parseLong 
			* �����ֻ����ַ�����Ϊ�����Σ�parseInt(123.12);
		parseDouble 
			* �����ֻ����ַ�����Ϊ�������� ��parseDouble("1.23")
		range 
			* ����������������ʼֵ������ֵ�����в��������Բ���Ҫ����Ĭ��Ϊ1����
			* ����һ��Iterator��������ѭ����
				for(var i in range(1,5)) {
					print(i)			//�����δ�ӡ1234.
				}
		flush 
			* ǿ��io�����

		json
			* ������ת��json�ַ������� var data = json(userList) 
			* ���Ը�һ�����л����� ��,var data = json(userList,"[*].id:i"),
			* ����ο� https://git.oschina.net/xiandafu/beetl-json

		pageCtx
			* ������web�����У�����һ��������Ȼ�������ҳ����Ⱦ�����У����ô�api��ȡ��
			* ��pageCtx("title","�û����ҳ��")��������κεط�������pageCtx("title") ��ȡ�ñ���

		type.new 
			* ����һ������ʵ������ var user = type.new("com.xx.User"); 
			* ���������IMPORT_PACKAGE�������ʡ�԰�����type.new("User")

		type.name 
			* ����һ��ʵ��������
			* var userClassName = type.name(user),����"User"
	# �ַ������
		strutil.startWith 
			* �ַ����Ƿ���Ϊָ�����ַ�����ͷ
			* ${ strutil.startWith("hello","he")} �����true
		strutil.endWith 
			* �ַ����Ƿ���ָ�����ַ�����β
			* ${ strutil.endWith("hello","o")} �����true
		strutil.length 
			* ��ȡ�ַ����ĳ���
			* ${ strutil. length ("hello")},�����5
		strutil.subString
			* �ַ����и�,�ӵڼ�λ�������Ϊ
			*  ${ strutil.subString ("hello",1)},����ǡ�ello��
		strutil.subStringTo $
			* �ַ����и�,�ӵڼ�λ���ڼ�λ
			* { strutil.subStringTo ("hello",1,2)},����ǡ�e��
		strutil.split 
			* ��һ���ַ���,��ɶΪ��������з�
			* ${ strutil.split ("hello,joeli",",")},��������飬������Ԫ�أ���һ����hello���ڶ�����joelli��
		strutil.contain 
			* �ж�ָ���ַ����Ƿ�����ַ�
			* ${ strutil.contain ("hello","el")},�����true
		strutil.toUpperCase 
			* ��дת��
			* ${ strutil.toUpperCase ("hello")},�����HELLO
		strutil.toLowerCase 
			* Сдת��
			* ${ strutil.toLowerCase ("Hello")},�����hello
		strutil.replace 
			* �滻,��һ��������ԭʼ�ַ���,�ڶ������滻Ŀ��,�������������
			* ${ strutil.replace ("Hello","lo","loooo")},�����helloooo
		strutil.format 
			* ��ʽ�� MessageFormat ,����û?
			* ${ strutil.format ("hello,{0}, my age is {1}","joeli",15)},�����hello,joelli, my age is 15. 

	# ������ط���
		...�Լ�������
	
	# ������ʽ��ط���
		reg.match(str,regex) 
			* strΪ��Ҫ������ַ�����regex�Ǳ��ʽ
		reg.replace(str,regex,replace)
			* strΪ��Ҫ������ַ�����regex�Ǳ��ʽ���滻���ַ����滻�ַ���
		reg.find(str,regex) 
			* �����ҵ��ķ��ϱ��ʽ�ĵ�һ���ַ��������򷵻ؿ��ַ���
		reg.findList(str,regex) 
			* �ҵ����з��ϱ��ʽ���ַ��������򷵻ؿ��б�
		reg.split(str,regex)
			* ���ַ��������з֣������б�
		reg.split(str,regex,limit)
			* ͬ�ϣ�limit����෵�ظ���
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
	* ������Ϊ�������ж��Ƿ���ڴ�'ȫ�ֱ���'���� has(userList),������1.x�汾��exist("userList"),������Ҫ����������

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
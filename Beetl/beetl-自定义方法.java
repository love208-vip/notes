----------------------------
Beetl-ʵ��Function			|
----------------------------
	# ʵ�� Function
		* org.beetl.core.Function

	# ��Beetl��,�Զ��� fun,����Ϊ�������ڵ�

	# ��д����
		* public Object call(Object[] paras, Context ctx)
	
	# call����Ҫ�󷵻�һ��Object������޷��أ�����null����
		* Ϊ�˱��������жϣ�call������÷���һ���������
		* ��date�������صľ���java.util.Date

	# call��������κ��쳣Ӧ���׳���Runtime�쳣

	# �߱���������
		Object[] paras
			* ��ģ�洫��Ĳ���

		Context ctx
			* ģ��������
	
	# Context ����
		
		byteWriter		�����
		template		ģ�屾��
		gt				GroupTemplate
		globalVar		��ģ���Ӧ��ȫ�ֱ���
		byteOutputMode	ģ������ģʽ�����ֽڻ����ַ�
		safeOutput		ģ�嵱ǰ�Ƿ��ڰ�ȫ���ģʽ
		* �������Խ��鲻��Ϥ�Ŀ�����Ա��Ҫ�Ҷ�
	
	# ����
		FN.methodName = xxx.xx.xxx.x
		* ��ģ����ͨ�� methodName(); ����ɵ��� 
	
----------------------------
Beetl-ʹ����ͨJAVA��		|
----------------------------
	# ����ʵ��Function����ģ��������˵����Ч����ߵķ�ʽ
	# �����ǵ��ܶ�ϵͳֻ��util�࣬��Щ����ķ�����Ȼ����ע��Ϊģ�庯����
	# �����ܼ򵥣�����'���������public����������軹ҪContext ����������Ҫ�ڷ������һ����������Context����'
		public class util{
			public String print(Object a, Context ctx){
					//balabala...
			}
		}

	# ע��
		* ��beetlЧ�ʽǶ�������������ͨ��Ч�ʲ���ʵ��Function����
		* ���õ���ͨjava�ྡ����ͬ������������Ч�ʸ��͡�beetl���õ���һ���ʺϵ�ͬ��������������java�����ҵ���ƥ���
		* ������֧�ֿɱ�������Ϊ����
		* ���������һ�����������Context����beetl�ᴫ�����������
	
	# ����
		FNP.nameSpace = xxx.xxx.xxx.xx
		* ��ģ����ͨ�� nameSpace.������(����); ����ɵ���

----------------------------
Beetl-ʹ��ģ���ļ�			|
----------------------------
	# ���Բ���дjava���룬ģ���ļ�Ҳ����Ϊһ��������
	# Ĭ������£���Ҫ��ģ���ļ��ŵ�Root��functionsĿ¼�£�����չ��Ϊ.html(���������ļ��������޸Ĵ���Ĭ��ֵ) ���������ֱ���para0,para1��..
	# ����root/functions/page.fn

		<%
			//para0,para1 �ɺ������ô���
			var current = para0,total = para1,style=para2!'simple'
		%>
		��ǰҳ�� ${current},�ܹ�${total}
		����ģ����
		<%
			page(current,total);
		%>

		����ʹ��return ���ʽ����һ�������������ߣ���ģ���ļ�functions\now.html

		<%
			return date();
		%>
		���κ�ģ���ﶼ���Ե��ã�
		hello time is ${now(),'yyyy-MM-dd'}
		Ҳ������functions������Ŀ¼������function�����namespace����ֵ�����ļ�����
		
����������������������������������������������������������������
һ,Action��Ҫ���յĶ���			|
����������������������������������������������������������������
1,ʵ��һ��Action��õķ�ʽ
	> ��Action�ӿڼ̳�
	> ��ActionSupport�̳�[����]
	> POJO��(û��ʵ�ֻ�̳����κν��,�����)
2,DMI��̬��������
	> !�ŵ���,����Ҫ�ǵ���xml�����ó���
3,ͨ���
	> *_*,{1},{2}!����˵
4,���ղ����ķ���
	> һ��������,����DomainModel������
	> ����һ��ʵ�ַ��ͽӿ�...
5,�򵥵Ĳ�����֤
	> addFieldError
	> һ�㲻��struts2��UI��ǩ
6,����WEBԪ��
	> ��ȡ�Ĵ�������Map�������ַ�ʽ
	* IOC	--	ͨ��ActionContext�õ�
	* ������Struts2���	--	ͨ��ʵ�ֽӿ�ע��
	> ֱ�ӻ�ȡ�Ĵ�����������
	* IOC	--	ͨ��ServletActionContext
	* ������Struts2���	--	ͨ��ʵ�ֽӿ�ע��
7,�����ļ�����	
	> <include ...>��ǩ,����˵
8,Ĭ��Action����
	> <default-action-ref name="Action����"></default-action-ref>

����������������������������������������������������������������
��,Action����Ԥ����������		|
����������������������������������������������������������������
	��Action�ӿ��ж����������,�Լ�һ��execute();���󷽷�
	SUCCESS	=	"success";	//���ݴ���ɹ�
	NONE	=	"none";		//ҳ�治��ת,retuen null;Ч����һ��!
	ERROR	=	"error";	//���ݴ���������(����ҳ��)
	INPUT	=	"input";	//�û�������������,ͨ�����ڱ�����У��
	LOGIN	=	"login";	//��ҪȨ����֤(��¼ҳ��)

����������������������������������������������������������������
��,ActionSupport��				|
����������������������������������������������������������������
	�̳����,��ʹ�õ�����!
	Action������,ʵ����һ��ѵĽӿ�,Ҳ������һ��ѵķ���
		Action
		Validateable
		ValidationAware
		TextPorvider
		LocaleProbvider
		Serializale
	> ֧��У��,֧�ֹ��ʻ�,��ȡ���ʻ���Ϣ

����������������������������������������������������������������
��,Action���,���ʷ�ʽ				|
����������������������������������������������������������������
	��ν�Ķ�̬�����ĵ���,�˿���Ӧ�û���һ��
	BaseServlet  ��û�У����Ӻ�����ϲ���,Ҳ���Ƿ�����
	��ʵ��struts2��,����һ��Action�ķ��������ַ�ʽ
һ,
		<action name="demo" class="com.kevin.demo.Demo" method="fun1" >
			<result name="success">/index.jsp</result>
		</action>
		> ��method ��ָ����Ҫ���õķ�������
		> ��ô�������ֱ�ӷ������Action,��Ĭ�ϵ���fun1();����
		> http://localhost:808/WEB/demo.action

	��̬��������
	���Action�д��ڶ��������ʱ��,���ǿ���ʹ��[!������]������ָ���ķ���,

	public class Demo
	{
		public String fun1()
		{
			return "���ǵ�һ������";
		}
		public String fun2()
		{
			return "���ǵڶ�������";
		}
	}
	
	����,�����Action�ķ���URL·��Ϊ:http://localhost:808/WEB/demo.action
		> ����fun1()
		* http://localhost:808/WEB/demo!fun1.action
		> ����fun2()
		* http://localhost:808/WEB/demo!fun2.action
		> ���ֻ��URL�����"!"��̾��,������ӷ�������ֱ�Ӿ��Ƿ���Ĭ�ϵķ���!
		> ע��ע��ע��,��struts.xml����Ҫ����������, ��Ȼ��������Ĭ��Ϊtrue,���������˸���.���黹����������
		<constant name="struts.enable.DynamicMethodInvocation" value="true"></constant>
		* �������������default.properties
		�����Ҫ�ر����ֶ�̬�������õĻ���,���ǿ�����struts.xml�ļ��н��г���������
		* <constant name="struts.enable.DynamlcMethodInvocation" value="false"></constant>
		

	��ʵ���ֶ�̬����,��struts2 1.0 �汾��ʱ��Ͳ�����ʹ���ˣ��ٷ�������ʹ�õĶ���,�ͱ����ˡ�

	----------------------
��,ͨ���������
		<action name="test_*" class="com.kevin.demo.Demo" method="{1}" >
			<result name="success">/index.jsp</result>
		</action>
		> ��ʵ��Ӧ�ò��ѿ������е���˼,�ٻ���һ��MessageFormat���Ӧ��֪����
		> text_* ���*�Ϳ����ɿͻ��˴��ݹ���,��ô���*�žͻᱻ��ֵ��{1}���������
		> ����ж��*����,�򰤸���ֵ{1}{2}{3}... ...
		> ����� * ������method��,����˵�ͻ��˿����Լ�����Ҫ���õķ���
		> ����,���*���ܳ����� class,result��ǩ�С���������ͳһ�ɿͻ��˷�����,Ȼ��Ϳ�����ô������Щ������


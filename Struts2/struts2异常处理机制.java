����������������������������������������������������������������
һ,struts2�쳣����				|
����������������������������������������������������������������
	> stutsĬ�ϵ�������ջ��,��һ��������!
	 <interceptor name="exception" class="com.opensymphony.xwork2.interceptor.ExceptionMappingInterceptor"/>
	* �������ĵ�����һ��'�ݹ����'�Ĺ���
	* ������������Ƕ������,��ʵɶҲû��!û��ֱ�Ӿͷ���!���ǵ�һ��ִ��,Ҳ�����һ��ִ��!
	* ������,ȴ�� try	catch!Ҳ����˵,ֻҪ�����Ժ��������,��ʵ����������ctach��Χ��!ֻҪ�����Χ��,�����쳣,������׽��
	


	> ��action�Ĳ�����,��������.ֱ���׳��Զ����쳣!
	> ������������,����actionֻҪ�����׳��쳣,Exception�������ͻᲶ����,Ȼ������ݽ��д���!












����������������������������������������������������������������
��,�����ľɱʼ�					|
����������������������������������������������������������������
struts2֧������ʽ�쳣����
��ActionSuppoer������е�execute����,������������һ��Exception
��˼����,˭��д���������,���б�дtrycatch,ֻ�������׳�,��struts2���������"����"

��ô��ͳ�����ǵ���Щ��catch��������throw new RuntimeException(e);,�Ϳ����������ˣ�
û��ϵ,��ܻ����"����".

----��������
<action..>
	<exception-mapping result="error" exception="java.sql.SQLException"/>
	<result name="error">/error.jsp</result>
</action>
	> ��˼���������Action�������׽����java.sql.Exception,��ôresutl�͵���error,��Ȼ�����Ҫ����һ��nameΪerror��result����ʽ

----ȫ�����ô���׽,�Լ��ṩ��Ӧ��Result����
<package name="error" extends="struts-default">
	<global-exception-mappings>
		<exception-mapping result="error" exception="java.sql.SQLException"/>
	</global-exception-mappings>
</package>
	> ��һ����������һ��ȫ�ֵĴ�����Ϣ,Ȼ��ֻҪ�̳����İ��������쳣,��ô�ͻᱻ����.result��ֵ,Ҳ�ͱ�ȫ�ֶ�����쳣��ת��
	> ���ַ�ʽ����Ҫ�Լ����Լ���Action���ṩresult���ҳ��,
	> ȫ���쳣����׽,result��nam����Ҫ��ȫ�ֵ�result������ͬ

----ȫ�����ô���׽,��ȫ��ͳһ����
<package name="error" extends="struts-default">
 	<global-results>
		<result name="error">/error.jsp</result>
	</global-results>	
	<global-exception-mappings>
		<exception-mapping result="error" exception="java.sql.SQLException"/>
	</global-exception-mappings>
</package>
	> ���ѿ���,��������Ⱦ��Ƕ��˸�ȫ�ֵ�result,Ҳ����˵,�̳���������İ���Action�������쳣֮�󶼲����Լ�����result������,��ȫ��result�����д�����

------ԭ����
���� ---> ���Ĺ����� --> �����ض���Action��exceute()����.

struts-default.xml�е�defaultStack�������C,��������һ������exception��������

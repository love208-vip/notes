����������������������������������������������������������������
һ,Result�������		|
����������������������������������������������������������������
<action ...>
	<result type="�������" ...>
		
	</result>
</action>
* type:ȷ���˽��������ת�������ض���,����ʲô.type�кܶ��ֵ
* ��strut-defautl.xml,�е�struts-default�������ҵ�!
* ��result���������:default="true"����,��ʾ��Action��result��Ĭ��ֵ���Ǹ�result!
	> �ⶫ���Ƕ�����default.xml�еĶ���!
����������������������������������������������������������������
��,��Ҫ���յĽ������		|
����������������������������������������������������������������
����ת��(Ĭ��)
	dispatcher
	* һ�����ڴ�һ��action��ת��ҳ��(jsp,html)
����ת��
	chain
	* ��¥�ϵ�������,��һ�����ڴ�һ��action��ת����һ��action
�ض���
	redirect		
	* <result type="redirect">/add.jsp?username=KevinBlandy</result>
�ض���
	redirectAction	
	* ��¥�ϵ��������,�����ض���Ҫĳ��action
	* <result name="success" type="redirectAction">action����?��������=����</result>
		> ���û����,�ǾͲ�ͬ��!��������ʹ��OGNL���ʽ��ValueStack�л�ȡ
	* ����ض����Action���ڴ˰���(����Ҫ�˽�һ�����:����ҪΪ��������������ֵ)
		> redirectAction��һ����,�������:org.apache.struts2.dispatcher����
		> setActionName(String actionName);//redirectAction��action����
		> setNamespace(String namespace);//redirectAction��namespace����
	<result name="success" type="redirectAction">
	 	<param name="actionName">�������µ�Action����</param>		<!-- redirectAction���е�actionName���� -->
		<param name="namespace">��������namespace</param>		<!-- redirectAction���е�namespace���� -->
	</result>
	* �������ַ���ᷢ���仯  
���� 
	stream
	* ����,�������˷��ص���һ��(�ֽ�)��,һ����������!


����������������������������������������������������������������
��,ֻ��Ҫ�˽�Ľ������			|
����������������������������������������������������������������
1,plainText
	> �õĲ��Ǻܶ�,ż������
	> ԭ�����Դ����,jsp��Դ����,���ᱻjsp�������,Ҳ���ᱻ���������
	> ����ҳ��Ĳ鿴Դ���ҳ����ʾ��Դ����һ��һ��,��
	> plainText Ҳ�������WEB-INFĿ¼�µ��ļ�
	* <result type="plainText">/WEB-INF/web.xml</result>
	> ����ҳ���к�������,���ܻ������������!�ļ���ŵı���,����������ı��벻һ��
	* ���Ҫ�������ҳ�����������(����Ҫ�˽�һ�����:����ҪΪ��������������ֵ)
		> plainText��һ����,,�������:org.apache.struts2.dispatcher����(��������µ�,û��ʵ����֤,�����Լ�ȥ��һ��)
		> setLocation(Sting location);//plainText��location����,��ʵ����Ҫ�����ҳ��
		> setCharSet(String charSet);//�ַ�������
	 * <result type="plainText">
		<param name="location">/WEB-INF/web.xml</param>		
		<param name="charSet">UTF-8</param>
	   </result>
[������������ģ�弼���Ķ���... ...]
2,freemarker
	
3,velocity
����������������������������������������������������������������
��,�ֲ����ҳ���ȫ�ֽ��ҳ��	|
����������������������������������������������������������������

1,ȫ�ֽ��ҳ��
package result����	(һ��package�й���)

	* �������������һ��package����
	* ��������ķ���ֵ(result),����ʽ
	* ���Ա���package���������action����
	* ���action�Լ���result name���Ը�ȫ�ֹ����һ��,��ô����ִ���Լ���
	<global-results>
		<result name="all" type="redirect">/index.jsp</result>
	</global-results>

2,ȫ�ֽ��������	

	* ���Ƕ���һ����,ȥ�̳� struts-default
	* Ȼ��,ֻҪ�Ǽ̳��������,���ܹ������ǵ� global-results
	* ��Ϊ������̳���struts-default,����,�̳�������İ�,Ҳ�ǿ���ʹ��struts-default�Ķ���
	<package name="base" extends="struts-default">
		<global-results>
			<result name="all" type="redirect">/all.jsp</result>
		</global-results>
	</package>
	<package name="manager" namespace="/demo" extends="base">
		...�������Ϊ�̳���base��,����������ڵ�Action���Թ���base���е�ȫ��result
	</package>

6,��̬�����
<action...>
	<result>${url}</result>
</action>

	> ��ʵ������Action�ж���һ��String������Ϊurl������,
	> ����ͨ��Action�ĳ����ж�,����url��ֵ.
	> �ڸ�Action��result��,�Ϳ���ͨ���������ư�url������ȥ����,����һ��url���д���
	> ${url},�����ڶ�ֵջ���������
---����
	public String demo()
	{
		if("1".equals(userName))
		{
			url = "/WEB-INF/jsps/manager.jsp";
		}
		else
		{
			url = "/WEB-INF/jsps/success.jsp";
		}
		return "test";
	}

7,�������Ľ����
> �ض���,Ҳ���ǿͻ�����ת��ʱ�����������������ת����ֱ�ӷ������
<action ..>
	<result type="redirect">/user/demo.jsp?p=${p}</result>
</action>

�ⶫ����,Ҳ�Ǵ�ֵջ����ȡ,��Action���涨�����ͺ�

ÿ��request����,��ֻ��һ��ֵջ,��һ������,������󴴽��µģ�
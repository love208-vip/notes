����������������������������������������������������������������
һ,struts2ValueStack��OGNL����	|
����������������������������������������������������������������
	> ����struts2���ѵ�,������֪ʶ��ϵ�����ѵ�һ������
	> OGNL��ɶ?valuestack����ɶ?
	> ���ż���Ľ���
		> ognl-�Ƕ��󵼺�ͼ���� Object-Graph Navigation Language 
			* ����ǿ��,��EL���ʽ��ǿ��
			* ����һ����������Ŀ,ֻ��˵struts2��������.ǧ�����Ϊ����struts2�Ķ���!struts2ʹ������ΪĬ�ϵ�����
			* �����������๦��
				1,֧�ֶ��󷽷��ĵ���,��:xxx.demo();
				2,֧���ྲ̬�����ĵ���,��ֵ�ķ���
				3,����OGNL������(OGNL Context)��ActionContext	(�����ص�����ValueStackֵ�C)
				4,֧�ָ�ֵ�����ͱ��ʽ����
				5,�������󼯺�
		> valuestack-ֵ�C,�������ֱ�ӷ��������
			* �Ӽ����Ƕ���˵,ValueStack����һ���ӿ�
			* ��ʹ�ýǶ���˵,ValueStack����һ������
			* ����ʹ��ValueStack,�������þ��ǰ�Action��ص�����,�Լ�WEB��صĶ���,Я����ҳ����
			  ��˵,��struts2��,ValueStack��Action�е�����Я����JSPҳ���Ͻ���չʾ!
			  '��֪��������session,request,application...�������ǽ���,ʹ�������ܵ�ʱ��,������ȥ����Щ����'
	> ΪʲôҪ��ValueStackһ��.�����й�ϵ��Ҫ��
		* ValueStack����װ
		* OGNL����ȡ
	> ValueStack����Ӧ��,���ǽ��:��Action����Я����jspҳ��
����������������������������������������������������������������
��,struts2ValueStack���ڲ��ṹ	|
����������������������������������������������������������������
	> ValueStack����һ���ӿ�!
	 com.opensymphony.xwork2.util.ValueStack
	> ����ʹ����,���ǰ�����Ϊһ������.����Я�����ݵ�ҳ��,��ҳ����OGNL���ʽȡ������

	1,ֵ�C���
		�� ValueStack��һ��ʵ����,����'OgnlValueStack'
		�� ÿһ��Action����һ��ValueStack
			* һ��Action,һ��request,һ��ValueStack�Ƕ�Ӧ��.Ҳ����˵ValueStack�������ڸ�request��������һ��
		�� ValueStack�д洢�˵�ǰAction����,�Լ��������õ�WEB����(request,response,appliction,session...)
		�� Struts2��ValueStack��'struts.valueStack'Ϊ��,��'ValueStack�洢����request����'
			* ��request����ȡ��ֵ�C��ʱ��,����ʹ������.����:ServletActionContext.STRUTS_VALUESTACK_KEY
			* ���Ҫֱ��дstruts.valueStackҲ��,��������д���˶���
			
		
	2,ValueStack�ڲ��ṹ
		> ֵ�C�����������
		�� ObjectStack	Struts�Ѷ�����صĶ���ѹ��ObjectStack��	���� List
		�� ContextMap	Stauts�Ѹ���ӳ���ϵ(һЩ Map ��ʽ����)ѹ��ContextMap��
			* parameters:	�� Map �а�����ǰ����Ĳ���
			* request:		�� Map �а�����ǰrequest��������������
			* session:		�� Map �а���session��������������
			* application:	�� Map �а�����ǰappliction�����е���������
			* attr:			�� Map ��˳��������ĳ������:request,session,application

	3,ValueStack�д���������Ҫ������
		�� root	-->	CompoundRoot	
			> ��ʵ���Ǽ̳��� ArrayList
		�� context	-->	OgnlContext
			> ��ʵ����һ�� Map
	4,context��ӦMap����root����
		> ����˵��,context��� Map �л��� root ������!����ValueStack��һ����Ҫ������!
		�� context�л�����request,session,application,attr,parameters��������
		�� OGNL���ʽ,����root�����ݵ�ʱ��,����Ҫ"#",����request,session,application,attr,parameters��������,����д#
	5,����ֵ�C,Ĭ�ϲ����ľ���rootԪ��

	['�ص�']
		'��ʵ,ValueStack������Ǹ�Context,����OGNL�����Context'

	['����']
		'ValueStack'����������,һ���� List,һ���� Map
		��struts2��,List ����root ,Map ����OgnlContext
		Ĭ�������,��struts2�д�ValueStack��ȡ����ʱ,��root�л�ȡ!
	
����������������������������������������������������������������������������������
��,ֵ�C����Ĵ����Լ���ActionCotext�Ĺ�ϵ|
��������������������������������������������������������������������������������
	1,ֵ�C������������ʱ������,ÿ��������ǰ�˹������д����µ�.

	2,ActionContext �� (ValueStack)ֵ�C�Ĺ�ϵ
		�� 'ActionContext�г�����ֵ�C������'
		
		ǰ�˿�����(Filter)�е�Դ��
			ActionContext ctx = ActionContext.getContext();
			if (ctx  != null)
			{
				stack = ctx.getValueStack();l
			}
	
	3,��λ�ȡֵ�C����(���ַ�ʽ)
		�� request������ֵ�C����//��request�л�ȡ
			ValueStack vs = (ValueStack) ServletActionContext.getRequest().getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		�� ActionContext��Ҳ��ֵ�C����//��ActionContext�л�ȡ
			ValueStack vs = ActionContext.getContext().getValueStack();
			* �Ƽ�ʹ�����
		�� ����һ�ַ��� 
		  ValueStack vs = ServletActionContext.getValueStack(ServletActionContext.getRequest())
			
	
		
		
	4,ValueStack�ڲ���������,һ���� Map(OgnlContext) һ���� List(root)
		�� ���� Map �л����� List!
������������������������������������������������������������������������
��,��ֵ�C�����������				|
������������������������������������������������������������������������
	> ��struts2��,һ�㶼�ǰ����ݴ洢��root,������context�д洢
	> ��˵��root�д�!��root�����һ�� List,
	> ��չ:�C�ṹ -- �Ƚ����

1,��root�д洢���������ַ���
	�� push(Object obj);
		* �����ݴ�ŵ���һ��Ԫ�ص�λ��(ջ��).
		* �ײ���� add(0,Object),���һ����������Զ�������
		* �ⶫ�����ȥ��,��һ�� Object

	�� set(String name,Object obj);
		* �ȴ�root�л�ȡ Map,��� Map ������,�ʹ���һ��!�ٰѴ��ݵĲ�����װ��ȥ
		* �ٵ��������push(Map map);�����Mapѹ��ջ��
		* �ײ��� HashMap 
		* ��ʼ����,root���涼ֻ��һ�� Map ,���´�������涫����ʱ��,�����ϴ�ͬһ�� Map,����Ҫע��!key��ͬ��������ǵ�����!

������������������������������������������������������������������������
��,��JSPҳ���л�ȡֵ�C����			|
������������������������������������������������������������������������		
		['�ص�']
		* ��סһ��ԭ��,����������ݲ�Ҫ#��,�Ǹ����������,��Ҫ#��
		* ��,����root....context��Ҫ#��!
��ȡroot
		1,����C���� Map ����,��ȡ��ʱ��,ֱ�ӿ���ͨ�� Map ��key����ȡ
		��	<s:property value="key"/>

		2,���ջ���Ƿ� Map ��������	
		��	<s:property value="[0].top"/>
			* ���value="[0]",ֻд0,��ô���ʹ�0�Ǳ꿪ʼ��������ȫ�����.['��0��ʼ���²�������']
			* ���value="[1]",ֻд1,��ô������1�Ǳ꿪ʼ��������ȫ�����.['��1��ʼ���²�������']
		3,����� Map �������Զ�����
		��	<s:property value="key"/>
			* ��ʵ����,Map ����ջ��.������֮���ǻ��������²���,�ҵ�Ϊֹ.�Ҳ���������!

		['�ܽ�']
			Object ����ͨ��root�����ĽǱ�,������,Map ͨ��key������!
			push(Object obj);������ȥ������,����Ҫ���Ǳ������
			set(String key,Object value);������ȥ������,���Կ��Ǳ�,Ҳ���Կ�key
		
��ȡcontext
		> ����ʲôrequest,session,application...�ȵ�!
		> ��ʵ��Щ����������������WEB����,���Ǳ���ܰ�װ����!
		> ������Ǹ�,Ҫ��#
		1,request����			
			<s:property value="#request.key"/>
			* ��request���л�ȡָ��key��ֵ
		2,session����			
			<s:property value="#session.key"/>
			* ��session���л�ȡָ��key��ֵ
		4,appliction����		
			<s:property value="#application.key"/>
			* ��application���л�ȡָ��key��ֵ
		5,attr					
			<s:property value="#attr.key"/>
			* ��С����,���β���ָ��key��ֵ.��EL���ʽȫ�����һ������!
		6,parameters
			* ���ڻ�ȡ�������
			<s:property value="#parameters.name[0]"/>
			* ��ȡָ�����Ƶ��������,��Ϊ��������п��ܶ���ֵ,������Ҫ�����±�
			* ����Ƕ������,���ֲ������±�Ļ�,��ô�ͻ���������������ֵ���г���,��","�Ÿ���!�ַ�����!

		
����������������������������������������������������������������
��,ֵ�CЯ�����ݷ����Լ�ʹ��		|
����������������������������������������������������������������

Action��JSPЯ������,����ʲô�������ݣ�
	1,��ͨ���ı�����,�ַ���!
		�� fieldError	У�����ݵĴ�����Ϣ��ʾ(���һ�������Map�ṹ,��key value��)
			���:this.addFieldError("key","value");
			��ȡ:<s:fielderror fieldName="msg"/>

		�� actionError	ҵ���߼�����,����:�û����������
			���:this.addActionError();
			��ȡ:<s:actionerror/>
		�� message		�ʹ������Ϣ

			���:this.addActionMessage();
			��ȡ:<s:actionmessage>


	2,�Ƚϸ��ӵ�����(��ҳ��ʱ��,��ҳ�洫�ݵ�PageBean)
	����1
		Action �д洢����
			ValueStack vs = ActionContext.getContext().getValueStack();
			List<User> list = new ArrayList<User>();
			list.add(new User("KevinBlandy","admin"));
			list.add(new User("LitchLeon","12345"));
			list.add(new User("LanechoCliche","abcde"));
			vs.push(list);
		ҳ���л�ȡ����
			<s:iterator value="[1].top" var="user">//ȡ��user			
  			�û���:<s:property value="#user.userName"/><br/>
  			�ܡ���:<s:property value="#user.passWord"/><br/>
  			</s:iterator>
		�� ����,����ʹ����һ��iterator��ǩ����������
		�� �Ѽ����е�ÿ��Ԫ��������user,��ô���user�Ǵ���context�е�,����root��!��ô��Ҫ��ȡ,��Ҫ����#��!
		�� �����ʹ��iterator���е���ʱ,û�и�����Ԫ������!��ô�Ͳ���
			<s:iterator value="[1].top">
  			�û���:<s:property value="userName"/><br/>
  			�ܡ���:<s:property value="passWord"/><br/>
  			</s:iterator>
		
����������������������������������������������������������������
��,ֵ�C��Ĭ��ѹ������ݷ���		|
����������������������������������������������������������������
	Ĭ��ѹ�뵽����ValueStack�е�����
	1,��ǰ���ʵĵ�Action����,�ᱻѹ�뵽ֵ�C!
		�� ������������ǰ��ѹ����
		�� Action����봫�����ݸ�JSP,ֻҪ�����ݱ��浽��Ա����.�ṩget/set�����Ϳ�����JSPҳ���ȡ!
		�� ֻҪ���Action,�ṩ��getXxx����.��ô�����Ծͻ���:xxxΪkey,����ֵΪvalue�� Map ��ʽ������ֵ�C��
		�� <s:iterator value="list"...//���б���������,ֻҪ���Action����getList();�������,������Զ�������!�㶮��!		
	2,����ģ��������Action
		�� ModelDriven,û���ǰ�?Action�ڲ���ʵ������,����Ҫget/set����!ֻ��Ҫʵ�ֽӿ�,���ض���Ϳ�����ɸ�ֵ
		�� ModelDriven�ӿ�,��һ������������
		 <interceptor name="modelDriven" class="com.opensymphony.xwork2.interceptor.ModelDrivenInterceptor"/>//18�޺�֮һ
			* �����������,��Model����,ѹ����ֵ�C:stack push(model);
				Դ��:��..�Լ�ȥ����,ִ����ѹ��ֵ�C����
			* ���Actionʵ��ModelDriven�ӿ�,ָ��Ĭ��ջ���������Model����(��Action����)
			* ��Ȥ����,Action���ModelDriven�Ľӿڷ���:getModel(),��Ϊ��get,Ҳ��ѷ��ص�Model����ֵ�C!������ʵ��ͬһ������
				['����']:�������Actionִ�з�������,��Model�����ݽ����޸�,��ô��ֵ�C�оͻ᲻һ��
					* һ��������������,����ܵ�����getModel(),�Ѷ������������,����ֵ�C
					* һ���ǵ�����Action֮��,��execute(),�����޸���ֵ֮��.�ٴα���ܵ���getModel(),��'model'������.����ֵ�C���model��ʵ�����������!
					* Ҫע��ľ���,ModelDriven����ӿڵ�ʵ������,genModel(),������Ҳ�������ֵ�C��
			* ���ƾ������,ȫ����,ֵ��ȫ����ʾ���ұ�

	['�ܽ�']
	����,һ������Action,һ������get��������Ķ���
����������������������������������������������������������������
��,����������ϵͼ				|
����������������������������������������������������������������
ActionContext
ValueStack
root			--> ArrayList
context			--> Map
OgnlContext

-------------------------------------

'ValueStack'		(��root����ͬһ��)			'OgnlContext'
root ������|������������������������������������������������������������������������������|��>root
		|										|
		|		(contextֱ�Ӱ����˶�������)		|		
context-|������������������������������������������������������������������������'>'| context
	��
	|
	|(����ValueStacke������)
	|
	|
---------------
'ActionContext'|
---------------

ValueStack��������,һ��request,һ��Action,һ��ValueStack

ϸ��:
ActionContext �����,ʵ���� Serializable �ӿڲ��������и�����
static ThreadLocal<ActionContext> actionContext = new ThreadLocal<ActionContext>();
	> �߳�����,�㶮��!

['ע��']
	ActionContext�ǰ󶨵��߳��е�!���������,Ϊʲôÿ�����󶼻Ὺ��һ�����߳�!
	struts2����������!ÿ��������,����.�Ҿ͸�����̰߳�һ��ActionContext!��,ValueStack�ǰ���ActionContext�ϵ�!ֻҪ�������,
	�߳�û����!�ⶫ����һֱ��!
['�ٴ�ǿ��']
	root	�洢����Action��ص���Ϣ
	context �д洢����ӳ���ϵ,�Լ�WEB�����г�������
		* request,session,application... ...

����������������������������������������������������������������
��,ֵ�C����ͨ��EL����			|
����������������������������������������������������������������
	ΪʲôEL�ܷ���ֵ�C(ValueStack)�е�����.
	����:
		vs.set("username","Kevin");
		<s:property values='userName'/>
		${userName}
		�� �ⶫ��û�������������д洢����
		�� �����������һ��,����Kevin
	
	['ԭ��']
		struts2������ʹ�õ�request,����!�Ѿ��Ǳ���װ��ǿ����request����!
		��ͳ:${userName}---�����,��������!
		��ǿ:${userName}--->request.get... ----> ValueStack

		�� ��ʵ������ǿ��request�� get����!ԭ�������������а�������!����������request��,���request��û��!ֱ��ValueStack!


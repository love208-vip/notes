����������������������������������������������������������������
һ,��̸ֵ�C����					|
����������������������������������������������������������������
	* �ⶫ����һ���ѵ�,Ҳ��struts2�ĺ�������!
	* ֻҪ��һ��MVC���,���������������:'���ݵĴ��ȡ'
	
	* struts2����ֵ�C������,����ֵ�C��һ���洢���ݵ��ڴ�ṹ!
	* �����ݴ��ֵ�C��,��ҳ��ʹ��OGNL������ʾ

	* ValueStack ��һ���ӿ�,struts2��ʹ�õ�������ʵ���� OgnlValueStack
	* OGNL,�����Ͳ���struts2�Ķ���,����һ�����󵼺�ͼ����.���Ը��ݶ�������������Ķ���
	  ��Ҳ���԰������Ϊ,��һ�����.struts2ֱ�ӾͰ����ù�������.

����������������������������������������������������������������
��,ֵ�C --	��������			|
����������������������������������������������������������������	
	1,��ȡֵ�C
		ValueStack valueStack = ActionContext.getContext().getValueStack();
			* ActionContext ����ֱ�ӻ�ȡֵ�C,����ֵ�C������.
		ValueStack valueStack = ServletActionContext.getValueStack(ServletActionContext.getRequest())
		ValueStack valueStack = (ValueStack) ServletActionContext.getRequest().getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
			* ֵ�C,�������request����.
	2,�����ֵ�C,��ʵ����ͬһ��!������ҲӦ��ע��,��һ�������Ǵ�request���л�ȡ��,
	  ����Ȼ,ֵ�C����������,��request,action��һ����!����������Ч!
		
����������������������������������������������������������������
��,ֵ�C --	�ڴ�ṹ			|
����������������������������������������������������������������	
	1,ValueStack ��һ���ӿ�,����������struts2��!ʹ�õ���һ��ʵ�������:OgnlValueStack
	2,ValueStack ���������ڴ�����,Ҳ���������ڴ�ṹ.һ�� Map ,һ�� ArrayList
	['context']
		* OgnlContext(OGNL)
		* �ֳ�֮ΪMap�C,��ʵ���˼�ognl������еĶ���
		* Դ���� OgnlContext ��ʵ�� implements Map,��������һ�� Map ����
		* �ڲ���Ҫkey,����
			1,_root
				���keyΪ_root,��ֵ,���Ǿ���'root '.Ҳ����˵'context'�����˶�root������
			2,_values
				���key����_values,��ֵ.����һ�� Map(HashMap),
				request,session,application,response,�ȶ������ Map ����
				�������,�Լ����ʵ�Action,�Լ�һЩӳ��(����)��Ϣ,Ҳ�����������
			
	['root']	
		* CompoundRoot(xwork)
		* �ֳ�֮Ϊ����C
		* Դ���� CompoundRoot ��ʵ�� extends ArrayList,������һ�� ArrayList ����

����������������������������������������������������������������
��,ֵ�C --	���ݴ洢			|
����������������������������������������������������������������
	['CompoundRoot']
		valueStack.push(Object obj);
			* ��һ����������˶���C��ջ��,��Ҳ����ͨ��ֱ�ӻ�ȡ'����C������',valueStack.getRoot(),ͨ������ List �Ѷ������Cβ!
	['OgnlContext']
		
����������������������������������������������������������������
��,ֵ�C --	����ȡ��			|
����������������������������������������������������������������
	['CompoundRoot']
		valueStack.peek();
			* ��ȡ����C,ջ��������
	['OgnlContext']

����������������������������������������������������������������
��,ֵ�C --	�ṹ��ͼ			|
����������������������������������������������������������������
ValueStack(ֵ�C)
	context(implements Map)
		* _root
			����������ValueStack�е���һ���ṹ	
		* _values(HashMap)				
			1, �����Servlet����������(request,response,session,appliction -- ��ʵ���Ǳ���װ����,���Ǳ���Ҳ��Map�ṹ)
			2, ��ǰ�����Action
	root(extends ArrayList)
		* ValueStackAction(��ǰ�����Action)
		* DefaultTextProvider(���ʻ�)

	OGNL�����Դ���OgnlContext,Ҳ����context.��struts2�����˰�װ,�ָ�����һ��root������!���Ǿ��γ���:valueStack!

����������������������������������������������������������������
��,ֵ�C --	����API				|
����������������������������������������������������������������
	ValueStack valueStack = ActionContext.getContext().getValueStack();
	* ��ȡ����������,���ﲻ��˵.�Լ�������

['��������C']
	valueStack.push(Object obj);
			* ��һ������,���絽'root'��,ջ����λ��.root,Ҳ����һ���C���ݽṹ������,ʵ��ִ�е���:root(0,o);
	valueStack.peek();
			* ��ȡ�ľ��Ƕ���C,ջ����Ԫ��.ʵ��ִ�е���:root.peek();������ֱ�� return get(0);
	valueStack.pop()
			* �Ƴ�ջ���ĵ�һ��Ԫ��
	valueStack.setParameter(String key,Object value);
			* ��ջ�������key����,��ֵΪvalue
			* ���������������,ֱ�Ӹı����C��ջ���������Ե�ֵ
	valueStack.getRoot();
			* ���صľ��� List<Object>,���Ƕ���C������.������Լ��Ѷ�����ӵ�ջ��,Ҳ������ӵ��C��
			* ��õ�����,�����ֶ��Ļ�ȡ/�洢,ջ�����ǗCĩ������!

['����Map�C']
	����ͨ������Servlet�����.���� Map �C��'_values'�����ݽ��д���/ȡ������!
	
����������������������������������������������������������������
��,ֵ�C --	Ĭ��ѹ������				|
����������������������������������������������������������������
	* �ҳ�ţ�Ƶ��ֻ�ֵ�C�ṹͼ
	* ������<s:debug/>��ǩ
	------------------------------------------------------------------------------------------
	Object								Property Name	Property Value								
	------------------------------------------------------------------------------------------
										container		There is no read method for container
										errorMessages	[]
										actionErrors	[]
	com.kevin.action.ValueStackAction	actionMessages	[]
										fieldErrors		{}
										texts			null
										valueStack		null
										locale			zh_CN
										errors			{}
	------------------------------------------------------------------------------------------
	com.opensymphony.xwork2.DefaultTextProvider	texts	null										
	------------------------------------------------------------------------------------------

	* ��ʵValueStackAction���Action,�̳���ActionSupport!��ô��ͼ�е����� Property Name ��Ŀ.ȫ�������ڱ����Լ������get����
	['�ܽ�']
		ֻҪ��Action�д��ڵ�getXxx();����.�ͻᱻֵ�Cѹ�뵽,CompoundRootջ��!
			* Property Name ���� getXxxx()��xxx
			* value ����getXxxx()����ֵ!
		�Ѷ���������C��,����ֱ��ʹ��<s:property value="������"/>ֱ�ӷ���
		�������C�г��ֶ����ͬ������,��ô�����ǩvalue���Ի�������¿�ʼѰ��,�ҵ���ֹ!


	

	
	
	

			
	
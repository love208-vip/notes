����������������������������������������������������������������
һ,struts2������				|
����������������������������������������������������������������
	> struts2,������.Դ��Spring��AOP˼��
	> ��,AOP�ĵײ�ʹ�õ��Ƕ�̬���� Proxy,�����˰�
	> strut2��������ʹ��������ģʽ
		> ������ģʽ��,�ܶ������һ����������¼ҵ����ö����������γ�һ����
		> ������ÿһ���ڵ�,�����Լ���������һ���ڵ�.Ҳ������ֹ���̼���ִ��
	> struts2��Ĭ��ʹ�õ���Ĭ�ϵ�defaultStack�������C
		> �������������C��,ʹ����18��������,��˵!struts2Ĭ�������!������18����������!
	
	> �ⶫ�����Ѿ������!������,����ɵ���˰�?
	> ����,�Ҷ����ǲ����ĸо�����ˬ!

	* ���ô�׻��������һ��:
	����Զ�һ��Action��ӹ���,Ҳ����ɾ���Ѿ���ӵĹ��ܣ����Ҷ�����ȥ��Դ��!�ӵ�����!
	����,�����н�ȥ!������!��WEB�е�filter�е���

	'��������������������'
	1,ʵ�� Interceptor �ӿ�
		* ������ԭʼ�Ľӿ�,�κ���������Ҫʵ����!������������,init,destory...interceptor
	2,�̳� AbstractInterceptor ������
		* ���� Interceptor ��ʵ����,��ʵ����init,destory����!����ֻ��Ҫ��д interceptor 
	3,�̳� MethodFilterInterceptor ������
		* ���� Interceptor ��ʵ����,����һ�� doInterceptor����.����ֻ����ָ���Ķ���
����������������������������������������������������������������
��,struts2��ôʹ��������		|
����������������������������������������������������������������
	1,�����Զ�����������,ʵ��Interceptor�ӿ�
		* com.opensymphony.xwork2.interceptor.Interceptor
	2,��д����
		> init();//��ʼ����������
		> intercept();//ҵ�����,Ҳ�����������صķ���
		> destroy();//���ٵ���
	3,��xml������ Interceptor
	4,��ô�ڷ��ʸ�Action��ʱ��,�ͻ��ȴ���������ִ��������!
	5,����һ���ݹ���õĹ���

['����������ṹ']
<package>
	//����������
	<interceptors>
		<interceptor name="" class=""/>	//�Զ���������1
		<interceptor name="" class="">	//�Զ���������2(������)
			<param name="����">ֵ</param>
		</interceptor>
		//������ջ
		<interceptor-stack name="">		//�Զ����������C(���п����������������������������C,�����̳�������)
			<interceptor-ref name=""/>		
			<interceptor-ref name=""/> 
		</interceptor-stack>
	</interceptors>
	//Action
	<action name="" class="" method="">
		<interceptor-ref name=""/>	//����ĳ��������,������������ջ
		<result name="login">/login.jsp</result>
	</action>
</package>

['���������']
	> ��ʱ��һ��Action����N�������������!����:login,serch!��ʱ��������ҪΪ�������ò�ͬ��Ȩ��!
	> ��������漰����һ������:������,ֻ����Action��ָ���ķ���
	1,Action�಻��ʵ�� Interceptor �ӿ�,���Ǽ̳����µĳ�����,����Ȼ��Ҳ��ʵ���� Interceptor �ӿ�
	* 'MethodFilterInterceptor'
	* import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor
	* ֻ��һ������:doInterceptor(Invocation invocaton);
	* ��������������ط���.
	2,��struts.xml������
	<interceptor name="" class="">									//�Զ���ķ���������
			<param name="includeMethods">add,update,delete</param>	//�ᱻ���������ķ���,�Ǹ�����,���Զ�����!
			<param name="excludeMethods">login,quite</param>		//���ᱻ�����������صķ���
	</interceptor>

	�ܽ�:ֻ����'includeMethods',�����������ķ����Ż�����.��Ȼ����ִ�����ز���!'������ûд,������д����excludeMethods����,�����ᱻִ��'
	* ������Ǹ�����.���߶�д,��ô�϶��ᱻ����!
	* ʲô?����дһ�������ڵķ���?����Ҫ�뵽Action���󷽷������ڻᱨ���... ...

['ע��']
	
	> �Լ�����������ջ,���а�Ĭ�ϵ�������ջ���ý���(�Լ��̳�struts-default���߼̳��Ѿ��̳���struts-default�İ�,�Ϳ���ʹ��Ĭ�ϵ��������CdefaultStack)
	  ֻҪ�ڶ������ʱ��,�̳�struts-default��,��ôdefaultStack����Ĭ�ϵ�������
	  '�����е�ĳ��action��ʾ��ָ����ĳ��������,��Ĭ�ϵ�����������������'
	  '���ܶ๦�ܶ��Ƕ�����Ĭ�ϵ��������C�е�..����:������װ�ȵ�........'
	  ������ջ�еĸ�����������˳�����Ҫ,'��������ִ��'!
	  һ�㶼�ǽ���,'������Ĭ�ϵ�������ջ,�������Լ���'
	> ������ջ�п���Ƕ��������ջ,��action�����õ�ʱ��,������ջ���ǵ��������������ñ�ǩһģһ��
	> ����һ��������,���ǿ��԰�defaultStack�C�е�������,�ֶ��ĸ�ֵ��Action��.Ȼ����в���/ɾ��/�滻�Ȳ���!
	
����������������������������������������������������������������
��,intercept,���ط���			|
����������������������������������������������������������������
	//������ǽӿ��еķ���,Ҳ���Ǵ�˵�е����ط���
	public String intercept(ActionInvocation invocation) throws Exception 
	{
		
		return invocation.invoke();
	}
	> �����������ֵ�ᱻresult�������������������յ�!��ȷ��,��������������,����Ҳǰ������!

['invocation']
	invoke();//����,��ʵ���ǵ�����һ��������������Action.����,��ɶ����ɶ!�õ�һ��String�ַ���
	getAction();//����һ��Object,��ʵ���ǵõ������ص��Ǹ�Action����!���Action�Ǽ̳���ActionSupport,�Ǿͽ���ǿת!
	
����������������������������������������������������������������
��,struts2������ԭ��			|		
����������������������������������������������������������������
	Դ��ִ������
	1.��StrutsPrepareAndExecuteFilter�в���
		* ��doFilter��������һ�仰 execute.executeAction (request, response, mapping) ִ��Action����.
		
	2.��executeActionִ�й����л����Dispatcher���е�serviceAction������������лᴴ��һ��
		* ActionProxy proxy = config.getContainer().getInstance(ActionProxyFactory.class).createActionProxy(namespace, name, method, extraContext, true, false);
		* ��������ǵ�Action�Ĵ������
		
	3.�鿴ActionInvocation���鿴��ʵ���� DefaultActionInvocation.
				
	����invoke������
	if (interceptors.hasNext())
	{
		//�ж��Ƿ�����һ��������.
		final InterceptorMapping interceptor = interceptors.next(); //�õ�һ��������
		String interceptorMsg = "interceptor: " + interceptor.getName();
		UtilTimerStack.push(interceptorMsg);
		try 
		{
			resultCode = interceptor.getInterceptor().intercept(DefaultActionInvocation.this); 
			//���õõ��������������ط���.��������󴫵ݵ��������С�
		}
		finally
		{
			UtilTimerStack.pop(interceptorMsg);
		}
	} 
				
		ͨ��Դ���������������DefaultActionInvocation�о���ͨ���ݹ�������е����ص��ò���.
		
		'����interceptor��Filter����:'
			1���������ǻ���java������Ƶģ����������ǻ��ں����ص��ġ�
			2��������������servlet����������������������servlet������
			3��������ֻ�ܶ�Action���������ã�������������ԶԼ����������������á�
			4�����������Է���Action�����ġ�ֵջ��Ķ��󣬶����������ܡ�
			5����Action�����������У����������Զ�ε��ã���������ֻ����������ʼ��ʱ������һ�Ρ�
		


����������������������������������������������������������������
��,struts2����������			|
����������������������������������������������������������������
			��д��,��ֱ�������˹���!

����������������������������������������������������������������
һ,	ģ������					|
����������������������������������������������������������������
	����ģ������,struts2�кܶණ����Χ�������˵!
	<interceptor name="modelDriven" class="com.opensymphony.xwork2.interceptor.ModelDrivenInterceptor"/>
	* ����кܶ����ģ�������Ķ���,���������������
	> ������������ɵ�һЩ�������C
	<!-- Sample model-driven stack  -->
    <interceptor-stack name="modelDrivenStack">
    <interceptor-ref name="modelDriven"/>
    <interceptor-ref name="basicStack"/>
    </interceptor-stack>

����������������������������������������������������������������
��,	�Լ�ʵ��ģ������			|
����������������������������������������������������������������
�ӿ�
public interface MyDomelDriven<T>
{
	public T getModel();
}
Action
public class ActionDemo implements MyDomelDriven<User>
{
	private User user = new User();
	public User getModel()
	{
		return user;
	}
}

��������/���������ж�
if (action instanceof MyDomelDriven)
{
	����
}


"��ʵ,�����ڹ��������ж��ǲ���ָ���ӿڵ�����,����ǵ��ýӿڷ���������"
"Ȼ���ٽ��и�ֵ"

	
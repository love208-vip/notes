����������������������������������������������������������������
һ,����struts2��������			|
����������������������������������������������������������������
	  ����˵��һ��,�����ø�ע��û��ϵ!ע��Ҳ����һ������!

��struts2.1��ʼ��struts2 ������Convention�����֧��������
ʹ��Լ������struts.xml����Annotation����
��Ҫ struts2-convention-plugin-2.3.7.jar ��asm-*.jar(����)
������Զ�����action��actions��struts��struts2��������Java��
����ʵ����com.opensymphony.xwork2.Action��Java��
����������Action��β��Java��
��������������Convention���
cn.kevin.struts2.HelloAction
cn.kevin.actions.books.BookSearchAction
cn.kevin.struts.user.UserAction
cn.kevin.estore.action.test.LoginAction


struts2-convention-plugin-2.3.7.jar ��struts-plugin.xml��Ҫ����
<constant name="struts.convention.package.locators" value="action,actions,struts,struts2"/>  Ĭ��ɨ���
<constant name="struts.convention.exclude.packages" value="org.apache.struts.*,org.apache.struts2.*,org.springframework.web.struts.*,org.springframework.web.struts2.*,org.hibernate.*"/> ��ɨ��
<constant name="struts.convention.action.suffix" value="Action"/> Ĭ��ɨ����Action��β����
<constant name="struts.convention.result.path" value="/WEB-INF/content/"/> ���resultҳ����λ��
<constant name="struts.convention.classes.reload" value="false" /> Action���ļ������Զ�����

���Action��������Action��׺����Action��׺ȥ��
��Action�������շ�д����ת���л���д��
���磺
cn.kevin.struts2.HelloAction ӳ�䵽 /hello.action
cn.kevin.actions.books.BookSearchAction  ӳ�䵽 /books/book-search.action
cn.kevin.struts.user.UserAction ӳ�䵽 /user/user.action
cn.kevin.estore.action.test.LoginAction ӳ�䵽 /test/login.action

Ĭ������£�Convention�ܻᵽWebӦ�õ�WEB-INF/content·���¶�λ�����Դ
<constant name="struts.convention.result.path" value="/WEB-INF/content/"/>
Լ���� actionName + resultCode + suffix 
���磺
����cn.kevin.struts.user.UserAction����success
Convention����ʹ�� WEB-INF/content/user/user-success.jsp
���user-success.jsp�����ڣ���ʹ��user-success.html
���user-success.html�����ڣ���ʹ��user.jsp




<%@ taglib prefix="s" uri="/struts-tags" %>
OGNL
	> Object Graph Navigation Language
	> ����ͼ,��������
1,ֱ�ӷ���ջ�е�Action����
	<s:property value="userName"/>
	* value,������������,����������Ա���Ҫ��getXxx();����
	!!!!ע�Ⱑ,���ֵܣ�OGNL���ʽָ����value���������,���������ǩ��Ҳ����˵����ʼǶ���Χ�������value�����������˵��
2,����Action�ж��������
	<s:property value="user.username"/>
	* һ��������,�������Action��use����,����������user��username����
	* ͬ��,ActionҪ�ṩuser��get/set.����user����ҲҪ�ṩusername��get/set
	* һ��ͨ,��ͨ!������Action�еĶ���,�ְ�������һ������,��һ�������ְ�������һ������,�����һֻxxx.xxx.xxx...������ȥȡ��ֵ
3,����ֵջ����ͨ�������ͨ����
	<s:property value="userName.length()"/>
	* ��ֻ��һ����ͨ����ʾ,�������Action�����userName���Եĳ���
5,����ֵջ��Action����ͨ����
	<s:property value="execute()"/>
	* ����㶮��,���Ƿ�����Action�е�execute����,����ľ��������ַ�������ֵ
6,����Action�еľ�̬����
	<s:property value="@����ȫ·��@��̬������()"/>
	* ��סxml�е�����<constant name="struts.ognl.allowStaticMethodAccess" value="true"/>
	* ��������ò�����,����ֵΪfalse,��ô�ǻ�ȡ������̬�����ķ���ֵ��
7,����Action�еľ�̬��Ա
	<s:property value="@����ȫ·��@��̬��Ա��"/>
	* ��̬��Ա�Ļ�ȡ�ǲ���ȥxml���ó�����,�κ�ʱ��֧��
8,Math������֧��
	 <s:property value="@@max(1,2)"/>
	 * ֱ�������ط���,���Ϸ�������
	 * ע��,ֻ��ʹ��Math����ķ���,���ֻ��ʹ����Math�������
9,������ͨ��Ĺ��췽��
	<s:property value="new ����ȫ·��('�������')"/>
	* ����,��Ϊ���ù���,��û�����ԭ��.��ñ���


	************************************ ���ʼ��Ͽ�� ************************************
---����List
1,����List
	<s:property value="Action�Ļ�ȡList��������"/>
	* ֱ�ӻ�ȡ�ľ���list
2,����List��ĳ��Ԫ��
	<s:property value="������[�±�]"/>
	* ���������Ĳ��,ֻ�Ƕ��˸��±�,����Ϊ��ȷ��Ҫȡ��һ��,���滹���Ը���������������.
3,����List��ĳ�����Եļ���
	<s:property value="list������.{Ԫ��������}"/>
	* �ⶫ�����ǰ�List�������������Ԫ�ص�ָ�����Ե�ֵ,���������������:����������������˵�����
4,����List��ĳ�����Եļ����е��ض�ֵ
	<s:property value="list������.{Ԫ��������}[�Ǳ�]"/>
	* ����������Ǹ�����һ��,��Ҫ����ָ�����ϵ��е�ָ���Ǳ���Ǹ�������:����������������˵�����.�Ǳ�Ϊ2���Ǹ�
---����Set
1,����Set
	<s:property value="Action�Ļ�ȡSet��������"/>
	* ��ȡָ�����Ƶ�Set]
2,����Set�е�ĳ��Ԫ��
	* ������,Set��û�Ǳ��,��ָ���ýǱ�����ȡ
---����Map
1,����Map
	<s:property value="Action�Ļ�ȡMap��������"/>
	* ֱ�Ӿ��ǻ�ȡMap
2,����Map��ĳ��Ԫ��
	<s:property value="Map��.ָ��Keyֵ"/>
	<s:property value="Map��['ָ����keyֵ']"/>	������һ��д����ע�����ͺ�
	* ����ָ����keyֵ�������Ӧ��valueֵ
3,����Map�е�����Key
	<s:property value="��ȡMap��������".keys"/>
	* �õ������Ǹ�Map�е�����Keyֵ
4,����Map�е�����value
	<s:property value="��ȡMap��������".values">
	* �õ�����Map�е�����valueֵ
5,���������Ĵ�С
	<s:property value="����.size()"/>
	* ���ܵķ���,ֻҪ��size();��������Ķ�����ö��ǿ��Ա�ִ�е�!

************************************ ͶӰ(����) ************************************
<s:property value="list.{?#this.age==1}.{age}"/>
	> ��ȡ�������list������,age���Ե���1��Ԫ�ص�age���Ե�ֵ�ļ���
<s:property value="list.{^#this.age > 1}.{age}"/>
	> age����1�ļ�������,�ĵ�һ��
<s:property value="list.{$#this.age > 1}.{age}"/>
	> ������һ��,��β���Ǹ�
<s:property value="list.{$#this.age > 1}.{age} == null">
	> �ж�һ��,age����1����������ǲ��ǿյ�

************************************ �����ŷ��� ************************************
<s:property value="[]"/>
	> ����
<s:property value="[0]"/>
	> ����
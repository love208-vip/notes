����struts2�Ĺ��ʻ�
����˵,ֱ����

1,׼����Դ��,���һ����������ʽ
	baseName_language_country.properties
	baseName_language.properties
	baseName.properties
> baseName ����Դ�ļ��Ļ�������,���ǿ����Լ�����
> language �����������,������JAVA����ʶ��ľ�̬���� 
> country  �������,Ҳ������JAVA����ʶ��Ĺؼ���
����:
	> baseName_zh_CN.properties
	> baseName_en_US.properties

2,Ϊ���ǵ���Ŀ�������Դ�ļ�
--����
>  ��һ��������� demo.zh.CN.properties
	* welcome="��ӭ"
>  �ڶ������Ӣ�� demo.en.US.properties
	* welecome="welcome"

3,�������е�����,���Ǳ�д���˺�,Ӧ��ʹ��JDK�ṩ��native2ascii������ļ�ת��Ϊunicode�����ʽ
> ����
native2ascii Դ�ļ� Ŀ���ļ�.properties

4,������ʹ��λ�õ��޶�
1,����Ϊȫ����Դ�ļ�
	> ��struts.xml�ļ���,���ó���
	* <constant name="struts.i18n.encoding" value="��Դ�ļ�������"></constant>

5,������Դ�ļ�
1,��JSPҳ����ʹ�ñ�ǩ����� 
	* <s:text name="welcome"/>	name���Ե�ֵ,������Դ�ļ��е�key
2,��Action����,���Լ̳�ActionSupport.ʹ��getText(String name)����,�õ����ʻ���Ϣ.name������Դ�ļ��е�Key
3,����ҳ�ı���ǩ��,ͨ��key����ָ����Դ�ļ��е�key
����:
	<s:textfield name="realname" key="user"/>


6,�������ռλ���Ĺ��ʻ���Դ
1,��Դ�ļ��н����޸�
	welcome={0}��ӭ{1}	//���ĵ�
	welcome={0}welcome{1}	//Ӣ�ĵ�
2,��JSPҳ�������ռλ������Դ
<s:text name="welcome">
	<s:sparam>
		<s:property value="1>
	</s:sparam>
</s:text>

3,��Action���л�ȡ����ռλ���Ĺ��ʻ���Դ
ʹ��:
	getTest(String key,String[] agrs);
	getTest(String name,List ages);




---------------
ResourceBundle res = ResourceBundle.getBundle("��Դ�ļ���,",Local.US);
System.out.println(res.getString("key"));

*	��Դ�ļ���,���Ǽ��ص��ĸ���Դ�ļ�,����ݺ����Local.US�������ж�,����Ǵ�������,������й�,��ô�ͻ�����й���properties�ļ�
*	res.getString("key");,����key������Ҫ�����������Ĺؼ���,����:��¼,�ں������ǵ�¼,Ӣ���о���Login
����֪��,��JAVA�д��ںܶ���������������
����:Date,
���ǿͻ��˴��ݹ�����,ȫ�������ַ�������,��ô��ʱ����ͳ����ˣ�
	
1,struts2�յ��ͻ��˲�����,Ĭ�ϵĻ��Action���������ͽ���ת��.����ת���ķ�ʽ��ʱ����������Ҫ�ġ�����:
	> Date����
	* �ͻ����ύ�����ݱ�����:1993-12-09���ʽ������,��ô��ܲŻ��Զ�ת��,�����������ƥ������,���ǲ�����ʽûƥ��,��ô����ִ��ת����ע��
	* Ĭ�ϵ�����,�����Զ����˸�ʽ�����,��������,���ң�

2,struts2������"����ת����"
*************************************************�ֲ�����ת����*************************************************
> ֻ��ĳһ��Action������
1,�Զ���java��
  > �̳�:DefaultTypeConverter
	* ����ȫ·��:com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;
2,��дconvertValue����(��ϸDemo�����)
  > ��д:public Object convertValue(Map<String, Object> context, Object value,Class toType)
	* ע�ⷽ��ǩǩ��,��д����.�����м���������ʽ���ֵ�ͬ������j
  > context,�Ȳ���.ognl���ʽd����
  > Object value;
	> ���ֵ,�������Ǵӿͻ��˽��յ���ֵ
	* ��Ϊ�ͻ��˴��ݵ�ֵ��ȷ��,���Կ��ֱ�Ӿ���ObjectȻ��,������ʹ�õ�ʱ��,��Ҫǿת����ȷ������,����:����,String
  > Class toType
	> ���ֵ,��������Ҫת��������
	* ���ֵ,�������ǹ�!�ǿ�ܶ�ȡ��Action������֮��õ���,���ֵ�������Ե�Class
	* һ�������������ж�
---------����
public Object convertValue(Map<String, Object> context, Object value,Class toType) 
{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");	//��Ϊ����Ҫ�����Action��Date�ֶν���ת�����Զ�������Զ����ʽ�����ڸ�ʽ������
	//���������Ҫ�ڲ�������,��������ĸ�ʽ��һ��,��ô���԰������ʽ����������if�ж������,��ͬ�����ʽ�ͺ�
	try
	{
		if(toType == Date.class)		//�����ܶ�ȡ��Action���Ե�Class ��Date,��ô�ͰѲ����ַ���,��������ָ���ĸ�ʽת����Date,���ظ���Action��date.
		{
			//�ַ���תDate
			String[] params = (String[]) value;//request.getParameterValues();
			return sdf.parse(params[0]);
		}
		else if(toType == String.class)		//�����Ҫ�����ǵ�Date�����ҳ��,Ҳ���������ʱ����String����,��ô�Ͱ����ǵ�Date����ʽ����ָ�����ͺ�,�����
		{
			//Dateת�ַ���
			Date date = (Date) value;
			return sdf.format(date);
		}
	}
	catch(ParseException e)
	{
		throw new RuntimeException(e);
	}
	return null;
}

3,ע��
  > ��һ��:��Ϊ�Ǿֲ���,��������Ҫ��ת����Actionͬ���´���һ��Poperties�ļ�,������ʽ�ǹ̶���,�����޸ı����ϸ�����
  * ��������:Action�ļ�����-conversion.properties	����:Demo-conversion.properties
  > �ڶ���:���չ���,���ø��ļ�
  * �ֶ���=ת����·��
	> �ֶ���,Ҳ�������Action����,����Ҫת�����ֶ���
	> ת����·��,������д���Ǹ�ת����,ע��,�Ǵ���ȫ·��
	> ����: date=com.kevin.filter.TypeDemo
  > ���ת����,����ʵ��˫��ת��,Ҳ���ǿͻ��˵�������,���������ͻ��ˣ�
  > ע��,��Ҫ�����,����:sql�µ�Date��util�µ�date.���жϵ�ʱ��������,������Ϊʲô֪����������ôѪ�Ľ�ѵ


*************************************************ȫ������ת����*************************************************
	> ��������Ŀ������
1,ͬ��,Ҳ�Ƕ���һ����,����ͬ��,�ҾͲ�д�ˣ�Ψһ�Ĳ�ͬ���������ļ������ò�ͬ
--��֮ͬ��
1,��WEB-INF/classesĿ¼��!Ҳ����srcԴ����Ŀ¼��.����ָ�����Ƶ��ļ�
	> xwork-conversion.properties
	* �����ʽ����Ҳ���ܱ�,ע��!
2,���չ���,�����ļ�
	> ��������=ת��������ȫ·��
	* ��Ϊ��ȫ��ת����,��ô�������Ƕ���ĳ��Action������,�����keyҲ��һ������ȫ·����JAVA������
	* ���ﶨ�����һ������.��������Ŀ����Action��������Ͷ��ᾭ�������ת��������
	* ����:java.util.Date=com.kevin.filter.TypeDemo





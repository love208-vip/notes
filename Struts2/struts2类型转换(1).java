����������������������������������������������������������������
һ,struts2���ṩ������ת��		|
����������������������������������������������������������������
	struts2�ڲ��ṩ�˴���������ת����,���������������ת������
	Date	-- >	"yyy-MM-dd"
	Boolean	--->	"true"/"false"
	Integer	-->		"1236"
	... ...
	strut������Զ��İ��ұߵ��ַ������͵�����,ת������ߵ���������
	* ����,�����ʽ����ȷ���п��ܻ��׳��쳣!

	һ��,�����ٿ�����ʹ����ЩĬ�ϵ�ת�����͹�����,����Ҳ�����������ʹ�õ��Զ��������ת����
	����:struts2�ж� Date ��ת��,Ĭ���� "yyyy-MM-dd"!��ʱ��������Ҫ��Щ�ı�!

����������������������������������������������������������������
��,truts2������ת��������ϵ		|
����������������������������������������������������������������
	com.opensymphony.xwork2.conversion
	* ����struts2����ת�����ĸ��ӿ�.MyGod,�����Դ�붼���㸴�ƹ�����(����ô��)
		package com.opensymphony.xwork2.conversion;
		import java.lang.reflect.Member;
		import java.util.Map;
		public interface TypeConverter
		{
			public Object convertValue(Map<String, Object> context, Object target, Member member, String propertyName, Object value, Class toType);
			
			public static final Object NO_CONVERSION_POSSIBLE = "ognl.NoConversionPossible";
			
			public static final String TYPE_CONVERTER_CONTEXT_KEY = "_typeConverter";
		}
	* ��������N���ʵ����.
		ArrayConverter
		CollectionConverter
		DateConverter
		EnumConverter
		NumberConverter
		StringConverter
		StrutsTypeConverter
		....
		* ������û?strut2�е��������͵�ת����������������ӿ�!
		* ����֪������������Ժ�,����Ҳ����ʵ������ӿ�������Զ��������ת����
����������������������������������������������������������������
��,truts2�Զ�������ת����		|
����������������������������������������������������������������
'���²���'
	1,�����Զ���ת������,ʵ��'TypeConverter'�ӿ�
	2,��д:public Object convertValue(Map<String, Object> context, Object target, Member member, String propertyName, Object value, Class toType);����
	3,ע������ת����

���
һ,�����Զ���ת������
	1,ʵ��TypeConverter��Ҫ��дconvertValue����ܳ����Ʒ���!��6������,������
		* ���ʵ������ӿ�,������JB���ˣ�����... ...���ǿ��Լ̳�һ���Ѿ�ʵ��������ֽӿڵ���!
	2,�̳�DefaultTypeConverter
		* com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter
		* ֻ��Ҫ��д:public Object convertValue(Object value, Class toType)
		* û��ô�����,����

��,��д����['�������']
		..���۽���,����ͬһ������.ͨ���жϲ���toType,��class������ȷ��.�ⶫ���Ǵ�ҳ�洫��,���Ǵ�Action����!
		ִ���߼������.��return��ֵ,�������յ�ֵ!

��,ע���Զ�������ת����['�����ַ�ʽ']
	1,'�ֲ�'--�����Action
		* ���ַ�ʽ,���ǰ�Action����Model����!
		* ��Action�����ڰ��´���:'Action����-conversion.properties'
		* �������ø�����һģһ��
	2,'�ֲ�'--�����Model
		* ��Model�����ڰ��´���:'Model����-conversion.properties'
		* ���ļ��е�ת�������ʽΪ:��������=����ת������ȫ����
		* ��:birthday=com.kevin.util.MyTypeConverter
	3,'ȫ��'--All
		* ȫ�־������������WEB��Ŀ,��ָ���ļ���ָ����Ҫ��ת����java��������!�Լ�����ת����ȫ����
		* ��src�´���һ���ļ�:'xwork-conversion.properties'
		* �����ļ�����д��ʽ:Ҫת��������ȫ��=�Զ��������ת����ȫ����
		* ��:java.util.Date=com.kevin.util.MyTypeConverter

��,'ע��'
	1,result��ͼ��Ӱ��
		����struts2��,����ת����!����������ύ��ʱ��,��������Model��װ,����������!
		��ô���Զ��İ�action��'result',��Ϊ'input'!Ҳ����˵������Ҫ׼������Ӧ����ͼ,�����struts2���Զ�У��
		���,ת���������쳣,������û�ж���'input'��result��ͼ!��ô�ͻ��׳��쳣!
		'ԭ��'
		struts-default.xml	�е�������������
			<interceptor-ref name="conversionError"/>					['���������쳣ת��������,��¼��action']
			* ������ת�����������ʱ��,������action�д洢������Ϣ
			<interceptor-ref name="workflow">							['������action�����б��������,��������������ִ��,����input']
				<param name="excludeMethods">input,back,cancel,browse</param>
			</interceptor-ref>
			* ��ǰ���������,����������,���ҰѴ�����Ϣ�����Action��!��ô����������ͻ��Զ�����ת��name="input"��result��ͼ
			* ������Ҳ��Ĭ�ϵ��������C�е����һ�ڶ���
		* �ڶ�Ӧ��resultҳ��,����ͨ��struts2�ı�ǩȡ��������Ϣ(�ǵõ����ǩ��)
			* <st:fielderror/>
			* Ӣ�ĵ�,����ͨ�����ʻ��Ĵ���!�������!
			
	2,ԭʼת����ʽ������
		struts2��Date,ԭʼ��ת�͸�ʽ��:'yyyy-MM-dd'.��������Զ���Ϊ:'yyyy/MM/dd'!��ôԭʼ��ʽ��������������!
	3,һ��properties�ļ��п�����������ֶ�,Ҳ����˵�������ö������ת����!
	4,������Զ�������ת���������쳣,��Ҫ��ת��name='input'��result��ͼ!��ô�쳣��Ϣ,catch��֮��,�׳�ȥ:throw new RuntimeException(e);!��Ȼ�������޷���׽���쳣,�ǲ�����ת��!

	
����������������������������������������������������������������
��,truts2������					|
����������������������������������������������������������������
	�ڶ���������ת������,�����Լ̳�һ������Apache������...
	org.apache.struts2.util.StrutsTypeConverter
	����һ��������,��ʵ���������'DefaultTypeConverter'������Զ�����ȥ�̳�����
	����ǿ��֮������,������������������ת��������!�ر�ţ��!['Դ���������']
	 
	* ��ʵ�Ƽ��̳������:StrutsTypeConverter
	�����,ţ��ָ������!��������������
	1,һ����,��ҳ�����ݵ�Action������ת������
	2,һ����,Action���ݵ���ҳ������ת���Ĵ���
	* ��Ȼ,����ţ�������ķ���,�ǳ����.����Ҫ�����Լ�ȥ����!
	������:
	public abstract Object convertFromString(Map context, String[] values, Class toClass);
	> ����ӱ�ҳ���ύ��Action������ת������
		* context,��ʱ���.OGNL�Ķ���
		* values:�ӱ����ݹ���������,��������ʽ���
		* toClass:����Ҫת��������(Model�ж�Ӧ�ֶε�ʵ������)!
	> ��ʵֻ�õ�values,�ͺ�!����returnʲô,��ôModel��Ӧ���ֶξͽ���ʲô!
	public abstract String convertToString(Map context, Object o);
	> �����Action�������ݴ��ݵ�ҳ���ת������
		* context:OGNL�Ķ���!
		* o:���Ǵ�����Action�������������,����Ҫ���ʲô���Ӹ�ҳ��,��return��ʲô����!
	
['�ó�����Դ��']
package org.apache.struts2.util;
import java.util.Map;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;
public abstract class StrutsTypeConverter extends DefaultTypeConverter 
{
	public Object convertValue(Map context, Object o, Class toClass)
	{
		if (toClass.equals(String.class)) 
		{
			return convertToString(context, o);
		} 
		else if (o instanceof String[])
		{
			return convertFromString(context, (String[]) o, toClass);
		} 
		else if (o instanceof String) 
		{
			return convertFromString(context, new String[]{(String) o}, toClass);
		}
		else 
		{
			return performFallbackConversion(context, o, toClass);
		}
	}
	protected Object performFallbackConversion(Map context, Object o, Class toClass) 
	{
		return super.convertValue(context, o, toClass);
	}
	/**
		��ҳ�浽Action��ת������
	*/
	public abstract Object convertFromString(Map context, String[] values, Class toClass);
	/**
		��Action��ҳ���ת������
	*/
	public abstract String convertToString(Map context, Object o);//ȥ��ʱ��ת��
}
['demo']
package com.kevin.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;
/**
 * �Զ�������ת����
 * �̳�StrutsTypeConverter������
 * @author KevinBlandy
 * @date   2015��12��29�� 19:40:18
 * */
public class MyTypeConverter extends StrutsTypeConverter
{
	/**
	 * ��ʽ��
	 * */
	private String[] simpleDateFormats = new String[]{"yyyy/MM/dd","yyyy-MM-dd","yyyy MM dd","yyyy.MM.dd"};//��ʽ������
	private Date date;
	/**
	 * ����ҳ������,ת��ΪAction��Ҫ������
	 * */
	public Object convertFromString(Map context, String[] values, Class toClass) 
	{
		String value = values[0];
		try 
		{
			date = new SimpleDateFormat(simpleDateFormats[0]).parse(value);//ת���쳣,��һ��ת����ʽ
		} 
		catch (ParseException e)
		{
			try
			{
				date = new SimpleDateFormat(simpleDateFormats[1]).parse(value);//ת���쳣,��һ��ת����ʽ
			}
			catch (ParseException e1) 
			{
				try 
				{
					date = new SimpleDateFormat(simpleDateFormats[2]).parse(value);//ת���쳣,��һ��ת����ʽ
				} 
				catch (ParseException e2) 
				{
					try 
					{
						date = new SimpleDateFormat(simpleDateFormats[3]).parse(value);//ת���쳣,��һ��ת����ʽ
					} 
					catch (ParseException e3) 
					{
						throw new RuntimeException(e);//û����,�����ڷ�Χ:��,���Ǹ���ɶ������������!Ȼ��ת����input��ͼ
					}
				}
			}
		}
		return date;
	}
	/**
	 * ����Action����,ת��Ϊҳ����Ҫ������
	 * */
	public String convertToString(Map context, Object obj) 
	{
		return null;
	}
}

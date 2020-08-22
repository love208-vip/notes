

	SptingMVC��,����ҳ���ύ��������ͨ���β�������,������ struts2����ͨ����Ա����.
	
		1,�ͻ�������,Я��key-value����
		2,����������������springmvc�ṩ��'���������',��key-value����ת��Ϊcontroller�������β�
	


	���������
		1,������ڵ�ʱ��,ʹ��PropertEditor,ֻ�ܰ��ַ���תΪJAVA����
		2,�����ھ�ʹ�� Converter,���Խ����������͵�ת��
		  springmvc�ṩ�˺ܶ�Converter(ת����),�����������,��Ҫ�Զ���Converter	
		3,��key-value�����ݰ󶨵��������β�

['������Ĭ��֧�ֵ�����']
		* Ҳ����Controller�β�֧�ֵ�����
		��������������
		POJO
		HttpServletRequest
		HttpServletResponse
		HttpSession
		Model/ModelMap
			* ModelMap��Model�ӿڵ�ʵ����,ͨ��Model����ModelMap��ҳ�洫������.����������ʵ��һ����.ģ��������䵽request��.
		
		* ͨ��JAVA����,��ȡ���������β�,�����������������.��ô�ͽ��в�����
		


['Date֮����������ʹ���']
		* ʵ���������͵Ĳ�����.
		* ��Ҫ��������������,ע�������Զ���Ĳ��������


		<!-- Springmvcע������ -->
		<mvc:annotation-driven conversion-service="conversionService"/>
		<!-- ����ת���� -->
		<bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
			<!-- �Զ�������ת�� -->
			<property name="converters">
				<list>
					<bean class="com.kevin.conversion.DateConversion"/>
				</list>
			</property>
		</bean>


	package com.kevin.conversion;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import org.springframework.core.convert.converter.Converter;
	/**
	 * ���ڸ�ʽת����
	 * 	String:һ�㲻��,������
	 * 	Date  :����ת����Ľ����������(Ҳ����Controller�Ĵ��������β�����)
	 * */
	public class DateConversion implements Converter<String,Date>
	{
		//�ַ������ݸ�ʽ
		private String[] types = new String[]{
				"yyyy-MM-dd",
				"yyyy/MM/dd",
				"yyyy.MM.dd",
				"yyyy��MM��dd��"
		};
		/**
		* ��Ҫע�����,�÷����ķ���ֵ����,����Ҫ��Handler�е��β�/POJO�е�����,!��ȫ��ͬ
		**/
		public Date convert(String date)
		{
			try 
			{
				return new SimpleDateFormat(types[0]).parse(date);
			}
			catch (ParseException e)
			{
				try 
				{
					return new SimpleDateFormat(types[1]).parse(date);
				}
				catch (ParseException e1) 
				{
					try 
					{
						return new SimpleDateFormat(types[2]).parse(date);
					}
					catch (ParseException e2) 
					{
						try
						{
							return new SimpleDateFormat(types[3]).parse(date);
						}
						catch (ParseException e3)
						{
							return null;
						}
					}
				}
			}
		}
	}

		-----------------------

		Converter<Դ����,Ŀ������>
		public Ŀ������ convert(Դ����)
		{
			//�߼�����
		}


============================׸��
�Զ�������ת����
	* ConversionService ��Spring����ת���ĺ��Ľӿ�.
	* ��������:ConversionServiceFactoryBean��Spring��IOC�д���һ��ConversionService!
	* Spring�����Զ�ʶ��,��IOC�����е�ConversionService,����Bean�������ü�SpringMVC�������βΰ󶨵ȳ���,ʹ�����������ݵ�ת��
	* ��ͨ��ConversionServiceFactoryBean ��converters����ע���Զ��������ת����

	SpringMVC ֧�ֵ�ת����
		* Spring������3�����͵�ת�����ӿ�,ʵ������һ��ת���ӿڶ�������Ϊ�Զ���ת����ע�ᵽConversionServiceFactoryBean��
		1,Converter<S,T>	['����']
			* ��S����ת��ΪT����,һ�����.S���ǿͻ��˴��ݵĲ���.����ΪString����
		2,ConverterFactory
			* ����ͬϵ�ж��"ͬ��",Converter��װ��һ��,���ϣ����һ�����͵Ķ���ת��Ϊ��һ�����ͼ�������Ķ���
			* ����:��String ת��ΪNumber,�Լ�Number����,�Ϳ���ʹ�����ת����������
		3,GenericConverter
			* �����Դ������Լ�Ŀ����������ڵ����������������Ϣ��������ת��.
		

		<!-- Springmvcע������ -->
		<mvc:annotation-driven conversion-service="conversionService"/>
		<!-- ����ת���� -->
		<bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
			<!-- �Զ�������ת�� -->
			<property name="converters">
				<list>
					<bean class="com.kevin.conversion.DateConversion"/>
				</list>
			</property>
		</bean>



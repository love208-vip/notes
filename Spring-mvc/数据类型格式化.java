


1,��������ת��
	* �����ʵ�Ա���N�������ת����,��ʵ�ǲ���Ҫ�����Լ�ȥ�����
	* �Զ�����������ת����
	* ConversionService ��Spring����ת����ϵ�ĺ��Ľӿ�
	  ��������ConversionServiceFactoryBean��Spring��IOC�����ж�һ��ConversionService
	  Spring���Զ�ʶ���OIC�����е�ConversonService,����Bean�������ü�Spring MVC�������βΰ󶨵ȳ���ʹ�����������ݵ�ת��
	* ����ͨ��ConversionServiceFactoryBean��converters����ע���Զ�������ת����

	<bean id="conversionService" class="org.springfamework.context.support.ConversionFactoryBean">
		<property name="converters">
			<list>
				<bean class="com.kevin.converte.MyConverter"/>
			</list>
		</property>
	</bean>

2,�������͸�ʽ��
3,����У��
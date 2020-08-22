<bean 
	id=""
	name=""
	class=""
	init-method=""
	scope=""
	abstract=""
	depends-on="" 
	autowire="" 
	autowire-candidate="" 
	destroy-method="" 
	factory-bean="" 
	factory-method="" 
	lazy-init="" 
	parent="" 
	primary=""
/>
	# ������Bean�������

<context:component-scan base-package="com.tedi" use-default-filters="false">
	<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
	<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"
</context:component-scan>
	# ɨ��

<aop:aspectj-autoproxy proxy-target-class="true" />
	# ʹ��CGLIB��̬����

<tx:advice id="txAdvice" transaction-manager="trans">
	<tx:attributes>
		<tx:method name="get*" read-only="true"/>
		<tx:method name="find*" read-only="true"/>
		<tx:method name="*" />					
	</tx:attributes>
</tx:advice>
	# �����������

<aop:config>
	<aop:pointcut expression="execution(* com.tedi.community.web.service..*(..))" id="community-service"/>

	<aop:advisor advice-ref="txAdvice" pointcut-ref="community-service"/>

	<aop:aspect ref="dataSourceAspect" order="-9999">
		<aop:before method="before" pointcut-ref="community-service" />
	</aop:aspect>
</aop:config>
	# AOP����
		

<context:property-placeholder location="classpath:jdbc.properties"/>
	# �����ⲿ�����ļ�

<context:annotation-config/>
	# ��xml����bean�е��Զ�װ��ע����Ч
	# component-scan ��ǩ���Զ���ע�����
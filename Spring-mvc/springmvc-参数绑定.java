--------------------------------
�Զ���						|
--------------------------------
	* �������


--------------------------------
�Զ����						|
--------------------------------
	1,�Զ�����ʵ��:HandlerMethodArgumentResolver
	2,���ø��ൽIOC
		<mvc:annotation-driven>
			<mvc:argument-resolvers>
				<bean class="resolver.MyResolver"/>
				<bean class="resolver.MyModelAttributeResolver"/>
			</mvc:argument-resolvers>
		</mvc:annotation-driven>
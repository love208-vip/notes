------------------------
Shiro-����Spring		|
------------------------
	

------------------------
Shiro-Shiro Filter		|
------------------------
	# ��web.xml������һ��filter
		<!-- shiro filter -->
		<filter>
			<filter-name>shiro</filter-name>
			<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
		</filter>
		<filter-mapping>
			<filter-name>shiro</filter-name>
			<url-pattern>/*</url-pattern>								
			<dispatcher>REQUEST</dispatcher>
			<dispatcher>FORWARD</dispatcher>
			<dispatcher>INCLUDE</dispatcher>
			<dispatcher>ERROR</dispatcher>
		</filter-mapping>																	*/
	
	# ��������������Shiro��filter
	

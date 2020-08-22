------------------------
Druid����				|
-----------------------	
	* ����,�ⶫ����һ�����ӳ�,ʵ���� DataSource 
	* �����ڰ���Ͱͼ���,��Դ,���
	* ���Ŀںž���,Ϊ��ض��������ݿ����ӳ�
------------------------
spring����				|
-----------------------	
	<bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
		<property name="driverClassName" value="${jdbc.driverClass}"/>
		<property name="url" value="${jdbc.jdbcUrl}"/>
		<property name="username" value="${jdbc.user}"/>
		<property name="password" value="${jdbc.password}"/>
		 <!-- ���ü��ͳ�����ص�filters -->
		<property name="filters" value="stat"/>
		<!-- ��������� -->
		<property name="maxActive" value="20"/>
		<!-- ��ʼ������ -->
		<property name="initialSize" value="5"/>
	</bean>

	* ���ض�˵,��Ϥ���ӳ�,��Ӧ�ö�


	* ��������˵һ��Drui��ţ��֮��
	* ���Ӽ��
		1,��web.xml������һ��Servlet
			<!-- Druid��� -->
			<servlet>
				<servlet-name>Druid</servlet-name>
				<servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
				<!-- �û��� -->
				<init-param>
					<param-name>loginUsername</param-name>
					<param-value>admin</param-value>
				</init-param>
				<!-- ���� -->
				<init-param>
					<param-name>loginPassword</param-name>
					<param-value>admin</param-value>
				</init-param>	
			</servlet>
			<!-- Druid��� -->
			<servlet-mapping>
				<servlet-name>Druid</servlet-name>
				<url-pattern>/druid/*</url-pattern>							*/
			</servlet-mapping>

			<!-- WEB URI ��� -->
			<filter>
				<filter-name>DruidWebStatFilter</filter-name>
				<filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
				<init-param>
					<!-- һЩ�ų����� -->
					<param-name>exclusions</param-name>
					<param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
				</init-param>
			</filter>
			<filter-mapping>
				<filter-name>DruidWebStatFilter</filter-name>
				<url-pattern>/*</url-pattern>																	*/
			</filter-mapping>

		2,ͨ�����������
			http://localhost:8080/kevinblandy/druid/index.html

		

		*���ܹ��������е����ݼ��
		



ʵ����ҵ����Ŀ������:

<!-- ��������Դ(���ӳأ�druid) -->
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
	<!-- �������� url��user��password -->
	<property name="url" value="${db.url}"/>
	<property name="username" value="${db.username}"/>
	<property name="password" value="${db.password}"/>

	<!-- ���ó�ʼ����С����С����� -->
	<property name="initialSize" value="${db.pool.initialSize}"/>
	<property name="minIdle" value="${db.pool.minIdle}"/>
	<property name="maxActive" value="${db.pool.maxActive}"/>

	<!-- ���û�ȡ���ӵȴ���ʱ��ʱ�� -->
	<property name="maxWait" value="60000"/>

	<!-- ���ü����òŽ���һ�μ�⣬�����Ҫ�رյĿ������ӣ���λ�Ǻ��� -->
	<property name="timeBetweenEvictionRunsMillis" value="60000"/>

	<!-- ����һ�������ڳ�����С�����ʱ�䣬��λ�Ǻ��� -->
	<property name="minEvictableIdleTimeMillis" value="300000"/>

	<property name="validationQuery" value="${db.validation}"/>
	<property name="testWhileIdle" value="true"/>
	<property name="testOnBorrow" value="false"/>
	<property name="testOnReturn" value="false"/>

	<!-- ��PSCache������ָ��ÿ��������PSCache�Ĵ�С��Oracleʹ�ã� 
	<property name="poolPreparedStatements" value="true" /> 
	<property name="maxPoolPreparedStatementPerConnectionSize"
	value="20" /> -->
	
	<!-- ���ü��ͳ�����ص�filters,wall:����SQLע�빥�� -->
	<property name="filters" value="stat,wall" />

	<!-- ��SQL��¼ -->
	<property name="connectionProperties" value="druid.stat.slowSqlMillis=5000" />

</bean>


	<!-- ����_Druid��Spring����������� -->
	<bean id="druid-stat-interceptor" class="com.alibaba.druid.support.spring.stat.DruidStatInterceptor"></bean>


------------------------
Durid-����				|
-----------------------	
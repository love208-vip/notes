------------------------
logback					|
------------------------
	# log4j���ߵ���һ������
	# logback��ǰ�ֳ�����ģ�飺
		logback-core
		logback- classic
		logback-access
		* logback-core����������ģ��Ļ���ģ�顣
		* logback-classic��log4j��һ�� �����汾��
		* logback-classic����ʵ��SLF4J APIʹ����Ժܷ���ظ�����������־ϵͳ��log4j��JDK14 Logging��
		* logback-access����ģ����Servlet���������ṩͨ��Http��������־�Ĺ��ܡ�
	
	# maven ����
		<!-- logger begin-->
		<!-- ���������滻spring����־ʵ�� -->
		<dependency>
		    <groupId>org.slf4j</groupId>
		    <artifactId>jcl-over-slf4j</artifactId>
		    <version>${slf4j-api.version}</version>
		</dependency>
		
		<dependency>  
		    <groupId>org.logback-extensions</groupId>  
		    <artifactId>logback-ext-spring</artifactId>  
		    <version>${logback-ext-spring.version}</version>  
		</dependency> 
		
		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
			<version>${logback.version}</version>
		</dependency>
		<!-- logger end -->

------------------------
logback	- �������		|
------------------------
	logback.xml ����
		<configuration>
			<property name="LEVEL" value="DEBUG"/>
			<property name="PATTERN-A" value="%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"/>
			<property name="PATTERN-B" value="[%-5p][%thread][%d{yyy-MM-dd HH:mm:ss}][%C %M] ==> : %m%n"/>

			<appender name="ROOT" class="ch.qos.logback.core.ConsoleAppender">
				<encoder>
					<pattern>${PATTERN-A}</pattern>
					<charset>UTF-8</charset>
				</encoder>
				<target>System.out</target>
			</appender>
			
			<root level="${LEVEL}">
				<appender-ref ref="ROOT"/>
			</root>
		</configuration>

		appender	:ͨ�� class ��ȷ����ǰappender�����������̨����������ļ���,���ǹ���,��ͬ�� class ���в�ͬ���ӱ�ǩ����������
		root		:�������һ�����߶�� appender
	

	web.xml ����
		<listener>
			<listener-class>ch.qos.logback.ext.spring.web.LogbackConfigListener</listener-class>
		</listener>
		<context-param>
			<param-name>logbackConfigLocation</param-name>
			<param-value>classpath:logback.xml</param-value>
		</context-param>
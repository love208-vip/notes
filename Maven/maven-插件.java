-------------------------------
������						|
-------------------------------
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<version>3.7.0</version>
		<configuration>
			<source>1.8/source>
			<target>1.8</target>
			<encoding>UTF-8</encoding>
		</configuration>
	</plugin>

-------------------------------
Զ�̲�����					|
-------------------------------
	1,tomcat�����û���Ȩ��
		* �������
		* ./conf/tomcat-users.xml
			<role rolename="manager-script"/>
			<user username="admin" password="password" roles="manager-script"/>
		* ����tomcat9��˵������ͬʱ�����û�manager-script��manager-gui��ɫ��
		* Զ�̲���,������Ҫ�� manager-script ��ɫ
	
	2,�޸�IP����
		* �޸�����
		* �������޶���Զ�̷���manager��IP
		* webapps/manager/META-INF/context.xml
			<Context antiResourceLocking="false" privileged="true" >
				<!--
			  <Valve className="org.apache.catalina.valves.RemoteAddrValve"
					 allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" />
				-->
			</Context>
		* ע�͵��ӱ�ǩ

	
	3,��Ӳ��
		<plugin>
			<groupId>org.apache.tomcat.maven</groupId>
			<artifactId>tomcat7-maven-plugin</artifactId>
			<version>2.2</version>
			<configuration>
				<url>http://59.110.143.96/manager/text</url>			/*/
				<username>KevinBlandy</username>
				<password>F8575532</password>
				<update>true</update>
				<!-- ע��,��·�������ظ� -->
				<path>/teach</path>	
			</configuration>
		</plugin>
	
	4,����
		tomcat7:deploy
		tomcat7:redeploy
		tomcat7:undeploy

		* ����ǵ�һ�β�������mvn tomcat7:deploy�����Զ�����(����tomcat8,9��Ҳ��ʹ��tomcat7����)��
		* ����Ǹ����˴�������²�����£�����mvn tomcat7:redeploy��
		* �����һ�β���ʹ��mvn tomcat7:redeploy����ֻ��ִ���ϴ�war�ļ��������������Զ���ѹ����
		* ���·����tomcat���������Ѵ��ڲ���ʹ��mvn tomcat7:deploy����Ļ��������������һ��Ҫ����<update>true</update>����Ȼ�ᱨ��
	

	5,����ڴ�й©����
		* ��managerҳ���е��:[find leaks] ��ť
		* ��������������ڴ�й©��Ϣ,���Ƿ������ڴ�й©
			The following web applications were stopped (reloaded, undeployed), but their
			classes from previous runs are still loaded in memory, thus causing a memory
			leak (use a profiler to confirm):

		* ��Ŀ�������
			* Servlet2
				<dependency>
					<groupId>se.jiderhamn.classloader-leak-prevention</groupId>
					<artifactId>classloader-leak-prevention-servlet</artifactId>
					<version>2.2.0</version>
				</dependency>
			* Servlet3
				<dependency>
					<groupId>se.jiderhamn.classloader-leak-prevention</groupId>
					<artifactId>classloader-leak-prevention-servlet3</artifactId>
					<version>2.2.0</version>
				</dependency>


		* ����Ŀ��web.xml�����һ��Listener�������ô�Listener��Ϊweb.xml�еĵ�һ��Listener�����������ã�
			<listener>
				<listener-class>se.jiderhamn.classloader.leak.prevention.ClassLoaderLeakPreventorListener</listener-class>
			</listener>

		*��ע��
			1,������Listener��Ĭ����tomcat�ر�5s��jvm������ڴ���յĲ���������ʱ�����ÿ���������������ҵ������ԣ��ڹرպ��5s�ڣ��ٴ�����tomcat�����ܻ�������⣬����������Ч���������tomcat��������־��ʾ�������Ƿ������������Ļ�����һ���ǲ���������⣩��
				* https://github.com/mjiderhamn/classloader-leak-prevention
				<!-- ������ֹͣ��,�ȵȶ�ý����������� -->
				<context-param>
					<param-name>ClassLoaderLeakPreventor.threadWaitMs</param-name>
					<param-value>1000</param-value>
				</context-param>
			2,���Listenerֻ���������ڴ�й©���������⣨��jdbc�ȣ��������ڴ�й©����Ҫ�Լ����


	# ���Tomcat��̨�����ϴ�����war����С����
		* �༭:webapps/manager/WEB-INF/web.xml,��Լ50�д�
		* Ĭ����50MB,�޸�.�Ĵ�㡣�Ӹ�0
			<multipart-config>
				<!-- 50MB max -->
				<max-file-size>524288000</max-file-size>
				<max-request-size>524288000</max-request-size>
				<file-size-threshold>0</file-size-threshold>
			</multipart-config>

	# ����ɾ��ROOT��Ŀ

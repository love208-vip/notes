----------------------------
Spring-Boot ����			|
----------------------------
	
	# ���Ĺ���
		* ��webӦ�ó�������� jar ����ʽ����
			> ���� Jetty/Tomcat ������
		* �޴������ɺ�xml����
			> ����Ҫxml,Ҳ�������sprin����������
		* �ṩ spring-boot-starter-web ��maven����
			> maven�����ÿ�,���Զ������� spring ��һЩ���
		* �Զ����� spring
		* Ӧ�ü��
		
	# ѧϰ��վ
		https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started
		http://www.infoq.com/cn/articles/microframeworks1-spring-boot
		http://412887952-qq-com.iteye.com/blog/2344171
		http://i.youku.com/i/UMjM3MTgwNzI4/videos?spm=a2hzp.8244740.0.0&qq-pf-to=pcqq.group
	
	# ������WEB���� & ���
		<parent>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-parent</artifactId>
			<version>1.5.1.RELEASE</version>
		</parent>
		<dependency>
	        <groupId>org.springframework.boot</groupId>
	        <artifactId>spring-boot-starter-web</artifactId>
    	</dependency>
		<build> 
			<plugins>
				<plugin>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-maven-plugin</artifactId>
				</plugin>
			</plugins>
		</build>

	# ������,ֱ����������
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.boot.web.support.SpringBootServletInitializer;

		@SpringBootApplication
		public class ParkApplication extends SpringBootServletInitializer{

			public static void main(String[] args){
				SpringApplication.run(ParkApplication.class,args);
			}
		}


	# ��ͳ��spring��Ŀ
		web.xml
			* ǰ�˿�����,����servlet.xml
			* Spring ����filter
			* Spring IOC ����
			* Druid ���
		servlet.xml
			* mvc:annotaion
				* �Զ���converter
			* interceptor
			* ��ͼ������
			* �ļ��ϴ�֧��
		application-context.xml
			* DataSource
			* �־ò㹤��
			* 
		

----------------------------
Spring-Boot ģ��			|
----------------------------
			spring-boot-starter					���� POM�������Զ�����֧�֡���־��Ͷ� YAML �����ļ���֧�֡�
			spring-boot-starter-amqp			ͨ�� spring-rabbit ֧�� AMQP��
			spring-boot-starter-aop				���� spring-aop �� AspectJ ��֧�����������̣�AOP����
			spring-boot-starter-batch			֧�� Spring Batch������ HSQLDB��
			spring-boot-starter-data-jpa		���� spring-data-jpa��spring-orm �� Hibernate ��֧�� JPA��
			spring-boot-starter-data-mongodb	���� spring-data-mongodb ��֧�� MongoDB��
			spring-boot-starter-data-rest		ͨ�� spring-data-rest-webmvc ֧���� REST ��ʽ��¶ Spring Data �ֿ⡣
			spring-boot-starter-jdbc			֧��ʹ�� JDBC �������ݿ⡣
			spring-boot-starter-security		���� spring-security��
			spring-boot-starter-test			�������õĲ���������������� JUnit��Hamcrest��Mockito �� spring-test �ȡ�
			spring-boot-starter-velocity		֧��ʹ�� Velocity ��Ϊģ�����档
			spring-boot-starter-web				֧�� Web Ӧ�ÿ��������� Tomcat �� spring-mvc��
			spring-boot-starter-websocket		֧��ʹ�� Tomcat ���� WebSocket Ӧ�á�
			spring-boot-starter-ws				֧�� Spring Web Services��
			spring-boot-starter-actuator		������������������Ĺ��ܣ�������ָ��ͼ��ȹ��ܡ�
			spring-boot-starter-remote-shell	���Զ�� SSH ֧�֡�
			spring-boot-starter-jetty			ʹ�� Jetty ������Ĭ�ϵ� Tomcat ��ΪӦ�÷�������
			spring-boot-starter-log4j			��� Log4j ��֧�֡�
			spring-boot-starter-logging			ʹ�� Spring Boot Ĭ�ϵ���־��� Logback��
			spring-boot-starter-tomcat			ʹ�� Spring Boot Ĭ�ϵ� Tomcat ��ΪӦ�÷�������


----------------------------
Spring-Boot ����������jar	|
----------------------------
	# ֻҪ���һ���������
		<build> 
			<plugins>
				<plugin>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-maven-plugin</artifactId>
				</plugin>
			</plugins>
		</build>
	
	# ��ͳ��ʽ
		<!-- �������� -->
		<build>
			<!--
				jar����
			-->
			<finalName>spring-boot</finalName>
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-jar-plugin</artifactId>
					<configuration>
						<classesDirectory>target/classes/</classesDirectory>
						<archive>
							<manifest>
								<!-- ָ��main���� -->
								<mainClass>com.kevin.example.springboot.controller.SampleController</mainClass>
								<!-- ���ʱ MANIFEST.MF�ļ�����¼��ʱ����汾 -->
								<useUniqueVersions>false</useUniqueVersions>
								<addClasspath>true</addClasspath>
								<!-- ����������Ŀ¼����-->
								<classpathPrefix>lib/</classpathPrefix>
							</manifest>
							<manifestEntries>
								<Class-Path>.</Class-Path>
							</manifestEntries>
						</archive>
					</configuration>
				</plugin>
				<!-- �������Ĵ����� -->
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-dependency-plugin</artifactId>
					<executions>
						<execution>
							<id>copy-dependencies</id>
							<phase>package</phase>
							<goals>
								<goal>copy-dependencies</goal>
							</goals>
							<configuration>
								<type>jar</type>
								<includeTypes>jar</includeTypes>
								<!-- ���������Ŀ¼ -->
								<outputDirectory>${project.build.directory}/lib</outputDirectory>
							</configuration>
						</execution>
					</executions>
				</plugin>
			</plugins>
		</build>

		
---------------------------
Spring-boot	������SSH����	|
---------------------------
	# ������Ҫ���������������
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-remote-shell</artifactId>
		</dependency>
	
	# ������ʱ��,ϵͳ���ṩSSH�ķ�������
		


---------------------------
Spring-boot	��������		|
---------------------------
	help
	metrics
	endpoint
	
	endpoint invoke health

---------------------------
Spring-boot	���Ƶ�¼�û�	|
---------------------------
	# �� application.properties ������
		shell.auth.simple.user=kevin
		shell.auth.simple.password=wyf

---------------------------
Spring-boot	��չ����		|
---------------------------
	# ������spring-boot-starter-remote-shell.jar �п��� Spring boot Ϊ���Ƕ��Ƶ�����
		commands.crash
			autoconfig.groovy
			beans.groovy
			endpoint.groovy
			login.groovy
			metrics.groovy
		
	# ʹ��Groovy�ű������� 
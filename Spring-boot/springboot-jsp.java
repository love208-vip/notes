------------------------------
Spring-boot ʹ��JSP��ͼ		  |
------------------------------
	# �ο���վ
		* http://www.cnblogs.com/God-/p/5857428.html
		* http://blog.csdn.net/alan666156/article/details/52168450


------------------------------
Spring-boot				����һ |
------------------------------
	1,maven ���� web��Ŀ
		* ��ʵ����WEB��Ŀ��ʵ������ν,����Ҫȷ��Ŀ¼: src/main/webapp �Ǵ��ڵ�

	2,��pom.xml���������
		<!--JSTL��ǩ��-->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>
		<!-- Servlet -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
		</dependency>
		<!-- jsp���� -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>

	3,��application.properties�����������֧��JSP
		spring.mvc.view.prefix=/WEB-INF/views
		spring.mvc.view.suffix=.jsp
	


	
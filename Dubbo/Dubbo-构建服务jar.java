------------------------------------
Dubbo-ʹ��Maven��������jar			|
------------------------------------
	# Dubbo�����з�ʽ
		1,ʹ��Servlet����(Tomcat,Jetty)����
			* ������
			* ���Ӹ�����(�˿�,����),�˷���Դ
		
		2,�Խ�Main������������(����Spring����)
			* ������(���ز��Կ�ȡ)
			* Dubbo�����ṩ�ĸ߼�����û����
			* �Լ���д���������п��ܻ���ȱ��
		
		3,ʹ��Dubbo����ṩ��Main������������(����Spring����)
			* ����
			* com.alibaba.dubbo.container.Main
			* ��Dubbo��ܱ����ṩ,����ʵ�����Źػ�(shutdownHook)
		
	
	# ��������
		* build.xml �ʼ����
	
------------------------------------
Dubbo-������jar����					|
------------------------------------
	# ������jar��һЩ����,������ classpath �´���һ�� dubbo.properties�ļ�,����������
	
		dubbo.container=spring,jetty,log4j							----����Dubbo�������ص�����
		dubbo.spring.config=classpath*:META-INF/spring/spring.xml	----����spring���ü���λ��,����ʹ��ͨ��� *.xml,����ʾ��������xml�����ļ�												
		dubbo.jetty.port=8080										----����jetty�����˿�
		dubbo.jetty.directory=/foo/bar								----���ÿ�ͨ��jettyֱ�ӷ��ʵ�Ŀ¼�����ڴ�ž�̬�ļ�
		dubbo.jetty.page=log,status,system							----������ʾ��ҳ�棬ȱʡ��������ҳ��
		dubbo.log4j.file=/foo/bar.log								----������־�ļ�·��
		dubbo.log4j.level=WARN										----������־����
		dubbo.log4j.subdirectory=20880								----������־��Ŀ¼�����ڶ���������������ͻ


	1,��������ƪ
		# ��������
			Spring Container(ȱʡ)
				# ������κβ���,��Ĭ�ϼ���spring,�Զ����� META-INF/spring������xml�ļ�
				�Զ�����META-INF/springĿ¼�µ�����Spring���á�
				���ã�(����java����-D��������dubbo.properties��)
				dubbo.spring.config=classpath*:META-INF/spring/*.xml ----����spring���ü���λ��				*/

			Jetty Container
				����һ����ǶJetty�����ڻ㱨״̬��
				���ã�(����java����-D��������dubbo.properties��)
				dubbo.jetty.port=8080				----����jetty�����˿�
				dubbo.jetty.directory=/foo/bar		----���ÿ�ͨ��jettyֱ�ӷ��ʵ�Ŀ¼�����ڴ�ž�̬�ļ�
				dubbo.jetty.page=log,status,system	----������ʾ��ҳ�棬ȱʡ��������ҳ��

			Log4j Container
				�Զ�����log4j�����ã��ڶ��������ʱ���Զ�����־�ļ������̷�Ŀ¼��
				���ã�(����java����-D��������dubbo.properties��)
				dubbo.log4j.file=/foo/bar.log		----������־�ļ�·��
				dubbo.log4j.level=WARN				----������־����
				dubbo.log4j.subdirectory=20880		----������־��Ŀ¼�����ڶ���������������ͻ

		# ͨ����������,ָ��Ҫ���ص�����
			java -jar dubbo-provider.jar spring jetty log4j
		
		# ͨ�� -D (JVM����)����,�������
			java -jar dubbo-provider.jar -Ddubbo.container=spring,jetty,log4j

		# ͨ�������ļ�����������
			dubbo.container=spring,jetty,log4j
		


	2,���ǲ���

		JVM����-D�������ȣ���������ʹ�û��ڲ��������ʱ���в�����д������������ʱ��ı�Э��Ķ˿ڡ�
		XML��֮�������XML�������ã���dubbo.properties�е���Ӧ��������Ч��
		Properties����൱��ȱʡֵ��ֻ��XMLû������ʱ��dubbo.properties����Ӧ������Ż���Ч��ͨ�����ڹ��������ã�����Ӧ������
	
	3,��������


------------------------------------
Dubbo-�ֶ�����jarά��				|
------------------------------------
	1,������������
		* ����

	2,����Ŀ¼�淶
		
		
	3,�ֹ�ά��dubbo����
		* ����
			jar -jar xxx.jar &
			jar -jar xxx.jar && tail -f ./provider.log

		* ���Źػ�
			kill PID
		
		* �����ػ�
			kill -9 PID

	4,�Զ���dubbo����ά����shell�ű�
		* �ű������淶
			/usr/local/service/xxx/service-xxx.sh
			
			/usr/local/service/user/service-user.sh
		
		* Ч��
			./service-xxx.sh start
			./service-xxx.sh stop
			./service-xxx.sh restart

	5,ά��ע������
			

��������������������������������������������������������
һ,ʹ��c3p0���ݿ����ӳ�		|
��������������������������������������������������������

	�ⶫ��,���Ѿ�ѧ���ˣ�JAVAEE/MYSQL�ʼ�������!
	��Hibernate,��֧��c3p0���ݿ����ӳص�!��Hibernate����ʵĬ��ʹ�õĲ���c3p0,���Լ���һ���ܼ򵥵����ӳ�!��������Ŀ���ߵ�ʱ������һ�㶼�������c3p0


	��hibernate-cfg.xml�������������
		<!-- c3p0���ӳ����� -->
		<!-- ʹ��c3p0���ӳ�,�������ӳ��ṩ�Ĺ�Ӧ�� -->		
		<property name="hibernate.connection.provider_class">org.hibernate.connection.C3P0ConnectionProvider</property>
		<!-- �������ӳ��п������ݿ����ӵ���С��Ŀ -->
		<property name="c3p0.min_size">5</property>
		<!-- �������ӳ��п������ݿ����ӵ������Ŀ -->
		<property name="c3p0.max_size">20</property>
		<!-- �������ݿ��������ӵĳ�ʱʱ��,��λ����,�����ʱ�ͶϿ����� -->
		<property name="c3p0.timeout">120</property>
		<!-- ����,������ӳ������п�������,�ļ��ʱ��,��λ���� -->
		<property name="c3p0.idle_test_period"></property>


	�ǵõ�����ص�jar��
		lib\optional\c3p0Ŀ¼�µ�����jar��
		c3p0-0.9.2.1.jar
		hibernate-c3p0-5.0.5.Final.jar
		mchange-commons-java-0.2.3.4.jar


  
	

	Ҳ������ Driud,��˭����˭�ͱ���Ҫ�ṩ��Hibernate�����ϰ�
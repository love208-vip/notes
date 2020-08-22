������������������������������������������������
һ,Spring ����Hibernate	|
������������������������������������������������
1,�����һ������,Spring  ����Hibernate,����������ʲô?
	> �� Spring ��IOC����ȥ���� Hibernate��SessionFactory!
	> ��Hibernate ʹ����,Spring ������ʽ����!

������������������������������������������������
��,���ϲ���				|
������������������������������������������������
	> �ܸо����ֱʼ��е����ǰ�!MyGod!
һ,Hibernate׼������
	1,���jar��(��ǧ������Ϊ��������ô������������ʼ�)
	2,����hibernate.cfg.xml�ļ�
		> ��ʵ��Spring��Hibernate�������ϵ�ʱ��,��������ļ�����ȫ�����õ���!
		> ��Ϊ����ԴҪ���õ�IOC��������,����Hibernate�����ļ��в�����������Դ
		> ʵ��ӳ���ļ�(..hbm.xml),Ҳ������IOC��������SessionFactoryʵ��ʱ��������
		> ������������Hibernate.cfg.xml�����õ�ʲô�Ļ�,�������õ��������(ע��ɾ����session-factory��name="foo"������)
			* ����
			* SQL��ʾ
			* ��ʽ��SQL��ʾ
			* �Զ��������
			* ��������
			... ...
	3,��д�־û����xml�����ļ�(..hbm.xml)
��,����Spring
	1,���jar��.
	2,����Spring�������ļ�
		* ��ʵ������������ļ�,����һ�����ϵĹ���
['�ص�']
	3,��IOC������������Hibernate��'SessionFactory'!
		> ͨ��Spring�ṩ��'LocalSessionFactoryBean'��������
		> org.springframework.orm����,�ҵ����Լ�ʹ�õ�Hibernate�汾��ص�jar��---> 'LocalSessionFactoryBean'
--------------------------------------------------------------------------------------------------------------------------
<bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">							
	<property name="dataSource" ref="dataSource"/><!-- ��������Դ,Ҳ����c3p0������ -->
	<!--
	<property name="configLocation" value="classpath:hibernate.cfg.xml"/>
	����ǵ���Hibernate�������ļ� ,���������ó���һ���ͺ�
	-->
	<property name="hibernateProperties"><!-- ����Hibernate������,������Զ����������'���������ļ�' -->
		<props>
			<prop key="hibernate.dialect">org.hibernate.dialect.MySQL5InnoDBDialect</prop><!-- ���� -->
			<prop key="hibernate.show_sql">true</prop><!-- ��ʾSQL��� -->
			<prop key="hibernate.format_sql">true</prop><!-- ��ʽ��SQL��� -->
			<prop key="hibernate.hbm2ddl.auto">update</prop><!-- �Զ�������� -->
			<prop key="current_session_context_class">thread</prop><!-- ���߳� -->
		</props>
	</property>
	<property name="mappingLocations" value="classpath:com/kevin/entiti/*.hbm.xml"/><!-- ����ʵ����ӳ���ļ�,����ʹ��ͨ��� -->
</bean>
--------------------------------------------------------------------------------------------------------------------------
['�ص�']
	4,��IOC����������������ʽ����
		> ͨ��spring�ṩ��'HibernateTransactionManager'��������
		> org.springframework.orm����,�ҵ����Լ�ʹ��Hibernate�汾��ص�jar��--> 'HibernateTransactionManager'
'!!!'	> �ر���Ҫע�����,����ͳ��������������ò�һ��!��ͳ��������'dataSource',��Hibernate���õ���'sessionFactory'!
		> һ��������Դ,һ���ǹ���
--------------------------------------------------------------------------------------------------------------------------
<!-- ����spring֧��Hibernate������ʽ��������� -->
	<bean id="transactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory"/>
	</bean>
<!-- ������������ -->
	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="*"/>
			<tx:method name="get*" read-only="true"/>
			<tx:method name="find*" read-only="true"/>
		</tx:attributes>
	</tx:advice>
<!-- ��������� -->
	<aop:config>
		<aop:pointcut expression="execution(void com.kevin.main.Demo.test())" id="test"/>
		<aop:advisor advice-ref="txAdvice" pointcut-ref="test"/>
	</aop:config>
--------------------------------------------------------------------------------------------------------------------------
	5,�������������!���Խ��д������
	��Ҫ��Hibernate������������:<property name="current_session_context_class">thread</property>
	һ��͹�.
������������������������������������������������
��,һЩ֪ʶ				|
������������������������������������������������
	1,Spring Hibernate ���������
	* �ڷ�����ʼǰ
	��,��ȡSession
	��,��Session�͵�ǰ�̰߳�,�����ͱ�֤����DAO��ʹ��SessionFactory.getCurrentSession()����ȡSession
	��,��������
		> ��������--�ύ����--���Session���̵߳İ�--�ر�Session
		> �����쳣--�ع�����--���Session���̵߳İ�--�ر�Session
	

������������������������������������������������
��,��߳���׳			|
������������������������������������������������
1,��DAO����,��Ӧ����Hibernate������,��Ӧ���ٳ���spring��ص��������,���Hibernate�Ŀ���ֲ��
	> ��Ҫ�̳� HibernateDaoSupport ��Щ��!




������������������������������������������������
��,�ܽ�һ��				|
������������������������������������������������	
	Hibernate���������ַ���
		* ��spring�����ļ���ֱ������Hibernate�����ļ�
		* ֱ�Ӱ�Hibernate������,��Ϊ����������õ�Spring�����ļ���
	
	
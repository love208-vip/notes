---------------------------
spring-quartz �������ϵͳ|
---------------------------
	# Scheduler --> Trigger --> JobDetail --> bean
	# ��ϵ
		Scheduler
			--> ����ע��,N��trigger
		Trigger
			--> ����ע��jobdetail,���ñ��ʽ
		JobDetail
			--> ����ע��ִ����,�Լ�ִ�еķ���
		bean
			--> ����ִ��
		
			

	# Scheduler	����			
		<bean id="myScheduler" class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
			<property name="triggers">
				<list>
					<!-- ָ������ trigger -->
					<ref bean="myTriggersA"></ref>
					<ref bean="myTriggersB"></ref>
				</list>
			</property>
			<!-- �Ƿ��Զ�ִ�� -->
			<property name="autoStartup" value="true"/>
		</bean>

	# Trigger	����				
		<bean id="myTriggersA" class="org.springframework.scheduling.quartz.CronTriggerFactoryBean">
			<!-- ָ�� JobDetail -->
			<property name="jobDetail" ref="myJobDetailA"/>
			<!-- ����ִ�б��ʽ -->
			<property name="cronExpression">
				<value>0/1 * * * * ?</value>
			</property>
		</bean>

	# JobDetail	����			

		<bean id="myJobDetailA" class="org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean">
			<!-- ָ��ҵ���� -->
			<property name="targetObject" ref="myJobA" />
			<!--ָ��ִ������ķ����� -->
			<property name="targetMethod" value="work" />
			<!-- �Ƿ��������񲢷�ִ�С���ֵΪfalseʱ����ʾ����ȵ�ǰһ���̴߳�����Ϻ������һ���µ��߳� -->
			<property name="concurrent" value="false" />
		</bean>

	# bean	����				
		<bean id="myJobA" class="com.quartz.MyJobA"/>

		# ҵ���಻��Ҫ�̳��κθ��࣬Ҳ����Ҫʵ���κνӿڣ�ֻ��һ����ͨ��java�ࡣ



	# spring-quartz �������ϵͳ|
					Scheduler 
						|
		Trigger		Trigger		Trigger
			|			|			|
		JobDetail	JobDetail	JobDetail
			|			|			|
		  bean		  bean		  bean



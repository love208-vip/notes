----------------------------
ActiveMQ-��Ϣ�洢�־û�		|
----------------------------
	# ActiveMQ ����֧�� PERSISTENT �� NON_PERSISTENT ���ֳ־û���ʽ,��֧����Ϣ�Ļָ� (recovery) ��ʽ

	# PTP
		Queue �Ĵ洢�Ǻܼ򵥵�,����һ�� FIFO Queue

			in  --> FIFO Queue(����) --->  out
	
	
	# PUB/SUB
		* ���ڳ־û���������,ÿ�������߶���õ�һ����Ϣ�ĸ���

			   -->  out
			in -->  out
			   -->  out
	
	# ��Ч����Ϣ�洢
		ActiveMQ �ṩ��һ���������Ϣ�洢,��������Ϣ�Ķ�㴫��.��Ҫʵ�������¼���

		1,AMQ��Ϣ�洢
			* ��ǰĬ�ϵĴ洢��ʽ,�����ļ��Ĵ洢��ʽ,�����Ѿ���KahaDB����
			* ��һ�������ļ�,����洢���Ϊ������Ϣ�洢��һ���ṹ,�ýṹ����������ʽ��������Ϣ������
			* ������Ϣ
				<persistenceAdapter>
					<!-- Ĭ�ϵĴ洢Ŀ¼ -->
					<amqPersistenceAdaoter directory="${activemq.base}/data" maxFileLength="32MB"/>
				</persistenceAdapter>


		2,KahaDB��Ϣ�洢
			* �����������Լ��ָ�����.�����ڵ�Ĭ�ϴ洢��ʽ
			* ������Ϣ
				<persistenceAdapter>
					<!-- Ĭ�ϵĴ洢Ŀ¼ -->
					<kahaDB directory="${activemq.data}/kahadb"/>
				</persistenceAdapter>
			* ����������
				directory				:ָ�������ļ��Ĵ洢�ط�
				indexWriteBatchSize		:����д����̵�����page����,Ĭ��ֵ1000
				indexCacheSize			:�ڴ��л�������page������,Ĭ��ֵ10000
				enableIndexWriteAsync	:�Ƿ��첽д������,Ĭ�� false
				journalMaxFileLength	:����ÿ����Ϣdata log�Ĵ�С,Ĭ�� 32MB
				enableJournalDiskSyncs	:�����Ƿ�֤ÿ��ÿһ��,û����������ݶ���д�����.JMS�־û���ʱ����Ҫ.Ĭ��Ϊ true
				cleanupInterval			:����ú�,ɾ������ʹ�õ���Ϣ.Ĭ��ֵ 30000
				checkpointInterval		:checkpint�ļ��ʱ��,Ĭ��5000
				... ���кܶ�,�õ�ʱ������

		3,JDBC
			* ����˼,ͨ��JDBC��ֵ����ݿ�
			* ��ҪԤ�����
			* ����
				<persistenceAdapter>
					<!-- ��������Դbean ,����ÿ���������Զ��Ĵ�����-->
					<jdbcPersistenceAdapter dataSource="#mysql-ds" createTablesOnStartup="true" />
				</persistenceAdapter>
				<!--����mysql����Դbean,ʹ��������dbcp���ӳ�.����Ƕ����� broker��ǩ֮���-->
				<bean id="mysql-ds" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
					<property name="driverClassName" value="com.mysql.jdbc.Driver"/>
					<property name="url" value="jdbc:mysql://localhost/activemq?relaxAutoCommit=true"/>
					<property name="username" value="activemq"/>
					<property name="password" value="activemq"/>
					<property name="poolPreparedStatements" value="true"/>
				</bean>
			
			* ע��,��Ҫ��JDBC������,���Ƶ�activemq��libĿ¼��

		
		4,JDBC & Journal
			* ˫�����,�ͷ���JDBC�Ĳ���,ʹ�ÿ��ٵĻ���д�뼼��,������������.
			* ������Ϣ
				<beans>
					<broker>
						<persistenceFactory>
							<journalPersistenceAdapterFactory
								journalLogFiles="4",
								journalLogFileSize="32768"
								useJournal="true"
								useQuickJournal="true"
								dataSource="#mysql-ds"
								dataDirectory="activemq-data"
							/>
						</persistenceFactory>
					</broker>
				</beans>
			* ע��,��Ҫע�͵� <persistenceAdapter></persistenceAdapter>,����Ҫ��
			* ���ַ�ʽ������Ҫ����jdbc
			* JDBC��������MASTER/SLAVE��д��������ݿ�ܹ�ģʽ,���������
			* һ�������,�����

		5,Memory
			* �����ڴ����Ϣ�洢.�ٶȿ�,���ǲ���ȫ
			* ��Ҫ��ʱ��,ȥ��
			
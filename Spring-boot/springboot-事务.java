---------------------------
Spring-boot ����			|
---------------------------
	# spring ����������ṩ��һ��ͳһ�Ľӿ�
		PlatformTransactionManager 
	
	# �ӿڵ�ʵ��
		JDBC		-->		DataSourceTransactionManager		//ͬ�����ʺ�MyBatis
		JPA			-->		JpaTransactionManager				//JPA
		Hibernate	-->		HibernateTransactionManager			//�ʺ�Hibernate3.0
		JDO			-->		JdoTransactionManager
		�ֲ�ʽ����	-->		JtaTransactionManager				//JTA

	# �ڳ����ж������������
		@Bean
		public PlatformTransactionManager platformTransactionManager(){
			DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
			dataSourceTransactionManager.setDataSource(dataSource());
			return dataSourceTransactionManager;
		}
	
	# ����ʽ����
		* spring ֧������ʽ����.ʹ��ע�� @Transactional
		* ��ע�����ϸ����,��spring������
	
	# ��������ʽ����
		* spring����һ��ע�� @EnableTransactionManagement
		* ע������������,����ǹ����ʽ�����֧��
		* ʹ�ø�ע���,spring�������Զ�ɨ��ע�� @Transactional �ķ�������
			@Configuration
			@EnableTransactionManagement
			public class transactionManagementAutoConfiguration		{
			}
		* ��Ҫ��������
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-tx</artifactId>
			</dependency>

		* ��ע����Ա�ʶ�ڷ�����
		* Ҳ���Ա�ʶ������,��ô���������е� public ����,����������
		
	# spring boot������֧��
		* ��ʹ��JDBC��Ϊ���ݷ��ʼ�����ʱ��,spring bootΪ���Ƕ����� PlatformTransactionManager ��ʵ�� DataSourceTransactionManager,Դ��:DataSourceTransactionManagerAutoConfiguration
		* ��ʹ��JPA....
		* spring bootר���û��������������:org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration
		* 'spring boot�в���Ҫ��ʾ����ʹ��'@EnableTransactionManagement ע��,'ֱ���������ע'
	
	

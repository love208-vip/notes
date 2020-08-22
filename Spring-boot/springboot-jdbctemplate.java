---------------------------
Spring-boot jdbctemplate	|
---------------------------
	# �򵥵�һ��Dao����ʹ���
	# ��Ҫ����
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<exclusions>
				<!-- �ų���Ĭ�ϵ����ӳ� -->
				<exclusion>
					<groupId>org.apache.tomcat</groupId>
					<artifactId>tomcat-jdbc</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<!-- ʹ�ð���Ͱ�Druid���ӳ� -->
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>druid</artifactId>
			<version>1.0.28</version>
		</dependency>
	
	# ����jdbctemplate�ľ���ʹ��,�뿴 spring ϵ��

---------------------------
Spring-boot ���ò���		|
---------------------------
	1,��������
	2,���� DataSource
		@Configuration
		public class DataSourceAutoConfiguration {
			@Bean
			public DataSource dataSource(){
				DruidDataSource dataSource = new DruidDataSource();
				dataSource.setUrl("jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true");
				dataSource.setUsername("root");//�û���
				dataSource.setPassword("root");//����
				dataSource.setInitialSize(2);
				dataSource.setMaxActive(20);
				dataSource.setMinIdle(0);
				dataSource.setMaxWait(60000);
				dataSource.setTestOnBorrow(false);
				dataSource.setTestWhileIdle(true);
				dataSource.setPoolPreparedStatements(false);
				return dataSource;
			}
		}

	3,����Ҫ�ĵط�ע�뼴��
		@Autowired
		private JdbcTemplate jdbcTemplate;
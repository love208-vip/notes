---------------------------
Spring boot - Spring Data	|
---------------------------
	# Spring Data ��һ�������ݿ����,��'֧���Ʒ������Ŀ�Դ���'
	# ����
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
	
	# Spring Boot ��֧��
		* spring-boot-starter-data-jpa ������ spring-boot-starter-jdbc
		* JDBC
			�����Զ����õ�Դ����:org.springframework.boot.autoconfigure.jdbc ����
			��Դ����Կ���,����dataSource����������ǰ׺Ϊ: spring.datasource,
			spring �Զ���ʼ��ע�������֧�� @EnableTransactionManagement
		* JPA
			���ڶ�JPA���Զ�������:org.springframework.boot.autoconfigure.orm ��
			'spring bootĬ�ϵ�JPAʵ���� Hibernate'
			��properties������JPA������,����: spring.jpa Ϊǰ׺
		
		* Spring Data Jpa
			����Spring Data JPA ���Զ������� org.springframework.boot.autoconfigure.data.jpa��
			��ɨ�����б�ע @Entity ��ʵ����
			

	# ��Ҫ����
		* �������ݿ��ü�
		* ֧�ֻ��ڹ�ϵ�����ݿ�����ݷ���,��Oracle RAC��
		* ֧��map-reduce��ܺ��Ƽ������ݷ���

	# �ṩ�� �־ò�ӿڹ�ϵ
		Repository
			|
		CrudRepository
			|
		PagingAndSortingRepository
			|
		JpaRepository
	
	# �������ݷ��ʲ�����ַ���
		1,�Զ���ӿ�,ʵ�ֽӿ�: JpaRepository<T, ID extends Serializable>
			public interface UserRepository extends JpaRepository<User,Integer>

		2,����ʹ�� Spring Data Jpa
			* ��spring������,ʹ��SpringDataJPA����ͨ�� @EnableJpaRepositories ע�������� SpringDataJPA��֧��
			* @EnableJpaRepositories �� value ����,����respository�ӿ����ڵİ�

			@Configuration
			@EnableJpaRepositories(value="com.levin.repository")
			public class JpaConfiguration{
				@Bean
				public EntityManagerFactory entityManagerFactory(){
					//
				}	
				//����Ҫ���� DataSource,PlatformTransactionManager�����Bean
			}
	
	# �����ѯ����
		public interface UserRepository extends JpaRepository<User,Integer>{
			/*
				�������Ƽ�����һ������,����Ϊname
				JPQL:FROM User WHERE name=:name
			*/
			List<User> findByName(String name);
			/*
				����LIKE��ѯ,����Ϊ name
				JPQL:FROM User WHERE name LIKE :name
			*/
			List<User> findByNameLike(String name);
			/*
				�������ƺ����������¼
				JPAL:FROM User WHERE name = :name AND age = :age
			*/
			List<User> findByNameWithAge(String name,int age);
			
			/*
				Ҳ����ʹ��@Queryע��,���Զ����Ϊ�߼��ļ���
			*/
			@Query("FROM User WHERE userName = :userName")
			public User queryByUserName(@Param(value="userName")String userName);
				
			/*
				��ȡ����������ǰ10����¼
			*/
			List<User> findFirst10ByName(String name);

			/*
				��ȡ����������ǰ30������
			*/
			List<User> findTop30ByName(String name);
		}
		* ��ѯ����,�кܶ�Ĺ���,����: or,and,between....��Ҫ��ʱ��,ȥ�ٶ�
	
	# ע��
		@Query
			* ��ʶ��ĳ�� repository �ķ�����,���ڶ���HQL���
			* ������ INSERT,CREATE,UPDATE,DELETE ���

		@Modifying
			* �� @Query ���ʹ��
			* ��ʶ��ĳ�� repository �ķ�����,��ʾ��ǰ�� @Query ��һ��UPDATE ���
			* �÷������ص� int ֵ��ǩ�ܵ�Ӱ�������

		@NamedQuery
			* ��ʶ�� Entity ��
			* name	Sring���͵�����,����ָ��������,���� "User.findByName"
			* query	String���������,����HQL,���� "FROM User WHERE name = :name"
			* �ڸ� Entity �Ľӿ��ж���� findByName ����,����ͨ�� query ���Ե�HQL�����м�����

---------------------------
Spring boot JPAע��			|
---------------------------
	@Entity
		* ��ϵͳ��⵽�� @Entity ע���ʶ��POJO,�������ݿ������ɶ�Ӧ�ı�ṹ��Ϣ
		* Ĭ�ϵ��ֶ���,�Ǹ����շ�������

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		* ��ʶID�ֶ�,����ָ�������ɲ���
			GenerationType.TABLE		ʹ��һ���ض������ݿ��������������� 
			GenerationType.SEQUENCE		���ݵײ����ݿ���������������������������ݿ�֧�����С� 
			GenerationType.IDENTITY		���������ݿ��Զ����ɣ���Ҫ���Զ������ͣ� 
			GenerationType.AUTO			�����ɳ������
	

	@Column
		* ��ʶ���ֶ�
		* ����
			name		//ָ�����ݿ��ֶε�����
---------------------------
Spring boot ����			|
---------------------------
	spring.datasource.url=jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true
	spring.datasource.username=root
	spring.datasource.password=root
	spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	spring.datasource.max-active=20
	spring.datasource.max-idle=8
	spring.datasource.min-idle=8
	spring.datasource.initial-size=10


	spring.jpa.database=mysql
	spring.jpa.show-sql=true
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.DefaultComponentSafeNamingStrategy
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

---------------------------
Spring boot ���ӿ�		|
---------------------------

	public interface Repository<T, ID extends Serializable>
		* �������ݿ���ʽӿ�,û���κ�ʵ��
		* �����Զ���Ľӿ�һ��ʵ���˸ýӿ�,�ͻᱻIOCʶ��Ϊһ�� RepositoryBean ���뵽IOC��
		* Ҳ����ʹ�� @RepositoryDefinition ע�������� Repository �ӿ�
		* �漰��ѯ����ʱ,�����������������ؼ�������,Ҫע������������Ե�����ĸ,�Ǵ�д
			> findByUserName(String userName);		//���Զ��ĸ��� userName��������һ����¼

		* ʹ�� @Query ע��,�����Զ���JPQL(HQL����)���ʵ�ָ����Ĳ�ѯ
			@Query("FROM User WHERE userName = :userName")
			public User queryByUserName(@Param(value="userName")String userName);
				
			@Query(value = "FROM User")
			public List<User> queryAll();

---------------------------
Spring boot �ӽӿ�			|
---------------------------
	@NoRepositoryBean
	public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
		//���浥��ʵ��
		<S extends T> S save(S var1);
		//���漯��
		<S extends T> Iterable<S> save(Iterable<S> var1);
		//����ID����ʵ��
		T findOne(ID var1);
		//����ID�ж�ʵ���Ƿ����
		boolean exists(ID var1);
		//���������е�ʵ��,����
		Iterable<T> findAll();
		Iterable<T> findAll(Iterable<ID> var1);
		//������ʵ�������
		long count();
		//����IDɾ��ʵ��
		void delete(ID var1);
		//����ʵ��ɾ��ʵ��
		void delete(T var1);
		//ɾ��һ��ʵ��ļ���
		void delete(Iterable<? extends T> var1);
		//ɾ������ʵ��
		void deleteAll();
	}

---------------------------
Spring boot ��ҳ����ӿ�	|
---------------------------
	@NoRepositoryBean
	public interface PagingAndSortingRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
		//����ʵ������ļ���
		Iterable<T> findAll(Sort var1);
		//����ʵ�ַ�ҳ�Լ�����ļ���
		Page<T> findAll(Pageable var1);
	}
	
	# Sort
		new Sort(Direction.ASC,"age");
		
	# Pageable
		* PageaRequest �� Pageable ����
			new PageaRequest(1,20);
		
---------------------------
Spring boot ֱ�Ӽ̳нӿ�	|
---------------------------

	@NoRepositoryBean
	public interface JpaRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
		List<T> findAll();

		List<T> findAll(Sort var1);

		List<T> findAll(Iterable<ID> var1);

		<S extends T> List<S> save(Iterable<S> var1);

		void flush();

		<S extends T> S saveAndFlush(S var1);

		void deleteInBatch(Iterable<T> var1);

		void deleteAllInBatch();

		T getOne(ID var1);

		<S extends T> List<S> findAll(Example<S> var1);

		<S extends T> List<S> findAll(Example<S> var1, Sort var2);
	}


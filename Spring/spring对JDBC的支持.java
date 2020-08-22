������������������������������������������������
һ,Spring ��JDBC��֧��	|
������������������������������������������������
	> JdbcTemplate
	> org.springframework.jdbc.core.JdbcTemplate
	> ������spring��jdbc��֧����,ͨ������������һ�����ݵĻ�������
	> JdbcTemplate�౻���Ϊ�̰߳�ȫ��,���Կ�����IOC�������������ĵ���ʵ��,�������ʵ��ע�뵽���е�DAOʵ������
	> ������ϵ���c3p0���ݿ����ӳ�(�ⶫ���������ӳ�,��Ȼ���Դ���һ�����ӳ�.���ǻ��ǿ����ø�רҵ��c3p0)
		* org.springframework.jdbc.datasource.DriverManagerDataSource
	> ��dbutils�ҳ�������
	> ��Ҫ������jar��,һ��jdbc��,һ�������
	1,��srcĿ¼��׼��db.properties�ļ�,��������c3p0���ݿ����ӳصĸ��ֲ���
	2,��xml�н�������(c3p0ʵ��bean,JdbcTemplateʵ��bean)
һ,applicationContext.xml����
<bean....>
	<!-- ������Դ�ļ� -->
	<context:property-placeholder location="classpath:db.properties"/>
	<!-- ����c3p0����Դ -->
	<bean id="datasource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
		<!-- ���ݿ��Ĵ���� -->
		<property name="jdbcUrl" value="${jdbc.jdbcUrl}"/>
		<property name="user" value="${jdbc.user}"/>
		<property name="password" value="${jdbc.password}"/>
		<property name="driverClass" value="${jdbc.driverClass}"/>
		<!-- �ز��� -->
		<property name="acquireIncrement" value="${jdbc.acquireIncrement}"/>
		<property name="initialPoolSize" value="${jdbc.initialPoolSize}"/>
		<property name="minPoolSize" value="${jdbc.minPoolSize}"/>
		<property name="maxPoolSize" value="${jdbc.maxPoolSize}"/>
	</bean>
	<!-- ����Spring��JDBCTemplate -->
		<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
			<property name="dataSource" ref="datasource"/>
		</bean>
</beans>

��,���Դ�����ʾ
package com.kevin.spring.main;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.kevin.spring.jdbc.User;
/**
 * ������
 * */
public class Main 
{
	private static ApplicationContext ctx;
	private static JdbcTemplate jdbcTemplate;
	public static void main(String[] args) throws Exception
	{
		/***
		 * �ⶫ����,���ܲ���ǿ��!��commons-dbutil���.����ʾ��
		 * */
		 update();
		BatchUpdate();
		queryForObject();
		queryForObjects();
		queryForSingle();
	}
	/**
	 * ��������/����
	 * */
	public static void update()
	{
		String sql ="UPDATE users SET userName=? WHERE passWord=?";
		jdbcTemplate.update(sql,new Object[]{"Litch","1234"});//�ɱ����
	}
	/**
	 * ��������/����
	 * */
	public static void BatchUpdate()
	{
		/**
		 * ÿ�� Object[]������һ�����ݵļ�¼
		 * */
		String sql = "INSERT INTO users(userName,passWord,age,gender) VALUES(?,?,?,?)";
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[]{"one","123",15,"boy"});
		list.add(new Object[]{"two","456",16,"none"});
		list.add(new Object[]{"three","789",19,"girl"});
		jdbcTemplate.batchUpdate(sql,list);
		
	}
	/**
	 * ��ѯ������,��װ����
	 * */
	public static void queryForObject()
	{
		/***
		 * �������������ѯ����������,��ֹһ��!��ô�ͻ��׳��쳣
		 * Ҫ��֤���ݿ��ֶ�����,��javaBean����������һ��!(����,���Խ���������)
		 * ��֧�ּ�������(�Ͼ��˼�spring�Ǹ�IOC���,����ORM���.���ֻ��һ��С����)
		 * */
		String sql = "SELECT * FROM users WHERE userName=?";
		//��ѯ������ɵĶ����������
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql,rowMapper,new Object[]{"one"});
		System.out.println(user);
	}
	/***
	 * ��ѯһ�����
	 * */
	public static void queryForObjects()
	{
		String sql = "SELECT * FROM users WHERE userName=?";
		//��ѯ������ɵĶ����������
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		List<User> users = jdbcTemplate.query(sql,rowMapper,new Object[]{"Litch"});
		System.out.println(users.size());
	}
	/**
	 * ���ص��е��е�����.����:count(),max(),min()....��Щ��ѯ
	 * */
	public static void queryForSingle()
	{
		//��ѯ�ܼ�¼��
		String sql = "SELECT COUNT(*) FROM users";
		Long l = jdbcTemplate.queryForObject(sql,Long.class);
		System.out.println(l);
	}
	static
	{
		//��̬�����,��ȡ�����ļ�,����
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
	}
}

������������������������������������������������
��,JdbcDaoSupport(�˽�)	|
������������������������������������������������
	> ���������spring jdbc����ṩ,������DAOʵ����.����������jdbcTemplate����,�����Դ�IOC������ע��,�����Զ�������Դ����
	> ��һ����,��dao��ȥ�̳�,�и� final �������ø�д
	> ����ô�������������,�Ƽ�ֱ��ʹ��JdbcTemplate��ΪDAO��ĳ�Ա����
		@Repository
		public class UserDao extends JdbcSupport
		{
			@Autowired		//�Զ�װ��ע��,�Զ���װ��һ��DataSource����
			public void setDate(DataSource datasource)
			{
				setDateSource(datasource);//���ø��෽��,�������ݿ����ӳ�
			}
		}
	> ֱ�ӾͰ����ӳض���,����propery ����ע�� jdbcTemplate��ʵ����, ���Ϳ��Ը������ӳض��󴴽�ģ��



������������������������������������������������
��,JDBCģ�����þ������� |
������������������������������������������������
	> NamedParameterJdbcTemplate
	> org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
	* ����û���޲ι�����,���봫��:DataSource ����һ����Ҳ��֪���Ǹ�ɶ�Ĳ���!
	> �ھ������JDBC�÷���,SQL��������ռλ��"?"�ʺ�,��ʾ!�����ܵ�λ�õ�����
	> ��λ��������������,һ��������˳�����仯!�ͱ���ı������
	> ��springJDBC�����,��SQL��������һ��ѡ�����,ʹ�þ�������(named parameter)
	> ��������:SQL������(��ð�ſ�ͷ),�����ǰ�λ�ý���ָ��,��������������ά��,Ҳ�����˿ɶ���!���������ɿ����������ʱ��ռλ��ȡ��
	> ��������,ֻ��NamedParameterJdbcTemplate���еõ�֧��
	> �ⶫ���ĺô�����,������λ�ÿ����������.���ù�!����Ҫ��дһ��Map<String,Object>��!����SQL����ø��ӵĸ���
	> ������ʾ
package com.kevin.spring.main;
import java.util.Map;
import java.util.HashMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
/**
 * ������
 * */
public class Main 
{
	private static NamedParameterJdbcTemplate named;
	private static ApplicationContext ctx;
	public static void main(String[] args) throws Exception
	{
		//��ͳSQL���д��
		String sql = "INSERT INTO users VALUES(?,?,?,?)";
		//NamedParameterJdbcTemplate��SQL���д��
		sql = "INSERT INTO users VALUES(:userName,:passWord,:age,:gender)";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName","Rocco");
		map.put("passWord","a12551255");
		map.put("gender","GIRL");
		map.put("age", 26);	//�������Ӳ���˳��
		named.update(sql, map);

		/*************����һ�ַ���******************/
		/**
		* ��������Ļ����ݵľͲ���һ��Map,��ֱ����һ������!Ҫ���������Ը����ݿ��ֶζ�Ӧ(��get/set)!�е��Hibernate�ĸо�
		* ��ʹ�õ�һ���ӿ��Լ�ʵ����,ϸ��
		**/
		User user = new User("name","password",21,"boy");
		SqlParameterSource papramSource = new BeanPropertySqlParameterSource(user);
		named.update(sql,papramSource);
	}
	static
	{
		//��̬�����,��ȡ�����ļ�,����
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		named = ctx.getBean("named",NamedParameterJdbcTemplate.class);
	}
}

������������������������������������������������
��,ֵ��ע�������		 |
������������������������������������������������
	1,Spring ������JDBC�ṩ��֧��,�Ժܶ�־ò��ܶ��ṩ�˶�Ӧ��֧��

		Hibernate		-->		HibernateTemplate
		Ibatis			-->		SqlMapClientTemplate
		JPA				-->		JpaTempate
	

	2,Spring ����Ҳ��һ�����ӳ�(DataSource)��ʵ��
		* DriverManagerDataSource
		* �߱�����
			1,driverClassName		//JDBC����
			2,url					//URL
			3,username				//�û���
			4,password				//����
	* �����ں��������ļ��м��������,�������Բ���.

	
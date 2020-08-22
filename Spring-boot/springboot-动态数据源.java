----------------------------
�������					|
----------------------------
	1,�����ļ�,����ʵ�ֶ�̬������
	2,DataSourceAspect				//AOP����,��������ע������ʶ��/д��
	3,DynamicDataSource				//��̬����Դ��ʵ��
	4,DynamicDataSourceHolder		//���ڱ�ʶ��/д��
	5,DataSourceConfig				//�ⲿ����ע��
	6,DataSourceAutoConfiguration	//���õ�IOC

----------------------------
1,�����ļ�					|
----------------------------
	jdbc.datasource.masterurl=jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true
	jdbc.datasource.masterusername=root
	jdbc.datasource.masterpassword=root

	jdbc.datasource.slaveurl[0]=jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true
	jdbc.datasource.slaveusername[0]=root
	jdbc.datasource.slavepassword[0]=root

	jdbc.datasource.slaveurl[1]=jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true
	jdbc.datasource.slaveusername[1]=root
	jdbc.datasource.slavepassword[1]=root

	jdbc.datasource.slaveurl[2]=jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true
	jdbc.datasource.slaveusername[2]=root
	jdbc.datasource.slavepassword[2]=root

	jdbc.datasource.slaveurl[3]=jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true
	jdbc.datasource.slaveusername[3]=root
	jdbc.datasource.slavepassword[3]=root

	jdbc.datasource.driverclassname=com.mysql.jdbc.Driver
	jdbc.datasource.maxactive=20
	jdbc.datasource.initialsize=10

----------------------------
2,DataSourceAspect			|
----------------------------
	package com.kevin.boot.web.datasource;
	import org.aspectj.lang.JoinPoint;
	import org.aspectj.lang.annotation.Aspect;
	import org.aspectj.lang.annotation.Before;
	import org.aspectj.lang.reflect.MethodSignature;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.core.annotation.Order;
	import org.springframework.stereotype.Component;
	import org.springframework.transaction.annotation.Transactional;

	import java.lang.reflect.Method;
	import java.lang.reflect.ParameterizedType;
	import java.lang.reflect.Type;

	/**
	 * ��̬����Դ����,���豣֤����������ִ��
	 */
	@Component
	@Aspect
	@Order(-999)        //��ر�֤����ִ��
	public class DataSourceAspect {
		private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);
		/**
		 * �ڽ���Service����֮ǰִ��
		 * @param point
		 * @throws NoSuchMethodException
		 */
		@Before(value = "execution(* com.kevin.boot.web.service..*.*(..))")
		public void before(JoinPoint point) throws NoSuchMethodException {
			//���ص�ʵ�����
			Object target = point.getTarget();
			//���صķ�������
			String methodName = point.getSignature().getName();
			//���صķ�������
			Object[] args = point.getArgs();
			//���صķ�����������
			Class[] parameterTypes = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
			//��ȡ����Ŀ�귽��
			Method method = null;
			//ͨ�����������ص�method
			method = target.getClass().getMethod(methodName, parameterTypes);
			//���������Ҫ���ʵ�����ص�method
			if(method.isBridge()){
				for(int i = 0; i < args.length; i++){
					//��÷�������
					Class genClazz = this.getSuperClassGenricType(target.getClass(),0);
					//����ʵ�ʲ��������滻parameterType�е�����
					if(args[i].getClass().isAssignableFrom(genClazz)){
						parameterTypes[i] = genClazz;
					}
				}
				//���parameterType�������͵ķ���
				method = target.getClass().getMethod(methodName, parameterTypes);
			}
			LOGGER.info("��ǰ���񷽷�  " + methodName);
			Transactional transactional = method.getAnnotation(Transactional.class);
			if(transactional != null && transactional.readOnly()){
				//����
				LOGGER.info("��̬����Դ - ����");
				DynamicDataSourceHolder.markSlave();
			}else {
				//д��
				LOGGER.info("��̬����Դ - д��");
				DynamicDataSourceHolder.markMaster();
			}
		}
		
		public Class getSuperClassGenricType(Class clazz, int index) {
			Type genType = clazz.getGenericSuperclass();        // �õ����͸���
			if (!(genType instanceof ParameterizedType)) {
				return Object.class;
			}
			Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
			if (!(params[index] instanceof Class)) {
				return Object.class;
			}
			return (Class) params[index];
		}
	}

----------------------------
3,DynamicDataSource			|
----------------------------
	package com.kevin.boot.web.datasource;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
	import org.springframework.util.ReflectionUtils;

	import javax.sql.DataSource;
	import java.lang.reflect.Field;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;
	import java.util.concurrent.atomic.AtomicInteger;

	/**
	 * ��̬����Դʵ��
	 */
	public class DynamicDataSource extends AbstractRoutingDataSource {
		private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);
		/**
		 * ���������
		 */
		private Integer slaveCount;
		
		// ��ѯ����,��ʼΪ-1
		private AtomicInteger counter = new AtomicInteger(-1);
		
		// ��¼�����key(������ioc��)
		private List<Object> slaveDataSources = new ArrayList<Object>(0) ;
		
		/**
		 * �÷����ķ���ֵ,����Ϊһ��Map<String,DataSource>�е�key,ȥ��ȡ��Ӧ������Դ.
		 * ����,ÿ������.ֻҪ�ı����key,�Ϳ��Ըı䵱�˴�����,�ڳ־ò�Ự��ע�������Դ,ʵ���Զ��Ķ�д����
		 */
		@Override
		protected Object determineCurrentLookupKey() {
			/**
			 * ���������,�����Ǵӿ�����Ϊ0
			 */
			Object key = null;
			if (DynamicDataSourceHolder.isMaster() || this.slaveCount == 0) {
				key = DynamicDataSourceHolder.getDataSourceKey();
				return key;
			}
			key = this.getSlaveKey();
			LOGGER.info("Datasource key={}",key);
			return key;
			
		}
		/**
		 * ����ʵ����InitializingBean,Spring����Bean��ʼ����ɺ�ص� afterPropertlesSet����
		 * ͨ���÷���,��ȡ�����еĶ���key,�洢������
		 */
		@SuppressWarnings("unchecked")
		@Override
		public void afterPropertiesSet() {
			super.afterPropertiesSet();
			// ���ڸ����resolvedDataSources������˽�е������ȡ��������Ҫʹ�÷����ȡ
			Field field = ReflectionUtils.findField(AbstractRoutingDataSource.class, "resolvedDataSources");
			field.setAccessible(true); // ���ÿɷ���
			try {
				//���ݵ�ǰ����,����ִ�и��ֶε�get����,��ȡ�����е�����Դ
				Map<Object, DataSource> resolvedDataSources = (Map<Object, DataSource>) field.get(this);
				/**
				 * �������������������Դ������ȥд�������,д������Ϊ 1
				 */
				this.slaveCount = resolvedDataSources.size() - 1;
				for (Map.Entry<Object, DataSource> entry : resolvedDataSources.entrySet()) {
					//�������е�key
					if (DynamicDataSourceHolder.MASTER.equals(entry.getKey())) {
						//�����д��,����֮
						continue;
					}
					//���д���key������
					slaveDataSources.add(entry.getKey());
				}
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("afterPropertiesSet error! ", e);
			}
		}
		
		/**
		 * ��ѯ�㷨ʵ��
		 */
		public Object getSlaveKey() {
			Integer index = counter.incrementAndGet() % slaveCount;
			if (counter.get() > 9999) { 	// ���ⳬ��Integer��Χ
				counter.set(-1);		 	// ��ԭ
			}
			return slaveDataSources.get(index);
		}
	}

----------------------------
3,DynamicDataSourceHolder	|
----------------------------
	package com.kevin.boot.web.datasource;

	/**
	 * ThreadLocal��¼��ǰ�̵߳�DB key
	 */
	public class DynamicDataSourceHolder {
		//д���ʶ
		public static final String MASTER = "MASTER";
		
		//�����ʶ
		private static final String SLAVE = "SLAVE";
		
		//ʹ��ThreadLocal��¼��ǰ�̵߳�����Դ��ʶ
		private static final ThreadLocal<String> holder = new ThreadLocal<String>();
		
		/**
		 * ��������Դ��ʶ
		 */
		private static void putDataSourceKey(String key) {
			holder.set(key);
		}
		
		/**
		 * ��ȡ����Դkey
		 */
		public static String getDataSourceKey() {
			return holder.get();
		}
		
		/**
		 * ���д��
		 */
		public static void markMaster(){
			putDataSourceKey(MASTER);
		}
		
		/**
		 * ��Ƕ���
		 */
		public static void markSlave(){
			putDataSourceKey(SLAVE);
		}
		
		/**
		 * �Ƿ�������
		 */
		public static boolean isMaster() {
			return  MASTER.equals(holder.get());
		}
	}


----------------------------
4,DataSourceConfig			|
----------------------------
	package com.kevin.boot.web.config;

	import com.alibaba.druid.pool.DruidDataSource;
	import org.springframework.boot.context.properties.ConfigurationProperties;

	import javax.sql.DataSource;
	import java.util.ArrayList;
	import java.util.List;

	/**
	 * Created by KevinBlandy on 2017/2/28 14:07
	 * ���ݿ�����,�����˵�õ� "���Կ��ɵĹ���" �أ�
	 */
	@ConfigurationProperties(prefix = "jdbc.datasource",ignoreInvalidFields = false)
	public class DataSourceConfig {
		private String masterurl;
		private String masterusername;
		private String masterpassword;
		
		private List<String> slaveurl = new ArrayList<String>();
		private List<String> slaveusername = new ArrayList<String>();
		private List<String> slavepassword = new ArrayList<String>();
		
		private String driverclassname;
		private int maxactive;
		private int initialsize;
		
		public String getMasterurl() {
			return masterurl;
		}
		
		public void setMasterurl(String masterurl) {
			this.masterurl = masterurl;
		}
		
		public String getMasterusername() {
			return masterusername;
		}
		
		public void setMasterusername(String masterusername) {
			this.masterusername = masterusername;
		}
		
		public String getMasterpassword() {
			return masterpassword;
		}
		
		public void setMasterpassword(String masterpassword) {
			this.masterpassword = masterpassword;
		}
		
		public List<String> getSlaveurl() {
			return slaveurl;
		}
		
		public void setSlaveurl(List<String> slaveurl) {
			this.slaveurl = slaveurl;
		}
		
		public List<String> getSlaveusername() {
			return slaveusername;
		}
		
		public void setSlaveusername(List<String> slaveusername) {
			this.slaveusername = slaveusername;
		}
		
		public List<String> getSlavepassword() {
			return slavepassword;
		}
		
		public void setSlavepassword(List<String> slavepassword) {
			this.slavepassword = slavepassword;
		}
		
		public String getDriverclassname() {
			return driverclassname;
		}
		
		public void setDriverclassname(String driverclassname) {
			this.driverclassname = driverclassname;
		}
		
		public int getMaxactive() {
			return maxactive;
		}
		
		public void setMaxactive(int maxactive) {
			this.maxactive = maxactive;
		}
		
		public int getInitialsize() {
			return initialsize;
		}
		
		public void setInitialsize(int initialsize) {
			this.initialsize = initialsize;
		}
		
		/**
		 * �������û�ȡMaster���ӳض���
		 * @return
		 */
		public DataSource getMasterDataSource(){
			DruidDataSource masterDataSource = new DruidDataSource();
			masterDataSource.setUrl(this.getMasterurl());
			masterDataSource.setUsername(this.getMasterusername());
			masterDataSource.setPassword(this.getMasterpassword());
			masterDataSource.setMaxActive(this.getMaxactive());
			masterDataSource.setInitialSize(this.getInitialsize());
			masterDataSource.setDriverClassName(this.getDriverclassname());
			return masterDataSource;
		}
	}


----------------------------
5,DataSourceAutoConfiguration|
----------------------------
	package com.kevin.boot.web.configuration;

	import com.alibaba.druid.pool.DruidDataSource;
	import com.kevin.boot.web.config.DataSourceConfig;
	import com.kevin.boot.web.datasource.DynamicDataSource;
	import com.kevin.boot.web.utils.GeneralUtils;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.context.properties.EnableConfigurationProperties;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;

	import javax.sql.DataSource;
	import java.util.HashMap;
	import java.util.Map;

	/**
	 * Created by KevinBlandy on 2017/2/28 14:11
	 */
	@Configuration
	@EnableConfigurationProperties(DataSourceConfig.class)
	public class DataSourceAutoConfiguration {
		
		@Autowired
		private DataSourceConfig dataSourceConfig;
		
		@Bean
		public DataSource dataSource(){
			DynamicDataSource dynamicDataSource = new DynamicDataSource();
			//�����û�ȡһ������
			DataSource masterDataSource = this.dataSourceConfig.getMasterDataSource();
			//Ĭ�Ͽ�Ϊ����
			dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
			Map<Object,Object> dataSources = new HashMap<Object,Object>();
			if(!GeneralUtils.isEmpty(this.dataSourceConfig.getSlaveurl()) && !GeneralUtils.isEmpty(this.dataSourceConfig.getSlaveusername()) && !GeneralUtils.isEmpty(this.dataSourceConfig.getSlavepassword())){
				int length = this.dataSourceConfig.getSlaveurl().size();
				DruidDataSource druidDataSource = null;
				for (int x = 0;x < length ; x++){
					String url = this.dataSourceConfig.getSlaveurl().get(x);
					String userName = this.dataSourceConfig.getSlaveusername().get(x);
					String passWord = this.dataSourceConfig.getSlavepassword().get(x);
					if(!GeneralUtils.isEmpty(url) && !GeneralUtils.isEmpty(userName) && !GeneralUtils.isEmpty(passWord)){
						//���slave��
						druidDataSource = new DruidDataSource();
						druidDataSource.setUrl(url);
						druidDataSource.setUsername(userName);
						druidDataSource.setPassword(passWord);
						druidDataSource.setMaxActive(this.dataSourceConfig.getMaxactive());
						druidDataSource.setInitialSize(this.dataSourceConfig.getInitialsize());
						dataSources.put("SLAVE"+x,druidDataSource);
					}
				}
			}
			//������⵽����,ע��˴� MASTER ֵ
			dataSources.put("MASTER",masterDataSource);
			dynamicDataSource.setTargetDataSources(dataSources);
			return dynamicDataSource;
		}
	}

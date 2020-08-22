-----------------------
MyBatis-��ҳ���		|
-----------------------
	# maven�ֿ�,һ����������
		<dependency>
			<groupId>com.github.pagehelper</groupId>
			<artifactId>pagehelper</artifactId>
			<version>${pagehelper.version}</version>
		</dependency>						
		<dependency>
			<groupId>com.github.jsqlparser</groupId>
			<artifactId>jsqlparser</artifactId>
			<version>${jsqlparser.version}</version>
		</dependency>
	
-----------------------
MyBatis-����			|
-----------------------
	# ��mybatisȫ��������,��Ӳ��
		<plugin interceptor="com.github.pagehelper.PageHelper">
			<!-- ָ�����ݿ�汾 -->
	        <property name="dialect" value="mysql"/>
			<!-- Ĭ��Ϊfalse
				ʹ��RowBounds��ҳ�����count��ѯ,����˵�ǲ���Ҫ��ѯ���ݵ�������
			-->
	        <property name="rowBoundsWithCount" value="true"/>
		</plugin>
	# ����ϸ��������Ϣ
		<plugins>
			<!-- com.github.pagehelperΪPageHelper�����ڰ��� -->
			<plugin interceptor="com.github.pagehelper.PageHelper">
				<property name="dialect" value="mysql"/>
				<!-- �ò���Ĭ��Ϊfalse -->
				<!-- ����Ϊtrueʱ���ὫRowBounds��һ������offset����pageNumҳ��ʹ�� -->
				<!-- ��startPage�е�pageNumЧ��һ��-->
				<property name="offsetAsPageNum" value="true"/>
				<!-- �ò���Ĭ��Ϊfalse -->
				<!-- ����Ϊtrueʱ��ʹ��RowBounds��ҳ�����count��ѯ -->
				<property name="rowBoundsWithCount" value="true"/>
				<!-- ����Ϊtrueʱ�����pageSize=0����RowBounds.limit = 0�ͻ��ѯ��ȫ���Ľ�� -->
				<!-- ���൱��û��ִ�з�ҳ��ѯ�����Ƿ��ؽ����Ȼ��Page���ͣ�-->
				<property name="pageSizeZero" value="true"/>
				<!-- 3.3.0�汾���� - ��ҳ����������Ĭ��false���� -->
				<!-- ���ú���ʱ�����pageNum<1���ѯ��һҳ�����pageNum>pages���ѯ���һҳ -->
				<!-- ���ú���ʱ�����pageNum<1��pageNum>pages�᷵�ؿ����� -->
				<property name="reasonable" value="true"/>
			</plugin>
		</plugins>
	
	# ��spring����
		<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		  <property name="dataSource" ref="dataSource"/>
		  <property name="mapperLocations">
			<array>
			  <value>classpath:mapper/*.xml</value>									*/
			</array>
		  </property>
		  <property name="typeAliasesPackage" value="com.isea533.ssm.model"/>
		  <property name="plugins">
			<array>
			  <bean class="com.github.pagehelper.PageHelper">
				<property name="properties">
				  <value>
					dialect=hsqldb
					reasonable=true
				  </value>
				</property>
			  </bean>
			</array>
		  </property>
		</bean>

-----------------------
MyBatis-ʹ��			|
-----------------------
	# ���˹��˷�ҳ����
		PageHelper.startPage(1,3);
		List<User> list = mapper.queryAll();
		* �ڼ�ҳ,Ҫ����������
	
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		System.out.println(pageInfo.getTotal());		//�ܼ�¼��
		System.out.println(pageInfo.getPages());		//��ҳ��
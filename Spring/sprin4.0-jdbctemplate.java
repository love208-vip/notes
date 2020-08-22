--------------------------
JdbcTemplate			  |
--------------------------

	<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
		<property name="dataSource" ref="datasource"/>
	</bean>


--------------------------
NamedParameterJdbcTemplate|
--------------------------
	> org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
		* ����û���޲ι�����,���봫��:DataSource ����һ����Ҳ��֪���Ǹ�ɶ�Ĳ���!

	> �ھ������JDBC�÷���,SQL��������ռλ��"?"�ʺ�,��ʾ!�����ܵ�λ�õ�����
	> ��λ��������������,һ��������˳�����仯!�ͱ���ı������
	> ��springJDBC�����,��SQL��������һ��ѡ�����,ʹ�þ�������(named parameter)
	> ��������:SQL������(��ð�ſ�ͷ),�����ǰ�λ�ý���ָ��,��������������ά��,Ҳ�����˿ɶ���!���������ɿ����������ʱ��ռλ��ȡ��
	> ��������,ֻ��NamedParameterJdbcTemplate���еõ�֧��
	> �ⶫ���ĺô�����,������λ�ÿ����������.���ù�!����Ҫ��дһ��Map<String,Object>��!����SQL����ø��ӵĸ���
----------------------------
MyBatis-ע��				|
----------------------------
	@Param
		* ���ע��,�Ǳ�ʶ��Mapper�ӿڵ��β���
		* ��ʵ����˵,Mapper�ӿڵ��β�,�����Ƕ���򵥵���������,ͨ��ע������������,��mapper.xml�о�ʹ��ע���ʶ�������������������
		* ͨ�����ע��,��ָ����εĲ�����
		['Demo']
			public User queryByNameAndPass(
										@Param(value="userName")String userName,
										@Param(value="password")String password);

			<select id="queryByNameAndPass" resultType="User">
				SELECT * FROM tb_user WHERE user_name = #{userName} AND password = #{password}
			</select>
	
	@Insert
	@Update
	@Delete
	@Selct
		# ����ע��,һ�۾Ϳ�����
	
	@Result
	@Results

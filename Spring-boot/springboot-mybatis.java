----------------------------
Spring boot MyBatis			|
----------------------------


----------------------------
Spring boot ��һ�ַ�ʽ		|
----------------------------
	# ʹ�ùٷ��ṩ��jar,��������
	1,��������
		
		<!-- spring boot mybatis -->
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.2.0</version>
		</dependency>
		
		<!-- mybatis��ҳ��� -->
		<dependency>
			<groupId>com.github.miemiedev</groupId>
			<artifactId>mybatis-paginator</artifactId>
			<version>1.2.17</version>
		</dependency>
	
	2,�� @SpringBootApplication �������ע����ɨ�� mapper �ӿ�
		@MapperScan("com.xx");
		* ɨ��ָ�����µ� mapper �ӿ�
		* value				������һ������,����ɨ����
		* annotationClass	�������������ָ��ע�����
	
	3,��properties�����ò���
		mybatis.mapper-locations[0]=classpath*:com/tedi/**/*mapper.xml																
			* mapper�ļ���ַ,�����ж��,֧��ʹ��ͨ���
		mybatis.config-location=classpath:mybatis/mybatis-config.xml
			* mybatis�����ļ���ַ
		

	
	

----------------------------
Spring boot �ڶ��ַ�ʽ		|
----------------------------
	# ʹ��ԭʼ����spring�ķ�ʽ��������
	# spring ����ô���ϵ�,����ô����


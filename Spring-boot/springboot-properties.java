-------------------------------
Spring boot-������				|
-------------------------------
	// Server���
		server.port=80
			# WEB�����˿�

		server.context-path=/
			# WEB����·��
		
	//��־

		logging.config=classpath:community-logback.xml
			# logback�����ļ���ַ
	
	//��̬�ļ�
		spring.mvc.static-path-pattern=/static/**													*/
			# ����ָ����̬�ļ���Ŀ¼(��classpathĿ¼��-src/main/resources),�������ֱ�ӷ���

	//MyBatis
		mybatis.mapper-locations[0]=classpath*:mapper/**/Mapper.xml
			# mybatis mapper�ļ�ɨ���ַ

		mybatis.config-location=classpath:mybatis/mybatis-config.xml
			# mybatis�����ļ���ַ

1,����/���ܹ��߰�
	<dependency>
		<groupId>commons-codec</groupId>
		<artifactId>commons-codec</artifactId>
		<version>1.10</version>
	</dependency>
	//ִ��MD5����
	String md5String = DigestUtils.md5Hex("123456")
	//ִ��Base64����
	String base64String = Base64.encodeBase64String("������".getBytes());
	//ִ��Base64����
	byte[] bytes = Base64.decodeBase64(base64String.getBytes());
	String results = new String(bytes);


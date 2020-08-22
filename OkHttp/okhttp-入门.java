---------------------------
okhttp-����					|
---------------------------
	# ���Դ��� HttpClient ���߰�
	# ��Ŀ��ַ
		http://square.github.io/okhttp/
	# maven�ֿ�
		<dependency>
			<groupId>com.squareup.okhttp3</groupId>
			<artifactId>okhttp</artifactId>
			<version>3.7.0</version>
		</dependency>

---------------------------
okhttp-Request				|
---------------------------
	Request.Builder builder = new Request.Builder();
	# URL���
		url(URL url);
		url(String url);

	# ���󷽷����
		delete(RequestBody body);
		get();
		post(RequestBody body);

	# ����ͷ���
		addHeader(String name, String value);
		removeHeader(String name);
		headers(Headers headers);
	
	# ���� Request ����
		build();

---------------------------
okhttp-RequestBody			|
---------------------------
	

---------------------------
okhttp-Response				|
---------------------------
	# ��ȡ��Ӧ��
		ResponseBody body();
	
	# �ж����
		boolean isRedirect();
			* �Ƿ����ض���
		boolean isSuccessful();
			* �Ƿ�����OK

	# ��Ӧͷ���
		String header(String headerName);
			* ��ȡָ�����Ƶ���Ӧͷ

		String header(String name, String defaultValue);
			* ��ȡָ�����Ƶ���Ӧͷ
			* ���������,�򷵻�Ĭ��ֵ

		Headers headers();
			* ����������Ӧͷ

		List<String> headers(String name);
			* ��ȡָ����Ӧͷ������ֵ


---------------------------
okhttp-ResponseBody			|
---------------------------
	byte[] bytes();
	InputStream byteStream();
	Reader charStream();
	long contentLength();
	MediaType contentType();
	String string();


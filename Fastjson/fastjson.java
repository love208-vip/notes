--------------------
FastJson			|
--------------------
	# ����Ͱ͵�����



--------------------
FastJson			|
--------------------
	��Ҫ��(��̬)
		com.alibaba.fastjson.JSON
	

	1,�Ѷ������л�Ϊjson�ַ���
		String json = JSON.toJSONString(Object obj,SerializerFeature ....serializerFeature);
		String json = JSON.toJSONString(Object obj, boolean prettyFormat); // ��JavaBean���л�Ϊ����ʽ��JSON�ı�

	2,��json,���л�ΪjavaBean
		T t = parseObject(String text, Class<T> clazz); 

	3,��json,���л�ΪjavaBean����
		List<T>  ts = parseArray(String text, Class<T> clazz); 
	
	4,��JSON�ַ���ת��ΪJSON����
		JSONObject JSONObject.parseObject(String json)

	5,��JSON����ת��ΪJSON����
		JSONArray JSONArray.parse(String jsonArray)
--------------------
FastJson-ע��		|
--------------------
	@JSONField
		format
			* ��ע��Bean���ֶ�������,���ַ�������ʽָ����ʽ����ʽ
		
		serialize
			* true/false,�Ƿ����л����ֶ�
		

	


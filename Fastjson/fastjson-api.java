
-----------------------------------
��ͨ								|
-----------------------------------
	com.alibaba.fastjson.JSON
		# ��̬��,�������̬����
			String toJSONString(Object obj);
				* �Ѷ���ת��ΪJSON
			String toJSONString(Object obj, boolean prettyFormat); 
				* �Ѷ���ת��ΪJSON,���Ҹ�ʽ��
			T parseObject(String text, Class<T> clazz); 
				* ��JSON�ַ��������л�Ϊ����
			List<T>  parseArray(String text, Class<T> clazz); 
				* ��JSON�ַ��������л�ΪList����

-----------------------------------
Spring ���							|
-----------------------------------
FastJsonHttpMessageConverter
	* ��ͨ��HTTP��Ϣת����

FastJsonHttpMessageConverter4
	* ͬ��

FastJsonpHttpMessageConverter4
	* ֧�ֿ����HTTP��Ϣת����
	* ����
		setFastJsonConfig(FastJsonConfig fastJsonConfig);
			* ����Config
		supportedMediaTypes(List<MediaType> supportedMediaTypes);
			* ����֧�ֵ����ݸ�ʽ

FastJsonConfig
	* ����ת���е�һЩ����
	setSerializerFeatures(SerializerFeature..serializerFeatures);
		SerializerFeature.QuoteFieldNames	
			* ���keyʱ�Ƿ�ʹ��˫����,Ĭ��Ϊtrue	
		SerializerFeature.UseSingleQuotes	
			* ʹ�õ����Ŷ�����˫����,Ĭ��Ϊfalse	
		SerializerFeature.WriteMapNullValue	
			* �Ƿ����ֵΪnull���ֶ�,Ĭ��Ϊfalse	
		SerializerFeature.WriteEnumUsingToString	
			* Enum���name()����original,Ĭ��Ϊfalse	
		SerializerFeature.UseISO8601DateFormat	
			* Dateʹ��ISO8601��ʽ�����Ĭ��Ϊfalse	
		SerializerFeature.WriteNullListAsEmpty	
			* List�ֶ����Ϊnull,���Ϊ[],����null	
		SerializerFeature.WriteNullStringAsEmpty	
			* �ַ������ֶ����Ϊnull,���Ϊ����,����null	
		SerializerFeature.WriteNullNumberAsZero	
			* ��ֵ�ֶ����Ϊnull,���Ϊ0,����null	
		SerializerFeature.WriteNullBooleanAsFalse	
			* Boolean�ֶ����Ϊnull,���Ϊfalse,����null	
		SerializerFeature.SkipTransientField	
			* �����true�����е�Get������Ӧ��Field��transient�����л�ʱ���ᱻ���ԡ�Ĭ��Ϊtrue	
		SerializerFeature.SortField	
			* ���ֶ���������������Ĭ��Ϊfalse	
		SerializerFeature.WriteTabAsSpecial	
			* ��\t��ת�������Ĭ��Ϊfalse	���Ƽ�
		SerializerFeature.PrettyFormat	
			* ����Ƿ��ʽ��,Ĭ��Ϊfalse	
		SerializerFeature.WriteClassName	
			* ���л�ʱд��������Ϣ��Ĭ��Ϊfalse�������л������õ�	
		SerializerFeature.DisableCircularReferenceDetect	
			* ������ͬһ����ѭ�����õ����⣬Ĭ��Ϊfalse	
		SerializerFeature.WriteSlashAsSpecial	
			* ��б�ܡ�/������ת��	
		SerializerFeature.BrowserCompatible	
			* �����Ķ������л�Ϊ\uXXXX��ʽ���ֽ������һЩ�������ܼ���IE 6��Ĭ��Ϊfalse	
		SerializerFeature.WriteDateUseDateFormat	
			* ȫ���޸����ڸ�ʽ,Ĭ��Ϊfalse��JSON.DEFFAULT_DATE_FORMAT = ��yyyy-MM-dd��;JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);	
		SerializerFeature.DisableCheckSpecialChar	
			* һ��������ַ�������������������ַ���˫���ţ�������ת��jsonʱ���з�б��ת�Ʒ����������Ҫת�壬����ʹ��������ԡ�Ĭ��Ϊfalse	
		SerializerFeature.NotWriteRootClassName	
			* ����	
		SerializerFeature.BeanToArray	
			* ������תΪarray���	
		SerializerFeature.WriteNonStringKeyAsString		
		SerializerFeature.NotWriteDefaultValue		
		SerializerFeature.BrowserSecure		
		SerializerFeature.IgnoreNonFieldGetter		
		SerializerFeature.WriteEnumUsingName	

FastJsonpResponseBodyAdvice
	# JSON������ǿ
	# һ����� FastJsonpHttpMessageConverter4 ʹ��,��������JSONP������Ĳ���

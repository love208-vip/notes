------------------------
ResponseBodyAdvice		|
------------------------
	# ResponseBody��ǿ�ӿ�
	# ������ @ResponseBody ��Ӧ�ͻ���֮ǰ��һЩ����,ֻ��Ҫʵ�ָýӿ�,Ȼ��ע�ᵽspring-mvc��IOC��
		ResponseBodyAdvice<T>{
			boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType);

			T beforeBodyWrite(T body, MethodParameter returnType, MediaType selectedContentType,
				Class<? extends HttpMessageConverter<?>> selectedConverterType,
				ServerHttpRequest request, ServerHttpResponse response);
		}
	# ����:JSONP,����,�ȵ�.... ...
	# Fastjson ��ʵ��



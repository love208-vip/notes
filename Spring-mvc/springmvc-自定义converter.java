
1,ʵ�ֳ�����:AbstractHttpMessageConverter<T> 
2,�ڹ��캯�����Զ���application��Ϣ����,ָ������Ϣת��������ת��ʲô��ʽ����Ϣ
	super(new MediaType("application/json"))
	* ����ֱ��ʹ��:super(MediaType.ALL); ������Ϣ�����ɸý���������

3,���󷽷����
	boolean supports(Class<?> clazz) 
		* �ý������Ƿ�֧�ֽ���������

	Object readInternal(Class<?> clazz, HttpInputMessage inputMessage)
		* ����������

	void writeInternal(Object o, HttpOutputMessage outputMessage) 
		* �����Ӧ��
		

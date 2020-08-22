SpringMVC�쳣�������		
	
	
		��Ŀ�а��������쳣
			1,Ԥ���쳣
				* ����
			2,�����쳣
				* ֻ�ܹ涨����淶


	DispatcherServlet��struts2�Ǹ�ǰ�˿�������������һ����,��ͷ����һ���ܴ��try
		try
		{
			... ...
		}
		catch ()
		{

		}
	


	ExceptionResolver		--> ȫ���쳣������,������Ŀֻ��һ��.

	RuntimeException --> ���ͻ����ṩһ����ʾ:δ֪����
	�Զ��� Exception --> �̳� Exception

	��struts2��ͨ��������ʵ���쳣�Ĳ���!���׳�,���ز���

	1,�����쳣����
		|--�Զ����쳣--> ȡ���쳣��Ϣ--> View��ʾ
		|--���Զ����쳣 --> ����,�׳��Զ����쳣

	

	2,ʵ�ֽӿ� HandlerExceptionResolver
		* ֻҪ��ʵ��������ӿ�,��ô��������ȫ���쳣������
			ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex);
		* request �� response�������
		* Object	--> ���Ǵ�����������Ҫִ�е� Hander
		* Exception --> ����ϵͳ�׳����쳣,���ǿ��Ի�ȡ������쳣,���д���
		* (���صľ��� ModelAndView)
		�������:
			�ж���� Exception �ǲ��������Զ�����쳣,����ǵĻ�,
			�����쳣,�����,ת��ҳ��.��ȡ������Ϣ�ͺ�
			������� RuntimeException,��ô�Զ����쳣��Ϣ.
	
	3,��xml�������Զ����쳣

		<!-- ȫ���쳣������ -->
		<bean class="�Զ���ȫ�޶���"/>


	


	�ⶫ��ֻҪһע����IOC������,ֻҪ�ǵ������������쳣,������ִ��������,�������!
	springmvc��ܵ��ص�����,��������������'�쳣����',�����ж�!
	struts2��ܵ��ص�����,������.����,���ز�ͬ���쳣����,���ò�ͬ��result


	SpringMVC�������쳣����ķ�ʽ
	1,�򵥵��쳣������
		SimpleMappingExceptionResolver
		<bean class="org.spring....SimpleMappingExceptionResolver">
		<!-- ����Ĭ�ϵ��쳣����ҳ��,�����쳣���͵�ע��ʱʹ��-->
		<property name="default" value="error"/>
		<!-- �����쳣����ҳ������ȡ�쳣��Ϣ�ı�������,Ĭ��Ϊ:exception-->
		<property name="exceptionAttribute" value="ex"/>
		<!-- ������Ҫ���⴦����쳣,ʹ��ȫ�޶�����Ϊkey,�쳣ҳΪֵ-->
		<property>
			<props>
				<prop key="com...Exception">errorjsp</prop>
				<prop key="com...Exception"/>errojsp</prop>
				....���������ö��
			</props>
		</property>
		</bean>
	2,ʵ��spring���쳣����ӿ�,�����Լ����쳣��
		HanderExceptionResolver
	3,ʹ�� ExcetionHander ע��ʵ���쳣����


---------------------------------
---------------------------------
	# ��һ�ַ�ʽ
	# ʹ�� Spring �ṩ�Ĵ�����
	# ����ֻ�ܴ���� 500 �������쳣,404 ֮��Ĳ��ᴦ��
	# request ���а����˺ܶ�����쳣����Ϣ 
		org.springframework.web.util.WebUtils ���ṩ�˺ܶೣ��,����request���쳣��Ϣ��key
		public static final String ERROR_STATUS_CODE_ATTRIBUTE = "javax.servlet.error.status_code";
		public static final String ERROR_EXCEPTION_TYPE_ATTRIBUTE = "javax.servlet.error.exception_type";
		public static final String ERROR_MESSAGE_ATTRIBUTE = "javax.servlet.error.message";
		public static final String ERROR_EXCEPTION_ATTRIBUTE = "javax.servlet.error.exception";
		public static final String ERROR_REQUEST_URI_ATTRIBUTE = "javax.servlet.error.request_uri";
		public static final String ERROR_SERVLET_NAME_ATTRIBUTE = "javax.servlet.error.servlet_name";

	@Component
	public class ExceptionController implements HandlerExceptionResolver {

		private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);
		
		/*
		 * ���Ը������������(Ajax)��ȷ���Ƿ���mv����ֱ����Ӧajax����
		 * ���ַ�ʽ,ֻ�ܴ�������������쳣,�޷����� 404 ֮����쳣
		 */
		@Override
		@ExceptionHandler
		public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
			HandlerMethod handlerMethod = (HandlerMethod) o;		//��handler����ǿת
			Method method = handlerMethod.getMethod();				//��ȡ�������쳣�ķ�������

			return new ModelAndView("error/error");
		}
	}


---------------------------------
---------------------------------
	# �ڶ��ַ�ʽ
	# ʹ�� Spring �ṩ�Ĵ�����
	# �ܴ�������쳣

	import org.springframework.http.converter.HttpMessageNotReadableException;
	import org.springframework.stereotype.Component;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.springframework.http.HttpStatus;

	import org.springframework.web.HttpMediaTypeNotSupportedException;
	import org.springframework.web.HttpRequestMethodNotSupportedException;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.ResponseStatus;


	@ControllerAdvice 
	@Component
	public class ExceptionAdvice {
		
		/** 
		 * 400 - Bad Request 
		 */  
		@ResponseStatus(HttpStatus.BAD_REQUEST)  
		@ExceptionHandler(HttpMessageNotReadableException.class)  
		public void  handleHttpMessageNotReadableException(HttpServletRequest request,HttpServletResponse response,HttpMessageNotReadableException e) {  
		}  
	  
		/** 
		 * 405 - Method Not Allowed 
		 */  
		@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)  
		@ExceptionHandler(HttpRequestMethodNotSupportedException.class)  
		public void handleHttpRequestMethodNotSupportedException(HttpServletRequest request,HttpServletResponse response,HttpRequestMethodNotSupportedException e) {  
		}  
	  
		/** 
		 * 415 - Unsupported Media Type 
		 */  
		@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)  
		@ExceptionHandler(HttpMediaTypeNotSupportedException.class)  
		public void handleHttpMediaTypeNotSupportedException(HttpServletRequest request,HttpServletResponse response,HttpMediaTypeNotSupportedException e) {  
		}  
	  
		/** 
		 * 500 - Internal Server Error 
		 */  
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  
		@ExceptionHandler(Exception.class)  
		public void handleException(HttpServletRequest request,HttpServletResponse response,Exception e) {  
			
		}  
	}

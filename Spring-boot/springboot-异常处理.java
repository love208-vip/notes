----------------------------
Spring boot-�쳣����1		|
----------------------------
	# ʹ�� Spring Boot �ṩ�Ĵ�����
	# ���Դ��� 404,500���쳣
	1,�Զ��쳣���� Controller ,ʵ�ֽӿ�: org.springframework.boot.autoconfigure.web.ErrorController.ErrorController
	2,��д����
		
		@Controller
		public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

			private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

			/**
			 * ����ҳ���Ŀ¼/·��
			 * classpatg:/templates/error/error.html
			 */
			private static final String ERROR_PATH = "error";

			/**
			 * �쳣��ʱ��,ϵͳ���Զ���ת�����·��,���һ��� request ���д�źܶ�����쳣����Ϣ
			 * ���Ը����쳣״̬�����ж���ʲô�쳣
			 * Ҳ���Ը�����������(ajax)�����Ƿ���ModelAndView����ֱ����ӦAjax����
			 * @param modelAndView
			 * @param request
			 * @param response
			 * @return
			 */
			@RequestMapping(value = ERROR_PATH,method = RequestMethod.GET)
			public ModelAndView error(ModelAndView modelAndView,
									  HttpServletRequest request,
									  HttpServletResponse response){
				Class exceptionType = (Class) request.getAttribute("javax.servlet.error.exception_type");   //�쳣����
				Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");    //�쳣��,ֻ���� 500 �쳣�������,��ֵ��Ϊ��
				Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");     //HTTP�쳣״̬��
				String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");     //�쳣��Servlet
				String erroPath = (String) request.getAttribute("javax.servlet.error.request_uri");         //�������쳣�������ַ(�����ǵ�ǰ��ַ-request.getRequestURI())
				LOGGER.error("�������쳣, erroPath={}, message={}",erroPath,exception.getMessage());
				/**
				 * ��ֹ�����������·��������С�ף��Ƚٳֲ���ʾ�Լ��Ĵ���ҳ�棬ǿ�ƽ�code����Ϊ200
				 * ������ajax���޷�������״̬
				 */
				response.setStatus(HttpServletResponse.SC_OK);
				return new ModelAndView(ERROR_PATH + "/error");
			}

			/**
			 * �쳣��ʱ��,ϵͳ���Զ������������,��ȡ���쳣��·��.Ȼ��Ը�·��ִ������
			 * @return
			 */
			@Override
			public String getErrorPath() {
				return ERROR_PATH;
			}
		}

----------------------------
Spring boot-�쳣����2		|
----------------------------
	# ʹ�� Spring �ṩ�Ĵ�����
	# ����ֻ�ܴ���� 500 �������쳣,404 ֮��Ĳ��ᴦ��
	# ʵ�� HandlerExceptionResolver ע�ᵽIOC��ʵ��ȫ�ֵ��쳣����

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
	

	# ����
	# ����ֻ�ܴ���� 500 �������쳣,404 ֮��Ĳ��ᴦ��
	# ��ʶ @ControllerAdvice ����Controllerע��,ע�ᵽIOC,��ʵ��ȫ���쳣�Ĵ���
		@ControllerAdvice
		public class ExceptionController {

			private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);
			
			/*
			 * ���Ը������������(Ajax)��ȷ���Ƿ���mv����ֱ����Ӧajax����
			 * ���ַ�ʽ,ֻ�ܴ�������������쳣,�޷����� 404 ֮����쳣
			 */
			@ExceptionHandler
			public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
				HandlerMethod handlerMethod = (HandlerMethod) o;		//��handler����ǿת
				Method method = handlerMethod.getMethod();				//��ȡ�������쳣�ķ�������
				return new ModelAndView("error/error");
			}
		}
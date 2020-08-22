SpringMVC��ʹ�õ�����Щע��

	@RequestMapping
		* ��ע��Ϊ������ָ��,���Դ�����ЩURL����
		* ����ע�ⷽ��/��.���뷽���ϵ�ע�⹹��һ��������URL����·��
		* ���ֻ�е�������,��ô������ڸ�Ŀ¼�ṹ.�����ע�����,��ô����·�������������·��
		�߱�����
			1,value
				* ����url
			2,method
				* ���󷽷�(get/post),��һ������,���ж��
			3,params
				* �������(������),����ָ��:��������ĸ�����?,���������Ƕ���?��һ��Ҫ����?..ȥ�����,û��!
			4,heads
				* ����ͷ(������)
		* ��ע����˿���ʹ��URLӳ������ͷ��,������ʹ�����󷽷�,�������,����ͷ...�ֱ�������������ָ��
		  ����֮��Ĺ�ϵ����,����ʹ�ö������,������������Ӿ�ȷ��
		  ��:@RequestMapping(value="/demo.action",method=RequestMethod.GET)
			* ֻ��ʹ��GET��ʽ���������������
		* ����ӳ�仹֧��ͨ���,��������ͨ�����ͨ��ant������������õ�
			* ant�����Դ��ַ,֧������ƥ���
				1,?:ƥ���ļ����е�һ���ַ�
				2,*:ƥ���ļ����е������ַ�
				3,**:ƥ����·��

				localhost:8080/demo/*/logon.action														*/
				�˽�ͺ�... ...��ȥ����
	

	@RestConttroller
		* ����� @Controller �� @ResponseBody ��һ��ע��

	@PathVariable
		* ��ע����3.0�汾�������Ķ���,��ռλ����UR!�ù�����SpringMVC��RESTĿ��ͦ����չ�����о�����̱�������
		* ͨ����ע��,���԰�URL��ռλ�������󶨵����ƴ������������β���.
		* ��:
			@RequestMapping("/delete/{userid}")
			public String delete(@PathVariable("userid") String id){
				userService.delete(id);
				return null;
			}
		* ���ģ��·���д���'.'��Ļ�,�ᶪʧ'.'����Ĳ���
			@RequestMapping("/delete/{userid:.+}")		//:.+ �Ϳ��Գɹ��Ļ�ȡ��ģ������д�.�Ĳ���
			public String delete(@PathVariable("userid") String id){
				userService.delete(id);
				return null;
			}
		
	@CookieValue
		# ��Cookieֵ�󶨵��β�

	@RequestParam
		# ��������󶨵��β�
	
	@RequestHeader
		# Htttp ����ͷ�󶨵��β�

	@InitBinder
		# �ɱ��ֶε�javaBean�İ�,�ڼ�������һЩ���͵�ת���Լ����ݵĸ�ʽ������
		# ��ע���ʶ�ķ���,���Զ�WebDataBinder������г�ʼ��.WebDataBinder ��DateBinder������.��������ɱ��ֶε�javaBean���Եİ�
		# ������ʶ�ķ��������з���ֵ,����������Ϊvoid.
		# ������ʶ�ķ���,�β�ͨ����WebDataBinder
		��:
			@InitBinder
			public void initBinder(WebDataBinder dataBinder)
			{
				dataBinder.setDisallowedfields("roleset);
			}
	
	@ModelAttribute
		# 
	
	@GetMapping
	@PostMapping
	@DeleteMapping
	@PutMapping
		# ����Ȼ,RESTFult ��Mapping,�Ƚϸߵİ汾���еĶ���
	
	
	@SessionAttributes
		# ����
			* String[] value() default {};
			* Class<?>[] types() default {};
		

	@ExceptionHandler
		# ��ʶ��һ��������,���Ҹ�����Ҫ��Spring������
		# ��Controller�����쳣��ʱ��,����ø÷���,��ʵ���Ǹ��쳣����
		# ����
			Class<? extends Throwable>[] value() default {};
			* ��ֵ��ʾ,��ϵͳ�쳣ʱ,����ݲ�ͬ��Exception�ҵ���ͬ�� @ExceptionHandler ���д���

	
	@ControllerAdvice
		# Controller��ǰ,��ע���ʶ��  @Component  ע��,Ҳ����˵���Ա�ɨ�赽,������Ҫ��Ӹ�ע���� scan include��
		# ���������Controller���涨��һЩ���������Controller������
		# ��һЩ�ô�,��ʹ�� @ExceptionHandler �����ã���������(@InitBinder,@ModelAttribute)�ô�����
		# ���԰��쳣������Ӧ�õ����п������������� @Controller ע��ĵ�����������
		# Demo
			@ControllerAdvice  
			public class ControllerAdviceTest {  
			  
				@ModelAttribute  
				public User newUser() {  
					System.out.println("============Ӧ�õ�����@RequestMappingע�ⷽ��������ִ��֮ǰ�ѷ���ֵ����Model");  
					return new User();  
				}  
			  
				@InitBinder  
				public void initBinder(WebDataBinder binder) {  
					System.out.println("============Ӧ�õ�����@RequestMappingע�ⷽ��������ִ��֮ǰ��ʼ�����ݰ���");  
				}  
			  
				@ExceptionHandler(Exception.class)  
				@ResponseStatus(HttpStatus.UNAUTHORIZED)  
				public String processUnauthenticatedException(HttpServletRequest  request, Exception e) {  
					System.out.println("===========Ӧ�õ�����@RequestMappingע��ķ����������׳�Exception�쳣ʱִ��");  
					return "viewName"; //����һ���߼���ͼ��  
				}  
			}  
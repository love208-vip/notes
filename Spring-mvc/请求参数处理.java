
����Spring��������Ļ�ȡ

['������������']
	* SpringMVCͨ����������'������ǩ��',��HTTP������Ϣ�󶨵���������Ӧ��'�β�'��!
	* SpringMVC�Կ�����������ǩ���������Ǻܿ��ɵ�,�������԰�ϲ�����κη�ʽ�Է�������ǩ��
	* ��Ҫʱ,���ԶԷ���,�Լ������βα�ע��Ӧ��ע��
		* @RequestParam
			value
				* ������
			required
				* �Ƿ��Ǳ����,Ĭ��Ϊtrue.��ʾ��������б��������Ӧ�Ĳ���,����������׳��쳣
			defaultValue
				* Ĭ��ֵ,����������û�д���,��ô�������н�ʹ�����Ĭ��ֵ���βΰ�
			��:
				public String demo(@RequestParam(value="name",required=false,defaulValue="Kevin")String name,@RequestParam(value="age",required=true)Integer age){}
				* ��ʾ,���������,name�����Կ�ѡ,���û,��ôĬ��Ϊkevin,age�����Ǳ����
				* ע���ʶ�Ĳ��������Բ��ͷ����β���һ��
				* ��ܻ��Զ��Ľ�������ת��
		* @PathVariable(REST)

['HTTP����ͷ']
	* @RequestHeader
		* ��ע���ǻ�ȡHTTP����ͷ
		��:
			public String demo(@RequestHeader(value="Accept-Language")String language){}
			* ���βξͻ�õ�ָ������ͷ��ֵ
	* ��ܻ��HTTP������Ϣ�󶨵���Ӧ�������β���,�����ݷ����ķ���ֵ����������Ӧ�ĺ�������
	
['Cookie']

	* @CookieValue
		* �����ô������βΰ�ĳ�������������Cookieֵ
		* �������������͵�ע��һ��,Ҳ�Ǿ߱�һ��'�Ƿ�Ϊ����'������
		��:
			public String demo(@CookieValue(value="jsessionid",required=false)String id){}

['ʹ��POJO��Ϊ����']
	* ��ܻ��Զ������������,��POJO�����������Զ�ƥ��!�Զ���Ϊ�����������ֵ
	* '֧�ּ���',��Luser.id,user.order.id
	* localhost8080/demo.action?userName=Kevin&user.order.id=10086
	��:
		public String demo(User user)
		{
			//��struts2һ������,ҳ��input�ֶ�,֧������.��������POJO�����Խ��и�ֵ
		}


['������ʽ']
	* String[]  hobby
	* ����ָ�����β��ж�������



['List']
	* ������Ϊ List ��ʱ��,Ҫͨ����װPOJO������,Ҳ������POJO��Ҫ���� List ����,��������Ҫ��ҳ��һ��
	* ���֧�ּ������� href=demo.action?user.user.name=sdasd
	* ������֧��: name="user.hobby[1]"	�е���OGNL���ʽ

	* ţ��֮������, List ���͵����ݰ󶨻�����ͨ������
		http://..item/delelteById?ids=123,456,789

		public void deleteById(@RequestParam(value="ids") List<Object> ids){
			
		}
		# ҳ�洫�ݵ�һ������,����','�ŷָ��.��ô������List������,springmvc���Զ��Ľ����и�... ...�𲻵�?

['Map']
	* ������Ϊ Map ��ʱ��,Ҳ��Ҫͨ����װ���͵�POJO �����н���
	

	




	SpringMVC��Handler,���������β�,���Խ�������ServletAPI���͵Ĳ���

	HttpServletRequest
	HttpServletResponse
		* ���ʹ��response���ͻ��˽�����Ӧ,��ô�����з���ֵ.�Ż���Ч.Ҳ����˵��ͼ����>responseֱ�Ӳ���
	HttpSession
	java.security.Principal
	Locale
	InputStream
	OutputStream
	Reader
	Writer









['���ڷ�ʽ']
	1, Handler�̳�һ����(�����Ѿ�����ʶ��ʱ,������ʹ��)
		����org.springframework.web.servlet.mvc.AbstractCommandController
		��������ʵ�Ѿ�ʵ����:Controller�ӿ�,�������ĸ�������,�Ͳ���˵
	2, ͬ��Ҳ�Ǹ�дһ��handle����
		protected ModelAndView handle(request,response,Obj,BindException error){}
		������ԭʼ��ʽ(ʵ��Controller�ӿ�)�����������.Object obj,BindException error
		������ʵ���obj,�������������װ���ʵ��,error,��ʾ��װʱ�������쳣
	3, ��Handler����ʾ�����޲ι�����!�ڹ�������,�������Ը���ķ���:this.setCommandClass(Class clzz);
		������ʵ,���Ǵ��ݽ�ȥModel,��������.��ܻ��Զ��Ĵ�������,��װ����
		����ͬʱ�϶�Ҫ��,�������ݵ�name����,Ҫ��Model����������һ��
	4, ��ô��handle������,��Ϳ���ͨ������������ȡ������Ѿ���װ�����ݵĶ���.����ǿת��ʹ��!
	5, �������������,request.setChartset("utf-8");��������
	6, ��struts2�е�����,�������һЩ�������͵����ݸ�ʽת��.�����漰���� Date ֮��ľͱȽϿӵ�,����Ҫʹ�õ�'�Զ�������ת����'
		������springMVC�ڲ�ע��һ���Զ��������ת����
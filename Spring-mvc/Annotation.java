
///////////////////////////////////////////////////////////////////////////////////////

@Controller			
	* ��ʶ��Handler,��ʾ��IOC�н���ע��
@RequestMapping		
	* ��ʶ����,Ҳ���Ա�ʶ�ڷ�����!����URL+������URL = URL����·��,��֧��ant����URL,��ʵ����:*,**,? ����������Ϊͨ���
@RequestParam
	* ��ʶHandler�β�,��Ϊ����������ձ���
@RequestHeader
	* ��ʶHandler�β�,��Ϊ����ͷ���ձ���
@CookieValue
	* ��ʶHandler�β�,��ΪCookie���ձ���
@SessionAttributes
	* ��ʶHandler,��ָ����ģ������.����Session
@ModelAttribute
	* ��ʶ�����ϻ���Handler�β���,����Handler������ִ��֮ǰִ��.���Ի�ȡ�������!
@PathVariable
	* ��ʶHandler�β�,���URLռλ��,RESTful����url
@InitBinder
	* ��ʶHander,���Զ�WebDataBinder������г�ʼ��.��������ֵ������void,����ͨ����:WebDataBinder!
@DateTimeFormat
	* ��ʶPOJO���,Date �������͵��ֶ�,ָ����ʾʱ����ַ�����ʽ!�ύ�����ͱ��������ָ�ʽ���ύ����ʱ����ַ���.
@NumberFormat
	* ��ʶPJO���,Number �������͵��ֶ�,ͨ��ʹ��"#"��,��ȷ�����ݸ�ʽ.��:@NumberFormat(pattern="####,###.#")
@RequestBody
	* ��ʶHandler�β�POJO,����������е�json�ַ���ת��ΪjavaBean
@ResponseBody
	* ��ʶHandler�ķ���ֵ(�÷���ֵ,Ӧ����һ��POJO����һ������),����ֱ�ӱ�־�ڷ�����,�ѷ��ظ��ͻ��Ķ���,ת��Ϊjson


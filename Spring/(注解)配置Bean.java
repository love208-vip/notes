����������������������������������������
һ,ע������javaBean	|
����������������������������������������
	֮ǰ���ǵ�Bean,���ǲ��û���xml��������,���ڿ��Կ���ͨ��ע������������,���������������!
	> ���ע�����õ�bean��xml���õ�beanͬʱ����,id��ͬ�����ɲ�ͬ��ʵ��!xml����һ��,ע������һ��!
	> ���ͬʱ����ע��,��xml�������ô��ڵĻ�!��ôxml���ȼ��Ƚϴ�!

����������������������������������������
��,�齨ɨ����		|
����������������������������������������
	�齨ɨ��(component scanning)
	> spring�ܹ���classpath���Զ�ɨ��,����ʵ���������ض�ע����齨
	�ض��齨��������(��ע��,��ʵ���Ǽ�������һ����.ֻ�Ǳ�ʶ�ĵط���ͬ����) 
	@Component
		* ����ע��,��־��һ����spring������齨,һ���ʶ����ͨ��javaBean��
	@Repository
		* �����ʶ�־ò��齨
	@Service
		* �����ʶ�����(ҵ���)�齨
	@Controller
		* �����ʶ���ֲ��齨
	> ����ɨ�赽���齨,spring'��Ĭ�ϵ���������',ʹ�÷��޶�����,��һ����ĸСд
	> Ҳ������ע����ͨ��value����ֵ��ʶ�齨������
		* @xxxx(value="�Զ�������")//value����ʡ��,ע���㶮��,���в�Ҳ���㶮��
		* �ڻ�ȡ��ʱ��Ϳ���ͨ���Զ�����������ȡ,������,Ĭ���Ǽ���������ĸСд���ⶫ����������Ϊ����xml�����е�id����
		* ��Ҫע�����,ͬһ��ɨ���齨��,���ܳ���������ͬ��ע��!��ȻgetBean("xxx")ʱ�쳣!
	> �����齨����ʹ�����ض�������֮��,����Ҫ��spring�������ļ�������<context:component-scan/>
	> ������Ҫ����context�����ռ�

	<context:component-scan base-package="com.kevin.annotation" resource-pattern="controller/UserController.class" use-default-filters="">
		<context:exclude-filter type="annotation" expression=""/>
		<context:include-filter type="annotation" expression=""/>
	</context:component-scan>

	* base-package
		> ��ʾɨ��İ�,srcĿ¼�µİ���ȫ�޶���
	* resource-pattern
		> ��ʾֻɨ��base-package���µ�ָ����,ע�ⶨ��ĸ�ʽ!
		> ����ʹ��ͨ��� xxx/*.class											*/
	* �����ж��context:include-filter����context:exclude-filter�ӱ�ǩ!
	> context:exclude-filter:��ʾҪ�ų������Ŀ����	<context:exclude-filter type="annotation" expression=""/>
	> context:include-filter:��ʾҪ������Ŀ����		<context:include-filter type="annotation" expression=""/>
	* type:���Է���һЩ���ʽ,���õ�������
	1,annotation
		> <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Component"/>
		> ���б�ע�� @Component ע�����,��������,������ʵ����!����
		> <context:include-filter type="assignable" expression="org.springframework.stereotype.Component"/>
		> ֻ�� @@Component ע���ʶ����,�Ž���ʵ��������!������ȫ������
		* ע��,Ҫ�������ǩ��Ч,����Ҫ��context:component-scan��ǩ���һ������:use-default-filters="false",��ֵĬ��Ϊtrue,Ҫ����Ϊfalse,������ò���Ч
	2,assinable
		> <context:exclude-filter type="assignable" expression="ָ������ȫ����"/>
		> ��������ָ����,������!����ָ���ӿ�,���ȫ����(ע��:����ǩ��use-default-filters����Ӧ��Ϊfalse,���߲�д)
		> <context:include-filter type="assignable" expression="ָ������ȫ����"/>
		> ֻʵ����ָ���������,����ָ���ӿ�,���ȫ����(ע��:����ǩ��use-default-filters����Ӧ��Ϊtrue)
	3,aspectj	������
	4,regex		������
	5,custom	������

����������������������������������������
��,������ϵ			|
����������������������������������������
	��ʵ<context:component-scan>Ԫ�ػ����Զ�ע��,AutowiredAnnotationBaenPostProcessor ʵ��,��ʵ�������Զ�װ�����
	@Autowired �� @Resource,@inject ע������ԣ�

	> @Autowired: ��ע���ʶ�ڳ�Ա�ֶ���,IOC������װ�ص�ʱ��,������������Ա��Ӧ������,����ʵ����������ֵ!					 |@Autowired
		* ����service�������dao,�����ֶ�!�Ϳ��Լ������,�����ͻ��Զ��ҵ�dao����,�����ʼ��,���Ҳ���Ҫ�ṩ�ֶε�get/set����: |private UserDao userDao;
		* ��ע���Զ�װ����м����Եĵ���Bean����
		* ���Է��ڹ�����,�ֶ�,���в����ķ���!�������?�����ҵ�֮��͸��������!����Ҳ�����Ӧ�����ԵĻ�,�ͻ��׳��쳣!��������ֶα�ʶ�˸�ע��,��ô�ֶζ�Ӧ����ҲҪ'�ܵ������Ĺ���'
		* �������ϣ��ĳһ������,����û���ҵ�,�������� @Autowired ��һ������Ϊfalse
			> @Autowired(required=false)
			> ����˵,�ҵõ��͸���ע����!�Ҳ��������˾���null,�����쳣!
		* ���ڶ����ͬ���͵����ʱ��!����˵�ж����ͬ����,���ĸ�?
			> ���Ȼ���ݱ���ע���ʶ������/��������..������!ȥѰ�Ҷ�Ӧ��(���)��ע���valueֵ(����ıʼ�),����ƥ��!˭ƥ������,����˭! 
			> �����û���ҵ�,�׳�@Autowired�쳣!(˵���˾���,��  ��ʶ�����Եı�����,�����ĸ���Ӧ���ע���valueֵ��ͬ,���valueֵ��ʵ��xml�е�id,������ıʼ�)
			> ���ڶ��ͬ������,����һ��ע�� @Qualifier(value="ָ������")
				* ���ע��� @Autowired ͬʱ����,vlaueֵΪ����bean������,����ĸСд!����Ҳ���ҵ�ָ������
				* ����:@Autowired ע���ʶ�ط�����һ���ӿ����͵Ĳ���!����ӿ���N�������!������������ӿ����͵�,������֪�������ĸ�?�Ϳ��������ע��,����ʾҪ�ҵ�����,����ҪСд!�����Ǹ���ҲҪ�� @Autowired ע��!��value��д!
			> ��Ȼ,����Ǹ�ע����valueֵ,��ô���ǿ��Բ������ע��,������ķ���,�ѱ������Ƹ�Ϊ�Ǹ��� @Autowired ע��� valueֵҲ�ǿ����ҵ���!
		* @Autowired ע��Ҳ����Ӧ���� �������͵�������,��ʱspring�������ƥ���bean�����Զ�װ��
		* @Autowired ע��Ҳ����Ӧ���� ��������,spring��ȡ�ü��ϵ�������Ϣ(����),Ȼ���Զ�װ����֮���ݵ�Bean
		* @Autowired ע��Ҳ����Ӧ���� Map ����,spring���Զ�װ����Mapֵ���ͼ��ݵ�Bean,ע��,���ʱ��,Bean������,��key,ֵ�����Ǹ�Bean!
	> @Resource
		* �� @Autowired ��������,��ע��,Ҫ���ṩһ��Bean���Ƶ�����,���������Ϊnull,�Ͳ��ñ�ע�������򷽷�����ΪBean������
		* @Resource(name="xxx") = @Autowired(required=false) + @Qualifier(value="xxx")
	> @inject
		* Ҳ��һ��,Ҳ�ǰ�����ƥ��ע��,����û�� reqired ����!
	---����ʹ�� @Autowired

������������������������������������������������
��,�������Ե�ע������	|
������������������������������������������������

1,����ͨ�����Ա��ע�⸳ֵ
	@value(value="kevin")
	private String  name;
	
	* �������ṩget/set����!��������ô��д������,Ϊʲô��ֱ��д����?

2,��ʼ���Լ����ٷ���
	<bean ini-method="">
	@PsotConstruct
		//�����ڳ�ʼ��������
	<bean destory-method="">
	@PreDestory
		//�������ٷ�����

3,����Bean��������
	@Scope("prototype")
	> ����Bean��������,��ע������
	* prototype	(�ǵ���,��������IOC��������������,ÿ��getBean���᷵���µ�ʵ��)
	* request
	* session	
	* singleton(Ĭ��,������,����IOC��������������)

������������������������������������������������
��,��չ					|
������������������������������������������������
	Spring 3.0��javaConfigΪ����.�ṩʹ��java�ඨ��Bean��Ϣ�ķ���

	@Configuration ָ�� POJO��ΪSpring�ṩBean������Ϣ
	@Bean �ṩһ��Bean������Ϣ

	* ���ĳ����,�����ر���,����xml��ע�ⶼ����ʹ.�Ϳ���ʹ�����ַ�ʽ������!

	* ֻҪ��Springɨ�赽������OK
	-------------------------------------
	@Configuration						//���ע�������������һ��������
	public class Factory
	{
		@Bean(name="car")				//���������һ��Bean,��ע�ᵽIOC
		public Car getCar()
		{
			retuen new Car(100,"����");
		}
		@Bean(name="Customer")			//��Ҳ��һ��Bean,Ҳ��ע�ᵽIOC
		public Customer getCustomer()
		{
			return new Customer(100,"Kevin");
		}
	}

������������������������������������������������
��,XML��ע����ʹ��	|
������������������������������������������������
	��ʵ�ʵĿ�����,spring����ע���xml��ѡ��.���п���.�������п���һ��ʹ��
		ע��:�Զ�ע��,��.�������ṩset����
		XML :�ṹ�Ը�ǿ,Bean�����׹���
	
	Bean,ͨ��xmlע��
	����,ͨ��ע��ע��

	<context:annotation-config/>
	* ��xml��������ע��,�Ϳ�������Щ������:���Ա,�����ϵ�ע����Ч
	* @Resource @PostConstruct @PreDestory @AutoWired

	<context:component-scan>
	* ��ע�������ʱ��,���Զ���ע�� <context:annotation-config/>
	* ���ע����ɨ�����ϵ�,ͬʱҲ������Щ������:��,���Ա,�����ϵ�ע����Ч
	* ��Ϊ���ǵ��඼�ǽ�����xml���й���,���ϲ�����ע��.�����ںϲ�������ʱ��,ֻ���ϵ�һ��(ֻ�Է���,���Ա�ϵ�ע����Ч)!

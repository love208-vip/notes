
@Component
@Service
@Controller
@Repository
@Scope
@Transactional

@Configuration
	# ����
		* String value() default "";
	# ��bean��ø���,�������õ�ʱ��,����ʹ�ø�ע���ʶһ����,��ʶ��ǰ����һ��������
	# �����µ����з������ǹ�������,��Щ�������صĶ���,�ᱻ����IOC����

@Bean
	# ����
		* String[] name() default {};		
		* Autowire autowire() default Autowire.NO;
		* String initMethod() default "";
		* String destroyMethod() default AbstractBeanDefinition.INFER_METHOD;
	# ��ʶ�� @Configuration ��ʶ��ķ�����,��ʾ��ǰ�����ķ��ض���ᱻ����IOC,bean�����ƾ��Ƿ�����
	# ������� @Configuration �ж�ε��ô� @Beam �ķ���,���صĶ�����IOC����һ��Ψһ��


@Conditional
	# ����
		* Class<? extends Condition>[] value();

	# һ�㶼����� @Configuration ����ʹ��
	# ������һ�� Class <clazz extends Condition> ����,Condition �ýӿ��и� ���� boolean �ķ���
		* ����÷������� true,��ô�ͻ�ʵ������ע��bean
		* ���� false �����
	# ��������Ա�ע�������棬��ʾ�������������@Bean������������.Ҳ���Ե����ı�ע�ڷ�����

@ComponentScan
	# ����
		�ܶ�,����API
	# ʹ��ע��ķ���ȥɨ�������


@EnableAspectJAutoProxy
	# ����
	# ʹ��ע��ķ�ʽ,������AspectJ�����֧��

@PostConstruct
	# ��ʶ��bean�ķ�����,�ڸ÷���ִ�й��캯��(��������)��ִ��

@PreDestroy
	# ��ʶ��bean�ķ�����,����������֮ǰִ��

@Profile
	# ����
		String[] value();

@CrossOrigin
	# ����֧��

@DependsOn
	# ��ʶ�� Bean �����,��ʾ����������ڸ�ע��ָ�������(������ᱻ���ȵļ��ص�mvc)





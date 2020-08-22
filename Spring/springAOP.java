������������������������������������������������
һ,AspectJ����			|
������������������������������������������������
AspectJ
	> Java���������������е�AOP���
	> ��Spring2.0���ϰ汾��,����ʹ�û���AspectJע������xml���õ�AOP
	> ʵ����,spring�Լ�Ҳ��һ��AOP��ܵ�ʵ��,�������AspectJ��ֵ�������Ƽ�ȥʹ��
	
������������������������������������������������
��,����ע��ķ�ʽ		|
������������������������������������������������
	> ��springӦ��Ҫ�õ�AspectJע��,����Ҫ��classpath�°���AspectJ�����
		* aspectj.weaver.jar
		* aopalliance.jar
		* spring-aspects.jar

	> Ҫ��springIOC����������AspectJע��֧��,ֻҪ��Bean�ļ��и�Ԫ���¶���һ���յ�XMLԪ��
		* <aop:aspectj-autoproxy/>
		* <aop:aspectj-autoproxy proxy-target-class="true" />
			* proxy-target-class Ĭ��ֵΪ false,��ʾʹ��JDK�Ķ�̬����,����Ϊ"ture",��ʾʹ��CGLib��̬����
			* ������ʹproxy-target-class����Ϊfalse�����Ŀ����û�������ӿڣ���spring���Զ�ʹ��CGLib��̬���� 
			
	> ��springIOC������⵽Bean�����ļ��е�<aop:aspectj-autoproxy>Ԫ��ʱ,���Զ���Aspectj����ƥ���Bean��������
		* ��������:��Ϊ������ע������,���BeanҲ��ע������,�������Ҫʹ�õ�ɨ����,�ǵ����ð�

һ,������(�ҵ�������,��������ǰ�������ǿ��������)
	> 1,�������������ע��
	@Aspect
	@Component
	@Order(1)
		> ��һ��ע����Ǳ�־������һ��'��ǿ��',רҵ�ľͽ�����,���й�ע��
		> ������,���뽻��IOC��������,����ҲҪ����@Component
		> ��������Ϊ�������������ȼ���,����������ϸ����(Ŀ�귽�����ڶ����֪ͬͨ������,˭��ֵ��,˭��֪ͨ����ִ��)

��,���������д�������,Ҳ���Ǵ�˵�е���ǿ����(Ҳ������ô��֪ͨ)!
	> ������������ע�������,��ĳһ��ʱ��,'���Ŀ�귽��'ִ��!
	֪ͨע��
	@Before("execution(public int com.kevin.Demo.demo(int,int))")
		> ǰ��֪ͨ,�����ע���ʶ�ķ���,����executionָ����'Ŀ�귽��ִ��ǰִ��'!
		> ���ָ���ķ���������,Ҳ�����׳��쳣(xml���ò��Թ�,ע��û�Թ�,�˳�һ����)
		> ע��execution��ֵ�ĸ�ʽ:Ȩ�� ����ֵ ����..����.������(����ǩ��)			[ע��,û���β�]
		> execution��֧��'ͨ���',����:@Before("execution(public int com.kevin.Demo.*(int,int))")
			* ע��,����ͨ���ֻ��,���Ʋ�һ��.����ֵ,����ǩ�����������execution���ʽ�ĺ�����Ч(�����о����һ�����ʽ�ܽ�)
		> ǰ��֪ͨû�а취��ֹĿ�귽����ִ��

	@After("execution(public int com.kevin.aop.imple.ArithmeticCalculator.add(int,int))")
		> ����֪ͨ,ͬ����,ֻ�����������executionָ������ִ�к�ִ��
		> ����Ŀ�귽��'�Ƿ��׳��쳣,����ִ��'
		> ���֪ͨ'���ܷ���Ŀ�귽����ִ�н��',Ҳ����Ŀ�귽��return�Ľ��!

	@AfterReturning(...)
		> ����֪ͨ,����ͬ��.��Ŀ�귽���ɹ�return֮��ִ��
		> ���֪ͨ,��Ŀ�귽�������쳣�󲻻�ִ��
		> ���֪ͨ,��'���Ի�ȡ�������ķ���ֵ'��!
		  1,��ע�������һ������,ע��,�ж��ע�����Դ���!value���Ե���ȨʧЧ,��ʱ����ָ��value������
			@AfterReturning(value="execution(...)",returning="result")	//returning�����Ծ���һ��������,�����Զ���
		  2,�ڸ�ע���ʶ�ķ�����,���һ���β�(����ǩ��)					
			public void advice(Object result)							//�βε�����Ҫע�Ᵽ�ָ�ע��returning��������һ��
		  3,�ڸ÷���(֪ͨ)��,���result,����Ŀ�귽���ķ���ֵ,ע��!��Object���͵�

	@AfterThrowing(...)
		> �쳣֪ͨ,����ͬ��.��Ŀ�귽��'�׳��쳣��ִ��'
		> ���֪ͨ���Ի�ȡ��Ŀ�귽�����ֵ��쳣����(��Ϣ)
		  1,��Ҫ��ע�������һ������
		  	@AfterThrowing(value="execution(...)",throwing="ex")	//throwing�����Ծ���һ��������,�����Լ�����
		  2,��ȡĿ��ķ������ֵ��쳣
			public void exce(Exception ex){}						//��Ҫע�����,�βεı���������Ҫ��throwing���Ա���һ��
		  3,����β�,����Ŀ�귽���������쳣����,�����֪ͨ'����'������Ի�ȡ��!
		ע��:
		* ������(֪ͨ)�������β�ȷ��ָ���������쳣,��ô��'֪ͨ'(����),ֻ����Ŀ�귽���׳�,ָ���쳣���������쳣,���ִ��
		  public void exce(NullPointerException ex)	
		> �˴��β�ָ�����쳣�����ǿ�ָ���쳣,��ôֻ��Ŀ�귽�����ֿ�ָ���쳣��ʱ��,��ע��Ż�ִ��!
		> ���������쳣,��֪ͨ(����)����ִ��
		* �б�Ҫ˵������,���Ŀ�귽�����쳣������trycatch����!Ҳ����ִ��,��ʵ����û�쳣,ǧ����!
		* ֪ͨ(����),��Ŀ�귽���׳��쳣ǰִ��,����Ҫ��ס����!�쳣���ǻ��׳�����!��㶰����ֵ�!

	@Around(...)	
		> ����֪ͨ,�����ڶ�̬�����ȫ����,���֪ͨ����һ��������β�:ProceedingJoinPoint
		> �����Կ���'�Ƿ�ִ��Ŀ�귽��'
		> ����֪ͨ�������з���ֵ,�����������ֵ�����Ŀ�귽���ķ���ֵ(��̬����InvocationHandler�ӿڵ��Ǹ����󷽷�... ...)
		> ����Ƿ������Ͳ�ƥ��,��ô���׳��쳣,����:Ŀ�귽���ķ���ֵ������String,������֪ͨ����ֵ��int.

		--------------ֱ���ϴ���
		@Around("...")
		public Object around(ProceedingJoinPoint pj)
		{
			Object obj = null;
			String methodName = pj.getSignature().getName();//Ŀ�귽������
			Object[] params = pj.getArgs();					//Ŀ�귽������	
			try 
			{
				//��ȡ��
				Object = pj.getTarget();  
				//�˴�������Ϊǰ��֪ͨ�е���doFilter����
				obj = pj.proceed();//�����˾��ĵ���Ŀ�귽��,�õ����ؽ��
				//�˴�������Ϊ������ǿ(֪ͨ)
			} 
			catch (Throwable e)
			{
				//�˴�������Ϊ�쳣֪ͨ
				e.printStackTrace();
			}
			return obj;		//����Ŀ�귽��ִ�к�Ľ��
		}
		* ע��,�ڵ���Ŀ�귽����ʱ��,������������֪ͨ���Ϲ�!��ô����ֵ�����������֪ͨ������,�������ֵ,����Ŀ�귽���ķ���ֵһ��!��ô�ͻ��׳��쳣
		* ProceedingJoinPoint �� һЩ����
			Object[] getArgs
				����Ŀ�귽���Ĳ���
			Signature getSignature
				����Ŀ�귽����ǩ��
			Object getTarget
				���ر�֯����ǿ�����Ŀ�����
			Object getThis
				����AOP���ΪĿ��������ɵĴ������
			Class[] parameterTypes = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
				�������ط�����'����������'.

* ����Ȼ,��Щ��ν��'֪ͨ',������@Aspect���е�!�������.....��Ҳ��֪��,û�Թ�!��������
* �ٴζ�ͨ����������������,�Ƚ���Ҫ
	> ������ʾ��һ��ͨ���,��ʵ�ܶ�ط���֧��ͨ���
	@Before("execution(* com.kevin.*.*(..))")
	* ����,�������:�������η�,���ⷵ��ֵ,ָ�����µ�����������ⷽ��,����������ķ���ǩ��...
	* �����Ƚ����,�Լ����Ű�!
* һ������(��),�������ö��֪ͨ
* һ��Ŀ�귽�������ͬ���͵�'֪ͨ'ָ��!����ִ��!ִ��˳��?û�о���!
* ��ʵ����һ������֪ͨ(�Ͳ�����,����ʹ��)
	> ����֪ͨ��һ�������֪ͨ����,��ͨ��Ϊ�ӿ��ṩʵ����!�������̬��ʵ�ֽӿ�,��������Ѿ�������ʱ��չ��ʵ����һ��!


��:�����е���ʽ
		> ��ʵ�ܼ�,������!
		> ���������кܶ�֪ͨ�㶼������,���ǵ�value���Ժܶ඼��һ����(�����ȫ��һ����)!һ������(��)��������֪ͨ(���� )��valueֵ��ͬ!���ǿ���������
			1,�ڵ�ǰ����(��)�д���һ������(��ʱ��Ϊ:��ݷ���),��Ҫд�κε��߼�����,���һ��ע��.������
				@Pointcut(value="�ܳ���һ����ָ���ķ���")
				public void demo(){}			//û��Ҫд�κ��߼�����,�������Ϊ�˼�ע�����������
			2,�Ϳ��԰�,�ڱ�����(��)���κε�֪ͨ(����)��,��value�����޸�Ϊ"demo()"
				@Before("demo()")				//��ʱ��Ͳ�����д��ô����ָ��������,ֱ��д����ķ�������
				public void beforeMethod(JoinPoint join)
		> ����Ϊ����?No,����ľ���,�䣡������(����)��Ҳ���ɣ��ԣ��ã�
			@Before("�����˿�ݷ�������.��ݷ���()")				//��ʱ��Ϳ���ʹ���������еĿ�ݷ���,��Ȼ,���'̫Զ',�ҹ���Ҫ�Ӱ���,��û�Թ�.������
			public void beforeMethod(JoinPoint join) 

��,��ν�����ӵ�
	> ��ʵ���ǿ�����'��ǿ����'(֪ͨ),�л�ȡĿ�귽������ʱ���ݵĲ���,�Լ�Ŀ�귽���ķ������Ƶ�һ������
	> ��ʵ�ܼ�,ֻ��Ҫ��'��ǿ����',Ҳ���Ǳ�'֪ͨ'ע���ʶ�ķ��������һ������:JoinPoint���͵Ĳ���,ͨ���������Ϳ��Ի�ȡ��Ŀ�귽���Ĳ���,��������
	ʾ������:
	@֪ͨע��(.....)//֪ͨ��
	public void advice(JoinPoint join)
	{
		String methodName = join.getSignature().getName();//��ȡĿ�귽��������
		LObject[] params = join.getArgs();//��ȡĿ�귽���Ĳ���
	}
	
������������������������������������������������
��,��������ȼ�			|
������������������������������������������������
	> ����,����һ������,��Ҳ�˽���!
	> ���һ��Ŀ�귽��,�����˶������,���涼�ж�������ͬ���Ե�֪ͨ(����)!˭��ǰ?˭�ں�?
	> ָ����������ȼ��ܼ�
	* ��������,�ټ���һ��ע��
	@Order(1)
	> ֵԽС,���ȼ�Խ��!
	> ������С��,����ʹ����


������������������������������������������������
��,����xml���õķ�ʽ	|
������������������������������������������������
	> ����ʹ��AspectJע����������,SpringҲ֧����Bean�����ļ�����������,��������ʽͨ��aop schema�е�xmlԪ����ɵ�
	> ���������:����ע�������Ҫ�����ڻ���xml������
	> ͨ��Aspectjע��,���������Aspectj����,������xml����������Springר�е�,����Aspectj�õ�Խ��Խ���Aop���֧��,����ע�����д�����潫���и������õĻ���
	> ������,����ͨBeanһ�������ø�ʽ,������xml��...Ȼ��,������

<!-- ����AOP -->
<aop:config>
	<!-- �����е���ʽ -->	<!--�ⶫ����,����Ŀ�귽��,���Դ��ڶ��,����ͬ��Ҳ֧��ͨ���-->
	<aop:pointcut expression="execution(public int com.kevin.aop.byxml.ArithmeticCalculator.add(int, int))" id="pointcut"/>
	<!-- ���������� -->	<!-- ����һ����,ref������bean��ǩ��idֵ,����order,�������ȼ��� -->
	<aop:aspect ref="aspect1" order="1">	<!-- ������ҲҪ��xml������ͨbean����ʽע��,Ȼ������refָ����id��OK -->
		<!-- ����ǰ��֪ͨ -->
		<aop:before method="beforeMethod" pointcut-ref="pointcut"/>	<!--pointcut-ref�����������,Ŀ�귽��!ĳ��aop:pointcut��idֵ  -->
		<!-- ���ú���֪ͨ -->
		<aop:after method="afterMethdo" pointcut-ref="pointcut"/>
		<!-- ���÷���֪ͨ -->
		<aop:after-returning method="atferReturn" pointcut-ref="pointcut" returning="result"/>	<!--returning����method�����д�����ֵ(Object)�Ĳ�����,���xml�����õ����Ƹ������е����Ʋ���ͬ,�׳��쳣  -->
		<!-- �����쳣֪ͨ -->
		<aop:after-throwing method="exce" pointcut-ref="pointcut" throwing="ex"/>	<!-- throwing,����menth�������쳣�����ı�����,�����һ��,���׳��쳣 -->
		<!-- ���û���֪ͨ -->			
		<aop:around method="around" pointcut-ref="pointcut"/>	<!-- ����֪ͨ,�õú���,���������� -->
	</aop:aspect>
	<!-- ���������� --><!-- ������һ����,ͬ������,Ҳ������˵,aop:config����������ö�������� -->
	<aop:aspect ref="aspect2" order="2">
		<aop:before method="befero" pointcut-ref="pointcut"/>
		<aop:after method="after" pointcut-ref="pointcut"/>
	</aop:aspect>
</aop:config>

	> �ṹ����
		<aop:fonfig>
			|--�����Ƕ��Ŀ�귽��
			|--�����Ƕ��������
				|--����ʹ���֪ͨ����
		</aop:fonfig>
	['ע��']
		�Բ�,��������ô���Ҫ��������!
		aspect �еĵ��е�,�ᰴ�մ��ϵ��µ�˳����ִ��,����ô��������Ҳ����!����,��������ģ�
		
������������������������������������������������
��,ֵ��ע�������		|
������������������������������������������������
1,�����Ǹ� Spectj���ʽ	
	> ��֪ͨ��ͨ��value���Զ����е�(Spectj���ʽ)
	ͨ��execution����,���Զ����е�ķ�������
	�﷨
		execution(<�������η�>��·��<��������><������>(<����>)<�쳣>)
	����
		ƥ���������public����
			execution(public * *(..))
		ƥ��ָ�����������෽��
			execution(* com.kevin.*(..))	//ֻ����Kevin���µ���
			execution(* com.kevin..*(..))	//����Kevin���µ���,���������Ӱ�����
		ƥ��ָ�������з���
			execution(* com.kevin.action.*(..))
		ƥ������save��ͷ�ķ���
			execution(*save*(..))
		ƥ��ָ�����͵�����
			... ...
		ƥ�������ָ��ע��ķ���
			@annotation(xxxxx....Permission)
	
2,����Advisor �� Aspect ������
	Advisor:Spring ��ͳ�����ϵ�����:֧��1���е��һ��֪ͨ�����
		* �̳�ָ���Ľӿ�,�������'ָ����֪ͨ'!�̳���������ڷ���ǰ��,�̳��Ǹ������ڷ�������.һ���.
		* ��Ҫ��xml������,��Ҫ�����Լ�ȥ���̳�,���Ǻܴ�ͳ�Ķ���,һ�������!

	ASPECT :����֧�ֶ���е�Ͷ��֪ͨ�����
		* һ����,���Զ���������.��Ȼ,��4����ʼǽ�����Щ������!
������������������������������������������������
��,�߼�֪ʶ				|
������������������������������������������������
	# AOP�л�ȡ����ķ�������

	private void beforeTransationHandle(JoinPoint point) throws Exception{
		//���ص�ʵ�����
		Object target = point.getTarget();
		//���صķ�������
		String methodName = point.getSignature().getName();
		//���صķ�������
		Object[] args = point.getArgs();
		//���صķ�����������
		Class[] parameterTypes = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
		//��ȡ����Ŀ�귽��
		Method method = null;
		try {
			//ͨ�����������ص�method
			method = target.getClass().getMethod(methodName, parameterTypes);
			//���������Ҫ���ʵ�����ص�method
			if(method.isBridge()){
				for(int i = 0; i < args.length; i++){
					//��÷�������
					Class genClazz = getSuperClassGenricType(target.getClass(),0);
					//����ʵ�ʲ��������滻parameterType�е�����
					if(args[i].getClass().isAssignableFrom(genClazz)){
						parameterTypes[i] = genClazz;
					}
				}
				//���parameterType�������͵ķ���
				method = target.getClass().getMethod(methodName, parameterTypes);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	public Class getSuperClassGenricType(Class clazz, int index) {
			Type genType = clazz.getGenericSuperclass();        // �õ����͸���
			if (!(genType instanceof ParameterizedType)) {
				return Object.class;
			}
			Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
			if (!(params[index] instanceof Class)) {
				return Object.class;
			}
			return (Class) params[index];
		}


������������������������������������������������
��,�е���ʽ			|
������������������������������������������������
	
	# ָ���������
		within(com.tedi.zhsq.common.base.BaseService+)
			* expression="within(com.tedi.zhsq.common.base.BaseService+)"

			* ָ���༰������е�����ķ���,����ִ��
			* ����������ӿڿ�������Ŀ,�ҳ������ BaseService,AbstractService ����Ŀ
						BaseService(�߼�����)
							|
							|
					 ---------------
					|				|
					(ʵ��)			(�̳�)
				AbstractService	  UserService
					|				|
					|				|
					|			(����ʵ��)
					 -------- UserServiceImpl
		
	
	# ָ��������
		execution(* com.tedi.community.web.service..*(..))
			* ָ������('���༶�Ӱ�')������������з���.
			* ���԰�'Base'ϵ�еĳ�����,��д�� service.base����,����̳к�,���෽��Ҳ����AOP
		
		execution(* com.tedi.community.web.service.*.*(..))
			* ָ������('�����Ӱ�')������������з���.
		

		

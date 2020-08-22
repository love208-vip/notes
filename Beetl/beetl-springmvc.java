----------------------------
Beetl-Spring MVC �򵥼���	|
----------------------------
	1,��� spring ����
		<bean id="beetlConfig" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init"/>

		<bean id="viewResolver" class="org.beetl.ext.spring.BeetlSpringViewResolver">
				<property name="contentType" value="text/html;charset=UTF-8"/>
				<property name="suffix" value=".html"/>
		</bean>
		
		* beetl������������ͼ��������preffix��ָ��Ŀ¼,����ͨ��classpath�µ�.beetl.properties,�п��ܵ���Layout�����޷�ʹ��
		* suffix ���������� ��ͼ��������,�ް�
		* ͬ�������ɷ�ʽһ����ģ������ý�����beetl.properties�С�
		* ��ȡ GroupTemplate
			BeetlGroupUtilConfiguration config = (BeetlGroupUtilConfiguration) this.getApplicationContext().getBean("beetlConfig");
			GroupTemplate group = config.getGroupTemplate();

	2,���properties����
		RESOURCE.root=/WEB-INF/templates/
	
	3,Controller
		ModelAndView modelAndView = new ModelAndView("index/index");
        return modelAndView;

----------------------------
Beetl-Spring MVC �߼�����	|
----------------------------
	* spring���ɻ�����ע�ᱻspring���������Function��Tag�ȣ�Ҳ���������ö����ͼ�������ȹ���
		<bean name="beetlConfig" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init">
			<!--- �����ļ���ַ -->
			<property name="configFileResource" value="/WEB-INF/beetl.properties"/>

			<!-- functions -->
			<property name="functions">
				<map>
					<entry key="testFunction" value-ref="testFunction"/>
				</map>
			</property>
			<property name="functionPackages">
				<map>
					<entry key="fp" value-ref="testFunctionPackage"/>
				</map>
			</property>
			
			<!-- tags -->
			<property name="tagFactorys">
				<map>
					<entry key="html.output" value-ref="testTagFactory"/>
					<entry key="html.output2" value-ref="testTagFactory2"/>
				</map>
			</property>
		</bean>

		<bean name="testTagFactory" class="org.beetl.ext.spring.SpringBeanTagFactory">
			<property name="name" value="testTag"/>
		</bean>
		<bean name="testTagFactory2" class="org.beetl.ext.spring.SpringBeanTagFactory">
			<property name="name" value="testTag2"/>
		</bean>


		<bean name="beetlViewResolver" class="org.beetl.ext.spring.BeetlSpringViewResolver">
			<!-- ���ϵͳ���ж�� BeetlGroupUtilConfiguration ����Ҫ��ʾ��ָ������һ�� -->
			<property name="config" ref="beetlConfig"/>
			<property name="contentType" value="text/html;charset=UTF-8"/>
		</bean>
	
		# BeetlGroupUtilConfiguration �������

		configFileResource 
			# ����ָ���������ļ�����·���������ָ������Ĭ����classpath��

		functions 
			# ָ���˱�spring���������function��keyΪע��ķ�������value-ref ָ����bean������

		functionPackages
			# ָ���˱�spring���������functionPackage��keyΪע��ķ���������value-ref ָ����bean������

		tagFactorys 
			# ע��tag��
			# 'key��tag�������,Ҳ������ģ����ʹ�õı�ǩ��'
			# value-refָ��һ��org.beetl.ext.spring.SpringBeanTagFactoryʵ����
			# ��ʵ����һ��Spring�����Bean����һ��name����.'����name��Ӧ��bean����tag��'��
			# ��Ҫע�⣬����Tag����״̬�ģ���ˣ���������ScopeΪ "prototype"�������:
				@Service
				@Scope("prototype")
				public class TestTag extends Tag {

				}
		
		typeFormats
			# ͬfunctions�������� Map, Format>������keyΪ����Class

		formats
			# ͬfunctions�������� Map������keyΪ��ʽ��������

		virtualClassAttributes
			# ͬfunctions������Map, VirtualClassAttribute>������keyΪ����Class
			# ���õľ���ָ�������������

		virtualAttributeEvals 
			# ����ΪList,���õ���'һЩ�����������'

		resourceLoader
			# ��Դ������ ��ֵ�� ʵ��ResourceLoader��һ��Bean

		errorHandler 
			# ������ֵ��ʵ��ErrorHandler��һ��Bean

		sharedVars
			# ͬ functions ��������Map�������ڴ����ù������

		configProperties
			# ������Properties�����Ը��������ļ���ĳЩ����


--------------------------------
Beetl-Spring MVC �����ͼ������	|
--------------------------------
	1,servlet.xml����	
		<bean id="beetlConfig" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init"/>
		<!-- beetl -->
		<bean id="viewResolver" class="org.beetl.ext.spring.BeetlSpringViewResolver">
			<property name="viewNames">
				<list>
					<value>/templates/***/</value>
				</list>
			</property>
			<property name="config" ref="beetlConfig"/>
			<property name="contentType" value="text/html;charset=UTF-8"/>
			<property name="suffix" value=".html"/>
			<property name="order" value="0"/>
		</bean>
		
		<!-- jsp -->
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/WEB-INF/views/"/>
			<property name="suffix" value=".jsp"/>
			<property name="order" value="256"/>
		</bean>
	
	2,Controller
		@RequestMapping(value = "test",method = RequestMethod.GET)
		@Auth(required = false)
		public ModelAndView modelAndView(){
			return new ModelAndView("/templates/test/test");
		}
	3,beetl.properties
		RESOURCE.root=/WEB-INF/
	
	4,Ŀ¼�ṹ
		
		WEB-INF
			|-templates		
				|-test
					|-test.html
			|-views
				|-..

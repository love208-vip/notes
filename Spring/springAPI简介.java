������������������������������������������������
һ,IOC����ʵ��			|
������������������������������������������������
��ȡBean����,����Beanʵ��֮ǰ,�����IOC��������ʵ�����ſ��Դ�IOC���������ȡBeanʵ��ʹ��
Spring�ṩ���������͵�IOC����ʵ��
1,BeanFactory
	* ICO�����Ļ���ʵ��
	* ��Spring��ܵĻ�����ʩ,����Spring����
2,ApplicationContext
	* �ṩ�˸���ĸ߼�����,��BeanFactory���ӽӿ�
	* ����ʹ��Spring��ܵĿ�����'�������е�Ӧ�ó���,��ֱ��ʹ��ApplicationContext,���ǵײ��BeanFactory'
> �������������ַ�ʽ,�����ļ�������ͬ��


������������������������������������������������
��,ApplicationContext	|
������������������������������������������������
> ������Ȼ��һ���ӿ�,����IOC����,������ʼ��������ʱ,��ʵ��������'������Bean'
================����Ҫ��ʵ���ࡿ
ConfigurableApplicationContext[interface]
	* ��չ��ApplicationContext,����������Ҫ�ķ���
	* ����Ƕ�����һ���ӿ�,ֻ�Ǹ�ǿ��.
		> refresh();//��������ˢ��������
		> close();//�ر�������
ClassPathXmlApplicationContext
	* ����·���¼��������ļ�
	* ����ͬʱ���ض�������ļ�
		new ClassPathXmlApplicationContext("beans1.xml","beans2.xml");
FileSystemXmlApplicationContext
	* ���ļ�ϵͳ���������ļ�
WebApplicationContext
	* ��ר��ΪWEBӦ�ö�׼����,������������WEB��Ŀ¼��·������ɳ�ʼ������
================����Ҫ�ķ�����
* һЩ�Ǽ̳���BeanFactory���ӿڵķ���
Object		getBean(String);
				|--���������ļ���,ָ��id���Ե�Bean,����һ��Object!��Ҫ�Լ��ֶ�ǿת
<T>			getBean(String,Class<T>);
				|--����Bean��Class����,����ָ����id����.�����ָ��,��xml���ж��ͬ�����͵�Bean����,'�׳��쳣'!
<T>			getBean(Class<T>);
				|--ֱ�Ӹ���Bean��������,�Զ�ȥxml�н���ƥ��!Ҫע�����,����Ҫ��֤xmlֻ��һ��ָ�����͵�Bean���ô���.����ж���ͻ��׳��쳣!
Object		getBean(String,Object);
				
String		getId();
String		getApplicationName();
String		getDisplayName();
long		getStartupDate();
			getParent();
			getAutowireCapableBeanFactory();
boolean		containsBean(String);
boolean		isSingleton(String);
boolean		isPrototype(String);
boolean		siTypeMatch(String,Class<?>);
Class<?>	getType(String);
String[]	getAliases(String);
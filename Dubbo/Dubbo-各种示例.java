--------------------------------
1,�������						|
--------------------------------
	# Dubbo'ȱʡ��������ʱ��������ķ����Ƿ����'��������ʱ���׳��쳣����ֹSpring��ʼ����ɣ��Ա�����ʱ���ܼ��緢�����⣬Ĭ��check=true��
	# �ر�һ�����������ʱ���(û���ṩ�߱���)
		<dubbo:reference check="false" />

	# �ر����з��������ʱ���(û���ṩ��ʱ����)
		<dubbo:consumer check="false" />

	# �ر�ע����������ʱ���(ע�ᶩ��ʧ��ʱ����)
		<dubbo:registry check="false" />

	# ����ȱʡ���ӳٳ�ʼ���ģ�ֻ�����ñ�ע�뵽����Bean����getBean()��ȡ���Ż��ʼ����
		* �����Ҫ�������أ���û��������Ҳ�������ɶ�̬�����������ã�
			<dubbo:reference init="true" />
		* init=true  :�����������û�б�ע�뵽������bean��,������û�б�getBean��ȡ,����ִ�г�ʼ��
		* init=false :�����������,ֻ�б�ע�뵽������bean��,�����Ǳ�getBean��ȡ,�Ż��ʼ��

	# dubbo.properties ����
		dubbo.reference.com.foo.BarService.check=false
		dubbo.reference.check=false
		dubbo.consumer.check=false
		dubbo.registry.check=false

	# JVM�������� ����
		java -Ddubbo.reference.com.foo.BarService.check=false
		java -Ddubbo.reference.check=false
		java -Ddubbo.consumer.check=false 
		java -Ddubbo.registry.check=false
					
	# ע��
		dubbo.reference.check=false��ǿ�Ƹı�����reference��checkֵ��������������������Ҳ�ᱻ���ǡ�
		dubbo.consumer.check=false��������check��ȱʡֵ���������������ʽ���������磺<dubbo:reference check="true"/>��������Ӱ�졣
		dubbo.registry.check=false��ǰ����������ָ���ĳɹ������ṩ���б��Ƿ�Ϊ���Ƿ񱨴����ע�ᶩ��ʧ��ʱ��Ҳ������������ʹ�ô�ѡ����ں�̨��ʱ

--------------------------------
2,��Ⱥ�ݴ�						|
--------------------------------
	# �ṩ������
		* ȫ�ִ���������
			<dubbo:provider cluster="failover"/>	
		* ������������
			<dubbo:service cluster="failover"/>
		* ��ȷ������
			<dubbo:service>
				<dubbo:method name="getUser" retries="2"></dubbo:method>
			</dubbo:service>

	# ����������
		* ȫ�ִ����ȿ���
			<dubbo:consumer cluster="failover"/>		
		* �����ӿڿ���
			<dubbo:reference cluster="failover"/>
		* ϸ���ȵ�����
			<dubbo:reference>
				<dubbo:method name="getUser" retries="2"></dubbo:method>
			</dubbo:reference>

	# ��ѡ�ݴ�����
		failover 
			* ʧ���Զ��л���������ʧ�ܣ�����������������('ȱʡ')
			* ͨ�����ڶ������������Ի���������ӳ١�
			* ��ͨ�� retries="2" ���������Դ���(������һ��)�������ֵ = 0,��ô����������.����ʧ��,ֱ���׳��쳣

		failfast 
			* ����ʧ�ܣ�ֻ����һ�ε��ã�ʧ����������
			* ͨ�����ڷ��ݵ��Ե�д����������������¼��

		failsafe 
			* ʧ�ܰ�ȫ�������쳣ʱ��ֱ�Ӻ��ԡ�
			* ͨ������д�������־�Ȳ�����

		failback 
			* ʧ���Զ��ָ�����̨��¼ʧ�����󣬶�ʱ�ط���
			* ͨ��������Ϣ֪ͨ������

		forking 
			* ���е��ö����������ֻҪһ���ɹ������ء�
			* ͨ������ʵʱ��Ҫ��ϸߵĶ�����������Ҫ�˷Ѹ��������Դ��
			* ��ͨ�� forks="2" ���������������

		broadcast 
			* �㲥���������ṩ�ߣ�������ã�����һ̨�����򱨴�(2.1.0��ʼ֧��)
			* ͨ������֪ͨ�����ṩ�߸��»������־�ȱ�����Դ��Ϣ��
		

--------------------------------
3,���ؾ���						|
--------------------------------
	# Dubboָ����N�ฺ�ؾ������
		random (Ĭ��)
			* �������Ȩ������������ʡ�
			* ��һ����������ײ�ĸ��ʸߣ���������Խ��ֲ�Խ���ȣ����Ұ�����ʹ��Ȩ�غ�Ҳ�ȽϾ��ȣ������ڶ�̬�����ṩ��Ȩ�ء�
			* Ȩ���������� : weight

		roundRobin 
			* ��ѭ������Լ���Ȩ��������ѭ���ʡ�
			* ���������ṩ���ۻ��������⣬���磺�ڶ�̨������������û�ң�����������ڶ�̨ʱ�Ϳ����ǣ��ö���֮���������󶼿��ڵ����ڶ�̨�ϡ�
	
		leastActive 
			* ���ٻ�Ծ����������ͬ��Ծ�����������Ծ��ָ����ǰ������
			* ʹ�����ṩ���յ�����������ΪԽ�����ṩ�ߵĵ���ǰ��������Խ��

		consistentHash 
			* һ����Hash����ͬ�������������Ƿ���ͬһ�ṩ�ߡ�
			* ��ĳһ̨�ṩ�߹�ʱ��ԭ���������ṩ�ߵ����󣬻�������ڵ㣬ƽ̯�������ṩ�ߣ�����������ұ䶯��
			* �㷨�μ���http://en.wikipedia.org/wiki/Consistent_hashing��
			* ȱʡֻ�Ե�һ������Hash�����Ҫ�޸ģ�������	<dubbo:parameter key="hash.arguments" value="0,1" />
			* ȱʡ��160������ڵ㣬���Ҫ�޸ģ�������		<dubbo:parameter key="hash.nodes" value="320" />
	
	# ����������
		* ȫ�ָ��ؾ������
			<dubbo:provider loadbalance="random" weight="5"/>
		* ���񼶱��ؾ������
			<dubbo:service loadbalance="random" weight="5"/>
		* ���������ؾ������
			<dubbo:service >
				<dubbo:method loadbalance="random" weight="5"/>
			</dubbo:service>

	# ����������
		* ȫ�ָ��ؾ������
			<dubbo:consumer loadbalance="random"/>
		* ���񼶱��ؾ������
			<dubbo:reference loadbalance="random"/>
		* ���������ؾ������
			<dubbo:reference>
				<dubbo:method loadbalance="random"/>
			</dubbo:reference>
	
	# ���ؾ�����Կ����Զ���,Dubbo���ṩ�ӿ�,�Լ�ȥ���ĵ���

--------------------------------
4,�߳�ģ��						|
--------------------------------

	# �¼������߳�˵��
		* ����¼�������߼���Ѹ����ɣ����Ҳ��ᷢ���µ�IO���󣬱���ֻ�����ڴ��мǸ���ʶ����ֱ����IO�߳��ϴ�����죬��Ϊ�������̳߳ص��ȡ�
		* ͨ�����:������յ���������,�ܿ���ִ����,���Һ���û������.��,���Լ��㶨,���������̻߳������̳߳�

		* ������¼������߼�������������Ҫ�����µ�IO���󣬱�����Ҫ��ѯ���ݿ⣬������ɷ����̳߳أ�����IO�߳������������²��ܽ�����������
		* ͨ�����:������յ���������,Ҫִ�кܾ�,����Ҫ�����������̳߳�ִ����,��Ȼ�ҽ���ִ�еĻ�.�Ͳ���ִ��������Զ�̵���������

		* �����IO�̴߳����¼��������¼���������з����µ�IO���󣬱����������¼��з����¼���󣬻ᱨ�����������������쳣����������������
		* ͨ�����:�Լ����... ...

	# dispatcher
		all		
			* ������Ϣ���ɷ����̳߳أ�����������Ӧ�������¼����Ͽ��¼��������ȡ�
		direct	
			* ������Ϣ�����ɷ����̳߳أ�ȫ����IO�߳���ֱ��ִ�С�
		message	
			* ֻ��������Ӧ��Ϣ�ɷ����̳߳أ��������ӶϿ��¼�����������Ϣ��ֱ����IO�߳���ִ�С�
		execution 
			* ֻ������Ϣ�ɷ����̳߳أ�������Ӧ����Ӧ���������ӶϿ��¼�����������Ϣ��ֱ����IO�߳���ִ�С�
		connection 
			* ��IO�߳��ϣ������ӶϿ��¼�������У��������ִ�У�������Ϣ�ɷ����̳߳ء�
	
	# threadpool
		fixed 
			* �̶���С�̳߳أ�����ʱ�����̣߳����رգ�һֱ���С�(ȱʡ)
		cached 
			* �����̳߳أ�����һ�����Զ�ɾ������Ҫʱ�ؽ���
		limited 
			* �������̳߳أ������е��߳���ֻ����������������(Ϊ��������ʱͻȻ���˴������������������)��

	# ������Ϣ
		<dubbo:protocol name="dubbo" 
			dispatcher="all" 
			threadpool="fixed" 
			threads="100" />
		
		<dubbo:provider 
			threadpool="fixed" 
			threads="100"/>

--------------------------------
5,ֱ���ṩ��					|
--------------------------------
	# �ƹ�ע������,ֱ�����ӷ����ṩ��.����Ȼ,�����ڲ��Ի���������

	# ������������,����urlָ���ṩ�ߣ����ƹ�ע�����ģ������ַ�÷ֺŸ������������£�(1.0.6�����ϰ汾֧��)
		<dubbo:reference id="xxxService" interface="com.alibaba.xxx.XxxService" url="dubbo://localhost:20890" />
	
	# Ҳ������properties��ͨ��java -D��������������,���鿴API

--------------------------------
6,ֻ����						|
--------------------------------
	# Ϊ���㿪�����ԣ������������¹���һ�����з�����õ�ע�����ģ���ʱ�����һ�����ڿ����еķ����ṩ��ע�ᣬ���ܻ�Ӱ�������߲����������С�

	# �����÷����ṩ�߿�������ֻ���ķ���(�����ķ������������������)������ע�����ڿ����ķ���ͨ��ֱ���������ڿ����ķ���

	# Dubbo��һ������,������ע������,���ĵ������ķ���.����,�Լ������������.�����Ҫ����,ֱ����ʽ,�����ñ�����
		<dubbo:registry address="10.20.153.10:9090" register="false" />
		<dubbo:registry address="10.20.153.10:9090?register=false" />
	
	# ��ģʽ,ָ������Ҫ���������Եķ����ṩ��,������ע�����Ķ����Լ���Ҫ�ķ���.������ע������ע���Լ���������ṩ�ķ���
	# ��ģʽ,��Ҫ���"ֱ���ṩ��"����,�����е���


--------------------------------
7,ֻע��						|
--------------------------------
	# ������������񻷾�������ע�����ģ���һ������ֻ������һ��ע�������в�����һ��ע�����Ļ�û���ü����𣬶�����ע�����ĵ�����Ӧ�ö���Ҫ�����˷���������Ҫ������ͬʱע�ᵽ����ע�����ģ���ȴ�����ô˷���ͬʱ��������ע�����ĵ���������
	# �����÷����ṩ�߷���ֻע�������һע�����ģ���������һע�����Ķ��ķ���
	# ���ö������ã�
		<dubbo:registry id="hzRegistry" address="10.20.153.10:9090" />
		<dubbo:registry id="qdRegistry" address="10.20.141.150:9090" subscribe="false" />

		<dubbo:registry id="hzRegistry" address="10.20.153.10:9090" />
		<dubbo:registry id="qdRegistry" address="10.20.141.150:9090?subscribe=false" />
	
	# ˵���˾���,�ұ���,����ע�ᵽĳһ��ע������,�ṩ����.�����ұ��������ķ���,���ܻ�����ע�����Ļ�ȡ


--------------------------------
8,��̬����						|
--------------------------------
--------------------------------
9,��Э��						|
--------------------------------
	# ��ͬ�ķ���,�����������ò�ͬ��Э��������,����������ö�����Э�飬С���ݴ󲢷��ó�����Э�顣
	# ���������
		<dubbo:application name="world"  />
		<dubbo:registry id="registry" address="10.20.141.150:9090" username="admin" password="hello1234" />
		<!-- ��Э������ -->
		<dubbo:protocol name="dubbo" port="20880" />
		<dubbo:protocol name="rmi" port="1099" />
		<!-- ʹ��dubboЭ�鱩¶���� -->
		<dubbo:service interface="com.alibaba.hello.api.HelloService" version="1.0.0" ref="demoService" protocol="dubbo" />
		<!-- ʹ��rmiЭ�鱩¶���� -->
		<dubbo:service interface="com.alibaba.hello.api.HelloService" version="1.0.0" ref="demoService" protocol="rmi" />
		<!-- ʹ�ö��Э�鱩¶����(��¶��ͬһ������,��ͬЭ���N������) -->
		<dubbo:service interface="com.alibaba.hello.api.HelloService" version="1.0.0" ref="demoService" protocol="dubbo,hessian" />

	
	# ���Ѷ�����
		* <dubbo:reference protocol="dubbo"/>		
		* 'ֻ����ָ��Э��ķ����ṩ��������Э����ԡ�'
	

--------------------------------
10,��ע������					|
--------------------------------
	# һ������,ע�ᵽ���ע������
		<!-- ��ע���������� -->
		<dubbo:registry id="hangzhouRegistry" address="10.20.141.150:9090" />
		<dubbo:registry id="qingdaoRegistry" address="10.20.141.151:9010" default="false" />
		<!-- ����ע������ע�� -->
		<dubbo:service interface="com.alibaba.hello.api.HelloService" version="1.0.0" ref="helloService" registry="hangzhouRegistry,qingdaoRegistry" />

	# �������,ע�ᵽ���ע������
		<!-- ��ע���������� -->
		<dubbo:registry id="chinaRegistry" address="10.20.141.150:9090" />
		<dubbo:registry id="intlRegistry" address="10.20.154.177:9010" default="false" />
		<!-- ������վע������ע�� -->
		<dubbo:service interface="com.alibaba.hello.api.HelloService" version="1.0.0" ref="helloService" registry="chinaRegistry" />
		<!-- �����վע������ע�� -->
		<dubbo:service interface="com.alibaba.hello.api.DemoService" version="1.0.0" ref="demoService" registry="intlRegistry" />
	
	# ���Ѷ�����
		<!-- ��ע���������� -->
		<dubbo:registry id="chinaRegistry" address="10.20.141.150:9090" />
		<dubbo:registry id="intlRegistry" address="10.20.154.177:9010" default="false" />
		<!-- ��������վ���� -->
		<dubbo:reference id="chinaHelloService" interface="com.alibaba.hello.api.HelloService" version="1.0.0" registry="chinaRegistry" />
		<!-- ���ù���վվ���� -->
		<dubbo:reference id="intlHelloService" interface="com.alibaba.hello.api.HelloService" version="1.0.0" registry="intlRegistry" />

--------------------------------
11,�������						|
--------------------------------
	# �����ṩ��,һ���ӿ���N��ʵ��.������group����
		<dubbo:service group="feedback" interface="com.xxx.IndexService" />
		<dubbo:service group="member"   interface="com.xxx.IndexService" />
	
	# ���Ѷ˵���
		<dubbo:reference id="feedbackIndexService" group="feedback" interface="com.xxx.IndexService" />
		<dubbo:reference id="memberIndexService"   group="member"   interface="com.xxx.IndexService" />
	
		<!-- �����飺(2.2.0���ϰ汾֧�֣�����ֻ��һ���������ʵ��) -->
		<dubbo:reference id="barService" interface="com.foo.BarService" group="*" />
		
--------------------------------
12,��汾						|
--------------------------------
	# ��һ���ӿ�ʵ�֣����ֲ���������ʱ�������ð汾�Ź��ɣ��汾�Ų�ͬ�ķ����໥�䲻���á�
	# �ڵ�ѹ��ʱ��Σ�������һ���ṩ��Ϊ�°汾
	# �ٽ���������������Ϊ�°汾
	# Ȼ��ʣ�µ�һ���ṩ������Ϊ�°汾
	# �ṩ������
		<dubbo:service interface="com.foo.BarService" version="1.0.0" />
		<dubbo:service interface="com.foo.BarService" version="2.0.0" />
	# ����������
		<dubbo:reference id="barService" interface="com.foo.BarService" version="1.0.0" />
		<dubbo:reference id="barService" interface="com.foo.BarService" version="2.0.0" />

	# �����ְ汾��(2.2.0���ϰ汾֧��)
		<dubbo:reference id="barService" interface="com.foo.BarService" version="*" />

--------------------------------
13,����ۺ�						|
--------------------------------
--------------------------------
14,������֤						|
--------------------------------
--------------------------------
15,�������						|
--------------------------------
--------------------------------
16,��������						|
--------------------------------
--------------------------------
17,����ʵ��						|
--------------------------------
--------------------------------
18,��������						|
--------------------------------
--------------------------------
19,��������Ϣ					|
--------------------------------
--------------------------------
20,��ʽ����						|
--------------------------------
--------------------------------
21,�첽����						|
--------------------------------
--------------------------------
22,���ص���						|
--------------------------------
--------------------------------
23,�����ص�						|
--------------------------------
--------------------------------
24,�¼�֪ͨ						|
--------------------------------
--------------------------------
25,���ش��						|
--------------------------------
--------------------------------
26,�ӳٱ�¶						|
--------------------------------
	# �����ķ�����ҪWarmupʱ�䣬�����ʼ�����棬�ȴ������Դ��λ�ȣ�����ʹ��delay�����ӳٱ�¶��

	# �ӳ�5�뱩¶����
		<dubbo:service delay="5000" />

	# �ӳٵ�Spring��ʼ����ɺ��ٱ�¶����(����Spring��ContextRefreshedEvent�¼�������¶)
		<dubbo:service delay="-1" />


--------------------------------
27,��������						|
--------------------------------
	# ���Ʒ����ĳ�����񲢷�ִ����(ռ���̳߳���)
		<dubbo:service interface="com.foo.BarService" executes="10" />
	
	# ���Ʒ����ĳ������������(ռ���̳߳���)
		<dubbo:service interface="com.foo.BarService">
			<dubbo:method name="sayHello" executes="10" />
		</dubbo:service>
	

	# ����ĳ������,ÿ���ͻ��˵���󲢷�(ռ�����ӵ�������)
		* ���������
			<dubbo:service interface="com.foo.BarService" actives="10" />
		* ���Ѷ�����
			<dubbo:reference interface="com.foo.BarService" actives="10" />
	
	# ����ĳ�������ĳ������,�ͻ�����󲢷�(ռ�����ӵ�������)
		* ���������
			<dubbo:service interface="com.foo.BarService">
				<dubbo:method name="sayHello" actives="10" />
			</dubbo:service>
		* ���Ѷ�����
			<dubbo:reference interface="com.foo.BarService">
				<dubbo:method name="sayHello" actives="10" />
			</dubbo:service>
	
	# ���<dubbo:service>��<dubbo:reference>������actives��<dubbo:reference>����

--------------------------------
28,���ӿ���						|
--------------------------------
	# ���Ʒ���˵Ľ��յ�����,���ܳ���10��
		<dubbo:provider protocol="dubbo" accepts="10" />
		<dubbo:protocol name="dubbo" accepts="10" />

	# ���ƿͻ��˷���ʹ��������������(����ǳ����ӣ�����DubboЭ�飬connections��ʾ�÷����ÿ���ṩ�߽����ĳ�������)

		<dubbo:service interface="com.foo.BarService" connections="10" />	
		<dubbo:reference interface="com.foo.BarService" connections="10" />
	# ���<dubbo:service>��<dubbo:reference>������connections��<dubbo:reference>����
	
--------------------------------
29,�ӳ�����						|
--------------------------------
	# �ӳ����ӣ����ڼ��ٳ������������е��÷���ʱ���ٴ��������ӡ�
	# ֻ��ʹ�ó����ӵ�dubboЭ����Ч��
		<dubbo:protocol name="dubbo" lazy="true" />

--------------------------------
30,ճ������						|
--------------------------------
	# ճ������������״̬���񣬾������ÿͻ���������ͬһ�ṩ�߷�����ã����Ǹ��ṩ�߹��ˣ�������һ̨��
	# ճ�����ӽ��Զ������ӳ����ӣ��Լ��ٳ����������μ����ӳ����� (+)
		<dubbo:protocol name="dubbo" sticky="true" />

--------------------------------
31,������֤						|
--------------------------------
	# ����
		��ֹ�������ƹ�ע�����ķ����ṩ��
		��ע�����Ŀ���Ȩ�ޣ��Ծ���Ҫ��Ҫ�·����Ƹ�������
		ע�����Ŀ����ı���Ȩ��ʽ���������޸Ļ������ṩ��
	
	# ȫ�ֿ���
		<!--���token���ƣ�ʹ��UUID����-->
		<dubbo:provider interface="com.foo.BarService" token="true" />
	
	# �����ĳ��������
		<dubbo:protocol name="dubbo" token="true" />
	
	# �����Э�鼶��
		<!--���token���ƣ�ʹ��UUID����-->
		<dubbo:protocol name="dubbo" token="true" />
		<!--�̶�token���ƣ��൱������-->
		<dubbo:protocol name="dubbo" token="123456" />
	

--------------------------------
32,·�ɹ���						|
--------------------------------
--------------------------------
33,���ù���						|
--------------------------------
--------------------------------
34,���񽵼�						|
--------------------------------
--------------------------------
35,����ͣ��						|
--------------------------------
	# Dubbo��ͨ��JDK��ShutdownHook���������ͣ���ģ���������û�ʹ��"kill -9 PID"��ǿ�ƹر�ָ��ǲ���ִ������ͣ���ģ�ֻ��ͨ��"kill PID"ʱ���Ż�ִ�С�
	ԭ��
		�����ṩ��
			ֹͣʱ���ȱ��Ϊ���������������������ʱֱ�ӱ����ÿͻ�����������������
			Ȼ�󣬼���̳߳��е��߳��Ƿ��������У�����У��ȴ������߳�ִ����ɣ����ǳ�ʱ����ǿ�ƹرա�
		�������ѷ�
			ֹͣʱ�����ٷ����µĵ������������µĵ����ڿͻ��˼�����
			Ȼ�󣬼����û���������Ӧ��û�з��أ��ȴ���Ӧ���أ����ǳ�ʱ����ǿ�ƹرա�
	
	# ��������ͣ����ʱʱ�䣬ȱʡ��ʱʱ����10�룺(��ʱ��ǿ�ƹر�)
		
		<dubbo:application ...>
			<dubbo:parameter key="shutdown.timeout" value="60000" /> <!-- ��λ���� -->
		</dubbo:application>
	
	# ���ShutdownHook������Ч���������е��ã�
		ProtocolConfig.destroyAll();

--------------------------------
36,������						|
--------------------------------
	# Ĭ�ϵ�����IP����˳��
		* ͨ��LocalHost.getLocalHost()��ȡ������ַ��
		* �����127.*��loopback��ַ����ɨ�����������ȡ����IP��
	
	#��ע��ĵ�ַ�����ȡ����ȷ��������Ҫע�ṫ����ַ,���Խ��м�������

		1,�� /etc/hosts������
			test1 205.182.23.201
		
		2,��dubbo.xml������������ַ
			<dubbo:protocol host="http://10.20.160.198/wiki/display/dubbo/205.182.23.201">
		
		3,��dubbo.properties������
			dubbo.protocol.host=205.182.23.201
	
	# Ĭ�϶˿���Э��
		dubbo: 20880
		rmi: 1099
		http: 80
		hessian: 80
		webservice: 80
		memcached: 11211
		redis: 6379
	
	# �޸Ķ˿�
		1,��dubbo.xml������
			<dubbo:protocol name="dubbo" port="20880">
		
		2,��dubbo.properties������
			dubbo.protocol.dubbo.port=20880
		

--------------------------------
37,��־������					|
--------------------------------
	# Ĭ���Զ�����˳��
		log4j
		slf4j
		jcl
		jdk
	
	# ������־���������
		
		java -Ddubbo.application.logger=log4j

		dubbo.application.logger=log4j

		<dubbo:application logger="log4j" />
	
--------------------------------
38,������־						|
--------------------------------
	# ��¼ÿ�εĵ���
	# ��־����ܴ�

	<!-- ����־�������ǰӦ�õ�log4j��־ -->
	<dubbo:protocol accesslog="true" />
	
	<!--������־�����ָ���ļ�,�����Ǳ���·����->
	<dubbo:protocol accesslog="http://10.20.160.198/wiki/display/dubbo/foo/bar.log" />

--------------------------------
39,��������						|
--------------------------------
	# ��������WEB����,ֱ��ʹ��Dubbo��������Spring����
	Spring 
		�Զ�����META-INF/springĿ¼�µ�����Spring���á�
		���ã�(����java����-D��������dubbo.properties��)
		dubbo.spring.config=classpath*:META-INF/spring/*.xml ----����spring���ü���λ��																*/
	
	Jetty
		����һ����ǶJetty�����ڻ㱨״̬��
		���ã�(����java����-D��������dubbo.properties��)
		dubbo.jetty.port=8080 ----����jetty�����˿�
		dubbo.jetty.directory=/foo/bar ----���ÿ�ͨ��jettyֱ�ӷ��ʵ�Ŀ¼�����ڴ�ž�̬�ļ�
		dubbo.jetty.page=log,status,system ----������ʾ��ҳ�棬ȱʡ��������ҳ��
	
	Log4j 
		�Զ�����log4j�����ã��ڶ��������ʱ���Զ�����־�ļ������̷�Ŀ¼��
		���ã�(����java����-D��������dubbo.properties��)
		dubbo.log4j.file=/foo/bar.log ----������־�ļ�·��
		dubbo.log4j.level=WARN ----������־����
		dubbo.log4j.subdirectory=20880 ----������־��Ŀ¼�����ڶ���������������ͻ
	
	# ��������
		1,��������spring(Ĭ��)
			java com.alibaba.dubbo.container.Main
		
		2,ͨ��main��������,ָ��Ҫ���ص�����
			java com.alibaba.dubbo.container.Main spring jetty log4j
		
		3,ͨ��JVM��������ָ��
			java com.alibaba.dubbo.container.Main -Ddubbo.container=spring,jetty,log4j
		
		4,ͨ��classpath�µ�dubbo.proerties����
			dubbo.container=spring,jetty,log4j

--------------------------------
40,Reference Config����			|
--------------------------------
--------------------------------
41,�ֲ�ʽ����					|
--------------------------------
	# Dubboδʵ��

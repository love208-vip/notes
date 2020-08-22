--------------------
Dubbo-����			|
--------------------
	# ����Ͱ͵Ķ���,ҵ�������ţ�ƵĿ��
	# ����
		http://dubbo.io/
	# HTTPЭ����RPC
		HTTP
			* ������,���� -> ��Ӧ = ���¶�
		RPC
			* ������,���� -> ��Ӧ = ���Ӳ��Ͽ�,�ȴ��´��������ʹ��(���ܸ���)
	
	
	# maven 
		* �ⶫ������ spring2.5,���ڶ���4��
		<dependency>
		    <groupId>com.alibaba</groupId>
		    <artifactId>dubbo</artifactId>
		    <version>2.5.3</version>
		    <exclusions>
				<exclusion>
					<!-- �ų�����spring���� -->
					<groupId>org.springframework</groupId>
					<artifactId>spring</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	
	# spring ����Լ��ͷ
		xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
		
--------------------
Dubbo-maven��Ҫģ��	|
--------------------
	ģ��			�����ư�			

	���Ŀ��		dubbo-2.5.3				
	�������̨		dubbo-admin-2.5.3.war
	���׼������	dubbo-monitor-simple-2.5.3-assembly.tar.gz
	����ע������	dubbo-registry-simple-2.5.3-assembly.tar.gz
	ʾ���ṩ��		dubbo-demo-provider-2.5.3-assembly.tar.gz
	ʾ��������		dubbo-demo-consumer-2.5.3-assembly.tar.gz


--------------------
Dubbo-maven����dubbo|
--------------------
	# Դ�빹��
	# ���˵�б�Ҫ,�Լ��޸Ŀ��Դ��.�Ϳ���ͨ�����·������������±���ʹ��


	dubbo-dubbo-2.5.3.zip		//����Դ��(��github��ȡ)
	hessian-lite.zip			//��������
	opensesame.zip				//��������
	
	1,��ѹ dubbo-dubbo-2.5.3.zip �� workspace
	2,��ѹ hessian-lite.zip �� workspace
	3,��ѹ opensesame.zip �� workspace
	4,Eclipse maven���� hessian-lite �� opensesame
	5,��������װ�����زֿ�(install)
	6,maven ���� dubbo-dubbo-2.5.3 Դ��
	/**���ϲ���OK,�Ϳ����޸�Դ��**/
	7,ѡ��:dubbo-dubbo-2.5.3,ִ��maven ����:clean package
		* Ŀ������ձ���,�ٱ�����
		* �һ� --> runas --> maven build
		* ���� clean package
		* �ǵù�ѡ:Skip Tests,Ŀ������������
		* run
	8,���� package OK ��Ϳ��Ի�ȡ����Ӧ�Ķ���
		dubbo ���� �� workspace�� dubbo-dubbo-2.5.3 ��targetĿ¼�»�ȡ��
		dubbo �������̨ �� workspace ��  dubbo-admin �� target Ŀ¼�»�ȡ��
		dubbo ���׼������ �� workspace �� dubbo-simple �� dubbo-monitor-simple �� target Ŀ¼�»�ȡ�� tar.gz �ļ�
		dubbo ����ע������ �� workspace �� dubbo-simple �� dubbo-registry-simple �� target Ŀ¼�»�ȡ�� tar.gz �ļ�
	

--------------------
Dubbo-dubbo�ܹ�		|
--------------------
	Provider		��¶����ķ����ṩ��
	Consumer		����Զ�̷�������ѷ�
	Registry		����ע��,���ַ���ĵ�������
	Monitor			ͳ�Ʒ���ĵ��ô����͵���ʱ��ļ������
	Container		������������


--------------------
Dubbo-���ù�ϵ		|
--------------------
	1,����������������,����,���з����ṩ��
	2,�����ṩ����������ʱ��,'��ע������ע���Լ��ṩ�ķ���'
	3,������������������ʱ��,'��ע�����Ķ����Լ�����ķ���'
	4,ע�����ķ���'�����ṩ�ߵ�ַ�б�'��������,����б��.ע�����Ļ�'�Գ����ӵķ�ʽ,�ѱ���������͸�������'
	5,����������,�ӷ����ṩ�ߵ�ַ�б���,����'���ؾ����㷨',ѡһ̨�ṩ�߽��е���,'�������ʧ��,����һ̨'
	6,���������ߺ��ṩ��,���ڴ����ۼƵ��ô����͵���ʱ��,'��ʱÿ�ַ���һ��ͳ�����ݵ��������'



--------------------
Dubbo-springԼ��	|
--------------------
	# ���dubbo�����ļ�����
	# dubbo.xsd �ļ�
	# Eclipse ����
		Windows
		Preferences
		XML
		XML Catalog
		��� ADD
			Location	: �ҵ�dubbo.xsd�ļ�
			Key type	: Schema location
			Key			: http://code.alibabatech.com/schema/dubbo/dubbo.xsd
		OK

	# �����ļ���
		<beans 
			xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"  
			xsi:schemaLocation="http://code.alibabatech.com/schema/dubbo
								http://code.alibabatech.com/schema/dubbo/dubbo.xsd">
		
		* ���һ�� xmlns
			xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
		* xsi:schemaLocation �������������,����˳���ϸ�,����пո�
			http://code.alibabatech.com/schema/dubbo
			http://code.alibabatech.com/schema/dubbo/dubbo.xsd
		

--------------------
Dubbo-Ĭ�϶˿�Э��	|
--------------------
	dubbo: 20880
	rmi: 1099
	http: 80
	hessian: 80
	webservice: 80
	memcached: 11211
	redis: 6379

--------------------
Dubbo-��ǩ����		|
--------------------
	<dubbo:service/>
		* �����ṩ�߱�¶��������

	<dubbo:reference/>
		* ����������,���÷�������

	<dubbo:protocol/>
		* �����ṩ��Э������

	<dubbo:registry/>
		* ע����������

	<dubbo:monitor/>
		* �����������

	<dubbo:application/>
		* Ӧ����Ϣ����

	<dubbo:module/>
		* ģ����Ϣ����

	<dubbo:provider/>
		* �����ṩ��ȱʡֵ����

	<dubbo:consumer/>
		* ����������ȱʡֵ����

	<dubbo:method/>
		* ������������

	<dubbo:argument/>
		* ������������

	<dubbo:parameter/>
		* ѡ���������

--------------------
Dubbo-���Ƶ�		|
--------------------
��	����ʱ���(���Ѷ�����)
	* ���Ѷ˵�������������� 
		<dubbo:reference check="false" />
	* ���Ѷ����з����������
		<dubbo:consumer check="false" />
	* �ر�ע����������ʱ���
		<dubbo:registry check="false" />
		

��	��Ⱥ�ݴ�(˫������)
	* ȫ������
		<dubbo:provider cluster="failover"/>	
		<dubbo:consumer cluster="failover"/>
	* ��ȷ��������
		<dubbo:service cluster="failover"/>
		<dubbo:reference cluster="failover"/>
	* ��ȷ������
		<dubbo:service>
			<dubbo:method name="getUser" retries="2"></dubbo:method>
		</dubbo:service>
		<dubbo:reference>
			<dubbo:method name="getUser" retries="2"></dubbo:method>
		</dubbo:reference>
	* �ݴ����
		failover	:(Ĭ��),���Ի���,ͨ��:retries �������������Դ���
		failfast	:������,����ʧ��,ֱ���׳��쳣
		failsafe	:���ӵ���ʧ��,���׳��쳣
		failback	:ʧ���Զ��ָ�����̨��¼ʧ�����󣬶�ʱ�ط���
		forking		:���е��ö����������ֻҪһ���ɹ������ء�ͨ��:forks �����������������
		broadcast	:�㲥����,�𽥵������еķ����ṩ��,ֻҪ��һ������.�ͱ���

��	���ؾ���(˫������)
	* ȫ������
		<dubbo:provider loadbalance="random" weight="5"/>
		<dubbo:consumer loadbalance="random"/>
	* ��ȷ����������
		<dubbo:service loadbalance="random" weight="5"/>
		<dubbo:reference loadbalance="random"/>
	* ��ȷ������
		<dubbo:service >
			<dubbo:method loadbalance="random" weight="5"/>
		</dubbo:service>
		<dubbo:reference>
			<dubbo:method loadbalance="random"/>
		</dubbo:reference>
	* ����������
		random			:(Ĭ��)�������,����ͨ��:weight ����������Ȩ��,ֵԽ��,Ȩ��Խ��
		roundRobin		:��ѯ,������
		leastActive		:��С��Ծ������
		consistentHash	:һ����hash
	* dubbo���ṩ���ؾ�����Խӿ�,�����Լ�ʵ���㷨

��	�߳�ģ��(���������)
	* �����ñ�ǩ
		<dubbo:protocol dispather="" threadpool="" threads=""/>
		<dubbo:provider dispather="" threadpool="" threads=""/>
	* �߳�ģʽ,ͨ�� dispatcher ���Կ���,��ѡ������
		all			:(Ĭ��),������Ϣ���ɷ����̳߳�ȥ���.
		direct		:������Ϣ�������̳߳�,��ǰIO�߳����
		message		:ֻ��������Ӧ��Ϣ�ɷ����̳߳أ��������ӶϿ��¼�����������Ϣ��ֱ����IO�߳���ִ�С�
		execution	:ֻ������Ϣ�ɷ����̳߳أ�������Ӧ����Ӧ���������ӶϿ��¼�����������Ϣ��ֱ����IO�߳���ִ�С�
		connection	:��IO�߳��ϣ������ӶϿ��¼�������У��������ִ�У�������Ϣ�ɷ����̳߳ء�
	* �̳߳�����,ͨ��:threadpool ���Կ���,��ѡ������
		fixed		:�̶���С�̳߳أ�����ʱ�����̣߳����رգ�һֱ���С�(ȱʡ)
		cached		:�����̳߳أ�����һ�����Զ�ɾ������Ҫʱ�ؽ���
		limited		:�������̳߳أ������е��߳���ֻ����������������(Ϊ��������ʱͻȻ���˴������������������)��
	* �̳߳�,�߳�����,ͨ��:threads ����ָ��

��	ֱ���ṩ��(����������)
	* <dubbo:reference id="xxxService" interface="com.alibaba.xxx.XxxService" url="dubbo://localhost:20890" />

��	ֻ����(ע���������)
	* �����������ע�������ϵķ���,�����ѱ���Ӧ�õķ���ע�ᵽ��ע������
		<dubbo:registry address="10.20.153.10:9090" register="false"/>
		<dubbo:registry address="10.20.153.10:9090?register=false" />

��	ֻע��(ע���������)
	* �����ѱ���Ӧ�õķ���ע�ᵽ���ע������,����ͨ�����ע�����Ļ�ȡ����
		<dubbo:registry id="qdRegistry" address="10.20.141.150:9090" subscribe="false" />
		<dubbo:registry id="qdRegistry" address="10.20.141.150:9090?subscribe=false" />

��	��̬����

��	��Э��(˫������)
	* ���������Э��
		<dubbo:protocol name="dubbo" port="20880" />
		<dubbo:protocol name="rmi" port="1099" />
	* ʹ��ָ��Э�鱩¶����
		<dubbo:service interface="com.alibaba.hello.api.HelloService" version="1.0.0" ref="demoService" protocol="dubbo" />
		<dubbo:service interface="com.alibaba.hello.api.HelloService" version="1.0.0" ref="demoService" protocol="rmi" />
	* ʹ�ö��Э�鱩¶����
		<dubbo:service interface="com.alibaba.hello.api.HelloService" version="1.0.0" ref="demoService" protocol="dubbo,hessian" />
	* ��������ָ��Э��ķ���
		<dubbo:reference protocol="dubbo"/>		
	
��	��ע������(˫������)
	* ���������ע������(���Ѷ�,����˶���Ҫ����)
		<dubbo:registry id="registry1" address="10.20.141.150:9090" />
		<dubbo:registry id="registry2" address="10.20.141.151:9010" default="false" />
	* ͬһ������,ע�ᵽ���ע������
		<dubbo:service registry="registry1,registry2" />
	* ��ͬ����,ע�ᵽ��ͬע������
		<dubbo:service interface="com.alibaba.hello.api.HelloService" registry="registry1" />
		<dubbo:service interface="com.alibaba.hello.api.DemoService" registry="registry2" />
	* ���Ѷ�ʹ��,��ָ����ע�����Ļ�ȡ����
		<dubbo:reference id="chinaHelloService" registry="registry1" />
		<dubbo:reference id="intlHelloService" registry="registry2" />

��	�������(˫������)
	* �����ṩ��,һ��������N��ʵ��
		<dubbo:service group="feedback" interface="com.xxx.IndexService" />
		<dubbo:service group="member"   interface="com.xxx.IndexService" />
	* �������Ѷ�,����ʱָ�� group
		<dubbo:reference group="feedback" interface="com.xxx.IndexService" />
		<dubbo:reference group="member"   interface="com.xxx.IndexService" />
	* �������һ��,���ɹ�һ���ͺ�
		<dubbo:reference group="*" interface="com.foo.BarService"  />
	
��	��汾(˫������)
	* �����ṩ��
		<dubbo:service interface="com.foo.BarService" version="1.0.0" />
		<dubbo:service interface="com.foo.BarService" version="2.0.0" />
	* ���Ѷ�����
		<dubbo:reference id="barService" interface="com.foo.BarService" version="1.0.0" />
		<dubbo:reference id="barService" interface="com.foo.BarService" version="2.0.0" />
	* �����ְ汾,������һ��
		<dubbo:reference id="barService" interface="com.foo.BarService" version="*" />

	����ۺ�
	������֤
	�������
	��������
	����ʵ��
	��������
	��������Ϣ
	��ʽ����
	�첽����
	���ص���
��	�����ص�
	* �����ʼ�

��	�¼�֪ͨ
	* �����ʼ�

	���ش��
	����αװ
��	�ӳٱ�¶(���������)
	* ȫ������
		<dubbo:provider delay="-1"/>
	* ָ������
		<dubbo:service delay="5000" />
	* delay ֵ(����)����� -1,���ʾ �ӳٵ�Spring��ʼ����ɺ��ٱ�¶����(����Spring��ContextRefreshedEvent�¼�������¶)

��	��������(˫������)
	* ���Ʒ����ṩ�˲���ִ����,ͨ�� executes ���Կ���
		* ȫ������
			<dubbo:provider executes="1000"/>
		* ���Ƶ�ָ������
			<dubbo:service executes="10" />
		* ���Ƶ�����
			<dubbo:service interface="com.foo.BarService">
				<dubbo:method name="sayHello" executes="10" />
			</dubbo:service>
		
	* ���Ʒ����ṩ��,'ÿ���ͻ���'����󲢷�ִ����(ռ�����ӵ�������),ͨ�� actives ���Կ���
		* ȫ������
			<dubbo:provider actives=""/>
			<dubbo:consumer actives=""/>
		* ���Ƶ�ָ������
			<dubbo:service interface="com.foo.BarService" actives="10" />
			<dubbo:reference interface="com.foo.BarService" actives="10"/>
		* ���Ƶ�ָ������
			<dubbo:service interface="com.foo.BarService">
				<dubbo:method name="sayHello" actives="10" />
			</dubbo:service>
			<dubbo:reference interface="com.foo.BarService">
				<dubbo:method name="sayHello" actives="10" />
			</dubbo:service>
		
��	���ӿ���(˫������)
	* ���Ʒ����ṩ�˵����������
		<dubbo:provider protocol="dubbo" accepts="10" />
		<dubbo:protocol name="dubbo" accepts="10" />
	* �ƿͻ��˷���ʹ��������������(����ǳ����ӣ�����DubboЭ�飬connections��ʾ�÷����ÿ���ṩ�߽����ĳ�������)
		<dubbo:reference interface="com.foo.BarService" connections="10" />
		<dubbo:service interface="com.foo.BarService" connections="10" />

	�ӳ�����
	* �ӳ����ӣ����ڼ��ٳ������������е��÷���ʱ���ٴ��������ӡ�������dubboЭ����Ч
		<dubbo:protocol name="dubbo" lazy="true" />

	ճ������
	* ճ������������״̬���񣬾������ÿͻ���������ͬһ�ṩ�߷�����ã����Ǹ��ṩ�߹��ˣ�������һ̨��
	* 'ճ�����ӽ��Զ������ӳ����ӣ��Լ��ٳ�������'
		<dubbo:protocol name="dubbo" sticky="true" />

��	������֤(�����/ע����������)
	* token ����Ϊtrue�Ļ�,��ʹ��UUID������token
	* ȫ������
		<dubbo:provider interface="com.foo.BarService" token="true" />
		<dubbo:provider interface="com.foo.BarService" token="123456" />
	* ���񼶱�
		<dubbo:service interface="com.foo.BarService" token="true" />
		<dubbo:service interface="com.foo.BarService" token="123456" />
	* Э�鼶��
		<dubbo:protocol name="dubbo" token="true" />
		<dubbo:protocol name="dubbo" token="123456" />
	
	·�ɹ���
	���ù���
	���񽵼�
	����ͣ��

��	������(���������)
	* ע��ĵ�ַ�����ȡ����ȷ��������Ҫע�ṫ����ַ
	* ������/etc/hosts�м��룺������ ����IP
		test1 205.182.23.201
	* ��dubbo.xml�м���������ַ������
		dubbo:protocol host="http://10.20.160.198/wiki/display/dubbo/205.182.23.201">
	* ��dubbo.properties�м���������ַ������
		dubbo.protocol.host=205.182.23.201

��	��־����(˫������)
	* Ĭ���Զ�����˳��:log4j slf4j jcl jdk
	* �����������
		* ��������
			java -Ddubbo.application.logger=log4j
		* properties�ļ�
			dubbo.application.logger=log4j
		* ȫ��
			<dubbo:application logger="log4j" />
		

��	������־
	* ÿ�η��ʶ���¼��־,��־���쳣��.
	* �ѷ�����־�������ǰ��log4��־
		<dubbo:protocol accesslog="true" />
	* �ѷ�����־�����ָ�����ļ�
		<dubbo:protocol accesslog="http://10.20.160.198/wiki/display/dubbo/foo/bar.log" />
	* ȫ������
		<dubbo:provider accesslog="true"/>
	* ��ȷ������
		<dubbo:service interface="" accesslog=""/>
		
��	��������
	* �����ʼ�

	Reference Config����
	�ֲ�ʽ����
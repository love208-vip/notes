--------------------------------
Dubbo-Zookeeper					|
--------------------------------
	# Zookeeper���е����ıʼǽ���,��ʵ�Ǵ����������һ�ּ���
	# �˴��ʼ�,����������Ϊ Dubbo ��ע��������صıʼ�
	# Zokkeeper,�е���'ע������'�Ľ�ɫ
		* �����ṩ��ע��������
		* ���������������������ע��
	
	# �����汾���ص�ַ
		http://apache.fayea.com/zookeeper/
	# Ĭ�ϼ����˿�
		2181
	# maven ����
		<dependency>
			<groupId>org.apache.zookeeper</groupId>
			<artifactId>zookeeper</artifactId>
			<version>3.4.9</version>
		</dependency>
		<dependency>
			<groupId>com.github.sgroschupf</groupId>
			<artifactId>zkclient</artifactId>
			<version>0.1</version>
		</dependency>


	
---------------------------------
Dubbo- Windos ��Dubbo������İ�װ|
---------------------------------
	1,����Zookeeper,��ѹ�������̷�
	2,�޸������ļ�
		* conf/zoo_sample.cfg
		* ������ļ�����Ϊ: zoo.cfg
		
	
		tickTime=2000
		initLimit=10
		syncLimit=5
		dataDir=E:/zookeeper-data
			* Ҳ����zookkeeper�����ݴ��·��
			* ��Ŀ¼�������,��ֻ���޸�������Ծ�OK,�����Ĳ��ö�.��ֻ�Ǹ��Ƴ���������
		dataLogDir=E:/zookeeper-log
			* ��־�ļ�Ŀ¼
		clientPort=2181
			* Ĭ�϶˿�

		#maxClientCnxns=60
		#autopurge.snapRetainCount=3
		#autopurge.purgeInterval=1
	3,���з���
		* bin/zkServer.cmd ˫��

---------------------------------
Dubbo- Linux ��Dubbo������İ�װ|
---------------------------------
	* ��windowsһ��,��ͬ����������ʽ
	* ����
		./zkServer.sh start
	* �ر�
		./zkServer.sh stop
	* �鿴����̨��Ϣ
		tail -f ./zookeeper.out
	
	* �鿴����
		jps
		QuorumPeerMain		//zookeeper�Ľ�����



---------------------------------
Dubbo- ��Ⱥ						 |
---------------------------------
	# Dubbo����ʹ��Zookeeper����Ϊ�����ע������
	# Zookeeper��Ⱥ��,ֻҪ�й���ڵ��������������,��ô������Ⱥ������ǿ��õ�
	# ��������������,����zk��Ⱥ.һ��'��Ⱥ�Ļ�������,������'�ȽϺ���
	# zookeeper��Ⱥ�ĸ߿���,������Leader���㷨,��Leader�ҵ���,ʣ�µĽڵ�,��ͨ��һ���㷨������ѡ�ٳ��µ�Leader

	1,�޸� /etc/hosts �ļ�
		�ڵ�IP				�ڵ���
		123.207.122.145		zk-01
		59.110.140.157		zk-02

	2,�� zookeeper Ŀ¼��,����Ŀ¼
		data		//�������
		logs		//�����־

	3,���� conf Ŀ¼�µ� zoo_sample.cfg �ļ�,����ǰĿ¼,��Ϊ:zoo.cfg
		cp ./zoo_sample.cfg ./zoo.cfg

	4,�޸������ļ�
		tickTime=2000
			* zookeeper��������Ⱥ֮���������ͻ���֮����������,ÿ������ʱ��(��)��һ��������

		initLimit=10
			* �ڵ㳬��'���ٸ�����'δ�յ�,����Ϊ������
			* 10 * 2000 = 20 ��
			* Ҳ����˵,���� 20 ��û���յ��ڵ�n������,����Ϊ������

		syncLimit=5
			* ����֮�䷢����Ϣ,�����Ӧ���ʱ�䳤�Ȳ��ܳ���'���ٸ�����'�ĳ���
			* 5 * 2000 = 10 ��
			* ��������Ӧ��,���ܳ���10��


		dataDir=/usr/local/zookeeper/zookeeper-3.4.9/data
			* Ҳ����zookkeeper�����ݴ��·��
			* ��Ŀ¼�������,��ֻ���޸�������Ծ�OK,�����Ĳ��ö�.��ֻ�Ǹ��Ƴ���������

		dataLogDir=/usr/local/zookeeper/zookeeper-3.4.9/logs
			* ��־�ļ�Ŀ¼

		clientPort=2181
			* Ӧ�ó�����ʵ�,Ĭ�϶˿�

		#maxClientCnxns=60
		#autopurge.snapRetainCount=3
		#autopurge.purgeInterval=1
		# ��Ⱥ����
		server.1=zk-01:2881:3881
		server.2=zk-02:2882:3882
		--------------------------------------------------------------
		# ��������(��Ⱥ����)
			* ������Ծ��Ǽ�Ⱥ�Ĺؼ���

			server.A=B:C:D

			A
				* ��һ������,��ʾΪ��Ⱥ�еڼ��ŷ�����
			
			B
				* ��ʾ�÷�������IP��ַ,��������IP����ӳ���������
			
			C
				* �ö˿�,��������Ⱥ��Ա֮�����Ϣ����.��ʾ�÷������뼯Ⱥ��leader�������Ľ�����Ϣ�Ķ˿�
			
			D
				* ����Ⱥ��Leader�ҵ���,��Ⱥ��Ա��ͨ���ö˿�������Leaderѡ��
		--------------------------------------------------------------
	5,��dataDirĿ¼�´���myid�ļ�
		touch ./myid
	
	6,��myid�ļ��������Ӧ�ı��
		* �������ǵڼ���������,�����д��
	
	7,����Zookeeper
		./bin/zkServer.sh start
	
	8,�鿴��ǰ�ڵ�״̬/��ɫ
		./bin/zkServet.sh status
	
	9,Dubbo���Ӽ�Ⱥ
		dubbo.registry.address=ip:port,ip:port,ip:port
		* ���Ӽ�Ⱥ�еĽڵ�,�ж��ٸ������ٸ�
		* ʹ�ö��ŷָ�
		

		
---------------------------------
Dubbo- ��Ⱥ��Ǩ��,����			 |
---------------------------------
	# Zookeeper��ȺǨ��˼·



		
		

		
	

	
	
	
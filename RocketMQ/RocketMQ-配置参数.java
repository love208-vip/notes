---------------------------
RocketMQ-JVM����			|
---------------------------	
	# �ļ�
		./bin/runbroker.sh
		./bin/runserver.sh

	# nameserver �� broker ��Ĭ��ֵ�е��,4GB
		JAVA_OPT="${JAVA_OPT} -server -Xms4g -Xmx4g -Xmn2g -XX:PermSize=128m -XX:MaxPermSize=320m"
		JAVA_OPT="${JAVA_OPT} -server -Xms4g -Xmx4g -Xmn2g -XX:PermSize=128m -XX:MaxPermSize=320m"

	# Ŀǰ�Ѳ�,��С�������ڴ�
		JAVA_OPT="${JAVA_OPT} -server -Xms256m -Xmx256m -Xmn128m -XX:PermSize=64m -XX:MaxPermSize=128m"

-----------------------------
RocketMQ- broker-x.properties|
-----------------------------
	listenPort 
		* Broker��������˿�,Ĭ��ֵ 10911 

	brokerClusterName=rocketmq-cluster
		* ������Ⱥ������
	
	brokerIP1
		* ����IP,����IP��ַ�ɳ����Զ�ʶ��.����ĳЩ���������ʶ���������,��ʱ�����˹�����
	
	brokerName=broker-a
		* broker����,һ����Ⱥ��ÿ��borker�����Ʋ�����ͬ,�����SLAVE,���ֵӦ�ú�MASTER����һֱ

	brokerId=0
		* ��ֵΪ0,���ʾ��ǰbroker��һ��master,��������� >0 ����ֵ���ʾ Slave

	namesrvAddr=rocketmq-nameserver1:9876;rocketmq-nameserver2:9876
		* nameserver��ַ,����ж����ʹ�÷ֺŷָ�

	defaultTopicQueueNums=4
		* �ڷ�����Ϣʱ���Զ����������������ڵ�topic��Ĭ�ϴ����Ķ�����

	autoCreateTopicEnable=true
		* �Ƿ����� Broker �Զ�����Topic���������¿��������Ϲر�
		* ���滷��,����ͨ����������������.����ǳ����Զ�����,���ػ�ʧЧ
		* Broker ����Զ��������еĻ�,��ôBroker�յ�һ���µĶ���,�ͻᴴ��.���Ժ�,�ö��е�������Ϣ����ͨ�����Broker����,��Ϣ����ʧЧ

	autoCreateSubscriptionGroup=true
		* �Ƿ����� Broker �Զ����������飬�������¿��������Ϲر�
	
	rejectTransactionMessage=false
		* �Ƿ�ܾ�������Ϣ
	
	fetchNamesrvAddrByAddressServer=false
		* �Ƿ��WEB��������ȡNameServer��ַ,��Դ��ģ��Broker��Ⱥ����ʹ�����ַ�ʽ

	deleteWhen=04
		* ɾ���ļ�ʱ��㣬Ĭ���賿 4��(24H)

	fileReservedTime=48
		* �ļ�����ʱ�䣬Ĭ�� 48 Сʱ,��λ��(H)

	mapedFileSizeCommitLog=1073741824
		* commitLogÿ���ļ��Ĵ�СĬ��1G,����֮��,�½��ļ�

	mapedFileSizeConsumeQueue=300000
		* ConsumeQueueÿ���ļ�Ĭ�ϴ�30W��������ҵ���������

	destroyMapedFileIntervalForcibly=120000

	redeleteHangedFileInterval=120000

	diskMaxUsedSpaceRatio=88
		* ��������ļ����̿ռ�

	/***	 ·�����ÿ�ʼ		**/
	storePathRootDir
		* �洢·��
	
	storePathCommitLog
		* commitLog �洢·��
		* Ĭ�ϵ�ַ $HOME/store/commitlog

	storePathConsumeQueue
		* ���Ѷ��д洢·���洢·��
		* Ĭ�ϵ�ַ $HOME/store/consumequeue

	storePathIndex
		* ��Ϣ�����洢·��
		* Ĭ�ϵ�ַ $HOME/store/index

	storeCheckpoint
		* checkpoint �ļ��洢·��
		* Ĭ�ϵ�ַ $HOME/store/checkpoint

	abortFile
		* abort �ļ��洢·��
		* Ĭ�ϵ�ַ $HOME/store/abort
	
	/***	 ·�����ý���		**/

	/***	 ��С�������ÿ�ʼ	**/
	maxTransferBytesOnMessageInMemory=262144
		* ���� Pull ��Ϣ(�ڴ�)���������ֽ���

	maxTransferCountOnMessageInMemory=32
		* ���� Pull ��Ϣ(�ڴ�)���ݵ������Ŀ��
	
	maxTransferBytesOnMessageInDisk=65536
		* ���� Pull ��Ϣ(����)���������ֽ���

	maxTransferCountOnMessageInDisk
		* ���� Pull ��Ϣ(����)���ݵ������Ŀ��
	
	maxMessageSize=65536
		* ���Ƶĵ�����Ϣ��С
	/***	 ��С�������ý���	**/

	messageIndexEnable=true
		*���Ƿ�����Ϣ��������

	messageIndexSafe=false
		* �Ƿ��ṩ��ȫ����Ϣ��������,������֤����
	
	haMasterAddress
		* ��SLAVE��ִ������MASTER��ַ,Ĭ�ϴ�NameServer���Զ���ȡ,Ҳ�����ֶ�������
	
	brokerRole=ASYNC_MASTER
		* Broker�Ľ�ɫ
		* ASYNC_MASTER �첽����Master
		* SYNC_MASTER ͬ��˫дMaster
	
	flushDiskType=ASYNC_FLUSH
		* ˢ�̷�ʽ
		* ASYNC_FLUSH �첽ˢ��
		* SYNC_FLUSH  ͬ��ˢ��
	
	cleanFileForciblyEnable=true
		* ������,���޹����ļ������,true ��ʾǿ��ɾ���ļ�,false,��Ƿ��񲻿���,�ļ�����ɾ��
	



	#flushCommitLogLeastPages=4
	#flushConsumeQueueLeastPages=2
	#flushCommitLogThoroughInterval=10000
	#flushConsumeQueueThoroughInterval=60000

	#
	
	brokerRole=ASYNC_MASTER
		* Broker �Ľ�ɫ
		* ASYNC_MASTER �첽����Master
		* SYNC_MASTER ͬ��˫дMaster
		* SLAVE

	flushDiskType=ASYNC_FLUSH
		* ˢ�̷�ʽ
		* ASYNC_FLUSH �첽ˢ��
		* SYNC_FLUSH ͬ��ˢ��

	checkTransactionMessageEnable=false
		
	sendMessageThreadPoolNums=128
		* ����Ϣ�̳߳�����

	pullMessageThreadPoolNums=128
		* ����Ϣ�̳߳�����





















brokerClusterName=rocketmq-cluster
brokerName=broker-x
brokerId=0
namesrvAddr=rocketmq-nameserver1:9876;rocketmq-nameserver2:9876
defaultTopicQueueNums=4
autoCreateTopicEnable=true
autoCreateSubscriptionGroup=true
listenPort=10911
deleteWhen=04
fileReservedTime=120
mapedFileSizeCommitLog=1073741824
mapedFileSizeConsumeQueue=300000
diskMaxUsedSpaceRatio=88
storePathRootDir=/usr/local/rocketmq/store
storePathCommitLog=/usr/local/rocketmq/store/commitlog
storePathConsumeQueue=/usr/local/rocketmq/store/consumerqueue
storePathIndex=/usr/local/rocketmq/store/index
storeCheckpoint=/usr/local/rocketmq/store/checkpoint
abortFile=/usr/local/rocketmq/store/abort
maxMessageSize=65536
brokerRole=ASYNC_MASTER
flushDiskType=ASYNC_FLUSH


































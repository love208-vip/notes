------------------------
ActiveMQ-����			|
------------------------
	# ������Apache������
	# ������ַ
		http://activemq.apache.org/
	# ��ȫ֧��JMS1.1��JEE1.4�淶��JMSʵ��
	
	# �˿�˵��
		8161
			* WEB����̨�˿�
		61616
			* tcpЭ�����Ӷ˿�
		
		

------------------------
ActiveMQ-Ŀ¼�ṹ		|
------------------------
	bin		
		* ����,������ע��ĵĽű�

	conf
		* �����ļ�Ŀ¼,�����º��ĵ������ļ�
		activemq.xml			//��������
		jetty.xml				//����Jetty�������ļ�
		jetty-realm.properties	//��̨�����û�����
	data
		* ���ݴ��

	docs
		* �ĵ�

	examples
		* ����

	lib
		* 

	webapps
		* ����Ĺܿ�̨,���������ű�.����ܿ�̨�ͻ�������Jetty����

	webapps-demo
		* Сdemo

	activemq-all-5.11.1.jar


------------------------
ActiveMQ-Consumer		|
------------------------
	* ��Ϣ������
	1,�������ӹ���
	2,ͨ��������ȡ����
	3,ͨ�����Ӵ����Ự
	4,ͨ���Ự��������/����
	5,ͨ���Ự������Ϣ������
	6,��Ϣ����������,�յ���Ϣ,��ȡ��message
	7,��ȡ����


------------------------
ActiveMQ-Provider		|
------------------------
	* ��Ϣ������
	1,�������ӹ���
	2,ͨ��������ȡ����
	3,ͨ�����Ӵ����Ự
	4,ͨ���Ự��������/����

	5,ͨ���Ự������Ϣ�����߶���,�󶨶���/����
		* Ҳ���Բ��󶨶���/����,��ִ�з��͵�ʱ���
	6,������Ϣ�����߶���Ĳ�������
		* Ҳ������ִ�з��͵�ʱ������
	7,������Ϣ
		* ��Ϣ������N����,������Ҫ����
	8,ͨ����Ϣ������ִ�з��Ͳ���
		* ����������󶨶���/����,��������
	9,�ر���Դ,������Ҫ�ر����Ӽ���,���Զ��ر���ص�����





------------------------
ActiveMQ-Linux����		|
------------------------
	./activemq start							//��������
	./activemq start > /tpm/activemqlog			//��������,����ָ����־�ļ�
	./activemq start xbean:file:../../my.xml	//�ֶ�ָ�������ļ�

	./activemq stop								//�رսڵ�,����˵ֱ�ӱ���kill





------------------------
ActiveMQ-JAVA��ǶBroker	|
------------------------
	# JAVA main
		public class Broker {
			public static void main(String[] args) throws Exception {
				BrokerService broker = new BrokerService();
				broker.setUseJmx(Boolean.TRUE);
				broker.addConnector("tcp://localhost:61616");
				broker.start();
			}
		}
	
	# ����spring
		* �Լ�ȥ��
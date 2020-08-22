package com.kevin.demo.activemq.helloworld;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * ��Ϣ������
 * */
public class Provider {
	public static void main(String[] args) throws JMSException {
		/**
		 * 1,�������ӹ���.ʹ��JMS�淶
		 * 	�û���������ʹ��Ĭ��,���ӷ�ʽΪTCP
		 * */
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
												ActiveMQConnectionFactory.DEFAULT_USER,
												ActiveMQConnectionFactory.DEFAULT_PASSWORD,
												"tcp://123.207.122.145:61616");
		/***
		 * 2,ͨ��������ȡһ������,���Ҵ���(�ڴ������ӵ�ʱ��,Ҳ�ǿ��������û���������)
		 * 	Ĭ���ǹر�״̬
		 * */
		Connection connection = connectionFactory.createConnection();
		connection.start();
		/**
		 * 3,ͨ������,��ȡ�Ự
		 * 	����1,�Ƿ���������(������)
		 * 	����2,��Ϣǩ��ģʽ(�������ֶ�ǩ��)
		 * */
		Session session = connection.createSession(Boolean.TRUE,Session.CLIENT_ACKNOWLEDGE);
		/**
		 * 4,ͨ���Ự���� Destination ����
		 * 	Destination ,�������� ������ �� ��Ϣ��Դ�Ķ���.��ʵ��һ���߲�ĳ���
		 *  	��PTPģʽ��,Destination ����Ϊ:Queue,Ҳ���Ƕ���
		 * 		��Pub/Subģʽ��,Destination ����Ϊ:Topic,Ҳ��������
		 * */
		Destination destination = session.createQueue("queue#1");		//PTPģʽ,�������Ƕ���,����ָ����������
		/**
		 * 5,ͨ���Ự���� ��Ϣ������ MessageProducer
		 * 	���촫�� Destination ��������
		 *	����Ĺ���,Ҳ����ָ��Ϊ null,��  messageProducer ִ�� send ������Ϣ��ʱ��,��ָ�� Destination
		 * */
		MessageProducer messageProducer = session.createProducer(destination);
		/**
		 * 6,���� ��Ϣ�����ߵ�һЩ����
		 * 	Ҳ������ִ�� send ��ʱ��,ȥָ������
		 * */
		messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);		//����Ϊ�ǳ־û�
		messageProducer.setPriority(9); 							//������Ϣ���ȼ���
		/**
		 * 7,���,ͨ���Ự,ʹ��JMS�淶�е� TextMessage ��ʽ��������,��ʹ�� ��Ϣ������MessageProducer ��������Ϣ
		 * */
		for(int x = 0;x < 5;x++){
			TextMessage message = session.createTextMessage("��Ϣǩ��ģʽ-�ͻ���ǩ����Ϣ#" + x);			//ֱ��ָ����Ϣ����
			//message.setText("hello");		Ҳ���Դ����������Ϣ
			messageProducer.send(message);
			//N�๹��,�����ڷ��͵�ʱ��,����һЩ����
			//messageProducer.send(destination, message, DeliveryMode.NON_PERSISTENT, Priority.DEBUG_INT, 9999999);
		}
		session.commit();
		/**
		 * 8,�ر���Դ
		 * */
		if(connection != null){
			/**
			 * ����Ҫ�رմ�����,�����Լ�ȥ�ر��������й�����
			 * */
			connection.close();
		}
	}
}



-----------------------------------------------------------------------------------------------
package com.kevin.demo.activemq.helloworld;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * ��Ϣ������
 * */
public class Consumer {
	public static void main(String[] args) throws JMSException {
		/**
		 * 1,����ConnectionFactory����
		 * 	ʹ��Ĭ�ϵ��û���������,���ӷ�ʽΪTCP
		 * */
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
												ActiveMQConnectionFactory.DEFAULT_USER,
												ActiveMQConnectionFactory.DEFAULT_PASSWORD,
												"tcp://123.207.122.145:61616");
		/**
		 * 2,ͨ��ConnectionFactory����,��ȡ������ Connection,���Ҵ�����(Ĭ��Ϊ�ر�״̬)
		 * */
		Connection connection = connectionFactory.createConnection();
		connection.start();
		/**
		 * 3,ͨ������,�����Ự,Session
		 * 	����������
		 * 	��Ϣǩ��ģʽΪ �������ֶ�ǩ��
		 * */
		Session session = connection.createSession(Boolean.FALSE,Session.CLIENT_ACKNOWLEDGE);
		/**
		 * 4,ͨ�� �Ự ���� Destination ����
		 * 	Destination ,�������� ������ �� ��Ϣ��Դ�Ķ���.��ʵ��һ���߲�ĳ���
		 *  	��PTPģʽ��,Destination ����Ϊ:Queue,Ҳ���Ƕ���
		 * 		��Pub/Subģʽ��,Destination ����Ϊ:Topic,Ҳ��������
		 * */
		Destination destination = session.createQueue("queue#1");	//ָ�����е�����
		/**
		 * 5,ͨ��Session������Ϣ���ն���
		 * 	���촫�� Destination ��������
		 * */
		MessageConsumer messageConsumer = session.createConsumer(destination);
		/**
		 * 6,ʹ�ý��ն���(MessageConsumer),�� receive ������ ,JMS�淶�� TextMessage ����,
		 * */
		while(true){
			/**
			 * receive(),��������кܶ�������ʽ
			 * 	1,�ղ�,����,�������.BIO���ֽ���
			 * 	2,Long,����ʱ��,�����ʱ.�ͻ�����ִ��
			 * 	3,NoWait(),����ִ�е��������Ƿ�������,�����ݾ�����.��Ȼֱ������ִ��.����ȴ�,����������
			 * */
			TextMessage message = (TextMessage) messageConsumer.receive();
			if(message == null){
				break;
			}
			message.acknowledge(); 		//�ֶ�ǩ����Ϣ,��ʵ���������߳�.TCP֪ͨMQ,�����Ϣ�ҳɹ�������
			System.out.println(message.toString());
			System.err.println("�յ���Ϣ:" + message.getText());
		}
		/**
		 *7, �ر���Դ
		 * */
		if(connection != null){
			connection.close();
		} 
	}
}

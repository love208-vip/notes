--------------------------------
RocketMQ-˳������				|
--------------------------------
	# OrderProducer
	# RocketMQ���Ա�֤�ϸ��˳������
	# ��ѭȫ�ֵ�ʱ��,ʹ��һ�� Queue,�ֲ�˳���ʱ��ʹ�ö�� Queue ��������.


--------------------------------
RocketMQ-Provider				|
--------------------------------

package com.kevin.rocketmq.helloword;
import java.util.List;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
/**
 * ��Ϣ������
 * */
public class Producer {
	private static final String PRODUCER_GROUP_NAME = "ORDER_GROUP";
	private static final String NAMESERVER_ADDRESS = "120.76.182.243:9876";
	private static final String TOPIC_NAME = "ORDER_TOPIC";
	public static void main(String[] args) throws Exception{ 
		DefaultMQProducer producer = new DefaultMQProducer(PRODUCER_GROUP_NAME);
		/**
		 * nameserver��ַ
		 */
		producer.setNamesrvAddr(NAMESERVER_ADDRESS);
		/**
		 * ��ʼ������
		 */
		producer.start();		
		for(int x = 1;x <= 5;x ++){
			String body =  "˳����Ϣ,��[" + x + "]��";		//��Ϣ����
			String key = "1234565";				//��Ϣ����
			Message message = new Message(TOPIC_NAME,"tag",key,body.getBytes());
			SendResult result = producer.send(message,new MessageQueueSelector() {
				public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
					Integer index = (Integer) arg;		//������Ի�ȡ���ݵĶ�����в���
					/**
					 * ����ѡ��һ�����н�����Ϣ����
					 */
					return mqs.get(index);
				}
			},0);										//0����ʹ�õĶ��е��±�,������Դ����������
			System.out.println(result);
		}
		producer.shutdown();		//�ͷ���Դ
    }
}

--------------------------------
RocketMQ-Consumer				|
--------------------------------
package com.kevin.rocketmq.helloword;
import java.util.List;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
/**
 * ˳����Ϣ����
 */
public class Consumer {
	private static final String CONSUMER_GROUP_NAME = "ORDER_GROUP";
	private static final String NAMESERVER_ADDRESS = "120.76.182.243:9876";
	private static final String TOPIC_NAME = "ORDER_TOPIC";
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(CONSUMER_GROUP_NAME);
        /**
         * ����Consumer��һ�������ǴӶ���ͷ����ʼ���ѻ��Ƕ���β����ʼ����<br>
         * ����ǵ�һ����������ô�����ϴ����ѵ�λ�ü�������
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        /**
         * nameserver��ַ
         */
        consumer.setNamesrvAddr(NAMESERVER_ADDRESS);
        /**
         * ��������
         */
        consumer.subscribe(TOPIC_NAME,"*");
        /**
         * ���ü���
         */
        consumer.registerMessageListener(new MessageListenerOrderly() {
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
            	try {
                	context.setAutoCommit(true);
	                for (MessageExt message: msgs) {
	                	//��Ϣ����
	                	String body = new String(message.getBody());		//����
						String ququeId = message.getQueueId() + "";			//����ID
						System.out.println("�յ�����Ϣ,����="+body+",����Id="+ququeId);
	                }
	                //�߳���ͣ
	                Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        System.out.println("����������");
    }
}
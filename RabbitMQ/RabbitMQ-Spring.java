--------------------------------
RabbitMQ-����Spring				|
--------------------------------
	# ��ͷϷ
	# 'spring��AMQP����֧��,����Ŀǰֻ��RabbitMQ�ṩ��ʵ��'
	# xml��Լ��ͷ
		xmlns:rabbit="http://www.springframework.org/schema/rabbit"
		xsi:schemaLocation = http://www.springframework.org/schema/rabbit http://www.springframework.org/schema/rabbit/spring-rabbit.xsd

	# ����Ҫ��ҪRabbitMQ�Ŀͻ���,����Ҫ���ϰ�
		<dependency>
			<groupId>com.rabbitmq</groupId>
			<artifactId>amqp-client</artifactId>
			<version>3.6.5</version>
		</dependency>

		* ˵ʵ��,��MQ��APIʹ��ȷʵ��˳��,������Ҫ��װ.Ҫô�����Լ���.Ҫô������.
		* ��Ȼ�Ǳ�����,û��,�����:spring
			<dependency>
				<groupId>org.springframework.amqp</groupId>
				<artifactId>spring-rabbit</artifactId>
				<version>1.6.3.RELEASE</version>
			</dependency>
	
		
		/**
			xml����
		*/
		<description>spring����RabbitMQ-demo</description>
		<!-- ����RabbitMQ�����ӹ��� -->
		<rabbit:connection-factory 
					id="connectionFactory"
					host="127.0.0.1" port="5672" 
					username="kevin" 
					password="a12551255"
					virtual-host="/kevinblandy" />

		
		<!-- 
			����Rabbitģ�壬ָ�����ӹ����Լ�����(������)exchange / �����Ƕ���
			IOC�л�ȡ�� RabbitTemplate ������,�����͵���Ϣ�͵���,ָ���Ľ�������
		-->
		<rabbit:template 
			id="amqpTemplate" 
			connection-factory="connectionFactory" 
			exchange="fanoutExchange" />

		<!-- ͬ��,Ҳ�Ƕ���ģ��,���������������ָ������Ϣ��key
			<rabbit:template 
				id="amqpTemplate" 
				connection-factory="connectionFactory"
				exchange="fanoutExchange" 
				routing-key="foo.bar" />
		-->
		<!-- ͬ��,����ģ��,���ַ�ʽ�ǰ���Ϣֱ�Ӹ�����,�����Ǹ�������
			<rabbit:template 
				id="amqpTemplate" 
				connection-factory="connectionFactory"
				queue="myQueue"  />
		-->


		<!-- 
			MQ�Ĺ����������С��������� .ָ��һ�����ӹ�����OK
			��ע��IOC�����þ���,����������Զ���������֮���
		-->
		<rabbit:admin connection-factory="connectionFactory" />

		<!-- 
			������У��Զ�����(declare):������в�����,�ʹ���,���ھ�ɶҲ���� 
			durable:ָ����ҪҪ�־û�����
		-->
		<rabbit:queue name="myQueue" auto-declare="true" durable="flase"/>
		
		<!-- 
			���彻�������Զ�����(auto-declare):���������������,�Ҿʹ���,�������.��ɶҲ����
		-->
		<rabbit:fanout-exchange name="fanoutExchange" auto-declare="true">
			<!-- �������󶨶��� -->
			<rabbit:bindings>
				<rabbit:binding queue="myQueue"/>
			</rabbit:bindings>
		</rabbit:fanout-exchange>
		
		<!--
			���Ҳ�Ƕ��彻����,��topic����,ͨ�����
		<rabbit:topic-exchange name="myExchange">
			<rabbit:bindings>
				<rabbit:binding queue="myQueue" pattern="foo.*" />
			</rabbit:bindings>
		</rabbit:topic-exchange> 
		-->



		
		<!-- 
			���м��� ָ�����ӹ���,�Լ�ָ��������ͷ���,���м����Ķ�������
		-->
		<rabbit:listener-container connection-factory="connectionFactory">
			<rabbit:listener ref="foo" method="listen" queue-names="myQueue" />
		</rabbit:listener-container>
		<!-- ������bean ע�ᵽIOC-->
		<bean id="foo" class="cn.itcast.rabbitmq.spring.Foo" />


		/**
			��ʾ������
		*/
		public class SpringMain {
			public static void main(final String... args) throws Exception {
				AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/rabbitmq-context.xml");
				//��IOC�л�ȡRabbitMQģ��
				RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
				//������Ϣ
				template.convertAndSend("Hello, world!");
				Thread.sleep(1000);// ����1��
				ctx.destroy(); //��������
			}
		}

		/**
		 * ������
		 **/
		public class Foo {
			/**
			 * �����߼�������Ϣִ�е�ҵ�񷽷�
			 * */
			public void listen(String foo) {
				System.out.println("�����ߣ� " + foo);
			}
		}
	
--------------------------------
RabbitMQ-����Spring-API			|
--------------------------------

	RabbitTemplate
		//��������
		converAndSend("item.update","{id:'123',name:'Kevin'}");
			* ��һ���������Ƕ���key
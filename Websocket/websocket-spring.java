----------------------------------------
����Spring-������						|
----------------------------------------
	# ��������
		<dependency>
			<groupId>javax.websocket</groupId>
			<artifactId>javax.websocket-api</artifactId>
			<version>1.1</version>
			<scope>provided</scope> 
		</dependency>
	
	# ������ô��������ô����,ֱ�����ӵ�spring�Ĵ���,��Ϊ @Endpoint ��������ɨ�����,Ҫ��ȷ������: ServerApplicationConfig
	# ���ַ�ʽ�ǰ� �˵㽻���� Servlet ��������
	# ��Tomcat8�²���OK

----------------------------------------
����Spring-xml����						|
----------------------------------------
	# Spring Լ��
		xmlns:websocket="http://www.springframework.org/schema/websocket"
		xsi:schemaLocation=
			http://www.springframework.org/schema/websocket
			http://www.springframework.org/schema/websocket/spring-websocket.xsd

	# ��������
		<dependency>
			<groupId>javax.websocket</groupId>
			<artifactId>javax.websocket-api</artifactId>
			<version>1.1</version>
			<!-- ע��,scope����Ϊprovided,����runtime���ͻ�����ʹ��tomcat 8,����Ҫ��TOMCAT_HOME/lib�µ�javax.websocket-api.jarһ��ɾ�� -->
			<scope>provided</scope> 
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-websocket</artifactId>
			<version>4.2.8.RELEASE</version>
		</dependency>

	# ���� MessageHandler
		* ��Ҫ�����ڴ�����Ϣ
		* ֧�����ַ�ʽ��һ����ʵ��org.springframework.web.socket.WebSocketHandler �ӿ�
		* һ�����Ǽ̳� TextWebSocketHandler �� BinaryWebSocketHandler ������
	
	# ����������
		* ��ѡ�Ĳ���,��Ҫ��������ǰ�����ֺ�������һЩ����
		* ��Ҫ���������ڿͻ���������֮�����ֵ�һЩ����
		* �̳г����� HttpSessionHandshakeInterceptor 
	
	# �����Զ������ֹ���
		* ��ѡ����,����������,������֤�ͻ�����Դ��Э����Э�������
		* ʵ�ֽӿ� HandshakeHandler 

	# xml����
		<!--spring javadoc��˵����Ĭ������£�����������Դ���ʣ����������������ֲ����� allowed-origins �Ļ����Ǳ�403����-->
		<websocket:handlers allowed-origins="*">
			<!-- handler -->
			<websocket:mapping path="/springws/websocket.ws" handler="demoWSHandler"/>

			<!-- ���ִ������� -->
			<websocket:handshake-handler ref="test"/>	
			
			<!-- ���������� -->
			<websocket:handshake-interceptors>
				<bean class="com.ld.net.spider.demo.ws.HandshakeInterceptor"/>
			</websocket:handshake-interceptors>
		</websocket:handlers>
		
		<!-- ����messageHandler -->
		<bean id="demoWSHandler" class="com.ld.net.spider.demo.ws.DemoWSHandler"/>

		<!-- ���� -->
		<bean class="org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean">
			<property name="maxTextMessageBufferSize" value="8192"/>		
			<property name="maxBinaryMessageBufferSize" value="8192"/>
			<property name="maxSessionIdleTimeout" value="1000"/>
			<property name="asyncSendTimeout" value="1000"/>
		</bean>
	
	# Web.xml
		��web.xml������*.wsӳ�伴�ɣ����ԭ������/**/�Ļ���	
		<servlet-mapping>
			<servlet-name>springMVC</servlet-name>
			<url-pattern>*.ws</url-pattern>
		</servlet-mapping>

----------------------------------------
����Spring-��xml����(ע��)				|
----------------------------------------
	# �Զ���������
		* ʵ�ֽӿ�:WebSocketConfigurer
		* ���ע��:@Configuration ,@EnableWebSocket
		* ��д������,ͨ�� registerWebSocketHandlers �� addHandler �����
			1,����µĶ˵㼰��ӳ��(�����ж��)
			2,�������������(�����ж��)
			3,������ִ�����
			4,������ʵ�վ��(�����ж��)
			5,���� socketjs��֧��

		@Configuration
		@EnableWebSocket
		public class WebSocketConfig implements WebSocketConfigurer {

			@Override
			public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
				registry.addHandler(myHandler(), "/ws.ws")
						.addInterceptors(new HttpSessionHandshakeInterceptor())
						.setHandshakeHandler(handshakeHandler())
						.setAllowedOrigins("*")
						.withSockJS();
			}

			@Bean			//��Ϣ������
			public WebSocketHandler myHandler() {
				MessageHandler messageHandler = new MessageHandler();
				System.err.println("HAND="+messageHandler);
				return messageHandler;
			}
			
			@Bean			//������
			public DefaultHandshakeHandler handshakeHandler() {
				return new DefaultHandshakeHandler();
			}

			@Bean			//������
			public WebSocketContainer webSocketContainer(){
				WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
				webSocketContainer.setAsyncSendTimeout(5000);                   //�첽��Ϣ��ʱʱ��
				webSocketContainer.setDefaultMaxBinaryMessageBufferSize(1000);  //��������Ϣ��󻺳���
				webSocketContainer.setDefaultMaxTextMessageBufferSize(10000);   //�ı���Ϣ��󻺳���
				webSocketContainer.setDefaultMaxSessionIdleTimeout(1000);       //session��ʱʱ��
				return webSocketContainer;
			}
		}

----------------------------------------
����Spring-sockjs						|
----------------------------------------
	# ����ͨ��sockjs��Ҳ����js������

	
		
----------------------------------------
API										|
----------------------------------------
	WebSocketHandler
		# ��Ϣ����������ӿ�
		# ����
			void afterConnectionEstablished(WebSocketSession session) throws Exception;
				* ������ִ��
			void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception;
				* �յ���Ϣ
			void handleTransportError(WebSocketSession session, Throwable exception) throws Exception;
				* �쳣
			void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception;
				* ���ӹر�
			boolean supportsPartialMessages();
				* �Ƿ�֧�ַ�Ƭ��Ϣ
		|-AbstractWebSocketHandler
			# ����ʵ��,��ʵ���������˼����������Ϣ���͵Ĵ�����
			# ����
				protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception 
					* �ı���Ϣ
				protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception 
					* ��������Ϣ
				protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception 
					* pong��Ϣ
			|-TextWebSocketHandler
				# �ı���Ϣ������
				# ����
					* û���·���,�����ڴ���	handleBinaryMessage ��Ϣ��ʱ����׳��쳣	

			|-BinaryWebSocketHandler
				# ��������Ϣ������
				# ����
					* û���·���,�����ڴ���	handleTextMessage ��Ϣ��ʱ����׳��쳣	

	DefaultHandshakeHandler
		# Ĭ�ϵ� HandshakeHandler ʵ��

	HttpSessionHandshakeInterceptor
		# HandshakeInterceptor ��ʵ��֮һ
	

	WebSocketSession
		# ���ӻỰ
			

	WebSocketMessage<T>
		# ��Ϣ,�Ƿ���
		# ����
			T getPayload();
			int getPayloadLength();
			boolean isLast();
		|-AbstractWebSocketMessage
			# ����ʵ��
			# ����
			|-BinaryMessage
			|-PingMessage
			|-PongMessage
			|-TextMessage

	CloseStatus
		# ��Ϣ�رյ�һЩ��Ϣ


----------------------------------------
XML										|
----------------------------------------
	<websocket:handlers>
        <websocket:mapping path="/ws.ws" allowed-origins="*" order="5"/>			
			* ��������һ�� WebSocketHandler ������,����ָ��URI
			* allowed-origins	:��ʾ����ʲô�ط�����������,����ʹ��ͨ���,��ʾ��������
			* order				:δ֪
		<websocket:handshake-handler ref="test"/>							
			* ���� HandshakeHandler ������,����������,������֤�ͻ�����Դ��Э����Э�������
        <websocket:handshake-interceptors>
			* ��������ǰ���������,HandshakeInterceptor ����,�����ж��
            <bean class="com.tedi.community.web.utils.Interceprot"/>	
				* �������������ж��
        </websocket:handshake-interceptors>
    </websocket:handlers>


----------------------------------------
ע��									|
----------------------------------------
	# spring��������Ҳ����wbsocket��·����Ч
	# MessageHandler ���Ե�������ʽ������Ӧ���е�
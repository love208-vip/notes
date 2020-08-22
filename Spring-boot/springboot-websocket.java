----------------------------
Spring-boot websocket		|
----------------------------
	# ����WebSocket���Զ����ð�
		org.springframework.boot.autoconfigure.websocket
	
	# �����war��ʽ���е�websocket,��ô endpoint ��Ӧ�ý�����������,������ ServerEndpointExporter

----------------------------
Spring-boot websocket��1	|
----------------------------
	# ��������
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-websocket</artifactId>
        </dependency>
	
	# ע��Bean
		* ServerEndpointExporter
		@Configuration  
		public class WebSocketConfiguration {  
			@Bean  
			public ServerEndpointExporter serverEndpointExporter (){  
				return new ServerEndpointExporter();  
			}  
		}  
	
	# ʹ��ע�⿪��WebSocket�˵�
		 
		@Component 
		@ServerEndpoint("/websocket")		//������б�߿�ͷ,��Ȼ��������
		public WebSocketEndpoint{
			@OnMessage
			@OnOpen
			@OnClose
			@OnError
		}

	# ע��
		* @OnError Ҫ��Ӳ���:Throwable ,��Ȼ�����쳣
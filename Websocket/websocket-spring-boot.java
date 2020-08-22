----------------------------
Spring-boot websocket		|
----------------------------
	# ����WebSocket���Զ����ð�
		org.springframework.boot.autoconfigure.websocket
	
	# ��صĽ̳�
		https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-websocket-tomcat
		https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-websocket-jetty

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
		* Endpoint �� @Component ע���ʶ,��IOC����,����ÿ���������󶼻ᴴ���µĶ���
		
		* @OnError Ҫ��Ӳ���:Throwable ,��Ȼ�����쳣

	

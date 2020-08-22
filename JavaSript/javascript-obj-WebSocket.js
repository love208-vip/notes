------------------------
WebSocket-js			|
------------------------
	# ����Ȼ����JS�Ķ���
	# ���������Ƿ�֧��WebSocket
		function loadDemo() {  
			if (window.WebSocket) {  
				//֧��  
			} else {  
				//��֧��
			}  
		}  
	

------------------------
WebSocket-WebSocket		|
------------------------
	# ���� WebSocket ����
		var Socket = new WebSocket(url,[protocol]);
			* url:��ʾ���ӵĵ�ַ,ͨ����Э��:"ws://"����"wss://"(��ȫ��websocket)Э�鿪ͷ
			* protocol:��һ������,���Խ���һ�����߶����Э��,�ò��������Ǳ����
	
	# ����
		readyState	
			* ֻ������ readyState ��ʾ����״̬������������ֵ
			CONNECTING	:ֵΪ0,��ʾ��������
			OPEN		:ֵΪ1,��ʾ���ӳɹ�������ͨ����
			CLOSING		:ֵΪ2,��ʾ�������ڹر�
			CLOSED		:ֵΪ3,��ʾ�����Ѿ��ر�,���ߴ�����ʧ��
			
		bufferedAmount	
			* ֻ������ bufferedAmount �ѱ� send() �������ڶ����еȴ�����,���ǻ�û�з����� UTF-8 �ı��ֽ���.
			* �����ж���Ϣ�Ƿ������
				if (socket.bufferedAmount === 0) {
				  // �������
				} else {
				  // ���ͻ�û����
				}
		
		binaryType 
			* ָ����������������
			* ö��ֵ(�ַ���)
				binaryType = "blob";
				binaryType = "arraybuffer";
			
	# �¼�
		* �¼�������,������һ�� event ����
			Socket.onopen	
				* ���ӽ���ʱ����
				*  event����
					var protocol = event.target.protocol

			Socket.onmessage	
				* �ͻ��˽��շ��������ʱ����
				* event����
					var data = event.data;

				* �ж���Ϣ����
					if(typeof event.data === String) {
						console.log("Received data string");
					}
					if(event.data instanceof ArrayBuffer){
						console.log("Received arraybuffer");
					}

			Socket.onerror	
				* ͨ�ŷ�������ʱ����

			Socket.onclose	
				* ���ӹر�ʱ����
				* event����
					var code = event.code;
					var reason = event.reason;
					var wasClean = event.wasClean;

		* eventͨ������
			
	
	# ����
		Socket.send()	
			* ʹ�����ӷ�������
			* ���Ͷ���������
				var file = document.querySelector('input[type="file"]').files[0];
				ws.send(file);

		Socket.close()	
			* �ر�����
			* �ڴ��ڹر�֮ǰ,�͹رյ�socket����,�п��ܻᵼ�·��������쳣
				window.onbeforeunload = function () {  
					ws.close();  
				}  
		

------------------------
WebSocket-WebSocket		|
------------------------

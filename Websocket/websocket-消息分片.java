-----------------------------------
WebSocket-��Ϣ��Ƭ,ע��ʽ			|
-----------------------------------
	# ����Ϣ�����ʱ��,����ѡ������ϢΪ�����Ϣ.
	# ��������Ϣ���ı���Ϣ��һ��
	# ����
		@OnMessage
		public void onMessage(String message,boolean isLast){
			//balabalabal
		}

		@OnMessage
		public void onMessage(byte[] message,boolean isLast){
			//balabalabal
		}

		@OnMessage
		public void onMessage(ByteBuffer[] message,boolean isLast){
			//balabalabal
		}

	# �����ǰ��Ϣ����Ϣ���е����һ������Ϣ,isLast = true,��֮,��Ϊ false


-----------------------------------
WebSocket-��Ϣ��Ƭ,���ʽ			|
-----------------------------------
	# MessageHandler
	# ����ͻ���(���͸������)����Ϣ,������һ�����߶��.��sessionά��
	# �ýӿڶ����˱��ʽ�˵�,������վ��Ϣʱ,ע������Ȥ�����з�ʽ.
	# ����ʹ�øýӿ���ѡ���ǽ����ı���Ϣ,���Ƕ�������Ϣ
	# Ҳ���Խ���������Ϣ,�����ǵ���Ϣ����ʱ���ս�С��Ƭ��(��Ϣ�ر���ʱ��)
	# �ýӿ�,�ڲ��������ӿ�(��ʵ����MessageHandler),������Ҫʵ�ָýӿ���,�Ľӿ�ʵ��
		interface Whole<T> extends MessageHandler {
			void onMessage(T message);		
		}
		//�ýӿھ��Ƿ�Ƭ��Ϣ,���ʽ�Ľӿ�
		interface Partial<T> extends MessageHandler {

			void onMessage(T partialMessage, boolean last);
		}

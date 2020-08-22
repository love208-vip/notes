-------------------------
Spring boot ϵͳ���	 |
-------------------------
	# spring boot�ṩ������ʱӦ�ü�غ͹�����
	# ����ͨ��HTTP,JMX,SSHЭ�������в���,���,������ָ����Ϣ���Զ��õ�
	# Spring boot �ṩ�˼�غ͹���˵�
		actuator		���� EndPoint �б�,��Ҫ���� Spring-HATEOAS ֧��
		autoconfig		��ǰӦ�������Զ�����
		beans			��ǰӦ��������Bean��Ϣ
		configprops		��ǰӦ�������е���������
		dump			��ʾ��ǰӦ�õ��߳�״̬
		env				��ʾ��ǰӦ�õĻ�����Ϣ
		health			��ʾ��ǰӦ�õĽ���״̬
		info			��ʾ��ǰӦ�õ���Ϣ
		metrics			��ʾ��ǰӦ�õĸ���ָ��
		mappings		��ʾ��ǰӦ�õ����� @RequestMapping ·��
		shutdowm		�رյ�ǰӦ��(Ĭ�Ϲر�)
		trace			��ʾ׷����Ϣ(Ĭ������HTTP����)
	

-------------------------
Spring boot HTTP		 |
-------------------------	
	# ֻ��Ҫ�����������
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		* ��Ȼ��HTTP���,��ô��Ŀ��Ȼ��ҪWEB������
	
	

	# ���·��
		http://{ip}:{port}/{�˵���}						/*/
		* http://localhost:8222/info
		* ���صĶ���JSON����
	# ���� shutdown�˵�
		* ��֧��GET����,������POST

	# �޸Ķ˵�ID
		* ���ƶ���ͨ�� endpoints+�˵���+������ ���������õ�,ÿ��ʹ��,����
		* Demo
			endpoints.beans.id=mybeans
			��ʱbeans�˵����·��: http://localhost:8222/mybeans
		
	
	# �����˵�
		endpoints.shutdown.enabled=true
	
	# �رն˵�
		endpoints.beans.enabled=false
	
	# ������������Ҫ�Ķ˵�
		* �����ȹر�����,Ȼ���ٿ��������
		endpoints.enabled=false
		endpoints.beans.enabled=true
		
	# ���ƶ˵�ķ���·��
		* �˵�ķ���·��Ĭ����: /
		* �����޸�����
			management.context-path=/manager
		* ���ʵ�ַΪ
			http://localhost:8222/manager/beans
		
	# ���ƶ˵���ʶ˿�
		* Ϊ�˰�ȫ,һ�㶼������
		management.port=8222
	
	# �ر�HTTP�˵�
		management.port=-1
	
	# �Զ���˵�
		* �̳� AbstractEndpoint,����ע��Ϊ bean

---------------------------------
Spring boot �Զ���HealthIndicator |
---------------------------------	
	# health ��Ϣ���Ǵ� ApplicationContext �����е� HealthIndicator �� Bean ���ռ���
	# spring ������һЩ HealthIndicator
	
	# ʵ�� HealthIndicator �ӿ�,��д health();����

	
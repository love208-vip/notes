----------------------------
����������					|
----------------------------
	<!-- ����RabbitMQ�����ӹ��� -->
	<rabbit:connection-factory  id="connectionFactory" host="127.0.0.1" port="5672" username="kevin" password="a12551255" virtual-host="/kevinblandy" />
	
	<!-- 
		ע�����
	 -->
	<rabbit:admin connection-factory="connectionFactory"/>
	<!--
		�������
		�Զ�����
		�־û�
	-->
	<rabbit:queue name="taotao-web-item" auto-declare="true" durable="true">
	</rabbit:queue>
	<!--
		����
		���ù���
		ִ��bean,����ִ�еķ���,�Ͷ�������
	-->
	<rabbit:listener-container connection-factory="connectionFactory">
		<rabbit:listener ref="bean" method="demo" queue-names="taotao-web-item" />
	</rabbit:listener-container>
	<!--
		ҵ��Bean
	-->
	<bean id="bean" cass="xx.xx.xx.xx.Handler"/>


----------------------------
����������					|
----------------------------
	# ����Ϣ���͵�������

	<!-- ����RabbitMQ�����ӹ��� -->
	<rabbit:connection-factory  id="connectionFactory" host="127.0.0.1" port="5672" username="kevin" password="a12551255" virtual-host="/kevinblandy" />
	
	<!-- 
		ע�����
	 -->
	<rabbit:admin connection-factory="connectionFactory"/>
	
	<!-- 
		���彻���� (ͨ������)
		����
		�Զ�����
		�־û�
	-->
	<rabbit:topic-exchange name="kevin-exchange" auto-declare="true" durable="true"/>
	
	<!-- 
		����ģ��
		ָ�����ӹ����뽻����
	 -->
	<rabbit:template id="template" connection-factory="connectionFactory" exchange="kevin-exchange"/>

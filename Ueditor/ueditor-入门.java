---------------------------------
ueditor-����					 |
---------------------------------
	# ���԰ٶȵ�����
	# ����
		http://ueditor.baidu.com/website/
	
	# maven  ����
		<dependency>
		    <groupId>cn.songxinqiang</groupId>
		    <artifactId>com.baidu.ueditor</artifactId>
		    <version>1.1.2-offical</version>
		</dependency>


---------------------------------
ueditor-��ʹ��				 |
---------------------------------
	1,�����Ҫ����
		 <!-- �����ļ� -->
	    <script type="text/javascript" src="${pageContext.request.contextPath }/static/ueditor/ueditor.config.js"></script>
	    <!-- �༭��Դ���ļ� -->
	    <script type="text/javascript" src="${pageContext.request.contextPath }/static/ueditor/ueditor.all.js"></script>
	2,maven�������
		<dependency>
		    <groupId>cn.songxinqiang</groupId>
		    <artifactId>com.baidu.ueditor</artifactId>
		    <version>1.1.2-offical</version>
		</dependency>
	3,form����ӱ༭��ʵ��
		<form id="submitform">
			<!-- name ��Ӧ����name���� -->
			<script id="container" name="name" type="text/plain">
			</script>
		</form>
	4,ʵ�����༭��
		var ue = UE.getEditor('container',{
        	//��ʼ������
        	 autoHeight: false
        });
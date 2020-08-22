

*	REST,Ҳ����Representational State Transfer (��Դ)���ֲ�״̬ת��.
	'��Ŀǰ�����е�һ�ֻ������ܹ�',���ṹ����,���ϱ�׼.�������,��չ����
	����,���𲽵õ�Խ��Խ�����վ����

*	'��Դ(Resources)',�����ϵ�һ��ʵ��,����˵�������ϵ�һ��������Ϣ.
	������ʹһ���ı�,һ��ͼƬ,һ�׸���,һ�ַ���,��֮����һ������Ĵ���.
	������һ��URI(ͳһ��Դ��λ��)ָ����,ÿ����Դ��Ӧһ���ض���URI,Ҫ��ȡ�����Դ
	��������URI�Ϳ���,���'URL����ÿ����Դ�Ķ�һ�޶��ı�ʶ��'

*	'���ֲ�(Representation),����Դ������ֳ�������ʽ',�������ı��ֲ�.
	����:�ı�������TXT��ʽ����,Ҳ������HTML��ʽ,JSON,��������ʹ�ö�����

*	'״̬ת��(State Transfer)':ÿ����һ������,�ʹ����˿ͻ��˺ͷ�������һ�ν�������
	HTTPЭ��,��һ����״̬Э��.�����е�״̬�������ڷ�������,���'����ͻ�����Ҫ����������,����ͨ��ĳ���ֶ�'
	'�÷��������� ״̬�仯(State Transfer).������ת���ǽ����ڱ��ֲ�֮�ϵ�,���Ծ��� ���ֲ�״̬��'.
	������˵����:
		HTTPЭ������,�ĸ���ʾ������ʽ�Ķ���:GET,POST,PUT,DELETE,���Ƿֱ��Ӧ���ֻ�������:��ȡ,���,�޸�,ɾ��
	


ʾ��
	/order/1	HTTP GET
		* �õ�id=1��order��Դ
	/order/1	HTTP DELETE
		* ɾ��id=1��order��Դ
	/order/1	HTTP PUT
		* ����id-1��order��Դ
	/order		HTTP POST
		* ���һ��order
	
	HiddenHttpMethodFilter
		Ŀǰ������ı���֧��:POST/GET ����,��DELETE,PUT��method����֧��
		Spring3.0�������һ��������
		���Խ���Щ����ת��Ϊ��׼��HTTP����
		ʹ��֧��GET,POST,PUT��DELETE����
	<!-- RESTǰ�˿����� -->
	<filter>
		<filter-name>HiddenHttpMethodFilter</filter-name>
		<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>HiddenHttpMethodFilter</filter-name>
		<url-pattern>/</url-pattern>
	</filter-mapping>

	����GET����
		<a href="ROOT/testRest/1"/>
	����DELETE����
		<form action="ROOT/testRest/1" method="POST">
			<input type="hidden" name="_method" value="DELETE">
			...
		</form>
	����PUT����
		<form action="ROOT/testRest/1" method="POST">
			<input type="hidden" name="_method" value="PUT">
			...
		</form>
	����POST����
		<form action="ROOT/testRest" method="POST">
			...
		</form>
	
	* ��ʵ���Ƿ���DELETE/PUT�����ʱ��,���һ��������.���ƹ̶�,ֵ�̶�!��ô,�ͱ����������������REST���

	* ��Ŀ�귽����,ʹ�� @PathVariable ע������ȡ�������
	
	@PathVariable
		* ��ע����3.0�汾�������Ķ���,��ռλ����URL!�ù�����SpringMVC��RESTĿ��ͦ����չ�����о�����̱�������
		* ͨ����ע��,���԰�URL��ռλ�������󶨵����ƴ������������β���.
		��:
		@RequestMapping("/delete/{userid}")
		public String delete(@PathVariable("userid") String id)
		{
			userDao.delete(id);
			return null;
		}


	

	�ܽ����:���ֻ��ʹ��GET/POST,û����.������Ϊ�����������֧��DELETE��PUT,
	���Ծ���Ҫ��web.xml������һ�����������URL
	�ڱ�����POST����ʽ�ύ��,�������������,ָ������������ʽ:PUT/DELETE


----------------------
ResponseEntity<T>		|
----------------------
	# restful,spring�����֧��
	# ��restful��,head,״̬��������ʾ����״̬,body����װ����,����ʾ�κε�״̬
	# �����,����������Ӧ״̬��
	# ���һ��Զ��İѷ����е�'����'����ʽ��

		ResponseEntity<T> entity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			//����״̬Ϊ404,����bodyֵΪnull

		ResponseEntity<T> entity = ResponseEntity.status(HttpStatus.OK).body(User);
			//����״̬Ϊ200,�������Bodyֵ

		ResponseEntity<T> entity = ResponseEntity.ok(user);
			//�������ַ�ʽ�ļ�д

		ResponseEntity<T> entity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			//500״̬
	
	# ���캯��s
		new ResponseEntity(T,HttpHeaders,HttpStatus)
	
	['demo']
		
		@RequestMapping(value="/{id}")
		public ResponseEntity<User> queryByUserId(@PathVariable(value="id")String id){
			try{
				User user = userService.queryByUserId(id);
				if(user == null){
					//��Դδ�ҵ�
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
				}
				//��Դ�ɹ���ȡ
				return ResponseEntity.status(HttpStatus.OK).body(User);
			}catch(Exception e){
				//�������쳣
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}
	
	# ���ؿ�ֵ
		* ��ʵ��ν�Ŀ�ֵ:������ݳɹ�,����Ҫ���ͻ�����Ӧ�κ�����
		* ע����,����ҪReqestMapping��URLӳ��,RESTful�Ǹ�������ʽ����

		@RequestMapping(methd=RequestMethod.POST)
		public ResponseEntity<void> create(User user{
			...
		}
	
	# build �� bodyʲôʱ���� ��

----------------------
���PUT�޷��ύ������	|
----------------------
	<!-- ���ù��������PUT�����޷��ύ�������� (RESTful)-->
		<filter>
			<filter-name>HttpMethodFilter</filter-name>
			<filter-class>org.springframework.web.filter.HttpPutFormContentFilter</filter-class>
		</filter>
		<filter-mapping>
			<filter-name>HttpMethodFilter</filter-name>
			<url-pattern>/*</url-pattern>					*/
		</filter-mapping>

	<!-- ���ù��������PUT/DELETE/�����޷��ύ�������� (RESTful)-->
		
		<filter>
			<filter-name>HiddenHttpMethodFilter</filter-name>
			<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
		</filter>
		<filter-mapping>
			<filter-name>HiddenHttpMethodFilter</filter-name>
			<url-pattern>/*</url-pattern>				*/
		</filter-mapping>

----------------------
һЩϸ������			|
----------------------
	* ͨ��ResponseEntity��Ӧ404״̬��.���ᴥ��web.xml�����õ�404errorҳ��
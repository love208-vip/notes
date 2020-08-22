----------------------------
Spring-boot ���ð����	|
----------------------------

----------------------------
Spring-boot �򵥵İ�		|
----------------------------
	@Value(value="name")
	private String name;

	* ����˵,�ܼ�. @Value ֻ�ܰ���Щ������:application.properties �ļ��е�����


----------------------------
Spring-boot �󶨵�POJO		|
----------------------------
	# ��Ķ���
		@ConfigurationProperties(prefix="user")
		public class User{
			private String userName;
			private String age;
			private List<String> hobe = new ArrayList<String>();
			//ʡ��get/set
		}
	
	# �����ļ��Ķ���
		user.username=kevinblandy
		user.age=23
		user.hobe[0]=java
		user.hobe[1]=Linux
	
	# �Ѹ�����ӵ�IOC����
		* ������������� @Component  ע��
		* Ҳ��������������,ͨ��:@EnableConfigurationProperties({User.class}); ע������ӵ�IOC
	
	* Spring Bootʹ�ÿ��ɵĹ������ڰ����Ե� @ConfigurationProperties 
	* �����õ���������bean����������Ҫ��ȷƥ�䡣
	* ���磬context-path�󶨵�contextPath��PORT��port��
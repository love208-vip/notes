-----------------------
Spring boot-��jar��		|
-----------------------
	# ����˵,ֱ��Ĭ�Ͼ���
	# ע��Ϊ Linux �ķ���
		<build> 
			<plugins>
				<plugin>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-maven-plugin</artifactId>
					<configuration>
						<executable>true</executable>
					</configuration>
				</plugin>
			</plugins>
		</build>
		* �ܼ�,���һ�� configuration ���ü���,Ȼ����������(�����������)�� /etc/init.d Ŀ��.��OK��
		* ��Ŀ����־��: /var/log/{������}.log ��
	
-----------------------
Spring boot-��war��		|
-----------------------
	# �������½���spring boot ��Ŀʱѡ��Ĵ����ʽ��jar,�����ʱ��������ϣ����war
	# ��ô��jarת��Ϊwar? ,���²���,������.������(war -> jar)Ҳ�Ͷ���
	

	1,�޸�POM�ļ�
		* ��Ϊwar�������ʽ,������� ����
			

	2,Ĭ�ϵ�Servlet�������������޸�
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>

	3,���� ServletInitializer ��
		public class ServletInitializer extends SpringBootServletInitializer{
			@Override
			protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
				//ָ�� @SpringBootApplication ������
				return application.sources(Main.class);
			}
		}



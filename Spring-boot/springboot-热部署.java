----------------------------
Spring boot �Ȳ���			|
----------------------------
	# �Ȳ������˼����׸��
	# spring boot �Ȳ�����Ҫ��������
	# ��Ӳ��
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<dependencies>
					<dependency>
						<groupId>org.springframework</groupId>
						<artifactId>springloaded</artifactId>
						<version>1.2.6.RELEASE</version>
					</dependency>
				</dependencies>
				<executions>
					<execution>
						<goals>
							<goal>repackage</goal>
						</goals>
						<configuration>
							<classifier>exec</classifier>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	
	# ����ڿ���̨����������־,�ͱ�ʶOK
		[INFO] Attaching agents: [**/1.2.4.RELEASE/springloaded-1.2.4.RELEASE.jar]

----------------------------
Spring boot ���з���һ		|
----------------------------
	# ʹ�� maven �����������Ŀ
		spring-boot:run

----------------------------
Spring boot ���з�����		|
----------------------------
	# ֱ������ main �Ļ�,��ҪһЩ����
		1,���� spring-loader.x.x.x.jar ��ӵ� lib Ŀ��
		2,����ʱ�����VM����
			-javaagent:.\lib\springloader.x.x.x.jar -noverfy


----------------------------
Spring boot ע��			|
----------------------------

	# ������õ�IDE��Eclipse�����������þ�û������
	# ������õ���IntelliJ IDEA����������Ҫע��һ�����⣺
		* IntelliJ IDEA �ǲ����Զ�����project�ģ����ԣ���ᷢ�֣����޸���java code��ҲCtril+S�ˣ�����Spring-Loaded����û��Ч��
		* ��ݼ�������   Ctrl+Shift+F9(Ҳ����ȥ�޸Ŀ�ݼ�,����:ÿ�� ctrl+s�����ͬʱҲִ�б���)
	
----------------------------
Spring boot-devtools		|
----------------------------
	# spring-boot-devtools
	# һ��Ϊ�������ṩ�����ģ��,����Ҫ�Ĺ��ܾ����Ȳ���,�Զ����´��뵽Ӧ��.
	# ԭ����Ƿ��ִ�����ĺ�.��������Ӧ�õ����ٶȼ���.
	# ���ε�ԭ�����,ʹ������ ClassLoader,һ�����ز���ı����(������jar),һ������Ҳ���ı����,��Ϊ restat ClassLoader
	# �ڴ��뱻���ĵ�ʱ��,ԭ���� restart ClassLoader ���´���һ�� restart ClassLoader,���ڼ��ص���Ƚ���,����ʵ���˽Ͽ������
	# ����

		1,�������
			
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-devtools</artifactId>
				<optional>true</optional>
				<scope>test</scope>
			</dependency>
		
		2,��Ӳ��
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<!-- �����ֵ��Ϊ true,���Ȳ��𲻻���Ч -->
					<fork>true</fork>
				</configuration>
			</plugin>

	
	# Ч��
		�޸��� ->		���������
		�޸������ļ�->	���������
		�޸�ҳ��->		���������(����ͼ�㼼���й�)
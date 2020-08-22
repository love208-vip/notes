Date	2016��1��2�� 20:27:22
Author	KevinBlandy
��������������������������������������������������������
һ,Hibernat����				|
��������������������������������������������������������
	> Hibernate��һ����Դ��ѵ�ORM���,Ӧ���ڳ־ò�.����JDBC�����˷ǳ��������Ķ����װ,�����������κγ���.WEB,�������...������!
	> Hibernate��һ����������JAVAEEӦ�ò�������,��һ����ϵ���ݿ�ORM���
		* ORM����ͨ����java����ӳ�䵽���ݿ�,ͨ������java����,�Ϳ�����ɶ����ݱ�Ĳ���
	> Hibernate�ṩ�˶Թ�ϵ�����ݵ���ɾ�Ĵ����
	> һЩ���������ݿ���
		* JPA(Java Persistence API)JPAͨ��JDK5.0ע��,����XML����һ�������ϵӳ��(ֻ�нӿڹ淶)
		* Hibernate ��������ORM���,ͨ������-��ϵӳ������.������ȫ����ײ�SQL
		* MyBatis	������Apache��һ����Դ��Ŀibatis,֧����ͨ��SQL��ѯ,�洢���̺͸߼�ӳ�������־ò���
		Apache DBUtils,Spring JDBCTemplate ... ...

	> ORM:Object Relational Mapping  �����ϵӳ��
		* ��ͳ��ʽ�Ŀ���,��Ҫ�Լ�ȥ��дʵ�������,��DAO��,�Լ�ȥ��дһЩ�������ݿ�Ĺ���
		* JAVA��������������,�����ݿ���һ����ϵ�����ݿ�!�洢�Ķ���ʵ��֮��Ĺ�ϵ!
	['�ŵ�']
		* Hibernate��JDBC�������ݿ�Ĵ�������˷�װ,���������ݿ���ʲ㷱�����ظ��Դ���
		* Hibernate��һ������JDBC�������־û����,��һ�������ORMʵ��,���ܶ�̶ȵļ���DAO����빤��
		* Hibernateʹ��java�ķ������,�������ֽ�����ǿ����ʵ��͸����
		* Hibernate'��������',��Ϊ����һ�����������.ӳ�������Ժܳ�ɫ,��֧�ֺܶ��ϵ�����ݿ�.��һ��һ,����Զ�.�ĸ��ָ��ӹ�ϵ
	> ĿǰHierbate �Ѿ����µ�5.x�汾!
	> ������Ҫ��3.X!��Ϊ�汾����,��Щ�ط������¼���!�����Hiernate4.x�汾���ϵĻ�,�ڸ�Spring���ϵ�ʱ��,��SpringҲҪ����ߵİ汾!

��������������������������������������������������������
��,�����					|
��������������������������������������������������������
['Ŀ¼�ṹ']
	documentation	 Hibernate�����ĵ�
	lib				 Hibernate����jar��
		bytecode	--> �����ֽ�����ʹ�õ�һ��jar��
		jpa			--> Hibernate��ʵ��JPA�Ĺ淶��һ��jar��
		optional	--> ��ѡjar��
		required	--> ����jarg��,����
	project			���Թ���
	hibernate3.jar	����jar��

	> �����ⶫ��ҲҪ�Ҹ���˵�Ļ�,�е���ѹ������
	> ��������jar��
		* hibernate3
		* requiredĿ¼�µ�����jar��
		* jpaĿ¼�µ�����jar��
		* ���ݿ�����


��������������������������������������������������������
��,����Լ��					|
��������������������������������������������������������
	> ʵ����ӳ���ļ����������ļ�Լ��
		��Hiernate�ĺ��İ����о�ӳ��xml�ļ���dtd�Լ��������ļ���dtd.����,����Լ����OK
	> �������ļ�Լ��
		<!DOCTYPE hibernate-configuration PUBLIC
		"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
		"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
	> ӳ���ļ�Լ��
		<!DOCTYPE hibernate-mapping PUBLIC 
		"-//Hibernate/Hibernate Mapping DTD 3.0//EN"
		"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">

��������������������������������������������������������
��,��Ҫ���յ�֪ʶ��			|
��������������������������������������������������������
	1,��������
		�� JDBCȱ��
		�� Hibernate�ŵ�
		�� ��ѯ
		�� �޸�
		�� ɾ��
		�� ����
		�� ִ�й���
	2, ���沿��
		�� Hibernateһ������
			* get
			* load
			* save
			* update
			* flush
			* evict
			* clear
		�� Hibernate��������
		�� Hibernate��ѯ����
	3, ��ϵ����
		�� һ�Զ൥��
		�� һ�Զ�˫��
		�� ��Զ�˫��
	4, ���ܲ���
		�� �ӳټ���
			> class �ϵ�lazy����
			> �־û��������� final
			> ���÷���,��ʼ���������Hibernate.initialize(Object);
			> �༶���ӳ�,�������Լ����ӳ�(ӳ���ļ�,��Ӧ��ǩ��������)
		�� ץȡ����
			> <set> <many-to-one>
			> fetch   lazy
	5,HQL
		�� createQuery();
		* ������ѯ
		* ��ҳ��ѯ
		* �ۺϺ�����ѯ
	5,QBC
		�� createCriteria();
		* ������ѯ
		* ��ҳ��ѯ
	7,SQL
		�� createSQLQuery();

��������������������������������������������������������
��,Hello World				|
��������������������������������������������������������
	1,�����
	2,�����ļ��Լ�ӳ���ļ�
	3,ͨ�� Configuration ��������ȡ�����ļ�
		Configuration cfg =  new Configuration();
		cfg.configure();
	3,��ȡSessionFactory��������
		SessionFactroy sessionFactory = cfg.buildSessionFactory();
	5,ͨ��SessionFactroy��ȡSession���Ӷ���
		Session session = sessionFactory.openSession();
	6,��������
		Transaction ts = session.beginTransaction();
	7,ִ���߼�����
	8,�ύ����
		ts.commit();
	9,�ر�Session
		session.close();
	

['��������']
	//������ȡ�����ļ��Ķ���
	Configuration cfg = new Configuration();
	//��ȡ�����ļ�
	cfg.configure();
	//��ȡSession������
	SessionFactory sessionFactory = cfg.buildSessionFactory();
	//�ӹ������л�ȡһ��Session����
	Session session = sessionFactory.openSession();
	//��������
	Transaction ts = session.beginTransaction();

	//�߼�����

	//�ύ����
	ts.commit();
	//�ر�Session����
	session.close();
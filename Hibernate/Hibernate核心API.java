��������������������������������������������������������
	Hibernate ����API		|
��������������������������������������������������������
	Configuration
	SessionFactory
	Session
	Transaction
	Query
	Criteria

��������������������������������������������������������
һ,Configuration ���Ķ���	|
��������������������������������������������������������
	* ǧ��Ҫע��,JAVASE��API��Ҳ��һ������� Configuration 
	* ������ʹ�õ��� Hibernate�� Configuration.ǧ��𵼴��
	* org.hibernate.cfg.Configuration;

	> ���������Hibernate�е���Щ������Ϣ
		* ����hiberante.cfg.xml�Լ�hibernate.properties
		* ���س־û��������ݰ���ӳ���ϵ(*.hbm.xml)

	> ���� Configuration �����ַ�ʽ
		* Configuration cfg = new Configuration();
			���ַ�ʽ,����Ĭ�ϼ�����:hibernate.properties���������ļ�,��ô���ӳ���ļ�,����Ҫͨ�������������
		* Configuration cfg = new Configuration().configure();
			���ַ�ʽ,���Ǽ�����xml���������ļ�,�����ļ���ӳ��.��ô�Ͳ����ֶ�����Ӵ���
			Ҳ���Ը�configure����ָ��·������,Ҳ����˵.���ĵ�xml�����ļ�,���Զ�������

	['���÷���']	
	configure();						//���غ��ĵ������ļ�:hibernate.cfg.xml
	addClass(Class clazz);				//����ָ������,ȥ���ض�Ӧ��ӳ���ļ�(Ҫ��ӳ���ļ����Ϲ涨,�Ҹ�����ͬһ������)
	addResource(String resourceName);	//����ָ��·����ӳ���ļ�
	buildSessionFactory();				//����SessionFactory����
	setProperty("name","value");		//���ֶ������ǲ��������ļ�,ͨ��������������ص�����,����һ�㲻��.Ӳ����!�������ݿ���˻�����д����?

��������������������������������������������������������
��,SessionFactory ���Ķ���	|
��������������������������������������������������������
	* SesionFactory�� Configuration ������ݵ�ǰ������Ϣ���ɵ�.
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	* �������˵�ǰ���ݿ�������Ϣ,������ӳ���ϵ�Լ�Ԥ�����SQL���
	* �����̰߳�ȫ��
	* ��������ά��Hibernate�Ķ�������(�������)
	* ����SessionFactory��������Դ,һ�����!һ��Ӧ��,ֻ��ʼ��һ������
	* �ڲ�����һ�����ӳ�,Ĭ�ϵ���Hibernate�Դ������ӳ�,���ǿ��Ի���c3p0��... ...
	* �����𴴽�Session����,��ʵ�Ϳ������Ϊһ��: Connection

	['���÷���']
	openSession();						//��һ�������ݵ�����,����Session����	(�������ΪConnection)	
	getCurrentSession();				//��ȡ�뵱ǰ�̰߳󶨵�Session
		* ����֪���������������,����Ҫ�ң�ʹ�������Ҫ���������ļ������ã�
		* <property name="current_session_context_class">thread</property>
		* ����߳�û�а�,��ôִ�������������һ���µĲ��ҷ���!
	close();							//�ر����ӳ�,ûɶ�ý���

��������������������������������������������������������
��,Session		 ���Ķ���	|
��������������������������������������������������������
	* Session�൱��JDBC�е�Connection
	* Session��Ӧ�ó��������ݿ�֮�佻��������һ�����̶߳���!��Hibernate����������
	* Session���̲߳���ȫ��
	* ���г־û����󶼱�����Session�Ĺ���ſ��Խ��г־û�����
	* Session������һ��һ������,��ʾִ��flush֮ǰ,���еĳ־û���������,��������session����!
	* �־û�����Session��������,�����˳־û�������
	* Session��ͨ��SessionFactory�õ�
		Session = sessionFactory.openSession();

	['���÷���']

	* ��������ķ���
		persist();						//��ʵ��saveһ��,����.������jpa�ṩ��.Hibernateʵ����jpa�ӿ�,ʵ��������淶��һ��ʵ����
		save(Object);					//insert into ...�᷵��һ��:Serializable ,���Ǳ���������¼��ID
		update(Object);					//update...
		delete(Object);					//delete...
		saveOrUpdate(Object);			//������߸���,�����ھͱ���,���ھ͸���
		close();						//�ر�����,�������ͷ���Դ.���ǰ���Դ���������ӳ�
		clear();						//���Session���б���Ķ���
		evict(Object);					//��ָ���Ķ����Session�����
	* ��ѯ�ķ���
		get(Class,id);					//select....,Class���Ƿ��ص�ʵ������������,id,һ�㶼�����ݿ��е�����,��ʵ������������
		load(Class ,id);				//ͬ��,ֻ��load�����ӳټ���,�������	
		createQuery(hql);				//HQL��ѯ,����һ��HQL��ѯ����(Query),����Ǹ�����������ķ��������ɲ�ͬ���ݵ�SQL���
		createSQLQuery();				//SQL��ѯ,����һ��SQL��ѯ����(SQLQuery),���������������ʵ
		createCriteria(Class);			//QBC��ѯ,
	* ��������ķ���
		beginTransaction();				//��ʼ����,���ҷ���һ���������
		getTransaction();				//��ȡ��ǰSession�������������

	['ע��']
		get��load������
		1,����SQL��ѯ����ʱ��
			* get :��ִ��session.get();��ʱ������ִ�в�ѯ.
			* load:��������һ������.lazy�ӳټ���(������),��ʹ������������Ե�ʱ��(����������),�Ż�ȥ����SQL����ѯ
		2,���صĶ���
			* get :���ص���һ����ʵ�Ķ���
			* load:���ص���һ���������(javassist-x.xx.x.GA.jar��������ɵ�),Ҳ����˵Ҫ��ʵ��������.javaBean������final��!
		3,����ѯ�����Ҳ�����ʱ��
			* get :����һ�� null ,�����׳��쳣!������ʹ�� null ,�Ϳ϶���ָ����!
			* load:���׳��쳣(ObjectNotFoundException)
	
��������������������������������������������������������
��,Transaction	���Ķ���	|
��������������������������������������������������������
	* Transaction,�������ݿ�������������,���ڹ�������
	* Transaction tx = session.beginTransaction();
	
	['���÷���']
	commit();							//�ύ����
	rollback();							//�ع�����
	wasCommitted();						//����booleanֵ,��������Ƿ��ύ
	wasRolledBack();					//����booleanֵ,��������Ƿ�ع�
	['ע��']
	���û�п�������,��ôSession��ÿ������,���൱��һ������


��������������������������������������������������������
��,Query ���Ķ���			|
��������������������������������������������������������
	* Query	���������������Hibernate����
	* Session.createQuery(String HQL);����һ��HQL���,����һ�� Query ����
	* HQL(Hibernate Query Language),�﷨����SQL�﷨,����������������
	* ʹ�� Query ����Ĳ���
		1,���Hibernate Session����
		2,��дHQL���
		3,����session.createQuery(HQL)������ѯ����
		4,���HQL����������
			setXXX(int index,value);	//��ָ��λ�õ�?����ָ�����͵ĸ�ֵ
		5,����Query�����list,����uniqueResult();ִ�в�ѯ
			list();						//�õ�һ�����ϵĽ��
			uniqueResult();				//�õ�һ��Ψһ�Ľ��,���û�н������null,�������ж��,ֱ�����쳣!����֪�������ĸ�
	* Query ��������������,���ڿ��Ʒ��ؽ��
		setFirstResult(int firstResult);//���÷��ؽ���ӵڼ�����ʼ(�ӵڼ�����ʼ)
		setMaxResults(int maxResults);	//���ñ��η��ؽ����¼����(Ҫ��������¼)
		* �ⶫ�����Ƿ�ҳ,��ܻ��Զ������Ǵ���limit(select * from tbname limit 0,15;)

	['demo']
	��������ѯ����
		Query query = session.createQuery("from Customer");
			* Ҫע�����,�����"Customer"!��һ������,���Ǳ���!����д��:com.kevin.domian.Customer
		List<Customer> list = query.list();
			* �������ľ���һ List ����,���Խ��б���
	��������ѯ����
		Query query = session.createQuery("from Customer where name=?");
			* Ҫע�����,�����"Customer"!��һ������,���Ǳ���!����д��:com.kevin.domian.Customer
		query.setParameter(0,"kevin");
			* �Ե�һ��?�Ž��и�ֵ(�±��0��ʼ)!��ʵ������������һ�ַ�ʽ.��HQL���������,ͨ����������ֵ,�����пɶ���!where name=:ddd ��ֵ!query.setString("ddd","Kevin");
		List<Customer> list = query.list();
			* �������ľ���һ List ����,�����˶�Ӧ���е����� name ����Ϊ Kevin �ļ�¼.���Խ��б���
	��ҳ��ѯ
		Query query = session.createQuery("from Customer");

��������������������������������������������������������
��,Criteria	���Ķ���		|
��������������������������������������������������������
	* ����һ��������ѯ�Ľӿ�(���� Query ��һ���ӽӿ�)
		> �������ǵ������������,�жϱ����ݵ��ֶ��Ƿ�Ϊnull,��Ϊnull!��ƴ���ַ���!�ﵽģ����ѯ��Ч��
	* Criteria criteria = session.createCriteria(Class clazz);
	* ʹ��Criteria������
		1,���Hiernate��Session����
		2,ͨ��Sesison���Criteria����
		3,ʹ��Restrictions�ľ�̬��������Criterion��������
		4,��Criteria���������Criterion��ѯ����
		5,ִ��Criterite��list()����uniqueResult();��ȡ���
	* ��Ҳ������������,�������ڷ�ҳ
		setFirstResult(int firstResult);//���÷��ؽ���ӵڼ�����ʼ(�ӵڼ�����ʼ)
		setMaxResults(int maxResults);	//���ñ��η��ؽ����¼����(Ҫ��������¼)
		* �ⶫ�����Ƿ�ҳ,��ܻ��Զ������Ǵ���limit(select * from tbname limit 0,15;)

	['demo']
		��������ѯ����
		Criteria c = session.createCriteria(Customer.class);
		List<Customer> list = c.list();
		��������ѯ����
		Criteria c = session.createCriteria(Customer.class);
		c.add(Restrictions.eq("name","Keviin"));	
			* ���ѿ���,ִ�����������ʱ��͸���ѯ���������.����ӷ�ʽ����һ����ľ�̬����.
			* eq����,��ʾ=,��һ�����������ֶ���,�ڶ����������Ǿ����ֵ 
		c.add(Restrictions.isNull("�ֶ���"));
			* isNull ������ʾ.ָ�����ֶ��ǿյ�
		List<Customer> list = c.list();

		['���õ���������']
		add(Restrictions.��������());
		... ...�Լ�����ȥ���,�ҵ�ȷ������!

		
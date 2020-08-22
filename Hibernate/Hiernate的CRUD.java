������
	Configuration cfg = new Configuration();
	cfg.configure();
	SessionFactory sessionFactory = cfg.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction ts = session.beginTransaction();

	//�߼�����

	ts.commit();
	session.close();



��������������������������������������������������������
һ,Hiernate�Ĳ�ѯ������¼	|
��������������������������������������������������������
	* ��ѯ����Ҫ�������� 

	session.get(Class, id);
	session.load(Class, id);
	> get��load������
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
��,Hiernate�Ĳ�ѯ������¼	|
��������������������������������������������������������
		* ��ѯ����Ҫ�������� 

	HQL��ѯ --> Hiernate QueryLanguage
		['��������ѯ����']
		Query query = session.createQuery("from Customer");
			* Ҫע�����,�����"Customer"!��һ������,���Ǳ���!����д��:com.kevin.domian.Customer
		List<Customer> list = query.list();
			* �������ľ���һ List ����,���Խ��б���
		['��������ѯ����']
		Query query = session.createQuery("from Customer where name=?");
			* Ҫע�����,�����"Customer"!��һ������,���Ǳ���!����д��:com.kevin.domian.Customer
		query.setString(0,"kevin");
			* �Ե�һ��?�Ž��и�ֵ!��ʵ������������һ�ַ�ʽ.��HQL���������,ͨ����������ֵ,�����пɶ���!where name=:ddd ��ֵ!query.setString("ddd","Kevin");
		List<Customer> list = query.list();
			* �������ľ���һ List ����,�����˶�Ӧ���е����� name ����Ϊ Kevin �ļ�¼.���Խ��б���
	QBC��ѯ
		['��������ѯ����']
		Criteria c = session.createCriteria(Customer.class);
		List<Customer> list = c.list();
		['��������ѯ����']
		Criteria c = session.createCriteria(Customer.class);
		c.add(Restrictions.eq("name","Keviin"));	
			* ���ѿ���,ִ�����������ʱ��͸���ѯ���������.����ӷ�ʽ����һ����ľ�̬����.
			* eq����,��ʾ=,��һ�����������ֶ���,�ڶ����������Ǿ����ֵ 
		c.add(Restrictions.isNull("�ֶ���"));
			* isNull ������ʾ.ָ�����ֶ��ǿյ�
		List<Customer> list = c.list();
	SQL��ѯ
		['��������ѯ����']
		SQLQuery sql = session.createSQLQuery("SELECT * FROM customer");
			* ֱ��дsql���,Ҫע�������Ǳ�����,��������.���������˾���SQL���
		List<Object[]> list = sql.list();
			* ���ص���һ��Object������,�����ÿһ������,����һ����¼
		['��������ѯ����']
		SQLQuery sql = session.createSQLQuery("SELECT * FROM customer");
		sql.addEntity(Customer.class);
			* ������Ψһ��ͬ�ľ���,�����������!��ʵ����SQL��ѯ��ʽҲ����ֱ�ӷ��ض���!ֻҪ���������ʽ���þͺ�
		List<Customer> list = sql.list();
			* ��ô���صĽ�����Ͳ�����Object������,����ָ���Ķ���
		
		
	
��������������������������������������������������������
��,Hiernate���޸�			|
��������������������������������������������������������
	session.update(Object obj);
	> �޸ļ�¼�����ַ�ʽ���Խ����޸�
		1,�ֶ���������ķ�ʽ
			* �ֶ��Ĵ���һ������,���������ݿ��еļ�¼��Ӧ!Ȼ�󴫵ݸ�update();ִ���޸�,��ô���ݿ��еļ�¼�ͻᱻ�޸ĳɸ������Լ������Ķ��������
			* �����޸ķ�ʽ,������ݿ��ж�Ӧ��¼�������ֶζ�����Ϊ new ��������������������!��ô�����ֻ�Ǹ���ĳһ���ֶεĻ�,���ַ�ʽ���Ե��ر𲻷���!�����п���������ֵ,���������ݿ���ֶεĴ���!
		2,�Ȳ�ѯ,���޸�(�Ƽ�����)
			* ��get();����Ҫ�޸ĵĶ���!Ȼ��ֱ�Ӷ������������޸�!Ҳ�ǿ����޸ĵ����ݿ��
			* ��������SQL��������.��select ,���������϶����,�ֻ�ִ��update���!

 ��������������������������������������������������������
��,Hiernate��ɾ��			 |
����������������������������������������������������������
	����ɾ��,Ҳ�����ַ���
	1,�Ȳ�ѯ,��ɾ��	['�Ƽ�']
			session.delete(session.get(Class,id));
	2,�Լ���������,�Ѷ��󴫵ݽ�ȥ����ɾ��
			session.delete(Object obj);

	> ��ʵ���Ǹ���obj������,ȥɾ����Ӧ���ָ����¼!�������obj,������Լ�������������ֵ!Ҳ���Դ����ݿ��ѯ����!
	> '����'��������ʱ��,��Ҫע��һЩ����.����:����ɾ��֮���!
	* ���������þ�ʹ�õ�һ��,�ȴ����ݿ��в�ѯ����!��ô�������Ķ���!���Ѿ��߱��˹�����ϵ�Ķ���(���溬����������,����֮���)!
	* ��ʱִ��ɾ��,�ͻἶ��ɾ��.��������Լ�����...����ļ���,���󰡶��ǿյ�!���ݿ�Ҳ��!


������������������������������������������������
Hibernate������ʽ		|
������������������������������������������������
	* Hibernate�ṩ�����ַ�ʽ�����в�ѯ
	1,��������ͼ������ʽ
		* �����Ѿ����صĶ��󵼺�����������
	2,OID������ʽ
		* ���ݶ����OID,Ҳ����Ψһ��ʶ���������м���
	3,HQL������ʽ
		* ʹ����������HQL��ѯ����
	4,QBC������ʽ
		* ʹ��QBC(Query By Criteria)API����������,����API��װ�˻����ַ�����ʽ�Ĳ�ѯ���,�ṩ�˸����������Ĳ�ѯ�ӿ�
	5,����SQL������ʽ
		* ʹ�ñ������ݿ��SQL��ѯ���
	
������������������������������������������������
��������ͼ����			|
������������������������������������������������
	Customer c = (Customer)session.get(Customer.class,"123");
	Set<Order> orders = c.getOrders();
	for(Order order : orders)
	{
		System.out.println(order);	//���ݶ���,����������
	}

������������������������������������������������
OID������ʽ				|
������������������������������������������������
	* ʹ��get/load,����OID�����м���.
	* ����get/load������,���ﲻ��׸��

������������������������������������������������
HQL������ʽ				|
������������������������������������������������
	* HQL(Hibernate Query Language),��������ѯ����.����SQL��ѯ������Щ����,��Hiberante����ʹ����㷺��һ�ֲ�ѯ����.
	* HLQ���,֧��ʹ��'?'�ʺ�ռλ��,Ҳ֧��':id',����ռλ��.ʹ���ʺ�,����Ҫ����˳����и�ֵ.����Ǳ���.�ɶ��ԱȽ�ǿ,������˳��.�Ƽ�ʹ��
	* HQL��֧��SQL��"SELECT *..",д��.������ʹ��'*'��,����ʹ��������ķ�ʽ����,as �ؼ��ֿ���ʡ��,Ϊ�˿ɶ���,������
	* ֧�ֱ���
		* "SELECT customer FROM com.kevin.domain.Customer as customer WHERE customer.id=:id"
	* HQL֧�ָ�������
		* =,<>,>=,<=,is null,is not null
		* in,not in,between,not between
	* HQL֧�����µļ�����ʽ

	1,��ѯ��������ø��ֲ�ѯ����
		Query query = session.createQuery("FROM com.kevin.domain.Customer WHERE id=:id");
		query.setParameter("id","302A8E12E9C44B0BB7BBBE27CBD22D93");
		Customer c = (Customer) query.uniqueResult();

	2,ͶӰ��ѯ,Ҳ���ǽ�������������Ĳ�������
		* ��Ҫʹ��'SELECT'���.ָ����Ҫ��ѯ�������ֶ�.��ѯ����ÿ�����ݶ���װ�� Object[] ������.
		String hql = "SELECT customer.name,customer.age FROM com.kevin.domain.Customer as customer";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();		//ÿһ��Object[],���ǲ�ѯ����һ����¼.��Ȼ,Ҳ���������������ʾ��ѯ�Ľ��
		* ��ͶӰ��ѯ�����װ������,����ͱȽϺ���,�ҳ����������.ֱ����HQL�����,��� new ���.
		String hql = "SELECT new com.kevin.domain.Customer(id,name) FROM com.kevin.domain.Customer as customer WHERE customer.id=:id";	
		//��HQL���,�ǲ����е��?Ҫע�����,���б���Ҫ�ṩ��Ӧ�Ĺ��캯��.��Ȼ�׳��쳣.Ҳ���Բ����WHERE���,��ѯ������List��������ж���,Ҳ����HQL��ָ��������.
		Query query = session.createQuery(hql);
		query.setParameter("id","4EF777D506D94417B24FC3CFB0AE4B9F");
		Customer c = (Customer) query.uniqueResult();
		
	3,�Բ�ѯ�����������
		* ֱ�Ӱ�ORDER BY���д��HQL��� 
		String hql = "SELECT customer FROM com.kevin.domain.Customer as customer ORDER BY customer.age DESC";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();

	3,��ҳ��ѯ
		* ʹ������������ȷ��Ҫ��ѯ������
		String hql = "SELECT customer FROM com.kevin.domain.Customer as customer";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);			//���ò�ѯ���ݵĿ�ʼ��
		query.setMaxResults(2);				//���ò�ѯ����������
		List<Customer> list = query.list();

	4,������������
		String hql = "SELECT customer FROM com.kevin.domain.Customer as customer WHERE customer.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id","6008C15C8A464B989554F74B552805A5");
		Customer c = (Customer) query.uniqueResult();	//uniqueResult�������᷵�ص�������,�����ѯ������ڶ��,��ô�׳��쳣
	
	4,���Ӳ�ѯ
		* ������
			//��ѯ����������Ľ�������
			String hql = "SELECT customer FROM com.kevin.domain.Customer as customer INNER JOIN customer.orders";		//��������˼άȥдHQL���
			Query query = session.createQuery(hql);
			List<Customer> list = query.list();
		* ����������
			//���һ���ؼ���:fetch,�ùؼ��ֽ���HQL�������ʹ��.SQL���沢���߱�
			String hql = "SELECT customer FROM com.kevin.domain.Customer as customer INNER JOIN FETCH customer.orders";
			Query query = session.createQuery(hql);
			List<Customer> list = query.list();
			* ����������,�������Ӳ�ѯ�����Ľ������һ����.
			* ������:�����ݷ�װ��һ�� List<Object[]>.����������:�����ݷ�װ��һ�� List<Customer>��,���������ӵõ��Ľ��,�������ظ���¼,��Ҫȥ�ز���.

		* ��ʽ������
			//������ͨ�ļ�һ��WHERE�ؼ���,ȥ�ѿ�����.
		* ��������
		* ������������
		* ��������
		* ��������
		//��SQLһ��,���ǲ�ѯ�����.ȡ���ѿ�����.

	5,���ʵ��������в�ѯ
		* �����������ķ�ʽ,�����в�ѯ,���ݵĲ���.����һ������
		//�½�һ���й�״̬��Customer����,������ҪΨһ��IODֵ.
		Customer customer = new Customer();						
		customer.setId("302A8E12E9C44B0BB7BBBE27CBD22D93");
		String hql = "SELECT order FROM com.kevin.domain.Order as order WHERE order.customer=:customer";
		//��HQL���,���������,����:order�����customer����=:customer
		Query query = session.createQuery(hql);
		query.setEntity("customer",customer);			//ͨ���˷���,��ָ��������ӵ�ռλ��,ͬ��,Ҳ����ʹ��'?',ռλ��
		List<com.kevin.domain.Order> list = query.list();

	5,�����ѯ,����ʹ�� HAVING��GROUP BY�ؼ���
	6,�ṩ���þۼ�����,��sum(),min()��max()
		//count(),����
		String hql = "SELECT COUNT(*) FROM com.kevin.domain.Customer";
		Query query = session.createQuery(hql);
		Long count = (Long) query.uniqueResult();		//ע��,����ֵ��һ�� long,����int!
		//MAX()����
		String hql = "SELECT MAX(customer.age) FROM com.kevin.domain.Customer as customer";
		Query query = session.createQuery(hql);		
		Integer count = (Integer) query.uniqueResult();	//��ѯ����������ɶ,���ص����ݾ���ɶ.

	7,������ѯ
		* ��ʵ,���ǰ�SQL/HQL���д����ӳ���ļ���
		<query name="findAll">			//<query>��ǩ,����HQL���,<sql-query>��ǩ,��SQL���
			SELECT customer FROM com.kevin.domain.Customer as customer
		</query>
		* �ڳ�����,ֻ��Ҫ����ָ�����Ƶ�HQL/SQL��伴��
		Query query = session.getNamedQuery("findAll");
		List<Customer> list = query.list();

	7,�ܹ�����,�û��Զ����SQL�������߱�׼��SQL����
	8,֧���Ӳ�ѯ
	9,֧�ֶ�̬�ΰ�
	10,��̬����
		* û̫������,����Ҫ֪��֧������д��
		* ��ʵ���Ǽ�����,ָ��������,�Լ�����.ǰ��϶����Ѿ���ӳ�䵽�˿�ܵ�������
		//��ѯ���е�ʵ��,�Լ�������
		Query query = session.createQuery("FROM com.kevin.domain.Customer");
		//��ѯ������ʵ����Serializable�ӿڵ�ʵ��
		Query query = session.createQuery("FROM java.io.Serialozable");
		//��ѯ�����еĳ־û�����
		Query query = session.createQuery("FROM java.lang.Object");

	11,����������ѯ
		* ��WEB��,����һ��:�����ò�ѯ������,DetachedCriteria����.���ݸ�service --> dao��.
		* dao,��ֱ�ӾͿ��Բ����ö���
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);	//��������
		criteria.add(Restrictions.like("name","%Kevin%"));						//�ṩ����
		criteria.add(Restrictions.eq("age",18));								//�ṩ����
		Criteria c = criteria.getExecutableCriteria(session);					//ִ�иö���ķ���,����session��Ϊ�β�,��ȡCriteria����
		List<Customer> list = c.list();											//����Criteria����,��ȡ���
		* ��ʵ����,�ڽ��и߼���ѯ��ʱ��.�ͻ����ṩ��һЩ��ѯ����,���޷���װ��JavaBean�е�(Ҳ��JavaBeanδ�ṩ��Щ�ֶ�)
		* ��ô������Ҫ��д��װ,���߷ֱ𴫵ݸ�dao��,�����жϺͲ���.�Ƚ��鷳,�Ϳ���ʹ���������߲�ѯ.ֱ��WEB��,��װһ��������ѯ�Ķ���.���ݸ�DAO�����ִ��

������������������������������������������������
QBC������ʽ				|
������������������������������������������������
	* QBC֧�����²�ѯ��ʽ
	
	1,�Բ�ѯ�����������
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.addOrder(Order.asc("age"));		//ͨ��Order����ľ�̬����ָ������ʽ,����Ҫ��������ֶ�,��Ϊ�βδ���
		List<Customer> list = criteria.list();

	2,��ҳ��ѯ
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setFirstResult(0);		//���ò�ѯ��ʼ��
		criteria.setMaxResults(2);		//���ò�ѯ����������
		List<Customer> list = criteria.list();

	3,������������
		* ʹ�÷�ҳ�޶���ѯ���
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setMaxResults(1);							//Ĭ�ϴ�0��ʼ��ѯ��һ����¼
		Customer c = (Customer) criteria.uniqueResult();	//Ĭ�ϻ�ȡ������ĵ�һ������
		* ʹ�������޶���ѯ���
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("id", "302A8E12E9C44B0BB7BBBE27CBD22D93"));	//Restrictions.eq(p,p);�÷�����ʾ���һ��'����'��ѯ����,��һ��������ʾ����,�ڶ����ֶα�ʾֵ.
		Customer c = (Customer) criteria.uniqueResult();
	
	4,ģ����ѯ
		* �ܼ�,һ����֪��!����Ҫע�����,����Ҫ�ǵ����:%,��Ȼ���ǵ�����!
		Criteria c = session.createCriteria(Customer.class);
		c.add(Restrictions.like("id","%7%"));
		List<Customer> list = c.list();
	
	5,���Ӳ�ѯ
		* ������
		* ����������['��֧��']
		* ��ʽ������['��֧��']
		* ��������
		* ������������
		* ��������	['��֧��']
		* ��������	['��֧��']
	
	6,ͶӰ��ѯ
������������������������������������������������
����SQL������ʽ			|
����������������������������������������������
	* ��ѯ����
		SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM _customer");		//������SQL���
		List<Object[]> list = sqlQuery.list();	//ÿһ��Object[],�е�ÿ������,����һ�������ɢװ����!
		for(Object[] arr : list)
		{
			System.out.println(Arrays.toString(arr));
			//[302A8E12E9C44B0BB7BBBE27CBD22D93, Kevi, 22]
		}
	* �Զ���װ
		SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM _customer");
		sqlQuery.addEntity(Customer.class);		//�ṩһ��Class��,����Զ����䴴������.�Զ��Ľ������ݷ�װ.
		List<Customer> list = sqlQuery.list();
		for(Customer customer : list)
		{
			System.out.println(customer);
			System.out.println(customer.getOrders());	//�Զ��ķ�װʵ��
		}
		

	# �Զ���װ�����
	if(hasEntity){
		//������clazz����Hibernate�������
		query.addEntity(clazz);
	}else{
		//������clazz������Hibernate�������
		query.setResultTransformer(Transformers.aliasToBean(clazz));
	}

������������������������������������������������
��:QBC����,�������		|
����������������������������������������������
		����:
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("id", "302A8E12E9C44B0BB7BBBE27CBD22D93"));
	
		Restrictions.eq("�ֶ�","ֵ");		//����
		Restrictions.allEq();				//����Mapʹ��key/value���ж�����ڵ��ж�
		Restrictions.gt("�ֶ�","ֵ");		//���� >
		Restrictions.ge("�ֶ�","ֵ");		//���ڵ��� >=
		Restrictions.lt("�ֶ�","ֵ");		//С��
		Restrictions.le("�ֶ�","ֵ");		//С�ڵ��� <=
		Restrictions.between();				//��ӦSQL��between�־�
		Restrictions.like("�ֶ�","ֵ");		//like���
		Restrictions.in("�ֶ�","ֵ");		//in���
		Restrictions.and();					//and��ϵ
		Restrictions.or();					//or��ϵ
		Restrictions.sqlRestriction();		//sql�޶���ѯ
		Restrictions.asc("�ֶ�");			//���ݴ�����ֶν�����������
		Restrictions.desc("�ֶ�");			//���ݴ�����ֶν��н�������

		* �������Զ��ڲ���,�п��ܲ���ȷ!ʵ��ʹ�õ�ʱ�����Ȳ�ѯȷ��.
		




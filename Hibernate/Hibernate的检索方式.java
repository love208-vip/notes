��������������������������������������������������������
Hibernat������ʽ			|
��������������������������������������������������������
	> ��ʵ��ν�ļ�����ʽ,����Hibernate�м��ֲ�ѯ��ʽ!
	
	1,��������ͼ������ʽ
		* �����Ѿ����صĶ��󵼺�����������
	2, OID������ʽ
		* ���ݶ����OID����������
		* get(0)/load()
	3,HQL������ʽ
		* ʹ����������HQL��ѯ����
		* session.createQuery(HQL);
	4,QBC������ʽ
		* ʹ��QBC(Query By Criteria)API����������
		* ����API��װ�˻����ַ�����ʽ�Ĳ�ѯ���,�ṩ���������Ĳ�ѯ�ӿ�!
		* session.createCriteria();
	5,����SQL������ʽ
		* ʹ�ñ������ݿ��SQL��ѯ���
		* session.createSQLQuery(SQL);
��������������������������������������������������������
һ,HQL������ʽ				|
��������������������������������������������������������
	> HQL(Hibernate Query Language)���������Ĳ�ѯ����,����SQL��ѯ������Щ����,��Hibernate�ṩ�ĸ��ּ�����ʽ��,HQL��ʹ����㷺��һ�ּ�����ʽ!
	> ������ǿ��Ĺ���
	1,�ڲ�ѯ������趨���ֲ�ѯ����
	2,֧��ͶӰ��ѯ,��:�����������ֶ��������
	3,֧�ַ�ҳ��ѯ 
	4,֧�����Ӳ�ѯ
	5,֧�ַ����ѯ,����ʹ�� having��group by�ؼ���
	6,�ṩ���þۼ�����,�� sum(),min(),max()
	7,�ܹ������û������SQL�������׼ SQL ����
	8,֧���Ӳ�ѯ
	9,֧�ֶ�̬������

	* HQL������ʽ�������²���
		* ͨ��Session��createQuery()��������һ��Query����,������һ��HQL��ѯ���,HQL��ѯ����п��԰�����������
		* ��̬������
		* ����Query��list()����ִ�в�ѯ���,�÷�������java.util.List��Ĳ�ѯ���.��List�����д���˷��ϲ�ѯ�����ĳ־û�����
	* Query�ӿ�֧�ַ�������̷������setXxxx();���صľ��������ʵ��,������void
	* HQL & SQL
		* HQL��ѯ��������������,Hibernate�������HQL��ѯ���,Ȼ����ݶ����ϵӳ���ļ��е�ӳ����Ϣ.��HQL��ѯ��䷭�����Ӧ��SQL���.HQL,��ѯ����е���������ģ���е����Լ��������
		* SQL��ѯ��������ϵ���ݿ��һ���,sql��ѯ����е����������ݿ�ı��Լ�����ֶ�
	ע��:
		QHL,֧��:select * ����д��!������ôд:select c from Customer c;������ķ�ʽ

['��ѯ����']
	Query query = session.createQuery("from ����");
	List<T> list = query.list();
['�������']
	Query quer = session.createQuery("from ���� ���� order by ����.������ ����ʽ");
	List<T> list = query.list();
['��ҳ��ѯ']
	Query query = session.createQuery("from ����");
	query.setFirstResult(0);	//���÷�ҳ,�ӵڼ�����¼��ʼ
	query.setMaxResults(2);		//���÷�ҳ,Ҫ��������
	List<!-- <T> --> list = query.list();
['��ѯ��������']
	//���ض���
	Query query = session.createQuery("from ���� ���� where ����.������=:name");
	query.setParameter("name","Kevin");
	T t = (T)query.uniqueResult();
	//ʹ�þۺϺ���
	Query query = session.createQuery("select count(*) from ����");
	Long count = query.uniqueResult();
['��ѯ��������']
	Query query = session.createQuery("select s.name from Student s");
	List<String> names = query.list();
['��ѯ�������']
	Query query = session.createQuery("select s.name,s.age from Student s");
	List<Object[]> all = query.list();
['���޽�--ֻ���ش���ָ�����ԵĶ���']
	Query query = session.createQuery("select new Student(s.name,s.id) from Student s");
	List<T> list = query.list();		//����һ�����,ֻӵ��HQL��ָ��������!����,ǧ��Ҫ�ṩ��Ӧ�Ĺ��캯��
['�������͵Ĳ���']
	Query query = session.createQuery("from Order o where o.customer=?");
	query.setEntity(new Costomer(��));		//���ݴ��ݽ�ȥ�Ŀͻ���,���ظÿͻ������ж�����
	List<Order> list = query.list();
['��ͨ���͵Ĳ���']
	Query query = session.createQuery("from Order o where o.id=?");
	query.setParameter(0,"10028");	
	List<Order> list = query.list();	//���صĽ��ֻ��һ��,�����滻Ϊ:Object obj = query.uniqueResult();
['���Ӳ�ѯ']
	�����Ӻ����������ӵ�����
	������	  :�����ݷ�װ��һ�� List<Object[]>��
	����������:�����ݷ�װ��һ�� List<Object>��!�����ظ���ֵ!��Ҫ���� distinctȥ���ظ�Ԫ��
['����������ѯ ']
	DetachedCriteria
	��;:��WEB��,���һ�����ߵ� Criteria!
	DetachedCriteria 
��������������������������������������������������������
��,QBC������ʽ				|
��������������������������������������������������������
['��ѯ����']
	Criteria c = session.createCriteria(Class T);
	List<T> list = c.list();
['�������']
	Criteria c = session.createCriteria(Class T);
	c.addOrder(Order.desc("ָ������")); //��ָ���ֶ������������
	c.addOrder(Order.asc("ָ������"));  //��ָ���ֶ������������
	List<T> list = c.list();
['��ҳ��ѯ']
	Criteria c = session.createCriteria(Class T);
	c.setFirstResult(1);	//��ҳ��ʼ���
	c.setMaxResults(5);		//��ҳ������
	List<T> list = c.list();
['��ѯ��������']
	Criteria c = session.createCriteria(Class T);
	c.add(Restrictions.eq("������","����ֵ"));		//����:select * from tb where ������=����ֵ.���صľ��ǵ�������
	T c = (T)c.uniqueResult();
['��������']
	Restrictions.����(ֵ);
	* ������Լ�ȥ��ٶ���,̫����û������!
	* ���ǰ�HQL�еĸ�������,�Ƚ�.�������˷���!���ӵ��������
	* ����:
		   HQL: where id='1005';
	       QBC: add(Restrictions.eq("id","1005"));
		   HQL: where name is null;
		   QBC: add(Restrictions.isNull("name"));
['���Ӳ�ѯ']

	
��������������������������������������������������������
��,SQL���ؼ�����ʽ			|
��������������������������������������������������������
['��ѯ����']
	SQLQuery s = session.createSQLQuery("select * from tb_name");
	List<Object[]> list = s.list();
		* ����Objcet�������͵�List����
	SQLQuery s = session.createSQLQuery("select * from tb_name");
	s.addEntity(Class T);	//����ָ������,�ͻ��Զ���װ
	List<T> list = s.list();
		* ���صľ���ָ�����͵Ķ��󼯺�



��������������������������������������������������������
��,�ɱʼ�					|
��������������������������������������������������������
	Hibernate�ṩ�����¼��ּ�������ķ�ʽ
	1,��������ͼ����:�����Ѿ����صĶ��󵼺��������Ķ���
		> employee.getDeparement().getName();//����Ա��,��ȡ����,�ٻ�ȡ��������!�������������ʵ�������ݿ�����Ĳ�������
	2,OID����:���ݶ����OID����������
		> session.get(),session.load()!!
	3,HQL����:ʹ����������HQL��ѯ����	***
		> �ص�ѧϰ��,���������Hibernate����ı�׼.
	4,QBC����:ʹ��QBC(Query By Criteria)API����������.����APIC��װ�˻����ַ�����ʽ�Ĳ�ѯ���,�ṩ�˸����������Ĳ�ѯ�ӿ�
		> 
	5,����SQL����:ʹ�ñ������ݿ��SQL��ѯ���
		> �ǳ����Ƽ�,��һ��д��ԭʼ�����ݿ����!��ô���޸����ݿ��ʱ��,����Ҫ�޸�Դ��

----------------------HQL
HQL�ص�
1,��SQL����,SQL�е��﷨�����϶�����ֱ��ʹ��
2,SQL��ѯ���Ǳ�ͱ��е���,HQL��ѯ���Ƕ���,������е�����
3,HQL�ؼ���,�����ִ�Сд,����JAVA��������������Ҫ���ִ�Сд!
4,SELECT����ʡ��!
-------------------------------��ѯ(select)
select from Employee
	> ��ѯEmployee���Ӧ�ı�,û�д�����,�Ͳ�������е�,����һ��List<Object>
	* ���Լ�as,Ҳ����˵���Լӱ���(�����Ƹ��ؼ��ֳ�ͻ��ʱ��,�Ϳ���ʹ�ñ���)
select from Employee as e where e.name='Kevin'
	> ����,��������
	* ���ص�Ҳ��һ��List<Object>
select e.name from Employee e
	> ��ѯ����ָ�����ֶ�
	* ���صļ��ϵ�Ԫ������,���������������(�ֶ���String,�Ǿ���List<String>)
select e.name,e.id from Employee e
	> ��ѯ���ָ�����ֶ�
	* ���ص���һ������ļ���!ÿ������,����һ����ѯ�����Ľ��!List<String[]>
select new Employee(e.name,e.id) from Employee e
	> ��ѯ���ָ�����ֶ�
	* ����ͱȽϵ���,���������Ƕ��󼯺�!������Щ����ֻ�����HQL�����ָ�����ֶ�!
	* ע�Ⱑ,ʹ�����ַ���,��ôָ������,Ҫ�з��ϵĹ��췽����!
-------------------------------�޸�(Update)��ɾ��(delete)
�޸�:
	Query q = session.createQuery("update Employee e set e.name=? where e.id=?");
	q.setParameter(0,"demo");
	q.setParameter(1,"CF2F2907E19340629A8424B2E67E4037");
	int x = q.executeUpdate();//���ص��Ǳ�Ӱ�������
ɾ��
	Query q = session.createQuery("delete Employee e where e.id=?");
	q.setParameter(0,"11111");
	int x = q.executeUpdate();
> ��update����delete��,Session��Ҫrefreshˢ��һ�£����ָ����ݿ�ͬ����

-------------------------------����
SQL����
Long count = (Long) session.createQuery("select count(*) from Employee e").uniqueResult();
	> count()��ʾ ����long!	
String count = (String) session.createQuery("select max(id) from Employee e").uniqueResult();
	> max()��ʾ,�����ֶ����ͷ�������һ��!
	* min(),avg(),sun(),һ����,��������ʾ
	* �������������,��ô����Number,�Լ�Ҫ�����������ת��
����
List list = session.createQuery("from Employee e order by e.id").list();
	> ����HQL����м���order by !
�����Ӳ�ѯ
List<Object> list = session.createQuery("select e.id,e.name,d.name from Employee e join e.department d ").list();
	> �ⶫ����mysql�������һ����������join����,���Ǹ��ı���,���Ƕ����һ������!
	* �����ѯ�������,�Լ��������Եı�!����ѯ,�����List<Object[] Object>
�����Ӳ�ѯ(��ȫ�������)
List<Object> list = session.createQuery("select e.id,e.name,e.department.name from Employee e ").list();
	> ������û?e�Ƕ���ı���,e.department.name!!���Ƕ����һ�����Ե����ԣ�ֱ�ӿ��������ַ�ʽ���,���������˼��һ����
	* Ҳ�Ƿ�����һ��List<Object[]>.�����Զ�ȥ����Employee���Ӧ�ı�,�ٲ�ѯEmployee��deparetmen���Զ�Ӧ�ı�,�Ķ�Ӧ��name�ֶ�

-----------------------------ʹ��������ѯ
�ⶫ����, �����ô��⣡�������ڵĽ׶λ���Ҫ��HQL���,д�ڴ����ڣ������Ҫ�޸�,����Ҫȥ�޸�Դ����!������ѯ--���ǰ�HQL���д�������ļ���!�����ڲ��޸�Դ�����������޸�HQL���
1,�ڵ�ǰ�����hbm.xml�������ļ��еĸ�Ԫ���¡����<query>��ǩ
	<query name="queryById">from Employee e where id=:xxx</query>
	* name:�Զ�������,����ľ���HQL���.һ����Ҫ������<hibernate-mapping>��ǩ��,����<class>��ǩ��
	* Ҫע����xml�ļ���,"<",">"��һЩ��QHL����Ҫ�õ��ķ���,��Ҫת�壡
2,�ڻ�ȡQuery��ʱ��,sessionִ�еĲ�����һ��HQL���,����һ��"����".!������ƾʹ�����һ��HQL���
	Query q = session.getNamedQuery("queryById");//����,����hbm.xml��<query>��ǩ��name��������,�Ϳ��Ի�ȡ����Ӧ��HQL���
	Employee e = (Employee) q.setParameter("xxx","CF2F2907E19340629A8424B2E67E4037").uniqueResult();//��xml�е�HQL���ı������и�ֵ

-----------------------------Query��һЩ�������
Query��һЩ�������
	setFirstResult(0);//���÷�ҳ,�ӵڼ�����¼��ʼ
	setMaxResults(2);//���÷�ҳ,Ҫ��������
		> ��:List list = session.createQuery("select from Employee e").setFirstResult(0).setMaxResults(2).list();
	uniqueResult();//��ѯ�Ľ����Ψһ��һ�����,����Object
		* ��������Ψһ,�ж��.���׳��쳣
	setParameter(0,"Kevin");//��ʽ��HQL���,���HQL�е�?ֵ,Ҫע�����,�����һ���Ǵ�0��ʼ!��JDBC�����Ǵ�1��ʼ!
		> Object o = session.createQuery("from Employee where id=?").setParameter(0,"Kevin").uniqueResult();
	setParameter("xxx",""Kevin);//���ַ�ʽ,�Ǹ��������Ƹ�ֵ,���Ǹ��ʺ���,���������������
		> Object o = session.createQuery("from Employee where name=:xxx").setParameter("xxx","Kevin").uniqueResult();
		* ����ʹ��":xxx"���ַ�ʽ��δ֪�������и�ֵ,��ô�����õ�ʱ��,�Ϳ��Բ�����˳��Ľ��и�ֵ��!ֻҪ�������ƶ��Ͼͺ�.ע���ʽ--:xxx
	setParameterList("xxx",Object[]);//��һЩ���ϻ��õ�,��Object[]�����ֵ��������xxx��.Ҳ����˵,HQL����е�xxx��һ�������͵Ĳ���
		> List list = session.createQuery("from Employee e where id in(:ids)").setParameterList("ids",new Object[]{"E6A66CB9530D4B45AF55914DAEC3897D","CF2F2907E19340629A8424B2E67E4037"}).list();
		* :ids����Ȼ���Ƕ������,����д�ʺŻ��߱������ɣ����ջ𣡾Ϳ������������!
	setEntity();
		> �Ѳ�����һ���־û����
		* List list = session.createQuery("from Order o where o.customer=?").setEntity(new Costomer(��)).list();
		* ����������һ���ͻ���!�����ѯ�����ĵ�ʱ��,ֱ�ӿ��԰Ѵ���һ���ͻ��Ķ�������HQL���!���ܷ��ظÿͻ���Ӧ�����ж���!
	executeUpdate();
		> ִ�е���update������delete���,���ص���һ��intֵ,����Ӱ�������
		* Ҫ��session.createQuery(HQL);�����HQL��һ��update/delete���!


-----------------------------ʹ��QBC(Query By Criteria)��ѯ
> һ���Ͷ�
	Criteria c = session.createCriteria(Employee.class);//������һ��Class����,�����Զ���ȥѰ��ƥ���xml,�ļ��ҵ�ƥ������ݿ��
> ���ӹ�������
	c.add(Restrictions.ge("id",1));
		> Restrictions��һ����,�����кܶ�ľ�̬�������ڹ��˲�ѯ���,�����ʾ����id>1
	c.add(Restrictions.le("id",5));
		> Restrictions��һ����,�����кܶ�ľ�̬�������ڹ��˲�ѯ���,�����ʾ����id<5
> ������������
	c.addOrder(Order.desc("id"));
		> Order��һ����,�����кܶྲ̬������������,�����ʾ���ǰ���id�ֶ���������
	c.addOrder(Order.desc("name"));
		> Order��һ����,�����кܶྲ̬������������,�����ʾ���ǰ���name�ֶν�������
> ִ�в�ѯ
	c.setFirstResult(1);	//��ҳ��ʼ���
	c.setMaxResults(5);	//��ҳ������
	c.uniqueResult();	//Ψһ���
	c.list();		//���ص��ǽ������
	c.iterate();		//���ص���һ��������Iterator
	setCacheable(boolean)	//�Ƿ񻺴�


---------------
֪ʶС��		|
---------------
HQL
��̬��ѯ(��ѯĳ���������... ...�ڱ��ж�Ӧ�����м�¼)
������ѯ
���췽��("from new xxx(zzz,ccc) where id=xxx")
ͶӰ��ѯ(ֻ��ѯ�����ĳЩ����,)
������ѯ(�������ļ���,����HQL���,��Session�е���)
����ѯ
	��������
	������
	����������
	��������		��������������
	������������	���������Ƕ���
QBC
�򵥲�ѯ
�����ѯ
������ѯ
��ҳ��ѯ
����������ѯ
SQL
�������������� List<Object[]>
addEntity(Object);//����ת��Ϊ����
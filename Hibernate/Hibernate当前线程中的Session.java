��������������������������������������������������������
һ,Hibernat��ǰ�̵߳�Session|
��������������������������������������������������������
	> ����ͨ������Service��ο���,����Session��DAO��!����Ŀ�������Session��������!
	
	getCurrentSession();				//��ȡ�뵱ǰ�̰߳󶨵�Session
		* ʹ�������Ҫ���������ļ������ã�
		* <property name="current_session_context_class">thread</property>
		* ����߳�û�а�,��ôִ�������������һ���µĲ��ҷ���!

	�����Hibernate�����ļ���
	current_session_context_class����������Ϊ:thread
	��ôHibernate�ͻᰴ���뱾���̰߳󶨵ķ�ʽ������Session

	Hibernate��һ�¹����Session�뱾���̰߳�
	* ��һ���̵߳�һ�ε���SessionFactory�����getCurrentSession()��ʱ��,�÷����ᴴ��һ���µ�Session����
	  �Ѹö������̰߳�,���ҷ������Session
	 
	* ���ٴε���SessionFactoy��getCurrentSession()��ʱ��,�ͷ�������Ѿ��󶨵�Session

	* �������ύ��ʱ��,Hibernate���Զ�����Session����Ļ���,Ȼ���ύ����!���ҹر�Session,�����������������ʱ��,Ҳ���Զ��ر�Session

	* ����ٴε���SessionFactory��getCurrentSession()��ʱ��,�ֻᴴ��һ���µ�Session���̰߳�,���ҷ���! 

��������������������������������������������������������
��,Session�Ĺ���			|
��������������������������������������������������������
	�����ó�����������Session�������������,Ҳ�ǿ��е�!����ʵ�ʵ�Ӧ���аѹ���Session������������ڽ���Hibernate����,���Լ�javaӦ�ó�����������ܹ�

	Hibernate3�����ṩ�����ֹ���Session����ķ���

		1,session ��������������뱾���̰߳�
		2,session ���������������JTA�����
		3,Hibernate ί�г������Session �������������

	��Hibernate�������ļ���
		current_session_context_class��������ָ��Session�Ĺ���ʽ
	
	thread: Session��������������뱾���̰߳�
	jta*  : Session����������������JTA�����
	managed: Hibernateί�г���������Session�������������

	'ע��'
		�󶨵�ǰ�߳��е�Session����Ҫ�ر�.�̻߳�������Զ��Ĺر�!��Ȼ�ᱨ��!
��������������������������������������������������������
��,�ɱʼ�	(����)			|
��������������������������������������������������������
��Ӧ�ó�����ʹ��Session�Ĺ�����

һ��ҵ�����,��һ������,һ������,һ������!һ������Ҳ���ǵ���һ��ҵ�񷽷�!

������,�ᵽҵ���!����,�����������ֱ�ӰѴ�����ȥ!�־ò�Ĵ��벻�ܳ�����ҵ���!
-------------------------------���ַ��������,��û��ѧ�ᶯ̬����֮ǰ.���������!�����˴�ϣ����ʦ������Ӵ!TxQueryRunner....
//������
class Utils
{
	public  static final ThreadLocal<Session> threadLoacl = new ThreadLocal<Session>();
}
//������
class MyFilter implements Fileter
{
	public void doFilter(request,response,chain)
	{
		Session session = sessionFactory.openSession();
		Utils.threadLoacl.set(session);//��Session�����߳�����,�󶨵���ǰ�߳�
		try
		{	session.beginTransaction();	//��������
			chain.doFilter();		//����
			session.getTransaction().commit();//�ύ����
		}
		catch(Exception e)
		{
			session.getTransaction().rollback();	//�쳣����,����ع�
			thorw new RuntimeException(e);
		}
		finally
		{
			session.close();
			Utils.threadLoacl.remove();//�Ƴ���ǰ�߳��е�Session,�����
		}
	}
}

//��ôDAO�еĴ������:
public class UserDao
{
	public void saveUser(User user)
	{
		Session sessiom = Utils.threadLoacl.get();//���߳������л�ȡ��ǰ�̵߳�Session����
		session.save(user);
	}
}
�ܽ�:ʹ��ThreadLocal����,ʹ�õ�ǰ�߳�����ΪKey,�����Ļ���֤�˲��������İ�ȫ,�Լ���������DAO�е�Session��ͬһ��!
-------------------------------------���ַ���,����,��������Hibernate��API�����!
//��ȡ��ǰ�󶨵�Session
Session session = sessionFactory.currentSession();
	> ��Ҫ�������õ�xml�ļ������,��Ȼ�ᱨ��
	> <property name="current_session_context_class">thread</property>
����:ȥָ������������(���߳�Thread),���Ұ󶨵�Session����,����оͷ���,���û�оʹ���һ�����󶨺��ٷ���
> ���������ļ��е�thread,���Ӧ�ö���!
> oppenSession(),ֻ�ǿ���һ���µ�Session,�������󶨺Ͳ��Ҳ���!
> �ύ����/�ع���,�����Զ��Ĺر�Session,�Ƴ����̵߳İ�,����ʹ�����������ʱ��,�������Լ��ر�Session,�ᱨ��!�����Ѿ�����ر���,���ָ���һ��!

			Session session1 = sessionFactory.getCurrentSession();
			Session session2 = sessionFactory.getCurrentSession();
			System.out.println(session1==session2);
			---�����:true
			Session session1 = sessionFactory.openSession();
			Session session2 = sessionFactory.getCurrentSession();
			System.out.println(session1==session2);
---�����:false
//������
class MyFilter implements Fileter
{
	public void doFilter(request,response,chain)
	{
		Session session = sessionFactory.getCurrentSession();//��,Session
		try
		{	session.beginTransaction();	//��������
			chain.doFilter();		//����
			session.getTransaction().commit();//�ύ����
		}
		catch(Exception e)
		{
			session.getTransaction().rollback();	//�쳣����,����ع�
			thorw new RuntimeException(e);
		}
	}
}
//DAO
public class UserDao
{
	public void saveUser(User user)
	{
		Session sessiom = Session session = sessionFactory.getCurrentSession();//��ȡ��ǰ�󶨵�Session
		session.save(user);
		close();
	}
}
�ܽ�:������SessionFactory��Session session = sessionFactory.getCurrentSession();����,����ȡ�󶨵Ķ���!�Ӷ��ﵽ,�ӹ�������Dao����һ��Session!
> �������һ��Ҫ���������ļ��м��ϱ�ǩ��!
	

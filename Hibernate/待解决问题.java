һ�Զ�ӳ��,��������ʱ����

Exception in thread "main" org.hibernate.StaleStateException: Batch update returned unexpected row count from update [0]; actual row count: 0; expected: 1


 order-by:�ܽ��Set�������������������
 Ҫע�����,һ�Զ��ʱ��.Set �����е�����Ĭ���ӳټ��ص�!�������JSPҳ��ʹ�ü�������,һ��Ҫ lazy="false",��Ȼ���쳣


 ����... ...
 ��Ʒһ������	��Ʒ��������	������Ʒ

 ���Ӳ�Ʒ		�ʼǱ�			������

 SELECT COUNT(*) FROM ������Ʒ�� p WHERE p.��Ʒ��������.��Ʒһ������.����=ֵ...
 * ֻ����Ʒһ�����������,��ȡ���о������Ʒ!




--------------------------------
1,�����ṩ�߶�����				|
--------------------------------
	com.alibaba.dubbo.config.annotation.Service

	<dubbo:annotation/>
		* ���Ե���spring�� <context:component-scan> ʹ��,��ʵ����,ע��springע���ʶ��bean.
		* �ѻ�� @Service ��ʶ����,��Ϊ����,ע�ᵽע������

	<context:component-scan base-package="">
		<context:include-filter type="annotation" expression="com.alibaba.dubbo.config.annotation.Service" />
	</context:component-scan>
		* spring ԭ��ɨ��,include-filter ����spring,��ע���ʶ����ҲҪ����ɨ��,����ע�ᵽע������

--------------------------------
2,���������߶�����				|
--------------------------------
	com.alibaba.dubbo.config.annotation.Reference

	<dubbo:annotation />
		* ���Ե���spring�� <context:component-scan> ʹ��,��ʵ����,ע��springע���ʶ��bean.
		* �����Զ���ע��: @Reference ��ʶ������,��ע�����Ļ�ȡ����
	
	<context:component-scan base-package="">
	</context:component-scan>
		* springԭ����ɨ��, 
		* ��Ϊ������:<dubbo:annotation /> ,���� @Reference ��ʶ������,��ע�����Ļ�ȡ������ע��
����������������������������������������������������������������
1,AJAX������					|
����������������������������������������������������������������
	> AJAX,�첽�ύ,������������.
	* ����
		1,�õ�XMLHttpRequest����
		2,���������������
		3,��������
		4,�õ���Ӧ

����������������������������������������������������������������
1,struts2��AJAX������			|
����������������������������������������������������������������
	> struts2,���ṩ��json���
	['����']
	1,����json�����
		* libĿ¼��:struts2-json-plugin-x.x.x.x.jar
	2,��xml�����ļ���,�Լ���Action����,package���ڼ̳�:struta-destul,���Ǽ̳�:json-default
		* json���������һ��xml,������һ��package,�������package�Ǽ̳���stuts-default
		* json�����xml,����ʵ����һЩ����json������������,��Щ���������Action��ջ�������ݽ���json
		<package extends="json-default">
	3,����Ӧ�첽Action�����ļ���,reusltҪ��"json"���type����!
		* <resutl type="json"/>
	

	* �����ⲽ���,���ValueStackջ�����ݱ��Json,
	  �������ǵĳ���,Ҳ���ǻ��Action����.��Ϊjson
	
['��չ']
	��xml��������,typeΪ"json"��result��ͼ��������һ������	
		<result type="json">
			<param name="root">Action����</param>
		</result>
	* �������õĻ�,�Ͳ���Ĭ�ϵİ�����Action��Ϊjson,����ָ����Action�е�������
	
	'����ת���ɵ�json�����в������ض�������'
	1,@JSON(serialize=false)
		* �����ע��,���õ�getXxx������!��ô������ԾͲ��ᱻjson��������!
		* д��Model��ĳ���ֶ��ϰ�!
	2,ͨ��JSON�����,Interceptor ���!
		<result type="json">
			<param name="root">Action����</param>
			<param name="includeProperties">ps[/d+]..��ĺܶ��ĵ�д��</param>
		</result>
		* �ⶫ���ܶ���,��Ҫʹ�õ�ʱ���Լ�ȥ��ѯ��!��Ե�,struts2�㲻�û���ûSpringMVC��ʹ.̫��ô���ظ�����!
		* ̫���ĳ�ŵ,ֻ��Ϊ̫����
	
	
	

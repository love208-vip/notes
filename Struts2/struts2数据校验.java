����������������������������������������������������������������
һ,struts2����У�������		|
����������������������������������������������������������������
	> ��ʵ�ʿ������������,����ҪУ���!�ͻ��˵�У����ҪJavaScript���!
	  ���Ƿ����ҲҪ����У��!
	> struts2�ṩУ��(������У��)
	  * �ֶ�У��
	  * ����У��(Annotation,xml),����ֻ��xml.ע�ⲻ��!

����������������������������������������������������������������
��,�ֶ�У��						|
����������������������������������������������������������������
	> Ҳ�б���У��
	> Ҫ��
	1,Actin�����̳���'ActionSupport' 
		* struts2��ʵ��У�鹦��!��ʵ��Ҫʵ��һ������'Validateable'�Ľӿ�!
		* ֻ��˵���'ActionSupport�Ѿ�������ʵ��������ӿ�'!����Ҫ����,�㲻�̳���,ֱ��ʵ�ֽӿ�Ҳ����(�Ƚ��鷳)

	2,��дһ����:public void validate()
		* �÷���,������������֮ǰִ��,Ҳ����������ִ��У��!�������Լ���д�߼�����
		* �����Ϊ���ݴ���,��ô��:this.addFieldError("��������","������ʾ");
		* ������һ�����߶��������Ϣ֮��,���Զ���ת��,nameΪinput��resultҳ��!
		['ԭ��']
			��Ҫ׷�ݵ�struts-default.xml�ļ���,һ����Ϊ:paramsPrepareParamsStack���������C
			 <interceptor-ref name="params">			['��װ���������������']
                 <param name="excludeParams">dojo\..*,^struts\..*,^session\..*,^request\..*,^application\..*,^servlet(Request|Response)\..*,parameters\...*</param>
             </interceptor-ref>
             <interceptor-ref name="conversionError"/>
             <interceptor-ref name="validation">		['������������ڷ���Action֮ǰ����valiDate����,������validate�����ж�����������д���']
                 <param name="excludeMethods">input,back,cancel,browse</param>
             </interceptor-ref>
             <interceptor-ref name="workflow">			['��������Ƕ��͸����ж�,�������action���涪�������쳣,�����ͻ�Ĭ��ת����input��ͼ']
                 <param name="excludeMethods">input,back,cancel,browse</param>
             </interceptor-ref>
			* params:�����װ���������,�������ʱ��,Action���Ѿ��в�����
			* conversionError:���������������������֮ǰ����valiDate����!У������
				* ������ȷ:����,����
				* ���ݴ���:this.addFieldError("��������","������ʾ");
			* excludeMethods:��������������ж�,����ĸ��ǰ�!����������û��?
			  ��ʵ����ȥ����FieldError,������û�������������涪������Ϣ!���Ҿ�����ֱ����input��result!û��,��Ҳ����!��Action�Լ�����
			* ��input��ͼҳ��ʹ�ñ�ǩ,����ȡ�����������Ϣ(�ǵõ���)
				 <st:fielderror/><!-- չʾ���д�����Ϣ -->
				 <st:fielderror fieldName="��������"/><!-- չʾָ�����ƵĴ�����Ϣ -->
			* �����ʾ�Ǵ�����ͼ��,����ͨ������������ȥ����ͼ,������ֱ��ͨ��'OGNL'���ʽ��ȡ��ֵ
				* ����:${filedErrors.age[0]}

	3,��Action�������������ҪУ��!��������������!
		�������:
		����У�鷽����ʱ��,��������Ϊ:
		validateXxxx(){}
		* ��ô���У�鷽����ֻ��xxx���������Ч��,ע�ⱻУ��ķ���,����ĸ��д!
		����:
		public String regist()
		public void validateRegist()
		{
			��ôУ���ֻ��regist���������Ч!
		}
		['ע��']
		������ָ��У��ĳ��������У������У��ȫ����У����(validate())ͬʱ����ʱ.
		��ôvalidate()�������ִ��!Ҳ����˵�Ȼ�ִ�����󷽷���Ӧ�ĵ�У����!Ȼ����ִ��һ��validate();
		* ˵���˾���,validate()���ǵ�!����˭��.��Ҫ�����У��һ��!����������ָ�����Ƶ�,ֻ��У��ָ������!��������validate()֮ǰУ��!
		* ����,���ǿ��԰�һЩ��ͬ������,������validate()�������У��!��ÿ���������е�����,�����Լ���Ӧ��У�鷽�������У��!
		

����������������������������������������������������������������
��,����У��	(��ҵ������У��)	|
����������������������������������������������������������������	
	> ����У�鲻�ʺϴ�����Ŀ,������������ʱ��,������ά��������ܴ�
	> struts2,��У����!���Ѿ�д���˺ܶ��У�鷽��,�õ�ʱ��ֱ�ӵ��÷�����OK!
	> ͨ�������ļ�,������struts2��У����!
	Ҫ��:
	1,Action�����̳�ActionSupport
	2,��Action���Ŀ¼�´���һ��xml�ļ�
	
�����ļ����
	'λ��':����Ҫ��У���Actionͬһ������
	'����':Action����-validation.xml
	'Լ��':xwork-core-x.x.x.jar�е�xwork-validator-x.x.x.dtd.��������,ճ�������ļ���
			<!DOCTYPE validators PUBLIC
  				"-//Apache Struts//XWork Validator 1.0.3//EN"
  					"http://struts.apache.org/dtds/xwork-validator-1.0.3.dtd">
	'��д':
			<validators>										//��Ԫ��
				<field name="��У���ֶ���">						//��У���ֶ�
					<field-validator type="ָ��У����">			//ָ��У����
						<message>�û�������Ϊ��</message>		//���У��ʧ��,��ʾ�Ĵ�����Ϣ.����ͨ����ǩȡ��:<st:fielderror fieldName="�ֶ���.message"/>
					</field-validator> 
				</field>
			</validators>
	['����']
	<field name="name">//name�ֶ�
 		<field-validator type="stringlength">		//�ַ�����У����
 			<param name="maxLength">16</param>		//��󳤶�
 			<param name="minLength">6</param>		//��С����
			<message key="name"/>					//������Ϣ��key(JSPҳ���п���ͨ��keyȡ��������Ϣ)
 			<message>6λ����,16λһ��</message>		//������Ϣ
 		</field-validator>
		<field-validator type="requiredstring">		//��������У����
			<param name="trim">false</param>		//�����ַ�������trim()����
			<message>�û�������Ϊ��</message>		//������Ϣ	
		</field-validator> 
 	</field>

	<field name="birth">//birth�ֶ�
		<field-validator type="date">				//����У����
 			<param name="max">2012-12-12</param>	//�������
 			<param name="min">2011-11-11</param>	//��С����
			<message key="date"/>					//������Ϣ��key(JSPҳ���п���ͨ��keyȡ��������Ϣ)
 			<message>ֻ����ָ��������</message>		//������Ϣ
 		</field-validator>
	</field>

	<field name="phone">//phon�ֶ�
		<field-validator type="regex">				//������ʽУ����
 			<param name="regexExpression">
				<![CDATA[������ʽ...]]>			//������ʽ,������ʹ��CDATA,��Ϊ�������һЩ�������.���ܱ�xml����!����ԭ�����
			</param>		
			<message key="phone"/>					//������Ϣ��key(JSPҳ���п���ͨ��keyȡ��������Ϣ)
 			<message>�绰�����ʽ����</message>		//������Ϣ
 		</field-validator>
	</field>

ֻУ��ָ���ķ���:
	> ��ʵ����˵,һ��Action��������˶����������!����:��¼��ע��
	> ��¼��ע���У��϶��ǲ�һ����!����,����У��,����Ҫ������һ��! 
	> ����취�ܼ�'�޸������ļ�������'! 
	* Action����-У�鷽��·����-validation.xml
		> �����þ�ֻ��ָ���ķ�������У��
		> ��: UserAction-xxx_login-validation.xml
		
	* Action����-validation.xml
		> �������ļ�����������е���������������У��
		> ��: UserAction-validation.xml
	
	* ���ȫ��У��͵�������У�鶼����,��ô���Բο�����'�ֶ�����У�鷽ʽ'��ͬ�����!

��·У��:
	���ǵ�ǰ��֤����,��ô����ľͲ��ٽ�����֤��
	<validator../>Ԫ�غ�<field-validator.../>����ָ��һ����ѡ��
	short-circuit����,������ָ��'����֤���Ƿ��Ƕ�·��֤��,Ĭ��ֵΪfalse'

	* ��ͬһ���ֶ��ڵĶ��,���һ����·��֤����֤����.��ô�����ľͶ�����֤��

ע��:
	> ��ʵ,ϵͳ�ύ��У�������Ѿ��㹻ʵ�ʵ���Ŀ��������!'����,�ܶ��У���������в���,������У�������Դ�����ҵ�'
	> ���У��������ͬʱ������һ���ֶ���,Ҳ����˵'��һ���ֶ�ͬʱ���Խ��ж���Լ��'
	> ����İ���ֻ�Ǽ򵥵Ľ�����һ����ʾ,�����,'�õ���ʱ����Ҫ���Լ�ȥ��'
	> �ڽ�������У���ʱ��,��Щ���ݶ��Ѿ�����ֵ��Model!
	> ��ʵ<field>����һ����Ԫ��,Ҳ����'����һ��У������',����field-validatorֱ�Ӹ�������
		<field name="repassword">
			<field-validator type="fieldexpression">
				<pram name="expression">
					<!CDATA[[(password==repassword)]]>
				</param>
				<message>������������벻һ��</message>
			</field-validator>
		</field>
	> �������ļ���Ҳ����ʹ��OGNL���ʽ
	<field-validator type="stringlength">			//�ַ�����У����
 			<param name="maxLength">16</param>		//��󳤶�
 			<param name="minLength">6</param>		//��С����
			<message key="name"/>					//������Ϣ��key(JSPҳ���п���ͨ��keyȡ��������Ϣ)
 			<message>${minLength},${maxLength}λһ��</message>		
			//${},���Զ���ȡ,���������,û�������
 	</field-validator>


���У������ͼ��ͻ
	* ʹ��ͨ���Action���ܻ����,���ϵͳ������������ʹ��ͬһ��resut--->input��ͼ
	* ����:��¼���ϴ��ļ�����ͬһ��Action������!��������������У����!xml,������Ĭ����ת�Ķ���input��ͼ.
	* �����ļ�ֻ����һ��resutl��ͼ����!�����������ֲ�ͬ��ҵ��ʽ����һ���ض��İɣ�
		['�������']
		�����к���input��ͼ�ķ�������Ӳ�ֵͬ��ע��
		@InputConfig(resultName="�Զ�����ͼ����")
		> ���ע��ͻ�ı䷽������Щ'�Զ���תinput��ͼ��������'!���Ǿͻ�Ĭ����ת����ָ������ͼ!

����������������������������������������������������������������
��,ϵͳ�ṩ��У����				|
����������������������������������������������������������������
	> type����ָ��У����,Ŀǰ��ָ����У����������ϵͳ�ṩ��
	> ��xwork���İ���!
	com.opensymphony.xwork2.validator.validators.default.xml�ļ���,�Ϳ����ҵ���Щϵͳ�ṩ��У����
<validators>
    <validator name="required" class="com.opensymphony.xwork2.validator.validators.RequiredFieldValidator"/>
		/*����У����*/:Ҫ���ֶ�ֵ����Ϊnull
    <validator name="requiredstring" class="com.opensymphony.xwork2.validator.validators.RequiredStringValidator"/>
		/*����У����*/:Ҫ���ֶ�ֵ����Ϊnull,�ҳ��ȴ���0,Ĭ������»���ַ�����trim()ȥ���˿ո����
    <validator name="int" class="com.opensymphony.xwork2.validator.validators.IntRangeFieldValidator"/>
		/*����У����*/:Ҫ���ֶ�ֵ������ָ���ķ�Χ��,minָ����Сֵ,maxָ�����ֵ!
    <validator name="long" class="com.opensymphony.xwork2.validator.validators.LongRangeFieldValidator"/>
    <validator name="short" class="com.opensymphony.xwork2.validator.validators.ShortRangeFieldValidator"/>
    <validator name="double" class="com.opensymphony.xwork2.validator.validators.DoubleRangeFieldValidator"/>
		/*˫���ȸ���У����*/:Ҫ���ֶ�ֵ������ָ���ķ�Χ��,minָ����Сֵ,maxָ�����ֵ!
    <validator name="date" class="com.opensymphony.xwork2.validator.validators.DateRangeFieldValidator"/>
		/*����У����*/:����У��Ҫ��,Ҫ���ֶε�����ֵ,������ָ����Χ��,minָ����Сֵ,maxָ�����ֵ!ע��,����У���ʽ!���õ����ݵ�ʱ���Ѿ���һ��Date������!
    <validator name="expression" class="com.opensymphony.xwork2.validator.validators.ExpressionValidator"/>
    <validator name="fieldexpression" class="com.opensymphony.xwork2.validator.validators.FieldExpressionValidator"/>
		/*OGNL���ʽУ����*/Ҫ���ֶ�����һ��OGNL���ʽ,expression����ָ��OGNL���ʽ!
    <validator name="email" class="com.opensymphony.xwork2.validator.validators.EmailValidator"/>
		/*email*/:�ʼ���ַУ����,Ҫ������ֶ�ֵ�ǿ�,������ǺϷ����ʼ���ַ
    <validator name="url" class="com.opensymphony.xwork2.validator.validators.URLValidator"/>
		/*urlУ����*/:��ַУ��,����ֶ�ֵ�ǿ�.������ǺϷ���url��ַ
    <validator name="visitor" class="com.opensymphony.xwork2.validator.validators.VisitorFieldValidator"/>
    <validator name="conversion" class="com.opensymphony.xwork2.validator.validators.ConversionErrorFieldValidator"/>
    <validator name="stringlength" class="com.opensymphony.xwork2.validator.validators.StringLengthFieldValidator"/>
		/*�ַ�������У����*/:Ҫ��У�������ֵ���ȱ�����ָ���ķ�Χ��.minLength:ָ����С����,maxLength:ָ����󳤶�
    <validator name="regex" class="com.opensymphony.xwork2.validator.validators.RegexFieldValidator"/>
		/*����У����*/:Ҫ����ֶ�,�������ָ����������ʽ,expression����,ָ��������ʽ,caseSentitive����
    <validator name="conditionalvisitor" class="com.opensymphony.xwork2.validator.validators.ConditionalVisitorFieldValidator"/>
</validators>

����������������������������������������������������������������
��,�Զ���У����					|
����������������������������������������������������������������
����
	1,�Զ���У��������ʵ��'Validator'�ӿ� 
		> ͨ���Զ���У�����̳�:'ValidatorSupport'��'FieldValidatorSupport'
		* ValidatorSupport ��ԵĲ���һ��������ֶ�(��������һ��)
		* FieldValidatorSupport ��Ե���һ�������ֶ�(�û����ǿ�)
	2,ע��У����
		> ����Ŀ��srcĿ¼���½�'validators.xml'�ļ�
		> ����xwork-core-x.x.x.jar��xwork-validator-config-1.0.dtd
	3,ʹ��У����
		> ��Action���а�����'Action����-validation.xml'
['����']
	> ʵ�ʿ�����,�����õ��������!

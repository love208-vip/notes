----------------------------
EasyUI-validate				|
----------------------------
	# easyui-validatebox
		* һ���ʶ��input����
	
	# ��һ����֤���
	# ������ϵ
		tooltip
	


	
----------------------------
EasyUI-validate����			|
----------------------------
	required
		* �Ƿ�Ϊ��������

	validType
		* ָ����֤����
			<!-- ������URL -->
			<input class="easyui-validatebox" data-options="required:true,validType:'url'">
			<!-- ����������,������0-20���ַ� -->
			<input class="easyui-validatebox" data-options="required:true,validType:['email','length[0,20]']">
	
	delay
		* ��������ӳ�ָ����ʱ���Ž���У��
	

	missingMessage
		* ���ı���δ��д����ʱ����Ϣ
	
	invalidMessage
		* ���ı�������ݱ���֤Ϊ��Чʱ���ֵ���ʾ��

	tipPosition
		* ���ı���������Ч��ʱ��,��ʾ��Ϣ���ֵ�λ��
		* ��Ч��ֵ�У�'left','right'
	
	deltaX
		* ��ʾ����ˮƽ�����λ�Ʒ���
	
	novalidate
		* �����ֵΪ true,��ر���֤����
	
	editable
		* �����ֵΪ true,�û����������������������
	
	disabled
		* �����ֵΪ true,�رո��ֶε���֤.���ұ��ύ��ʱ�򲻻��ύ���ֶεĲ���
	
	readonly
		* �����ֵΪ true,�򱻱�ʶ���ֶ�.��ֻ������
	
	validateOnCreate
		* �����ֵΪ true,�򴴽����ֶξͽ�����֤
	
	validateOnBlur
		* �����ֵΪ true,���ڵ�ǰ�ֶ�ʧȥ�����ʱ�������֤
	

	
	

----------------------------
EasyUI-validate�¼�			|
----------------------------
	onBeforeValidate
		* ����֤һ���ֶ�֮ǰ����
	
	onValidate
		* ����֤һ���ֶε�ʱ�򴥷�

----------------------------
EasyUI-validate����			|
----------------------------
	options
		* �������Զ���
	
	destroy
		* �Ƴ������������
	
	validate
		* ִ����֤�ı���,�����Ƿ���Ч
	
	isValid
		* ��������ķ���,���ҷ�����֤���.true/false
	
	enableValidation
		* ������֤
	
	disableValidation
		* ������֤
	
	resetValidation
		* ������֤
	
	enable
		* ���ø����
	
	disable
		* ���ø����
	
	readonly
		* ����ֻ��ģʽ
		* �߱�һ�� boolean �εĲ���,�������Ƿ�ֻ��.�����д��Ĭ��Ϊ true,Ҳ����ֻ������
	




-----------------------------
EasyUI-�Լ�����У�����		 |
-----------------------------
	
	<input class="easyui-validatebox" data-options="validType:'xxxx[5]'">  
		* validType��ֵΪ,�Զ����У���������,�������������һ������,���Դ���N������

		$.extend($.fn.validatebox.defaults.rules, {    
			//�Զ����У���������
			xxxx: {    
				//У�鷽��
				validator: function(value, param){    
					/*
						value�Ǳ��Ĳ���,param���Լ����ݵĲ���,��������������Լ�ʵ��У�����
						Ҫע���ʱ��,param��һ������.�����ж��������
					*/
					return value.length >= param[0];    
				},    
				//���У��ʧ�ܵ���ʾ��Ϣ,{0}.��һ����ʽռλ��.ִ����ʾ��ʱ����滻��param�ж�Ӧ�±�Ĳ���
				message: 'Please enter at least {0} characters.'   
			},
			//����һ���Զ����У�����
			zzzz: {
				validator: 	function(value,param){
					return true;
				}
				message: '�Զ������ʾ��Ϣ';
			}
		});  
----------------------------
EasyUI-form					|
----------------------------
	# ��
	# �ύ��ʽһ��������.
		1,ʹ��easyui-form �� submit �����ύ
			//�ᴥ��: onsubmit ����
		2,ʹ��Jquery ѡ�� form ��,����dom���� submit �ύ
			//�ᴥ��: onsubmit ����
		3,ͨ��Jquery �� $.ajax(); ��ȡ�������������.�ύ
			//���ᴥ��: onsubmit ����

----------------------------
EasyUI-form����				|
----------------------------
	novalidate
		* �Ƿ���֤���ֶ�.
	
	iframe
		* �Ƿ�ʹ��  iframe ��ʽ�ύ��
	
	ajax
		* �Ƿ�ʹ��ajax�����ύ��
	
	queryParams
		* �����ύ����̨����ӵĲ���
	
	url
		* �ύ�ĵ�ַ

----------------------------
EasyUI-form�¼�				|
----------------------------
	onSubmit
		* ���ύ֮ǰ����.����false������ֹ���ύ
		* ������һ���ִ��һЩ�ύ������У��
		* ����:param

	onProgress
		* ���ϴ�����������Чʱ�������ڡ�iframe����������Ϊtrueʱ���¼����ᱻ������
		* ����:percent
	
	success
		* �ڱ��ύ�ɹ��󴥷�
		* ����:data
	
	onBeforeLoad
		* �������������֮ǰ����,���� false ������ֹ�¼�
		* ����:param
	
	onLoadSuccess
		* �ڱ����ݼ�����ɺ󴥷���
		* ����:data
	
	onLoadError
		* �ڱ����ݼ��ش����ʱ�򴥷�
	
	onChange
		* �ڱ����ݷ����仯��ʱ�򴥷�
	
----------------------------
EasyUI-form����				 |
-----------------------------
	submit
		* ִ���ύ��������ѡ��Ĳ�����һ�������������������ԣ�
			url			//�����URL��ַ��
			onSubmit	//�ύ֮ǰ�Ļص��������������false,����ֹ��
			success		//�ύ�ɹ���Ļص�������������ص�JSON����,���ǲ����Զ�ת��ΪJSON��.��Ҫ�Լ��ֶ�ת��:
		* demo
			$.messager.progress();	// ��ʼ�ύ����ʾ������
			$('#ff').form('submit', {
				url: '${pageContext.request.contextPath}/user',
				onSubmit: function(){
					var isValid = $(this).form('validate');
					if (!isValid){
						$.messager.progress('close');	// ���������Ч�������ؽ�����
					}
					return isValid;						// ����false��ֹ���ύ
				},
				success: function(data){
					$.messager.progress('close');		// ����ύ�ɹ������ؽ�����
					var data = eval('(' + data + ')');  // ���ַ�ʽ�ǲ������Ӧ����ת��ΪJSON��.��Ҫ�Լ��ֶ���ȥת��
					if (data.success){    
						alert(data.message)    
					}    
				}
			});


		

	load
		* ��Զ�̵�ַ��ȡ����,��䵽�����
		* ���������һ���ַ���,����URL,ȥ��ȡԶ������
		* ���������һ������.����Ϊ���ص�����.������

	validate
		* ���ô˷���,���е�����У��ѡ�OK�Ļ�,���� true,��֮���� false
		* ��������У��
	
	clear
		* ���ô˷���,��ձ�����
	
	reset
		* ���ñ�����
	
	enableValidation
		* ������֤
	
	disableValidation
		* ������֤
	
	resetValidation
		* ������֤
	


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
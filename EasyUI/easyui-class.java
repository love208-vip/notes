----------------------------
EasyUI-class				|
----------------------------
	# ��������ֱ����ΪHTMLԪ�ص�����.
		<div id="div" title="����" class="easyui-diaglog"> <div>

	# ���ԺͲ���Ҳ����ͨ��JS�����
		$(function(){
			//�������ƾ���easyui����������
			$('#div').dialog({
				//JSON����,�����ò���
				title:'����'
			});
		});
		
	easyui-draggable
		* ����ʶ��Ԫ��,�������ɵ��϶�
	
	easyui-dialog
		* �Ի���
		modal:true		//�Ƿ�����... ...,��������Ķ���������.Ĭ����false
		title:'����'	//���ڱ���
	

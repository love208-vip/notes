----------------------------
easyui-progressbar			|
----------------------------
	# ������
	# ������
		easyui-progressbar

----------------------------
easyui-progressbar����		|
----------------------------
	width
		* ���ý��������
	
	height
		* ���ý������߶�

	value
		* ��������ֵ���100,��С0
	
	text
		* ��������ʾ���ı�.Ĭ����ʾ�ľ�������Ľ���ֵ.�������޸�

----------------------------
easyui-progressbar�¼�		|
----------------------------
	onChange
		* ��ֵ���ĵ�ʱ�򴥷��� 
		* ����������:newValue,oldValue
		* demo
			$('#p').progressbar({
				onChange: function(value){
					alert(value)
				}
			});
	


----------------------------
easyui-progressbar����		|
----------------------------
	options
		* �������Զ���
	
	resize
		* �����С
		* demo
			$('#p').progressbar('resize');           // ���Ľ�������ԭʼ���
			$('#p').progressbar('resize', 350);   // ���Ľ��������µĿ��
	
	getValue
		* ��ȡ���������Ľ���ֵ
	
	setValue
		* ������������һ������ֵ
	

	

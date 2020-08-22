------------------------
EasyUI-calendar			|
------------------------
	# ʹ��$.fn.calendar.defaults��дĬ��ֵ����
	# ��������
		easyui-calendar	

------------------------
EasyUI-calendar	����	|
------------------------
	width
		* �����ؼ��Ŀ��
	
	height
		* �����ռ�ĸ߶�
	
	fit
		* �����ֵΪ true,�������ؼ���ŵ���Ԫ�صĴ�С
	
	border
		* �Ƿ���ʾ�߿�
	
	firstDay
		* ����һ�ܵĵ�һ�������ڼ���0=�����ա�1=����һ �ȡ�
		* �߱�һ����ֵ�͵Ĳ���:0/1
	
	weeks
		* ��ʾ���б�����
		* ������һ������.
		* Ĭ��ֵ:['S','M','T','W','T','F','S']
	
	months
		* ��ʾ���б�����
		* ������һ������
		* Ĭ��ֵ:['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug','Sep', 'Oct', 'Nov', 'Dec']
	
	year
		* ������,�����������ʾ�����ʹ��ָ������ݺ��·ݴ���һ��������
		* �߱�һ����ֵ���͵Ĳ���
		* <div class="easyui-calendar" data-options="year:2012,month:6" />
	
	month
		* ������
		* �߱�һ������.�����·�.(��1�·ݿ�ʼ)
	
	current
		* �߱�һ������. Date ����
		* ���õ�ǰ��ʱ��

	formatter
		* ���ڸ�ʽ������
			$('#cc').calendar({
				formatter: function(date){
					return date.getDate();
				}
			});
	
	styler
		* (date) ���������ʽ����������������ʽ��CSS��ʽ���Class���ơ� 
		* demo
			$('#cc').calendar({
				styler: function(date){
					if (date.getDay() == 1){
						return 'background-color:#ccc';
							// �������Է���Ԥ�����css class��Ԥ�����������ʽ
							// return {class:'r1', style:{'color:#fff'}};	
						} else {
							return '';
						}
					}
				})
			
	validator
		* ��֤����������ȷ���Ƿ����ѡ�������ϵ�ĳһ�죬���� false ����ֹѡ��ǰ
		* demo
			$('#cc').calendar({
				validator: function(date){
					if (date.getDay() == 1) {                                    
						return true;
					} else {                               
						return false;                                
					}
				}
			})
	

			

	



------------------------
EasyUI-calendar	�¼�	|
------------------------
	onSelect
		* ��ѡ��һ���¼���ʱ�򴥷�
		* demo
			$('#cc').calendar({
				onSelect: function(date){
					alert(date.getFullYear()+":"+(date.getMonth()+1)+":"+date.getDate());
				}
			});
	
	onChange
		* ���û��޸�ʱ��Ĵ���
		* �߱���������:newDate, oldDate.Ҳ�����µ�����,�;ɵ�����
	

------------------------
EasyUI-calendar	����	|
------------------------
	options
		* ���ز�������
	
	resize
		* ����������С
	
	moveTo
		* �ƶ����ڵ�ָ��ֵ
		* demo
			$('#cc').calendar('moveTo', new Date(2012, 6, 1));
	



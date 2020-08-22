------------------------
EasyUI-timespinner		|
------------------------
	# ʱ��΢������Ĵ�������΢���������������΢�����ƣ�������ʾ��ʱ��ֵ��ʱ��΢����������û��������Ҳ��С��ť�����ӻ����ʱ�䡣
	# �̳й�ϵ
		spinner

------------------------
EasyUI-timespinner	����|
------------------------
	'�����������չ��spinner(΢��)��������������������£�'
	separator
		* ������Сʱ���Ӻ���֮��ķָ���
	
	showSeconds
		* �Ƿ���ʾ������Ϣ
	
	highlight
		* ��ʼѡ���ֶ�
		* 0=Сʱ,1=����...
	
	formatter
		* ��ʽ�����ں������ú�������date�����Ͳ���������һ���ַ���ֵ��
		* function (date){}
		* demo	
			//���µ�ʾ������չʾ����θ���Ĭ�ϸ�ʽ�����ķ�����
			$.fn.timespinner.defaults.formatter = function(date){
				if (!date){return '';}
				var opts = $(this).timespinner('options');
				var tt = [formatN(date.getHours()), formatN(date.getMinutes())];
				if (opts.showSeconds){
					tt.push(formatN(date.getSeconds()));
				}
				return tt.join(opts.separator);
				
				function formatN(value){
					return (value < 10 ? '0' : '') + value;
				}
			}
	
	parser
		* ��������/ʱ���ַ����ĺ������ú�������date�ַ������͵Ĳ���������һ��date����ֵ
		* demo
			$.fn.timespinner.defaults.parser = function(s){
				var opts = $(this).timespinner('options');
				if (!s){return null;}
				var tt = s.split(opts.separator);
				return new Date(1900, 0, 0, 
				parseInt(tt[0],10)||0, parseInt(tt[1],10)||0, parseInt(tt[2],10)||0);
			}
	
	selections
		* ������һ��array
		* ����ѡ�񲿷ֵ�ֵ��ͻ����ʾÿһ���֡����磺���ַ���0�㵽2�����Сʱ���֡�
		* [[0,2],[3,5],[6,8]] 
	




------------------------
EasyUI-timespinner	�¼�|
------------------------
	'������¼���ȫ�̳���spinner(΢��)��'

------------------------
EasyUI-timespinner	����|
------------------------
	'������ķ�����չ��spinner(΢��)���������д�ķ������£�'

	options
		* �������Զ���
	
	setValue
		* ����ʱ��΢�������ֵ
		* demo
			$('#ss').timespinner('setValue', '17:45');  // ����ʱ��΢�������ֵ
			var v = $('#ss').timespinner('getValue');  // ��ȡʱ��΢�������ֵ
			alert(v);
	
	getHours
		* ��ǰСʱ��
	
	getMinutes
		* ��ȡ��ǰ������
	
	getSeconds
		* ��ȡ��ǰ������


	
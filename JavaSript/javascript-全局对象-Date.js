-------------------
Date				|
-------------------
	# ����
		var date = new Date();
		var date = new Date(milliseconds);
			* ������һ���������͵�ʱ���

		var date = new Date(dateString);
			* var date = new Date("Wed May 15 2013 10:30:25 GMT+0800 (�й���׼ʱ��)");

		var date = new Date(year, month, day, hours, minutes, seconds, milliseconds);
			* ��,��,��,ʱ,��,��,ʱ���

	# �������ڶ���֮�����ʵ�ּӼ���
		* �����,�õ����Ǻ���ֵ
		var now = new Date();
		for(var x = 0 ;x < 1000; x++){
		}
		var then = new Date();
		out("����ֵ:"+(then - now));

	# ʵ������

		toLocaleString();		
			* ���ݵ�ǰϵͳ����,����һ��ʱ�������

		getYear();				
			* ����λ,�������,���ڷ���,������ʹ��

		getFullYear();			
			* ����λ,�������

		getMonth();				
			* ��ȡ�·�,���ص���0-11,��Ҫ+1�������ܻ�ȡ��׼ȷ��ֵ

		getDay();				
			* ����һ�ܵ��еڼ���0-6,��Ҫ+1�������ܻ�ȡ��׼ȷ��ֵ

		getDate();				
			* ����һ�����еڼ���

		getHours();				
			* ��ȡСʱ(24H��)

		getMinutes();			
			* ��ȡ��ǰ�ķ���

		getSeconds();			
			* ��ȡ��ǰ��

		getMilliseconds()	
			* ��ȡ����(0 ~ 999)��

		getTime();				
			* ����:1970-1-1�յ����ĺ�����

		toJSON();
			* �� JSON ���ݸ�ʽ���������ַ�����

		setDate()	
			* ���� Date �������µ�ĳһ�� (1 ~ 31)��

		setFullYear()
			* ���� Date �����е���ݣ���λ���֣���

		setHours()
			* ���� Date �����е�Сʱ (0 ~ 23)��

		setMilliseconds()	
			* ���� Date �����еĺ��� (0 ~ 999)��

		setMinutes()
			* ���� Date �����еķ��� (0 ~ 59)��

		setMonth()
			* ���� Date �������·� (0 ~ 11)��

		setSeconds()
			* ���� Date �����е����� (0 ~ 59)��

		setTime()	
			* setTime() �����Ժ������� Date ����
	
-------------------
Date-��ȡ��ǰʱ��	|
-------------------
	function now(){
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;	
		if(month < 10){
			month = "0" + month;
		}
		var dayOfMonth = date.getDate();
		if(dayOfMonth < 10){
			dayOfMonth = "0" + dayOfMonth;
		}
		var hours = date.getHours();		
		if(hours < 10){
			hours = "0" + hours;
		}
		var minutes = date.getMinutes();	
		if(minutes < 10){
			minutes = "0" + minutes;
		}
		var seconds = date.getSeconds();
		if(seconds < 10){
			seconds = "0" + seconds;
		}
		return year + "��" + month + "��" + dayOfMonth + "�� " + hours + ":" + minutes + ":" + seconds;
	}
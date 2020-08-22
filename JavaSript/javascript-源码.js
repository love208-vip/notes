
----------------------------------------
Array-�Զ���ԭ�ͷ���,���Ա�����ά����	|
----------------------------------------
	Array.prototype.each = function(fun){
		try{
			//Ԥ�����ʼ������
			this.i || (this.i = 0);
			//ȷ����ǰ������Ԫ��,���Ҵ��ݵĲ�����һ������
			if(this.length > 0 && fun.constructor == Function){
				while(this.length > this.i){
					//��ȡÿһ��Ԫ��
					var temp = this[this.i];
					if(temp && temp.constructor == Array){
						//�����ǰԪ�ػ���һ������,�ݹ����
						temp.each(fun);
					}else{
						//�������,��ִ�д��ݽ����ĺ���
						var obj = true;
						fun.call(temp,temp);
					}
					//�ͷű����ڴ�
					this.i ++;
				}
				this.i = null;
			}
		}catch(e){
			//TODO
		}
		return this;
	}
	var arr = [5,6,7,8,9,[10,11,12,[55,[66]]]];
	arr.each(function(val){
		console.log(val);
	});

----------------------------------------
Date-��ȡ��ǰʱ��						|
----------------------------------------
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

----------------------------------------
Date-��ʾ����ͼƬ						|
----------------------------------------
	var input = document.getElementsByTagName("input")[0];
	input.onchange = function (e) {
		var url = window.URL.createObjectURL(this.files[0]);
		document.getElementsByTagName("img")[0].src = url;
		//window.URL.revokeObjectURL(url);					
	};

----------------------------------------
location-��ȡURL����������			|
----------------------------------------
	function urlArgs(){
		var args = {};
		//��ȡ�����ַ���,ɾ��?��
		var query = location.search.substring(1);
		//���� & ���Ϸָ��ַ���
		var pairs = query.split("&");
		for(var x = 0;x < pairs.length;x++){
			//����name=value
			var pos = pairs[x].indexOf("=");
			if(pos == -1){
				continue;
			}
			var name = pairs[x].substring(0,pos);
			var value = pairs[x].substring(pos + 1);
			//URI����
			value = decodeURIComponent(value);
			if(args.hasOwnProperty(name)){
				//�����Ѿ�����,��','�ŷָ�
				value = args[name] + "," + value;
			}
			args[name] = value;
		}
		return args;
	}

----------------------------------------
doucment-��ȡ���е�Cookie				|
----------------------------------------
	function getCookies (){
		var cookie = {};
		var all = document.cookie;
		if(all === ''){
			return cookie;				
		}
		var list = all.split(';');
		for(var x = 0; x < list.length ; x++){
			var cookieStr = list[x];
			var point = cookieStr.indexOf('=');
			var name = cookieStr.substring(0,point);
			var value = decodeURIComponent(cookieStr.substring(point + 1));
			cookie[name] = value;
		}
		return cookie;
	}
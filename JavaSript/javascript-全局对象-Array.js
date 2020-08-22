--------------------
Array-����ʵ������	|
--------------------
	concat(arr1,arr2...);
		* ����һ�����߶������,�����µ�����

	fill(value,start,end);
		* ʹ��ָ��ֵ,�������
		* start Ĭ����1,endĬ�� length

	slice(start,end);
		* ��ȡָ���Ǳ굽ָ���Ǳ��Ԫ��,�����µ�����
	
	splice(index,many,item...);
		* �Ե�ǰ�������ɾ��/���.��inde����ʼɾ��,ɾ��many������,������һ�����߶�� item ����,�ͻ�������

	every(Function fun);
		* �ж�Ԫ���Ƿ񶼷�������

	some(Function fun);
		* �Ƿ���һ�����߶��Ԫ�ط�������

	filter(Function fun);
		* ��Ԫ�ؽ��й���,�����µ�����

	find(Function fun);
		* ���ط��������ĵ�һ��Ԫ��

	findIndex(Function fun);
		* ���ط��������ĵ�һ��Ԫ�صĽǱ�

	forEach(Function fun);
		* ����

	indexOf(value);
		* ��ȡָ��ֵ�ĵ�һ���Ǳ�,�������

	lastIndexOf();
		* ��ȡָ��ֵ�ĵ�һ���Ǳ�,�������

	join(spe);
		* ��ָ�����ַ��������������Ԫ�����Ϊ�µ��ַ���

	map(Function fun);
		* ��������Ԫ��,�󷵻�,����µ�����

	pop();
		* ɾ�����һ��Ԫ��,������

	shift();
		* ɾ����һ��Ԫ��,���ҷ���

	push();
		* ��ĩβ���һ�����߶��Ԫ��,�����µ����鳤��

	unshift();
		* �ڿ�ͷ���һ�����߶��Ԫ��,�����µ����鳤��

	reverse();
		* ��ת����

	sort(Function fun);
		* �Ե�ǰ�����������
		


--------------------
Array				|
--------------------
	# ����
		* ������Խ��,δ������±�Ϊ undefined
		* ���Դ洢������������,û�з���Լ��
		* Ҳ��������Ľ����޸�/����/ɾ��

	# ����
		var arr = new Array();				//�ռ���
		var arr = new Array(5);				//��ʼ����Ϊ5�ļ�
		var arr = new Array("1","2","3");	//�ڳ�ʼ����ʱ��,���������
		var arr = ["1","2","4"];			//��ʿ����
		var arr = [1,,,,,3];				//һ����6��Ԫ��,�м��ĸ���undefind
	
	# ����
		constructor	
			* ���ع��캯��
		length	
			* ���û򷵻�����Ԫ�صĸ�����
		prototype	
			* ����ԭ�Ͷ���
	# ��������
		var arr = ["1","2","4"];	//��ʽ����
		arr["0"];					//��ʽ��ת��Ϊ0
		arr[0];
	
	# ɾ��Ԫ��
		var arr = [1,2,3]
		delete arr[0];
			* ɾ���˵�һ��Ԫ��,���ǳ�����Ȼ��3,��һ��Ԫ�ؾ���undefind
		arr.length = 0;
			* ֱ�Ӱ����鳤�ȱ�Ϊ0,Ҳ��ɾ�������е���������
	
	# ��̬����
		isArray();
			* �ж�ָ���Ķ����Ƿ�����������
		
	# ʵ������
		concat()	
			* ����һ�����������飬�����µ����顣
			* demo
				var a1 = [1,2,3];
				var a2 = ["4","5","6"];
				var a3 = [7,8,9];
				var a4 = a1.concat(a2,a3);		//a4 = 1,2,3,4,5,6,7,8,9

		copyWithin()
			* �������ָ��λ�ÿ���Ԫ�ص��������һ��ָ��λ���С�
			* ����
				target	
					> ���衣���Ƶ�ָ��Ŀ������λ�á�
				start	
					> ���衣Ԫ�ظ��Ƶ���ʼλ�á�
				end	
					> ��ѡ��ֹͣ���Ƶ�����λ�� (Ĭ��Ϊ array.length)
			* demo
				var fruits = ["Banana", "Orange", "Apple", "Mango"];
				fruits.copyWithin(2, 0);	//Banana,Orange,Banana,Orange

		every()
			* �����ֵԪ�ص�ÿ��Ԫ���Ƿ񶼷������������� boolean ֵ
				> ȫ��������,���� true,����һ�������Ͼͷ��� false
			* ����
				function(currentValue, index,arr){}
					> ����(����)����,�ú���Ӧ�÷��� true/false
					> ����
						currentValue
							> ��ǰ�����е�ֵ
						index
							> ��ǰֵ���±�
						arr
							> ��ǰ����
				thisValue
					> ��ѡ����,������Ϊ��ִ�лص�ʱʹ�ã����ݸ����������� "this" ��ֵ�����ʡ���� thisValue ��"this" ��ֵΪ "undefined"
			* Demo
				var ages = [32, 33, 16, 40];
				//�жϵ�ǰ�����е�����,�Ƿ��������ݶ����� 18 
				ages.every(function(currentValue, index,arr){
					if(currentValue > 18){
						return true;
					}
					return false;
				});
			
		fill()	
			* ʹ��һ���̶�ֵ��������顣
			* ����
				value	
					> ���衣����ֵ��
				start
					> ��ѡ����ʼ���λ�á�
				end	
					>��ѡ��ֹͣ���λ�� (Ĭ��Ϊ array.length)
			* Demo
				var arr [1,2,3] ;
				arr.fill("8");		//arr = ["8","8","8"];

		filter()
			* �����ֵԪ��,��ʵ���ǹ��˲����ط�����������Ԫ�ص�����.
			* ����
				function(currentValue, index,arr){}
					> ����(����)����,�ú���Ӧ�÷��� true/false
					> ����
						currentValue
							> ��ǰ�����е�ֵ
						index
							> ��ǰֵ���±�
						arr
							> ��ǰ����
				thisValue
					> ��ѡ����,������Ϊ��ִ�лص�ʱʹ�ã����ݸ����������� "this" ��ֵ�����ʡ���� thisValue ��"this" ��ֵΪ "undefined"
				
			* Demo
				var arr = [1,2,3,4,5];
				//�������������д��� 2 ��ֵ
				var result = arr.filter(function(cv,index,arr){
					if(cv > 2){
						return true;
					}
					return false;
				});		
		find()	
			* ���ط��������ĵ�һ��Ԫ�ء�
			* ���ҵ��˵�һ�����ϵ�Ԫ��,�ͷ���,���һ����û,���� undefined
			* �������Ϊ��,��ô�÷�������ִ��
			* ����
				function(currentValue, index,arr){}
					> ����(����)����,�ú���Ӧ�÷��� true/false
					> ����
						currentValue
							> ��ǰ�����е�ֵ
						index
							> ��ǰֵ���±�
						arr
							> ��ǰ����
				thisValue
					> ��ѡ����,������Ϊ��ִ�лص�ʱʹ�ã����ݸ����������� "this" ��ֵ�����ʡ���� thisValue ��"this" ��ֵΪ "undefined"
			* Demo
				var arr = [1,2,3];
				//��ȡ�����е�һ������ 1����
				var result = arr.find(function(cv,index,arr){
					if(cv > 1){
						return true;
					}
					return false;
				});

		findIndex()
			* ���ط��������ĵ�һ��Ԫ�ص�������
			* ͬ��,�����÷������ص��� Ԫ�ص�����,������Ԫ�ر���

		forEach()
			* ����ÿ��Ԫ�ض�ִ��һ�λص�������
			* ����
			* ����
				function(currentValue, index,arr){}
					> ����(����)����,�ú���Ӧ�÷��� true/false
					> ����
						currentValue
							> ��ǰ�����е�ֵ
						index
							> ��ǰֵ���±�
						arr
							> ��ǰ����
				thisValue
					> ��ѡ����,������Ϊ��ִ�лص�ʱʹ�ã����ݸ����������� "this" ��ֵ�����ʡ���� thisValue ��"this" ��ֵΪ "undefined"
			* Demo
				var arr = [1,2,3,4,5,6,7];
				arr.forEach(function(value,index,arr){
					println(value);
				});

		indexOf()
			* �������������еĵ�һ��Ԫ�أ������������ڵ�λ�á�
			* ʹ��ȫ === ȥƥ���,���û�ҵ�,���� -1
			* ����
				item	
					> ���롣���ҵ�Ԫ�ء�
				start	
					> ���ĸ��Ǳ꿪ʼ�������,Ĭ��ֵΪ0
			* Demo
				var arr = [1,2,3,4,5,"6",6,7];
				var index = arr.indexOf(6));		//6
		
		lastIndexOf()
			* ���������������еĵ�һ��Ԫ�أ������������ڵ�λ��
			* ����
				item	
					> ���롣���ҵ�Ԫ�ء�
				start	
					> ���ĸ��Ǳ꿪ʼ�������,Ĭ��ֵΪ length - 1 
			* Demo
				var arr = [1,2,3,4,5,"6",6,7];
				var index = arr.lastIndexOf(6));		//6

		join()
			* �������е�����Ԫ��ת��Ϊһ���ַ���,
			* ����
				separator	
					> ��ѡ��ָ��Ҫʹ�õķָ��������ʡ�Ըò�������ʹ�ö�����Ϊ�ָ�����
			* Demo
				var arr = [1,2,3];
				var result = arr.join('-');		//1-2-3
		
		map()
			* ͨ��ָ���������������ÿ��Ԫ�أ������ش����������顣
			* ����
				function(currentValue, index,arr){}
					> ����(����)����,�ú���Ӧ�÷��� true/false
					> ����
						currentValue
							> ��ǰ�����е�ֵ
						index
							> ��ǰֵ���±�
						arr
							> ��ǰ����
				thisValue
					> ��ѡ����,������Ϊ��ִ�лص�ʱʹ�ã����ݸ����������� "this" ��ֵ�����ʡ���� thisValue ��"this" ��ֵΪ "undefined"
			* Demo
				var arr = [1,2,3];
				var result = arr.map(function(va,index,arr){
					//�������е�Ԫ��,ÿ��Ԫ�ض�����1
					return va + 1;
				});

		pop()
			* ɾ����������һ��Ԫ�ز�����ɾ����Ԫ�ء�

		shift()
			* ɾ������������ĵ�һ��Ԫ�ء�

		push()
			* �������ĩβ���һ�������Ԫ�أ��������µĳ��ȡ�

		reduce()
			* ������Ԫ�ؼ���Ϊһ��ֵ�������ң���
			* ����
				function(currentValue, index,arr){}
					> ����(����)����,�ú���Ӧ�÷��� true/false
					> ����
						total
							> ����,��ʼֵ,���߼��������ķ���ֵ��
						currentValue
							> ��ǰ�����е�ֵ
						index
							> ��ǰֵ���±�
						arr
							> ��ǰ����
				thisValue
					> ��ѡ����,������Ϊ��ִ�лص�ʱʹ�ã����ݸ����������� "this" ��ֵ�����ʡ���� thisValue ��"this" ��ֵΪ "undefined"
			* Demo
				

		reduceRight()
			* ������Ԫ�ؼ���Ϊһ��ֵ�����ҵ��󣩡�
			* ͬ��,ֻ�Ƿ���ͬ

		reverse()
			* ��ת�����Ԫ��˳��,�������µ�����,ֱ�ӾͰѵ�ǰ���鷴ת
		
		slice()
			* ѡȡ����ĵ�һ���֣�������һ�������顣
			* ����ͷ,������β
			* ����(���ĸ��Ǳ꿪ʼ?���ĸ��Ǳ����?)
				start	
					> ���衣�涨�Ӻδ���ʼѡȡ������Ǹ�������ô���涨������β����ʼ�����λ�á�Ҳ����˵��-1 ָ���һ��Ԫ�أ�-2 ָ�����ڶ���Ԫ�أ��Դ����ơ�
				end	
					> ��ѡ���涨�Ӻδ�����ѡȡ���ò���������Ƭ�Ͻ������������±ꡣ���û��ָ���ò�������ô�зֵ���������� start ���������������Ԫ�ء������������Ǹ�������ô���涨���Ǵ�����β����ʼ�����Ԫ�ء�
			* Demo	
				var arr = [1,2,3];
				var result = arr.slice(0,2);		//12

		some()	
			* �������Ԫ�����Ƿ���һ������Ԫ�ط���ָ������������ boolean
			* ����
				function(currentValue, index,arr){}
					> ����(����)����,�ú���Ӧ�÷��� true/false
					> ����
						currentValue
							> ��ǰ�����е�ֵ
						index
							> ��ǰֵ���±�
						arr
							> ��ǰ����
				thisValue
					> ��ѡ����,������Ϊ��ִ�лص�ʱʹ�ã����ݸ����������� "this" ��ֵ�����ʡ���� thisValue ��"this" ��ֵΪ "undefined"
			
			* Demo
				var arr = [1,2,3,4];
				arr.some(function(val){
					if(val == 4){
						return true;
					}
					return false;
				});

		sort()	
			* �������Ԫ�ؽ������򡣻��޸�ԭ���������
			* ����
				sortfunction(item1,item2){}
					> ����Ĳ���
						item1
							> Ԫ��1
						item2
							> Ԫ��2
			* Demo
				var arr = [5,2,9,4]; 
				var result = arr.sort(function(v1,v2){
					return v1 > v2;
				});

		splice()	
			* �ڵ�ǰ��������ӻ�ɾ��Ԫ�ء�
			* ����
				index	
					> ���衣�涨�Ӻδ����/ɾ��Ԫ�ء��ò����ǿ�ʼ����ͣ���ɾ��������Ԫ�ص��±꣬���������֡�
				howmany	
					> ���衣�涨Ӧ��ɾ������Ԫ�ء����������֣��������� "0"�����δ�涨�˲�������ɾ���� index ��ʼ��ԭ�����β������Ԫ�ء�
				item1, ..., itemX	
					> ��ѡ��Ҫ��ӵ��������Ԫ��
			* index �����˴����￪ʼɾ��Ԫ��,howmany ������Ҫɾ�����ٸ�Ԫ��,�����һ�����߶�� item ,�ͻᱻ��ӵ�ɾ���Ŀ�ȱ��,û�о�����
			* ��� item ��������ɾ���ĳ���,��,ԭ�����������Ԫ�غ���
			* Demo
				var fruits = ["Banana", "Orange", "Apple", "Mango"];
				fruits.splice(2,1,"Lemon","Kiwi");	//Banana,Orange,Lemon,Kiwi,Mango

		toString()
			* ������ת��Ϊ�ַ����������ؽ����
			* ʹ��,�ŷָ�

		unshift()
			* ������Ŀ�ͷ���һ�������Ԫ�أ��������µĳ��ȡ�
			* Demo
				var fruits = ["Banana", "Orange", "Apple", "Mango"];
				fruits.unshift("Lemon","Pineapple");//	Lemon,Pineapple,Banana,Orange,Apple,Mango

		valueOf()
			* ������������ԭʼֵ��
			* valueOf() ����������Ĭ�Ϸ�����
			* Demo
				var fruits = ["Banana", "Orange", "Apple", "Mango"];
				var v = fruits.valueOf();	//fruits.valueOf()�� fruits����ֵһ��,v������Ϊ��Banana,Orange,Apple,Mango


--------------------
Array-ע��ĵط�	|
--------------------
	# �޸�Array��length����,��Ӱ�쵽�����е�Ԫ��
		var x = [1,2,3,4,6];
		x.length = 3;		//1,2,3    

--------------------
Array-�ɱ�����ά����|
--------------------	
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
	


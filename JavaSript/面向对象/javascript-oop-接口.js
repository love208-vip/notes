--------------------
�ӿ�				|
--------------------
	# JS��û�нӿ��������,���ǿ���ģ��߼����ԵĽӿ�
	# JS�еĽӿ�,��һ������Ҫ�ĸ���
	# �����ӿڵķ�ʽ
		1,ע�������νӿ�
		2,���Լ���νӿ�
		3,Ѽʽ���ͽӿ�
	# �ӿ�����
		����С������˵,ʹ�ýӿھͻ��Եúܲ�����,��Ϊ�ⶫ�����ó�����ӵĸ���
	

--------------------
ע�������νӿ�		|
--------------------
	* ��ʵֻ��ʹ��ע����Լ��,��û���κ�ǿ���Ե�Լ��
		/**		����ӿ�
		interface Composite {
			function add (o);
			function remove(o);
			function update(o);
		}
		*/

		/**		����ʵ��
		 * CompositeImpl implements Composite
		 */
		function CompositeImpl(){

		}

		/**
		 * ��ԭ�Ͷ�����ʵ�ֽӿڷ���
		 */
		CompositeImpl.prototype.add = function(o){
			
		}
		CompositeImpl.prototype.remove = function(o){
			
		}
		CompositeImpl.prototype.update = function(o){
			
		}

		var c1 = new CompositeImpl();
		var c2 = new CompositeImpl();

		out(c1.add == c2.add);

	
	

--------------------
���Լ���νӿ�		|
--------------------
	* ��ʵ��������һ������,ֻ��˵����һ��,���
	
--------------------
Ѽʽ���ͽӿ�		|
--------------------
	# �ռ�,�������ķ�ʽ
	# ��ȫ���������,����Ҳʵ��ͳһ,����Ҳ����
	
		1,�����ӿڹ淶��
		2,�����ӿڹ淶���ʵ��
			* ���ݽ�ȥ�ӿڵ�����(���ַ�����ʾ)
			* �ӿ�����ĳ��󷽷�(���ַ�����ʾ)
		3,�����ӿڵ�ʵ����
			* ʵ����Щ����
		4,ʹ��У��
	# ����
	
		/**
		 * �ӿ���,��Ҫ��������
		 * 1,�ӿ�����
		 * 2,��һ������,���Ƿ������Ƶļ���(String)
		 */
		function Interface (name,methods){
			//�жϽӿڵĲ�������
			if(arguments.length != 2){
				throw new Error("�쳣,��������ȷ");
			}
			this.name = name;
			this.methods = [];
			for(var x = 0;x < methods.length;x++){
				if(methods[x] && typeof(methods[x]) === "string"){
					//ȷ�������������ַ���
					this.methods.push(methods[x]);
				}else{
					throw new Error(methods[x] + " - ����String����")
				}
			}
		}

		/**
		 * ʵ�����ӿڶ���
		 */
		var CompositeInterface = new Interface("CompositeInterface",["add","remove"]);
		var FormItemInterface = new Interface("FormItemInterface",["select"]);

		/**
		 * ����ʵ����
		 * CompositeImpl implements CompositeInterface,FormItemInterface
		 */
		function CompositeImpl(){
			
		}

		/**
		 * �ӿڷ���ʵ��
		 */
		CompositeImpl.prototype.add = function(o){console.log("add")}
		CompositeImpl.prototype.remove = function(o){console.log("remove")}
		CompositeImpl.prototype.select = function(o){console.log("select")}



		/**
		 * ����ʵ�ַ���,���� Interface �ľ�̬����
		 */
		Interface.ensureImplements = function(instance,interfaces){
			if(!(instance && interfaces)){
				throw new Error("�����쳣");
			}
			for(var x = 0;x < interfaces.length;x++ ){
				//�ӿ�
				var inter = interfaces[x];
				//�жϲ����Ƿ��ǽӿ�������
				if(!(inter.constructor === Interface)){
					throw new Error("�ӿڲ��� Interface ����");
				}
				//������ǰ�ӿ��еĳ��󷽷�����
				for(var j = 0 ; j < inter.methods.length ; j++ ){
					var method = inter.methods[j];
					var prop = instance[method];
					if(!prop || typeof(prop) !== 'function'){
						//���Բ�����,�������ԷǺ���,��ô�ж����󷽷�δʵ��
						throw new Error("����["+method+"]δʵ��");
					}
				}
			}
		}

		/**
		 * ��������
		 */
		var c = new CompositeImpl();

		/**
		 * ִ�м���
		 */
		Interface.ensureImplements(c,[CompositeInterface,FormItemInterface]);

		
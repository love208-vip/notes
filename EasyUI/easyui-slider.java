-----------------------
EasyUI-slider			|
-----------------------
	# �����������û���һ�����޵ķ�Χ��ѡ��һ����ֵ��������ؼ����Ź���ƶ���ʱ�򣬽�����ʾһ����ʾ����ʾ��ǰֵ���û�����ͨ�������������Զ��廬�顣
	# �̳й�ϵ
		draggable

-----------------------
EasyUI-slider	����	|
-----------------------
	width
		* �������Ŀ��
	
	height
		* �������ĸ߶�
	
	mode
		* �����������Ĺ�������
		* ����ֵ�У�'h'(ˮƽ)��'v'(��ֱ)��
	
	reversed
		* �����ֵΪ true
		* �����ֵҲ��Сֵ�ύ��˳��
	
	showTip
		* ʵ����ʾֵ��Ϣ��ʾ
	
	disabled
		* �Ƿ���û�����
	
	range
		* �����Ƿ���ʾ����ķ�Χ
		* Ĭ��ֵΪ false
	
	value
		* Ĭ��ֵ
	
	min
		* ������Сֵ
	
	max
		* ��������ֵ
	
	step
		* ֵ���ӻ��߼���
	
	rule
		* ��ʾ��ǩ�ԱߵĻ��飬'|' �� ֻ��ʾһ�С�
		* ������һ�� array
	
	tipFormatter
		* �ú������ڸ�ʽ�������������ص��ַ���ֵ����ʾ��ʾ��
		* ������һ�� function
	
	converter
		* ��ת�������������û�������ν�һ��ֵת��Ϊ������λ�û������λ��ֵ��
		* demo
			$('#ss').slider({
				converter:{
					toPosition:function(value, size){
						var opts = $(this).slider('options');
						return (value-opts.min)/(opts.max-opts.min)*size;
					},
					toValue:function(pos, size){
						var opts = $(this).slider('options');
						return opts.min + (opts.max-opts.min)*(pos/size);
					}
				}
			});
	


-----------------------
EasyUI-slider	�¼�	|
-----------------------
	onChange
		* ���ֶ�ֵ���ĵ�ʱ�򴥷�
		* ����������:newValue, oldValue
	
	onSlideStart
		* �ڿ�ʼ�϶���������ʱ�򴥷�
		* ����Ϊ :value
	
	onSlideEnd
		* �ڽ�����ק��������ʱ�򴥷�
		* ����Ϊ :value
	onComplete
		* �ڻ���ֵ���û��ı��ʱ�򴥷����������϶����ǵ������
		* ����Ϊ :value
	

-----------------------
EasyUI-slider	����	|
-----------------------
	options
		* ���ػ���������
	
	destroy
		* ���ٻ���������
	
	resize
		* ���û�������С
		* ������һ������{width:x,height:y}
	
	getValue
		* ��ȡ��������ֵ
	
	getValues
		* ��ȡ��������ֵ����
	
	setValue
		* ���û�������ֵ
	
	setValues
		* ���û�����ֵ����
	
	clear
		* �����������ֵ
	
	reset
		* ���û�������ֵ
	
	enable
		* ���û������ؼ�
	
	disable
		* ���û������ؼ�

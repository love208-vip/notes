--------------------------
javascript-window			|
--------------------------

--------------------------
javascript-����				|
--------------------------
	innerHeight
		*����������ڵ��ڲ��߶�
	innerWidth 
		* ��������ڵ��ڲ����
	parent
		* ���ظ������ڵ�window����
	to
		* ��������Ĵ��ڵ�window
	opener
		* ���ش����˴��ڵ�����

--------------------------
javascript-����				|
--------------------------
	alert("����");					
		* ������ʾ��

	confirm("��");				
		* ����һ������[ȷ��],[ȡ��]����ʾ��,�÷����᷵��һ��Bolleanֵ

	prompt("���������п�����");		
		* ����һ�����ı������ĵ���,��������ֵ

	open(url,name,features,replace);
		* ��һ���µĴ���
		* url		:��ʾ�򿪵ĵ�ַ,���û��,��ô���Ǵ�һ���հ�ɶҲû��
		* name		:һ��Ϊ��,��ʾ�򿪵ķ�ʽ
		* features	:��ʾ�´򿪴��ڵ�����
		* replace	:

	opener;			
		* ���ش����˴��ڵ�window����
		* ����:var main = window.opener;	
		* ��ômian,���Ǵ�����������ڵ� window ����.ͨ�����ڿ細�ڲ���

	close();						
		* �رմ���,��������ݱȽϲ�,��ĳЩ������¹��ƻ᲻��ʹ

	setInterval(fun,10);		
		* ��ʱ��,ÿ��10�������һ��demo();���������
		* ��������᷵��һ��id
		* Demo
			var x = 0;
			var intervalId = window.setInterval(function(){
				x++;
				if(x == 10){
					clearInterval(intervalId);
				}
				console.log(new Date().getTime());			
			},1000);
			

	clearInterval(id);				
		* ���ָ���Ķ�ʱ��,���ݶ�ʱ����id

	setTimeOut(fun,10);		
		* ��10�����,ȥִ��ָ���ĺ���,Ҳ����ֱ����JS����,������ִ��һ��,Ҳ�᷵��һ��id

	clearTimeOut(id);				
		* ���ָ���ĵ��ζ�ʱ��,���ݶ�ʱ����id

	moveBy(200,400);				
		* ƫ�Ƶ�һ��λ��,����ֵ��ƫ��ֵ,���ݵ�ǰλ�ö���ֵ

	moveTo(200,400);				
		* �ƶ���һ��λ��,������Ļ������

	resizeTo();
		* ���µ����������С

	focus();						
		* �ô���һֱ��ȡ����,Ҳ����һֱ����ǰ��״̬
	
	scrollBy(x,y);
		* �����ɰ����ݹ���ָ������������
		* ע��:Ҫʹ�˷������� window �������Ŀɼ����Ա�������Ϊtrue��	

	scroll();
		
	scrollTo(x,y);
		* scrollTo() �����ɰ����ݹ�����ָ�������ꡣ

--------------------------
javascript-�¼�				|
--------------------------
	onload
		* �������ĵ��������ִ��
	
	onstorage
		* ���¼�Ӧ��ע�ᵽwindow������
		* �¼��������������
			key				//key
			newValue		//��ֵ
			oldValue		//������²���,��ֵΪnull
			storageArea		//�� localStorage ���� sessionStorage
			url				//��ǰURL

		* ����¼����ڹ㲥�¼�,��֪ͨ��ǰ������д򿪵�������ͬ��ҳ��
		* ��ͬԴҳ���ĳ��ҳ���޸���localStorage,�����ͬԴҳ��ֻҪע����storage�¼����ͻᴥ��
		* ��ͬһ����ҳ�޸ı��ش洢������ͬһ����ҳ������������û��Ч���ġ�
		* Chrome �±���������ҳ�津����IE,Firefox ���Ա�ҳ�津��
		* demo	
			window.addEventListener('storage',function(event){
				
			});
	
	onbeforeunload
		* �ڴ��ڹر�֮ǰִ��
	
	onunload
		* �ڴ��ڹر�֮��ִ��
	
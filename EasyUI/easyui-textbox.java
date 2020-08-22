---------------------------
EasyUI-textbox				|
---------------------------
	# TextBox(�ı���)��һ����ǿ�������ֶ������ �������û��ǳ��򵥵Ĵ���һ���������һ�����ڹ���������Ͽؼ��Ļ���������磺combo��databox��spinner�� 
	# �̳й�ϵ
		validatebox 
		linkbutton

---------------------------
EasyUI-textbox			����|
---------------------------
	width
		* ����Ŀ��
	
	height
		* ����ĸ߶�
	
	prompt
		* ���������ʾ����ʾ��Ϣ
	
	value
		* Ĭ��ֵ
	
	type
		* �ı������͡�����ֵ�У�"text"��"password"��
	
	multiline
		* �����Ƿ��Ƕ����ı���
	
	editable
		* �����û��Ƿ����ֱ���ڸ��ֶ����������֡�
	
	disabled
		* �����Ƿ���ø��ֶΡ�
	
	readonly
		* ����ÿؼ��Ƿ�ֻ��
	
	icons
		* ������һ������
		* ���ı���ɾ������ͼ�ꡣÿһ����������ԣ�
			iconCls		//����string��ͼ���class���ƣ�
			disabled	//����boolean��ָ���Ƿ���ø�ͼ�ꣻ
			handler		//����function�����ڴ�������ͼ���Ժ�Ķ����� 
	
			$('#tb').textbox({
				icons: [{
					iconCls:'icon-add',
					handler: function(e){
						$(e.data.target).textbox('setValue', 'Something added!');
					}
				},{
					iconCls:'icon-remove',
					handler: function(e){
						$(e.data.target).textbox('clear');
					}
				}]
			})
					
	iconCls
		* ���ı�����ʾ����ͼ��
	
	iconAlign
		* ����ͼ��λ��.ֵ�У�"left", "right"��
	
	iconWidth
		* ͼ��Ŀ��
	
	buttonText
		* �ı��򸽼Ӱ�ť��ʾ���ı����ݡ�
	
	buttonIcon
		* �ı��򸽼Ӱ�ť��ʾ��ͼ�ꡣ
	
	buttonAlign
		* ������ť��λ��,��ӵ�е�ֵ�У�"left", "right"��
	

---------------------------
EasyUI-textbox			�¼�|
---------------------------
	'�¼���չ�� validatebox���������������ı����¼���'
	onChange
		* ���ֶ�ֵ���ĵ�ʱ�򴥷�
		* newValue, oldValue
	
	onResize
		* ���ı����С���ĵ�ʱ�򴥷�
		* width, height
	
	onClickButton
		* ���û������ť��ʱ�򴥷�
	
	onClickIcon
		* ���û����ͼ���ʱ�򴥷�
		* index
	
	
---------------------------
EasyUI-textbox			����|
---------------------------
	'������չ�� validatebox���������������ı��򷽷���'
	options
		* �������Զ���
	
	textbox
		* �����ı������
		* demo
			var t = $('#tt');
			t.textbox('textbox').bind('keydown', function(e){
				if (e.keyCode == 13){	// �����»س���ʱ���������ֵ��
					t.textbox('setValue', $(this).val());
				}
			});
	
	button
		* ������ť����
	
	destroy
		* �����ı������
	
	resize
		* �����ı���������
		* ������ width
	
	disable
		* �������
	
	enable
		* �������
	
	readonly
		* ����/����ֻ��ģʽ
		* demo
			$('#tb').textbox('readonly');        // ����ֻ��ģʽ
			$('#tb').textbox('readonly',true);	// ����ֻ��ģʽ
			$('#tb').textbox('readonly',false);	// ����ֻ��ģʽ
		
	clear
		* �������е�ֵ
	
	reset
		* ��������е�ֵ
	
	initValue
		*����ʼ�����ֵ�����ø÷������ᴥ����onChange���¼���
	
	setText
		* ������ʾ���ı�ֵ
		* ����:text
	
	getText
		* ��ȡ��ʾ���ı�ֵ
	
	setValue
		* ���������ֵ
		* ����:value

	getValue
		* ��ȡ�����ֵ
	
	getIcon
		* ��ȡָ��ͼ�����



		

	





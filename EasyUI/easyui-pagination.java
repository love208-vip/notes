------------------------
EasyUI-Pagination		|
------------------------
	# ��ҳ
	# ����
		easyui-pagination
	# �̳й�ϵ
		linkbutton

------------------------
EasyUI-Pagination����	|
------------------------
	total
		* �ܼ�¼��,�ڷ�ҳ�ռ��ʼ����ʱ��ֵ
		* ������ Number

	pageSize
		* ҳ���С,Ҳ����ÿҳ��ʾ��������¼
	
	pageNumber
		* �ڷ�ҳ�ؼ�������ʱ����ʾҳ��
	
	pageList
		* �û����Ըı��ҳ���С
		* �����û����Կ���ÿҳ��ʾ���������ݵ�ѡ��
		* demo
			$('#pp').pagination({
				pageList: [10,20,50,100]
			});
	
	loading
		* ���������Ƿ���������
		* ������ boolean

	buttons
		* ����һ���Զ���İ�ť
		* ������һ������
			[
				{
					//��ť��ͼ����ʽ
					iconCls:'icon-add',
					handler:function(){
						//��ť����¼�
					}
				},'-',		//�ָ���
				{
					iconCls:'icon-save',
					handler:function(){}
				}
			]
		* ����Ҳ������һ��ѡ����
			buttons:'#btnDiv'
		
	layout
		* ��ҳ�ؼ���������
		* ����ѡ����԰���һ������ֵ��
			1) list		//ҳ����ʾ�����б�
			2) sep		//ҳ�水ť�ָ��ߡ�
			3) first	//��ҳ��ť��
			4) prev		//��һҳ��ť��
			5) next		//��һҳ��ť��
			6) last		//βҳ��ť��
			7) refresh	//ˢ�°�ť��
			8) manual	//�ֹ����뵱ǰҳ�������
			9) links	//ҳ�������ӡ�
		* demo
			$('#pp').pagination({
				layout:['first','links','last']
			});
			
	links
		* ������һ�� Number
		* �����������ڡ�links��������ڡ�layout���е�ʱ����Ч��
	
	showPageList
		* �Ƿ���ʾҳ�浼���б�
	
	showRefresh
		* �Ƿ���ʾˢ����ť
	
	beforePageText
		* ���������֮ǰ��ʾһ�� label ��ǩ
	
	afterPageText
		* ���������֮����ʾһ�� label ��ǩ
	
	displayMsg
		* ��ʾҳ����Ϣ
		* ������һ�� String


------------------------
EasyUI-Pagination�¼�	|
------------------------
	onSelectPage
		* �û�ѡ��һ����ҳ���ʱ�򴥷����ص���������2������
			pageNumber		//�µ�ҳ����
			pageSize:		//ҳ���С��ÿҳ��ʾ���������� 
		* demo
			$('#pp').pagination({
				onSelectPage:function(pageNumber, pageSize){
					$(this).pagination('loading');
					alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
					$(this).pagination('loaded');
				}
			});
	
	onBeforeRefresh
		* �ڵ��ˢ�°�ťˢ��֮ǰ����������false����ȡ��ˢ�¶�����
		* ����:pageNer, pageSizeumb
	
	onRefresh
		* ��ˢ��֮�󴥷�
		* ����:pageNer, pageSizeumb
	
	onChangePageSize
		* ��ҳ�����ҳ���С��ʱ�򴥷�
		* ����:pageSize


------------------------
EasyUI-Pagination����	|
------------------------
	options
		* ���ز�������
	
	loading
		* ���ѿؼ����ڼ�����
	
	loaded
		* ���ѷ�ҳ�ռ�������
	
	refresh
		* ˢ�²���ʾ��ҳ����Ϣ,������һ�����ö���
		* demo
			$('#pp').pagination('refresh');	// ˢ�·�ҳ����Ϣ
			$('#pp').pagination('refresh',{	// �ı�ѡ�ˢ�·�ҳ����Ϣ
				total: 114,
				pageNumber: 6
			});
	
	select
		* ѡ��һ����ҳ��,ҳ��������1��ʼ
		* demo
			$('#pp').pagination('select');            // ˢ�µ�ǰҳ
			$('#pp').pagination('select', 2);        // ѡ��ڶ�ҳ
	


	





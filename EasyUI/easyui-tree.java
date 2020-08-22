------------------------
Easyui-tree				|
------------------------
	# ���ؼ���webҳ����һ�����ֲ����������νṹ������ʾ�����ṩ�û�չ�����۵�����ק���༭���첽���صȹ��ܡ�
	# �̳й�ϵ
		draggable
		droppable

	# ����tree�ĵ�һ�ַ�ʽ
		1,ֱ��д������
			<ul id="tt" class="easyui-tree">   
				//�����Ӳ˵���һ���˵�
				<li>   
					<span>Folder</span>   
					<ul>   
						//�����Ӳ˵��Ķ����˵�
						<li>   
							<span>Sub Folder 1</span>   
							<ul>   
								<li>   
									<span><a href="#">File 11</a></span>   
								</li>   
								<li>   
									<span>File 12</span>   
								</li>   
								<li>   
									<span>File 13</span>   
								</li>   
							</ul>   
						</li>   
						//�������Ӳ˵��Ķ����˵�
						<li>   
							<span>File 2</span>   
						</li>   
						<li>   
							<span>File 3</span>   
						</li>   
					</ul>   
				</li>   
				//�������Ӳ˵���һ���˵�
				<li>   
					<span>File21</span>   
				</li>   
			</ul>
		1,ͨ��Զ�̵�ַ����
			* ֱ��дһ������<ul> -- <ul id="tt"> </ul>
			* ͨ��һ��Զ�̵�ַ,����tree������
			$(function(){
				$('#tt').tree({
					//�����ַ
					url:'tree_data.json' ,
					lines:true,
				});
			});
	
	# easyui�ڵ���Ҫ�߱�������
		id			�ڵ�ID���Լ���Զ�����ݺ���Ҫ��
		text		��ʾ�ڵ��ı���
		state		�ڵ�״̬��'open' �� 'closed'��Ĭ�ϣ�'open'�����Ϊ'closed'��ʱ�򣬽����Զ�չ���ýڵ㡣
		checked		��ʾ�ýڵ��Ƿ�ѡ�С�
		attributes	����ӵ��ڵ���Զ������ԡ�
		children	һ���ڵ��������������ɽڵ㡣
		attributes	����һ����������,������Զ���һЩ�Զ��������

		{
			id:"123",
			text:"�ڵ�����",
			state:"opend",
			checked:true,
			attributes:{
				key1:"value",
				key2:"value"
			},
			children:[
				{
					id:"123",
					text:"�ڵ�����",
					state:"opend",
				}	
			],
		}
					

------------------------
Easyui-����				|
------------------------
	url
		* ����Զ�̼��� tree ���ݵ� url
	
	method
		* HTTP����ʽ,Ĭ��POST
	
	animate
		* ����ڵ���չ�����۵���ʱ���Ƿ���ʾ����Ч����
	
	checkbox
		* �����Ƿ���ÿһ�����֮ǰ����ʾ��ѡ��
	
	cascadeCheck
		* �Ƿ��Ǽ���ѡ��,����ѡ���˸��ڵ�������ӽڵ�,��ô���ڵ����һ����ѡ��״̬.���ȫ���ӽڵ㶼ѡ����,��ô���ڵ����һ��ȫѡ��״̬
		* Ĭ��ֵΪ false,Ҳ���ǲ�����.��˭,��˭.�����Ľڵ㶼û�仯
	
	onlyLeafCheck
		* �Ƿ�ֻ����ĩ�ڵ�֮ǰ��ʾ��ѡ��,��ʵ����˵.ֻ������һ���ڵ�.���и�ѡ��Ĵ���
	
	lines
		* �Ƿ���ʾ����,Ĭ��ֵ�� false,Ҳ���ǲ���ʾ

	dnd
		* ���ǿ����������ק�ڵ�.���Լ��Ķ��Ӹ�����,�ѱ��˵İְָ���... ...

	data
		* �ڵ����ݼ��ء� 
		* demo
			$('#tt').tree({
				data: [{
					text: 'Item1',
					state: 'closed',
					children: [{
						text: 'Item11'
					},{
						text: 'Item12'
					}]
				},{
					text: 'Item2'
				}]
			});
	
	queryParams
		* ������Զ�����ݵ�ʱ��,�����ύ�Ĳ���
		* ������һ������
	
	formatter
		* ���������Ⱦ�ڵ���ı���
		* demo
			$('#tt').tree({
				formatter:function(node){
					return node.text;
				}
			});
	
	filter
		* ������ι��˱���չʾ�����ݣ�����true������ڵ����չʾ��
		* function (q,node){}
	
	loader
		* ������δ�Զ�̷������������ݡ�����false���Ժ��Ա��������ú����߱����²�����\
			param			//���͵�Զ�̷������Ĳ�������
			success(data)	//���������ݳɹ���ʱ����õĻص�������
			error()			//����������ʧ�ܵ�ʱ����õĻص�������
	
	loadFilter
		* ���ع��˹������ݽ���չʾ�����������Ǳ�׼����ʽ���ú����߱����²�����
			data	//���ص�ԭʼ���ݡ�
			parent:	//DOM���󣬴����ڵ㡣 
	
	checked
		* �Ƿ�ѡ��ǰ�ڵ�,������:true/false
		* ǰ��϶��ǿ�����:checkbox : true


------------------------
Easyui-�¼�				|
------------------------
	�ܶ��¼��Ļص�����������'node'��������߱��������ԣ�
		id			//�󶨽ڵ�ı�ʶֵ��
		text		//��ʾ�Ľڵ��ı���
		iconCls		//��ʾ�Ľڵ�ͼ��CSS��ID��
		checked		//�ýڵ��Ƿ�ѡ�С�
		state		//�ڵ�״̬��'open' �� 'closed'��
		attributes	//�󶨸ýڵ���Զ������ԡ�
		target		//Ŀ��DOM����
	
	
	onClick
		* �ڽڵ㱻�����ʱ��ִ��
		* ��һ������:node,���ǵ��������ڵ����Ϣ����

			$('#tt').tree({
				onClick: function(node){
					alert(node.target);  // ���û������ʱ����ʾ
				}
			});

	onDblClick
		* �ڽڵ㱻˫����ʱ�򴥷�
		* ��һ������:Node,���Ǳ�˫���Ľڵ���Ϣ����
			onDblClick:function(node){
				//˫����/���߹رսڵ�ڵ�
				$('#tt').tree('toggle',node.target);
			}
	
	onBeforeLoad
		* ���������Զ������֮ǰ����������false����ȡ�����ز�����
		* ����:node, param

	onLoadSuccess
		* ������(�ڵ�)���سɹ��󴥷�
		* ����ͨ�������ʵ��'�첽ȫչ��'��Ч��
		* ����������:
			node		//���ݸ���̨�ڵ��ֵ
			data		//���Ǻ�̨��Ӧ����ֵ
		$('#tree').tree({
			//��̨������Ӧ�ɹ�,������������
			onLoadSuccess:function(node,data){
				/*
					ִ��չ�����нڵ�
					��ÿ��չ����Ҫ�����̨���ᴥ������¼�
					����¼��͵ݹ�ִ����
				*/
				if(data){
					//������̨��Ӧ�Ľڵ�
					$(data).each(function(index,d){
						/*
							����ǹر�״̬,��ִ�д򿪲���
							�򿪲���,�ֻ������̨������.�ֻᴥ������¼�
							��̨���߼�:������ӽڵ�,���� closed ״̬,���û�ӽڵ�,���� open ״̬
						*/
						if(this.state == 'closed'){
							$('#tree').tree('expandAll');
						}
					});
				}
			}
		});

	onLoadError
		* ��Զ�����ݼ���ʧ�ܵ�ִ��
		* ��һ������:arguments
		* arguments������jQuery��$.ajax()���������'error'�ص������Ĳ�����ͬ��
		* arguments ��ʵ���Ƿ�������Ӧ������JSON��Ϣ
		��

	onBeforeExpand
		* �ڽڵ�չ��֮ǰ����
		* ���� false ����ȡ���ò���
		* ����: node

	onExpand
		* �ڽڵ�չ����ʱ�򴥷�
		* ����: node

	onBeforeCollapse
		* �ڽڵ��۵�֮ǰ����������false����ȡ���۵�������
		* ����: node

	onCollapse
		* �ڽڵ��۵���ʱ�򴥷���
		* ����:node

	onBeforeCheck
		* ���û������ѡ��ѡ��֮ǰ����������false����ȡ��ѡ������
		* ����:node, checked

	onCheck
		* ���û������ѡ��ѡ���ʱ�򴥷���
		* ����:node, checked
		* Demo
			//��ѡ��ʱ��,����и����˵�,ȫ����ѡ
			//ȡ����ѡ��ʱ��,������Ӳ˵�,ȫ��ȡ����ѡ
			onCheck:function (node, checked) {
                    if(checked){
                        //��ѡ,���ڸ����˵�
                        var parent = $(this).tree('getParent',node.target);
                        if(parent != null){
                            $(this).tree('check',parent.target);
                        }
					}else {
                        //ȡ����ѡ,�����Ӳ˵�
                        var childrens = $(this).tree('getChildren',node.target);
                        if(childrens != null && childrens.length != 0){
                            for(var x = 0;x < childrens.length ; x++){
                                $(this).tree('uncheck',childrens[x].target);
                            }
                        }
					}
                },

	onBeforeSelect
		* ���û������ѡ��ѡ��֮ǰ����������false����ȡ��ѡ����
		* ����:node, checked
	
	onSelect
		* ���û�ѡ��ڵ��ʱ�򴥷���
		* ����:node
	

	onContextMenu
		* �һ��ڵ��ʱ�򴥷��¼�
		* ����������:e:�¼�,node:���һ��Ľڵ�
			onContextMenu:function(e,node){
				//��ֹ��������һ��¼�
				e.preventDefault();
				//��ʾ�����Զ���Ĳ˵�
				$('#treeMenu').menu('show',{
					//�˵���λ������������ĵط�
					left:e.pageX,
					top:e.pageY
				});
			}
	
	onBeforeDrag
		* �ڿ�ʼ�϶��ڵ�֮ǰ����������false���Ծܾ��϶���
		* ����:node
	
	onStartDrag
		* �ڽڵ㿪ʼ�϶���ʱ�򴥷�
		* ����:node
	
	onStopDrag
		* �ڽڵ�ֹͣ�϶���ʱ�����
		* ����:node

	onDragEnter
		* ���϶�һ���ڵ���뵽ĳ��Ŀ��ڵ㲢�ͷŵ�ʱ�򴥷�������false���Ծܾ��϶���
			target		//�ͷŵ�Ŀ��ڵ�Ԫ�ء�
			source		//��ʼ�϶���Դ�ڵ㡣
	
	onDragOver
		* ���϶�һ���ڵ㾭��ĳ��Ŀ��ڵ㲢�ͷŵ�ʱ�򴥷�������false���Ծܾ��϶���
			target		//�ͷŵ�Ŀ��ڵ�Ԫ�ء�
			source		//��ʼ�϶���Դ�ڵ㡣
	
	onDragLeave
		* ���϶�һ���ڵ��뿪ĳ��Ŀ��ڵ㲢�ͷŵ�ʱ�򴥷�������false���Ծܾ��϶���
			target		//�ͷŵ�Ŀ��ڵ�Ԫ�ء�
			source		//��ʼ�϶���Դ�ڵ㡣		
	
	onBeforeDrop
		* ���϶�һ���ڵ�֮ǰ����������false���Ծܾ��϶���
			target	//�ͷŵ�Ŀ��ڵ�Ԫ�ء�
			source	//��ʼ�϶���Դ�ڵ㡣
			point	//��ʾ��һ���϶�����������ֵ�У�'append','top' �� 'bottom'��
	
	onDrop
		* ���ڵ�λ�ñ��϶�ʱ������
			target		//DOM������Ҫ���϶�����Ŀ��ڵ㡣
			source		//Դ�ڵ㡣
			point		//��ʾ��һ���϶�����������ֵ�У�'append','top' �� 'bottom'��
	
	onBeforeEdit
		* �ڱ༭�ڵ�֮ǰ������
		* ����:node
	
	onAfterEdit
		* �ڽڵ�༭֮�󴥷�
		* ����:node
	
	onCancelEdit
		* ��ȡ���༭������ʱ�򴥷�
	
	

------------------------
Easyui-����				|
------------------------
	options
		* �������ؼ����ԡ�
	
	loadData
		* ��ȡ���ؼ����ݡ�
		* ����:data
	
	getNode
		* ��ȡָ���ڵ����
		* ����:target
	
	getData
		* ��ȡָ���ڵ����ݣ����������ӽڵ㡣
		* ����:target
	
	reload
		* �����������ؼ����ݡ�
		* ����:target
	
	getRoot
		* ��ȡͨ����nodeEl������ָ���Ľڵ�Ķ������ڵ�Ԫ�ء�
	
	getRoots
		* ��ȡ���и��ڵ㣬���ؽڵ����顣
	
	getParent
		* ��ȡ���ڵ㣬'target'��������ڵ��DOM����
		* ����:target
	
	getChildren
		* ��ȡ�����ӽڵ㣬'target'��������ڵ��DOM����
		* ����:target
	
	getChecked
		* ��ȡ����ѡ�еĽڵ㡣
		* 'state'����ֵ�У�'checked','unchecked','indeterminate'��
		* ���'state'δָ����������'checked'�ڵ㡣 
		* demo
			var nodes = $('#tt').tree('getChecked');	// get checked nodes
			var nodes = $('#tt').tree('getChecked', 'unchecked');	// ��ȡδѡ��ڵ�
			var nodes = $('#tt').tree('getChecked', 'indeterminate');	// ��ȡ��ȷ���Ľڵ�
			����ע����1.3.4������ȡ��ʽ��
			var nodes = $('#tt').tree('getChecked', ['unchecked','indeterminate']);
	
	getSelected
		* ��ȡѡ��ڵ㲢�����������δѡ���򷵻�null��
	
	isLeaf
		* �ж�ָ���Ľڵ��Ƿ���Ҷ�ӽڵ㣬target������һ���ڵ�DOM����
	
	find
		* ����ָ���ڵ㲢���ؽڵ����
		* ����:id
		* demo
			// ����һ���ڵ㲢ѡ����
			var node = $('#tt').tree('find', 12);
			$('#tt').tree('select', node.target);
	
	select
		* ѡ��һ���ڵ㣬'target'������ʾ�ڵ��DOM����
		* ����:target
	
	check
		* ѡ��ָ���ڵ㡣
		* ����:target
	
	uncheck
		* ȡ��ѡ��ָ���ڵ㡣
		* ����:target
	
	collapse
		* �۵�һ���ڵ㣬'target'������ʾ�ڵ��DOM����
		* ����:target
	
	expand
		* չ��һ���ڵ�
		* 'target'������ʾ�ڵ��DOM����
		�ڽڵ�رջ�û���ӽڵ��ʱ�򣬽ڵ�ID��ֵ(��Ϊ'id'�Ĳ���)���ᷢ�͸������������ӽڵ�����ݡ� 
	
	collapseAll
		* �۵����нڵ㡣
		* ����:target
	
	expandAll
		* չ�����нڵ㡣
		* ����:target
	
	expandTo
		* �򿪴Ӹ��ڵ㵽ָ���ڵ�֮������нڵ㡣
		* ����:target
	
	scrollTo
		* ������ָ���ڵ㡣
		* ����:target
	
	append
		* ׷�������ӽڵ㵽һ�����ڵ㣬param������2�����ԣ�
			parent	//DOM���󣬽�Ҫ��׷���ӽڵ�ĸ��ڵ㣬���δָ�����ӽڵ㽫��׷�������ڵ㡣
			data	//���飬�ڵ����ݡ�
	
	toggle
		* �򿪻�رսڵ�Ĵ�������target������һ���ڵ�DOM����
	
	insert
		* ��һ��ָ���ڵ�֮ǰ��֮�����ڵ㣬'param'���������������ԣ�
			before	//DOM������ĳ���ڵ�֮ǰ���롣
			after	//DOM������ĳ���ڵ�֮����롣
			data	//���󣬽ڵ����ݡ� 
		
		* demo
			//����Ĵ���չʾ����ν�һ���½ڵ���뵽ѡ��Ľڵ�֮ǰ��
			var node = $('#tt').tree('getSelected');
			if (node){
				$('#tt').tree('insert', {
					before: node.target,
					data: {
						id: 21,
						text: 'node text'
					}
				});
			}
			����ע����1.3.4������ȡ��ʽ��var node = $('#tt').tree('getSelected');
			if (node){
				$('#tt').tree('insert', {
					before: node.target,
					data: [{
						id: 23,
						text: 'node23'
								},{
							text: 'node24',
									state: 'closed',
						children: [{
						text: 'node241'
						},{
						text: 'node242'
						}]
								}]
				});
			}
	
	remove
		* �Ƴ�һ���ڵ�������ӽڵ㣬'target'�����Ǹýڵ��DOM����
	
	pop
		* �Ƴ�һ���ڵ�������ӽڵ㣬�÷�����remove����һ������ͬ�����������ر��Ƴ��Ľڵ����ݡ�
	
	update
		* ����ָ���ڵ㡣'param'���������������ԣ�
			target(DOM���󣬽������µ�Ŀ��ڵ�)��id��text��iconCls��checked�ȡ�
		* demo
			// ����ѡ��Ľڵ��ı�
			var node = $('#tt').tree('getSelected');
			if (node){
				$('#tt').tree('update', {
					target: node.target,
					text: 'new text'
				});
			}
	
	enableDnd
		* ������ק���ܡ�
	
	disableDnd
		* ������ק���ܡ�
	
	beginEdit
		* ��ʼ�༭һ���ڵ㡣
		* ����:target
	
	endEdit
		* �����༭һ���ڵ�
		* ����:target
	
	cancelEdit
		* ȡ���༭һ���ڵ�
		* ����:target
	
	doFilter
		* ���˲�������filter���Թ�������
		* ����:text
		* demo
			$('#tt').tree('doFilter', 'easyui');
			$('#tt').tree('doFilter', '');	// ���������
	


	# ����Node��target
		target�� Node.target�ķ���ֵ
		һ��,�¼��ᴫ��һ��Node����,�����˵�ķ���.������Ҫtarget�������
		

-------------------
Demo				|
-------------------
	# ��ѡ��ʱ��,�Ṵѡ���еĸ����˵�
	# ȡ����ѡ��ʱ��,��ȡ����ѡ���е��Ӳ˵�
			
			onCheck:function (node, checked) {
                    if(checked){
                        //��ѡ,���ڸ����˵�
                        var parent = $(this).tree('getParent',node.target);
                        if(parent != null){
                            $(this).tree('check',parent.target);
                        }
					}else {
                        //ȡ����ѡ,�����Ӳ˵�
                        var childrens = $(this).tree('getChildren',node.target);
                        if(childrens != null && childrens.length != 0){
                            for(var x = 0;x < childrens.length ; x++){
                                $(this).tree('uncheck',childrens[x].target);
                            }
                        }
					}
                },
	
		
	# ͳһ���ݵķ��ظ�ʽ
	loadFilter:function (data,parent) {
	                if(!data.success){
	                    TD.showAlert(data.message);
	                    return [];
	                }
	                return data.data;
                },


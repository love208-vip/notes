------------------------
easyloader				|
------------------------
	# �ų�һ����N��
	# EasyUI�Ĳ�����ǵ������ڵ�JS�ļ�,��Ҫʹ���ĸ����,����Ҫ�����ĸ����,̫��
	# ����������Զ�̬������.˵����,��ֻҪ��������OK,Ȼ����ʹ���ĸ����,ֻ��ʹ�����js����Ķ�����Ե���.��̬������
	
	# <script type="text/javascript" src="${pageContext.request.contextPath }/static/jquery-easyui-1.5/easyloader.js"></script>

	# easyloader.load('',function(){})

	# demo
		easyloader.load('dialog',function(){
			$('#div').dialog({
				title:'�Բ�',
				collapsible:true,
				resizable:true,
				minimizable:true,
				modal:true
			});
		});

		easyloader.load('ģ��/�������',function(){
			//�ص�����
		});
	
	# Ҳ����һ���Ե�������ģ��
		easyloader.load(['dialog','messager'],function(){
			$('#div').dialog({
				title:'�Բ�',
				collapsible:true,
				resizable:true,
				minimizable:true,
				modal:true
			});
			$.messager.alert('�Բ�');
		});

		* easyloader.load(),��һ������,����һ������
	
	# ţ��֮������,������һ��:easyloader.js,ֱ����HTMLԪ���ϱ�ʶeasyui����,Ҳ���Զ���������Ӧ��ģ��
		<div class="easyui-dialog" id="div" style="width: 300px;height: 100px;">
		</div>
		* ֱ�Ӿ���ôд,��������dialogģ��
	

	# using ,loader�ļ�д����
		using(['dialog','messager'],function(){
			//�ص�����
		});

		using('http://xxxxx.js',function(){
			//�ص�����
		});

		* ����ȥ����ָ�� URL�µĶ���
		* ������CSS,JS... ...�ȵ�
	
	# ԭ�����
		* '����ģ��ܶ�'						--> ����ָ��ģ���ʱ��,�Ǹ�ģ�������������ģ��..�ο�maven,���Ǻ�������һ��ѵĶ���
		* '����JS,Ҳ������Ⱦδ�����ģ��'		--> �����ǲ���JSҲ����ȾHTML��ǩ��easyui-xxx����
			//����д���
			window.using = easyloader.load;
			if (window.jQuery) {
				jQuery(function() {
					easyloader.load("parser",
					function() {
						jQuery.parser.parse();
					});
				});
			}
			* ������parser���,Ȼ�����������parse();����
			* ���������ţ����
				(function($){
					//�������,ֻҪ��������class��easyui��,�ͻ������Ⱦ
					$.parser : true,
					onComplete : function(){
						//��ƪ�ĵ�������֮�󴥷����¼�
					}
				});
			
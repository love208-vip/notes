----------------------------
1,Ext-����					|
----------------------------
	# ����4.1�汾
	# ���
		* ����JS
		* �е���Java Swing��MVC�ܹ�
		* ֧�������,ģ�黯���
		* �ṩ��������Դ֧��
		* ���������˵Ľ�������

	# Ŀ¼�ṹ
	# Web Site �� Web AppliCation ������
		Web Site:��չʾΪ��,����:���˲���,�Ż���վ
		Web AppliCation:Ӧ��,��ҵ���߼�Ϊ��CMSϵͳ

	# ����
	
	# ѧϰ��վ
		http://www.jeeboot.com/
		http://www.cnblogs.com/DonaHero/p/5983151.html
		http://blog.csdn.net/tianxiaode/article/details/51453630
		http://www.cnblogs.com/mlzs/

----------------------------
2,Ext-��������				|
----------------------------
	���(Compoment)
		# ֱ����ͼ�λ���ʽ��ʾ�������
		# ���л����Է�Ϊ������Ԫ�����
			* �������:�ܹ������������������Ԫ�������,�ǽ��е�Ԫ����������Ļ���
			* Ԫ���  :�ܹ�ͼ�λ���ʾһ��Ƭ�湦�ܵ����(����,��,�б�)
	��	
		# �ṩ���ܵķ�ͼ�λ�����,����Ϊͼ�����ṩ��������֧��
		# �����ܷ�Ϊ
			����֧����(data)
			�Ϸ�֧����(dd)
			����֧����(layout)
			����״̬�洢֧����(state-����Cookie)
			ʵ�ù�����(util)
		# �ܷ���:���ܱ���չ����
		# ԭ����:��չ��Javascript��׼����е���
		# ������
			Ext.define("����",{
				
			},function(){
				console.log("�ഴ�����");
			});
	����
		# ��Ϊ�๦�ܵ�����,�ܹ������ı����������仯��ֱ������
		# ������������ʽ�ɷ�Ϊ,private �� public(��ʵ��ȫ���û��Ծ�,û��ǿ��Ҫ��)

	�¼�
		# ���ඨ��,���ҿ��������������״̬�����ı��ʱ��,����
		# ֻ�б����ĵ��¼��Ż���Ч
		# �������Ҫ���¼�,Ӧ�ý����˶�,��ǿ�����ִ��Ч��

	����ѡ��
		# ���ڳ�ʼ��һ��Extjs�������ֶ�
		# ע��,����ѡ�һ����������,����������,Ҳ�п��ܳ������Է��ص��������㵱��ָ��������ѡ�����Ͳ�һ�µ����
	

	����
		# �ܹ��ڳ��������ڼ�,�ܹ�������,�����˽⵱ǰ���Ͷ����״̬
		# ʵ�ʿ�����,EXT����������,�Ƚϲ,��Ҫͨ���˽�Դ����.�����˽����ʹ�����Ե��ô�
	

	�����ռ�
		# �ѱ�д�õ�Extjs�������Ч��֯���ֶ�
		# ����EXT����֮Ϊ����AJAX��ܵ�����֮һ
		# ��ʵ������ô����
			Ext.namespace("com.kevin");
			package com.kevin;
	
----------------------------
3,��������					|
----------------------------
		
	1,���������ļ���
		ext-6.2.0\build\classic\theme-crisp
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/ext/theme-crisp/resources/theme-crisp-all.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/ext/theme-crisp/resources/theme-crisp-all-debug.css" />
	2,����JS�ļ�
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/ext/ext-bootstrap.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/ext/locale-zh_CN.js"></script>





----------------------------
4,API�ĵ�����				|
----------------------------
	xtype
		* �������
	Hierarchy
		* ��νṹ
	Inherited mixins
		* �������
	Requires
		* �������Ҫʹ�õ���
	Configs
		* �����������Ϣ
	Properties
		* ����������
	methods
		* ����ķ���
	events
		* ������¼�

----------------------------
5,֪ʶ��					|
----------------------------
	# ��������������ַ�ʽ
		var win = Ext.create('Ext.window.Window',{
			title:""
		});

		var win = new Ext.window.Window({
			title:""
		});
	
	# �����������
		items:[
			{
				xtype:'button',
				text:'����ӵ���ť���'
			},
			 new Ext.button.Button({
                text:"��Ҳ����ť",
                handler:function (e) {
                    alert("haha");
                }
            },
			 Ext.create('Ext.button.Button',{
                text:"��ť����",
                handler:function (e) {
                    alert("����");
                }
            }),
		]

	# ��ȡ�������

		* up();�������������е�������еķ���
		* ����������һ������� xtype ������ ѡ����
			tbar:[
				text:"������-��ť1",
				handler:function(e){
					//��ȡ��������window�������ı���
					var title = e.up('window').title;
				}
			]
		* ��ʵҲ����ֱ�� Ext.getCmp("����ID"); ��ȡ��ָ�������
		* ����һ�ַ�ʽ,���� ownerCt,�����Լ���������������߱���,���صľ���ֱ�Ӹ����������
			tbar:[
				text:"������-��ť1",
				handler:function(e){
					//��ȡֱ���������-tbar
					var tbar = e.ownerCt;
				}
			]
		

		

	
----------------------------
4,ͨ��Sencha����Ext��Ŀ		|
----------------------------
	1,��װSencha cmd����,��ҪJDK
	2,����ext.js,��ѹ��Ŀ¼
	3,ִ������
		sencha -sdk d:\ext-6.2.0 generate app myapp e:\myapp
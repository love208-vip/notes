-------------------------------
Beetl �Զ����ǩ				|
-------------------------------
	# ��ǩ��ʽ������
	
	# һ���Ǳ�ǩ����

	# �ڶ�����html tag
		* 'ʵ�������﷨������ʱ���ת���ɵ�һ��'
			* Ҳ��˵,tag ��ʵҲ�ᱻ����Ϊ fun
		* ��,ʵ����HTMLTagSupportWrapper�����ཫ��Ѱ��root/htmltagĿ¼��ͬ���ı�ǩ�ļ���Ϊģ����ִ�С�
		* ������ͨģ��һ�����ڴ˾Ͳ���ϸ˵��

	# HTML_TAG_FLAGĬ��Ϊ#���������Ƿ���beetl��html tag
	# ��Ҳ�������ó���������

-------------------------------
Beetl ��ǩ����					|
-------------------------------
	# ��ǩ��������jsp2.0��ʵ�ַ�ʽ����Ҫ�̳�Tag�������render��������
		org.beetl.core.Tage

	# ��beetl��,�ǵ���ģʽ,�����spring����,�ǵð� tagʵ������Ϊ�ǵ���

	# ��д����
		public class MyTag extends Tag{
			@Override
			public void render() {
				//��ǩ����(һ��ûɶ����)
				String tagName = (String) this.args[0];
				//��ȡ���ݽ���������map
				Map<String,Object> attrs = (Map<String, Object>) this.args[1];
				//������map�л�ȡname����ֵ
				String value = (String) attrs.get("name");
				try {
					//��Ӧ��ģ��
					this.ctx.byteWriter.writeString("���," + value);
				}catch (Exception e){
					throw new RuntimeException(e);
				}
			}
		}

	# tag���ṩ���������Ժͷ�����ʹ��
		args	�����ǩ�Ĳ���
		gt		GroupTemplate
		ctx		Context
		bw		��ǰ�������
		bs		��ǩ���Ӧ���﷨��������Ϥ��
	
	# �����·���
		protected void doBodyRender()
			* ��Ⱦ��ǩ��

		protected BodyContent getBodyContent()
			* ���ཫ���ø��෽��doBodyRender����Ⱦtag body��
			* ����
				BodyContent  content = getBodyContent();
				String content = content.getBody();
				String zip = compress(conent);			//���ø��෽��getBodyContent �����tag body��ѹ�����
				ctx.byteWriter.write(zip);


	# ע���ǩ����
		  grouptemplate.registerTag("mytag", MyTag.class);	
	
	# ʹ�ñ�ǩ����
		 <#mytag name="��ѽѽ"></#mytag>


-------------------------------
Beetl �󶨱�����HTML��ǩ		|
-------------------------------
	# Beetl�� ֧�ֽ���ǩʵ���ࣨjava���룩��Ķ�����Ϊ��ʱ����������ǩ�����á�
	# ��ʱ��Ҫʵ�� GeneralVarTagBinding (������Tag�����ࣩ 
	# �����ṩ���⼸������ 
		void binds(Object�� array) 
			* ������render��������ô�����ʵ�ֱ����󶨣���˳��ͬ��ģ����������˳�� 
		void bind(String name, Object value) 
			* ������render��������ô�����ʵ�ֱ����󶨣�name��ģ���������ı�����,�ô˷����󶨲���binds�������Ƽ�
		Object getAttributeValue (String name)
			* ��ñ�ǩ������ 
		Map getAttributes 
			* ��ñ�ǩ���������ԣ�
	
	# д��
		public class TagSample extends GeneralVarTagBinding{
				@Override
				public void render(){
						int limit = Integer.parseInt((String) this.getAttributeValue("limit"));
						for (int i = 0; i < limit; i++){
								this.binds(i)			//�� ���� i ����ǩ����һ��������
								this.doBodyRender();	//render������ѭ����Ⱦ��ǩ��limit�Σ���ÿ�ζ���value��ֵΪi
						}
				}
		}
		//��ĳ��ע��һ�±�ǩTagSample
		//gt.registerTag("tag", TagSample.class);
	
	# д��ǩ
		<#tag limit="3";value>
			${value}
		</#tag>

		* �����ڳ���html��ǩ����Ҫ�ڱ�ǩ���������Զ��������Ϸֺ� ";" �˷ֺű�ʾ�����һ����Ҫ�ڱ�ǩ����ʱ��Ҫ�󶨱����ı�ǩ�������Ҫ�󶨵ı����б�
		* ������ֻ����һ��value������'�����Ҫ�󶨶�����������ö��ŷֿ�'����var1,var2 �ϡ�
		* ������û�б����б�ֻ�зֺţ���'Ĭ�ϰ󶨵���ǩ��ͬ���ı�����'. �����ǩ�� namesapce ��Ĭ�ϰ󶨶��ı����������� namespace

		* ע�⣬���ڱ�ǩʹ����Ϊ̫�����ܻ��л������ı���ʽ�����»��У�Ŀǰbeetlֻ����������֮�任�У����򣬽�����ǩ��������

		* Ĭ������£������ǩ���Գ�����var(����ͨ�������ļ��ĳ�����������)��Ҳ��Ϊ�ǰ󶨱����ı�ǩ�������������Ҳ������ôд
			<#tag limit="3" var="value">
				${value}
			</#tag>

		* var���Ե�ֵ�����Ǹ��Զ��ŷֿ��ı������б���var="total,customer,index"
---------------------------
GroupTeamplate				|
---------------------------
	# Beetl����ͨ�������ļ���������GroupTemplate
	# ��Ҫ���ǵ�δ������IDE�����֧��Beetlģ�壬ģ������ԣ��ͺ����������ͨ�������ļ���ȡ����������IDE���ʶ��
	# ����GroupTemplate�����ַ���
		1,�����ļ�
		2,API
	

---------------------------
GroupTeamplate-�����ļ�		|
---------------------------
	# �����ļ�: Ĭ��������/org/beetl/core/beetl-default.properties ��
	# Beetl���ȼ��ش������ļ���Ȼ���ټ���classpath���beetl.properties,���ú��߸���ǰ�ߡ�
	# �����ļ���Ϊ������
	1,��������
		
	2,��Դ������
		RESOURCE_LOADER=org.beetl.core.resource.ClasspathResourceLoader
			# ��Դ���ã�resource�������ֻ�����ض�ResourceLoader
			# ��beetl��������ܼ��ɵ�ʱ��,ģ���������һ�������������(����Spring,����RESOURCE_LOADER��spring������Ϊ׼)

		RESOURCE.root= /
			#  ָ��ģ���Ŀ¼,����� classpath, '/'��ʾ���ڸ�Ŀ¼

		RESOURCE.autouCheck= true
			# �Ƿ����ļ��仯,Ĭ��Ϊ true ,�����������Զ����ģ���Ƿ����
		
	3,��չ����
		FN.date = org.beetl.ext.fn.DateFunction
		FN.nvl = org.beetl.ext.fn.NVLFunction
		.................
			# ���õķ���
		
		FNP.strutil = org.beetl.ext.fn.StringUtil
			# ���õĹ��ܰ�

		FT.dateFormat =  org.beetl.ext.format.DateFormat
		FT.numberFormat =  org.beetl.ext.format.NumberFormat
		.................
			# ���õĸ�ʽ������

		FTC.java.util.Date = org.beetl.ext.format.DateFormat
		FTC.java.sql.Date = org.beetl.ext.format.DateFormat
			# ���õ�Ĭ�ϸ�ʽ������

		TAG.include= org.beetl.ext.tag.IncludeTag
		TAG.includeFileTemplate= org.beetl.ext.tag.IncludeTag
		TAG.layout= org.beetl.ext.tag.LayoutTag
		TAG.htmltag= org.beetl.ext.tag.HTMLTagSupportWrapper
			# ��ǩ��
		
		* FNǰ׺-��ʾFunction
		* FNPǰ׺-��ʾFunctionPackage���߰�
		* FT-��ʾformat����
		* FTC-��ʾָ�����Ĭ��Format����
		* TAG-��ʾ��ǩ�ࡣ
		* Beetlǿ�ҽ���ͨ�������ļ�������չ���Ա����IDE�����ʶ����Щע�ắ��

---------------------------
GroupTeamplate-API			|
---------------------------
	# Configuration����أ���˼�����ɺ�Ҳ����ͨ������API���޸�������Ϣ
	# ͨ������GroupTemplate�ṩ�ķ�����ע�ắ������ʽ����������ǩ������
------------------------------
��ֹXSS����,HTMLת�幤����		|
------------------------------
	# common-lang3.jar
	# org.apache.commons.lang3.StringEscapeUtils
	# StringEscapeUtils.escapeHtml4(String js);
	# ���԰Ѵ����HTML�����JS����ת��Ϊת���ַ�,��ֹXSS��վ����

		String js =  "����<script>hi</script><h5></h5>";
		System.out.println(js);	//����<script>hi</script><h5></h5>
		js = StringEscapeUtils.escapeHtml4(js);
		System.out.println(js);	//����&lt;script&gt;hi&lt;/script&gt;&lt;h5&gt;&lt;/h5&gt;

		
		StringEscapeUtils.escapeHtml4();
			# ����HTML4����

		StringEscapeUtils.escapeEcmaScript()
			# ����ת��JS����

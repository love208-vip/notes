----------------------------
Beetl-�Զ����ʽ������		|
----------------------------
	# ��Ҫʵ�� Format �ӿ�
		org.beetl.core.Format
	
	# ��д����
		public Object format(Object data, String pattern);
	
	# ����
		data 
			* ������ʾ��Ҫ��ʽ���Ķ���
		pattern
			* ��ʾ��ʽ��ģʽ������ʱ����Ҫ����patternΪnull�����
		
	# Ҳ����ʵ�� ContextFormat ����󷽷����Ӷ��õ�Context����ȡ��ĸ�ʽ����Ϣ��
		* org.beetl.core.ContextFormat
	
	# ����
		FT.xxFormate=x.x.x.x
		* ��ģ����ͨ��ʹ��
			${data,xxFormate="pattern"}

			data		��ʾ��Ҫ����ʽ���Ķ���
			xxFormate	��ʾ�����ļ��е����õ�����
			pattern		��ʽ����ģʽ,���Բ���.��ôΪnull

			

------------------------
EasyUI-filebox			|
------------------------
	# FileBox(�ļ���)����ڱ����б�ʾһ���ļ��ϴ����ֶΡ�����չ�� textbox (�ı���)���󲿷ֵ����ԡ��¼��ͷ������̳����ı��򡣵�������������İ�ȫ���⣬���е�ĳЩ�������磺"setValue"���������� filebox �����
	# �̳й�ϵ
		textbox 

------------------------
EasyUI-filebox		����|
------------------------
	'������չ�� textbox����������������д���ļ������ԡ�'
	buttonText
		* �ı����ϸ��ӵ���ť��ʾ�ı�
	
	buttonIcon
		* ���ı����ϸ��ӵ���ť��ʾͼ��
	
	buttonAlign
		* ������ťλ��,����ֵ:"left", "right"��
	
	accept
		* ָ�����ܵ��ļ�����
	
	multiple
		* ָ���Ƿ����ѡ�����ļ�
	
	separator
		* ָ������ļ�����֮��ķָ���

------------------------
EasyUI-filebox		�¼�|
------------------------
	'�¼���չ�� textbox��'

------------------------
EasyUI-filebox		����|
------------------------
	'������չ�� textbox��'

------------------------
EasyUI-filebox		ʵս|
------------------------

	# ���Easyui��ȡ File ���������
		* �ļ������
			<input
				accept="image/gif,image/jpeg,image/png"
				class="easyui-filebox"
				data-options="
					onChange:fileUpdload
				"/>
		
		* onChange ���ϴ��¼�
			function fileUpdload() {
				//��ֵ��һ���ַ���,������ȡ���Ǳ����ļ���·��ֵ,�����ܻ�ȡ��file����
				var value = $(this).filebox('getValue');
				TD.println(value);
				
				//�ö������һ��file���������,��Ϊfile�п����Ƕ�ѡ
				var files = $('#filebox_file_id_1')[0].files;
				TD.println(files);
			}
		
		* filebox_file_id_1 ���ID ��easyui �Լ�������input ��ǩ. �����������������ļ��ĵط�.
		* ��������˶�� filebox  ��ô�����ID ����filebox_file_id_2,filebox_file_id_3.
	


----------------------------
url							|
----------------------------
	* ȫ��Ƭ�����ļ�:urls
		urlpatterns = [
			url(r'^admin/', admin.site.urls),
		]

	* URL���ú���
		url(url,controller,params)
			* url,������һ��������ʽ
				* ���������ʽ������ָ�����ƶ���������������,��ôcontrollerӦ�þ߱�ͬ���Ĳ���,������url������ƥ�䵽��ֵ
			* controller,��ͼ����,����һ������
			* params,��ѡ����,���ݸ���ͼ��������Ĳ���,�ò���Ӧ����һ�� dict
				* �ò����е����� key,��controller�ж�����Ҫ�ж�Ӧ�Ĳ���,���Ʊ�����ͬ
			* �ؼ��ֲ���
				name
					* ����,��ѡ��name����(��URL�ı���),���Է����ȡURL����
					* ��controller����,����ͨ�� name ������ֵ,����ȡ����url()url��Ϣ
					* ��ģ����������Ҳ���Ի�ȡ��: {% url "name" %}
								���������ģ�
									{% url 'name' %}
								��������,���������Ǳ�����
									{% url 'name' ���� %}
					* �� templates, models, views �����ж����Եõ���Ӧ����ַ
			
	
	* ��ϵͳʹ�������URLƥ�䵽�˵�һ�����Ϲ����URL����,�ͻ�ִ�и�controller,��������ƥ��
	
	* RESTFull���Ĳ�����ȡ

	* urlӳ��ַ�

		from django.conf.urls import url,include
		from django.contrib import admin

		urlpatterns = [
			url(r'^admin/', admin.site.urls),
			
			# �������κ���root��ͷ��·��,�ͻ�ѵ�ǰ������䵽 root.urls ģ������·��
			url(r'^root/', include('root.urls'))
		]

----------------------------
Beetl-ajax�ֲ���Ⱦ			|
----------------------------
	# beetl֧�־ֲ���Ⱦ����
	# �����̨�����ص���һ����ɵ�htmlƬ�Σ���ǰ�����������ֱ�ӽ����htmlƬ��׷�ӵ�����


<#menu/>
<#top10> ....</#top10>
<div id="table-container" >
	<%
		//ajaxƬ�ο�ʼ
		#ajax userTable: {
	%>

		<table>
			<tr><td width=100>id</td><td width=100>����</td></tr>
			<% 
				for(user in users){ 
			%>
				<tr><td>${user.id}</td><td>${user.name}</td></tr>
			<% 
				} 
			%>
		</table>

		��ǰҳ��<span id="current">${page!1}</span><span style="width:20px"></span>
		<a href="#"><span  class="page">next</span></a> <a href="#" ><span  class="page">pre</span></a>

	<%
		//ajaxƬ�ν�β
		}
	%>
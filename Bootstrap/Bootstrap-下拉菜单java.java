������������������������������������������������
1,JavaScript-�����˵�	|
������������������������������������������������
	.dropdown
		* �������˵��������������˵�����������(�����˵���Ԫ��)
	.data-toggle
		* �����˵�������,ȡֵΪ "dropdown"
	.dropup
		* ���ϵ����������˵�(�����˵���Ԫ��)
	.divider
		* Ϊ�����˵���ӷָ��ߣ����ڽ�������ӷ���
		<li class="divider"/>
	.disabled
		* ���õĲ˵���
	.dropdown-header
		* ��ӱ���˵�
		 <li role="presentation" class="dropdown-header">�����˵�����</li>
	.btn-large
	.btn-sm 
	.btn-xs
		* ���������˵���Ť�Ĵ�С,����ʽӦ�ü���button��
	* ������
		1,��֯һ��class="dropdown"��div
		2,��div�м���һ��button���������:data-toggle="dropdown"
		3,��ul���������:class="dropdown-menu"
	
	����	
		<div class="dropdown">					//button,��ul�ĸ�����												
			<button type="button" class="btn-lg btn-success" data-toggle="dropdown">		
			JAVA								//button
			<span class="caret"></span>			//һ��������							
			</button>
			<ul class="dropdown-menu">			//ul							
				<li>
					<a href="#">JDBC</a>		//����ѡ��										
				</li>
				<li class="divider"/>			//ѡ��ָ���							
				<li>
					<a href="#">WEB</a>
				</li>
				<li class="divider"/>
				<li>
					<a href="#">JSP</a>
				</li>
				<li class="divider"/>
				<li��class="disabled">			//����ѡ��													
					<a href="#">Tomcat</a>
				</li>
			</ul>
		</div>
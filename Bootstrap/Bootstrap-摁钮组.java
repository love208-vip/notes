������������������������������������������������
2,JavaScript-��Ŧ��		|
������������������������������������������������
	.btn-group
		* ��Ť��,����ʵ�ְ�һ�鰴ť������ͬһ��
	.btn-group-vertical
		* ��ֱ���еİ�ť��	,����Ť������ͬһ��
	.btn-toolbar
		* ��Ť������Ŀ,�Ѷ����Ť���������
	.btn-group-lg
	.btn-group-sm
	.btn-group-xs
		* ��Ť���С
	* ������
		1,׼����һ��div,���class����:btn-group
		2,�����div�����n����Ť
	//�����̿�����ť��ʽ����󣬴˴���Ҫͨ��div�����ð�ť��С
	<div class="btn-group btn-group-lg">
		<button type="button" class="btn btn-success">JAVA</button>
		<button type="button" class="btn btn-success">PHP</button>
		<button type="button" class="btn btn-success">C++</button>
		<button type="button" class="btn btn-success">Python</button>
	</div>
������������������������������������������������
3,JavaScript-��Ŧ�������˵�|
������������������������������������������������
	* �����������ǰ�������,�Ǿͺܺð�
	* ������
		1,����һ����ť��div,���class="btn-group"
		2,��������洴��һ��div,���class="btn-group"
		3,���ڲ���div�����button,�ڲ�div�������:dropdown����
		4,����������������Ӿ�����
			<div class="btn-group">
				<!-- java -->
				<div class="btn-group">
					<button type="button" class="btn btn-success" data-toggle="dropdown">
						JAVA <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li>JDBC</li>
						<li>List</li>
						<li>Set</li>
						<li>Map</li>
					</ul>
				</div>
				<!-- ��� -->
				<div class="btn-group">
					<button type="button" class="btn btn-success" data-toggle="dropdown">
							��� <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li>Spring</li>
							<li>MyBatis</li>
							<li>Hibernate</li>
							<li>Strtus2</li>
						</ul>
					</div>
				</div>
========================	ģ��	===========================

���һ
	<many-to-one name="" class="" column=""/>
һ�Զ�
	<set name="">
        	<key column=""/>
        	<one-to-many class=""/>
        </set>
��Զ�
	<set name="" table="">
   		<key column=""/>
   		<many-to-many class="" column=""/>
   	</set>
һ��һ(�������,��Ҳ���Ƽ��ķ�ʽ)
	�������
	<many-to-one name="" class="" column="" unique="">
	�������
	<one-to-one name="" class="" property-ref=""/>
========================	���	===========================
<!-- XXXX����,��ʾ��XXXX�Ķ�Զ��ϵ -->
------1-------------2-------3---------
1,name����
	��1
2,class����
	��2
3,cloumn
   �ڶ��һ(many-to-one)ʱ:
	�������е�,name������+id
   ��һ�Զ��<key>��:
	д�Է����ӳ���ļ���,��Ӧ�������õ�����,�͸����й�ϵ���Ǹ�����
   �ڶ�Զ��<key>��:
	д�Լ��������+id
   �ڶ�Զ��<many-to-many>��cloumn��
	д�Է��������+id��׺
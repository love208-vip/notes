----------------------
window.localStorage		|
----------------------
	# localStorage ����洢������û��ʱ�����ơ��ڶ��졢�ڶ��ܻ���һ��֮��������Ȼ���á�
	# sessionStorage �������һ�� session �������ݴ洢�����û��ر���������ں����ݻᱻɾ����
	# �������Դ洢������������,����ֱ�Ӵ洢����
	# �����Ҫ�洢����,��Ҫת��ΪJSON�ַ���
	# ͬ���Ĳ������Ա�����
	# ����ʹ�� for in ���е���
		for(var name : ins localStorage){
			var value = localStorage[name];
		}
	# ������������,ͬԴ��������


----------------------
window.localStorage	����|
----------------------
	localStorage.��������
		* ��ʵ���ǿ��Զ�ָ�������Խ��д�ȡ

	localStorage.['��������']
		* Ҳ֧������ķ�ʽ���������Ե����úͶ�ȡ
	
	length
		* ����,�ж��ٸ�����

----------------------
window.localStorage	����|
----------------------
	localStorage.setItem(key,value);
		* ��������

	localStorage.getItem(key);
		* ��ȡ����

	localStorage.removeItem(key);
		* ɾ����������

	localStorage.clear();
		* ɾ����������

	localStorage.key(index);
		* �õ�ĳ��������key

----------------------
window.localStorage	�¼�|
----------------------
	onstorage
		* ���¼�Ӧ��ע�ᵽwindow������
		* �¼��������������
			key				//key
			newValue		//��ֵ
			oldValue		//������²���,��ֵΪnull
			storageArea		//�� localStorage ���� sessionStorage
			url				//��ǰURL

		* ����¼����ڹ㲥�¼�,��֪ͨ��ǰ������д򿪵�������ͬ��ҳ��
		* ��ͬԴҳ���ĳ��ҳ���޸���localStorage,�����ͬԴҳ��ֻҪע����storage�¼����ͻᴥ��
		* ��ͬһ����ҳ�޸ı��ش洢������ͬһ����ҳ������������û��Ч���ġ�
		* Chrome �±���������ҳ�津����IE,Firefox ���Ա�ҳ�津��
		* demo	
			window.addEventListener('storage',function(event){
				
			});
		

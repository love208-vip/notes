-----------------------
Nginx-��������			|
-----------------------
	# Nginx ��������,��߻�������
	# ��һЩ��̬��Դ�����ڿͻ���
	# expires(����)


-----------------------
Nginx-expires			|
-----------------------
	# �����ʽ
		expires 30s;
			// 30�����
		expires 30m;
			// 30���ӹ���
		expires 2h;
			// ��Сʱ����
		expires 30d;
			// 30�����

	# ����д��location��
		location iamge {
			//ֻҪ�Ƿ���imageĿ¼,ȫ������30��
			expires 30d;
		}
		location ~^ \.(jpg|gif|png|jepg){
			expires 1d;
		}
	
	
		
-----------------------
��ȫ��-��������ץ��		|
-----------------------
	# ��������ץ�������
		* ����������,������ʱ��,��������.���
		* 

-----------------------
��ȫ��-Wireshark		|
-----------------------
	# �ǳ�ţ�Ƶ�һ��ץ������,Linux,Windos,MACϵͳ�¶���
	# ����ͨ���������ץȡ���ݰ�
	Interface List
		* ��ʾ��ǰ����Щ����
	
	1,ѡ������
		
	2,����ץ��������
		* ץȡ��Χ(ip)
		* �﷨: protocol $ Direction $Host(s) $ Value $ Logical Operation $ Other expression
			protocol
				* Э��,���ܵ�ֵ:eher,fddi,ip,arp,rarp,decnet,lat,sca,moprc,mopdl,tcp,udp

			Direction
				* ����,���ܵ�ֵ:src,dst,src and dst,src or dst
				* ���Ͱ���Դ��˭
				* dst-Ŀ��
				* src-Դ

			$Host				
				* ���ܵ�ֵ:net,port,host,portrange
				* ���û��ָ����ֵ,Ĭ��ʹ��'Host'�ؼ���,����:'src 10.1.1.1'��'src host 10.1.1.1'��ͬ

			Value				
				
			Logical Operation	
				* �߼�����,�����ܵ�ֵ:not ,and ,or
				* not,Ҳ���Ƿ�,����������ȼ�.��(or),����(and),������ͬ���ȼ�,����ʱ,������������
				* 'not tcp port 3128 and tcp prot 23' �� '(not tcp port 3128) and tcp port 23'��ͬ
				* 'not tcp port 3128 and tcp port 23' �� 'not (tcp port 3128 and tcp port 23)'��ͬ

			Other expression
				* ���ѡ��

		


	3,������ʾ������
		* ץȡ����Щ��(HTTP,HTTPS,TCP,UDP)
			* HTTP(POST/GET)
		* �﷨:Protocol.String1.String2 $ Comparison operator $ Value $ Logical Operations $ Other expression
		* ����:
			ip src == 192.168.1.100		//��ʾ��ԴΪ:192.168.1.100�İ�
			tcp dst port 8080

			
			http.request.method==GET	//��ȡPOST������



	4,���������ݷ���
		* �ʺ�,����


-----------------------
��ȫ��-Wireshark		|
-----------------------
	Ethernet II 
		* ��̫��Э��

	Internet Protocol Version 4(IP)
		* IPЭ��(��װ��ԴIP,Ŀ��IP)
		Source		:�������ݰ�����
		Destination	:Ŀ��IP

	Hypertext Transfer Protocol(TCP)
		* Ӧ�ò�Э��(��װ�˶˿ں�,TTL,Ӧ������... ...)
		Source Port			:Դ�˿�
		Destination Port	:Ŀ��˿�
		
		
--------------------
Nginx-��ַ��д		|
--------------------
	# Rewriter��Ҫ�Ĺ��ܾ���ʵ��URL��д,Nginx��Rewriter�������(Perl)����������ʽ���﷨���й����ƥ��.�����ҪNginx��Rewriter����,�ڱ���Nginx֮ǰ,��Ҫ��װPCRE��
	# URL,ͳһ��Դ��λ��
	# URI,ͨ����Դ��ʶ��
	# rewriter ���Գ��ֵĵط�
		* location 
		* server
	# ��������
		if(����){}
		set $����
		return 500
		beak ���� rewrite
		rewrite ��д

--------------------
Nginx-Rewriter�﷨	|
--------------------
	# ������
		* ������������ "=" ���� "!=" �����
	~
		��ʾ���ִ�Сд��ĸƥ��
	!~
		��¥���෴
	~*
		��ʾ�����ִ�Сд��ĸƥ��
	!~*
		��¥���෴
	-f	!-f
		�ļ��Ƿ����
	-d	!-d
		Ŀ¼�Ƿ����
	-e	!-e
		�ж��ļ�����Ŀ¼,�Ƿ����
	-x	!-x
		�ж��ļ��Ƿ��ִ��
	
	# ֧�� $1 - $9 λ�û�����

		
--------------------
Nginx-Returnָ��	|
--------------------
	# ʾ��:�����".sh",".bash"��β,�򷵻�״̬��403

	location ~.*\.(sh|bash)?${
		return 403;
	}

--------------------
Nginx-set,rewriteָ��|
--------------------
	set $var '1';
	rewriteָ������һ������Ϊflag���,֧�ֵ�flag�����Ҫ�����¼���

	last	:�൱��Apache��[L]���,��ʾ���rewrite
	break	:��������ƥ����ɺ�,��ֹƥ��,����ƥ�����Ĺ���
	redirect:����302�ض���,�������ַ����ʾ��ת���URL��ַ
	permanent:��������301�ض���,�������ַ����ʾ��ת���URL��ַ

	last��break����ʵ��URI��д,�������ַ��URL����
	redirect��permanent����ʵ��URL��ת,������ĵ�ַ����ʾ��ת���URL��ַ

	# һ���� location ��,��ֱ����server��ǩ�б�д rewrite����,�Ƽ�ʹ��last���
	  �ڷ�location��,��ʹ��break���
	
	# URL rewriter �ͷ������ͬʱ����

	# nginx rewriteָ��ִ��˳��
		1.ִ��server���rewriteָ��(����Ŀ�ָ����server�ؼ��ֺ�{}��Χ����������xx������)
		2.ִ��locationƥ��
		3.ִ��ѡ����location�е�rewriteָ��
			�������ĳ��URI����д��������ѭ��ִ��1-3��ֱ���ҵ���ʵ���ڵ��ļ�

			���ѭ������10�Σ��򷵻�500 Internal Server Error����

		breakָ��
		�﷨��break;
		Ĭ��ֵ����
		������server,location,if

		ִֹͣ�е�ǰ���������ĺ���rewriteָ�
--------------------
Nginx-ifָ��		|
--------------------
	# �����û else ��,ֻ�� if

	if ($http_user_agent ~ MSIE)
	{
		rewrite ^(.*)$/msie/$1 break;
	}
	if (!-f $request_filename)
	{
		rewrite ^/img/(.*) /site/$host/images/$1 last;
	}
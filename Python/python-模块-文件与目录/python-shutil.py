----------------------------
shutil						|
----------------------------
	* �ļ��ĸ߼�����

----------------------------
shutil-ģ������				|
----------------------------

----------------------------
shutil-ģ�鷽��				|
----------------------------
	None copyfileobj(f1 ,f2)
		* �����ļ�,��f1������f2
		* f1/2Ӧ������ open() �������صĶ���
		* �ؼ��ֲ���:
				length 
					* �����ĳ���
	
	str copyfile(src, dst)
		* �����ļ�,��src������dst,����dst��·��
		* ���ַ�������ʽָ�����ļ�
	
	str copy(src, dst)
		* �����ļ���Ȩ��,����dst��·��
	
	copy2(src, dst)
		* �����ļ���״̬��Ϣ

	str copytree(src, dst, symlinks=False, ignore=None)
		* �ݹ��ȥ�����ļ���,���� dst ·��
		* �ؼ��ֲ���
			symlinks
				* �Ƿ�Ҫ���������ļ�
			ignore
				* ������,����ָ�����Ƶ��ļ�
				* ignore_patterns('*.pyc', 'tmp*')

	ignore_patterns()
		* �����ļ�������,֧��ͨ���
		* �䳤����,���Դ���N���ֵ
		* ignore_patterns('*.pyc', 'tmp*')
	
	None rmtree(dst)
		* �ݹ��ȥɾ���ļ�
		* '���ز���,�൱��Linux : rm -rf '
	
	str move(src, dst)
		* �ݹ��ȥ�ƶ��ļ�,������mv����,��ʵ����������
		* ���� dst ·��
	
	str make_archive(base_name, format,...)
		* ����ѹ����,���ҷ���·��
		* base_name,ָ��ѹ�����ĵľ���·��,����(���Զ�����Ӻ�׺��),�������ָ������û��Ŀ¼,���ʾ�ڵ�ǰĿ¼
		* format,ѹ������:"zip", "tar", "bztar","gztar"
		* �ؼ�����
			root_dir:Ҫѹ�����ļ���·��(Ĭ�ϵ�ǰĿ¼)
			owner	:�û�,Ĭ�ϵ�ǰ�û�
			group	:��,Ĭ�ϵ�ǰ��
			logger	:���ڼ�¼��־,ͨ����logging.Logger����
		* 'shutil ��ѹ�����Ĵ�����ͨ������ZipFile �� TarFile����ģ�������еġ�'
	

	copymode(src, dst)
		* ����ֻ��src��Ȩ�޿�����dst������Ȩ��
		* ����,��,�û�������
	
	copystat(src, dst)
		* ������״̬����Ϣ
		* ����:mode bits, atime, mtime, flags
	




---------------------------
tarfile						|
---------------------------
	* tar������


---------------------------
tarfile-demo				|
---------------------------
import tarfile
 
# ѹ��
tar = tarfile.open('your.tar','w')
tar.add('/Users/wupeiqi/PycharmProjects/bbs2.log', arcname='bbs2.log')
tar.add('/Users/wupeiqi/PycharmProjects/cmdb.log', arcname='cmdb.log')
tar.close()
 
# ��ѹ
tar = tarfile.open('your.tar','r')
tar.extractall()  # �����ý�ѹ��ַ,�ؼ��ֲ���:path ,Ĭ�ϵ�ǰĿ¼
tar.close()
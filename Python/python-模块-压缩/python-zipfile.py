-----------------------
zipfile					|
-----------------------
	* zipѹ��������


-----------------------
zipfile-demo			|
-----------------------
import zipfile
# ѹ��
z = zipfile.ZipFile('laxi.zip', 'w')
z.write('a.log')
z.write('data.data')
z.close()
# ��ѹ
z = zipfile.ZipFile('laxi.zip', 'r')
z.extractall()	# �����ý�ѹ��ַ,�ؼ��ֲ���:path
z.close()


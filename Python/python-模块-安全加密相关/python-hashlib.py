---------------------------
hashlib						|
---------------------------
	* ��ȫɢ������ϢժҪ

---------------------------
hashlib-��������			|
---------------------------
	
---------------------------
hashlib-ģ�鷽��			|
---------------------------
	_hashlib.HASH md5()
		* ��ȡ�� md5 ���ܶ���
		* <md5 HASH object @ 0x02E85B78>
	
	_hashlib.HASH sha1()
		* ��ȡ sha1 ���ܶ���
		* <sha1 HASH object @ 0x02A55B78>

	_hashlib.HASH sha256()
		...

---------------------------
hashlib-_hashlib.HASH		|
---------------------------
	None update()
		* ��ָ�������ݽ���md5����,����Ϊ�ֽ�����
		* �����ε��� update(),���ǰѶ�δ��ݲż��ܲ���,����ƴ��

	str hexdigest()	
		* ��ȡ���ܺ��16��������

	* demo(md5)
		md5 = hashlib.md5()
		md5.update("a12551255".encode("UTF-8"))
		var = md5.hexdigest()	# 493d01fa9ae5c2aaae17fbe88ec1d5fb
	* demo(sha1)
		sha1 = hashlib.sha1()
		sha1.update("a12551255".encode("utf-8"))
		var = sha1.hexdigest()	# 98e01e46e4f714f30548052fe7bbca6df24bc3e7
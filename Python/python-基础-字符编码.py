----------------------------
Python-字符编码				|
----------------------------
	# Python2默认是ASCII码,如果包含中文字符,需要在顶部进行声明
		# -*- coding: UTF-8 -*-
	
	# Python3默认就是Unicode格式编码


----------------------------
Python-编码转换				|
----------------------------
	str = "余文朋"
	encode = str.encode('UTF-8')
		# 当前字符编码
	print(encode)           //b'\xe4\xbd\x99\xe6\x96\x87\xe6\x9c\x8b'
	print(type(encode))     //<class 'bytes'>
	decode = encode.decode("UTF-8")
		# 目标编码
	print(decode)           //余文朋

----------------------------
Python-编码类别				|
----------------------------
	# 二进制
		* 计算机只能看懂这个

	# ASCII
		* 只能存英文和拉丁字符
		* 一个字符占1个字节(8比特)
	
	# GB2312
		* 只有6700多个中文字符(1980年)
	
	# GBK1.0
		* 只有20000多个中文字符(1995年)
	
	# GB18030
		* 只有27000多个中文字符(2000年)
	
	# Unicode
		* 本身是一个标准,万国码
	
	# UTF-32
		* Unicode 实现,一个字符占4个字节
	
	# UTF-16
		* Unicode 实现,一个字符占2个字节
	
	# UTF-8
		* Unicode 实现
		* 通用的万国码
		* 可变长字节
		* 英文
			> 使用ASCII码存,占1个字节
		* 中文
			> 占三个字节
	
	

---------------------
字符串扩展			 |
---------------------
	1,字符的 Unicode 表示法
	2,codePointAt()
	3,String.fromCodePoint()
	4,字符串的遍历器接口
	5,at()
	6,normalize()
	7,includes(), startsWith(), endsWith()
	8,repeat()
	9,padStart()，padEnd()
	10,模板字符串
	11,实例：模板编译
	12,标签模板
	13,String.raw()
	14,模板字符串的限制

---------------------
Unicode				 |
---------------------
	# JavaScript 允许采用\uxxxx形式表示一个字符，其中xxxx表示字符的 Unicode 码点。
		let x = "\u0061";

	# 这种表示法只限于码点在\u0000~\uFFFF之间的字符。超出这个范围的字符，
	# 超出这个范围的字符，必须用两个双字节的形式表示。
		let x = "\uD842\uDFB7"		// "𠮷"
		let y = "\u20BB7"			// " 7"
		* 如果直接在\u后面跟上超过0xFFFF的数值（比如\u20BB7），JavaScript会理解成\u20BB+7。
		* 由于\u20BB是一个不可打印字符，所以只会显示一个空格，后面跟着一个7。
	
	# 'ES6 对这一点做出了改进，只要将码点放入大括号，就能正确解读该字符。'
		\u{UNICODE码}
		"\u{20BB7}"							// "𠮷"
		"\u{41}\u{42}\u{43}"				// "ABC"
		let hello = 123;					hell\u{6F} // 123
		'\u{1F680}' === '\uD83D\uDE80'		// true
	
	# 有了这种表示法之后，JavaScript 共有6种方法可以表示一个字符。
		'\z' === 'z'		// true
		'\172' === 'z'		// true
		'\x7A' === 'z'		// true
		'\u007A' === 'z'	// true
		'\u{7A}' === 'z'	// true
	
	# 相关AIP
		codePointAt();		
		String.fromCodePoint();
		String.fromCharCode();
	
---------------------
字符串遍历接口		 |
---------------------
	# ES6为字符串实现了遍历接口,可以被 for in 遍历
		for (let codePoint of 'foo') {
			console.log(codePoint)
		}
	# 这个遍历器在字符串中最大的优点是可以识别大于0xFFFF的码点，传统的for循环无法识别这样的码点。

---------------------
at					 |
---------------------
	# 返回指定位置的字符
	# ES5对字符串对象提供 charAt方法，返回字符串给定位置的字符。该方法不能识别码点大于0xFFFF的字符。
		lex x = "1234".at(2);		//3

---------------------
normalize			 |
---------------------
	# 跟音符相关的API

---------------------
其他新的API			 |
---------------------

	includes();
		* 返回 boolean,是否包含指定的字符串

	startsWith();
		* 是否以指定的字符串开头

	endsWith();
		* 是否以指定的字符串结尾

	# 以上下仨方法都支持第二个参数,表示指定下标,从哪个位置起开始判断
		* 默认就是从0开始
		* endsWith的行为与其他两个方法有所不同。它针对前n个字符，而其他两个方法针对从第n个位置直到字符串结束。
	
	repeat();
		* 表示把字符串重复几次后返回
		* repeat的参数是负数或者Infinity，会报错。
		* 如果参数是0到-1之间的小数，则等同于0，这是因为会先进行取整运算。0到-1之间的小数，取整以后等于-0，repeat视同为0。
		* 参数NaN等同于0。字符串也会被转换为数字
	
	padStart();
		* 头补全
		* 俩参数,第一个是指定长度,第二个参数就是用于补全的字符串
		* 如果原字符串的长度，等于或大于指定的最小长度，则返回原字符串。
		* 如果用来补全的字符串与原字符串，两者的长度之和超过了指定的最小长度，则会截去超出位数的补全字符串。
			'abc'.padStart(10, '0123456789');  // '0123456abc'
		* 如果省略第二个参数，默认使用空格补全长度。
			'x'.padStart(4) // '   x'
		* 常见用途是为数值补全指定位数
			var day = new Date().getDatofMonth();

	padEnd();
		* 尾补全
		* 俩参数,第一个是指定长度,第二个参数就是用于补全的字符串
		* 同上
		* 如果省略第二个参数，默认使用空格补全长度。
			'x'.padEnd(4)	// 'x   

---------------------
转义字符串			 |
---------------------
	* 传统写法
		var x = "\"Hello\""
	
	* 新版写法
		var x = `"Hello"`
	
---------------------
模版字符串			 |
---------------------
	
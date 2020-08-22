
----------------------------------------
wsgiref.simple_server.WSGIServer		|
----------------------------------------
	* 简单的HTTP服务器
		from wsgiref import simple_server

		def controller(environ, response):
			# HTTP 状态码,和响应头
			response('200 OK', [('Content-Type', 'text/html')])
			# 响应数据,字节数组
			return [b"<h1>Hello World</h1>"]
			# return [bytes('')];

		http_server = simple_server.make_server('localhost', 9630,controller)
		http_server.serve_forever();
	



----------------------------------------
environ(dict)	详情					|
----------------------------------------
{
    'ALLUSERSPROFILE': 'C:\\ProgramData', 
    'APPDATA': 'C:\\Users\\KevinBlandy\\AppData\\Roaming', 
    'CLASSPATH': '.;D:\\JDK8\\jdk1.8.0_91\\lib\\dt.jar;D:\\JDK8\\jdk1.8.0_91\\lib\\tools.jar;', 
    'COMMONPROGRAMFILES': 'C:\\Program Files\\Common Files', 
    'COMMONPROGRAMFILES(X86)': 'C:\\Program Files (x86)\\Common Files', 
    'COMMONPROGRAMW6432': 'C:\\Program Files\\Common Files', 
    'COMPUTERNAME': 'PC201603271442', 
    'COMSPEC': 'C:\\Windows\\system32\\cmd.exe', 
    'DEVMGR_SHOW_DETAILS': '1', 
    'FP_NO_HOST_CHECK': 'NO', 
    'HOMEDRIVE': 'C:', 
    'HOMEPATH': '\\Users\\KevinBlandy', 
    'JAVA_HOME': 'D:\\JDK8\\jdk1.8.0_91', 
    'LOCALAPPDATA': 'C:\\Users\\KevinBlandy\\AppData\\Local', 
    'LOGONSERVER': '\\\\PC201603271442', 
    'MAVEN_HOME': 'C:\\apache-maven-3.0.5', 
    'MOZ_PLUGIN_PATH': 'C:\\Program Files (x86)\\Foxit Software\\Foxit Reader\\plugins\\',
    'NUMBER_OF_PROCESSORS': '4',
    'OS': 'Windows_NT', 
    'PATH': 'D:/JDK8/jre8/bin/server;D:/JDK8/jre8/bin;D:/JDK8/jre8/lib/amd64;C:\\ProgramData\\Oracle\\Java\\javapath;C:\\Windows\\system32;C:\\Windows;C:\\Windows\\System32\\Wbem;C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\;D:\\JDK8\\jdk1.8.0_91\\bin;D:\\JDK8\\jdk1.8.0_91\\jre\\bin;C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin;C:\\apache-maven-3.0.5\\bin;C:\\Program Files\\TortoiseSVN\\bin;C:\\Users\\KevinBlandy\\AppData\\Local\\Programs\\Python\\Python36\\Scripts\\;C:\\Users\\KevinBlandy\\AppData\\Local\\Programs\\Python\\Python36\\;C:\\Users\\KevinBlandy\\AppData\\Local\\Programs\\Python\\Python36-32\\Scripts\\;C:\\Users\\KevinBlandy\\AppData\\Local\\Programs\\Python\\Python36-32\\;C:\\Users\\KevinBlandy\\bin\\Sencha\\Cmd;C:\\Program Files (x86)\\SSH Communications Security\\SSH Secure Shell;D:\\eclipse-jee-oxygen-M7-win32-x86_64\\eclipse;', 
    'PATHEXT': '.COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC', 
    'PROCESSOR_ARCHITECTURE': 'AMD64', 
    'PROCESSOR_IDENTIFIER': 'Intel64 Family 6 Model 60 Stepping 3, GenuineIntel', 
    'PROCESSOR_LEVEL': '6', 'PROCESSOR_REVISION': '3c03', 
    'PROGRAMDATA': 'C:\\ProgramData', 
    'PROGRAMFILES': 'C:\\Program Files', 
    'PROGRAMFILES(X86)': 'C:\\Program Files (x86)', 
    'PROGRAMW6432': 'C:\\Program Files', 
    'PROMPT': '$P$G', 
    'PSMODULEPATH': 'C:\\Windows\\system32\\WindowsPowerShell\\v1.0\\Modules\\', 
    'PUBLIC': 'C:\\Users\\Public', 
    'PYDEV_COMPLETER_PYTHONPATH': 'D:\\eclipse-jee-oxygen-M7-win32-x86_64\\eclipse\\plugins\\org.python.pydev_5.8.0.201706061859\\pysrc', 
    'PYDEV_CONSOLE_ENCODING': 'UTF-8', 
    'PYTHONIOENCODING': 'UTF-8',
    'PYTHONPATH': 'D:\\eclipse-jee-oxygen-M7-win32-x86_64\\eclipse\\plugins\\org.python.pydev_5.8.0.201706061859\\pysrc\\pydev_sitecustomize;C:\\Users\\KevinBlandy\\AppData\\Local\\Programs\\Python\\Python36\\DLLs;C:\\Users\\KevinBlandy\\AppData\\Local\\Programs\\Python\\Python36\\lib;C:\\Users\\KevinBlandy\\AppData\\Local\\Programs\\Python\\Python36;C:\\Users\\KevinBlandy\\AppData\\Local\\Programs\\Python\\Python36\\lib\\site-packages', 'PYTHONUNBUFFERED': '1', 
    'SESSIONNAME': 'Console', 
    'SYSTEMDRIVE': 'C:',
    'SYSTEMROOT': 'C:\\Windows', 
    'TEMP': 'C:\\Users\\KEVINB~1\\AppData\\Local\\Temp',
    'TMP': 'C:\\Users\\KEVINB~1\\AppData\\Local\\Temp', 
    'USERDOMAIN': 'PC201603271442',
    'USERNAME': 'KevinBlandy', 
    'USERPROFILE': 'C:\\Users\\KevinBlandy', 
    'VBOX_MSI_INSTALL_PATH': 'C:\\Program Files\\Oracle\\VirtualBox\\', 
    'WINDIR': 'C:\\Windows',
    'WINDOWS_TRACING_FLAGS': '3', 
    'WINDOWS_TRACING_LOGFILE': 'C:\\BVTBin\\Tests\\installpackage\\csilogfile.log', 
    'SERVER_NAME': 'www.fangkeng.club', 
    'GATEWAY_INTERFACE': 'CGI/1.1', 
    'SERVER_PORT': '9630', 
    'REMOTE_HOST': '', 
    'CONTENT_LENGTH': '',
    'SCRIPT_NAME': '', 
	# 协议
    'SERVER_PROTOCOL': 'HTTP/1.1',
    'SERVER_SOFTWARE': 'WSGIServer/0.2',
	# 请求方法
    'REQUEST_METHOD': 'GET',				
	# 请求的地址
    'PATH_INFO': '/',
	# 请求参数
	'QUERY_STRING': '', 
	# 客户端远程地址
    'REMOTE_ADDR': '127.0.0.1',				
    'CONTENT_TYPE': 'text/plain',			
    'HTTP_HOST': 'localhost:9630', 
    'HTTP_CONNECTION': 'keep-alive', 
    'HTTP_CACHE_CONTROL': 'max-age=0',
    'HTTP_UPGRADE_INSECURE_REQUESTS': '1',
	# 客户端浏览器信息
    'HTTP_USER_AGENT': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36',
    'HTTP_ACCEPT': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
	# 客户端支持压缩格式
    'HTTP_ACCEPT_ENCODING': 'gzip, deflate, sdch, br', 
	# 客户端语言
    'HTTP_ACCEPT_LANGUAGE': 'zh-CN,zh;q=0.8', 
	# cookie
    'HTTP_COOKIE': '_ga=GA1.1.1468046053.1499215491', 
	# input流
    'wsgi.input': <_io.BufferedReader name=564>, 
    'wsgi.errors': <_io.TextIOWrapper name='<stderr>' mode='w' encoding='UTF-8'>, 
    'wsgi.version': (1, 0), 
    'wsgi.run_once': False, 
    'wsgi.url_scheme': 'http', 
    'wsgi.multithread': True, 
    'wsgi.multiprocess': False, 
    'wsgi.file_wrapper': <class 'wsgiref.util.FileWrapper'>
}



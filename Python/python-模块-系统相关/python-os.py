-----------------------
os						|
-----------------------
	* ����ϵͳ��ص�ģ��
	* �����ļ�/�ļ��в�����һЩ����
		1,��������Ǿ���·��,�����ݵ�ǰ·�����в���:getcwd() 
		2,������֧�� . �� ..  ����Զ�λ��Ŀ¼


-----------------------
��������				|
-----------------------
	str curdir  
		* ��ǰĿ¼:('.'),�ַ���
	
	str pardir
		* ��ǰĿ¼�ĸ�Ŀ¼�ַ�����:('..')
	
	str sep	
		* �������ϵͳ�ض���·���ָ���,win��Ϊ"\\",Linux��Ϊ"/"

	str linesep   
		* �����ǰƽ̨ʹ�õ�����ֹ��(����),win��Ϊ"\t\n",Linux��Ϊ"\n"

	str pathsep    
		* �ָ���
		* windows �е� path ���������еķָ�����: ;
		* Linux �е�  path ���������еķָ�����: :
	
	str name    
		* ����ַ���ָʾ��ǰʹ��ƽ̨,win->'nt'  Linux->'posix'

	os._Environ environ  
		* ��ȡϵͳ��������
		* environ({'ALLUSERSPROFILE': 'C:\\ProgramData', 'APPDATA': 'C:\\Users\\Kevin\\AppData\\Roaming', 'CLASSPATH': '.;C:\\Program Files\\Java\\jdk1.8.0_111\\lib\\dt.jar;C:\\Program Files\\Java\\jdk1.8.0_111\\lib\\tools.jar;', 'COMMONPROGRAMFILES': 'C:\\Program Files (x86)\\Common Files', 'COMMONPROGRAMFILES(X86)': 'C:\\Program Files (x86)\\Common Files', 'COMMONPROGRAMW6432': 'C:\\Program Files\\Common Files', 'COMPUTERNAME': 'DESKTOP-UHNU5C4', 'COMSPEC': 'C:\\WINDOWS\\system32\\cmd.exe', 'ERLANG_HOME': 'C:\\Program Files\\erl8.1', 'GRAILS_HOME': 'C:\\grails-3.1.8', 'GROOVY_HOME': 'C:\\groovy-2.4.7', 'HOMEDRIVE': 'C:', 'HOMEPATH': '\\Users\\Kevin', 'JAVA_HOME': 'C:\\Program Files\\Java\\jdk1.8.0_111', 'LOCALAPPDATA': 'C:\\Users\\Kevin\\AppData\\Local', 'LOGONSERVER': '\\\\DESKTOP-UHNU5C4', 'MAVEN_HOME': 'C:\\apache-maven-3.3.9', 'MOZ_PLUGIN_PATH': 'C:\\Program Files (x86)\\Foxit Software\\Foxit Reader\\plugins\\', 'NUMBER_OF_PROCESSORS': '4', 'OS': 'Windows_NT', 'PATH': 'C:/Program Files/Java/jre1.8.0_111/bin/server;C:/Program Files/Java/jre1.8.0_111/bin;C:/Program Files/Java/jre1.8.0_111/lib/amd64;C:\\ProgramData\\Oracle\\Java\\javapath;C:\\Program Files\\Java\\jdk1.8.0_111\\bin;C:\\Program Files\\Java\\jdk1.8.0_111\\jre\\bin;C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin;C:\\apache-maven-3.3.9\\bin;C:\\WINDOWS\\system32;C:\\WINDOWS;C:\\WINDOWS\\System32\\Wbem;C:\\WINDOWS\\System32\\WindowsPowerShell\\v1.0\\;C:\\grails-3.1.8/bin;C:\\groovy-2.4.7/bin;C:\\Users\\Kevin\\AppData\\Local\\Programs\\Python\\Python36-32\\Scripts\\;C:\\Users\\Kevin\\AppData\\Local\\Programs\\Python\\Python36-32\\;C:\\Users\\Kevin\\bin\\Sencha\\Cmd;C:\\Program Files (x86)\\SSH Communications Security\\SSH Secure Shell;C:\\Users\\Kevin\\AppData\\Local\\Microsoft\\WindowsApps;;E:\\eclipse;', 'PATHEXT': '.COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC', 'PROCESSOR_ARCHITECTURE': 'x86', 'PROCESSOR_ARCHITEW6432': 'AMD64', 'PROCESSOR_IDENTIFIER': 'Intel64 Family 6 Model 55 Stepping 8, GenuineIntel', 'PROCESSOR_LEVEL': '6', 'PROCESSOR_REVISION': '3708', 'PROGRAMDATA': 'C:\\ProgramData', 'PROGRAMFILES': 'C:\\Program Files (x86)', 'PROGRAMFILES(X86)': 'C:\\Program Files (x86)', 'PROGRAMW6432': 'C:\\Program Files', 'PROMPT': '$P$G', 'PSMODULEPATH': 'C:\\WINDOWS\\system32\\WindowsPowerShell\\v1.0\\Modules\\', 'PUBLIC': 'C:\\Users\\Public', 'PYDEV_COMPLETER_PYTHONPATH': 'E:\\eclipse\\plugins\\org.python.pydev_5.7.0.201704111357\\pysrc', 'PYDEV_CONSOLE_ENCODING': 'UTF-8', 'PYTHONIOENCODING': 'UTF-8', 'PYTHONPATH': 'E:\\eclipse\\plugins\\org.python.pydev_5.7.0.201704111357\\pysrc\\pydev_sitecustomize;E:\\workspace\\kevinblandy-python-demo;C:\\Users\\Kevin\\AppData\\Local\\Programs\\Python\\Python36-32\\DLLs;C:\\Users\\Kevin\\AppData\\Local\\Programs\\Python\\Python36-32\\lib;C:\\Users\\Kevin\\AppData\\Local\\Programs\\Python\\Python36-32;C:\\Users\\Kevin\\AppData\\Local\\Programs\\Python\\Python36-32\\lib\\site-packages', 'PYTHONUNBUFFERED': '1', 'SESSIONNAME': 'Console', 'SYSTEMDRIVE': 'C:', 'SYSTEMROOT': 'C:\\WINDOWS', 'TEMP': 'C:\\Users\\Kevin\\AppData\\Local\\Temp', 'TMP': 'C:\\Users\\Kevin\\AppData\\Local\\Temp', 'USERDOMAIN': 'DESKTOP-UHNU5C4', 'USERDOMAIN_ROAMINGPROFILE': 'DESKTOP-UHNU5C4', 'USERNAME': 'Kevin', 'USERPROFILE': 'C:\\Users\\Kevin', 'WINDIR': 'C:\\WINDOWS'})

-----------------------
���ú���				|
-----------------------
	str getcwd() 
		* ��ȡ��ǰ����Ŀ¼,����ǰpython�ű�����Ŀ¼�ľ���·��
		* E:\workspace\kevinblandy-python-demo

	None chdir(dirname)  
		* �ı䵱ǰ�ű�����Ŀ¼:�൱��shell��cd
	
	# ����==================
	None mkdir(dirname)    
		* ���ɵ���Ŀ¼:�൱��shell��mkdir dirname
		* ����ļ����Ѿ�����,�׳��쳣:FileExistsError
		* ��������Ǿ���·��,�����ݵ�ǰ·�����в���:getcwd() ()

	None makedirs(dirnames)    
		* ���Ե��ƵĴ�������ļ���
		* ����ļ��ж�����,���׳��쳣:FileExistsError
	
	# ɾ��==================
	None rmdir(dirname)		
		* ɾ��������Ŀ¼,��Ŀ¼��Ϊ�����׳��쳣
		* �൱��shell��rmdir dirname

	None removedirs(dirnames)    
		* ɾ���༶Ŀ¼,��Ŀ¼Ϊ��,��ɾ��,���ݹ鵽��һ��Ŀ¼,����ҲΪ��,��ɾ��,��������
		* ����Ŀ¼��Ϊ��,�׳��쳣:OSError
		* ��ɾ��������ԭ���Ե�
	
	None remove(file)  
		* ɾ��һ���ļ�
	
	# �ж�
	bool access(path,model)
		* ������Ŀ���ļ�/�ļ��н��м��
		* path Ҫ��������Ƿ��з���Ȩ�޵�·��
		* model ����ģʽ
			os.F_OK:	����path�Ƿ����
			os.R_OK:	����path�Ƿ�ɶ�
			os.W_OK:	����path�Ƿ��д
			os.X_OK:	������access()��mode������ ������path�Ƿ��ִ��
				
				
	# �г�==================
	list listdir(dir)    
		* �г�ָ��Ŀ¼�µ������ļ�����Ŀ¼,���������ļ�
		* �����б�
	generator walk(path)
		* �ݹ�ָ����Ŀ¼,����һ��������
		* �õ�����,ÿһ��Ԫ��,��һ�� tuple
		* tuple[0]:��ǰĿ¼
		* tuple[1]:list,��ǰĿ¼�е���Ŀ¼(���·��)
		* tuple[2]:list,��ǰĿ¼�е��ļ�(���·��)
		* demo
			for root,dirs,files in os.walk("D:\\"):
				print("��ǰ����Ŀ¼:%s"%(root))
				print("��ǰĿ¼�е�Ŀ¼:%s"%(dirs))
				print("��ǰĿ¼�е��ļ�:%s"%(files))


	# �޸�==================
	None renames(oldname,newname)  
		* �������ļ�/Ŀ¼
	
	None chmod(path,model)
		* �޸�Ȩ��

	# ��Ϣ==================
	os.stat_result stat('path/filename')  
		* ��ȡ�ļ�/Ŀ¼��Ϣ
		* os.stat_result(st_mode=16895, s
		t_ino=1407374883553285,
		st_dev=3424898185,
		st_nlink=1, 
		st_uid=0, 
		st_gid=0, 
		st_size=8192,			# �ļ�/Ŀ¼��С
		st_atime=1497075122,	# ����ȡʱ��
		st_mtime=1497075122,	# ����ʱ��
		st_ctime=1459282700)	# ����޸�ʱ��

	
	# ����==================
	int system("bash command") 
		* ����shell/cmd����ֱ����ʾ
		* ����ֵ����� 0 ���ʾִ��OK
	
	# 
		urandom(num)			
			* unkonw
	
	os._wrap_close popen("bash command"")
		* ִ������,��ȡ����
		* ִ�и÷��ض����read(),���Ի�ȡ������ִ�к�Ľ��
			read()

	# path �������==================

	str path.abspath(path)  
		* ����path�淶���ľ���·��
		* ����ָ��·���ľ���·��

	tuple path.split(path)  
		* ����Ԫ��
		* ��һ��Ԫ�ؾ��ǵ�ǰ�ļ�/Ŀ¼,���ڵ�Ŀ¼
		* �ڶ���Ԫ�ؾ��ǵ�ǰ�ļ�/Ŀ¼,������

	str path.dirname(path)  
		* ����path���ڵ�Ŀ¼
		* ��ʵ����os.path.split(path)�ĵ�һ��Ԫ��

	str path.basename(path)  
		* ����path�����ļ�/�ļ�����.���path��'��'��'\'��β,��ô�ͻ᷵�ؿ�ֵ('')
		* ��os.path.split(path)�ĵڶ���Ԫ��
	
	path.exists(path)  
		* ���path����,���� True:���path������,���� False

	path.isabs(path)  
		* ���path�Ǿ���·��,����True
	
	path.realpath(path)
		* ����ָ���ļ��ľ���·��
		* ��ǰPython�ű��ľ���·��:os.path.realpath(__file__)

	path.isfile(path)  
		* ���path��һ�����ڵ��ļ�,���� True,���򷵻� False

	path.isdir(path)  
		* ���path��һ�����ڵ�Ŀ¼,�򷵻� True ���򷵻� False

	path.join(path1, path2, ...)  
		* �����·����Ϻ󷵻�
		* �������һ��(����)·���Ǿ���·��,��ô��·��(����)ǰ������·���ᱻ����
	
	path.split(path)
		* ��һ��·�����Ϊ������,��һ����������󼶱��Ŀ¼���ļ���
		* ���� tuple

	path.getatime(path)  
		* ����path��ָ����ļ�����Ŀ¼������ȡʱ��

	path.getmtime(path)  
		* ����path��ָ����ļ�����Ŀ¼������޸�ʱ��
	
	path.splitext(path)
		* ��ȡ�ļ��ĺ�׺����
		* ���� type,[1]�Ǳ���Ǻ�׺
	
	# �߳����
	int getppid()
		* ���ظ�����(�����˵�ǰ���̵Ľ���)��PID
	
	int getpid()
		* ���ص�ǰ���̵�ID
	
	fork()
		* �����µĽ���,����,ֻ���� Unix/Linux ����

-----------------------
os._wrap_close			|
-----------------------
	str read()
		* ��ȡ,ִ����shell����������

-----------------------
demo					|
-----------------------
# �ݹ�ɾ��Ŀ¼/�ļ�
def deleteFile(path):
    assert os.path.exists(path),'ɾ��Ŀ��:[%s]�������'%(path)
    if(os.path.isfile(path)):
        os.remove(path) # ����Ŀ¼,ֱ��ɾ��
    else:
        subFiles = os.listdir(path)
        if(len(subFiles) > 0):
            for file in subFiles:   # ����һ�����߶����Ŀ¼/�ļ�
                file = os.path.join(path,file)# Ŀ¼ƴ��
                deleteFile(file)    # �ݹ鴦��     
        os.rmdir(path)              # ɾ��Ŀ¼

# �ݹ����Ŀ¼,�ҳ�����ָ�����Ƶ��ļ�
def find_file(target_dir,file_name):
    assert os.path.isdir(target_dir),"Ŀ��Ŀ¼[%s]�������"%(target_dir)
    result = list()
    def func(target):
        files = os.listdir(target)
        if(len(files) > 0):
            for file in files:
                file = os.path.join(target,file)
                if os.path.isfile(file) :
                    print("�ҵ��ļ�: %s"%(file))
                    if(file.find(file_name) != -1):
                        result.append(os.path.abspath(file))
                else:
                    func(file)
    func(target_dir)
    return result


# �ݹ���޸��ļ�/�ļ���,�������ǰ׺,�Լ��Թؼ��ֵ��滻
def rename_files(file,pre_fix='',repalce=None):
    assert os.path.exists(file) ,'Ŀ���ļ�[%s],�������'%(file)
    if os.path.isdir(file):
        files = os.listdir(file)
        if(len(files) > 0):
            for sub_file in files:
                rename_files(os.path.join(file,sub_file),pre_fix,repalce)
    file_name = os.path.basename(file)
    if repalce is not None:
        file_name = repalce(file_name)
    os.renames(file, os.path.dirname(file) + os.sep + pre_fix + file_name)

def replace(name):
    return name.replace('','')

rename_files("D:\\note", "javaweb")

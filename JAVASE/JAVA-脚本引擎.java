--------------------
JAVA-�ű�����		|
--------------------
	# ��ʵ������JAVA������ִ��JavaScript�Ĵ���
	# JAVAֻ���ṩ������ӿ�,����û�ṩʵ��,�������Ľű������Լ���дʵ��.
	# ����
		1,�ͻ��˴�����һ���ַ���
			"3 * 4 / 2 + 6 -5"
		2,���ַ���Ӧ�����ڼ������Ľ��
		3,�����ʹ��JAVA�����,�ͱȽϵ��鷳
		4,�����JavaScript�Ǿͼ� eval();�����͸㶨
	# �ű�������JDK6.0�Ժ���ӵ��¹���
		* ��ʵ����,JAVAӦ�ó������ͨ��һ�׹̶��Ľӿ���'���ֽű�����'����
		* �Ӷ��ﵽ��Javaƽ̨�ϵ��ø��ֽű����Ե�Ŀ��
		* Java�ű�API����ͨJavaƽ̨�ýű����Ե�����
		* ���԰�һЩ��������ҵ���߼������ű����Դ���,��Ҳ�������˿���Ч��
		* ��ʵ���ǿ�����java������ִ�������Ľű�����
		* 6.0��javascript-->Rhino����ӵ���JDK
	# ��ȡ�ű��������
		ScriptEngineManager sem = new ScriptEngineManager();
	# Java�ű�APIΪ�������ṩ��N�๦��
		* ��ȡ�ű���������,ͨ���ű��������нű����������н��.
		* ���ĵĽӿ� : ScriptEngineFactory
			1,ע��:�ǽӿ�,JAVA����ʹ�ø��ֲ�ͬ��ʵ��,�Ӷ�����js,groovy,python�Ƚű�
			2,JavasScript  -->  RhinoEngineFactory
			3,Rhino ��һ��ʹ��java���Ա�д��javascript����
			* Rhino <<JavaScriptȨ��ָ��>>,�Ȿ��������Rhino.
	# Demo
		public static void demo() throws ScriptException{
			ScriptEngineManager sem = new ScriptEngineManager();
			//��ȡJavaScript�Ľű�����
			ScriptEngine engine = sem.getEngineByName("javascript");
			/*
				����һ������,�洢��������������
				Java���Ի�ȡ��,����Ҳ���Ի�ȡ��
			*/
			engine.put("key", "value");
			/*
				����һ��JavaScript�ű�����
			*/
			String str = "var user = {name:'KevinBlandy',age:22,gender:'��'};";
			engine.eval(str);
		}

	
	# ������ȥִ�л��߼���,URL�ϵ�,���ص�JS�����ļ�

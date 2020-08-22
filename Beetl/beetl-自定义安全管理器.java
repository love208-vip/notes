---------------------------
�Զ��尲ȫ������			|
---------------------------
	# ����ģ��ı��ص��ö���Ҫͨ����ȫ������У��
	# Ĭ����Ҫʵ�� NativeSecurityManager �� public boolean permit(String resourceId, Class c, Object target, String method) ����
		* NativeSecurityManager
		* public boolean permit(String resourceId, Class c, Object target, String method)
	# Demo
		public class DefaultNativeSecurityManager implements NativeSecurityManager{

			@Override
			public boolean permit(String resourceId, Class c, Object target, String method){
					if (c.isArray()){
						//������ã���ʵ���ϻ������������б�������˴�����
						return true;
					}
					String name = c.getSimpleName();
					String pkg = c.getPackage().getName();
					//Runtime,Process,ProcessBuilder �඼���õ���
					if (pkg.startsWith("java.lang")){
							if (name.equals("Runtime") || name.equals("Process") || name.equals("ProcessBuilder")
											|| name.equals("System")){
									return false;
							}
					}
					return true;
			}
		}


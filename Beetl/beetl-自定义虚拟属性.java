---------------------------
�Զ�����������				|
---------------------------
	# ����Ϊ�ض�����ע��һЩ��������
	# Ҳ����ΪһЩ��ע����������


---------------------------
Ϊ�ض���ע��һ������		|
---------------------------
	# ͨ�� GroupTemplate �� registerVirtualAttributeClass ������ע��
		GroupTemplate grouptemplate = new GroupTemplate(resourceLoader, configuration);
		grouptemplate.registerVirtualAttributeClass(UserEntity.class, new VirtualClassAttribute() {
            public Object eval(Object o, String attributeName, Context ctx) {
                UserEntity userEntity = (UserEntity) o;	 //��ǰ����
                if(attributeName.equals("test")){		//�ж�ģ�洫�ݵ�����������
                    return "test";
                }
                return "����test";
            }
        });
	# eval �������
		Object o, 
			* ��ǰ����
		String attributeName, 
			* ������������
		Context ctx
			* ģ��������


---------------------------
ΪһЩ��ע����������		|
---------------------------
	# ͨ�� GroupTemplate �� registerVirtualAttributeEval ������ע��
		grouptemplate.registerVirtualAttributeEval(new VirtualAttributeEval() {
			//�ж��Ƿ�ҪӦ���������Ե�����
			public boolean isSupport(Class c, String attributeName) {
				return false;
			}

			public Object eval(Object o, String attributeName, Context ctx) {
				return null;
			}
		});
	
	# �������������һ������,ֻ��˵���˸�"�Ƿ�ҪӦ�õ�"�жϷ���

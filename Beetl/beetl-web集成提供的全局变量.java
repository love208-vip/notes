---------------------------------
Web�ṩ��ȫ�ֱ���				 |
---------------------------------
	request 
		* �е�����attribute.��ģ���п���ֱ��ͨ��attribute name ������
		* ����controller�� request.setAttribute("user",user),����ģ���п���ֱ����${user.name} .

	session 
		* �ṩ��session�Ự��ģ��ͨ��session["name"],����session.name ����session��ı���

	request 
		* ��׼�� HTTPSerlvetRequest,������ģ��������request���ԣ�getter������${request.requestURL}��

	parameter 
		* �û���ȡ�û��ύ�Ĳ�������${parameter.userId} 
		* (����2.2.7���ϰ汾֧��)

	ctxPath 
		* WebӦ��ContextPath

	servlet 
		* ��WebVariable��ʵ��
		* ������HTTPSession,HTTPSerlvetRequest,HTTPSerlvetResponse.��������
		* ģ���п���ͨ��request.response,session �����ã��� ${serlvet.request.requestURL};

	���е�GroupTemplate�Ĺ������

	pageCtx
		* ��һ�����÷��� 
		* ������web�����У���������һ��������Ȼ�������ҳ����Ⱦ�����У����ô�api��ȡ����pageCtx("title","�û����ҳ��")��������κεط�������pageCtx("title") ��ȡ�ñ�����
		* (����2.2.7���ϰ汾֧��)

---------------------------------
��չ							 |
---------------------------------
	# ��Ҫ��չ�������ԣ���Ҳ��������beetl.properties�����ļ���WEBAPP_EXT����
	# ʵ��WebRenderExt�ӿڣ�����Ⱦģ��֮ǰ�����Լ�����չ

		RESOURCE.root=/WEB-INF/views
		WEBAPP_EXT = com.park.oss.util.GlobalExt
	
	public class GlobalExt implements WebRenderExt{
        static long version = System.currentTimeMillis();
        @Override
        public void modify(Template template, GroupTemplate arg1, HttpServletRequest arg2, HttpServletResponse arg3) {
                //js,css �İ汾���
                template.binding("sysVersion",version);		//ÿ����ģ���ﶼ���Է��ʱ���sysVersion
        }
	}



	
����ǰ�˿�������Դ��,������springMVC��ִ�й���


1,��������
	ǰ�˿�������ȥ����һ��doDispatcher()�ķ���
	> doDispatcher(HttpServletRequest request,HttpServletResponse response)
2,ǰ�˿�����ȥ���ô�����-ӳ����,������Handler
	> protected HandlerExecutionChain getHandler(HttpServlet request);
3,���ô�����������ȥִ��Handler,�õ�ModelAndView
	> ModelAndView = ha.handle(..);
4,��ͼ��Ⱦ,��Model������,��䵽request��
	

	��д��...��Ҳ����!֪�����̾ͺ�,���������붼��������
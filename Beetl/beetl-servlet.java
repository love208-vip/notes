----------------------------
����Servlet					|
----------------------------
	# ֻ��Ҫ��Servlet����������ServletGroupTemplate���ܼ���Beetl
	# ���ṩ��һ��render(String child, HttpServletRequest request, HttpServletResponse response)����

		protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			//ģ��ֱ�ӷ���users
			request.setAttribute("users",service.getUsers());
			// ServletGroupTemplate.instance()	���ص�������
			ServletGroupTemplate.instance().render("/index.html", request, response);
		}
	
	# ServletGroupTemplateͬ����web����һ��������ȡ�����ļ�������

	# �����Ҫͨ���������ã�������Serlvet listener�� ServletGroupTemplate.instance().getGroupTemplate()������ȡGroupTemplate

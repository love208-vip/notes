ModelAndView modelAndView = new ModelAndView();

addObject(name,value);
	> ��request.setAttribute(name,value);����,String���͵����ƺ�ֵ
setViewName(String path);
	> ..���path��һ��jsp·��!
	* mv.setViewName("/WEB-INF/jsp/demo.jsp");



SpringMVC�ṩһ�¼���;�����ģ������

	1,ModelAndView
		* ��Ϊ�������ķ���ֵ,�Ȱ�����ͼ��Ϣ,Ҳ����ģ������.ģ������Ĭ�ϴ洢��rquest��
			addObject(name,value);				//key,�Զ�������.value����.��ָ���Ķ��������request��
			setViewName(String path);			//��ת·��,Ĭ��Ϊת��
		
	2,Map �� Model
		* ���ǿ�����Ϊ����,���߷���ֵ.
		* ������ڲ�ʹ����һ��:org.springframework.ui.Model�ӿڴ洢ģ������
		* ����ڵ��÷���ǰ�ᴴ��һ��������ģ�Ͷ�����Ϊģ�����ݵĴ洢����.
		* '����������β�Ϊ Map,����Model'����,��ô��ܾͻ�����ص�ģ�����ô��ݸ���Щ�β�,�����߿���ͨ���βλ�ȡ��ģ�͵�����,Ҳ�������
			public String demo(Map<String,Object> map)
			{
				map.put(key,value);				//��������ʵ�洢����request��
			}

	3,@SessionAttributes
		* Session,�������,ֻ�ܷ�������
			value		//String���͵�����
			types		//Class���͵�����
		@SessionAttributes(value={"user"})
			������������������Ϊ"user",�Ķ��󱻷��õ��� Map,������ ModelAndView��,��ô��"user"����Ҳ�ᱻ���õ�Session��
			����Ҳ����ͨ��������ָ��
		@SessionAttributes(types={String.class})
			��������������String.class���͵Ĳ��������õ���request,��ôҲ���Զ��ķ��õ�Session
			����Ҳ����ͨ������ָ��

	4,@ModelAttribute
		* �ⶫ����ʵҲ�����,����һ���ص�
		* �����ע���ʶ�ķ���,����'ÿ��Ŀ�귽��ִ��֮ǰ����ܵ���'.
		* �÷������Ի�ȡ���������
		��������
			1,���Ȼ�ִ�� @ModelAttribute ע���ʶ�ķ���
				* �÷�������Ӧ����,�����ݿ��л�ȡ����,�Ѷ������ request ��
			2,��ܴ� request ��ȡ������,���ѱ���������������ö���Ķ�Ӧ����
			3,��ܰ����������Ŀ�귽������
			* Ҳ�������е�һЩ,����.��ʵ���������ݿ�.һЩ���������ڱ�!���п���,�ö����е�ĳЩ����,�ǲ������ı��!

		ע��:@ModelAttribute,��ע�ķ���,�ڴ����ʱ��,��key��Ҫ��.
		* ͨ��������.����map�е�key,����Ҫ�봦�������βε�����һ��!

		@RequestMapping(value="/demo")
		public String demo(User user)
		{
			System.out.println(user);				//��ʱ��user����,�����Ѿ���װ�������Ա������ݿ��ֵ.	
			return "first";
		}
		@ModelAttribute
		public void getUser(String id,Model model)	//�˴���id,������������е�idֵ,Model��������,����Ҫ����request��
		{
			if(id != null)
			{
				User user = service.getUserById(id)	//ģ������ݿ���ȡ������,��װ����
				model.addAttribute("user",user);	//����request��,ע��:key Ҫ�����������β�һ��,�ű�����ȷ�ĸ�ֵ
			}
		}

		* �ⶫ����,Ŀǰ����֪����������ʹ��!
		SpringMVC ȷ��Ŀ�귽��POJO�����βεĹ���
			1,ȷ��һ��key
			2,��implicitModel �в���key��Ӧ�Ķ���.�������,����Ϊ�βδ��ݸ�Ŀ�귽��
			3,���������,�ͼ�鵱ǰ��Handler�Ƿ�ʹ���� @ModelAtrribute ע��.
			4,���ʹ���˸�ע��,�Ҹ�ע��� value,����ֵ�а�����key,�ͻ��HttpSession������ȡkey����Ӧ��valueֵ
			5,�������,��ֱ�Ӵ��ݸ�Ŀ�귽���β�,���������!�׳��쳣.
			6,Handler û�б�ʶ @SessionAttributes ע��,���߸�ע����û�а���key,���ͨ������������POJO���͵Ĳ���.Ȼ����Handler�β�.
			7,SpringMVC ���key��value,���浽 imolicitModel ,�������浽request��


		
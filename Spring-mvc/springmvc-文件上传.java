

SpringMVC���ļ��ϴ���֧��

	����,��������Ŀ¼,��ΪͼƬ�Ĵ洢Ŀ¼!�����ǵ����Ĳ�ȡͼƬ������
	Ŀ¼��ɢ�ǳ���Ҫ.�ṩIO����!���԰�������.Ҳ���԰��չ�ϣֵǰ��

	1,��IOC��ע��,�ļ��ϴ���֧�����
		<!-- �ļ��ϴ�֧�� -->
		<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
			<!-- �ϴ��ļ�����ֽ��� (5MB)
				-1	:Ĭ��ֵ,����û������
			-->
			<property name="maxUploadSize" value="5242880"/>
			<!--
				�ı��ļ��ı���
			-->
			<property name="defaultEncoding" value="UTF-8"/>
			<!--
				����ڴ�,���������ֵ,�ᱻд����ʱĿ¼
			-->
			<property name="maxInMemorySize" value="1638400"/>
			<!--
				�������ڴ�ֵ�Ժ�,д�����ʱĿ¼��ַ,Ĭ���������WEBAPP�ĸ�Ŀ¼,���Ŀ¼������.���Զ��Ĵ���Ŀ¼
			-->
			<property name="uploadTempDir" value="/temp"/>
		</bean>
		* ��Bean��idֵ�ǹ̶���,�����޸�
	
	2,�������������ṩһ���β�:MultipartFile pic
		* @RequestParam("uploadFile") MultipartFile uploadFile
		* ���Ʊ���ͱ��ֶε�����һ��
		* �ö�������ϴ����ļ�����,�߱����·���
			pic.getOriginalFilename();	//��ȡ�ļ�ԭʼ����
			pic.getBytes();				//��ȡ�ļ��ֽ�����
			pic.getContentType();		//��ȡ�ļ�ͼƬ��ʽ
			pic.getInputStream();		//��ȡ�ļ���ȡ��4
			pic.getName();				//��ȡ�ļ�,���ֶ�����
			pic.getSize();				//��ȡ�ļ���С,����Longֵ
			pic.transferTo(File f);		//�Ѹ��ļ�д��ָ����File����
	

	����:
		1,��������л�����������file�ֶ�����,�������β��ṩjavaBean,400����!
		2,����ļ��ϴ������޶�����,��ת�ĸ�ҳ��?�Լ�����Զ��������ʾ.

--------------------------
ʵ�ʿ�������Ҫע������� |
--------------------------
	1,�ļ����ϴ�����Ҫ�ڴ�������������µ�У��
		1,�ļ�����
		2,�ļ���С
		3,У������
			* �Ƿ���ͼƬ/�ı��ļ�,�»��˸ĺ�׺,������ű�,����
--------------------------
����У���ļ������ͽ������|
--------------------------
	[ͼƬ]
		* ͼƬ���͵��ļ�,�����п�͸ߵ�����,���ǿ���ͨ����ȡ�ļ��Ŀ������
		* ����ܳɹ���ȡ,����������ͼƬ�ļ�,��֮���ǻ���
		1,�Ȱ��ļ�д��Ӳ��
		2,ʹ��	BufferedImage ȥ��ȡͼƬ�ļ�����
		3,���ܹ��ɹ��Ļ�ȡ�������
				boolean isImg = false;
				try {
					//ʹ��:BufferedImage ��ȡͼƬ�ļ�����
					BufferedImage image = ImageIO.read(file);
					if (image != null) {
						int width =	image.getWidth();
						int hright = image.getHeight();
						//�ɹ���ȡ���,δ�쳣.�ļ�OK,����״̬OK
						isImg = true;
					}
				} catch (IOException e) {
					//�����쳣,����Ȼ����ͼƬ.��ôִ��ɾ���ļ�
				}

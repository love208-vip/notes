����������������������������������������������������������������
һ,�ļ��ϴ�����					|
����������������������������������������������������������������
	struts2,�ϴ�.���ǻ���Ҫ����һ��!����WEB�Ķ���!
	'�Կͻ��˵�Ҫ��'
		1,����ʹ�ñ�,�������ǳ�����
		2,����method������POST������GET
		3,����enctype������:multipart/form-data(enctype="multipart/form-data")
		4,�ڱ������file���ֶ�,��<input type="file" name="xxx"/>
	'�ص�'
		> �ಿ��������
		1,�ָ���������,��һ������һ������
		2,һ��������,�Լ���������ͷ�Ϳ����Լ�������
			*��ͨ����
				> 1��ͷ,:Content-Disposition:����name="xxx".Ҳ���Ǳ�����
				> ����Ǳ����ֵ
			* �ļ�����
				> 2��ͷ	
					Content-Disposition:����name="xxx".Ҳ���Ǳ����� -- filename="xxx" ��ʾ�ϴ��ļ�������
					Content-Type:�����ϴ��ļ���MIME����,����:image/pjpeg ��ʾ�ϴ���ʱ��ͼƬ��jpg��ʽ��ͼƬ
				> ������ϴ��ļ�������

����������������������������������������������������������������
��,struts2�ļ��ϴ�				|
����������������������������������������������������������������
	> ��struts2��,Ĭ�������.stuts2ʹ�õľ��ǵ�������ʹ�õ������ֵ�.
	*	commons-fileupload.jar	���������jar��������ɹ���
	*	commons-io.jar			IOȴ����������,�����Լ���������)
	> struts2ʹ����һ�� Interceptor(��������) ������������ļ��ϴ�����
	> <interceptor-ref name="fileUpload"/>
		*  <interceptor name="fileUpload" class="org.apache.struts2.interceptor.FileUploadInterceptor"/>
		* ����ʮ���޺����е�һ��,Ҳ����˵!����Ҫʵ���ϴ�!�㻹��ʹ��Ĭ�ϵ�������!
		* ����,�Լ���Action�е����������������
	['���ʻ�������Ϣ']
		* ��struts2�ĺ��İ�����һ��:struts-message.properties�ļ�
		* ���ļ���'ͨ���'����ʽ������һЩ��Ϣ,����:������ʾ��Ϣ��,���ǿ�������

	1,���������ļ���Action
		* �̳�ActionSupport��ѻ���
	2,���������ֶ�,ע��,�ֶ���������Լ����!
		* private File xxx;//����ļ����name���Ա���һ��.���ļ������ϴ��ļ�
		* private String xxxContentType;//�ϴ��ļ�������
		* private String xxxFileName;//�ϴ��ļ�������
		> xxx:������Ǳ�ҳ����.file�����name����<input type="file" name="xxx"/>.����һ��!
			* ���ļ�,�����ϴ����ļ�.����Զ��İ����ǽ����˷�װ����!
		> xxxContentType:Ҳ��ͬ���ı������ŵ��ֶ����Ǻ�!
			* �������ϴ��ļ�������,����:image/jpeg
		> xxxFileName:�����ϴ��ļ�������,ҲҪ���������Լ��.
			* �����ϴ��ļ�������,������.����name��������,����:�ҵ���ƭ.jpg
	3,�ṩ���������ֶε�,get/set����!
	4,���ù���,�����ļ�!
		> FileUtils.copyFile(pic,new File("D:/file/"+picFileName));
		* �ⶫ����,��struts2�ṩ��һ������.��Ҫ����,�Լ�дIOҲ��!
		* ʵ�ʿ�����Ҫ���ǵ�,Ŀ¼��ɢ,�ļ����������!����ø�ϰһ��IO��֪ʶ!����ǰ�ıʼǰ�!

	['ע��']
		> ��������,���ϴ��ļ���Action�п���ͬʱ����javaBean,ֻҪ���ṩ��get/set.�Լ����ṩ�˶�Ӧ���ֶ�!
		> �����ܽ��гɹ��ĸ�ֵ��!Ҳ����˵,ͬʱ�ϴ��ļ��ͷ�װ��������!������!

����������������������������������������������������������������
��,struts2�ļ��ϴ�,ϸ��������	|
����������������������������������������������������������������
	> ����һЩ�����ļ��ϴ�������,����������:default.properties������,��Ȼ,���ǿ�����xml�н�������!
	1,����input��ͼ,��Ϊ�ļ��ϴ�ʧ�ܺ���תҳ��!
		* ���ļ��ϴ���ʱ��,�����������!��ôfileUpload�����������ô�����Ϣ,workflow�������ͻ���ת��input��ͼ
		* ��ҳ�����ͨ��strust�ı�ǩ<s:actionerror/>ȡ��,�ǵõ���
	['���ԶԴ�����Ϣ,���й��ʻ�����']
		
	
	2,struts.multipart.parser=jakarta	'�����ļ��ϴ�,����commons-fileupload����'
		* ͬʱ֧��cos,pell�ϴ�����(���ʹ�������ϴ�����,������������jar��)
		* ��ʵstruts2�ṩ��pell�ϴ�������֧��jar��

	3,struts.multipart.maxSize			'�����ϴ����ֵ��ܴ�С����(��λ�ֽ�)'
		* struts.multipart.maxSize=2097152	['Ĭ����2MB']	
		* ���������С,�Ǿͻ���ת��input��ͼ
		* xml������,<constant name="struts.multipart.maxSize" value="2097152"/>
		* �����ö�ȫ�ֵ��ϴ�����Ч
	['�ϴ���С/�ļ���������,�����Ķ�ĳ��form/Action��Ч']
		> ��������'fileUpload'�����������������!
			* maximumSize:�ϴ��ļ�����󳤶�(�ֽ�Ϊ��λ),Ĭ��Ϊ2MB
			* allowedTypes:�ϴ��ļ�������,�������֮����","���ŷָ�
			* allowedExtensions:�����ϴ��ļ���չ��,�����չ��֮����","���ŷָ�
			* �Ƚ��鷳,�����������
	4,struts.multipart.saveDir			'������ʱĿ¼'
		* Ĭ��Ϊ��,û������!

	5,���ļ��ϴ�
		* ��ҳ�����ṩ���file�ֶ�!���,���ǵ�name���Զ�һ��!��ôAction�е��������򲻱�!����,�������Ա�ɼ���.�Լ�����ȡ��
			* private List<File> xxx;//����ļ����name���Ա���һ��.���ļ������ϴ��ļ�
			* private List<String> xxxContentType;//�ϴ��ļ�������
			* private List<String> xxxFileName;//�ϴ��ļ�������

		* ����Ŀfiel�ֶ�name�������ƶ���һ��!


����������������������������������������������������������������
��,struts2����ĳ��Action�ļ��ϴ�|
����������������������������������������������������������������
		['�ϴ���С/�ļ���������,�����Ķ�ĳ��form/Action��Ч']
		> ���Կ���'fileUpload'�����������������!
			* maximumSize:�ϴ��ļ�����󳤶�(�ֽ�Ϊ��λ),Ĭ��Ϊ2MB
			* allowedTypes:�ϴ��ļ�������,�������֮����","���ŷָ�
			* allowedExtensions:�����ϴ��ļ���չ��,�����չ��֮����","���ŷָ�
		> ����������Ĭ�ϵ��������C����
			<interceptor-ref name="defaultStack">
				<param name="fileUpload.allowedTypes">txt,mp3,doc</param>
				<param name="fileUpload.maximumSize">1024</param>
				<param name="fileUpload.allowedExtensions">.gif</param>
			</interceptor-ref>
			* ����Ҫ�����Ƶ�Action��'��ʽ������:����Ĭ�ϵ�������ջ'
			* ��ͨ��OGNL���ʽ,���ж�'fieUpload���Խ��и�ֵ'
			* ��ô,���Action���ϴ��ͻᱻ����!�����������,�ͷ���input����


---------------------------------------�ļ��ϴ�,Ŀ¼��ɢ��
		//���ͷ��Ϊnull
		if(pic != null)
		{
			String uploadFile = "/upload/user";
			//�Ӹ�Ŀ¼��ȡ����·��
			String rootFilePath = ServletActionContext.getServletContext().getRealPath(uploadFile);
			//����ΨһID
			String fileName = Utils.getUUID()+"_"+picFileName;
			//Ŀ¼��ɢ,�����ļ����ƻ�ȡ��ϣֵ
			int hashCode = fileName.hashCode();				
			//�ѹ�ϣֵת��Ϊ16����
			String hex = Integer.toHexString(hashCode);	
			//��ȡ16���Ƶĵ�1,2���ַ�	
			String filePath = hex.charAt(0)+"/"+hex.charAt(1);	
			//��1���ַ���Ϊ��Ŀ¼,�ڶ����ַ���Ϊ��Ŀ¼
			File dirFile = new File(rootFilePath,filePath);	
			//����Ŀ¼��
			dirFile.mkdirs();	
			//����Ŀ¼��+�ļ���,���������ļ�
			File saveFile = new File(dirFile,fileName);
			//�����ļ�������
			FileUtils.copyFile(pic, saveFile);
			//�����ļ�����
			user.setHeadImg(uploadFile+"/"+filePath+"/"+fileName);
		}
////////////////////////////


	1,ʹ�ù�ϣ��ɢ
	2,�����ϴ��ļ�����hashCode();��ȡһ��intֵ,
	3,�ٰ����intֵ,��Ϊ16����!
	4,16������ʾ���ַ���ΧΪ:0-9 A-F
	5,ʹ��16����ǰ��λ��ΪĿ¼��
		* ��һλΪ��Ŀ¼
		* �ڶ�λΪ��Ŀ¼

	ÿ��Ŀ¼�¶�������16��Ŀ¼


	ȱ��:�ļ��浽����?�˹�������!

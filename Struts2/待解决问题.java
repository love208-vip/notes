�ļ����ص�����
	-- �����ļ��� name���Բ�һ��
	--xml���ò�������

ֵ�C����
	--set(name,Object);
	--����ֵ�C��ʱ��,��ÿ�����ݶ�����һ��Map,����˵����ֵ�C�����ݶ�ֻ��һ��Map
	--���ꡣ�������ƿ�ܣ�ֱ�ӷ���������¶�!�������ë����Ū��ֵ�C�п�а���
	--��OGNL����������X��

������֤��
	--> ����ʹ��Servlet,�ͻ���������֤��������Actionʵ��!
	--> ���ͷ�����Ǹ����?Content-disposition
	*  Action ���� none,�ֶ��Ļ�ȡresponse,��ȡ����Ӧ!����Servlet��һ��!
	*  Ajax ͬ��,ֱ�� return null,�ֶ���ȡresponse,�Լ�����Ӧ!



['��Ŀ����']
	--> result����Զ�����Խ���������ͬʱ��һ��Action�����
	--> У���ļ��Ƕ����з�����У��,һ��Ҫע��
	--> ʹ��ͨ���Action���ܻ����,���ϵͳ������������ʹ��ͬһ��resut--->input��ͼ
		* ����:��¼���ϴ��ļ�����ͬһ��Action������!��������������У����!xml,������Ĭ����ת�Ķ���input��ͼ.
		* �����ļ�ֻ����һ��resutl��ͼ����!�����������ֲ�ͬ��ҵ��ʽ����һ���ض��İɣ�
		['�������']
		��ĳ������input��ͼ�ķ��������ע��
		@InputConfig(resultName="�Զ�����ͼ����")
		> ���ע��ͻ�ı䷽������Щ'�Զ���ת'input��ͼ��������!���Ǿͻ�Ĭ����ת����ָ������ͼ!
	--> <s:if test="#session.session_user == null">
			session�������ݵ����
		</s:if>
		<s:else>
			session��û���ݵ����
		</s:else>

	---> 
		<jsp:include page="jspҳ��"/>		��̬����
		���԰Ѷ����Ĳ˵�:��¼/ע��/�����ȵȶ�����������ҳ����
	--> <s:fielderror fieldName="username"/>
		ҳ��ͨ�����,ȡ��Action��ͨ��this.addFieldError("username", "��֤�벻��ȷ");��ӵ�����
		* ֻҪ������������������,��ô�Զ�Ĭ�ϵľͻ���input��ͼ��
	-->	<s:actionmessage/>
		ҳ��ͨ�����,ȡ��Action��ͨ��this.addActionMessage("��ϲ,����ɹ�");��ӵ�����

	--> struts2 Action �е�get();���ж������������ֵ�C! ֱ��ͨ��<s:property value="xxx"/>	//getXxx();


	--> �̳���ҳ��Action����N���Service,��ȡ��ͬ������.������ϵȣ�һ��������ҳ����չʾ
	--> ModelDriven�ӿڷ������صĶ�������ֵ�C��,����ͨ��:model.����  ȡֵ
	--> <s: iterator begin="1" end="pageBean.totalpage" var="x">
			<s:if test="#x == pageBean.pageCode")
				//if�жϱ�ǩ��,����ֱ�ӽ��������ж�
			</s:if>
			<s:else>
				//else��ǩֱ�Ӽ�������ͺ�
			</s:else>
		</s:iterator>
		* ������ǩ��,����ͨ�����ַ�ʽ���е���
	
	--> ��������ɾ��
		1,������ѭ������'�û�',��ʱ��,��ÿ���û�ǰ�涼����һ��checkbox,name��������.ֵΪ'�û�id'!
		2,�ύ����������ʱ��,�ͻ�ѱ�ѡ�е�id,��nameΪ����������ʽ�����ݴ��ݸ�������!д������,ѭ��ɾ��!
	--> ����Action�е�����һ��ActionҲ�ǿ��Ե�:return list();
		ֱ�Ӿͷ��ظ�action��ֵ,���Ҹ�action��������ҵ�����,�����ݶ�������ֵ�C!
	--> �ض������Ҫ,��Ϊת���������ַ�������仯,���һЩ�ύ��������ת���Ļ�,ҳ���ַ�����ύ��ҳ���ַ,�ٴ�ˢ�»��ظ��ύ����

	--> <a href="javascript:delete('${user.id}')"/>
	   function delete(id){
			...����....����URL+id;
	   }
	 
	--> ����û����ظ�������
		* �����ʱ��ͼ�,�����û�����ѯһ����,�ܲ���û�.�Ǿ����ظ���!
			SELECT * FOMR user WHERE account="�˺�";
		* �༭��ʱ��
			1,�༭��ʱ��,���ݿ����Ѿ������˶�Ӧ���û���.���в�ѯ��ʽҪ�ı�
			SELECT * FROM user WHERE account='�˺�' AND id='�û�id';
			* �˺�Ϊ�༭֮����˺�
			* ����������ڱ༭���û�,��������˺Ŷ�Ӧ�ļ�¼.�Ǿ����ظ���.

	--> Radio������
		<s:radio list="#{'1':'��Ч','0':'��Ч'}" name="role.state"/>

	--> struts2ʹ��OGNL�ж�
			<%--�û�ͷ��Ϊ�� --%>
            <s:if test="%{user.headImg != null && user.headImg != ''}">
            	<img src="${pageContext.request.contextPath }${user.headImg}" width="100" height="100"/>
            	<input type="hidden" name="headImg" value="${user.headImg}"/>
            </s:if>
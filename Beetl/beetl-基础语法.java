------------------------
Beet �����﷨			|
------------------------
	# �������ռλ����
		* beetlģ����������JS���Ժ�ϰ��,ֻҪ��Beetl���Է��붨����ż���
		* Ĭ�ϵ��� <%  %>,ռλ�����ھ�̬�ı���Ƕ�룬ռλ���������
			<%
				var a = 2;
				var b = 3;
				var result = a + b;
			%>
			hello 2+3 = ${result}
		* �������ռλ�� ͨ�����б��ѡ�����¶����
			@ �ͻس����� (��ʱ,ģ������DELIMITER_STATEMENT_END= ���� DELIMITER_STATEMENT_END=null ������)
			#	: �ͻس�����
			<!--: �� -->
			<!--# �� -->
			<? �� ?>
		* ����������Ǳ��ʽ��������ʽ�����������ռλ���г�ͻ���������� ��\�� ����
			@for(user in users){
				il is ${user.name}\@163.com
			@}
			${[1,2,3]} //���һ��json�б�
			${ {key:1,value:2 \}  } //���һ��json map��} ��Ҫ����\
	
	# ע��
		* Beetl�﷨����js�﷨������ע����Ҳͬjsһ���� ����ע�Ͳ���//
		* ����ע�Ӳ���/**/
	
	# ��ʱ��������
		* ��ģ���ж���ı�����Ϊ��ʱ������������js�в���var ����ı���
			var x = 3;
			var b =3,c = "abc",d=true,e=null;
			var f = [1,2,3];
			var g = {key1:a:key2:b};
			var y = x + b;
	
	# ȫ�ֱ�������
		* ȫ�ֱ�����ͨ��template.binding����ı���,��Щ��������ģ����κ�һ���ط���������ģ�嶼�ܷ��ʵ���
			template.binding("list",service.getUserList());
			//��ģ����
			<% 
				for(user in list){
			%>
				hello,${user.name};
			<% 
				} 
			%>
	
	# �������
		* �������ָ������ģ���ж��������õı�����
		* �� groupTemplate.setSharedVars(Map sharedVars)����ı���,��Щ�������� ����ģ�� ���κ�һ���ط�
			//.....
			GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, cfg);
			//�����������,Map
			Map<String,Object> shared = new HashMap<String,Object>();
			//��������
			shared.put("name", "beetl");
			/*
				���ù������
			*/
			groupTemplate.setSharedVars(shared);
			//��ȡģ��1
			Template template = groupTemplate.getTemplate("/org/beetl/sample/s0208/t1.txt");
			//��Ⱦģ��һ
			String str = template.render();
			System.out.println(str);
			//��ȡĿ��2
			template = groupTemplate.getTemplate("/org/beetl/sample/s0208/t2.txt");
			//��Ⱦģ��2
			str = template.render();
			System.out.println(str);


			//t1.txt
			hi,${name}
			//t2.txt
			hello,${name}

	# ģ�����
		* ģ�������һ������ı����������Խ�ģ�����κ�һ�ε������ֵ���ñ������������Ժ��������ط�ʹ��
			<%
				var content = {
					var c = "1234";
					print(c);
			%>
			ģ���������ݣ�
			<% 
				}; 
			%>
			* ��2�ж�����һ��ģ�����content = { ��} ; �˱�������ʱ����һ���������������ط�ʹ�ã�
			* ������÷������ڸ��ӵĲ��֡���ο��߼��÷�����
	
	# ��������

		* ����������ģ���е���Ҫһ����,beetl֧������ͬjavascript��֧�ַ�ʽһ��

		* Beetl֧��ͨ��"."�������ʶ���ĵ�����,���javascriptһ�������User�����и�getName()��������ô��ģ���У�����ͨ��${xxx.name}������

		* ���ģ��������������List��,�����ͨ��[] ������,��${userList[0]}

		* ���ģ�������Map��,�����ͨ��[]������,��${map["name"]},���keyֵ���ַ���
		  Ҳ����ʹ��${map.name}.����������ôʹ��,��Ϊ����ģ���Ķ�������Ϊ��һ��Pojo����

		* BeetlҲ֧��Generic Get��ʽ,�����������һ��public Object get(String key)����
		  ����ͨ����.���Ż���[]������,Ʃ�� ${activityRecord.name}����${activityRecord["name"] }��������activityRecord�� get(String key)������
		  ���������о�������,����Generic get(����ģ����Ʒ�ʽ�ǲ�ֵ�ù���),���Ծ����������ȼ���.
		 
		* BeetlҲ����ͨ��[]���������ԣ���${user["name"]} �൱��${user.name}.���javascript����һ�¡�
		  �����鲻��ô������Ϊ�������Ķ�ģ���������Ϊ����һ��Map����
		 
		* Beetl �����Զ�λ����Ķ�������,���������java����,�����������
		  ��,�������м���,����,���й�ͬ����������size.
		  ����������".~"+����1������

		template.binding("list",service.getUserList());
		template.binding("pageMap",service.getPage());

		//��ģ����
		�ܹ� ${list.~size}
		<%
			for(user in list){
		%>
		hello,${user.name};
		<% 
			} 
		%>

		��ǰҳ${pageMap['page']},�ܹ�${pageMap["total"]}

	# ���Ը�ֵ
		* Beetl2.7.0 ��ʼ֧�ֶ���ֵ
			var user = ....
			user.name="joelli";
			user.friends[0] = getNewUser();
			user.map["name"] = "joelli";

	# �������ʽ
		* Beetl֧������javascript���������ʽ���������ʽ����+ - * / % �Լ��������Լ�����++���Լ�--
			<%
				var a = 1;
				var b = "hi";
				var c = a++;
				var d = a+100.232;
				var e = (d+12)*a;
				var f = 122228833330322.1112h
			%>
		* Beetl�ﶨ�����ʱ��������Ĭ�϶�Ӧ��java��Int�ͻ���double����,����ģ�峣�����˵,�Ѿ�����
		* �����Ҫ���峤��������(��Ӧjava��BigDecimal,����Ҫ������ĩβ����h�Ա�ʾ���ǳ�����BigDecimal,���ļ��������Լ��߼����ʽ�������ճ���������������
	
	# �߼����ʽ
		* Beetl֧������Javascript,java���������ʽ ��>��\<��==��!=��>= , \<= �Լ� !, ����&&�� || ��������Ԫ���ʽ�ȣ���������
			<%
				var a = 1;
				var b=="good";
				var c = null;
				if(a !=1 && b=="good" && c==null){
					
				}
			%>
		* ��Ԫ���ʽ���ֻ����true������Ӧ��ֵ�Ļ�����������,��������Ч����һ���ġ�
			<%
			 var  a = 1 ;
			%>
			${a==1 ? "ok":''}
			${a==1 ? "ok"}
	
	# ѭ�����
		* Beetl֧�ַḻ��ѭ����ʽ����for-in,for(exp;exp;exp)���Լ�whileѭ�����Լ�ѭ���������break;continue; 
		* ���⣬���û�н���forѭ���壬������ִ��else forָ������䡣
		-----------------------------------------------
		for in 
			* ѭ������֧�ֱ������϶���,����List�������Լ� Iterator ��˵,������Ǽ��϶���.
			* ����Map��˵���������Map.entry

			<%	//��������/����/Ierator
				for(user in userList){
					print(userLP.index);
					print(user.name);
				}
			%>
			<%	//����map
				for(entry in map){
					var key = entry.key;
					var value = entry.value;
					print(value.name);
				}
			%>

			* �����д���userLP��Beetl��������ı���������ѭ������ʹ�á��������淶��item���ƺ����LP�����ṩ�˵�ǰѭ������Ϣ����
				userLP.index	��ǰ����������1��ʼ
				userLP.size		���ϵĳ���
				userLP.first	�Ƿ��ǵ�һ��
				userLP.last		�Ƿ������һ��
				userLP.even		�����Ƿ���ż��
				userLP.odd		�����Ƿ�������
		
		-----------------------------------------------
		for(exp;exp;exp) 
			* ������Ⱦ�߼���Ϊ�������Ǿ����forѭ�����
			<%
				var a = [1,2,3];
				for(var i=0;i<a.~size;i++){
						print(a[i]);
				}
			%>
		
		-----------------------------------------------
		while
			* ������Ⱦ�߼�ͬ���������е�whileѭ�����
			<%
				var i = 0;
				while(i<5){
					print(i);
					i++;
				}
			%>
		
		-----------------------------------------------
		elsefor
			* ��ͬ��ͨ���������ԣ����û�н���ѭ���壬�������Ĵ���
			* ģ����Ⱦ�߼���������������û�н���ѭ���壬����Ҫ����ʲô
			* ��ˣ�����forѭ����˵������elsefor ����������ѭ����û�н��룬��ִ��elsefor ������
			<%
				var list = [];
				for(item in list){
					print(item.name);		//�ռ���,����ִ��ѭ����
				}elsefor{
					print("δ�м�¼");
				}
			%>
	
	# �������
		-----------------------------------------------
		if else
			* ��JSһ��,֧�� if else
				<%
					var a =true;
					var b = 1;
					if(a && b==1){

					}else if(a){

					}else{

					}
				%>
			
		-----------------------------------------------
		switch-case
			* ��JSһ��
			* switch��������֧���κ����ͣ�������js����ֻ��������
				<%
					var b = 1;
					switch(b){
						case 0:
								print("it's 0");
								break;
						case 1:
								print("it's 1");
								break;
						default:
								print("error");
					}
				%>
		
		-----------------------------------------------
		select-case
			* select-case ��switch case����ǿ�档������case �����߼����ʽ��
			* ͬʱ��Ҳ����Ҫÿ��case��breakһ�£�Ĭ�������Ϻ�������caseִ�к���˳���
				<%
					var b = 1;
					select(b){
						case 0,1:	//�����0����1
								print("it's small int");
						case 2,3:	//�����2����3
								print("it's big int");
						default:
								print("error");
					}
				%>
			* select ��Ҳ����Ҫһ������������case ����߼����ʽ������ִ���ĸ�case.
				<%
					select {
						case boolExp,orBoolExp2:		//���ʽ��ʽ
								doSomething();
					}
				%>
				<%
					var b = 1;
					select{
						case b<1,b>10:
								print("it's out of range");
								break;
						case b==1:
								print("it's 1");
								break;
						default:
								print("error");
				}
				%>
	
	# try-catch
		* ͨ��ģ����Ⱦ�߼������õ�try-catch �����ǵ���Ⱦ�߼������ԣ��Լ�ģ��Ҳ�в��ɿصĵط���
		* �����ṩtry catch������Ⱦʧ�ܵ�ʱ����Ȼ�ܱ�֤�������
			<%
				try{
						callOtherSystemView()
				}catch(error){
						print("��ʱ������");
				}
			%>
		* error������һ���쳣�������ͨ�� error.message ����ȡ���ܵĴ�����Ϣ
		* Ҳ����ʡ��catch���֣����������쳣�������κβ���
	
	# ��������
		* ��������Ҳ�Ƕ�������ԣ���������ģ���ģ�Ͷ������ʵ���ԣ������ĺô��ǵ�ģ����Ҫ�����������ʾ�����Ե�ʱ���ֲ������ģ�ͣ�����Բ������ְ취 
		* ��beetl���õ���������.~size ����������Լ��������͡�
			${user.gender}
			${user.~genderShowName}
			~genderShowName ���������ԣ����ڲ�ʵ�ָ���boolean����gender����ʾ�Ա�
			�������������ԣ���ο��߼��÷�
	
	# ��������
		* Beetl����������ʵ�ú�����������Beetl�κεط����á����������ǵ���date ������������������£����ص�ǰ����
			<%
				var date = date();
				var len = strutil.length("cbd");
				println("len="+len);
			%>
		* ע�⺯����֧��namespace��ʽ����˴����3�е��õĺ�����strutil.length
		* ����beetl�ķ����ǳ����ף������ַ���
			ʵ��Function���call����������ӵ������ļ��������ʾ��ͨ������ע��registerFunction(name,yourFunction)
			����ֱ�ӵ���registerFunctionPackage(namespace,yourJavaObject),��ʱ��yourJavaObject�������public��������ע��ΪBeetl��������������namespace+"."+������
			����ֱ��дģ���ļ�������html��Ϊ��׺���ŵ�root/functionsĿ¼�£�������ģ���ļ��Զ�ע��Ϊһ���������亯�����Ǹ�ģ���ļ�����
	
	# ��ȫ���
		* ��ȫ������κ�һ��ģ������������ӵ����⣬���򣬽���������ģ�忪���ߡ�
		* Beetl�У����Ҫ�����ģ�����Ϊnull����beetl�������������㲻ͬ��JSP��JSP���null��Ҳ��ͬ��Feemarker�����û����!,���ᱨ��.
		* ģ���л�����������ᵼ��ģ������쳣
			1,��ʱ��ģ������������ڣ�Ʃ����ģ���
			2,ģ�����Ϊnull����������Ǵ˱�����һ�����ԣ���${user.wife.name} //������û����,�����������ӵ�����
		* ���ǰ����������������ڱ������ú���� "!" ������beetl����һ����ȫ����ı�����
		* ��${user.wife.name! },��ʹuser�����ڣ�����userΪnull������user.wifeΪnull������user.wife.nameΪnull beetl���������
		* ������!������һ���������ַ������������͵ȣ�����������һ�����������������ص��ã���ΪĬ�����
			${user.wife.name! "����"}
			//���userΪnull������user.wifeΪnull������user.wife.nameΪnull�����������
			${user.birthday!@System.constants.DefaultBir}
			//��ʾ���userΪnull������user. birthdayΪnull�����System.constants.DefaultBir
		* ����һ��������ٷ�������Ҳ�п��ܣ����ģ������������κ��쳣��������ڲ��׳���һ���쳣����Ҫʹ�ø�ʽ${!(����)},�������ڱ������÷����κ��쳣����£����������
			${!(user.name)}
			//beetl�������user.getName()��������������쳣��beetl������Դ��쳣��������Ⱦ
		* ֵ��ע����ǣ��ڱ��������!����������Ӧ����ռλ�����(����Ҫ��Ӧ����ռλ�����)��Ҳ�������ڱ��ʽ��
			<%
				var k = user.name!'N/A' + user.age!;	//���userΪnull����kֵ��ΪN/A
			%>
			<%
				${k}
			%>
		* ����Щģ�����������ģ�嶼��Ҫ��ȫ�����Ҳ����ģ��Ĳ�����Ҫ��ȫ�����ʹ���߲���Ϊÿһ�����ʽʹ�ã�������ʹ��beetl�İ�ȫָʾ��������ɰ�ȫ��� 
			<%
				//������ȫ���
				DIRECTIVE SAFE_OUTPUT_OPEN;
			%>
			${user.wife.name}
			ģ���������ݣ����ܰ�ȫ�������
			<%
				//�رհ�ȫ�����
				DIRECTIVE SAFE_OUTPUT_CLOSE;
			%>
		* Beetl������ÿһ��ҳ�涼ʹ��DIRECTIVE SAFE_OUTPUT_OPEN�����������������в������Ĵ��󣬲����׼�ʱ����
		* ��ȫ�����ζ��beetl���ж���Ĵ�����ֵ�Ƿ���ڻ����Ƿ�Ϊnull�����ܻ��Բ�㡣���Խ��鼰ʱ�رհ�ȫ������ⲻ�Ǳ���ģ���ҳ�����еط��ǰ�ȫ��������ܲ����׷��ִ���
		* ��for-in ѭ���� ��Ҳ����Ϊ���ϱ������Ӱ�ȫ���ָʾ���ţ�������������ϱ���Ϊnull��Ҳ���Բ�����ѭ����
			<%
				var list = null;
				for(item in list!){

				}elsefor{
						print("no data");
				}
			%>
		* �����Ƿ����
			<%
				if(has(flag)){
						print("flag�������ڣ����Է���")
				}
			%>
		* �����Ҫ�жϱ����Ƿ���ڣ�������ڣ����������ж�������ͨ������ôд
			<%
				//���flag�����ڣ�����flag���ڣ���ֵ��0������ִ��if���
				if(has(flag) || flag ==0){
					//code
				}
			%>
		* ����,�и�Ϊ���ķ�����ֱ���ð�ȫ���
			<%
				//'flag!0' ȡֵ�������ģ����flag�����ڣ���Ϊ0��������ڣ���ȡֵflag��ֵ��������Ԫ���ʽ has(flag)?falg:0
				if(flag!0 == 0){
						//code
				}
			%>

		* ��ȫ������ʽ, ��ȫ������ʽ���԰���
			�ַ�������,�� ${user.count!"�޽��"}
			boolean���� ${user.count!false}
			���ֳ�������������������Ϊ����Ǹ����������Ƽ��ţ��������ã���ˣ������Ҫ��ʾ�������������ţ���${user.count!(-1)}
			classֱ�ӵ��ã���${user.count!@User.DEFAULT_NUM}
			�������ã��� ${user.count!getDefault() }
			�������ã��� ${user.count!user.maxCount }
			�κα��ʽ����Ҫ������
	
	# ��ʽ��
		* �������е�ģ�����Զ�֧�ָ�ʽ��
			<% var date = date(); %>
			Today is ${date,dateFormat="yyyy-MM-dd"}.
			Today is ${date,dateFormat}
			salary is ${salary,numberFormat="##.##"}
		* ��ʽ������ֻ��Ҫһ���ַ�����Ϊ��������=�ź��棬
		* ���û��Ϊ��ʽ�����������������ʹ��Ĭ��ֵ��dateFormat��ʽ������Ĭ��ֵ��local
		* BeetlҲ����Ϊָ����java class�趨��ʽ��������
		* Ʃ���Ѿ������˶�java.util.Date,java.sql.Date �������˸�ʽ�������������������ӿ��Լ�Ϊ
			${date,"yyyy-MM-dd"}
		* Beetl������ں����������ṩ��Ĭ�ϵĸ�ʽ����������org/beetl/core/beetl-default.properties�ע����
			##���õĸ�ʽ������
			FT.dateFormat =  org.beetl.ext.format.DateFormat
			FT.numberFormat =  org.beetl.ext.format.NumberFormat
			##���õ�Ĭ�ϸ�ʽ������
			FTC.java.util.Date = org.beetl.ext.format.DateFormat
			FTC.java.sql.Date = org.beetl.ext.format.DateFormat
			FTC.java.sql.Time = org.beetl.ext.format.DateFormat
			FTC.java.sql.Timestamp = org.beetl.ext.format.DateFormat
			FTC.java.lang.Short = org.beetl.ext.format.NumberFormat
			FTC.java.lang.Long = org.beetl.ext.format.NumberFormat
			FTC.java.lang.Integer = org.beetl.ext.format.NumberFormat
			FTC.java.lang.Float = org.beetl.ext.format.NumberFormat
			FTC.java.lang.Double = org.beetl.ext.format.NumberFormat
			FTC.java.math.BigInteger = org.beetl.ext.format.NumberFormat
			FTC.java.math.BigDecimal = org.beetl.ext.format.NumberFormat
			FTC.java.util.concurrent.atomic.AtomicLong = org.beetl.ext.format.NumberFormat
			FTC.java.util.concurrent.atomic.AtomicInteger = org.beetl.ext.format.NumberFormat
	
	# ��ǩ����	
		* ��ν��ǩ��������������ģ���ļ����һ�����ݣ����ܵ���ͬjsp tag��
		* Beetl���õ�layout��ǩ
			//index.html
			<%
				layout("/inc/layout.html",{title:'����'}){
			%>
			Hello,this is main part
			<% 
				} 
			%>

			//layout.html
			title is ${title}
			body content ${layoutContent}
			footer

			* ��1�б���title������layout��ǩ�����Ĳ���
			* ��2��layoutContent ��layout��ǩ��{}��Ⱦ��Ľ��
			* ����layout��ǩ���ο��߼����Ⲽ��

		* Beetl����������һ����ǩ��include,���� include ����һ��ģ���ļ�
			<%
				include("/inc/header.html"){}
			%>
		* �ڱ�ǩ�У�{} ���ݽ����ݱ�ǩ��ʵ�ֶ�ִ�У�layout��ǩ��ִ��{}�е����ݣ���include��ǩ����Ա�ǩ�����ݡ�

		* �������ʵ�ֱ�ǩ��������ο��߼�����,������һ���򵥵ĵı�ǩ������

			public class CompressTag extends Tag{
					@Override
					public void render(){
							BodyContent  content = getBodyContent();
							String content = content.getBody();
							String zip = compress(conent);
							ctx.byteWriter.write(zip);
					}
			}
	
	# HTML��ǩ	
		* Beetl Ҳ֧��HTML tag��ʽ�ı�ǩ�� ����beetl��html tag �� ��׼html tag��
		* ���趨HTML_TAG_FLAG=#��������html tag����beetl����
			<#footer style=��simple��/>
				<#richeditor id=��rid�� path="${ctxPath}/upload" name=��rname��  maxlength=��${maxlength}��> ${html} ������ģ������   </#richdeitor>
			<#html:input  id=��aaaa�� />

			* ����ڱ�ǩfooter,BeetlĬ�ϻ�Ѱ��WebRoot/htmltag/footer.tag(����ͨ�������ļ��޸�·���ͺ�׺) ,��������:
				<% 
					if(style==��simple��){ 
				%>
					����ϵ�� ${session.user.name}
				<% 
					}else{ 
				%>
					����ϵ�� ${session.user.name},phone:${session.user.phone}
				<% 
					}
				%>
	
	# �󶨱�����HTML��ǩ
		
	# ֱ�ӵ���java����������
		* ����ͨ������@������������ʽ������java���
		* ���Ե��ö���ķ���������
			${@user.getMaxFriend(��lucy��)}
			${@user.maxFriend[0].getName()}
			${@com.xxxx.constants.Order.getMaxNum()}
			${@com.xxxx.User$Gender.MAN}
			<%
				var max = @com.xxxx.constants.Order.MAX_NUM;
				var c =1;
				var d = @user.getAge(c);
			%>
		* ���Ե���instance��public���������ԣ�
		* Ҳ���Ե��þ�̬������Ժͷ��� ,��Ҫ��һ�� @ ָʾ�˵�����ֱ�ӵ���class�����ı��ʽ��java���ġ�
		* GroupTemplate��������Ϊ������ֱ�ӵ���Class��������ο������ļ�.
		* Ҳ����ͨ����ȫ���������õ�����Щ��Beetl��������ã�������ο��߼��÷���
		* Ĭ�������java.lang.Runtime,�� java.lang.Process��������ģ������á����Լ��İ�ȫ������Ҳ���������Ϊ����ֱ�ӷ���DAO�ࣨ��������ǰjsp���Է���������������Σ����
		* �밴��java�淶д�����ͷ�����������������������beetlʶ�𵽵׵��õ����ĸ��࣬�ĸ�������������׳�����
		* ����ʡ�԰�����ֻ��������beetl��������·���ҵ����ʵ��ࣨ��Ҫ��������"IMPORT_PACKAGE=����.;����."����������Ҫ��һ��".", ���ߵ���"Configuration.addPkg")����������ο����������ļ�˵��
		* �ڲ��ࣨ����ö�٣�����ͬjavaһ������User���и��ڲ�ö����Gender��������User$Gender
		* ���ʽ��java��񣬵�������Ȼ��beetl���ʽ������ @user.sayHello(user.name).����user.sayHello��java���ã�user.name ��Ȼ��beetl���ʽ
	
	# �ϸ�MVC����
		* ����������ļ����������ϸ�MVC���������﷨������ģ���ļ����������򽫱���STRICK_MVC ����
			* ���������Ϊ������ֵ,��var a = 12�ǷǷ���
			* �������ʽ ��${user.age+12}�ǷǷ���
			* ����ֻ���������⣬�������߼����ʽ�ͷ������� ��if(user.gender==1)�ǷǷ���
			* �������ã���${subString(string,1)}�ǷǷ���
			* Class���������Ե��ã���${@user.getName()}�ǷǷ���
			* �ϸ��MVC���ǳ��������߼�����ͼ�ķ��룬�ر��߼�����ͼ���������Ŷ�����ɵġ�������Ⱥ��ϸ�MVC�����Ե���groupTemplate.enableStrict()
			* ͨ������ AntlrProgramBuilder �����԰����Լ��ķ������Ƶ�����Щ�﷨�ǲ�������ģ�������г��ֵģ������Ѿ�������Beetlģ��Ļ���ʹ��
	
	# ָ��
		* ָ���ʽ: DIRECTIVE ָ���� ָ���������ѡ�� 
		* BeetlĿǰ֧�ְ�ȫ���ָ��ֱ���
			DIRECTIVE SAFE_OUTPUT_OPEN ; �򿪰�ȫ������ܣ���ָ�������б��ʽ�����а�ȫ������ܣ�
			DIRECTIVE SAFE_OUTPUT_CLOSE ; �رհ�ȫ������ܡ�����ο���ȫ���
			DIRECTIVE DYNAMIC varName1,varName2 ��ָʾ����ı����Ƕ�̬���ͣ�BeetlӦ�ÿ���ΪObject. Ҳ����ʡ�Ժ���ı����������ʾģ�������б�������Object
				<% DIRECTIVE DYNAMIC idList;
				for(value in idList) .....
				* DYNAMIC ͨ���������ģ�����Ϊ���ģ����Խ����κ����͵Ķ������б�ؼ������Խ����κκ���id�� value���ԵĶ���
				* ע�� DYNAMIC ��ı�����Ҳ���������ţ�����Ҫ�Ǽ���Beetl1.x�汾
		* Beetl1.x ָ��Ǵ�д����ǰ�汾Ҳ����Сд���� directive dynamic idList
	
	# ��������
		* Beetl �����ϻ���ǿ���͵�ģ�����棬��ģ��ÿ�������������ض��ģ���ģ�����й����У�beetl �����ȫ�ֱ����Զ��Ʋ��ģ���и��ֱ����ͱ��ʽ���͡�
		* Ҳ����ͨ������������˵��beetlȫ�ֱ���������
			<%
			/*
			 * @type (List<User> idList,User user)
			 */
			for(value in idList) .....
		* ������������ŵ�����ע����
		* ��ʽ��@type( �� ),�������������java�����Ĳ���������
		* �����㿴����������������ע���Ҳ�ͱ���������Beetlģ�������в��Ǳ���ģ�������ֻ��Ҫ����һ���ּ��ɣ�֮�����ṩ��ѡ������˵��������Ϊ
			* ���һ������
			* ����Ҫ���ǣ������ģ��Ŀ�ά���ԡ�������ģ��ά����֪���������ͣ�Ҳ������δ����ide������������������ṩ������ʾ���ع��ȸ߼�����
			* ��Ҫע����ǣ�����������������ṩ������������������ȫ·�������������������ļ��������������·��(����Ҫ��������IMPORT_PACKAGE=����.;����.�����ߵ���Configuration.addPkg))��
			* Ĭ�ϵ�����·����java.util. �� java.lang.
	
	# ������
		* Beetl�ܽ�Ϊ��ϸ����ʾ����ԭ�򣬰�������������������ţ��������ݸ�����ģ�����ݣ��Լ�����ԭ��������쳣���������쳣���쳣��Ϣ�� 
		* Ĭ������£������ڿ���̨��ʾ��
			<%
				var a = 1;
				var b = a/0;
			%>
			* ���д�ģ��󣬴�����ʾ����
				DIV_ZERO_ERROR:0 λ��3�� ��Դ:/org/beetl/sample/s0125/error1.txt
				1|<%
				2|  var a = 1;
				3|  var b = a/0;
				4| %>
			
		* Ĭ�ϵĴ��������������̨��ӡ���󣬲�û���׳��쳣��
		* �����Ҫ��render����ʱ���׳��쳣�����Ʋ㣬�����ʹ��org.beetl.core.ReThrowConsoleErrorHandler��������ӡ�쳣�����׳�BeetlException
		* �����Զ����쳣������������Ѵ�������� ��Ϊ��Ⱦ���һ���������������������۵�html���ݵȣ�����ο��߼��÷�
		* �����������ļ��������쳣������Beetl���潫�������쳣���û��������ⲿ�������������ⲿ����ErrorHandler��������ʾ�쳣��
	
	# BeetlС����
		* BeetlKit �ṩ��һЩ�����ķ�������������ʹ��Beetlģ�����档�ṩ�����·���
			public static String render(String template, Map<String, Object> paras) ��Ⱦģ�壬ʹ��paras��������Ⱦ�����Ϊ�ַ�������
			public static void renderTo(String template, Writer writer, Map<String, Object> paras) ��Ⱦģ�壬ʹ��paras��������Ⱦ�����Ϊ�ַ�������
			public static void execute(String script, Map<String, Object> paras) ִ��ĳ���ű�
			public static Map execute(String script, Map<String, Object> paras, String[] locals) ִ��ĳ���ű�����localsָ���ı�������ģ��ִ�к���Ӧֵ���뵽���ص�Map��
			public static Map executeAndReturnRootScopeVars(String script) ִ��ĳ���ű����������ж���scope�����б�����ֵ
			public static String testTemplate(String template, String initValue) ��Ⱦģ��template���������Դ��intValue�ű����еĽ���������ж���Scope�ı���������Ϊtemplate�ı���
			public static String testTemplate(String template, String initValue) ��Ⱦģ��template���������Դ��intValue�ű����еĽ���������ж���Scope�ı���������Ϊtemplate�ı���
			String template = "var a=1,c=2+1;";
			Map result = executeAndReturnRootScopeVars(template);
			System.out.println(result);
			//��������{c=3, a=1}
		* BeetlKit����Ҫ��������ϵͳ��������Ϊ����Beetl���ܶ��ṩ�ģ������Ҫ������ʹ����Щ���ܣ���ο�����Դ��������չ

	# ���鹦��
		* ����:�ҷ��ֱ��ģ������Ҫ���������룬�ǳ�����,ʹ��Beetl����ȫ���õ��ģ�����velocty��stringtemlate��freemarker���Ӷ������˲�����������Ӱ�������ۣ�Beetl��ȫ���赣���������
		* Escape:����ʹ��\ ��escape ���ţ���\$monkey\$ ����Ϊһ����ͨ���ı������Ϊ$monkey$.����Ϊ���ں������Ԫ���ţ�ռλ��ǡ��������Ԫ���ţ������������ַ�ʽhello,it��s $money$\$, ����Hello,it��s $money+"\$"$ �����Ҫ���\���ű���������Ҫ������\,�����javascript��java ����һ��.


------------------------
Beet �߼�����			|
------------------------
	
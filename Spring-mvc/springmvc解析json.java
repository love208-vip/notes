
//////////////////////////
	SptingMVC,��json�����ݽ�����֧��		'�ص�'
	Json,��һ�����ݸ�ʽ,�ı����ݽ�����ʽ!�ڽӿڵ���,ǰ̨ҳ��Ƚϳ���,
	Json,�ⶫ����.��������!
	����:WebService
	
	����Json����ķ���
	���ͻ��˰�Json�����ݵ���������ʱ��,SptingMVC�ٽ��в����󶨵�ʱ��,��ʹ�� @RequestBody ��Json��������ΪJAVA����!���ݸ��β�!
	�߼��������֮��,�ٰ�java����,ͨ�� @ResponseBody ����Ϊjson����.��Ӧ���ͻ���!

	@RequestBody	--> ��jsonת��Ϊjava����(POJO,List)
	@ResponseBody	-->	��java����ת��Ϊjson

	* ���ͻ�������Ĳ���json,�ǾͲ���Ҫʹ�� @RequestBody ע�������н���
	* ����,�����Ҫ���ͻ�����Ӧjson,��ô�Ϳ���ʹ�õ� @ResponseBody ������ת��

	�ܽ�:
		1,����json,��Ӧjson
			* ���������json,�ⶫ����Ҫ��ʹ��js�������ݽ���,���ڿͻ��ĵ�Ҫ��ͻ�Ƚϸ���
			* ������Щɥ�Ĳ���Ŀ��,�ͷ�Ҫǰ����Ӧjson.����:... ...
		2,����key-value,��Ӧjson
			* ʹ�ñȽ϶�

/////////////////////////////////
����׼��
	1,SpringMVC,��Ҫ�����������һ��json������:
		jackson-core-asl-x.x.x.jar
		jackson-mapper-asl-x.x.x.jar
		* @RequestBody �� @ResponseBody ����ʹ��������������jsonת��
	
	2,��ע������������:messageConverters
		<!-- ע��:������������ -->
		<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
			<property name="messageConverters">
				<list>
					<!-- jsonת���� -->
					<bean class="org.springframework.http.converter.json.MappingJacksonHttpMessageConverter"/>
				</list>
			</property>
		</bean>
		* �����ʹ��<mvc:annotation-driven/>,��ô.�Ͳ��ö���,'�Ѿ�Ĭ�ϼ���'.
	
////////////////////////
	1,�������json��,��Ӧ��Ҳ��json
		* �ͻ�������ͷ:contentType:application/json;charset=utf-8
		* ��������Ӧͷ:contentType:application/json;charset=utf-8
		
		�ڴ������������β��ϱ�ʶע��:@RequestBody  ���ܰ������json������Ϊ��ʶ�Ķ���
		public @ResponseBody User jsonDemo(@RequestBody User user)
		{
			return user;
		}

	2,�������key-value,��Ӧ����json
		* �ͻ�������ͷ:contentType:application/x-www-form-urlencoded
		* ��������Ӧͷ:contentType:application/json;charset=utf-8
		public @ResponseBody User jsonDemo(User user)
		{
			return user;
		}

	
	* @ResponseBody Ҳ���Ա�ע��Handler������!Ҳ�ǿ��Ե�,Handler�ķ���ֵҲ������ Collection<T>


/////////////////////////////////////////////////////
	MessageConverter

	# ֻҪ��Controller�б���� @ResponseBody �ķ���,�����Ƿ���ֵ�� ResponseEntity<T> �ķ���.����ʹ��MessageConverter���������
	# ��������ע��������,Ĭ��װ����7�� MessageConverter ,ע��˳��
		org.springframework.http.converter.ByteArrayHttpMessageConverter
			# �ֽ�����

		org.springframework.http.converter.StringHttpMessageConverter
			# �ַ���ת��,Ĭ�ϱ���Ϊ:IOS-88-59-1
			# ���������,��֪�����˶�����

		org.springframework.http.converter.ResourceHttpMessageConverter
			
		org.springframework.http.converter.xml.SourceHttpMessageConverter

		org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter

		org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter

		org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
			# json ת��
			# ֻ����֧�ֶ������,Ҳ����json.

	# ��������Ӧ,û��ָ����������(MediaType),spring�����������˵������,'�������²���.˭֧��.�����˭,��������������'
		

	# �Զ���Converter
		<!--  ע������  -->
		<mvc:annotation-driven>
			<mvc:message-converters>
				<!-- �������ӦΪ:text�ı�ʱ,Ĭ��ʹ��:IOS-8859-1 ������ -->
				<bean class="org.springframework.http.converter.StringHttpMessageConverter">
					<!-- ͨ�����췽��,ָ������ -->
					<constructor-arg index="0" value="UTF-8"/>
				</bean>
			</mvc:message-converters>
		</mvc:annotation-driven>
		
		* �Զ�����,MessageConverter��,�Ƿ���ע��Ĭ�ϵ�MessageConverter,�� mvc:message-converters ��ǩ�� register-defaults="boolean" ����ָ��

		* register-defaults="true"(Ĭ��ֵ)	--> ����ע��Ĭ�ϵ�Converter(����Ĭ�ϵ�,���а˸���.����'�Զ����Ҫ�ŵ�ǰ��')

		* register-defaults="false"			--> ����ע��Ĭ�ϵ�Converter


	
//////////////////////////////////////////////////////
	JSONP--��˵�еĿ���, SpringMVC�Ľ������
	1,�̳�:org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
		
	2,��д:
		import java.io.IOException;
		import javax.servlet.http.HttpServletRequest;
		import org.apache.commons.io.IOUtils;
		import org.springframework.http.HttpOutputMessage;
		import org.springframework.http.converter.HttpMessageNotWritableException;
		import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
		import org.springframework.util.StringUtils;
		import org.springframework.web.context.request.RequestContextHolder;
		import org.springframework.web.context.request.ServletRequestAttributes;
		import com.fasterxml.jackson.core.JsonEncoding;
		import com.fasterxml.jackson.core.JsonProcessingException;


		// ��jsonp��֧�ֵı�ʶ������������мӸò���
		private String callbackName;
		/**
		 * ��дִ�з��� 
		 * */
		protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
			// ��threadLocal�л�ȡ��ǰ��Request����
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			// ��ȡҳ�洫�ݵ�callbackName,Ҳ���ǿ�Խ������jsonp�Ļص�������
			String callbackParam = request.getParameter(callbackName);
			if(StringUtils.isEmpty(callbackParam)){
				// û���ҵ�callback������ֱ�ӷ���json����
				super.writeInternal(object, outputMessage);
			}else{
				//����callback����,Ҳ���ǿ�������.��ôʹ�ûص���������JSON����
				JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
				try {
					String result = callbackParam+"("+super.getObjectMapper().writeValueAsString(object)+");";
					IOUtils.write(result, outputMessage.getBody(),encoding.getJavaName());
				}
				catch (JsonProcessingException ex) {
					throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
				}
			}
		}
		public String getCallbackName() {
			return callbackName;
		}

		public void setCallbackName(String callbackName) {
			this.callbackName = callbackName;
		}
		
	3,ע�ᵽSpringIOC��
		<mvc:annotation-driven>
			<mvc:message-converters>
				<!-- �������ӦΪ:text�ı�ʱ,Ĭ��ʹ��:IOS-8859-1 ������ -->
				<bean class="org.springframework.http.converter.StringHttpMessageConverter">
					<!-- ͨ�����췽��,ָ������ -->
					<constructor-arg index="0" value="UTF-8"/>
				</bean>
				<!-- 
						�Զ���json����,���Դ���jsonp.���������.
						callbackName:����ǰ�˴��ݹ�����'�ص�����������'��request���е�keyֵ.�����������
				 -->
				<bean class="MappingJackson2HttpMessageConverter����·��">
					<property name="callbackName" value="callback"/>
				</bean>
			</mvc:message-converters>
		</mvc:annotation-driven>




/////////////////////////////////////////////////////
JSON

	1,Json��ʲô?
		����js�ṩ��һ�����ݽ�����ʽ,��ͬ����֮������ݽ���.
	2,Ӧ�ó���
		WebService,Ajax�첽����... ...

	
һ,JSON�����﷨

	* ����������/ֵ����
	* ������","���ŷָ�,������'˫����������',�����Ų���
	* �����ű������
	* �����ű�������
		var person = {"name":"kevin","age":"18","gender":"��"};
		alert(person.name+","+person.age+","+person.gender);
	* Json��ֵ
		* ����		����/������
		* �ַ���	��˫������
		* �߼�ֵ	true/false
		* ����		�ڷ�������
		* null
		var p = {"name":"kevin","age":18,"marry":false,"hobby":["LOL","CSOL","CSOL2"]};
		var p = {"name":"kevin","age":18,"marry":false,"hobby":[{"name":"LOL"},{"name":"CSOL"},{"name":"CSOL2"}]};
	

��,Appache��С����--json-lib
	* ������߿��԰�javaBeanת��Ϊjson��!
	* ������jar����
		commons-lang.jar
		commons-beanUtils.jar
		commons-collections.jar
		ezmorph.jar
	
	* ���Ķ���
		JSONObject		--> Map
			put(Object,Object);		//��ʵ�ͼ�ֵ��,���toString()��ת��ΪJson��
			fromObject(Object);		//���صľ���һ�� JSONObject����,����toString();�ͻ���β�javaBeanת��Ϊһ��json�ַ���
			toString();				//���صľ���һ��json��

		JSONArray		--> List
			add(Object);			//���һ������,�����toString();�ͻ��������������еĶ��󶼱��һ��json�ַ���
			fromObject(Object);		//���صĻ���JSONArray,����һ��List����,ֱ�Ӱ�List���������Ԫ�ض�ת����json!
			toString();				//������
			
===========================================================================================================
package com.kevin.json;
import java.util.ArrayList;
import java.util.List;
import com.kevin.domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * Appache-Jsonת��������ʾ
 * */
public class Json
{
	/**
	 * ������,���ķ���:
	 * JSONObject		--> Map
	 * 		> toString();
	 *		> fromObject(Object);
	 * JSONArray		--> List
	 * 		> toString();
	 *		> fromObject(Object);
	 * */
	public static void main(String[] args)
	{
		demo1();
		demo2();
		demo3();
		demo4();
	}
	/**
	 * ����Map��ʹ��
	 * */
	public static void demo1()
	{
		JSONObject map = new JSONObject();
		map.put("name","kevin");
		map.put("age",18);
		map.put("marry",false);
		System.out.println(map.toString());
		//{"name":"kevin","age":18,"marry":false}
	}
	/**
	 * ��javaBeanת��ΪJson
	 * */
	public static void demo2()
	{
		User user = new User("F8575532","Kevin",22,false);
		JSONObject map = JSONObject.fromObject(user);
		System.out.println(map.toString());
		//{"age":22,"id":"F8575532","marry":false,"name":"Kevin"}
	}
	/**
	 * ����List��ʹ��
	 * */
	public static void demo3()
	{
		User a = new User("F8575532","Kevin",22,false);
		User b = new User("F8575852","Litch",24,true);
		JSONArray list = new JSONArray();
		list.add(a);
		list.add(b);
		System.out.println(list.toString());
		//[{"age":22,"id":"F8575532","marry":false,"name":"Kevin"},{"age":24,"id":"F8575852","marry":true,"name":"Litch"}]
	}
	/**
	 * ʹ���Զ���List
	 * */
	public static void demo4()
	{
		User a = new User("F8575532","Kevin",22,false);
		User b = new User("F8575852","Litch",24,true);
		List<User> arr = new ArrayList<User>();
		arr.add(a);
		arr.add(b);
		JSONArray list = JSONArray.fromObject(arr);
		System.out.println(list);
		//[{"age":22,"id":"F8575532","marry":false,"name":"Kevin"},{"age":24,"id":"F8575852","marry":true,"name":"Litch"}]
	}
}


	

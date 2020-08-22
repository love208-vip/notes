-----------------------------
Spring boot ʹ�� fastjson	 |
-----------------------------
	# spring Ĭ�ϵ�json�������� jackson
	# fastjson �ǰ���Ͱ͵�һ��������json���л����
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>fastjson</artifactId>
			<version>1.2.24</version>
		</dependency>
	
-----------------------------
Spring boot ����һ			 |
-----------------------------
	1,������̳� WebMvcConfigurerAdapter
	2,���Ƿ��� configureMessageConverters

	# ����
		@SpringBootApplication
		public class Application extends WebMvcConfigurerAdapter {
			public static void main(String[] args){
				SpringApplication.run(Application.class,args);
			}
			
			@Override
			public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
				super.configureMessageConverters(converters);
				//���� Converter ��Ϣת����
				FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
				fastJsonHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
				//���� ��Ϣת�������ö���
				FastJsonConfig fastJsonConfig = new FastJsonConfig();
				//�������ò���
				fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
				//���� converter ��Ϣת����
				fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
				//��converter ��ӵ� converters ��
				converters.add(fastJsonHttpMessageConverter);
			}
		}


-----------------------------
Spring boot ������			 |
-----------------------------
	# ���������ʽ�� fastjson ����Ϣת����.����IOC
	# ����
		/**
		 * Created by KevinBlandy on 2017/2/25 16:47
		 */
		@Configuration
		public class HttpMessageConverterConfiguration {
			/**
			 * FastJsonpHttpMessageConverter4
			 * @return
			 */
			@Bean
			public HttpMessageConverters httpMessageConverter(){
				FastJsonpHttpMessageConverter4 fastJsonpHttpMessageConverter4 = new FastJsonpHttpMessageConverter4();
				fastJsonpHttpMessageConverter4.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
				FastJsonConfig fastJsonConfig = new FastJsonConfig();
				fastJsonConfig.setCharset(StandardCharsets.UTF_8);
				fastJsonConfig.setSerializerFeatures(
						SerializerFeature.PrettyFormat,				//��ʽ��
						SerializerFeature.WriteMapNullValue,		//���null�ֶ�
						SerializerFeature.QuoteFieldNames,			//ʹ��˫����
						SerializerFeature.WriteNullListAsEmpty);	//��null����/�������Ϊ[]
				fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
				fastJsonpHttpMessageConverter4.setFastJsonConfig(fastJsonConfig);
				return new HttpMessageConverters(fastJsonpHttpMessageConverter4);
			}
			
			/**
			 * ����֧��
			 * @return
			 */
			@Bean
			public FastJsonpResponseBodyAdvice fastJsonpResponseBodyAdvice(){
				FastJsonpResponseBodyAdvice fastJsonpResponseBodyAdvice = new FastJsonpResponseBodyAdvice("callback","jsonp");
				return fastJsonpResponseBodyAdvice;
			}
		}
		* �����߼���ʵ��������


		
	

--------------------
FastJson-����springmvc|
--------------------
	# ��ͨת����
		FastJsonHttpMessageConverter
		FastJsonHttpMessageConverter4

	# ֧��JSONP��ת����
		FastJsonpHttpMessageConverter4
		* ��Ҫ����  FastJsonpResponseBodyAdvice ��ָ��JSONP���������


	  <mvc:annotation-driven>
        <mvc:message-converters register-defaults="true">
            <bean class="com.alibaba.fastjson.support.spring.FastJsonpHttpMessageConverter4">
                <property name="supportedMediaTypes">
                    <list>
                        <value>application/json</value>
                    </list>
                </property>
                <property name="fastJsonConfig">
                    <bean class="com.alibaba.fastjson.support.config.FastJsonConfig">
                        <property name="charset" value="UTF-8"/>
                        <property name="serializerFeatures">
                            <array>
                                <!-- ���null�ֶ� -->
                                <value>WriteMapNullValue</value>
                                <!-- ���keyʹ��˫���� -->
                                <value>QuoteFieldNames</value>
                                <!-- �ռ������[] -->
                                <value>WriteNullListAsEmpty</value>
                            </array>
                        </property>
                        <!-- ���ڸ�ʽ -->
                        <property name="dateFormat" value="yyyy-MM-dd HH:mm:ss"/>
                    </bean>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
	
	<!--  jsonp ���� ֧��-->
    <bean class="com.alibaba.fastjson.support.spring.FastJsonpResponseBodyAdvice">
        <constructor-arg>
            <list>
                <value>callback</value>
                <value>jsonp</value>
            </list>
        </constructor-arg>
    </bean>
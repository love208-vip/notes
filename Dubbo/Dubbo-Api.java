-----------------------
Dubbo-����API			|
-----------------------
	com.alibaba.dubbo.config.ServiceConfig
	com.alibaba.dubbo.config.ReferenceConfig
	com.alibaba.dubbo.config.ProtocolConfig
	com.alibaba.dubbo.config.RegistryConfig
	com.alibaba.dubbo.config.MonitorConfig
	com.alibaba.dubbo.config.ApplicationConfig
	com.alibaba.dubbo.config.ModuleConfig
	com.alibaba.dubbo.config.ProviderConfig
	com.alibaba.dubbo.config.ConsumerConfig
	com.alibaba.dubbo.config.MethodConfig
	com.alibaba.dubbo.config.ArgumentConfig

-----------------------
Dubbo-ע��API			|
-----------------------
	com.alibaba.dubbo.config.annotation.Service
		* �����ṩ��ע��
		* xml����
			<!-- ɨ��ע���·����������ö��ŷָ�������pacakge��ʾɨ�赱ǰApplicationContext�����е��� -->
			<dubbo:annotation package="com.foo.bar.service" />
		* ����
			import com.alibaba.dubbo.config.annotation.Service;
			 
			@Service(version="1.0.0")
			public class FooServiceImpl implements FooService {
			 
			}
	com.alibaba.dubbo.config.annotation.Reference
		* ���ѷ�ע��
		* xml����
			<!-- ɨ��ע���·����������ö��ŷָ�������pacakge��ʾɨ�赱ǰApplicationContext�����е��� -->
			<dubbo:annotation package="com.foo.bar.action" />
		* ����
			import com.alibaba.dubbo.config.annotation.Reference;
			import org.springframework.stereotype.Component;
			@Component
			public class BarAction {
				@Reference(version="1.0.0")
				private FooService fooService;
			 
			}
	
	# ��spring���ط���/���÷���
	
		<dubbo:annotation />
		<context:component-scan base-package="com.foo.bar.service">
			<context:include-filter type="annotation" expression="com.alibaba.dubbo.config.annotation.Service" />
		</context:component-scan>
		
		* �ȼ���:<dubbo:annotation package="com.foo.bar.service" />
	



-----------------------
Dubbo-ģ��API			|
-----------------------
	com.alibaba.dubbo.common.URL
	com.alibaba.dubbo.rpc.RpcException

-----------------------
Dubbo-������API			|
-----------------------
	com.alibaba.dubbo.rpc.RpcContext

-----------------------
Dubbo-����API			|
-----------------------
	com.alibaba.dubbo.rpc.service.GenericService
	com.alibaba.dubbo.rpc.service.GenericException
		�μ����������� & ����ʵ��
	com.alibaba.dubbo.rpc.service.EchoService
		�μ�����������

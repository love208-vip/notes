import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;



��myabtis�����ļ���������²������
	<plugins>
		<plugin interceptor="com.github.miemiedev.mybatis.paginator.OffsetLimitInterceptor">
		<property name="dialectClass" value="com.github.miemiedev.mybatis.paginator.dialect.MySQLDialect"/>
		</plugin>
	</plugins>
	* ָ�����ݿⷽ��




	setContainsTotalCount �����������Ҫ.����Ϊtrue,�ſ����з�ҳ��Ϣ



package com.kevin.blog.comm.utils;
import java.util.ArrayList;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
/**
 * ��ҳ����
 * */
public class PageUtils {
	/**
	 * ��ȡһ��PageBounds
	 * */
	public static PageBounds getPageBounds(Integer pageCode,Integer limit,String... cloum){
		PageBounds page = new PageBounds();
		if(pageCode == null || pageCode < 1){
			pageCode = 1;
		}
		//��ǰҳ
		page.setPage(pageCode);
		//ÿҳ��ʾ����
		page.setLimit(limit);
		if(cloum != null && cloum.length > 0){
			List<Order> orders = new ArrayList<Order>();
			//����һ��,���߶�������ֶ�
			for(String str : cloum){
				Order order = new Order(str,Direction.DESC,null);
				orders.add(order);
			}
			page.setOrders(orders);
		}
		//��Ҫ��ѯ�ü�¼��
		page.setContainsTotalCount(true);
		//��ֹ�첽��ѯ��ҳ����
		page.setAsyncTotalCount(false);
		return page;
	}
}




��Ȼ��Ҫע����ǣ�ֻҪ���õ����첽��ѯ(page.setContainsTotalCount(true))����������ʹ�����̳߳أ�������ʹ��ʱ��Ҫ����������������Ա���ֹͣ����ʱ�ر��̳߳ء���Ҫ��web.xml�м���

<listener>  
    <listener-class>com.github.miemiedev.mybatis.paginator.CleanupMybatisPaginatorListener</listener-class>  
</listener>  


����maven�ֿ������ַ:
	<dependency>
		<groupId>com.github.miemiedev</groupId>
		<artifactId>mybatis-paginator</artifactId>
		<version>${mybatis-paginator.version}</version>
	</dependency>
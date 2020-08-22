import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.ReflectionUtils;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by KevinBlandy on 2017/4/1 14:09
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);

    // ��ѯ����,��ʼΪ-1,AtomicInteger���̰߳�ȫ��
    private AtomicInteger counter = new AtomicInteger(-1);

    // ��¼�����key(������ioc��)
    private List<Object> slaveDataSources = new ArrayList<>(0);

    /**
     * �÷����ķ���ֵ,����Ϊһ��Map<String,DataSource>�е�key,ȥ��ȡ��Ӧ������Դ.
     * ����,ÿ������.ֻҪ�ı����key,�Ϳ��Ըı䵱�˴�����,�ڳ־ò�Ự��ע�������Դ,ʵ���Զ��Ķ�д����
     */
    @Override
    protected Object determineCurrentLookupKey() {
        Object key = null;
        if (DynamicDataSourceHolder.isMaster() || this.slaveDataSources.isEmpty()) {
            /**
             * AOP��ʶ����,����û���κδӿ�
             */
            key = DynamicDataSourceHolder.MASTER;
        }else {
            /**
             * ��ѯ�㷨��ȡ�ӿ�
             */
            key = this.getSlaveKey();
        }
        LOGGER.info("[��̬����Դ] dataSourceKey = {}",key);
        return key;

    }
    /**
     * ����ʵ����InitializingBean,Spring����Bean��ʼ����ɺ�ص� afterPropertlesSet����
     * ͨ���÷���,��ȡ�����еĶ���key,�洢������
     */
    @SuppressWarnings("unchecked")
    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        // ���ڸ����resolvedDataSources������˽�е������ȡ��������Ҫʹ�÷����ȡ
        Field field = ReflectionUtils.findField(AbstractRoutingDataSource.class, "resolvedDataSources");
        field.setAccessible(true); // ��������
        try {
            //���ݵ�ǰ����,�����ȡ���ֶ�ֵ,���е�����Դ
            Map<Object, DataSource> resolvedDataSources = (Map<Object, DataSource>) field.get(this);
            for (Map.Entry<Object, DataSource> entry : resolvedDataSources.entrySet()) {
                //�������е�key
                if (DynamicDataSourceHolder.MASTER.equals(entry.getKey())) {
                    //�����д��,����֮
                    continue;
                }
                //���д���key������
                slaveDataSources.add(entry.getKey());
            }
        } catch (Exception e) {
            LOGGER.error("afterPropertiesSet error! ", e);
        }
    }

    /**
     * ��ѯ�㷨
     * @return
     */
    public Object getSlaveKey() {
        // ͬ������ 1 ��ȡģ����,�õ����±�Ϊ��0��1��2��3����
        Integer index = counter.incrementAndGet() % this.slaveDataSources.size();
        if (counter.get() > 9999) { 	// ���ⳬ��Integer��Χ
            counter.set(-1);		 	// ��ԭ
        }
        return slaveDataSources.get(index);
    }
}

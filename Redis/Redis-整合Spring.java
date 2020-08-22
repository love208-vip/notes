---------------------------
Redis-����spring			|
---------------------------

<!-- �����ⲿ�ļ� -->
<context:property-placeholder location="classpath:redis.properties" ignore-unresolvable="true"/>
<!-- ���ӳ����� -->
<bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig">
	<!-- ��������� -->
	<property name="maxTotal" value="${redis.maxTotal}"/>

	<property name="testWhileIdle" value="${redis.testWhileIdle}"/>
	<property name="minEvictableIdleTimeMillis" value="${redis.minEvictableIdleTimeMillis}"/>
	<property name="numTestsPerEvictionRun" value="${redis.numTestsPerEvictionRun}"/>
	<property name="maxIdle" value="${redis.maxIdle}"/>
	<property name="minIdle" value="${redis.minIdle}"/>
</bean>
<!-- ��Ƭʽ���ӳ� -->
<bean class="redis.clients.jedis.ShardedJedisPool" destroy-method="close">
	<constructor-arg index="0" ref="jedisPoolConfig"/>
	<constructor-arg index="1">
		<list>
			<!-- ��Ⱥ�Ľڵ�1��Ϣ -->
			<bean class="redis.clients.jedis.JedisShardInfo">
				<constructor-arg index="0" value="${redis.node1.ip}"/>
				<constructor-arg index="1" value="${redis.node1.port}"/>
			</bean>
			<!-- ��Ⱥ�Ľڵ�2��Ϣ 
			<bean class="redis.clients.jedis.JedisShardInfo">
				<constructor-arg index="0" value="${redis.node2.ip}"/>
				<constructor-arg index="1" value="${redis.node2.port}"/>
			</bean>-->
		</list>
	</constructor-arg>
</bean>


redis.maxTotal=100
redis.node1.ip=127.0.0.1
redis.node1.port=6379

---------------------------
Redis-�������˼��			|
---------------------------

**
 * Redis Service
 * */
@Service
public class RedisService {
	@Autowired
	private ShardedJedisPool shardedJedisPool;
	/**
	 * ����������Ӽ�¼
	 * */
	private <T> T execut(Function<ShardedJedis ,T> fun){
		 ShardedJedis shardedJedis = null;
	        try{
	        	// ��ȡRedis����
	        	shardedJedis = shardedJedisPool.getResource();
	        	return fun.callback(shardedJedis);
	        }finally{
	        	 //�ر�����
	            shardedJedis.close();
	        }
	}
	/**
	 * ����ֵ
	 * */
	public String set(final String key,final String value){
		return this.execut(new Function<ShardedJedis, String>() {
			public String callback(ShardedJedis jedis) {
				return jedis.set(key, value);
			}
		});
	}
	/**
	 * ����ֵ,ͬʱ��������ʱ��
	 * ��λΪ��
	 * */
	public String set(final String key,final String value,final Integer seconds){
		return this.execut(new Function<ShardedJedis, String>() {
			public String callback(ShardedJedis jedis) {
				String result = jedis.set(key, value);
				jedis.expire(key, seconds);
				return result;
			}
		});
	}
	/**
	 * ��ȡֵ
	 * */
	public String get(String key){
		return this.execut(new Function<ShardedJedis, String>() {
			public String callback(ShardedJedis jedis) {
				return jedis.get(key);
			}
		});
	}
	/**
	 * ����Keyɾ������
	 * */
	public Long delete(String key){
		return this.execut(new Function<ShardedJedis, Long>() {
			public Long callback(ShardedJedis jedis) {
				return jedis.del(key);
			}
		});
	}
	/**
	 * ����Keyɾ������
	 * */
	public Long expire(String key,Integer seconnds){
		return this.execut(new Function<ShardedJedis, Long>() {
			public Long callback(ShardedJedis jedis) {
				return jedis.expire(key, seconnds);
			}
		});
	}
}
interface Function <T,E>{
	public E callback(T t);
}

=================================================JK8  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.function.Function;

/**
 * Created by KevinBlandy on 2017/1/22 17:31
 * Redis
 */
@Service
public class RedisService {
    @Autowired
    private ShardedJedisPool shardedJedisPool;

    /**
     * �ص�ִ��
     * @param fun
     * @param <T>
     * @return
     */
    private <T> T execute(Function<ShardedJedis,T> fun){
        ShardedJedis shardedJedis = null;
        try{
            // ��ȡRedis����
            shardedJedis = shardedJedisPool.getResource();
            return fun.apply(shardedJedis);
        }finally{
            //�ر�����
            shardedJedis.close();
        }
    }

    /**
     * ����µ�ֵ��redis
     * @param key
     * @param value
     * @return
     */
    public String set(final String key,final String value){
        return this.execute(shardedJedis -> shardedJedis.set(key,value));
    }

    /**
     * ����µ�ֵ������,����������������
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public String set( String key, String value, Integer seconds){
        return this.execute(shardedJedis -> {
            String result = shardedJedis.set(key,value);
            shardedJedis.expire(key,seconds);
            return result;
        });
    }

    /**
     * ����key���Զ�ȡһ��ֵ
     * @param key
     * @return
     */
    public String get(String key){
        return this.execute(shardedJedis -> shardedJedis.get(key));
    }

    /**
     * ����key����ɾ��һ��ֵ
     * @param key
     * @return
     */
    public Long delete(String key){
        return this.execute(shardedJedisPool -> shardedJedisPool.del(key));
    }

    /**
     * ����key,����ֵ����������
     * @param key
     * @param seconnds
     * @return
     */
    public Long expire(String key,Integer seconnds){
        return this.execute(shardedJedis -> shardedJedis.expire(key,seconnds));
    }
}

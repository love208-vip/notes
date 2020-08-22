import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
/**
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

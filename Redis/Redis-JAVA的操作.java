-----------------------
Redis-JAVAAPI�Ĳ���		|
-----------------------
	* jedis-2.8.1.jar
	
	<dependency>
		<groupId>redis.clients</groupId>
		<artifactId>jedis</artifactId>
		<version>2.9.0</version>
	</dependency>

һ,���Ӳ���
	//����ip�Ͷ˿ڴ������Ӷ���
	Jedis jedis = new Jedis("localhost",6379);
	/*
		������֤,���������redis����
		jedis.auth('password');
	*/
��,�򵥵Ĵ洢��ȡ
	jedis.set("key","value");
	System.out.println(jedis.get("key"));
	jedis.close();

��,����key�ĳ�ʱʱ��
	jedis.expire(key, seconds);��

��,���ӳ�

    public static void main(String[] args) {
        // �������ӳ�������Ϣ
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // �������������
        jedisPoolConfig.setMaxTotal(50);
        // �������ӳ�
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        // �����ӳ��л�ȡ����
        Jedis jedis = jedisPool.getResource();
        // ��ȡ����
        System.out.println(jedis.get("mytest"));
        // �����ӻ��ص����ӳ���
        jedisPool.returnResource(jedis);
        // �ͷ����ӳ�
        jedisPool.close();
    }

��,��Ƭʽ���ӳ�
	 public static void main(String[] args) {
        // �������ӳ�������Ϣ
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // �������������
        poolConfig.setMaxTotal(50);
        // ���弯Ⱥ��Ϣ
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();

		//���һ����Ⱥ�Ľڵ�
        shards.add(new JedisShardInfo("127.0.0.1", 6379));

        // ���弯Ⱥ���ӳ�
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(poolConfig, shards);

        ShardedJedis shardedJedis = null;
        try {
            // �����ӳ��л�ȡ��jedis��Ƭ����
            shardedJedis = shardedJedisPool.getResource();

            // ��redis�л�ȡ����
            String value = shardedJedis.get("mytest");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != shardedJedis) {
                // �رգ���������Ƿ���Ч����Ч��Żص����ӳ��У���Ч������״̬
                shardedJedis.close();
            }
        }
        // �ر����ӳ�
        shardedJedisPool.close();

    }
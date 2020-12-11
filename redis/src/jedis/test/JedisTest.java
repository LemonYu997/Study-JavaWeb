package jedis.test;

import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Jedis的测试类
 * */
public class JedisTest {
    /**
     * 快速入门
     * */
    @Test
    public void test1(){
        //1、获取链接
        Jedis jedis = new Jedis("localhost", 6379);
        //2、操作
        jedis.set("username", "zhangsan");
        //3、关闭连接
        jedis.close();
    }

    /**
     * string数据结构操作
     * */
    @Test
    public void test2(){
        //1、获取链接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值"localhost", 6379端口
        //2、操作
        //存储
        jedis.set("username", "zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);
        //可使用setex()方法存储可以指定过期时间的key value
        jedis.setex("activecode", 20, "hehe");  //将activecode:hehe键值对存入redis，并且20秒后自动删除
        //3、关闭连接
        jedis.close();
    }

    /**
     * hash数据结构操作
     * */
    @Test
    public void test3(){
        //1、获取链接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值"localhost", 6379端口
        //2、操作
        //存储
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "male");
        //获取
        String name = jedis.hget("user", "name");
        System.out.println(name);
        //获取hash的所有map数据
        Map<String, String> user = jedis.hgetAll("user");
        //keyset遍历集合
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            //获取value
            String value = user.get(key);
            System.out.println(key + ":" + value);  //gender:male name:lisi age:23
        }
        //3、关闭连接
        jedis.close();
    }

    /**
     * list数据结构操作
     * */
    @Test
    public void test4(){
        //1、获取链接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值"localhost", 6379端口
        //2、操作
        //存储
        jedis.lpush("mylist", "a", "b", "c");   //从左边存
        jedis.rpush("mylist", "a", "b", "c");   //从右边存
        //获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist); //[c, b, a, a, b, c]
        //弹出
        String element1 = jedis.lpop("mylist");
        System.out.println(element1);   //c
        String element2 = jedis.rpop("mylist");
        System.out.println(element2);   //c
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2); //[b, a, a, b]
        //3、关闭连接
        jedis.close();
    }

    /**
     * set数据结构操作
     * */
    @Test
    public void test5(){
        //1、获取链接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值"localhost", 6379端口
        //2、操作
        //存储
        jedis.sadd("myset", "java", "php", "c++");
        //获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);      //[c++, java, php]
        //3、关闭连接
        jedis.close();
    }

    /**
     * sortedset数据结构操作
     * */
    @Test
    public void test6(){
        //1、获取链接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值"localhost", 6379端口
        //2、操作
        //存储
        jedis.zadd("mysortedset", 3, "Arthur");
        jedis.zadd("mysortedset", 100, "Elden");
        jedis.zadd("mysortedset", 55, "George");
        //获取
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);        //自动排序 [Arthur, George, Elden]
        //3、关闭连接
        jedis.close();
    }

    /**
     * Jedis连接池的使用
     * */
    @Test
    public void test7(){
        //0、创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //1、创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        //2、获取链接
        Jedis jedis = jedisPool.getResource();
        //3、使用
        jedis.set("hehe", "haha");
        String hehe = jedis.get("hehe");
        System.out.println(hehe);   //haha
        //4、归还到连接池中
        jedis.close();
    }

    /**
     * Jedis连接池工具类的使用
     * */
    @Test
    public void test8(){
        //1、通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();
        //2、使用
        jedis.set("hello", "world");
        String hello = jedis.get("hello");
        System.out.println(hello);   //world
        //3、归还到连接池中
        jedis.close();
    }
}

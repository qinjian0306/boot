package com.qj.springboot.redis.cluster;

import com.qj.springboot.redis.single.RedisDataUtils;
import com.qj.springboot.redis.single.RedisObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * 封装redis
 */
public class JedisClusterCli {

    /**
     * JedisCluster
     */
    protected JedisCluster jedisCluster;

    /**
     * 设置JedisCluster
     */

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }


    /**
     * 新增不过期的数据
     */
    public boolean setNoExpire(String key, String value) {
        try {
        	String result = jedisCluster.set(key, value);
        	if (result.equals("OK")) {
        		return true;
        	}
            return false;
        } catch (Exception e) {
            return false;
		}
    }
    
    /**
     * 新增不过期的数据
     */
    public boolean setNoExpire(int db, String key, String value) {
        try {
            jedisCluster.select(db);
            String result = jedisCluster.set(key, value);
        	if (result.equals("OK")) {
        		return true;
        	}
            return false;
        } catch (Exception e) {
        	return false;
		}
    }
    
    /**
     * 设置带过期时间的数据
     */
    public boolean set(String key, String value, int expireSeconds) {
        try{
            String result = jedisCluster.setex(key, expireSeconds, value);
            if (result.equals("OK")) {
        		return true;
        	}
            return false;
        } catch (Exception e) {
        	return false;
		}
    }
    
    /**
     * 设置带过期时间的数据
     */
    public boolean set(int db, String key, String value, int expireSeconds) {
        try {
            jedisCluster.select(db);
            String result = jedisCluster.setex(key, expireSeconds, value);
            if (result.equals("OK")) {
        		return true;
        	}
            return false;
        } catch (Exception e) {
        	return false;
		}
    }
    
    
    /**
     * 新增不过期的数据(带数据压缩)
     */
    public boolean setNoExpireZip(String key, String value) {
    	//数据压缩
    	value = RedisDataUtils.serializationObject(value);
    	return setNoExpire(key, value);
    }
    
    /**
     * 新增不过期的数据(带数据压缩)
     */
    public boolean setNoExpireZip(int db, String key, String value) {
    	//数据压缩
    	value = RedisDataUtils.serializationObject(value);
    	return setNoExpire(db, key, value);
    }
    
    /**
     * 设置带过期时间的数据(带数据压缩)
     */
    public boolean setZip(String key, String value, int expireSeconds) {
    	//数据压缩
    	value = RedisDataUtils.serializationObject(value);
    	return set(key, value, expireSeconds);
    }
    
    /**
     * 设置带过期时间的数据(带数据压缩)
     */
    public boolean setZip(int db, String key, String value, int expireSeconds) {
    	//数据压缩
    	value = RedisDataUtils.serializationObject(value);
    	return set(db, key, value, expireSeconds);
    }

    /**
     * 读取
     */
    public String get(String key) {
        try {
            return jedisCluster.get(key);
        } catch (Exception e) {
        	return null;
		}
    }

    /**
     * 读取
     */
    public String get(int db, String key) {
        try{
            jedisCluster.select(db);
            return jedisCluster.get(key);
        } catch (Exception e) {
        	return null;
		}
    }

    /**
     * 拼接数据
     */
    public Long append(String key, String value) {
        try {
            return jedisCluster.append(key, value);
        } catch (Exception e) {
        	return null;
		}
    }

    /**
     * 拼接数据
     */
    public Long append(int db, String key, String value) {
        try{
            jedisCluster.select(db);
            return jedisCluster.append(key, value);
        } catch (Exception e) {
        	return null;
		}
    }
    
    /**
     * 读取(已解压为对象)
     */
    public RedisObject getZip(String key) {
        try {
        	String json = jedisCluster.get(key);
        	if(!StringUtils.isEmpty(json)){
        		return RedisDataUtils.deserializationObject(json, RedisObject.class);
        	}
            return null;
        } catch (Exception e) {
        	return null;
		}
    }

    /**
     * 读取(已解压为对象)
     */
    public RedisObject getZip(int db, String key) {
        try {
            jedisCluster.select(db);
        	String json = jedisCluster.get(key);
        	if(!StringUtils.isEmpty(json)){
        		return RedisDataUtils.deserializationObject(json, RedisObject.class);
        	}
            return null;
        } catch (Exception e) {
        	return null;
		}
    }

    
    /**
     * 删除
     */
    public Long delete(String... keys) {
        try{
            return jedisCluster.del(keys);
        } catch (Exception e) {
        	return 0L;
		}
    }
    
    /**
     * 删除
     */
    public Long delete(int db, String... keys) {
        try {
            jedisCluster.select(db);
            return jedisCluster.del(keys);
        } catch (Exception e) {
        	return 0L;
		}
    }
    
    /**
     * 设置到期时间
     */
    public Long expire(String key, int seconds) {
        try{
            return jedisCluster.expire(key, seconds);
        } catch (Exception e) {
        	return 0L;
		}
    }
    
    /**
     * 设置到期时间
     */
    public Long expire(int db, String key, int seconds) {
        try {
            jedisCluster.select(db);
            return jedisCluster.expire(key, seconds);
        } catch (Exception e) {
        	return 0L;
		}
    }
}

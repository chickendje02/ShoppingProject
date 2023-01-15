package com.excercise.productservice.cache;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ProductCache {

    private static final Map<String, CacheModel> cacheMap = new HashMap<>();

    /**
     * 1000L*60*60*24*30 equals to 1 month which has 30 days
     * To convert to timestamp just multiply it with 100
     */
    private static final long DEFAULT_EXPIRED_TIME = 600000L;

//    private static final long

    private ProductCache() {

    }

    public static <T> void putData(String key, T data, Long configTime) {
        Long timeExpired = Optional.ofNullable(configTime).orElse(DEFAULT_EXPIRED_TIME);
        CacheModel<T> cacheData = new CacheModel<>();
        cacheData.setData(data);
        cacheData.setExpiredTime(System.currentTimeMillis() + timeExpired);
        cacheMap.put(key, cacheData);
    }

    public static CacheModel getData(String key) {
        CacheModel data = cacheMap.get(key);
        if (Objects.isNull(data)) {
            return null;
        }
        if (System.currentTimeMillis() >= data.getExpiredTime()) {
            cacheMap.remove(key);
            return null;
        } else {
            return data;
        }
    }

    public static <T> void updateData(String key, T data) {
        CacheModel<T> cachesData = new CacheModel<>();
        cachesData.setData(data);
        cachesData.setExpiredTime(System.currentTimeMillis() + DEFAULT_EXPIRED_TIME);
        cacheMap.put(key, cachesData);
    }

    public static <T> void removeData(String key) {
        cacheMap.remove(key);
    }

    public static Map<String, CacheModel> getCacheMap() {
        return cacheMap;
    }


    public static void main(String[] args) {
        long yourmilliseconds = System.currentTimeMillis() - (1000L * 60 * 10);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(yourmilliseconds);
        System.out.println(sdf.format(resultdate));
    }


}

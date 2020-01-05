package com.windvalley.sell.utils;

import java.util.Random;

public class KeyUtil {
    /**
     *生成唯一主键
     *格式:时间+随机数
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer value = random.nextInt(90) + 10000;
        return System.currentTimeMillis() + String.valueOf(value);
    }
}

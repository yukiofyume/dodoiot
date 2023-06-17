package com.iot.dodo.springboot.starter.common.toolkit;

import com.iot.dodo.springboot.starter.common.enums.LocalTimeEnum;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author lwh
 * @date 2023-06-11 16:21:39
 */
public class LocalTimeUtils {

    public final static String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";

    /**
     * localDateTime 转 字符串
     *
     * @param localDateTime localDateTime
     * @param pattern       转换模式
     * @return 字符串时间
     */
    public static String localDateTime2Str(LocalDateTime localDateTime, String pattern) {
        var dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(localDateTime);
    }

    public static long nowUTF8Milli() {
        return LocalDateTime.now().toInstant(ZoneOffset.of(LocalTimeEnum.UTC8.getTimeZone())).toEpochMilli();
    }
}
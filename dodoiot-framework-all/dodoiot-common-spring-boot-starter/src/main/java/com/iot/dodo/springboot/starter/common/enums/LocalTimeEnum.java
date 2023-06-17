package com.iot.dodo.springboot.starter.common.enums;

/**
 * @author lwh
 * @date 2023-06-11 16:05:05
 */
public enum LocalTimeEnum {
    UTC8("+8"),
    ;
    private final String timeZone;

    LocalTimeEnum(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
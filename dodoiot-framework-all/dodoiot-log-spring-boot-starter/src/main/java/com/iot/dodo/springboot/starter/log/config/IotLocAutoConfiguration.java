package com.iot.dodo.springboot.starter.log.config;

import com.iot.dodo.springboot.starter.log.aspect.IotLogPrintAspect;
import org.springframework.context.annotation.Bean;

/**
 * @author lwh
 * @date 2023-06-11 17:13:39
 */
public class IotLocAutoConfiguration {

    @Bean
    public IotLogPrintAspect iotLogPrintAspect() {
        return new IotLogPrintAspect();
    }
}
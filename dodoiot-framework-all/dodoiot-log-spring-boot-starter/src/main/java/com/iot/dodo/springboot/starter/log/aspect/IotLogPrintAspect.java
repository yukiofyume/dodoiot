package com.iot.dodo.springboot.starter.log.aspect;

import com.iot.dodo.springboot.starter.common.toolkit.JacksonUtils;
import com.iot.dodo.springboot.starter.common.toolkit.LocalTimeUtils;
import com.iot.dodo.springboot.starter.log.annotation.IotLog;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * 日志打印切面
 *
 * @author lwh
 * @date 2023-06-11 15:40:27
 */
@Aspect
public class IotLogPrintAspect {

    /**
     * 打印注解处理
     */
    @Around(value = "@within(com.iot.dodo.springboot.starter.log.annotation.IotLog) || @annotation(com.iot.dodo.springboot.starter.log.annotation.IotLog)")
    public Object printIotLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = LocalTimeUtils.nowUTF8Milli();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Logger log = LoggerFactory.getLogger(methodSignature.getDeclaringType());
        Object result = null;
        try {
            result = joinPoint.proceed();
        } finally {
            Method targetMethod = joinPoint.getTarget().getClass().getDeclaredMethod(methodSignature.getName(), methodSignature.getMethod().getParameterTypes());
            IotLog logAnnotation = Optional.ofNullable(targetMethod.getAnnotation(IotLog.class)).orElse(joinPoint.getTarget().getClass().getAnnotation(IotLog.class));
            if (!Objects.isNull(logAnnotation)) {
                IotLogPrint logPrint = new IotLogPrint();
                logPrint.setBeginTime(LocalTimeUtils.localDateTime2Str(LocalDateTime.now(), LocalTimeUtils.PATTERN_STANDARD));
                if (logAnnotation.input()) {
                    logPrint.setInputParams(buildInput(joinPoint));
                }
                if (logAnnotation.output()) {
                    logPrint.setOutputParams(result);
                }
                String methodType = "", requestURI = "";
                try {
                    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                    if (servletRequestAttributes != null) {
                        HttpServletRequest request = servletRequestAttributes.getRequest();
                        methodType = request.getMethod();
                        requestURI = request.getRequestURI();
                    }
                } catch (Exception ignore) {
                }

                log.info("[{}] {}, executeTime: {}ms, info:{}", methodType, requestURI, LocalTimeUtils.nowUTF8Milli() - startTime, JacksonUtils.entity2Json(logPrint));
            }
        }
        return result;
    }

    private Object[] buildInput(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object[] printArgs = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if ((args[i] instanceof HttpServletRequest) || (args[i] instanceof HttpServletResponse)) {
                continue;
            }
            if (args[i] instanceof byte[]) {
                printArgs[i] = "byte array";
            } else if (args[i] instanceof MultipartFile) {
                printArgs[i] = "file";
            } else {
                printArgs[i] = args[i];
            }
        }
        return printArgs;
    }

    @Data
    private static class IotLogPrint implements Serializable {
        private final long serialVersionUID = -7186090357161805113L;
        private String beginTime;
        private Object[] inputParams;
        private Object outputParams;
    }
}
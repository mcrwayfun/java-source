package com.mcrwayfun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
@Aspect
public class LoggingAfterAspect {

    public final static Logger log = LoggerFactory.getLogger(LoggingAfterAspect.class);

    private static final String RET_CODE = "retCode";

    private static final String RET_MSG = "retMsg";

    private static final Integer SUCCESS_CODE = 200;

    @AfterReturning(value = "@annotation(com.mcrwayfun.aspect.Loggable)", returning = "result")
    public void log(JoinPoint joinPoint, Map<String, Object> result) {

        // 获取当前调用的className
        String className = joinPoint.getTarget().getClass().getName();
        // 获取当前调用的methodName
        String methodName = joinPoint.getSignature().getName();

        log.info("className={},methodName={},returnString={}", className, methodName, result);

        Object retCode = result.get(RET_CODE);
        Object retMsg = result.get(RET_MSG);
        StringBuilder res = new StringBuilder();
        if (retCode != null) {
            Integer code = (Integer) retCode;
            // 处理非200的请求，并输出到日志中
            if (!code.equals(SUCCESS_CODE)) {
                // 获取当前调用参数并拼装
                Object[] args = joinPoint.getArgs();
                if (args != null && args.length > 0) {
                    for (int i = 0; i < args.length; i++) {
                        if (i == args.length - 1)
                            res.append(args[i]);
                        else
                            res.append(args[i] + ",");
                    }
                }
            }
        }

        log.info("className={},methodName={},params={}", className, methodName, res.toString());
    }
}

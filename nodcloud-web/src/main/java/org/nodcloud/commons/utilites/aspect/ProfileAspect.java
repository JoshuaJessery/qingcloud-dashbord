package org.nodcloud.commons.utilites.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

@Aspect
public class ProfileAspect {
    private final Logger log = LoggerFactory.getLogger(ProfileAspect.class);

    @Around("org.nodcloud.commons.utilites.aspect.SystemArchitecture.businessService()")
    public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object retVal = joinPoint.proceed();
        stopWatch.stop();
        final long totalTimeMillis = stopWatch.getTotalTimeMillis();

        if (totalTimeMillis < 50) {
            return retVal;
        }

        StringBuffer message = new StringBuffer();
        message.append(joinPoint.getTarget().getClass().getSimpleName());
        message.append(".");
        message.append(joinPoint.getSignature().getName());
        message.append("(");
        // append args
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            message.append(arg).append(",");
        }
        if (args.length > 0) {
            message.deleteCharAt(message.length() - 1);
        }
        message.append(")");
        message.append(" execution time: ");
        message.append(totalTimeMillis);
        message.append(" ms");
        log.debug(message.toString());
        return retVal;
    }
}
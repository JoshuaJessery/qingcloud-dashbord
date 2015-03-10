package org.nodcloud.commons.utilites.aspect;


import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.nodcloud.commons.utilites.annotation.BusinessLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractLogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractLogAspect.class);

    protected Object next(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            throw e;
        }
    }

    protected Boolean retrieveBusinessLogAnnotation(ProceedingJoinPoint joinPoint) {
        try {
            Class targetClass = joinPoint.getTarget().getClass();
            Class[] argTypes = retrieveMethodArgs(joinPoint);
            final Method method = targetClass.getDeclaredMethod(joinPoint.getSignature().getName(), argTypes);
            if (method.isAnnotationPresent(BusinessLog.class)) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    private Class[] retrieveMethodArgs(ProceedingJoinPoint joinPoint) {
        Class[] argTypes = new Class[joinPoint.getArgs().length];
        for (int i = 0; i < argTypes.length; i++) {
            Class<?> aClass = joinPoint.getArgs()[i].getClass();
            if (aClass == Integer.class) {
                aClass = Integer.TYPE;
            }else if(aClass == Long.class) {
                aClass = Long.TYPE;
            }

            argTypes[i] = aClass;
        }

        return argTypes;
    }

}

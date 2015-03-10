package org.nodcloud.commons.utilites.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.nodcloud.commons.utilites.AuthUtils;
import org.nodcloud.persistent.entity.UserLog;
import org.nodcloud.persistent.repository.UserLogDao;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class InstanceOperationLogAspect extends AbstractLogAspect {


    @Autowired
    private UserLogDao userLogDao;

    @Around("org.nodcloud.commons.utilites.aspect.UserLogArchitecture.instanceLayer()")
    public Object instanceOperation(ProceedingJoinPoint joinPoint) throws Throwable {

        if (retrieveBusinessLogAnnotation(joinPoint)) {
            return logInstanceOperation(joinPoint);
        } else {
            return next(joinPoint);
        }

    }

    private Object logInstanceOperation(ProceedingJoinPoint joinPoint) throws Throwable {

        UserLog userLog = new UserLog();
        final Object proceed;
        try {
            userLog.setMessage(joinPoint.getSignature().getName());
            userLog.setUserId(AuthUtils.getCurrentUserId());
            proceed = joinPoint.proceed();
            userLog.setStatus("success");
        } catch (Exception e) {
            userLog.setStatus("error");
            throw e;
        } finally {
            userLogDao.save(userLog);
        }
        return proceed;

    }

}

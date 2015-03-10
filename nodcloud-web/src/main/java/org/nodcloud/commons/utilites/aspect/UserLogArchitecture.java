package org.nodcloud.commons.utilites.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UserLogArchitecture {

    @Pointcut("execution(* org.nodcloud.web.service.InstanceService.*(..))")
    public void instanceLayer() {}

    @Pointcut("execution(* org.nodcloud.web.service.VolumeService.*(..))")
    public void volumeLayer() {}

    @Pointcut("execution(* org.nodcloud.web.service.KeypairService.*(..))")
    public void keyPairLayer() {}

}

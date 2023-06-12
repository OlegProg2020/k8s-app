package olegprog.k8sapp.aop.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("olegprog.k8sapp.aop.logging.LoggingPointcuts.allGetMethods()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        String signature = joinPoint.getSignature().toShortString();
        log.info("call: {}", signature);
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("with args: {}", args);
    }

    @AfterReturning(pointcut = "olegprog.k8sapp.aop.logging.LoggingPointcuts.allGetMethods()",
        returning = "result")
    public void afterMethodExecution(Object result) {
        log.info("returned value: {}", result);
    }

}

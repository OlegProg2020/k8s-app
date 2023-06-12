package olegprog.k8sapp.aop.logging;

import org.aspectj.lang.annotation.Pointcut;

public class LoggingPointcuts {

    @Pointcut("execution(public * olegprog.k8sapp.web.AccountController.get*(..))")
    public void allGetMethods() {
    }

}

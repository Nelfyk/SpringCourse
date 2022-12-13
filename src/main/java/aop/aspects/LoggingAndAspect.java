package aop.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAndAspect {
    @Before("MyPointcuts.allGetMethods()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу.");
    }

    @AfterReturning(pointcut = "MyPointcuts.allGetMethods()")
    public void afterReturningGetLoggingAdvice() {
        System.out.println("afterReturningGetLoggingAdvice: логирование полученной книги.");
    }

//    @AfterThrowing(pointcut = "MyPointcuts.allGetMethods()")
//    public void afterExceptionGetLoggingAdvice() {
//        System.out.println("EXCEPTION!!!!");
//    }
    @After("MyPointcuts.allGetMethods()")
    public void afterGetLoggingAdvice(){
        System.out.println("afterGetLoggingAdvice: логируем окончание работы метода.");
    }
}

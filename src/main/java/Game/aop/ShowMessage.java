package Game.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/*@Component
@Aspect*/
public class ShowMessage {
    @Pointcut("execution(* * (..))")
    private void getAll(){}

    @Before("getAll()")
    public void showMessage () {
        System.out.println("Че-то произошло.");
    }
}

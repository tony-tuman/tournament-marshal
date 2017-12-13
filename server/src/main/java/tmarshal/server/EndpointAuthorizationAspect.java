package tmarshal.server;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EndpointAuthorizationAspect {
    @Before("execution(* tmarshal.server.controllers.*.*(..))")
    public void authorizeBefore() {
        System.out.println("Aspects are running!" + this);
    }
}

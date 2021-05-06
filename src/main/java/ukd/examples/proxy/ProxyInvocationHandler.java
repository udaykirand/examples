package ukd.examples.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationHandler implements InvocationHandler {

    private Object target;

    ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();

        Object result = method.invoke(target, args);


        long elapsed = System.nanoTime() - start;
        System.out.println(method.getName() + " - " + elapsed);
        return result;
    }
}


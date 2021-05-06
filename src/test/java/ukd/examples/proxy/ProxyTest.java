package ukd.examples.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProxyTest {

    @Test
    public void testProxyHandler() {
        Map proxyInstance = (Map) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[] { Map.class },
                new ProxyInvocationHandler(new HashMap<>()));

        proxyInstance.put("hello", "world");
        assertEquals("world", proxyInstance.get("hello"));
    }
}

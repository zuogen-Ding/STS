package club.banyuan.project.util;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    Object object=new Object();

    public CglibProxy(Object object) {
        this.object = object;
    }

    public Object getProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        Object o= enhancer.create();
        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        method.invoke(object,objects);
        return null;
    }
}

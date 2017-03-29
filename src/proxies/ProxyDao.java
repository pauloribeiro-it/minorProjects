package proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDao implements InvocationHandler {
	
	private Object originalImpl;
	
	private ProxyDao(Object originalImpl){
		this.originalImpl = originalImpl;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		switch(method.getName()){
			case "save":
				System.out.println("One row add.");
				break;
			case "delete":
				System.out.println("One row deleted");
				break;
			default:
				System.out.println("Method: "+method.getName()+" executed.");
		}
		return method.invoke(originalImpl, args);
	}
	
	public static Object createProxy(Object impl){
		return Proxy.newProxyInstance(impl.getClass().getClassLoader(), impl.getClass().getInterfaces(), new ProxyDao(impl));
	}
}

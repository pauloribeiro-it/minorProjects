package proxies;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import vo.AbstractTransaction;

public class SenderFactory {
	
	public static <T extends AbstractTransaction<?>> T createSender(Class<T> senderType, Object...params) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException{
		Constructor<T> constructor = senderType.getConstructor(getParameterTypes(params));
		return constructor.newInstance(params);
	}
	
	private static Class<?>[] getParameterTypes(Object params[]){
		List<Class<?>> types = new ArrayList<>();
		for(Object obj:params){
			types.add(obj.getClass());
		}
		return types.toArray(new Class<?>[params.length]);
	}
}

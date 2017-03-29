package enumselector.selector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import enumselector.annotations.AttributeSelector;

public class EnumRecover<T extends Enum<?>>  {

	public T recoverEnum(Class<T> t, String attributeName, Object value)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Method method = getMethod(t, attributeName);
		if (method != null) {
			return findByMethod(t, method, value);
		} else {
			method = findMethodByAnnotation(t, attributeName);
			if (method != null) {
				return findByMethod(t, method, value);
			}
		}
		throw new NoSuchMethodException("Method not found!");
	}

	private Method getMethod(Class<T> s, String attributeName) {
		for (Method m : s.getDeclaredMethods()) {
			if (m.isAnnotationPresent(AttributeSelector.class)) {
				StringBuilder methodName = new StringBuilder();
				methodName.append("get");
				methodName.append(String.valueOf(attributeName.charAt(0)).toUpperCase());
				methodName.append(attributeName.substring(1));
				if (m.getName().equals(methodName.toString())) {
					return m;
				}
			}
		}
		return null;
	}

	private T findByMethod(Class<T> c, Method m, Object value)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (T e : c.getEnumConstants()) {
			Object obj = m.invoke(e);
			if (obj.equals(value)) {
				return e;
			}
		}
		return null;
	}

	private Method findMethodByAnnotation(Class<T> c, String attribute) {
		for (Method m : c.getDeclaredMethods()) {
			if (m.isAnnotationPresent(AttributeSelector.class)) {
				AttributeSelector annotation = m.getDeclaredAnnotation(AttributeSelector.class);
				if (attribute.equals(annotation.value())) {
					return m;
				}
			}
		}
		return null;
	}

}

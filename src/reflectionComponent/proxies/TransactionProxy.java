package proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Properties;

import ifc.Sender;
import response.AbstractTransactionResponse;
import vo.AbstractTransaction;

public class TransactionProxy<Request extends AbstractTransaction<?>,Response extends AbstractTransactionResponse> implements InvocationHandler{
	
	public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
		Properties props = MockResponse.getResponse((AbstractTransaction<?>)args[0]);
		ParameterizedType paramType = (ParameterizedType) (args[0].getClass().getGenericSuperclass());
		
		Type responseType = paramType.getActualTypeArguments()[0];
//		System.out.print(Class.forName(responseType.getTypeName()));
		
		return processResponse(Class.forName(responseType.getTypeName()), props);
	}
	
	public Sender createProxy(Class<?> class1){
		return (Sender) Proxy.newProxyInstance(class1.getClassLoader(), new Class<?>[]{class1}, new TransactionProxy<Request,Response>());
	}
	
	<R> R processResponse(Class<R> type,Properties props) throws Exception{
		R r = type.newInstance();
//		ParameterizedType parameterizedType = (ParameterizedType) r;
//		System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
		for(Object key:props.keySet()){
			String keyAsString = (String) key;
			StringBuilder methodName = new StringBuilder();
			methodName.append("set");
			methodName.append(String.valueOf(keyAsString.charAt(0)).toUpperCase());
			methodName.append(keyAsString.substring(1));
			r.getClass().getMethod(methodName.toString(), props.get(key).getClass()).invoke(r, props.get(key));
		}
		return r;
	}
}

class MockResponse{
	static Properties getResponse(AbstractTransaction<?> request){
		Properties properties = new Properties();
		properties.put("processingDate","2017/03/30");
		properties.put("purchaseStatus", "1");
		return properties;
	}
}
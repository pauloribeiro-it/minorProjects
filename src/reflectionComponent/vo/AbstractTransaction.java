package vo;

import response.AbstractTransactionResponse;

public abstract class AbstractTransaction<Response extends AbstractTransactionResponse>{
	
	public Response createResponse(Class<Response> type) throws InstantiationException, IllegalAccessException{
		return type.newInstance();
	}
}

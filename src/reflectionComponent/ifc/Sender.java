package ifc;

import response.AbstractTransactionResponse;
import vo.AbstractTransaction;

public interface Sender {
	<Request extends AbstractTransaction<?>,Response extends AbstractTransactionResponse>Response send(Request request);
}

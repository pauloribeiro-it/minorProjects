package main;

import ifc.Sender;
import proxies.SenderFactory;
import proxies.TransactionProxy;
import response.PurchaseTransactionResponse;
import vo.PurchaseTransactionVo;

public class Main {
	public static void main(String[] args) throws Exception{
		PurchaseTransactionVo purchase = SenderFactory.createSender(PurchaseTransactionVo.class, "Florida Mall",new Double(123.0));
		TransactionProxy<PurchaseTransactionVo,PurchaseTransactionResponse> proxy =  new TransactionProxy<>();
		Sender sender = proxy.createProxy(Sender.class);
		System.out.println(sender.send(purchase));
	}
}

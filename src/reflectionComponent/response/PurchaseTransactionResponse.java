package response;

public class PurchaseTransactionResponse extends AbstractTransactionResponse {

	private String processingDate;
	private String purchaseStatus;

	public PurchaseTransactionResponse() {

	}
	
	public PurchaseTransactionResponse(String processingDate, String purchaseStatus) {
		this.processingDate = processingDate;
		this.purchaseStatus = purchaseStatus;
	}

	public String getProcessingDate() {
		return processingDate;
	}

	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
	}

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	@Override
	public String toString() {
		return purchaseStatus + " " + processingDate;
	}

}

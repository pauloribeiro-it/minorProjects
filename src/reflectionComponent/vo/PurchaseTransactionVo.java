package vo;

import response.PurchaseTransactionResponse;

public class PurchaseTransactionVo extends AbstractTransaction<PurchaseTransactionResponse> {

	private String shopName;
	private Double totalValue;

	public PurchaseTransactionVo() {

	}

	public PurchaseTransactionVo(String shopName, Double totalValue) {
		this.shopName = shopName;
		this.totalValue = totalValue;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return shopName + " " + totalValue;
	}
}

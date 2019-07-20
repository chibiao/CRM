package com.tjetc.utils;

/*
 * 报价单模糊查询信息
 * zc
 * 20190717 10:33
 */
public class FuzzyOffer {
	private Integer offerId;// 报价单编号
	private Integer orderId;// 订单编号
	private Integer managerId;// 客户经理编号
	private Integer offerState;// 报价单状态
	private String productName;// 产品名称
	private Double quodationMin;// 产品报价
	private Double quodationMax;//
	private Double implQuodationMin;// 实施报价
	private Double implQuodationMax;//
	private Double servQuodationMin;// 运维报价
	private Double servQuodationMax;//
	private Double specQuodationMin;// 专项服务报价
	private Double specQuodationMax;//
	private Double profitOrLossMin;// 损益报价
	private Double profitOrLossMax;//
	private Double totalMin;// 总计
	private Double totalMax;

	public FuzzyOffer() {
		super();
	}

	public FuzzyOffer(Integer offerId, Integer orderId, Integer managerId, Integer offerState, String productName,
			Double quodationMin, Double quodationMax, Double implQuodationMin, Double implQuodationMax,
			Double servQuodationMin, Double servQuodationMax, Double specQuodationMin, Double specQuodationMax,
			Double profitOrLossMin, Double profitOrLossMax, Double totalMin, Double totalMax) {
		super();
		this.offerId = offerId;
		this.orderId = orderId;
		this.managerId = managerId;
		this.offerState = offerState;
		this.productName = productName;
		this.quodationMin = quodationMin;
		this.quodationMax = quodationMax;
		this.implQuodationMin = implQuodationMin;
		this.implQuodationMax = implQuodationMax;
		this.servQuodationMin = servQuodationMin;
		this.servQuodationMax = servQuodationMax;
		this.specQuodationMin = specQuodationMin;
		this.specQuodationMax = specQuodationMax;
		this.profitOrLossMin = profitOrLossMin;
		this.profitOrLossMax = profitOrLossMax;
		this.totalMin = totalMin;
		this.totalMax = totalMax;
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getOfferState() {
		return offerState;
	}

	public void setOfferState(Integer offerState) {
		this.offerState = offerState;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getQuodationMin() {
		return quodationMin;
	}

	public void setQuodationMin(Double quodationMin) {
		this.quodationMin = quodationMin;
	}

	public Double getQuodationMax() {
		return quodationMax;
	}

	public void setQuodationMax(Double quodationMax) {
		this.quodationMax = quodationMax;
	}

	public Double getImplQuodationMin() {
		return implQuodationMin;
	}

	public void setImplQuodationMin(Double implQuodationMin) {
		this.implQuodationMin = implQuodationMin;
	}

	public Double getImplQuodationMax() {
		return implQuodationMax;
	}

	public void setImplQuodationMax(Double implQuodationMax) {
		this.implQuodationMax = implQuodationMax;
	}

	public Double getServQuodationMin() {
		return servQuodationMin;
	}

	public void setServQuodationMin(Double servQuodationMin) {
		this.servQuodationMin = servQuodationMin;
	}

	public Double getServQuodationMax() {
		return servQuodationMax;
	}

	public void setServQuodationMax(Double servQuodationMax) {
		this.servQuodationMax = servQuodationMax;
	}

	public Double getSpecQuodationMin() {
		return specQuodationMin;
	}

	public void setSpecQuodationMin(Double specQuodationMin) {
		this.specQuodationMin = specQuodationMin;
	}

	public Double getSpecQuodationMax() {
		return specQuodationMax;
	}

	public void setSpecQuodationMax(Double specQuodationMax) {
		this.specQuodationMax = specQuodationMax;
	}

	public Double getProfitOrLossMin() {
		return profitOrLossMin;
	}

	public void setProfitOrLossMin(Double profitOrLossMin) {
		this.profitOrLossMin = profitOrLossMin;
	}

	public Double getProfitOrLossMax() {
		return profitOrLossMax;
	}

	public void setProfitOrLossMax(Double profitOrLossMax) {
		this.profitOrLossMax = profitOrLossMax;
	}

	public Double getTotalMin() {
		return totalMin;
	}

	public void setTotalMin(Double totalMin) {
		this.totalMin = totalMin;
	}

	public Double getTotalMax() {
		return totalMax;
	}

	public void setTotalMax(Double totalMax) {
		this.totalMax = totalMax;
	}

	@Override
	public String toString() {
		return "FuzzyOffer [" + (offerId != null ? "offerId=" + offerId + ", " : "")
				+ (orderId != null ? "orderId=" + orderId + ", " : "")
				+ (managerId != null ? "managerId=" + managerId + ", " : "")
				+ (offerState != null ? "offerState=" + offerState + ", " : "")
				+ (productName != null ? "productName=" + productName + ", " : "")
				+ (quodationMin != null ? "quodationMin=" + quodationMin + ", " : "")
				+ (quodationMax != null ? "quodationMax=" + quodationMax + ", " : "")
				+ (implQuodationMin != null ? "implQuodationMin=" + implQuodationMin + ", " : "")
				+ (implQuodationMax != null ? "implQuodationMax=" + implQuodationMax + ", " : "")
				+ (servQuodationMin != null ? "servQuodationMin=" + servQuodationMin + ", " : "")
				+ (servQuodationMax != null ? "servQuodationMax=" + servQuodationMax + ", " : "")
				+ (specQuodationMin != null ? "specQuodationMin=" + specQuodationMin + ", " : "")
				+ (specQuodationMax != null ? "specQuodationMax=" + specQuodationMax + ", " : "")
				+ (profitOrLossMin != null ? "profitOrLossMin=" + profitOrLossMin + ", " : "")
				+ (profitOrLossMax != null ? "profitOrLossMax=" + profitOrLossMax + ", " : "")
				+ (totalMin != null ? "totalMin=" + totalMin + ", " : "")
				+ (totalMax != null ? "totalMax=" + totalMax : "") + "]";
	}

}

package com.tjetc.pojo;
/*
 * 报价 实体类
 * zc hjw
 * 201907716
 */
public class Offer {
	private Integer offerId;// 报价单编号
	private Integer orderId;// 订单编号
	private Integer managerId;// 管理员编号
	private Integer offerState;// 报价状态 null:未审核 0:未通过 1:已通过
	private String productName;// 产品名称
	private Double quodation;// 产品报价
	private Double implQuodation;// 实施报价
	private Double servQuodation;// 运维报价
	private Double specQuodation;// 专项服务报价
	private Double profitOrLoss;// 损益报价
	private Double total;// 合计

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
		this.productName = productName == null ? null : productName.trim();
	}

	public Double getQuodation() {
		return quodation;
	}

	public void setQuodation(Double quodation) {
		this.quodation = quodation;
	}

	public Double getImplQuodation() {
		return implQuodation;
	}

	public void setImplQuodation(Double implQuodation) {
		this.implQuodation = implQuodation;
	}

	public Double getServQuodation() {
		return servQuodation;
	}

	public void setServQuodation(Double servQuodation) {
		this.servQuodation = servQuodation;
	}

	public Double getSpecQuodation() {
		return specQuodation;
	}

	public void setSpecQuodation(Double specQuodation) {
		this.specQuodation = specQuodation;
	}

	public Double getProfitOrLoss() {
		return profitOrLoss;
	}

	public void setProfitOrLoss(Double profitOrLoss) {
		this.profitOrLoss = profitOrLoss;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Offer() {
		super();
		this.total = this.quodation + this.implQuodation + this.servQuodation + this.specQuodation + this.profitOrLoss;
	}

	public Offer(Integer offerId, Integer orderId, Integer managerId, Integer offerState, String productName,
			Double quodation, Double implQuodation, Double servQuodation, Double specQuodation, Double profitOrLoss) {
		super();
		this.offerId = offerId;
		this.orderId = orderId;
		this.managerId = managerId;
		this.offerState = offerState;
		this.productName = productName;
		this.quodation = quodation;
		this.implQuodation = implQuodation;
		this.servQuodation = servQuodation;
		this.specQuodation = specQuodation;
		this.profitOrLoss = profitOrLoss;
		this.total = this.quodation + this.implQuodation + this.servQuodation + this.specQuodation + this.profitOrLoss;
	}

	public Offer(Integer orderId, Integer managerId, Integer offerState, String productName, Double quodation,
			Double implQuodation, Double servQuodation, Double specQuodation, Double profitOrLoss) {
		super();
		this.orderId = orderId;
		this.managerId = managerId;
		this.offerState = offerState;
		this.productName = productName;
		this.quodation = quodation;
		this.implQuodation = implQuodation;
		this.servQuodation = servQuodation;
		this.specQuodation = specQuodation;
		this.profitOrLoss = profitOrLoss;
		this.total = this.quodation + this.implQuodation + this.servQuodation + this.specQuodation + this.profitOrLoss;
	}

	@Override
	public String toString() {
		return "Offer [" + (offerId != null ? "offerId=" + offerId + ", " : "")
				+ (orderId != null ? "orderId=" + orderId + ", " : "")
				+ (managerId != null ? "managerId=" + managerId + ", " : "")
				+ (offerState != null ? "offerState=" + offerState + ", " : "")
				+ (productName != null ? "productName=" + productName + ", " : "")
				+ (quodation != null ? "quodation=" + quodation + ", " : "")
				+ (implQuodation != null ? "implQuodation=" + implQuodation + ", " : "")
				+ (servQuodation != null ? "servQuodation=" + servQuodation + ", " : "")
				+ (specQuodation != null ? "specQuodation=" + specQuodation + ", " : "")
				+ (profitOrLoss != null ? "profitOrLoss=" + profitOrLoss + ", " : "")
				+ (total != null ? "total=" + total : "") + "]";
	}

}
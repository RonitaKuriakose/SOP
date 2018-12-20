package com.hrblock.sop.app.model;

public class SopAccountHistoryBean {

	private String market;
	private String region;
	private String district;
	private int officeId;
	private int omWarningStatusId;
	private String date;
	private int warningStepId;
	private int userId;
	private OmWarningStatusBean omWarningStatusBean;
	private WarningStepBean warningStepBean;
	
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getOfficeId() {
		return officeId;
	}
	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}
	public int getOmWarningStatusId() {
		return omWarningStatusId;
	}
	public void setOmWarningStatusId(int omWarningStatusId) {
		this.omWarningStatusId = omWarningStatusId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getWarningStepId() {
		return warningStepId;
	}
	public void setWarningStepId(int warningStepId) {
		this.warningStepId = warningStepId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public OmWarningStatusBean getOmWarningStatusBean() {
		return omWarningStatusBean;
	}
	public void setOmWarningStatusBean(OmWarningStatusBean omWarningStatusBean) {
		this.omWarningStatusBean = omWarningStatusBean;
	}
	public WarningStepBean getWarningStepBean() {
		return warningStepBean;
	}
	public void setWarningStepBean(WarningStepBean warningStepBean) {
		this.warningStepBean = warningStepBean;
	}
	
	
}

package com.hrblock.sop.app.model;



public class SopMainDetails {
	
	private String market;
	private String region;
	private String district;
	private int officeId;
	private boolean officeStatus;
	private int omWarningStatusId;
	private String omWarningStatusName;
	private String lastUpdated;
	private int warningStepId;
	private String warningStepName;
	private String comments;
	private OmWarningStatus omWarningStatusBean;
	private WarningStep warningStepBean;
	
	
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
	public boolean isOfficeStatus() {
		return officeStatus;
	}
	public void setOfficeStatus(boolean officeStatus) {
		this.officeStatus = officeStatus;
	}
	public int getOmWarningStatusId() {
		return omWarningStatusId;
	}
	public void setOmWarningStatusId(int omWarningStatusId) {
		this.omWarningStatusId = omWarningStatusId;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public int getWarningStepId() {
		return warningStepId;
	}
	public void setWarningStepId(int warningStepId) {
		this.warningStepId = warningStepId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public OmWarningStatus getOmWarningStatusBean() {
		return omWarningStatusBean;
	}
	public void setOmWarningStatusBean(OmWarningStatus omWarningStatusBean) {
		this.omWarningStatusBean = omWarningStatusBean;
	}
	public WarningStep getWarningStepBean() {
		return warningStepBean;
	}
	public void setWarningStepBean(WarningStep warningStepBean) {
		this.warningStepBean = warningStepBean;
	}
	public String getOmWarningStatusName() {
		return omWarningStatusName;
	}
	public void setOmWarningStatusName(String omWarningStatusName) {
		this.omWarningStatusName = omWarningStatusName;
	}
	public String getWarningStepName() {
		return warningStepName;
	}
	public void setWarningStepName(String warningStepName) {
		this.warningStepName = warningStepName;
	}
	
	

}

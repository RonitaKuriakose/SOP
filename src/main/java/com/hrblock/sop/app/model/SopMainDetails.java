package com.hrblock.sop.app.model;

/**
 *  @author  Umesh Kumar M
 *  @version     1.0
 *  @since       1.0
 *  Release Date: 
 *  <p>
 *  Revision History: 
 * 
 */ 

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
	private String omName;
	private int accRowId;
	private int warningCycleId;
	private int marketId;
	private int regionId;
	private int districtId;
	
	
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
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public int getAccRowId() {
		return accRowId;
	}
	public void setAccRowId(int accRowId) {
		this.accRowId = accRowId;
	}
	public int getWarningCycleId() {
		return warningCycleId;
	}
	public void setWarningCycleId(int warningCycleId) {
		this.warningCycleId = warningCycleId;
	}
	public int getMarketId() {
		return marketId;
	}
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	
	

}

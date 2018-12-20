package com.hrblock.sop.app.model;

import java.util.List;

public class SOPOffice {


private Integer officeID;
private String officeName;
private Integer omId;
private String omName;

private List<WarningStatusDetailsBean> verbalWarning;
private List<WarningStatusDetailsBean> writtenWarning;
private List<WarningStatusDetailsBean> finalWarning;
private List<WarningStatusDetailsBean> decision;


public Integer getOfficeID() {
	return officeID;
}

public void setOfficeID(Integer officeID) {
	this.officeID = officeID;
}

public String getOfficeName() {
	return officeName;
}

public void setOfficeName(String officeName) {
	this.officeName = officeName;
}

public String getOmName() {
	return omName;
}

public void setOmName(String omName) {
	this.omName = omName;
}

public List<WarningStatusDetailsBean> getVerbalWarning() {
	return verbalWarning;
}

public void setVerbalWarning(List<WarningStatusDetailsBean> verbalWarning) {
	this.verbalWarning = verbalWarning;
}

public List<WarningStatusDetailsBean> getWrittenWarning() {
	return writtenWarning;
}

public void setWrittenWarning(List<WarningStatusDetailsBean> writtenWarning) {
	this.writtenWarning = writtenWarning;
}

public List<WarningStatusDetailsBean> getFinalWarning() {
	return finalWarning;
}

public void setFinalWarning(List<WarningStatusDetailsBean> finalWarning) {
	this.finalWarning = finalWarning;
}

public List<WarningStatusDetailsBean> getDecision() {
	return decision;
}

public void setDecision(List<WarningStatusDetailsBean> decision) {
	this.decision = decision;
}

public Integer getOmId() {
	return omId;
}

public void setOmId(Integer omId) {
	this.omId = omId;
}


}

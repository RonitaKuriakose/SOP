package com.hrblock.sop.app.model;

import java.util.List;

public class SOPOffice {


private Integer officeID;
private String officeName;
private Integer omId;
private String omName;

private List<OmWarningStatus> verbalWarning;
private List<OmWarningStatus> writtenWarning;
private List<OmWarningStatus> finalWarning;
private List<OmWarningStatus> decision;


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

public List<OmWarningStatus> getVerbalWarning() {
	return verbalWarning;
}

public void setVerbalWarning(List<OmWarningStatus> verbalWarning) {
	this.verbalWarning = verbalWarning;
}

public List<OmWarningStatus> getWrittenWarning() {
	return writtenWarning;
}

public void setWrittenWarning(List<OmWarningStatus> writtenWarning) {
	this.writtenWarning = writtenWarning;
}

public List<OmWarningStatus> getFinalWarning() {
	return finalWarning;
}

public void setFinalWarning(List<OmWarningStatus> finalWarning) {
	this.finalWarning = finalWarning;
}

public List<OmWarningStatus> getDecision() {
	return decision;
}

public void setDecision(List<OmWarningStatus> decision) {
	this.decision = decision;
}

public Integer getOmId() {
	return omId;
}

public void setOmId(Integer omId) {
	this.omId = omId;
}


}

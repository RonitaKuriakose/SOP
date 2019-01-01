package com.hrblock.sop.app.model;

import java.util.List;

public class SOPOffice {


private Integer officeID;
private String officeName;
private Integer omId;
private String omName;

private List<WarningStatusDetails> verbalWarning;
private List<WarningStatusDetails> writtenWarning;
private List<WarningStatusDetails> finalWarning;
private List<WarningStatusDetails> decision;


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

public List<WarningStatusDetails> getVerbalWarning() {
	return verbalWarning;
}

public void setVerbalWarning(List<WarningStatusDetails> verbalWarning) {
	this.verbalWarning = verbalWarning;
}

public List<WarningStatusDetails> getWrittenWarning() {
	return writtenWarning;
}

public void setWrittenWarning(List<WarningStatusDetails> writtenWarning) {
	this.writtenWarning = writtenWarning;
}

public List<WarningStatusDetails> getFinalWarning() {
	return finalWarning;
}

public void setFinalWarning(List<WarningStatusDetails> finalWarning) {
	this.finalWarning = finalWarning;
}

public List<WarningStatusDetails> getDecision() {
	return decision;
}

public void setDecision(List<WarningStatusDetails> decision) {
	this.decision = decision;
}

public Integer getOmId() {
	return omId;
}

public void setOmId(Integer omId) {
	this.omId = omId;
}


}

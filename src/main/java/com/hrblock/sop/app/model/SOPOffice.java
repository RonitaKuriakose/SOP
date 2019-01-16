package com.hrblock.sop.app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @author  Umesh Kumar M
 *  @version     1.0
 *  @since       1.0
 *  Release Date: 
 *  <p>
 *  Revision History: 
 * 
 */ 

public class SOPOffice {


private Integer officeID;
private String officeName;
private Integer omId;
private String omName;

private List<WarningStatusDetails> verbalWarning;
private List<WarningStatusDetails> writtenWarning;
private List<WarningStatusDetails> finalWarning;
private List<WarningStatusDetails> decision;
private Map<String, List<WarningStatusDetails>> warningListofOffice = new HashMap<>();
private List<SopMainDetails> sopMainDetails= new ArrayList<>();
private String roleName;

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

public Map<String, List<WarningStatusDetails>> getWarningListofOffice() {
	return warningListofOffice;
}

public void setWarningListofOffice(Map<String, List<WarningStatusDetails>> warningListofOffice) {
	this.warningListofOffice = warningListofOffice;
}

public List<SopMainDetails> getSopMainDetails() {
	return sopMainDetails;
}

public void setSopMainDetails(List<SopMainDetails> sopMainDetails) {
	this.sopMainDetails = sopMainDetails;
}

public String getRoleName() {
	return roleName;
}

public void setRoleName(String roleName) {
	this.roleName = roleName;
}


}

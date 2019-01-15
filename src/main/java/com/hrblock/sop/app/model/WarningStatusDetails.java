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

public class WarningStatusDetails {

	
	private String date;
	private String omWarningStatus;
	private String exception;
	private String exceptionReason;
	private int warningId;
	private int omStepId;
	private String warningName;
	private int warningCycleId;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOmWarningStatus() {
		return omWarningStatus;
	}
	public void setOmWarningStatus(String omWarningStatus) {
		this.omWarningStatus = omWarningStatus;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getExceptionReason() {
		return exceptionReason;
	}
	public void setExceptionReason(String exceptionReason) {
		this.exceptionReason = exceptionReason;
	}
	public int getWarningId() {
		return warningId;
	}
	public void setWarningId(int warningId) {
		this.warningId = warningId;
	}
	public int getOmStepId() {
		return omStepId;
	}
	public void setOmStepId(int omStepId) {
		this.omStepId = omStepId;
	}
	public String getWarningName() {
		return warningName;
	}
	public void setWarningName(String warningName) {
		this.warningName = warningName;
	}
	public int getWarningCycleId() {
		return warningCycleId;
	}
	public void setWarningCycleId(int warningCycleId) {
		this.warningCycleId = warningCycleId;
	}
	
	
	
}

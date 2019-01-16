package com.hrblock.sop.app.dao;

import java.util.List;

import com.hrblock.sop.app.exception.SopCustomException;
import com.hrblock.sop.app.model.SOPOffice;

/**
 *  @author  Umesh Kumar M
 *  @version     1.0
 *  @since       1.0
 *  Release Date: 
 *  <p>
 *  Revision History: 
 * 
 */ 
public interface SopDAO {

	public SOPOffice getSopMainDetails(List<Integer> districtList, String smUser, String psID) throws SopCustomException;
	public SOPOffice fetchWarningDetailsOfOffice(String officeId) throws SopCustomException;
	public String savingWarningStatus(String officeId,String warningName,String date,String omWarningStatus,String exception,String exceptionReason, String warningCycleId, String psID) throws SopCustomException;
}

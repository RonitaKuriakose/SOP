package com.hrblock.sop.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetails;


public interface SopDAO {

	public List<SopMainDetails> getSopMainDetails(List<Integer> districtList);
	public SOPOffice fetchWarningDetailsOfOffice(String officeId);
	public String savingWarningStatus(String officeId,String warningName,String date,String omWarningStatus,String exception,String exceptionReason);
}

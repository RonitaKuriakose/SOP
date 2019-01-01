package com.hrblock.sop.app.service;

import java.util.ArrayList;
import java.util.List;

import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetails;




public interface SOPService {

	public List<SopMainDetails> getMainInterface(List<Integer> districtList);
	public ArrayList<SopMainDetails> getSearchDetails(String filterValue,String searchedValue);
	public SOPOffice getWarningDetailsOfOffice(String officeId);
	public String savingWarningStatus(String officeId,String warningName,String date,String omWarningStatus,String exception,String exceptionReason);
	
}

package com.hrblock.sop.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetailsBean;
import com.hrblock.sop.app.model.WarningStatusDetailsBean;
import com.hrblock.sop.app.util.SOPUtil;



@Service("sopService")
public interface SOPService {

	public List<SopMainDetailsBean> getMainInterface(List<Integer> districtList);
	public ArrayList<SopMainDetailsBean> getSearchDetails(String filterValue,String searchedValue);
	public SOPOffice getWarningDetailsOfOffice(String officeId);
	public String savingWarningStatus(String officeId,String warningName,String date,String omWarningStatus,String exception,String exceptionReason);
	
}

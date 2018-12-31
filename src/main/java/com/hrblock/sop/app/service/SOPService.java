package com.hrblock.sop.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetails;
import com.hrblock.sop.app.model.OmWarningStatus;
import com.hrblock.sop.app.util.SOPUtil;



@Service("sopService")
public interface SOPService {

	public List<SopMainDetails> getMainInterface(List<Integer> districtList);
	public ArrayList<SopMainDetails> getSearchDetails(String filterValue,String searchedValue);
	public SOPOffice getWarningDetailsOfOffice(String officeId);
	
}

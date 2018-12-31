package com.hrblock.sop.app.dao;

import java.util.List;

import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetails;
import com.hrblock.sop.app.model.OmWarningStatus;

public interface SopDAO {

	public List<SopMainDetails> getSopMainDetails(List<Integer> districtList);
	public SOPOffice fetchWarningDetailsOfOffice(String officeId);
}

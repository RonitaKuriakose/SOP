package com.hrblock.sop.app.dao;

import java.util.List;

import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetailsBean;
import com.hrblock.sop.app.model.WarningStatusDetailsBean;

public interface SopDAO {

	public List<SopMainDetailsBean> getSopMainDetails(List<Integer> districtList);
	public SOPOffice fetchWarningDetailsOfOffice(String officeId);
}

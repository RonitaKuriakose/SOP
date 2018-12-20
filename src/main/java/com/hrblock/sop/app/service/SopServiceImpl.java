package com.hrblock.sop.app.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hrblock.sop.app.dao.SopDAO;
import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetailsBean;
import com.hrblock.sop.app.model.WarningStatusDetailsBean;

public class SopServiceImpl implements SOPService{

	@Autowired
	private SopDAO sopDao;
	
	/** fetch data from db corresponding to the user details  **/
	
	public List<SopMainDetailsBean> getMainInterface(List<Integer> districtList) {
		System.out.println("TestIMPL");
		
		List<SopMainDetailsBean> sopMainArray = new ArrayList<SopMainDetailsBean>();
		sopMainArray = sopDao.getSopMainDetails(districtList);
		return sopMainArray;
	}

	/** fetch data from db corresponding to the search data from search bar **/
	
	@Override
	public ArrayList<SopMainDetailsBean> getSearchDetails(String filterValue,String searchedValue) {
		System.out.println(filterValue + searchedValue);
		ArrayList<SopMainDetailsBean> sopMainArray = new ArrayList<SopMainDetailsBean>();
		SopMainDetailsBean sopMainDetailsBean = new SopMainDetailsBean();
		sopMainDetailsBean.setMarket("Central");
		sopMainDetailsBean.setRegion("Chicago/Wisconsin");
		sopMainDetailsBean.setDistrict("Chicago South, IL");
		sopMainDetailsBean.setOfficeId(12730);
		sopMainDetailsBean.setWarningStepId(2);
		sopMainDetailsBean.setLastUpdated("12/12/2220");
		
		sopMainArray.add(sopMainDetailsBean);
		return sopMainArray;
	}

	/** call to DAO reagrding the details of the warning status details for the office id **/
	@Override
	public SOPOffice getWarningDetailsOfOffice(String officeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
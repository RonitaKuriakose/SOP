package com.hrblock.sop.app.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrblock.sop.app.dao.SopDAO;
import com.hrblock.sop.app.exception.SopCustomException;
import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetails;

/**
 *  @author  Umesh Kumar M
 *  @version     1.0
 *  @since       1.0
 *  Release Date: 
 *  <p>
 *  Revision History: 
 * 
 */ 

@Component
public class SopServiceImpl implements SOPService{

	@Autowired
	private SopDAO sopDao;
	Logger log = Logger.getLogger(this.getClass());
	
	/** fetch data from db corresponding to the user details  **/
	
	public List<SopMainDetails> getMainInterface(List<Integer> districtList,String smUser, String psID) throws SopCustomException{
		System.out.println("TestIMPL");
		List<SopMainDetails> sopMainArray = new ArrayList<SopMainDetails>();
		log.info("Entering SSO Integration process ServiceImpl");
		try {
			sopMainArray = sopDao.getSopMainDetails(districtList,smUser,psID);
		}catch (Exception e) {
			log.error("Exception occured at Integration process ServiceImpl: ",e);
			//System.err.print(e);
//			e.printStackTrace();
			throw new SopCustomException("Exception caught at ServiceImpl");
		}
		log.info("Existing SSO Integration process ServiceImpl");
		return sopMainArray;
	}

	/** call to DAO reagrding the details of the warning status details for the office id **/
	@Override
	public SOPOffice getWarningDetailsOfOffice(String officeId,String officeRowId) throws SopCustomException{
		
		SOPOffice sopOffice = new SOPOffice();
		log.info("Entering office warning details fetching ServiceImpl");
		try {
			sopOffice= sopDao.fetchWarningDetailsOfOffice(officeId,officeRowId);
		}catch (Exception e) {
			log.error("Exception occured at warning details fetching ServiceImpl: ",e);
			//System.err.print(e);
			e.printStackTrace();
			throw new SopCustomException("Exception caught at ServiceImpl");
		}
		log.info("Existing office warning details fetching ServiceImpl");
		return sopOffice;
	}

	/** sending data to dao class to store the details of status changed **/
	@Override
	public String savingWarningStatus(String officeId, String warningName, String date, String omWarningStatus,
			String exception, String exceptionReason,String warningCycleId,String psID) throws SopCustomException{
		String savingResult="";
		log.info("Entering WarningStatus Updation Process ServiceImpl");
		try {
			savingResult=sopDao.savingWarningStatus(officeId, warningName, date, omWarningStatus, exception, exceptionReason, warningCycleId, psID);
		}catch (Exception e) {
			log.error("Exception occured at WarningStatus Updation ServiceImpl: ",e);
			//System.err.print(e);
			e.printStackTrace();
			throw new SopCustomException("Exception caught at ServiceImpl");
		}
		log.info("Exiting WarningStatus Updation Process ServiceImpl");
		return savingResult;
	}

}

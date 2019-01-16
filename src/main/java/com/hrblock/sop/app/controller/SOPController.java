package com.hrblock.sop.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrblock.sop.app.exception.SopCustomException;
import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.service.SOPService;

/**
 *  @author  Umesh Kumar M
 *  @version     1.0
 *  @since       1.0
 *  Release Date: 
 *  <p>
 *  Revision History: 
 * 
 */ 

@ComponentScan("com.hrblock.sop.app.service")
@Controller
@RequestMapping("")
public class SOPController {

	@Autowired
	private SOPService service;

	Logger log = Logger.getLogger(this.getClass());
	String userName,role,smUser,psID,firstName,lastName;
	//String role;
	//String smUser;
	//String psID;

	/** Method to fetch the data to load the initial data table **/

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request,ModelMap model) throws SopCustomException {
		//role = "DISTRICTMANAGER";
		log.info("Entering SSO Integration process Controller");
		SOPOffice sopOffice = new SOPOffice();
		try {
			smUser=request.getHeader("SM_USER");
			/*psID=request.getHeader("PSID");*/
			psID= "1001438";
			firstName= request.getHeader("fName");
			lastName= request.getHeader("lName");
			userName = firstName+" "+lastName;
			List<Integer> districtList = new ArrayList<Integer>();
			districtList.add(1);
			districtList.add(2);
			districtList.add(3);
			districtList.add(4);
			sopOffice = service.getMainInterface(districtList,smUser,psID);
			role=sopOffice.getRoleName();
			model.addAttribute("jsondata", sopOffice.getSopMainDetails());
			model.addAttribute("userName", userName);
			model.addAttribute("role", role);
		} catch (Exception e) {
			log.error("Exception occured at Integration process Controller: ",e);
			//System.err.print(e);
			//e.printStackTrace();
			return "sop_internalservererror";
		}
		log.info("Existing SSO Integration process Controller");
		return "sop_home";
	}

	/** Method to fetch the warning step details with corresponding to office id **/

	@RequestMapping(value = "/officedetails", method = RequestMethod.GET)
	public String fetchSopOfficeWarningDetails(@RequestParam("officeId") String officeId,
			@RequestParam("omName") String omName,@RequestParam("warningCycleId") String warningCycleId,ModelMap model)
			throws SopCustomException {
		log.info("Entering office warning details fetching Controller");
		SOPOffice sopOffice = new SOPOffice();
		try {
			sopOffice = service.getWarningDetailsOfOffice(officeId);
			model.addAttribute("officeNumber", officeId);
			model.addAttribute("omName", omName);
			model.addAttribute("warningCycleId", warningCycleId);
			model.addAttribute("sopOfficeDetails", sopOffice.getWarningListofOffice());
			/*
			 * model.addAttribute("verbal", sopOffice.getVerbalWarning());
			 * model.addAttribute("written", sopOffice.getWrittenWarning());
			 * model.addAttribute("finals", sopOffice.getFinalWarning());
			 * model.addAttribute("decision", sopOffice.getDecision());
			 */
			model.addAttribute("userName", userName);
			model.addAttribute("role", role);
		} catch (Exception e) {
			log.error("Exception occured at warning details fetching Controller: ",e);
			//System.err.print(e);
			e.printStackTrace();
			return "sop_internalservererror";
		}
		log.info("Existing office warning details fetching Controller");
		return "sop_warning";
	}

	/** updation of the warning status with corresponding to the office id and warning step**/
	
	
	@RequestMapping(value = "/warningStatus", method = RequestMethod.POST)
	public @ResponseBody String savingWarningStatus(@RequestParam("officeId") String officeId,
			@RequestParam("warningName") String warningName, @RequestParam("date") String date,
			@RequestParam("omWarningStatus") String omWarningStatus, @RequestParam("exception") String exception,
			@RequestParam("exceptionReason") String exceptionReason,@RequestParam("warningCycleId") String warningCycleId) throws SopCustomException {

		String result = "";
		try {
			log.info("Entering WarningStatus Updation Process Controller");

			result = service.savingWarningStatus(officeId, warningName, date, omWarningStatus, exception,
					exceptionReason,warningCycleId,psID);

			log.info("Exiting WarningStatus Updation Process Controller");
		} catch (Exception e) {
			log.error("Exception occured at WarningStatus Updation Controller: ",e);
			//System.err.print(e);
			e.printStackTrace();
			return "sop_internalservererror";
		}
		if(result.equals("success")) {
			return "success";
		}else {
			return "failure";
		}
		
	}

}

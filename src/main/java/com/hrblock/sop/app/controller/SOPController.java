package com.hrblock.sop.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrblock.sop.app.model.SOPOffice;
import com.hrblock.sop.app.model.SopMainDetails;
import com.hrblock.sop.app.model.OmWarningStatus;
import com.hrblock.sop.app.service.SOPService;

@Controller
public class SOPController {

	@Autowired
	private SOPService service;

	Logger log = Logger.getLogger(this.getClass());

	/** Method to fetch the data to load the initial data table **/

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@RequestParam(value = "userid", required = false) String userid, ModelMap model) {
		List<Integer>districtList= new ArrayList<Integer>();
		districtList.add(1);
		districtList.add(2);
		districtList.add(15);
		districtList.add(7);
		districtList.add(10);
		List<SopMainDetails> mainList = service.getMainInterface(districtList);
		model.addAttribute("jsondata", mainList);
		return "sop_home";
	}

	/** Method to get the details with corresponding to search items **/

	/*
	 * @RequestMapping(value="/MySearch/{searchItem}", method = RequestMethod.GET)
	 * public @ResponseBody String fetchSopSearchDetails(@PathVariable("searchItem")
	 * String searchItem,ModelMap model){
	 */

	@RequestMapping(value = "/MySearch", method = RequestMethod.GET)
	public String fetchSopSearchDetails(@RequestParam("filters") String filterValue,
			@RequestParam("searchVal") String searchedValue, ModelMap model) {
		ArrayList<SopMainDetails> searchList = service.getSearchDetails(filterValue, searchedValue);
		model.addAttribute("jsondata", searchList);
		return "sop_home";
	}

	@RequestMapping(value = "/officedetails", method = RequestMethod.GET)
	public String fetchSopOfficeWarningDetails(@RequestParam("officeId") String officeId, ModelMap model) {
		
		SOPOffice sopOffice = new SOPOffice();
		sopOffice=service.getWarningDetailsOfOffice(officeId);
		model.addAttribute("officeNumber", officeId);
		model.addAttribute("omName", sopOffice.getOmName());
		model.addAttribute("verbal", sopOffice.getVerbalWarning());
		model.addAttribute("written", sopOffice.getWrittenWarning());
		model.addAttribute("finals", sopOffice.getFinalWarning());
		model.addAttribute("descision", sopOffice.getDecision());
		return "sop_warning";
	}
}

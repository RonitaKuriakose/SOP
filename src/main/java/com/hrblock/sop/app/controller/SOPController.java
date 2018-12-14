package com.hrblock.sop.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrblock.sop.app.service.SOPService;



@Controller
public class SOPController {

	
	@Autowired
	private SOPService service;
	
	Logger log = Logger.getLogger(this.getClass());
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@RequestParam(value="userid", required=false) String userid,ModelMap model) {
		String message = "hai";
		model.addAttribute("office", message);
		return "home";
		
	}
	
}

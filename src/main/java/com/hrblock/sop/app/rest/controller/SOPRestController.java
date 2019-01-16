package com.hrblock.sop.app.rest.controller;

/*@RestController
@RequestMapping("/api/sop")
public class SOPRestController {

	@Autowired
	private SOPService service;

	Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/warningStatus", method = RequestMethod.POST)
	public Response savingWarningStatus(@RequestParam("officeId") String officeId,
										@RequestParam("warningName") String warningName, 
										@RequestParam("date") String date,
										@RequestParam("omWarningStatus") String omWarningStatus, 
										@RequestParam("exception") String exception,
										@RequestParam("exceptionReason") String exceptionReason) {

		log.debug("Entering SOPRestController");
		
		String result = service.savingWarningStatus(officeId, warningName, date, omWarningStatus, exception,
				exceptionReason);
		
		log.debug("Exiting SOPRestController");
		
		return new Response(result);
	}

}
*/
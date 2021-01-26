package org.openmrs.module.bahmnicustomutil.web.controller;

import org.openmrs.api.LocationService;
import org.openmrs.module.bahmnicustomutil.api.BahmnicustomutilService;
import org.openmrs.module.bahmnicustomutil.model.CustomLocationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private BahmnicustomutilService bahmnicustomutilService;

	@RequestMapping(value = "/module/bahmnicustomutil/greeting", method = RequestMethod.GET)
	@ResponseBody
	public String test() {
		return "This is a custom module for any custom API";
	}

	@RequestMapping(value = "/module/bahmnicustomutil/getLocationBylocationTagName", method = RequestMethod.GET)
	@ResponseBody
	public CustomLocationBuilder getLocationBylocationTagName(
	        @RequestParam(value = "locationTagName", required = false) String locationTagName) {
		CustomLocationBuilder customLocationBuilder = new CustomLocationBuilder();
		customLocationBuilder.setResults(bahmnicustomutilService.getLocationBylocationTagName(locationTagName));
		return customLocationBuilder;
	}
}

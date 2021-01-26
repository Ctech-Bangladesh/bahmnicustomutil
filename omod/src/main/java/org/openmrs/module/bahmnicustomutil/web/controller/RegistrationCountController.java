package org.openmrs.module.bahmnicustomutil.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.bahmnicustomutil.api.BahmnicustomutilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class RegistrationCountController {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private BahmnicustomutilService bahmnicustomutilService;

	@RequestMapping(value = "/module/bahmnicustomutil/totalRegistration/poorPatient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> countPoorPatient() {
		Map<String, Object> patients = bahmnicustomutilService.getPoorPatientData();
		log.info("Poor patients have been counted among total patients :: " + patients);
		return patients;
	}
}

package org.openmrs.module.bahmnicustomutil.extension.html;

import org.openmrs.module.Extension;
import org.openmrs.module.web.extension.AdministrationSectionExt;

import java.util.HashMap;
import java.util.Map;

public class AdminList extends AdministrationSectionExt {

    public Extension.MEDIA_TYPE getMediaType() {
		return Extension.MEDIA_TYPE.html;
	}

    public String getTitle() {
		return "bahmnicustomutil.title";
	}

    public Map<String, String> getLinks() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("module/bahmnicustomutil/greeting.form", "BAHMNI Custom Module");
		map.put("module/bahmnicustomutil/totalRegistration/poorPatient.form", "Poor Patients Count");
		return map;
	}

}

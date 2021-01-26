package org.openmrs.module.bahmnicustomutil.api;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.bahmnicustomutil.model.CustomLocation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface BahmnicustomutilService extends OpenmrsService {

	public List<CustomLocation> getLocationBylocationTagName(String locationTagName);

	@Transactional
	Map<String, Object> getPoorPatientData() throws APIException;
}

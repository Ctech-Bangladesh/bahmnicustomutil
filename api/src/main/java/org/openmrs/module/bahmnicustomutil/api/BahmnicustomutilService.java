package org.openmrs.module.bahmnicustomutil.api;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.bahmnicustomutil.model.CustomLocation;

import java.util.List;
import java.util.Map;

public interface BahmnicustomutilService extends OpenmrsService {

    List<CustomLocation> getLocationBylocationTagName(String locationTagName);

    Map<String, Object> getPoorPatientData() throws APIException;
}

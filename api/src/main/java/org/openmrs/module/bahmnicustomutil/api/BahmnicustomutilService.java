package org.openmrs.module.bahmnicustomutil.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.bahmnicustomutil.model.CustomLocation;

import java.util.List;

public interface BahmnicustomutilService extends OpenmrsService {

	public List<CustomLocation> getLocationBylocationTagName(String locationTagName);
}

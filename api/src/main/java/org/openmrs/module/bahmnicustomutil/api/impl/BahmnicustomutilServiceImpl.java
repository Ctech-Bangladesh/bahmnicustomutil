package org.openmrs.module.bahmnicustomutil.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bahmnicustomutil.api.BahmnicustomutilService;
import org.openmrs.module.bahmnicustomutil.api.dao.BahmnicustomutilDao;
import org.openmrs.module.bahmnicustomutil.model.CustomLocation;

import java.util.List;
import java.util.Map;

public class BahmnicustomutilServiceImpl extends BaseOpenmrsService implements BahmnicustomutilService {

	private BahmnicustomutilDao bahmnicustomutilDao;

	public void setBahmnicustomutilDao(BahmnicustomutilDao bahmnicustomutilDao) {
		this.bahmnicustomutilDao = bahmnicustomutilDao;
	}

	@Override
	public List<CustomLocation> getLocationBylocationTagName(String locationTagName) {
		return bahmnicustomutilDao.getLocationBylocationTagName(locationTagName);
	}

	@Override
	public Map<String, Object> getPoorPatientData() {
		return bahmnicustomutilDao.getPoorPatientData();
	}
}

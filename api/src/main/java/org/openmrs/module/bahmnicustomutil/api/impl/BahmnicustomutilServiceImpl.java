/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.bahmnicustomutil.api.impl;

import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bahmnicustomutil.api.BahmnicustomutilService;
import org.openmrs.module.bahmnicustomutil.api.dao.BahmnicustomutilDao;
import org.openmrs.module.bahmnicustomutil.model.CustomLocation;

import java.util.List;
import java.util.Map;

public class BahmnicustomutilServiceImpl extends BaseOpenmrsService implements BahmnicustomutilService {

	BahmnicustomutilDao dao;

	UserService userService;

	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(BahmnicustomutilDao dao) {
		this.dao = dao;
	}

	@Override
	public List<CustomLocation> getLocationBylocationTagName(String locationTagName) {
		return dao.getLocationBylocationTagName(locationTagName);
	}

	@Override
	public Map<String, Object> getPoorPatientData() {
		return dao.getPoorPatientData();
	}
}

package org.openmrs.module.bahmnicustomutil.api.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.bahmnicustomutil.model.CustomLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bahmnicustomutil.BahmnicustomutilDao")
public class BahmnicustomutilDao {
	
	@Autowired
	DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<CustomLocation> getLocationBylocationTagName(String locationTagName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CustomLocation.class);
		criteria.add(Restrictions.eq("location_tag_name", locationTagName));
		return criteria.list();
	}
}

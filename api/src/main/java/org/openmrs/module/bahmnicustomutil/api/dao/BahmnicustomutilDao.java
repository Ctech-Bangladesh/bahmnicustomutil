package org.openmrs.module.bahmnicustomutil.api.dao;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.bahmnicustomutil.model.CustomLocation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository("bahmnicustomutilDao")
public class BahmnicustomutilDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<CustomLocation> getLocationBylocationTagName(String locationTagName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CustomLocation.class);
		criteria.add(Restrictions.eq("location_tag_name", locationTagName));
		return criteria.list();
	}

	@Transactional
	public Map<String, Object> getPoorPatientData() {
		String query1 = "select count(obs_value.value_coded)" + " from (select o.value_coded" + " from obs o"
				+ " where o.voided = 0" + " and o.concept_id in"
				+ " (select cv.concept_id from concept_view cv where concept_full_name = 'Registration Fee Type')"
				+ " and cast(o.obs_datetime as DATE) between cast(now() as DATE) and cast(now() as DATE)"
				+ " group by o.person_id) obs_value";
		String query2 = "select count(distinct obs_value.person_id)" + " from (select o.person_id" + " from obs o"
				+ " where o.voided = 0" + " and o.value_coded in"
				+ " (select cv.concept_id from concept_view cv where concept_full_name = 'Poor Patient')"
				+ " and cast(o.obs_datetime as DATE) between cast(now() as DATE) and cast(now() as DATE)"
				+ " group by o.person_id) obs_value";
		SQLQuery criteria1 = sessionFactory.getCurrentSession().createSQLQuery(query1);
		SQLQuery criteria2 = sessionFactory.getCurrentSession().createSQLQuery(query2);
		Map<String, Object> obj = new LinkedHashMap<String, Object>();
		obj.put("totalPatient", criteria1.list());
		obj.put("poorPatient", criteria2.list());
		return obj;
	}
}

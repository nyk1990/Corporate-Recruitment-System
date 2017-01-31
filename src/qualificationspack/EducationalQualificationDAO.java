package qualificationspack;

import generalinfopack.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * EducationalQualification entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see qualificationspack.EducationalQualification
 * @author MyEclipse Persistence Tools
 */

public class EducationalQualificationDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(EducationalQualificationDAO.class);
	// property constants
	public static final String HIGHEST_QUALIFICATION = "highestQualification";
	public static final String SPECIALIZATION = "specialization";
	public static final String INSTITUTE = "institute";
	public static final String AGGREGATE = "aggregate";
	public static final String YOP = "yop";
	public static final String HIGHEST_QUALIFICATION2 = "highestQualification2";
	public static final String SPECIALIZATION2 = "specialization2";
	public static final String INSTITUTE2 = "institute2";
	public static final String AGGREGATE2 = "aggregate2";
	public static final String YOP2 = "yop2";

	public void save(EducationalQualification transientInstance) {
		log.debug("saving EducationalQualification instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EducationalQualification persistentInstance) {
		log.debug("deleting EducationalQualification instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EducationalQualification findById(java.lang.String id) {
		log.debug("getting EducationalQualification instance with id: " + id);
		try {
			EducationalQualification instance = (EducationalQualification) getSession()
					.get("qualificationspack.EducationalQualification", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EducationalQualification instance) {
		log.debug("finding EducationalQualification instance by example");
		try {
			List results = getSession().createCriteria(
					"qualificationspack.EducationalQualification").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EducationalQualification instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EducationalQualification as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHighestQualification(Object highestQualification) {
		return findByProperty(HIGHEST_QUALIFICATION, highestQualification);
	}

	public List findBySpecialization(Object specialization) {
		return findByProperty(SPECIALIZATION, specialization);
	}

	public List findByInstitute(Object institute) {
		return findByProperty(INSTITUTE, institute);
	}

	public List findByAggregate(Object aggregate) {
		return findByProperty(AGGREGATE, aggregate);
	}

	public List findByYop(Object yop) {
		return findByProperty(YOP, yop);
	}

	public List findByHighestQualification2(Object highestQualification2) {
		return findByProperty(HIGHEST_QUALIFICATION2, highestQualification2);
	}

	public List findBySpecialization2(Object specialization2) {
		return findByProperty(SPECIALIZATION2, specialization2);
	}

	public List findByInstitute2(Object institute2) {
		return findByProperty(INSTITUTE2, institute2);
	}

	public List findByAggregate2(Object aggregate2) {
		return findByProperty(AGGREGATE2, aggregate2);
	}

	public List findByYop2(Object yop2) {
		return findByProperty(YOP2, yop2);
	}

	public List findAll() {
		log.debug("finding all EducationalQualification instances");
		try {
			String queryString = "from EducationalQualification";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EducationalQualification merge(
			EducationalQualification detachedInstance) {
		log.debug("merging EducationalQualification instance");
		try {
			EducationalQualification result = (EducationalQualification) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EducationalQualification instance) {
		log.debug("attaching dirty EducationalQualification instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EducationalQualification instance) {
		log.debug("attaching clean EducationalQualification instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
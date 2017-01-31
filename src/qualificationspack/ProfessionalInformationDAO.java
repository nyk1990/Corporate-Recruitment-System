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
 * ProfessionalInformation entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see qualificationspack.ProfessionalInformation
 * @author MyEclipse Persistence Tools
 */

public class ProfessionalInformationDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(ProfessionalInformationDAO.class);
	// property constants
	public static final String FUNCTIONAL_AREA = "functionalArea";
	public static final String CURRENT_ROLE = "currentRole";
	public static final String AREA_OF_SPECIALIZATION = "areaOfSpecialization";

	public void save(ProfessionalInformation transientInstance) {
		log.debug("saving ProfessionalInformation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProfessionalInformation persistentInstance) {
		log.debug("deleting ProfessionalInformation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProfessionalInformation findById(java.lang.String id) {
		log.debug("getting ProfessionalInformation instance with id: " + id);
		try {
			ProfessionalInformation instance = (ProfessionalInformation) getSession()
					.get("qualificationspack.ProfessionalInformation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ProfessionalInformation instance) {
		log.debug("finding ProfessionalInformation instance by example");
		try {
			List results = getSession().createCriteria(
					"qualificationspack.ProfessionalInformation").add(
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
		log.debug("finding ProfessionalInformation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ProfessionalInformation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFunctionalArea(Object functionalArea) {
		return findByProperty(FUNCTIONAL_AREA, functionalArea);
	}

	public List findByCurrentRole(Object currentRole) {
		return findByProperty(CURRENT_ROLE, currentRole);
	}

	public List findByAreaOfSpecialization(Object areaOfSpecialization) {
		return findByProperty(AREA_OF_SPECIALIZATION, areaOfSpecialization);
	}

	public List findAll() {
		log.debug("finding all ProfessionalInformation instances");
		try {
			String queryString = "from ProfessionalInformation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProfessionalInformation merge(
			ProfessionalInformation detachedInstance) {
		log.debug("merging ProfessionalInformation instance");
		try {
			ProfessionalInformation result = (ProfessionalInformation) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProfessionalInformation instance) {
		log.debug("attaching dirty ProfessionalInformation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProfessionalInformation instance) {
		log.debug("attaching clean ProfessionalInformation instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
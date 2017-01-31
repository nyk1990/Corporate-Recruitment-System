package companyinfopack;

import generalinfopack.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * CompanyUpdates entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see companyinfopack.CompanyUpdates
 * @author MyEclipse Persistence Tools
 */

public class CompanyUpdatesDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(CompanyUpdatesDAO.class);
	// property constants
	public static final String COMPANY = "company";
	public static final String WEBSITE = "website";
	public static final String ELIGIBILITY = "eligibility";
	public static final String LOCATION = "location";
	public static final String JOB_ROLE = "jobRole";
	public static final String JOB_SUMMARY = "jobSummary";

	public void save(CompanyUpdates transientInstance) {
		log.debug("saving CompanyUpdates instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyUpdates persistentInstance) {
		log.debug("deleting CompanyUpdates instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyUpdates findById(java.lang.Integer id) {
		log.debug("getting CompanyUpdates instance with id: " + id);
		try {
			CompanyUpdates instance = (CompanyUpdates) getSession().get(
					"companyinfopack.CompanyUpdates", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyUpdates instance) {
		log.debug("finding CompanyUpdates instance by example");
		try {
			List results = getSession().createCriteria(
					"companyinfopack.CompanyUpdates").add(
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
		log.debug("finding CompanyUpdates instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CompanyUpdates as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCompany(Object company) {
		return findByProperty(COMPANY, company);
	}

	public List findByWebsite(Object website) {
		return findByProperty(WEBSITE, website);
	}

	public List findByEligibility(Object eligibility) {
		return findByProperty(ELIGIBILITY, eligibility);
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List findByJobRole(Object jobRole) {
		return findByProperty(JOB_ROLE, jobRole);
	}

	public List findByJobSummary(Object jobSummary) {
		return findByProperty(JOB_SUMMARY, jobSummary);
	}

	public List findAll() {
		log.debug("finding all CompanyUpdates instances");
		try {
			String queryString = "from CompanyUpdates";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyUpdates merge(CompanyUpdates detachedInstance) {
		log.debug("merging CompanyUpdates instance");
		try {
			CompanyUpdates result = (CompanyUpdates) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyUpdates instance) {
		log.debug("attaching dirty CompanyUpdates instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyUpdates instance) {
		log.debug("attaching clean CompanyUpdates instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
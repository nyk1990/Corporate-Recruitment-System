package generalinfopack;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Generalinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see generalinfopack.Generalinfo
 * @author MyEclipse Persistence Tools
 */

public class GeneralinfoDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(GeneralinfoDAO.class);
	// property constants
	public static final String FIRSTNAME = "firstname";
	public static final String MIDDLENAME = "middlename";
	public static final String LASTNAME = "lastname";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String ADDRESS = "address";
	public static final String MOBILENO = "mobileno";
	public static final String CITY = "city";
	public static final String PINCODE = "pincode";
	public static final String NATIONALITY = "nationality";
	public static final String GENDER = "gender";
	public static final String CURRENTCITY = "currentcity";
	public static final String DOB = "dob";

	public void save(Generalinfo transientInstance) {
		log.debug("saving Generalinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Generalinfo persistentInstance) {
		log.debug("deleting Generalinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Generalinfo findById(java.lang.String id) {
		log.debug("getting Generalinfo instance with id: " + id);
		try {
			Generalinfo instance = (Generalinfo) getSession().get(
					"generalinfopack.Generalinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Generalinfo instance) {
		log.debug("finding Generalinfo instance by example");
		try {
			List results = getSession().createCriteria(
					"generalinfopack.Generalinfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Generalinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Generalinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFirstname(Object firstname) {
		return findByProperty(FIRSTNAME, firstname);
	}

	public List findByMiddlename(Object middlename) {
		return findByProperty(MIDDLENAME, middlename);
	}

	public List findByLastname(Object lastname) {
		return findByProperty(LASTNAME, lastname);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByMobileno(Object mobileno) {
		return findByProperty(MOBILENO, mobileno);
	}

	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List findByPincode(Object pincode) {
		return findByProperty(PINCODE, pincode);
	}

	public List findByNationality(Object nationality) {
		return findByProperty(NATIONALITY, nationality);
	}

	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List findByCurrentcity(Object currentcity) {
		return findByProperty(CURRENTCITY, currentcity);
	}

	public List findByDob(Object dob) {
		return findByProperty(DOB, dob);
	}

	public List findAll() {
		log.debug("finding all Generalinfo instances");
		try {
			String queryString = "from Generalinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Generalinfo merge(Generalinfo detachedInstance) {
		log.debug("merging Generalinfo instance");
		try {
			Generalinfo result = (Generalinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Generalinfo instance) {
		log.debug("attaching dirty Generalinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Generalinfo instance) {
		log.debug("attaching clean Generalinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
package employerinfopack;

import generalinfopack.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for EmployerInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see employerinfopack.EmployerInfo
  * @author MyEclipse Persistence Tools 
 */

public class EmployerInfoDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EmployerInfoDAO.class);
	//property constants
	public static final String COMPANY_NAME = "companyName";
	public static final String EMAIL_ID = "emailId";
	public static final String PASSWORD = "password";
	public static final String CONTACT_PERSON = "contactPerson";
	public static final String DESIGNATION = "designation";
	public static final String CONTACT_NO = "contactNo";
	public static final String WEB_URL = "webUrl";
	public static final String COMPANY_PROFILE = "companyProfile";



    
    public void save(EmployerInfo transientInstance) {
        log.debug("saving EmployerInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EmployerInfo persistentInstance) {
        log.debug("deleting EmployerInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EmployerInfo findById( java.lang.String id) {
        log.debug("getting EmployerInfo instance with id: " + id);
        try {
            EmployerInfo instance = (EmployerInfo) getSession()
                    .get("employerinfopack.EmployerInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EmployerInfo instance) {
        log.debug("finding EmployerInfo instance by example");
        try {
            List results = getSession()
                    .createCriteria("employerinfopack.EmployerInfo")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding EmployerInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EmployerInfo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCompanyName(Object companyName
	) {
		return findByProperty(COMPANY_NAME, companyName
		);
	}
	
	public List findByEmailId(Object emailId
	) {
		return findByProperty(EMAIL_ID, emailId
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByContactPerson(Object contactPerson
	) {
		return findByProperty(CONTACT_PERSON, contactPerson
		);
	}
	
	public List findByDesignation(Object designation
	) {
		return findByProperty(DESIGNATION, designation
		);
	}
	
	public List findByContactNo(Object contactNo
	) {
		return findByProperty(CONTACT_NO, contactNo
		);
	}
	
	public List findByWebUrl(Object webUrl
	) {
		return findByProperty(WEB_URL, webUrl
		);
	}
	
	public List findByCompanyProfile(Object companyProfile
	) {
		return findByProperty(COMPANY_PROFILE, companyProfile
		);
	}
	

	public List findAll() {
		log.debug("finding all EmployerInfo instances");
		try {
			String queryString = "from EmployerInfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EmployerInfo merge(EmployerInfo detachedInstance) {
        log.debug("merging EmployerInfo instance");
        try {
            EmployerInfo result = (EmployerInfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EmployerInfo instance) {
        log.debug("attaching dirty EmployerInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EmployerInfo instance) {
        log.debug("attaching clean EmployerInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
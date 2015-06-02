package com.iportfolio.users;

import com.iportfolio.session.*;


import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



/**
 * A data access object (DAO) providing persistence and search support for Users
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.iportfolio.users.Users
 * @author MyEclipse Persistence Tools
 */

public class UsersDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(UsersDAO.class);
	// property constants
	public static final String PSEUDO = "pseudo";
	public static final String PASS = "pass";
	public static final String EMAIL = "email";
	public static final String LAST_IP = "lastIp";
	public static final String RANK = "rank";

	protected void initDao() {
		// do nothing
	}

	public void save(Users transientInstance) {
		log.debug("saving User instance"); 
        try { 
           Session session = (Session) HibernateSessionFactory.getSession(); 
           Transaction tx = session.beginTransaction(); 
           tx.begin(); 
           session.save(transientInstance); 
            
           tx.commit(); 
            session.close();
            log.debug("save successful"); 
        } catch (RuntimeException re) { 
            log.error("save failed", re); 
            throw re; 
        } 
	}

	public void delete(Users persistentInstance) {
        log.debug("deleting User instance"); 
        try { 
           Session session = (Session) HibernateSessionFactory.getSession(); 
           Transaction tx = session.beginTransaction(); 
           tx.begin(); 
        
            session.delete(persistentInstance); 
            
            tx.commit(); 
            session.close();
            log.debug("delete successful"); 
        } catch (RuntimeException re) { 
            log.error("delete failed", re); 
            throw re; 
        }
	}

	public Users findById(java.lang.Integer id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) getHibernateTemplate().get(
					"com.iportfolio.users.Users", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Users> findByExample(Users instance) {
		log.debug("finding Users instance by example");
		try {
			List<Users> results = (List<Users>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Users instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Users as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Users> findByPseudo(Object pseudo) {
		return findByProperty(PSEUDO, pseudo);
	}

	public List<Users> findByPass(Object pass) {
		return findByProperty(PASS, pass);
	}

	public List<Users> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Users> findByLastIp(Object lastIp) {
		return findByProperty(LAST_IP, lastIp);
	}

	public List<Users> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List findAll() {
		log.debug("finding all Users instances");
		try {
			String queryString = "from Users";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Users merge(Users detachedInstance) {
		 log.debug("merging User instance"); 
	        try { 
	           Session session = (Session) HibernateSessionFactory.getSession(); 
	           Transaction tx = session.beginTransaction(); 
	           tx.begin(); 
	        
	            Users result = (Users) session 
	                    .merge(detachedInstance); 
	            
	            tx.commit(); 
	            session.close();
	            log.debug("merge successful"); 
	            return result; 
	        } catch (RuntimeException re) { 
	            log.error("merge failed", re); 
	            throw re; 
	        } 
	}

	public void attachDirty(Users instance) {
		log.debug("attaching dirty Users instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Users instance) {
		log.debug("attaching clean Users instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UsersDAO) ctx.getBean("UsersDAO");
	}
}
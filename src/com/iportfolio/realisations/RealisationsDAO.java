package com.iportfolio.realisations;

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

import com.iportfolio.session.HibernateSessionFactory;
import com.iportfolio.users.Users;

/**
 * A data access object (DAO) providing persistence and search support for
 * Realisations entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.iportfolio.realisations.Realisations
 * @author MyEclipse Persistence Tools
 */

public class RealisationsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RealisationsDAO.class);
	// property constants
	public static final String TITRE = "titre";
	public static final String SLUG = "slug";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	public void save(Realisations transientInstance) {
		log.debug("saving Realisations instance"); 
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

	public void delete(Realisations persistentInstance) {
		   log.debug("deleting Realisations instance"); 
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

	public Realisations findById(java.lang.Integer id) {
		log.debug("getting Realisations instance with id: " + id);
		try {
			Realisations instance = (Realisations) getHibernateTemplate().get(
					"com.iportfolio.realisations.Realisations", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Realisations> findByExample(Realisations instance) {
		log.debug("finding Realisations instance by example");
		try {
			List<Realisations> results = (List<Realisations>) getHibernateTemplate()
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
		log.debug("finding Realisations instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Realisations as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Realisations> findByTitre(Object titre) {
		return findByProperty(TITRE, titre);
	}

	public List<Realisations> findBySlug(Object slug) {
		return findByProperty(SLUG, slug);
	}

	public List<Realisations> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Realisations instances");
		try {
			String queryString = "from Realisations";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Realisations merge(Realisations detachedInstance) {
		 log.debug("merging User instance"); 
	        try { 
	           Session session = (Session) HibernateSessionFactory.getSession(); 
	           Transaction tx = session.beginTransaction(); 
	           tx.begin(); 
	        
	           Realisations result = (Realisations) session 
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

	public void attachDirty(Realisations instance) {
		log.debug("attaching dirty Realisations instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Realisations instance) {
		log.debug("attaching clean Realisations instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RealisationsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (RealisationsDAO) ctx.getBean("RealisationsDAO");
	}
}
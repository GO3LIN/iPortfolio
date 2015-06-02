package com.iportfolio.commentaires;

import java.sql.Timestamp;
import java.util.List;
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
 * Commentaires entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.iportfolio.commentaires.Commentaires
 * @author MyEclipse Persistence Tools
 */

public class CommentairesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CommentairesDAO.class);
	// property constants
	public static final String PSEUDO = "pseudo";
	public static final String MESSAGE = "message";

	protected void initDao() {
		// do nothing
	}

	public void save(Commentaires transientInstance) {
		log.debug("saving Commentaires instance"); 
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

	public void delete(Commentaires persistentInstance) {
		   log.debug("deleting Commentaires instance"); 
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

	public Commentaires findById(java.lang.Integer id) {
		log.debug("getting Commentaires instance with id: " + id);
		try {
			Commentaires instance = (Commentaires) getHibernateTemplate().get(
					"com.iportfolio.commentaires.Commentaires", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Commentaires> findByExample(Commentaires instance) {
		log.debug("finding Commentaires instance by example");
		try {
			List<Commentaires> results = (List<Commentaires>) getHibernateTemplate()
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
		log.debug("finding Commentaires instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Commentaires as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Commentaires> findByPseudo(Object pseudo) {
		return findByProperty(PSEUDO, pseudo);
	}

	public List<Commentaires> findByMessage(Object message) {
		return findByProperty(MESSAGE, message);
	}

	public List findAll() {
		log.debug("finding all Commentaires instances");
		try {
			String queryString = "from Commentaires";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Commentaires merge(Commentaires detachedInstance) {
		 log.debug("merging Commentaires instance"); 
	        try { 
	           Session session = (Session) HibernateSessionFactory.getSession(); 
	           Transaction tx = session.beginTransaction(); 
	           tx.begin(); 
	        
	           Commentaires result = (Commentaires) session 
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

	public void attachDirty(Commentaires instance) {
		log.debug("attaching dirty Commentaires instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commentaires instance) {
		log.debug("attaching clean Commentaires instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CommentairesDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CommentairesDAO) ctx.getBean("CommentairesDAO");
	}
}
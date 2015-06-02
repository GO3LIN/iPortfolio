package com.iportfolio.model.dao;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "portfodb")
public class Users extends AbstractUsers implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String pseudo, String pass, String email,
			Timestamp dateInscri, String lastIp, Short rank) {
		super(pseudo, pass, email, dateInscri, lastIp, rank);
	}

	/** full constructor */
	public Users(String pseudo, String pass, String email,
			Timestamp dateInscri, String lastIp, Short rank,
			Set<Realisations> realisationses) {
		super(pseudo, pass, email, dateInscri, lastIp, rank, realisationses);
	}

}

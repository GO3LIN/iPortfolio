package com.iportfolio.users;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;


import com.iportfolio.realisations.*;
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
	public Users(Integer id, String pseudo, String pass, String email,
			Timestamp dateInscri, String lastIp, Short rank) {
		super(id, pseudo, pass, email, dateInscri, lastIp, rank);
	}

	/** full constructor */
	public Users(Integer id, String pseudo, String pass, String email,
			Timestamp dateInscri, String lastIp, Short rank,
			Set<Realisations> realisationses) {
		super(id, pseudo, pass, email, dateInscri, lastIp, rank, realisationses);
	
	}

	
}

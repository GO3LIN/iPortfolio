package com.iportfolio.users;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.iportfolio.realisations.*;
/**
 * AbstractUsers entity provides the base persistence definition of the Users
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractUsers implements java.io.Serializable {

	// Fields

	private Integer id;
	private String pseudo;
	private String pass;
	private String email;
	private Timestamp dateInscri;
	private String lastIp;
	private Short rank;
	private Set<Realisations> realisationses = new HashSet<Realisations>(0);

	// Constructors

	/** default constructor */
	public AbstractUsers() {
	}

	/** minimal constructor */
	public AbstractUsers(Integer id, String pseudo, String pass, String email,
			Timestamp dateInscri, String lastIp, Short rank) {
		this.id = id;
		this.pseudo = pseudo;
		this.pass = pass;
		this.email = email;
		this.dateInscri = dateInscri;
		this.lastIp = lastIp;
		this.rank = rank;
	}

	/** full constructor */
	public AbstractUsers(Integer id, String pseudo, String pass, String email,
			Timestamp dateInscri, String lastIp, Short rank,
			Set<Realisations> realisationses) {
		this.id = id;
		this.pseudo = pseudo;
		this.pass = pass;
		this.email = email;
		this.dateInscri = dateInscri;
		this.lastIp = lastIp;
		this.rank = rank;
		this.realisationses = realisationses;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "pseudo", nullable = false, length = 50)
	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Column(name = "pass", nullable = false, length = 100)
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "dateInscri", nullable = false, length = 19)
	public Timestamp getDateInscri() {
		return this.dateInscri;
	}

	public void setDateInscri(Timestamp dateInscri) {
		this.dateInscri = dateInscri;
	}

	@Column(name = "lastIP", nullable = false, length = 15)
	public String getLastIp() {
		return this.lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	@Column(name = "rank", nullable = false)
	public Short getRank() {
		return this.rank;
	}

	public void setRank(Short rank) {
		this.rank = rank;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Realisations> getRealisationses() {
		return this.realisationses;
	}

	public void setRealisationses(Set<Realisations> realisationses) {
		this.realisationses = realisationses;
	}

}
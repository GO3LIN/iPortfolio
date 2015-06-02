package com.iportfolio.model.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractCommentaires entity provides the base persistence definition of the
 * Commentaires entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractCommentaires implements java.io.Serializable {

	// Fields

	private Integer id;
	private Realisations realisations;
	private String pseudo;
	private String message;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public AbstractCommentaires() {
	}

	/** full constructor */
	public AbstractCommentaires(Realisations realisations, String pseudo,
			String message, Timestamp date) {
		this.realisations = realisations;
		this.pseudo = pseudo;
		this.message = message;
		this.date = date;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRealisation", nullable = false)
	public Realisations getRealisations() {
		return this.realisations;
	}

	public void setRealisations(Realisations realisations) {
		this.realisations = realisations;
	}

	@Column(name = "pseudo", nullable = false, length = 50)
	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Column(name = "message", nullable = false)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "date", nullable = false, length = 0)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}
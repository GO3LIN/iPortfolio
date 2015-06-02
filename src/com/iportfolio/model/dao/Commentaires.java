package com.iportfolio.model.dao;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Commentaires entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "commentaires", catalog = "portfodb")
public class Commentaires extends AbstractCommentaires implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Commentaires() {
	}

	/** full constructor */
	public Commentaires(Realisations realisations, String pseudo,
			String message, Timestamp date) {
		super(realisations, pseudo, message, date);
	}

}

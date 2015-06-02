package com.iportfolio.realisations;


import com.iportfolio.users.*;
import com.iportfolio.categories.*;
import com.iportfolio.commentaires.*;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Realisations entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "realisations", catalog = "portfodb")
public class Realisations extends AbstractRealisations implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Realisations() {
	}

	/** minimal constructor */
	public Realisations(Categories categories, Users users, String titre,
			String slug, String description, Timestamp date) {
		super(categories, users, titre, slug, description, date);
	}

	/** full constructor */
	public Realisations(Categories categories, Users users, String titre,
			String slug, String description, Timestamp date,
			Set<Commentaires> commentaireses) {
		super(categories, users, titre, slug, description, date, commentaireses);
	}

}

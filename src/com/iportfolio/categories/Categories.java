package com.iportfolio.categories;

import com.iportfolio.users.*;
import com.iportfolio.categories.*;
import com.iportfolio.commentaires.*;
import com.iportfolio.realisations.*;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Categories entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "categories", catalog = "portfodb")
public class Categories extends AbstractCategories implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Categories() {
	}

	/** minimal constructor */
	public Categories(String nom, String slug, Integer idParent) {
		super(nom, slug, idParent);
	}

	/** full constructor */
	public Categories(String nom, String slug, Integer idParent,
			Set<Realisations> realisationses) {
		super(nom, slug, idParent, realisationses);
	}

}

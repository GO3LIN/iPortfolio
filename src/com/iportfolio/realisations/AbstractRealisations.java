package com.iportfolio.realisations;


import com.iportfolio.users.*;
import com.iportfolio.categories.*;
import com.iportfolio.commentaires.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractRealisations entity provides the base persistence definition of the
 * Realisations entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractRealisations implements java.io.Serializable {

	// Fields

	private Integer id;
	private Categories categories;
	private Users users;
	private String titre;
	private String slug;
	private String description;
	private Timestamp date;
	private Set<Commentaires> commentaireses = new HashSet<Commentaires>(0);

	// Constructors

	/** default constructor */
	public AbstractRealisations() {
	}

	/** minimal constructor */
	public AbstractRealisations(Categories categories, Users users,
			String titre, String slug, String description, Timestamp date) {
		this.categories = categories;
		this.users = users;
		this.titre = titre;
		this.slug = slug;
		this.description = description;
		this.date = date;
	}

	/** full constructor */
	public AbstractRealisations(Categories categories, Users users,
			String titre, String slug, String description, Timestamp date,
			Set<Commentaires> commentaireses) {
		this.categories = categories;
		this.users = users;
		this.titre = titre;
		this.slug = slug;
		this.description = description;
		this.date = date;
		this.commentaireses = commentaireses;
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
	@JoinColumn(name = "idCat", nullable = false)
	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "titre", nullable = false, length = 50)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(name = "slug", nullable = false, length = 50)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "date", nullable = false, length = 19)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "realisations")
	public Set<Commentaires> getCommentaireses() {
		return this.commentaireses;
	}

	public void setCommentaireses(Set<Commentaires> commentaireses) {
		this.commentaireses = commentaireses;
	}

}
package com.iportfolio.model.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractCategories entity provides the base persistence definition of the
 * Categories entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractCategories implements java.io.Serializable {

	// Fields

	private Integer id;
	private String nom;
	private String slug;
	private Integer idParent;
	private Set<Realisations> realisationses = new HashSet<Realisations>(0);

	// Constructors

	/** default constructor */
	public AbstractCategories() {
	}

	/** minimal constructor */
	public AbstractCategories(String nom, String slug, Integer idParent) {
		this.nom = nom;
		this.slug = slug;
		this.idParent = idParent;
	}

	/** full constructor */
	public AbstractCategories(String nom, String slug, Integer idParent,
			Set<Realisations> realisationses) {
		this.nom = nom;
		this.slug = slug;
		this.idParent = idParent;
		this.realisationses = realisationses;
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

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "slug", nullable = false, length = 50)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Column(name = "idParent", nullable = false)
	public Integer getIdParent() {
		return this.idParent;
	}

	public void setIdParent(Integer idParent) {
		this.idParent = idParent;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Realisations> getRealisationses() {
		return this.realisationses;
	}

	public void setRealisationses(Set<Realisations> realisationses) {
		this.realisationses = realisationses;
	}

}
package com.redesocial.RedeSocial.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Marilia Muniz
 * @author Arthur Leandro
 * @since 1.0
 *
 */

@Entity
@Table(name = "tb_post")
public class PostModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPost;

	@NotBlank
	@Size(min = 5, max = 500)
	private String title;

	@NotBlank
	@Size(min = 5, max = 1000)
	private String descriptionPost;

	@NotBlank
	@Size(min = 5, max = 500)
	private String archive;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("post")
	private ThemeModel fkTheme;

	@ManyToOne
	@JsonIgnoreProperties("user")
	private UserModel fkUser;

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptionPost() {
		return descriptionPost;
	}

	public void setDescriptionPost(String descriptionPost) {
		this.descriptionPost = descriptionPost;
	}

	public String getArchive() {
		return archive;
	}

	public void setArchive(String archive) {
		this.archive = archive;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ThemeModel getFkTheme() {
		return fkTheme;
	}

	public void setFkTheme(ThemeModel fkTheme) {
		this.fkTheme = fkTheme;
	}

	public UserModel getFkUser() {
		return fkUser;
	}

	public void setFkUser(UserModel fkUser) {
		this.fkUser = fkUser;
	}

}

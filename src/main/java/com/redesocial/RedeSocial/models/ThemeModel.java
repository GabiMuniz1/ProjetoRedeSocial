package com.redesocial.RedeSocial.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Laiane Karla
 * @author Arthur Leandro
 * @since 1.0
 * 
 */

@Entity
@Table(name = "tb_theme")
public class ThemeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTheme;

	@NotBlank
	@Size(min = 5, max = 100)
	private String name;

	@NotBlank
	@Size(min = 5, max = 500)
	private String descriptionTheme;

	@OneToMany(mappedBy = "fkTheme", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("fkTheme")
	private List<PostModel> post;

	public Long getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(Long idTheme) {
		this.idTheme = idTheme;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescriptionTheme() {
		return descriptionTheme;
	}

	public void setDescriptionTheme(String descriptionTheme) {
		this.descriptionTheme = descriptionTheme;
	}

	public List<PostModel> getPost() {
		return post;
	}

	public void setPost(List<PostModel> post) {
		this.post = post;
	}

}
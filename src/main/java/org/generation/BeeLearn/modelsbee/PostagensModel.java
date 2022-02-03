 package org.generation.BeeLearn.modelsbee;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tbl_postagens")
public class PostagensModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPostagem;
	
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@NotNull
	@Size (max = 200)
	private String titulo;

	@NotNull
	@Size (max = 200)
	private String postagem;
	
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private GrupoModels grupo;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private UserModel user;
	
	
	
	public void setIdPostagem(Long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPostagem() {
		return postagem;
	}

	public void setPostagem(String postagem) {
		this.postagem = postagem;
	}

	public GrupoModels getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoModels grupo) {
		this.grupo = grupo;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Long getIdPostagem() {
		return idPostagem;
	}


	
	
	
}

	
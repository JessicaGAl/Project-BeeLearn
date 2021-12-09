package org.generation.BeeLearn.modelsbee;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private long id;
	
	@NotNull
	@Size (max = 200)
	private String postagem;
	
	@ManyToOne
	@JsonIgnoreProperties("PostagensModel")
	@JoinColumn(name = "id_grupo", foreignKey = @ForeignKey(name="FK_postagem_grupo"))
	private GrupoModels grupo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
	
}

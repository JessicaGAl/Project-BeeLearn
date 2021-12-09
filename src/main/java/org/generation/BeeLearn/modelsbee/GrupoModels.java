package org.generation.BeeLearn.modelsbee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_grupos")
public class GrupoModels {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @NotBlank Long idGrupo;
	private @NotBlank String nomeGrupo;
	private @NotBlank String descricao;
	private @NotBlank String urlImagem;
	
	@ManyToOne
	@JsonIgnoreProperties("GrupoModels")
	@JoinColumn(name = "id_instrutor")
	private InstrutorModel instrutor;
	
	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("GrupoModels")
	private List<PostagensModel> postagem = new ArrayList<>();

	
	
	

	

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public InstrutorModel getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(InstrutorModel instrutor) {
		this.instrutor = instrutor;
	}

	public List<PostagensModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagensModel> postagem) {
		this.postagem = postagem;
	}
	
	

}

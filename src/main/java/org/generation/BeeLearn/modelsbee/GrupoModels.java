package org.generation.BeeLearn.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_grupos")
public class GrupoModels {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @NotBlank Long idGrupo;
	private @NotBlank String nomeGrupo;
	private @NotBlank String descricao;
	private @NotBlank String urlImagem;
	private @NotBlank Long tblIntrutorIdInstrutor;

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

	public Long getTblIntrutorIdInstrutor() {
		return tblIntrutorIdInstrutor;
	}

	public void setTblIntrutorIdInstrutor(Long tblIntrutorIdInstrutor) {
		this.tblIntrutorIdInstrutor = tblIntrutorIdInstrutor;
	}

}

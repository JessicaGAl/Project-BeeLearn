package org.generation.BeeLearn.modelsbee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_instrutor")

public class InstrutorModel {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @NotBlank String urlInstrutor;
	private @NotBlank String tituloInstrutor;
	private @NotBlank String bioInstrutor;
	private @NotNull Long nivelInstrutor;
	private @NotNull Long xpInstrutor;

	@OneToOne(mappedBy = "instrutor")
	private UserModel userIns;

	@OneToMany(mappedBy = "instrutor", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("InstrutorModel")
	private List<GrupoModels> grupo = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserModel getUserIns() {
		return userIns;
	}

	public void setUserIns(UserModel userIns) {
		this.userIns = userIns;
	}

	public List<GrupoModels> getGrupo() {
		return grupo;
	}

	public void setGrupo(List<GrupoModels> grupo) {
		this.grupo = grupo;
	}

	public String getUrlInstrutor() {
		return urlInstrutor;
	}

	public void setUrlInstrutor(String urlInstrutor) {
		this.urlInstrutor = urlInstrutor;
	}

	public String getTituloInstrutor() {
		return tituloInstrutor;
	}

	public void setTituloInstrutor(String tituloInstrutor) {
		this.tituloInstrutor = tituloInstrutor;
	}

	public String getBioInstrutor() {
		return bioInstrutor;
	}

	public void setBioInstrutor(String bioInstrutor) {
		this.bioInstrutor = bioInstrutor;
	}

	public Long getNivelInstrutor() {
		return nivelInstrutor;
	}

	public void setNivelInstrutor(Long nivelInstrutor) {
		this.nivelInstrutor = nivelInstrutor;
	}

	public Long getXpInstrutor() {
		return xpInstrutor;
	}

	public void setXpInstrutor(Long xpInstrutor) {
		this.xpInstrutor = xpInstrutor;
	}

	public void setId(Long id) {
		this.id = id;

	}

}

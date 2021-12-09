package org.generation.BeeLearn.modelsbee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_instrutor")

public class InstrutorModel {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @NotBlank String urlInstrutor;
	private @NotBlank String tituloInstrutor;
	private @NotBlank String bioInstrutor;
	private @NotNull Long nivelInstrutor;
	private @NotNull Long xpInstrutor;

	public Long getId() {
		return id;
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

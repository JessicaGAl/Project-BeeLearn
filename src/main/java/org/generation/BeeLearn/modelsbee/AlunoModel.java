package org.generation.BeeLearn.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


	@Entity
	@Table( name = "tbl_aluno")
	public class AlunoModel {
	
	@Id
	@GeneratedValue
	(strategy = GenerationType.IDENTITY)
	private long id;	
	
	
	
	@NotNull
	@Column(name = "url_avatar")
	@Size (min = 5, max = 200 )
	private String avatar;
	
	@NotNull
	@Column(name = "bio_aluno")
	@Size (min = 5, max = 45 )
	private String bio;
	
	@NotNull
	@Column(name = "titulo_aluno")
	@Size (min = 5, max = 60 )
	private String titulo;
	
	@NotNull
	@Column(name = "xp_aluno")
	private int xp;
	
	@NotNull
	@Column(name = "nivel_aluno")
	private int nivel;


	
	
	public long getId() {
	return id;

}
	public void setId(long id) {
	this.id = id;
}	
	public String getAvatar() {
	return avatar;
}
	public void setAvatar(String avatar) {
	this.avatar = avatar;
}
	public String getBio() {
	return bio;
}
	public void setBio(String bio) {
	this.bio = bio;
}
	public String getTitulo() {
	return titulo;
}
	public void setTitulo(String titulo) {
	this.titulo = titulo;
}
	public int getXp() {
	return xp;
}
	public void setXp(int xp) {
	this.xp = xp;
}
	public int getNivel() {
	return nivel;
}
	public void setNivel(int nivel) {
	this.nivel = nivel;
}



}
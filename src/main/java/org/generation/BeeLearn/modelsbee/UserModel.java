package org.generation.BeeLearn.modelsbee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Biblioteca e Método @Entity utlizado para info e persistêcia no banco de
 * dados; Biblioteca e Método @Table para nomear e definir a tabela; Biblioteca
 * e Método @Size para limitar; Biblioteca e Método @NotBlank para não aceita
 * valor nulo e sem caracter; Biblioteca e Getters e Setters para indicar e
 * adicionar classes private; Biblioteca e Método @GeneratedValue gerar valores
 * automaticamente; Biblioteca e Método @Id valor criado para indivualmente para
 * identidade do usuário(chave primária); Id, nome, e-mail e senha são atributos
 * em comum da primeira classe para criação de usuário no projeto.
 * 
 * @author Jéssica Gomes
 * @since 1.0
 */

@Entity
@Table(name = "tbl_usuário")

public class UserModel {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUsuario;
	private @Size(min = 3, max = 50) String nomeUsuario;
	private @Email @NotBlank String email;
	private @NotBlank String senha;
	private String bio;
	private String urlAvatar;
	private Long nivel;
	private Long xp;
	private String token;
	private String tokenBasic;
	private String foto;
	private String tipo;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("UserModels")
	private List<PostagensModel> postagem;
	
	

	public String getTokenBasic() {
		return tokenBasic;
	}

	public void setTokenBasic(String tokenBasic) {
		this.tokenBasic = tokenBasic;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getUrlAvatar() {
		return urlAvatar;
	}

	public void setUrlAvatar(String urlAvatar) {
		this.urlAvatar = urlAvatar;
	}

	public Long getNivel() {
		return nivel;
	}

	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}

	public Long getXp() {
		return xp;
	}

	public void setXp(Long xp) {
		this.xp = xp;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<PostagensModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagensModel> postagem) {
		this.postagem = postagem;
	}
	
	

}

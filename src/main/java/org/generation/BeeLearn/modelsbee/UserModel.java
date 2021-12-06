package org.generation.BeeLearn.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



/**
 * Biblioteca e Método @Entity utlizado para info e persistêcia no banco de dados;
 * Biblioteca e Método @Table para nomear e definir a tabela;
 * Biblioteca e Método @Size para limitar;
 * Biblioteca e Método @NotBlank para não aceita valor nulo e sem caracter;
 * Biblioteca e Getters e Setters para indicar e adicionar classes private;
 * Biblioteca e Método @GeneratedValue gerar valores automaticamente;
 * Biblioteca e Método @Id valor criado para indivualmente para identidade do usuário(chave primária);
 * Id, nome, e-mail e senha são atributos em comum da primeira classe para criação de usuário no projeto.
 * 
 * @author Jéssica Gomes
 * @since 1.0
 */



	@Entity
	@Table(name = "tbl_usuário")
	
	public class UserModel {
		 
		
		private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int id_usuario;		
		private @NotBlank @Size (min = 3, max = 50)  String nome;
		private @Size (min = 5, max = 100) @Email String email;
		private @Size (min = 5, max = 45) @NotBlank  String senha;
		
		
		public int getId_usuario() {
			return id_usuario;
		}
		public void setId_usuario(int id_usuario) {
			this.id_usuario = id_usuario;
		}
		
		
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
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
	    
		
		

}

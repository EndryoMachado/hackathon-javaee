package com.stefanini.entity;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_usuario")
    private Long idUsuario;
    
    @NotBlank(message = "Nome não pode ser nulo ou vazio")
    @Size(max = 50, message = "Nome possui um limite de 50 caracteres")
    @Column(name = "nome_usuario")
    private String nome;
    
    @NotBlank(message = "Login não pode ser nulo ou vazio")
    @Size(min = 5, max = 20, message = "Login deve ter ter entre 5 e 20 caracteres")
    @Column(name = "login_usuario", unique = true)
    private String login;
    
    @NotBlank(message = "Email não pode ser nulo ou vazio")
    @Email(message = "Email deve ser válido")
    @Size(min = 10, message = "Email possui um valor minimo de 10 caracteres")
    @Column(name = "email_usuario")
    private String email;
    
    @NotBlank(message = "Senha não pode ser nula ou vazia")
    @Column(name = "senha_usuario")
    private String senha;
    
    @NotNull(message = "Data de nascimento não pode ser nula ou vazia")
    @PastOrPresent(message = "Data de nascimento deve ser válida")
    @Column(name = "dt_nascimento_usuario")
    private LocalDate dtNascimeto;
    
    
    
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public LocalDate getDtNascimeto() {
		return dtNascimeto;
	}

	public void setDtNascimeto(LocalDate dtNascimeto) {
		this.dtNascimeto = dtNascimeto;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
}

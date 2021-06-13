package projeto.zup.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import projeto.zup.model.Usuario;

public class UsuarioRequest {

	@NotBlank(message = "Inserção Inválida")
	private String nome;
	@NotBlank(message = "Inserção Inválida")
	private String email;
	@NotBlank(message = "Inserção Inválida")
	private String cpf;
	@NotNull(message = "O campo dataNasc não pode ser nulo")
	private Date dataNasc;
	
	public UsuarioRequest(String nome, String email, String cpf, Date dataNasc) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Usuario toModel() {
		return new Usuario (nome, email, cpf, dataNasc);
	}
}

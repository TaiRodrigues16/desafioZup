package projeto.zup.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "dataNasc", nullable = false)
	private Date dataNasc;
	
	@OneToMany
	private List<Veiculos> veiculos;
	
	public void setVeiculos(Veiculos veiculos) {
		this.veiculos.add(veiculos);
	}

	public List<Veiculos> getVeiculos() {
		return veiculos;
	}
	
	@Deprecated
	public Usuario() {}

	public Usuario(String nome, String email, String cpf, Date dataNasc) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", dataNasc=" + dataNasc
				+ ", veiculos=" + veiculos + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
}

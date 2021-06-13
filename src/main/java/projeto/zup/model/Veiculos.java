package projeto.zup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(name = "ano_modelo", nullable = false)
	private String anoModelo;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String valor;
	
	private String codigoMarca;
	private String codigoModelo;
	private String codigoAno;
	private String diaRodizio;
	private Boolean rodizioAtivo;
	
	@Deprecated
	public Veiculos() {}
	
	public Veiculos(String marca, String anoModelo, String modelo, String valor, String codigoMarca, String codigoModelo,
			String codigoAno, String diaRodizio, Boolean rodizioAtivo) {
		super();
		this.marca = marca;
		this.anoModelo = anoModelo;
		this.modelo = modelo;
		this.valor = valor;
		this.codigoMarca = codigoMarca;
		this.codigoModelo = codigoModelo;
		this.codigoAno = codigoAno;
		this.diaRodizio = diaRodizio;
		this.rodizioAtivo = rodizioAtivo;
	}

	@Override
	public String toString() {
		return "Veiculos [marca=" + marca + ", anoModelo=" + anoModelo + ", modelo=" + modelo + ", valor=" + valor
				+ ", diaRodizio="+ diaRodizio + ", rodizioAtivo=" + rodizioAtivo +" ]";
	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public String getModelo() {
		return modelo;
	}

	public String getValor() {
		return valor;
	}

	public String getCodigoMarca() {
		return codigoMarca;
	}

	public String getCodigoModelo() {
		return codigoModelo;
	}

	public String getCodigoAno() {
		return codigoAno;
	}

	public String getDiaRodizio() {
		return diaRodizio;
	}

	public Boolean getRodizioAtivo() {
		return rodizioAtivo;
	}
}

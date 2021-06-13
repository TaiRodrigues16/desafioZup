package projeto.zup.dto;
import javax.validation.constraints.NotBlank;

import projeto.zup.model.Veiculos;

public class VeiculosRequest {
	@NotBlank(message = "Inserção Inválida")
	private String marca;
	@NotBlank(message = "Inserção Inválida")
	private String anoModelo;
	@NotBlank(message = "Inserção Inválida")
	private String modelo;
	@NotBlank(message = "Inserção Inválida")
	private String valor;
	
	private String codigoMarca;
	private String codigoModelo;
	private String codigoAno;
	private String diaRodizio;
	private Boolean rodizioAtivo;
	
	public VeiculosRequest(String marca, String anoModelo, String modelo, String valor) {
		this.marca = marca;
		this.anoModelo = anoModelo;
		this.modelo = modelo;
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(String codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getCodigoModelo() {
		return codigoModelo;
	}

	public void setCodigoModelo(String codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public String getCodigoAno() {
		return codigoAno;
	}

	public void setCodigoAno(String codigoAno) {
		this.codigoAno = codigoAno;
	}

	public String getDiaRodizio() {
		return diaRodizio;
	}

	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}
	
	public Boolean getRodizioAtivo() {
		return rodizioAtivo;
	}

	public void setRodizioAtivo(Boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}

	public Veiculos toModel() {
		return new Veiculos(marca, anoModelo, modelo, valor, codigoMarca, codigoModelo, codigoAno, diaRodizio, rodizioAtivo);
	}
	
}

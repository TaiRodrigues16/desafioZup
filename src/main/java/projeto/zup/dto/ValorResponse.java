package projeto.zup.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

public class ValorResponse {
	String Valor;
	String Marca;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public ValorResponse(String Valor, String Marca){
		this.Valor = Valor;
		this.Marca = Marca;
	}
	
	public String getValor() {
		return Valor;
	}
	public void setValor(String valor) {
		this.Valor = valor;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	
	
}

package projeto.zup.dto;

import projeto.zup.model.Veiculos;

public class VeiculosResponse {
	
	private Veiculos veiculos;
	private String message;
	
	public VeiculosResponse() {	}
	
	public VeiculosResponse(Veiculos veiculos, String message) {
        this.veiculos = veiculos;
        this.message = message;
    }

	public Veiculos getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

package projeto.zup.clientVeiculo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import projeto.zup.dto.AnoResponse;
import projeto.zup.dto.MarcaResponse;
import projeto.zup.dto.ModeloResponse;
import projeto.zup.dto.ValorResponse;

@FeignClient(name = "veiculoClient", url = "https://parallelum.com.br/fipe/api/v1/carros/marcas")
public interface VeiculoClient {
	
	@GetMapping
    List<MarcaResponse> buscaMarca();
	
	@GetMapping("/{codigoMarca}/modelos")
    ModeloResponse buscaModelos(@PathVariable String codigoMarca);
	
	@GetMapping("/{codigoMarca}/modelos/{codigoModelo}/anos")
    List<AnoResponse> buscaAnos(@PathVariable String codigoMarca, @PathVariable String codigoModelo);
	
	@GetMapping("/{codigoMarca}/modelos/{codigoModelo}/anos/{codigoAno}")
    ValorResponse getValor(@PathVariable String codigoMarca, @PathVariable String codigoModelo, @PathVariable String codigoAno);
	
	//urlVeiculo = "https://parallelum.com.br/fipe/api/v1/carros/marcas/{codigoMarca}/modelos/{codigoModelo}/anos/{codigoAno}";
}
package projeto.zup.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import projeto.zup.clientVeiculo.VeiculoClient;
import projeto.zup.dto.AnoResponse;
import projeto.zup.dto.MarcaResponse;
import projeto.zup.dto.ModeloResponseObjeto;
import projeto.zup.dto.ValorResponse;
import projeto.zup.dto.VeiculosRequest;
import projeto.zup.dto.VeiculosResponse;
import projeto.zup.model.Veiculos;
import projeto.zup.repository.VeiculosRepository;

@RestController
@RequestMapping("/controleVeiculos")
public class VeiculosController {
	
	@Autowired
	private VeiculosRepository veiculoRepository;
	
	@Autowired
    private VeiculoClient veiculoClient;
	
	String anoArray[] = new String[2];
	String anoVeiculo = "";
	String diaSemana = "";

	Boolean ativo;
	
	String dayWeek = "";
    GregorianCalendar gc = new GregorianCalendar();
	
	@PostMapping
	public ResponseEntity<VeiculosResponse> adicionar(@RequestBody @Valid VeiculosRequest veiculoRequest) {
		VeiculosResponse response = new VeiculosResponse();
		List<MarcaResponse> marcasResponse = veiculoClient.buscaMarca();
		for (MarcaResponse marcaResponse : marcasResponse) {
			if(marcaResponse.getNome().equals(veiculoRequest.getMarca())) {
				veiculoRequest.setCodigoMarca(marcaResponse.getCodigo());
				break;
			}
		}
		
		List<ModeloResponseObjeto> modelosResponse = veiculoClient.buscaModelos(veiculoRequest.getCodigoMarca()).getModelosResponse();
		for (ModeloResponseObjeto modeloResponse : modelosResponse) {
			if(modeloResponse.getNome().equals(veiculoRequest.getModelo())) {
				veiculoRequest.setCodigoModelo(modeloResponse.getCodigo());
				break;
			}
		}
		
		List<AnoResponse> anosResponse = veiculoClient.buscaAnos(veiculoRequest.getCodigoMarca(), veiculoRequest.getCodigoModelo());
		for (AnoResponse anoResponse : anosResponse) {
			if(anoResponse.getNome().equals(veiculoRequest.getAnoModelo())) {
				veiculoRequest.setCodigoAno(anoResponse.getCodigo());
				break;
			}
		}
		
		ValorResponse valorResponse = veiculoClient.getValor(veiculoRequest.getCodigoMarca(), veiculoRequest.getCodigoModelo(), veiculoRequest.getCodigoAno());
		veiculoRequest.setValor(valorResponse.getValor());
		
		anoArray = veiculoRequest.getAnoModelo().split(" ");
		anoVeiculo = anoArray[0];
		
		if (anoVeiculo.charAt(3) == '0' || anoVeiculo.charAt(3) == '1') {
			diaSemana = "Segunda-Feira";
		}
		else if(anoVeiculo.charAt(3) == '2' || anoVeiculo.charAt(3) == '3') {
			diaSemana = "Terça-Feira";
		}
		else if(anoVeiculo.charAt(3) == '4' || anoVeiculo.charAt(3) == '5') {
			diaSemana = "Quarta-Feira";
		}
		else if(anoVeiculo.charAt(3) == '6' || anoVeiculo.charAt(3) == '7') {
			diaSemana = "Quinta-Feira";
		}
		else if(anoVeiculo.charAt(3) == '8' || anoVeiculo.charAt(3) == '9') {
			diaSemana = "Sexta-Feira";
		}
		veiculoRequest.setDiaRodizio(diaSemana);
		
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
            dayWeek = "Domingo";
            if(veiculoRequest.getDiaRodizio().equals(dayWeek)) {
            	ativo = true;
            }else {
            	ativo = false;
            }
            break;
        case Calendar.MONDAY:
            dayWeek = "Segunda-Feira";
            if(veiculoRequest.getDiaRodizio().equals(dayWeek)) {
            	ativo = true;
            }else {
            	ativo = false;
            }
            break;
        case Calendar.TUESDAY:
            dayWeek = "Terça-Feira";
            if(veiculoRequest.getDiaRodizio().equals(dayWeek)) {
            	ativo = true;
            }else {
            	ativo = false;
            }
        break;
        case Calendar.WEDNESDAY:
            dayWeek = "Quarta-Feira";
            if(veiculoRequest.getDiaRodizio().equals(dayWeek)) {
            	ativo = true;
            }else {
            	ativo = false;
            }
            break;
        case Calendar.THURSDAY:
            dayWeek = "Quinta-Feira";
            if(veiculoRequest.getDiaRodizio().equals(dayWeek)) {
            	ativo = true;
            }else {
            	ativo = false;
            }
            break;
        case Calendar.FRIDAY:
            dayWeek = "Sexta-Feira";
            if(veiculoRequest.getDiaRodizio().equals(dayWeek)) {
            	ativo = true;
            }else {
            	ativo = false;
            }
            break;
        case Calendar.SATURDAY:
            dayWeek = "Sábado";
            if(veiculoRequest.getDiaRodizio().equals(dayWeek)) {
            	ativo = true;
            }else {
            	ativo = false;
            }
            break;
		default:
			break;
		}
		veiculoRequest.setRodizioAtivo(ativo);
		
		var newVeiculo = veiculoRepository.save(veiculoRequest.toModel());
		response.setVeiculos(newVeiculo);
		response.setMessage("Success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
    
	@GetMapping("{id}")
	public Veiculos getById(@PathVariable Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O veículo não foi encontrado, tente outra vez! :)"));
    }
	
	@GetMapping
	public List<Veiculos> listar() {
		return veiculoRepository.findAll();
	}
	

}


package projeto.zup.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import projeto.zup.dto.UsuarioRequest;
import projeto.zup.dto.UsuarioResponse;
import projeto.zup.dto.UsuarioVeiculoRequest;
import projeto.zup.model.Usuario;
import projeto.zup.model.Veiculos;
import projeto.zup.repository.UsuarioRepository;
import projeto.zup.repository.VeiculosRepository;


@RestController
@RequestMapping("/controleUsuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VeiculosRepository veiculoRepository;
	
	String query;
	
	@GetMapping("{id}")
	public Usuario getById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "o usuário solicitado não foi encontrado, tente outra vez! :)"));
    }
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<UsuarioResponse> adicionar(@Valid @RequestBody UsuarioRequest usuarioRequest) {
		
		Optional<Usuario> cpf = usuarioRepository.findUsuarioByCpf(usuarioRequest.getCpf());
	    Optional<Usuario> email = usuarioRepository.findUsuarioByEmail(usuarioRequest.getEmail());
	    UsuarioResponse response = new UsuarioResponse();
	    
	    if(cpf.isPresent() || email.isPresent()){
	        if (cpf.isPresent() && email.isPresent()) {
	            response.setMessage("E-mail e CPF precisam ser únicos. No sistema já consta um cadastro com estes dados :)");
	        } else if(cpf.isPresent()) {
	            response.setMessage("CPF precisa ser único. No sistema já consta um cadastro com este CPF.");
	        } else if(email.isPresent()) {
	            response.setMessage("E-mail precisa ser único. No sistema já consta um cadastro com este E-mail.");
	        }
	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    }
	    else{
	    	var newUsuario = usuarioRepository.save(usuarioRequest.toModel());
			response.setUsuario(newUsuario);
			response.setMessage("Success");
	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    }
	}
	
	@PutMapping
	public ResponseEntity<?> adicionarVeiculo(@RequestBody UsuarioVeiculoRequest usuarioVeiculoRequest) {
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioVeiculoRequest.getIdUsuario());
		if(usuario == null) {
			return ResponseEntity.status(400).build();
		}
		Optional<Veiculos> veiculo = veiculoRepository.findById(usuarioVeiculoRequest.getIdVeiculo());
		if(veiculo == null) {
			return ResponseEntity.status(400).build();
		}
		
		usuario.get().setVeiculos(veiculo.get());
		
		usuarioRepository.save(usuario.get());
		
		return ResponseEntity.status(204).build();
	}
	
}

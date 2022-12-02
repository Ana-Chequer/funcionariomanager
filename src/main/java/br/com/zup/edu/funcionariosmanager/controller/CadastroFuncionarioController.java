package br.com.zup.edu.funcionariosmanager.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.funcionariosmanager.model.Funcionario;
import br.com.zup.edu.funcionariosmanager.repository.FuncionarioRepository;

@RestController
public class CadastroFuncionarioController {
	
	private final FuncionarioRepository funcionarioRepository;

	public CadastroFuncionarioController(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	@PostMapping("/funcionarios")
	public ResponseEntity<?> cadastrarFuncionario(@RequestBody @Valid FuncionarioRequest funcionarioRequest, 
			UriComponentsBuilder uriComponentsBuilder) {
		
		Funcionario funcionario = funcionarioRequest.paraFuncionario();
		
		funcionarioRepository.save(funcionario);
		
		URI location = uriComponentsBuilder.path("/funcionarios/{id}")
				.buildAndExpand(funcionario.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}

}

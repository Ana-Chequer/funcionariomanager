package br.com.zup.edu.funcionariosmanager.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.edu.funcionariosmanager.model.Funcionario;
import br.com.zup.edu.funcionariosmanager.repository.FuncionarioRepository;

@RestController
public class AtualizarSalarioController {
	
	private final FuncionarioRepository funcionarioRepository;

	public AtualizarSalarioController(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	@PatchMapping("/funcionarios/{id}")
	public ResponseEntity<?> atualizarSalario(@PathVariable Long id) {
		
		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "funcionário não cadastrado no sistema"));
		 
		funcionario.calcularReajuste();
		
		funcionarioRepository.save(funcionario);
		
		return ResponseEntity.noContent().build();
		
	}

}

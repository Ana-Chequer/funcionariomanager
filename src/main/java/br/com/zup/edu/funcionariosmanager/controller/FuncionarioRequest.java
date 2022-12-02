package br.com.zup.edu.funcionariosmanager.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.edu.funcionariosmanager.model.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FuncionarioRequest {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String endereco;
	
	@NotNull
	@PastOrPresent
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAdmissao;
	
	@NotNull
	private BigDecimal salario;

	public FuncionarioRequest(String nome, String cpf, String endereco, LocalDate dataAdmissao, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}
	
	public Funcionario paraFuncionario() {
		return new Funcionario(nome, cpf, endereco, dataAdmissao, salario);
	}

}

package br.com.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;

import br.com.spring.data.orm.Funcionario;
import br.com.spring.data.repository.FuncionarioRepository;
import br.com.spring.data.specification.SpecificationFuncionario;

public class RetorioFuncionarioDinamico {

	private final FuncionarioRepository funcionarioRepository;
	
	public RetorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.nome(nome)));
	}
	
}

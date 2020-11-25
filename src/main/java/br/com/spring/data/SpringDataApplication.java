package br.com.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.spring.data.orm.Cargo;
import br.com.spring.data.repository.CargoRepository;
import br.com.spring.data.service.CrudCargosService;
import br.com.spring.data.service.CrudFuncionarioService;
import br.com.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.spring.data.service.RelatoriosServices;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargosService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosServices relatorioservice;

	private Boolean system = true;

	public SpringDataApplication(CrudCargosService cargoService, CrudFuncionarioService funcionarioService,
			CrudUnidadeTrabalhoService unidadeTrabalhoService, RelatoriosServices relatorioservice) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioservice = relatorioservice;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual açao você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade Trabalho");
			System.out.println("4 - Relatorios da aplicação");

			Integer function = scanner.nextInt();

			switch (function) {
			case 1:
				cargoService.inicial(scanner);
				break;
			case 2:
				funcionarioService.inicial(scanner);
				break;
			case 3:
				unidadeTrabalhoService.inicial(scanner);
				break;
			case 4:
				relatorioservice.inicial(scanner);
				break;
			default:
				System.out.println("Finalizando");
				system = false;
				break;

			}

		}
	}
}

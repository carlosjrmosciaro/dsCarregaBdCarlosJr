package carregabanco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import carregabanco.controller.CarregaBancoController;
import carregabanco.model.AlunoModel;
import carregabanco.repository.AlunoDao;
import carregabanco.view.CarregaBancoView;

public class CarregaBanco {
	public static void main(String[] args) {

		// AlunoModel alunoModel = AlunoDao.getInstance().getById(1);
		AlunoModel alunoModel = new AlunoModel();
		AlunoDao alunoDao = AlunoDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		String nome, campus, coordenacao, curso, email, periodo, polo, sexo, situacao;
		int idade;
		boolean valido = true;

		while (opcao != 6) {
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Adicionar aluno");
			System.out.println("2 - Listar alunos");
			System.out.println("3 - Editar aluno");
			System.out.println("4 - Buscar aluno");
			System.out.println("5 - Excluir aluno");
			System.out.println("6 - Sair");

			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:

				System.out.println("Digite o nome:");

				nome = scanner.next();

				System.out.println("Digite a idade:");

				idade = scanner.nextInt();

				System.out.println("Digite o email:");
				email = scanner.next();

				System.out.println("Digite o campus:");
				campus = scanner.next();

				System.out.println("Digite a coordenação:");
				coordenacao = scanner.next();

				System.out.println("Digite o curso:");
				curso = scanner.next();

				System.out.println("Digite o periodo de entrada:");
				periodo = scanner.next();

				System.out.println("Digite o polo:");
				polo = scanner.next();

				System.out.println("Digite o sexo:");
				sexo = scanner.next();

				System.out.println("Digite a situação:");
				situacao = scanner.next();

				if (valido == false) {
					System.out.println("Alguma informação foi colocada de forma errada tente novamente!");
					break;
				} else {

					alunoModel.setNome_estudante(nome);
					alunoModel.setIdade(idade);
					alunoModel.setCampus(campus);
					alunoModel.setCoordenacao(coordenacao);
					alunoModel.setCurso(curso);
					alunoModel.setEmail_institucional(email);
					alunoModel.setPeriodo_entrada(periodo);
					alunoModel.setPolo(polo);
					alunoModel.setSexo(sexo);
					alunoModel.setSituacao(situacao);

					alunoDao.persist(alunoModel);

					System.out.println("Contato adicionado com sucesso!");
				}

				break;

			case 2:

				List<AlunoModel> alunos = alunoDao.findAll();

				for (AlunoModel aluno : alunos) {
					System.out
							.println(aluno.getCampus() + " - " + aluno.getNome_estudante() + " - " + aluno.getIdade());
				}

				break;

			case 3:

				// Pede para o usuário inserir o ID do registro a ser atualizado
				System.out.println("Insira o ID do aluno a ser atualizado:");
				int id = scanner.nextInt();
				// Consulta o registro pelo ID
				AlunoModel aluno = alunoDao.getById(id);
				if (aluno == null) {
					System.out.println("aluno não encontrado!");
				} else {
					System.out.println("Digite o nome:");

					nome = scanner.next();

					System.out.println("Digite a idade:");

					idade = scanner.nextInt();

					System.out.println("Digite o email:");
					email = scanner.next();

					System.out.println("Digite o campus:");
					campus = scanner.next();

					System.out.println("Digite a coordenação:");
					coordenacao = scanner.next();

					System.out.println("Digite o curso:");
					curso = scanner.next();

					System.out.println("Digite o periodo de entrada:");
					periodo = scanner.next();

					System.out.println("Digite o polo:");
					polo = scanner.next();

					System.out.println("Digite o sexo:");
					sexo = scanner.next();

					System.out.println("Digite a situação:");
					situacao = scanner.next();

					if (valido == false) {
						System.out.println("Alguma informação foi colocada de forma errada tente novamente!");
						break;
					} else {

						alunoModel.setNome_estudante(nome);
						alunoModel.setIdade(idade);
						alunoModel.setCampus(campus);
						alunoModel.setCoordenacao(coordenacao);
						alunoModel.setCurso(curso);
						alunoModel.setEmail_institucional(email);
						alunoModel.setPeriodo_entrada(periodo);
						alunoModel.setPolo(polo);
						alunoModel.setSexo(sexo);
						alunoModel.setSituacao(situacao);

						// Atualiza o registro com os novos valores

						alunoDao.merge(alunoModel);

					}
				}
				break;

			case 4:

				// Pede para o usuário inserir o ID do registro a ser atualizado
				System.out.println("Insira o ID do aluno a ser atualizado:");
				int idBusca = scanner.nextInt();
				// Consulta o registro pelo ID
				AlunoModel alunoBusca = alunoDao.getById(idBusca);
				if (alunoBusca == null) {
					System.out.println("aluno não encontrado!");
				} else {
					System.out.println(alunoBusca.getCampus() + " - " + alunoBusca.getNome_estudante() + " - "
							+ alunoBusca.getIdade());
				}
				break;
			case 5:

				// Pede para o usuário inserir o ID do registro a ser excluído
				System.out.println("Insira o ID do aluno a ser deletado:");
				int idDelete = scanner.nextInt();
				// Chama a função para excluir o registro pelo ID
				alunoDao.removeById(idDelete);
				break;

			case 6:
				System.out.println("Saindo...");
			}

		}

		/*
		 * new CarregaBancoView();
		 * 
		 * CarregaBancoController controller = new CarregaBancoController();
		 * 
		 * ArrayList<AlunoModel> valores = controller.loader("alunostads.csv");
		 * 
		 * controller.inserirNoBanco(valores);
		 */

	}

}

package aplicacao;

import java.util.Scanner;
import dao.UsuarioDAO;

import model.Usuario;

public class MainUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		Scanner s = new Scanner(System.in);

		int opcao = 0, id = 0;

		String nome, email, senha, cpf, endereco, telefone;

		do {

			System.out.println("\n============================== USUARIOS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o CPF:");
				cpf = s.nextLine();
				System.out.println("Digite o endereço:");
				endereco = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o Telefone:");
				telefone = s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();

				Usuario usuario1 = new Usuario(nome, cpf, endereco, email, telefone, senha);

				usuarioDAO.create(usuario1);
				break;
			case 2:

				for (Usuario u : usuarioDAO.read()) {
					u.mostrar();
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o CPF:");
				cpf = s.nextLine();
				System.out.println("Digite o endereço:");
				endereco = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o Telefone:");
				telefone = s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();

				Usuario usuario2 = new Usuario(id, nome, cpf, endereco, email, telefone, senha);

				usuarioDAO.update(usuario2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				usuarioDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Usuario usuario3 = usuarioDAO.readById(id);

				usuario3.mostrar();
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}

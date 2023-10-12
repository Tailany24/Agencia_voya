package aplicacao;

import java.util.Scanner;

import dao.DestinoDAO;
import dao.PromocoesDAO;
import dao.UsuarioDAO;
import model.Destino;
import model.Promocoes;
import model.Usuario;

public class MainPromocoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		PromocoesDAO promocoesDAO = new PromocoesDAO();

		Scanner s = new Scanner(System.in);

		int opcao = 0, id = 0;

		String descricao;
		int id_destino, id_usuario;
		float preco;
		do {

			System.out.println("\n============================== PROMOÇÕES =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Descrição:");
				descricao = s.nextLine();
				System.out.println("Preço:");
				preco = s.nextFloat();
				System.out.println("Destino:");
				id_destino = s.nextInt();
				System.out.println("Usuario:");
				id_usuario = s.nextInt();

				Usuario usuario = usuarioDAO.readById(id_usuario);
				Destino destino = destinoDAO.readById(id_destino);
				Promocoes promocoes = new Promocoes(descricao, preco, destino, usuario);

				promocoesDAO.create(promocoes);
				break;
			case 2:

				for (Promocoes p : promocoesDAO.read()) {
					p.mostrar();
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Descrição:");
				descricao = s.nextLine();
				System.out.println("Preço:");
				preco = s.nextFloat();
				System.out.println("Destino:");
				id_destino = s.nextInt();
				System.out.println("Usuario:");
				id_usuario = s.nextInt();
				Usuario usuario1 = usuarioDAO.readById(id_usuario);
				Destino destino1 = destinoDAO.readById(id_destino);

				Promocoes promocoes2 = new Promocoes(id, descricao, preco, destino1, usuario1);

				promocoesDAO.update(promocoes2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				promocoesDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Promocoes promocoes3 = promocoesDAO.readById(id);

				promocoes3.mostrar();
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}

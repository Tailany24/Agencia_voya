package aplicacao;

import java.util.Date;
import java.util.Scanner;

import dao.DestinoDAO;

import model.Destino;

public class MainDestino {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DestinoDAO destinoDAO = new DestinoDAO();

		Scanner s = new Scanner(System.in);

		int opcao = 0, id = 0;

		String formas_de_pagamento, destino_da_viagem;

		do {

			System.out.println("\n============================== DESTINO =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Formas de pagamento:");
				formas_de_pagamento = s.nextLine();
				System.out.println("Destino da viagem:");
				destino_da_viagem = s.nextLine();

				Destino destino = new Destino(formas_de_pagamento, destino_da_viagem, new Date(), new Date());

				destinoDAO.create(destino);
				break;
			case 2:

				for (Destino d : destinoDAO.read()) {
					d.mostrar();
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Formas de pagamento:");
				formas_de_pagamento = s.nextLine();
				System.out.println("Destino da viagem:");
				destino_da_viagem = s.nextLine();

				Destino destino2 = new Destino(id, formas_de_pagamento, destino_da_viagem, new Date(), new Date());

				destinoDAO.update(destino2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				destinoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Destino destino3 = destinoDAO.readById(id);

				destino3.mostrar();
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}
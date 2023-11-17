package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

@WebServlet(urlPatterns = { "/destino", "/destino-delete", "/destino-create", "/destino-edit", "/destino-update" })
public class DestinoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	DestinoDAO destinoDao = new DestinoDAO();
	Destino destinos = new Destino();

	public DestinoServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();// guarda a busca da url
		switch (action) { // de acordo com a rota eu executo um método
		case "/destino": // rota é chamada através de um link no index.html
			read(request, response);
			break;
		case "/destino-delete": // rota é chamada através de um button no index.jsp
			delete(request, response);
			break;
		case "/destino-create":
			create(request, response);
			break;
		case "/destino-edit":
			edit(request, response);
			break;
		case "/destino-update":
			update(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Destino> lista = destinoDao.read();
		request.setAttribute("listadestino", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/destino.jsp");
		rd.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		destinoDao.delete(id);
		
		response.sendRedirect("./destino"); // retorna novamente para a rota de clientes após deletar para reccarregar
											// as informações
	}

	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String formaPagamento = request.getParameter("formas_de_pagamento");
    String destinoViagem = request.getParameter("destino_da_viagem");

    String dataIdaStr = request.getParameter("data_de_ida");
    String dataVoltaStr = request.getParameter("data_de_volta");

    Date dataIda = null;
    Date dataVolta = null;

    try {
        if (dataIdaStr != null && !dataIdaStr.isEmpty()) {
            dataIda = new SimpleDateFormat("yyyy-MM-dd").parse(dataIdaStr);
        }

        if (dataVoltaStr != null && !dataVoltaStr.isEmpty()) {
            dataVolta = new SimpleDateFormat("yyyy-MM-dd").parse(dataVoltaStr);
        }
    } catch (ParseException e) {
        e.printStackTrace();
        return;
    }

    Destino novoDestino = new Destino();
    novoDestino.setFormas_de_pagamento(formaPagamento);
    novoDestino.setDestino_da_viagem(destinoViagem);
    novoDestino.setData_de_ida(dataIda);
    novoDestino.setData_de_volta(dataVolta);

    destinoDao.create(novoDestino);

    response.sendRedirect("destino");
}


	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		destinos = destinoDao.readById(id);

		request.setAttribute("destino", destinos);

		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/Edit.jsp");
		rd.forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String formasDePagamento = request.getParameter("formas_de_pagamento");
		String destinoDaViagem = request.getParameter("destino_da_viagem");

		String dataDeIdaStr = request.getParameter("data_de_ida");
		Date dataDeIda = null;
		if (dataDeIdaStr != null && !dataDeIdaStr.isEmpty()) {
			try {
				SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
				dataDeIda = formatoData.parse(dataDeIdaStr);
			} catch (ParseException e) {
				e.printStackTrace(); 
			}
		}

		String dataDeVoltaStr = request.getParameter("data_de_volta");
		Date dataDeVolta = null;
		if (dataDeVoltaStr != null && !dataDeVoltaStr.isEmpty()) {
			try {
				SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
				dataDeVolta = formatoData.parse(dataDeVoltaStr);
			} catch (ParseException e) {
				e.printStackTrace(); 
			}
		}

		Destino destinoAtualizado = new Destino();
		destinoAtualizado.setId_destino(id);
		destinoAtualizado.setFormas_de_pagamento(formasDePagamento);
		destinoAtualizado.setDestino_da_viagem(destinoDaViagem);
		destinoAtualizado.setData_de_ida(dataDeIda);
		destinoAtualizado.setData_de_volta(dataDeVolta);

		destinoDao.update(destinoAtualizado);

		RequestDispatcher rd = request.getRequestDispatcher("./destino");
		rd.forward(request, response);
	}
}


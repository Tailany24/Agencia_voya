package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import dao.PromocoesDAO;
import dao.UsuarioDAO;
import model.Destino;
import model.Promocoes;
import model.Usuario;


@WebServlet(urlPatterns = { "/promocao", "/promocao-getCreate", "/promocao-create", "/promocao-update", "/promocao-delete", "/promocao-edit" })
public class PromocaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PromocoesDAO promocoesDao = new PromocoesDAO();
	UsuarioDAO udao = new UsuarioDAO();
	DestinoDAO ddao = new DestinoDAO();
	Promocoes promocoes = new Promocoes();

	public PromocaoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();// guarda a busca da url
		switch (action) { // de acordo com a rota eu executo um método
		case "/promocao": // rota é chamada através de um link no index.html
			read(request, response);
			break;
		case "/promocao-delete": // rota é chamada através de um button no index.jsp
			delete(request, response);
			break;
		case "/promocao-getCreate":
			getCreate(request, response);
			break;
		case "/promocao-create": // rota é chamada através de um button no index.jsp
			create(request, response);
			break;
		case "/promocao-edit": // rota é chamada através de um button no index.jsp
			edit(request, response);
			break;
		case "/promocao-update": // rota é chamada através de um button no index.jsp
			update(request, response);
			break;

		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Promocoes> lista = promocoesDao.read();
		request.setAttribute("listapromocao", lista);// passando a lista para o jsp
		RequestDispatcher rd = request.getRequestDispatcher("./views/promocao/promocao.jsp");
		rd.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		promocoesDao.delete(id);
		;
		response.sendRedirect("promocao"); // retorna novamente para a rota de clientes após deletar para reccarregar
											// as informações
	}
	
	protected void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Destino> listaDestino = ddao.read();
		request.setAttribute("listaDestino", listaDestino);
		
		List<Usuario> listaUsuarios = udao.read();
		request.setAttribute("listaUsuarios", listaUsuarios);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/promocao/createpromocao.jsp");
		rd.forward(request, response);
	}
	
	
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Promocoes novoPromocao = new Promocoes();
		
		Usuario usuario = udao.readById(Integer.parseInt(request.getParameter("usuario")));
		Destino destino = ddao.readById(Integer.parseInt(request.getParameter("destino")));
		
		novoPromocao.setDestino(destino);	
		novoPromocao.setUsuario(usuario);;
		novoPromocao.setDescricao(request.getParameter("descricao"));
		novoPromocao.setPreco(Float.parseFloat(request.getParameter("preco")));
		

		promocoesDao.create(novoPromocao);
		
		response.sendRedirect("promocao");
	
		

		
	}



	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idParameter = request.getParameter("id");

	    if (idParameter != null && !idParameter.isEmpty()) {
	        try {
	            int id = Integer.parseInt(idParameter);
	            promocoes = promocoesDao.readById(id);
	            request.setAttribute("promocao", promocoes);
	        } catch (NumberFormatException e) {
	            // Lidar com o erro de conversão
	            e.printStackTrace(); // Ou use um logger para registrar o erro
	        }
	    }

	    RequestDispatcher rd = request.getRequestDispatcher("./views/promocao/Edit.jsp");
	    rd.forward(request, response);
	}



	protected void update(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    try {
	        // Obtenha os parâmetros da solicitação
	        int id = Integer.parseInt(request.getParameter("id"));
	        String descricao = request.getParameter("descricao");

	        // Converta o valor do preço para float
	        float preco = Float.parseFloat(request.getParameter("preco"));

	        // Atualize os dados no objeto promocoes
	        promocoes.setId(id);
	        promocoes.setDescricao(descricao);
	        promocoes.setPreco(preco);

	        // Atualize os dados no banco de dados
	        promocoesDao.update(promocoes);

	        // Redirecione de volta para a página de promoção após a atualização
	        response.sendRedirect(request.getContextPath() + "/promocao");
	    } catch (NumberFormatException e) {
	        e.printStackTrace();  // Lidar com erro de conversão (por exemplo, se id não for um número)
	        // Adicione lógica adicional conforme necessário
	    }
	}


}


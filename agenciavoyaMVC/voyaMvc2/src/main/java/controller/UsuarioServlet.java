package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet(urlPatterns = { "/usuario", "/usuario-create", "/usuario-update", "/usuario-delete", "/usuario-edit" })
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDao = new UsuarioDAO();
	Usuario usuarios = new Usuario();

	public UsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();// guarda a busca da url
		switch (action) { // de acordo com a rota eu executo um método
		case "/usuario": // rota é chamada através de um link no index.html
			read(request, response);
			break;
		case "/usuario-delete": // rota é chamada através de um button no index.jsp
			delete(request, response);
			break;
		case "/usuario-create": // rota é chamada através de um button no index.jsp
			create(request, response);
			break;
		case "/usuario-edit": // rota é chamada através de um button no index.jsp
			edit(request, response);
			break;
		case "/usuario-update": // rota é chamada através de um button no index.jsp
			update(request, response);
			break;

		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> lista = usuarioDao.read();
		request.setAttribute("listausuario", lista);// passando a lista para o jsp
		RequestDispatcher rd = request.getRequestDispatcher("./views/usuario/usuario.jsp");
		rd.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		usuarioDao.delete(id);
		;
		response.sendRedirect("usuario"); // retorna novamente para a rota de clientes após deletar para reccarregar
											// as informações
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Usuario novoUsuario = new Usuario();
		
		novoUsuario.setNome_completo(request.getParameter("nome_completo"));
		novoUsuario.setEmail(request.getParameter("email"));
		novoUsuario.setSenha(request.getParameter("senha"));
		novoUsuario.setTelefone(request.getParameter("telefone"));
		novoUsuario.setCpf(request.getParameter("cpf"));
		novoUsuario.setEndereco(request.getParameter("endereco"));

		usuarioDao.create(novoUsuario);
		
		response.sendRedirect("usuario");
	
		

		
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    usuarios = usuarioDao.readById(id);
	    
	    request.setAttribute("usuario", usuarios);

	    RequestDispatcher rd = request.getRequestDispatcher("./views/usuario/Edit.jsp");
	    rd.forward(request, response);
	}


	protected void update(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
	    usuarios.setId(Integer.parseInt(request.getParameter("id")));
	    usuarios.setNome_completo(request.getParameter("nome_completo"));
	    usuarios.setEmail(request.getParameter("email"));
	    usuarios.setSenha(request.getParameter("senha"));
	    usuarios.setTelefone(request.getParameter("telefone"));
	    usuarios.setCpf(request.getParameter("cpf"));
	    usuarios.setEndereco(request.getParameter("endereco"));

	    usuarioDao.update(usuarios);

	    response.sendRedirect(request.getContextPath() + "/usuario");
	}

}
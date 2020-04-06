package ads.pipoca.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.pipoca.model.entity.Filme;
import ads.pipoca.model.service.FilmeService;

@WebServlet("/manter_filmes.do")
public class ManterFilmesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "mostrar":
			String id_filme = request.getParameter("id_filme");
			int idFilme = Integer.parseInt(id_filme);
			FilmeService fService = new FilmeService();
			Filme filme = fService.buscarFilme(idFilme);
			System.out.println(filme);
			
			request.setAttribute("filme", filme);
			
			RequestDispatcher view = request.getRequestDispatcher("Filme.jsp");
			view.forward(request, response);
			break;
		case "inserir":
			break;
		case "atualizar":
			break;
		case "excluir":
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

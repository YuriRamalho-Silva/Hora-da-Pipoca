package ads.pipoca.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.pipoca.model.entity.Filme;
import ads.pipoca.model.entity.Genero;
import ads.pipoca.model.service.FilmeService;
import ads.pipoca.model.service.GeneroService;

@WebServlet("/manter_filmes.do")
public class ManterFilmesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
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
			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			Double popularidade = Double.parseDouble(request.getParameter("popularidade"));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			 Date dataLanc = null;
			
			try {
				dataLanc = formatter.parse(request.getParameter("dtlanc"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String poster = request.getParameter("poster");
			String diretor = request.getParameter("diretor");
			int idGenero = Integer.parseInt(request.getParameter("idgenero"));
			GeneroService genero = new GeneroService();
			Genero genero1 = genero.buscarGenero(idGenero);
			
			Filme filme2 = new Filme();
			filme2.setTitulo(titulo);
			filme2.setDescricao(descricao);
			filme2.setPopularidade(popularidade);
			filme2.setDataLancamento(dataLanc);
			filme2.setPosterPath(poster);
			filme2.setDiretor(diretor);
			 filme2.setGenero(genero1);
			 
			 FilmeService filmesvc = new FilmeService();
			 int idDoFilme = filmesvc.inserirFilme(filme2);
			 
			 request.setAttribute("filme", idDoFilme);

				RequestDispatcher view2 = request.getRequestDispatcher("Filme.jsp");
				view2.forward(request, response);
				break;
				
		case "atualizar":
			break;
		case "excluir":
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package ads.pipoca.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		
		Filme filme = null; 
		Genero genero = null;
		FilmeService fService = new FilmeService();
		GeneroService gService = new GeneroService();
		String saida = null, titulo = null, descricao = null, diretor = null, posterPath = null;
		double popularidade;
		int idGenero, idFilme;
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd"); 
		java.util.Date dataLanc = null;
		ArrayList<Genero> generos = new ArrayList<Genero>(); 
		ArrayList<Filme> filmes = new ArrayList<Filme>();

		switch (acao) {
		case "mostrar":
			String id_filme = request.getParameter("id_filme");
			idFilme = Integer.parseInt(id_filme);
			filme = fService.buscarFilme(idFilme);
			System.out.println(filme);

			request.setAttribute("filme", filme);

			RequestDispatcher view = request.getRequestDispatcher("Filme.jsp");
			view.forward(request, response);
			break;
			
		case "inserir":
			 titulo = request.getParameter("titulo");
			 descricao = request.getParameter("descricao");
			 popularidade = Double.parseDouble(request.getParameter("popularidade"));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			 dataLanc = null;
			
			try {
				dataLanc = formatter.parse(request.getParameter("dtlanc"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String poster = request.getParameter("poster");
			 diretor = request.getParameter("diretor");
			idGenero = Integer.parseInt(request.getParameter("idgenero"));
			GeneroService generoObj = new GeneroService();
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
			 filme2.setId(idDoFilme);
			 request.setAttribute("filme", filme2);

				RequestDispatcher view2 = request.getRequestDispatcher("Filme.jsp");
				view2.forward(request, response);
				break;
				
		case "atualizar":
			idFilme = Integer.parseInt(request.getParameter("id_filme"));

			titulo = request.getParameter("titulo");
			descricao = request.getParameter("descricao");
			diretor = request.getParameter("diretor");
			idGenero = Integer.parseInt(request.getParameter("genero"));
			popularidade = Double.parseDouble(request.getParameter("popularidade"));
			posterPath = request.getParameter("poster_path");
			filme = new Filme();
			filme.setTitulo(titulo);
			filme.setDescricao(descricao);
			filme.setDiretor(diretor);

			try {
				dataLanc = formater.parse(request.getParameter("data_lancamento"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			filme.setDataLancamento(dataLanc);
			filme.setPopularidade(popularidade);
			filme.setPosterPath(posterPath);
			genero = gService.buscarGenero(idGenero);
			filme.setGenero(genero);
			filme.setId(idFilme);
			
			//Filme filmeAtualizado = fService.atualizarFilme(filme); 
			//request.setAttribute("filme", filmeAtualizado); 
			saida = "Filme.jsp"; 
			break;

		case "excluir":

			idFilme = Integer.parseInt(request.getParameter("id_excluir"));

			filme = fService.buscarFilme(idFilme);
			if (filme != null) {

				//fService.excluirFilme(idFilme);
				request.setAttribute("filme", filme); 
				saida = "Filme.jsp"; 

			} else {
				saida = "nExiste.html";
			}

			break;
		
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

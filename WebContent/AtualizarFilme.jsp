<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Filme</title>
<meta charset="utf-8" />

</head>
<body>
<h1>Filme</h1>
	<p> Digite os dados do filme para atualizar</p>
	<form action="atualizar_filmes.do" method="POST"> 
		<p><input type= "hidden" name="id_filme" value="${filme.id}"/> </p> 
		<p><label>Título do Filme: </label><input type="text" name="titulo" value="${filme.titulo}" required/> </p>
		<p><label>Descrição: </label><input type="text" name="descricao" value="${filme.descricao}" /></p>
		<p><label>Diretor: </label><input type="text" name="diretor" value="${filme.diretor}"/>
		
		<label>Gênero: </label><select name="genero" required> 
		
		<c:forEach var="genero" items="${generos}">
			<option value="${genero.id}">${genero.nome}</option> 
		</c:forEach>
		</select>
		</p>
		
		<p><label>Lançamento: </label><input type="date" name="data_lancamento" value="${filme.dataLancamento}"/>
		<label>Popularidade: </label><input type="number" name="popularidade" value="${filme.popularidade}"/></p>
		<p><label>URL do Pôster: </label><input type="text" name="poster_path" value="${filme.posterPath}"/></p>
		<p><input type="submit" name="acao" value="atualizar"></p>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-08">
<title>Lista de Filmes</title>

</head>
<body>
<h1>Lista de Filmes</h1>



<c:forEach var="filme" items="${filmes}">  
	
	<div style="">
		<form action="listar_filmes.do" method="GET">
			
			<p><button type="submit" name="acao" value="page_atualizar">Atualizar Filme</button></p>
			<p>${filme}</p>
			<img src="${filme.posterPath}"></img>
			<input type="hidden" name="id_atualizar" value="${filme.id}"/>
			
		</form>
	
	</div>
	<hr>

</c:forEach>

</body>
</html>
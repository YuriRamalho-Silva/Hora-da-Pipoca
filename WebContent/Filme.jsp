<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Filme</title>
</head>
<body>
	<h1>Filme id: ${filme.id}</h1>
	<p><strong>Título: </strong>${filme.titulo}</p>
	<p><strong>Descrição: </strong>${filme.descricao}</p>
	<p><strong>Diretor: </strong>${filme.diretor}</p>
	<p><strong>Gênero: </strong>${filme.genero.nome}</p>
</body>
</html>
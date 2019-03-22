<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais -
	Casa do Código</title>
</head>
<body>
	<h1>Casa do Código</h1>
	<form action="/casadocodigo/produtos" method="post">
		<div>
			<label>Título</label> 
			<input type="text" name="titulo" />
			<form:errors path="produto.titulo" />
		</div>
		<div>
			<label>Descrição</label>
			<textarea rows="10" cols="20" name="descricao"></textarea>
			<form:errors path="produto.descricao" />
		</div>
		<div>
			<label>Páginas</label> 
			<input type="text" name="paginas" />
			<form:errors path="produto.paginas" />
		</div>
		<c:forEach items="${tipos }" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label> <input type="text"
					name="precos[${status.index }].valor"> <input type="hidden"
					name="precos[${status.index }].tipo" value="${tipoPreco }">
			</div>
		</c:forEach>

		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>
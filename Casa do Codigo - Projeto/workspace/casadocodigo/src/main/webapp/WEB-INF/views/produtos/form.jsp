<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais -
	Casa do Código</title>

<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath }/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath }/bootstrap-grid.css" />
<style type="text/css">
	body{
		padding-bottom: 40px;
	}
</style>
<nav class="navbar navbar-dark bg-dark">
		<div class="navbar-header">
			<a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Casa do Código</a>
			<a class="navbar-brand" href="${s:mvcUrl('PC#listar').build() }">Lista de Produtos</a> 
			<a class="navbar-brand" href="${s:mvcUrl('PC#form').build() }">Cadastro de Produtos</a>
		</div>
		<!-- /.navbar-collapse --> </nav>


</head>
<body>

	 
	<h1 align="center">Cadastro de Produto</h1>
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="POST"
		commandName="produto" enctype="multipart/form-data" cssClass="container">
		<div class="form-group">
			<label>Título</label>
			<form:input path="titulo" cssClass="form-control"/>
			<form:errors path="titulo" />
		</div>
		<div class="form-group">
			<label>Descrição</label>
			<form:textarea rows="10" cols="20" path="descricao" cssClass="form-control"/>
			<form:errors path="descricao" />
		</div>
		<div class="form-group">
			<label>Páginas</label>
			<form:input path="paginas" cssClass="form-control"/>
			<form:errors path="paginas" />
		</div>
		<div>
			<label>Data de Lançamento</label> <input name="dataLancamento" />
			<form:errors path="dataLancamento" />
		</div>
		<c:forEach items="${tipos }" var="tipoPreco" varStatus="status">
			<div class="form-group">
				<label>${tipoPreco}</label>
				<form:input path="precos[${status.index }].valor" cssClass="form-control"/>
				<form:hidden path="precos[${status.index }].tipo"
					value="${tipoPreco }" />
			</div>
		</c:forEach>
		<div class="form-group">
			<label>Sumário</label> <input name="sumario" type="file" class="form-control">
		</div>
		<button type="submit">Cadastrar</button>
	</form:form>
</body>
</html>
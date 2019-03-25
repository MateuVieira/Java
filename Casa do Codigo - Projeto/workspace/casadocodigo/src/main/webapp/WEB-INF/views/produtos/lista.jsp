<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
<style type="text/css">
	size-bar:
	{
		size: 10px;
	}
</style>
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link text-white" href="${s:mvcUrl('HC#index').build()}">Casa do Código</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link text-white" href="${s:mvcUrl('PC#listar').build()}">Lista de Produtos</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link text-white"  href="${s:mvcUrl('PC#form').build()}">Cadastro de Produtos</a>
      </li>
    </ul>
    <security:authorize access="hasRole('ROLE_ADMIN')">
	    <ul class="nav navbar-nav ">
	      	 <li class="nav-item">
	      	 	<a class="nav-link text-white" href="#">
	      	 		<security:authentication property="principal" var="usuario" />
	      	 		Usuário: ${usuario.username }     
	      	 	</a>
	      	 </li>
	     </ul>
    </security:authorize>
    <ul class="nav navbar-nav navbar-right">
	      	 <li class="nav-item active text-white size-bar">
	      	 	||
	      	 </li>
	      </ul>
	<ul class="nav navbar-nav navbar-right">
	      	 <li class="nav-item active">
	      	 	<a class="flex-sm-fill text-sm-center nav-link active text-white" href="<c:url value="/logout" />">  Sair</a></span>
	      	 </li>
	      </ul>
  </div>
</nav>

	<div class="container">
		<h1>Lista de Produtos</h1>
		<p> ${sucesso} </p>
		<p> ${falha} </p>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Título</th>
				<th>Descrição</th>
				<th>Páginas</th>
			</tr>
			<c:forEach items="${produtos }" var="produto">
				<tr>
					<td><a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build() }">${produto.titulo }</a> </td>
					<td>${produto.descricao }</td>
					<td>${produto.paginas }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais -
	Casa do Código</title>

<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath }/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath }/bootstrap-grid.css" />


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
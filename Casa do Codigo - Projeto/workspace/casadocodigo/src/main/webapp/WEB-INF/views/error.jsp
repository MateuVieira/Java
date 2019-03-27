<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<tags:pageTemplate titulo="Produto não encontrado...">

	<section id="index-section" class="container middle">
		 <h2> Erro generico acontecendo</h2>
		 
		 <!-- 
		 	Mensagem : ${excepetion.message}
		 	<c:forEach items="${excepetion.stackTrace}" var="stk">
		 		${stk}
		 	</c:forEach>
		  -->
		  
	</section>

	</tags:pageTemplate>
</body>
</html>


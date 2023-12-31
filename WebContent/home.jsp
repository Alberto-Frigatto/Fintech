<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp">
    <jsp:param name="title" value="Home" />
    <jsp:param name="navbar" value="true" />
</jsp:include>

<main class='d-flex align-items-center justify-content-center flex-column gap-3'>
	<section class='p-4 bg-white d-flex flex-column rounded-4 w-50 gap-3'>
		<h1 class='fs-2 text-center'>Opções</h1>
		<div class='row'>
			<div class='col'>
				<a href='<%=request.getContextPath() + "/user/contas"%>' class='card text-decoration-none btn btn-outline-primary'>
					<div class='card-body d-flex align-items-center gap-2 justify-content-center'>
						<i class="bi bi-bank fs-5"></i>
						Contas bancárias
					</div>
				</a>
			</div>
		</div>
		<div class='row'>
			<div class='col'>
				<a href='<%=request.getContextPath() + "/user/receitas"%>' class='card text-decoration-none btn btn-outline-primary'>
					<div class='card-body d-flex align-items-center gap-2 justify-content-center'>
						<i class="bi bi-coin fs-5"></i>
						Receitas
					</div>
				</a>
			</div>
			<div class='col'>
				<a href='<%=request.getContextPath() + "/user/despesas"%>' class='card text-decoration-none btn btn-outline-primary'>
					<div class='card-body d-flex align-items-center gap-2 justify-content-center'>
						<i class="bi bi-credit-card-fill fs-5"></i>
						Despesas
					</div>
				</a>
			</div>
		</div>
	</section>
</main>

<%@ include file="template/footer.jsp" %>
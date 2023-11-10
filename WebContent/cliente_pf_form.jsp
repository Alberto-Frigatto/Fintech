<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp">
    <jsp:param name="title" value="Realizar Cadastro" />
</jsp:include>

<main class='d-flex align-items-center justify-content-center flex-column gap-3'>
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">
		    ${ error }
		</div>
	</c:if>

	<form action='clientePF' method='post' class='p-4 bg-white d-flex flex-column rounded-4 w-50 gap-2'>
		<h1 class='fs-2'>Pessoa Física</h1>
		
		<p>Para criar uma conta como <b>Pessoa Jurídica</b> <a href='register_cliente_pj.jsp'>Clique Aqui</a></p>
		
		<div class='row mb-2'>
			<div class='col'>
				<div class="form-floating">
				    <input type="text" class="form-control" name='nome' id="nome" placeholder="João">
				    <label for="nome">Nome</label>
				</div>
			</div>
			<div class='col'>
				<div class="form-floating">
				    <input type="email" class="form-control" name='email' id="email" placeholder="email">
				    <label for="email">Email</label>
				</div>
			</div>
		</div>
		
		<div class='row mb-2'>
			<div class='col'>
				<div class="form-floating">
				    <input type="text" class="form-control" name='cpf' id="cpf" placeholder="11111111111">
				    <label for="cpf">CPF</label>
				</div>
			</div>
			<div class='col'>
				<div class="form-floating">
				    <input type="text" class="form-control" name='rg' id="rg" placeholder="111111111">
				    <label for="rg">RG</label>
				</div>
			</div>
			<div class='col'>
				<div class="form-floating">
				    <input type="date" class="form-control" name='dataNascimento' id="dataNascimento" placeholder="27/02/2005">
				    <label for="dataNascimento">Data de nascimento</label>
				</div>
			</div>
		</div>
		
		<div class='row mb-2 align-items-center'>
			<div class='col'>
				<div class="form-floating">
				    <input type="password" class="form-control" name='senha' id="senha" placeholder="adawdawdawdaw">
				    <label for="senha">Senha</label>
				</div>
			</div>
			<div class='col'>
				<p>A senha deve possuir no mínimo:</p>
				<ul>
					<li>8 caracteres</li>
					<li>1 letra maiúscula</li>
					<li>1 letra minúscula</li>
					<li>1 número</li>
					<li>1 caractere especial</li>
				</ul>
			</div>
		</div>
		
		<div class='d-grid'>
			<button type='submit' class='btn btn-primary'>Cadastrar</button>
		</div>
		
		<p>Ou então, efetue seu login <a href='index.jsp'>clicando aqui</a></p>
	</form>
</main>

<%@ include file="template/footer.jsp" %>
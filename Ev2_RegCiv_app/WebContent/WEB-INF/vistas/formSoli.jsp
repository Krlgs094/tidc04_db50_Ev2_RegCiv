<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:include page="../templates/header.jsp"></jsp:include>
	<main class="container mt-6">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
			
				
				<c:if test="${errores != null}">
					<div class="notification is-warning">
					 	<h6>Existen errores en el formularios</h6>
					 	<div class="content">
					 		<ul>
					 			<c:forEach var="error" items="${errores}">
					 				<li>${error}</li>
					 			</c:forEach>
					 		</ul>
					 	</div>
					</div>
				</c:if>
			</div>
		</div>
		<div class="columns is-centered">
			<div class="column is-6">
				<form method="post" action="IngSoliController.do">
					<div class="card">
						<div class="card-header has-background-primary">
							<span class="card-header-title">Ingrese su solicitud</span>
						</div>
						<div class="card-content">
							<div class="field">
 								<label class="label" for="rut-txt">Rut</label>
									<div class="control">
    									<input name ="rut-txt" class="input" type="text" id="rut-txt" placeholder="Ingrese su rut con punto y guion" />
  									</div>
							</div>
							<div class="field">
  								<label class="label" for="nombre-txt">Nombre</label>
  								<div class="control">
    								<input name="nombre-txt" class="input" type="text" id="nombre-txt" placeholder="Ingrese su nombre" />
  								</div>
							</div>
							<div class="field">
								<label class="label" for="tipoSoli-select">Tipo de Solicitud</label>
								<div class="control">
									<div class="select">
							      		<select name="tipoSoli-select" id="tipoSoli-selects">
							        		<option>Retiro de cedula de identidad</option>
							        		<option>solicitud de cedula de identidad</option>
							        		<option>solicitud de certificado de nacimiento</option>
							        		<option>solicitud de certificado de defuncion</option>
							      		</select>
							    	</div>
						  		</div>
							</div>
						</div>
						<div class="card-footer">
							<div class="card-footer-item">
								<button type="submit" class="button is-primary">Ingresar solicitud</button>
							</div>
						</div>
					</div>
				</form>
			</div>	
		</div>
	</main>
</body>
</html>
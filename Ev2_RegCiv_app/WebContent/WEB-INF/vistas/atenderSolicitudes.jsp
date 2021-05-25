<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:include page="../templates/header.jsp"></jsp:include>
<% int c;
	c=0;%>
	<main class="container mt-6">
		
		<div class="columns is-centered">
			<div class="column is-8 is-centered">
				<table class="table is-hovered is-bordered is-fullwidth">
					<thead class="has-background-primary">
						<tr>
							<th>Numero de atencion</th>
							<th>Nombre de cliente</th>
							<th>tipo de solicitud</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="solicitudes" items="${solicitud}">
							<tr>
								<td>${c=c+1}</td>
								<td>${solicitudes.nombre}</td>
								<td>${solicitudes.tipoSoli}</td>
								<td>
									<a href="AtenderSolicitdesController.do?nombreEliminar=${solicitudes.nombre}" class="has-text-success">Atender</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</main>
</body>
</html>
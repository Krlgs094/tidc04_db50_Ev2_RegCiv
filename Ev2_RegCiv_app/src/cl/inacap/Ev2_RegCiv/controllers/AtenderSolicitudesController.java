package cl.inacap.Ev2_RegCiv.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.Ev2_RegCiv_Model.dto.Solicitud;
import cl.incap.Ev2_RegCiv_Model.dao.SolicitudesDAOLocal;

/**
 * Servlet implementation class AtenderSolicitudesController
 */
@WebServlet("/AtenderSolicitudesController.do")
public class AtenderSolicitudesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private SolicitudesDAOLocal solicitudesDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtenderSolicitudesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(request.getParameter("solicitudEliminar") != null) {
			String solicitudes = request.getParameter("solicitudEliminar").trim();
			
			List<Solicitud> busqueda = solicitudesDAO.filterByName(solicitudes);
			Solicitud solicitudEliminar = busqueda.isEmpty()? null:busqueda.get(0);
			if(solicitudEliminar != null) {
				solicitudesDAO.delete(solicitudEliminar);
			}
		}
		List<Solicitud> solicitud = solicitudesDAO.getAll();
		request.setAttribute("solicitud",solicitud);
		
		request.getRequestDispatcher("WEB-INF/vistas/atenderSolicitudes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

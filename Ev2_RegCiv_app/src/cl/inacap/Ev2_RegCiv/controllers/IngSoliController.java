package cl.inacap.Ev2_RegCiv.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.Ev2_RegCiv_Model.dto.Solicitud;
import cl.inacap.Ev2_RegCiv_Utils.RutUtils;
import cl.incap.Ev2_RegCiv_Model.dao.SolicitudesDAOLocal;

/**
 * Servlet implementation class IngSoliController
 */
@WebServlet("/IngSoliController.do")
public class IngSoliController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private SolicitudesDAOLocal solicitudesDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngSoliController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/vistas/formSoli.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> errores = new ArrayList<>();		
		RutUtils ru = new RutUtils();		
		
		String rut = request.getParameter("rut-txt").trim();
		if(ru.verificaRutChileno(rut) != true) {
			errores.add("Ingrese un Rut chileno valido");
		}
		String nombre = request.getParameter("nombre-txt").trim();
		if(nombre.isEmpty()) {
			errores.add("Debe ingresar su nombre");
		}
		String tipoSoli = request.getParameter("tipoSoli-select").trim();
		if(tipoSoli.isEmpty()) {
			errores.add("Debe ingresar una solicitud");
		}
		if(errores.isEmpty()) {
			
			Solicitud solicitud = new Solicitud();
			solicitud.setRut(rut);
			solicitud.setNombre(nombre);
			solicitud.setTipoSoli(tipoSoli);
			solicitudesDAO.save(solicitud);
			request.setAttribute("mensaje","Solicitud ingresada correctamente");
			request.getRequestDispatcher("AtenderSolicitudesController.do").forward(request, response);
		} else {
			request.setAttribute("errores", errores);
		}
		doGet (request,response);
	}

}

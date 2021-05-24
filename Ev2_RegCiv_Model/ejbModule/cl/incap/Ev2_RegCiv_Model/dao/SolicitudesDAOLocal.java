package cl.incap.Ev2_RegCiv_Model.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.Ev2_RegCiv_Model.dto.Solicitud;

@Local
public interface SolicitudesDAOLocal {
	
	void save (Solicitud solicitud);
	List<Solicitud> getAll();
	void delete (Solicitud solicitud);
	List<Solicitud> filterByName(String nombre);
}

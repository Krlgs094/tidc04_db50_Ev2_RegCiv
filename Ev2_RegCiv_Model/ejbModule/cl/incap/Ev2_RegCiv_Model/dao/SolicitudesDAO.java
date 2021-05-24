package cl.incap.Ev2_RegCiv_Model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.Ev2_RegCiv_Model.dto.Solicitud;

/**
 * Session Bean implementation class SolicitudesDAO
 */
@Stateless
@LocalBean
public class SolicitudesDAO implements SolicitudesDAOLocal {
	
	private static List<Solicitud> solicitudes = new ArrayList<>();


	@Override
	public void save(Solicitud solicitud) {
		// TODO Auto-generated method stub
		solicitudes.add(solicitud);
	}

	@Override
	public List<Solicitud> getAll() {
		// TODO Auto-generated method stub
		return solicitudes;
	}

	@Override
	public void delete(Solicitud solicitud) {
		// TODO Auto-generated method stub
		solicitudes.remove(solicitud);
	}

	@Override
	public List<Solicitud> filterByName(String nombre) {
		// TODO Auto-generated method stub
		return solicitudes.stream().filter(c->c.getNombre().contains(nombre)).collect(Collectors.toList());
	}

}

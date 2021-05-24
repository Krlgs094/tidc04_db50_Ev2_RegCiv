package cl.inacap.Ev2_RegCiv_Model.dto;


public class Solicitud {
	
	private String nombre;
	private String rut;
	private String tipoSoli;
	private int nroSolicitud;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getTipoSoli() {
		return tipoSoli;
	}
	public void setTipoSoli(String tipoSoli) {
		this.tipoSoli = tipoSoli;
	}
	public int getNroSolicitud() {
		return nroSolicitud;
	}
	public void setNroSolicitud(int nroSolicitud) {
		this.nroSolicitud = nroSolicitud;
	}

}

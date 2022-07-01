package javaPeopleDao;

import java.util.List;

import javaPeopleModel.Calificacion;

public interface CalificacionDAO {
	
	public List<Calificacion> findAllCalificaciones();
	public Calificacion findByIdCalificacion(int id);
	public void crearCalificacion (Calificacion calificacion);
	public void editarCalificacion (Calificacion calificacion);
	public void borrarCalificacion (int id);
}

package javaPeopleDao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import javaPeopleModel.Calificacion;

public interface CalificacionDAO {
	
	public List<Calificacion> findAllCalificaciones() throws SQLException, NamingException;
	public Calificacion findByIdCalificacion(int id) throws SQLException, NamingException;
	public Calificacion findCalificacionByIdEstudiante(int id) throws SQLException, NamingException;
	public void crearCalificacion (Calificacion calificacion) throws SQLException, NamingException;
	public void editarCalificacion (Calificacion calificacion) throws SQLException, NamingException;
	public void borrarCalificacion (int id) throws SQLException, NamingException;
}

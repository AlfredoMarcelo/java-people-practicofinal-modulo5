package javaPeopleDao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import javaPeopleModel.Asignatura;

public interface AsignaturaDAO {

	public List<Asignatura> findAllAsignaturas() throws SQLException, NamingException;
	public Asignatura findAsignaturaById(int id) throws SQLException, NamingException;
	public void crearAsignatura(Asignatura asignatura) throws SQLException, NamingException;
	public void editarAsignatura(Asignatura asignatura) throws SQLException, NamingException;
	public void borrarAsignatura(int id) throws SQLException, NamingException;
	
}

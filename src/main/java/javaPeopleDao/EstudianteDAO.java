package javaPeopleDao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import javaPeopleModel.Estudiante;

public interface EstudianteDAO {

	public List<Estudiante> findAllEstudiantes() throws SQLException, NamingException;
	public Estudiante findByIdEstudiante(int id) throws SQLException, NamingException;
	public void crearEstudiante(Estudiante estudiante) throws SQLException, NamingException;
	public void editarEstudiante(Estudiante estudiante) throws SQLException, NamingException;
	public void borrarEstudiante(int id) throws SQLException, NamingException;
	
}

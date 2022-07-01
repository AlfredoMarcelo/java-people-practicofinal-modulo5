package javaPeopleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import javaPeopleModel.Estudiante;

public class EstudianteDAOImp implements EstudianteDAO{

	@Override
	public List<Estudiante> findAllEstudiantes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estudiante findByIdEstudiante(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearEstudiante(Estudiante estudiante) throws SQLException, NamingException {
		String sql = "INSERT INTO estudiantes(nombre, apellido, run, genero, fono) VALUES (?, ?, ?, ?, ?)";
		try (
				Connection conexion = DbUtils.getCoenxion();
				PreparedStatement declaracion = conexion.prepareStatement(sql);
			) {
				declaracion.setString(1, estudiante.getNombre());
				declaracion.setString(2, estudiante.getApellido());
				declaracion.setString(3, estudiante.getRun());
				declaracion.setString(4, estudiante.getGenero());
				declaracion.setString(5, estudiante.getFono());
				int filasInsertadas = declaracion.executeUpdate();
		}
	}

	@Override
	public void editarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarAsignatura(int id) {
		// TODO Auto-generated method stub
		
	}

}

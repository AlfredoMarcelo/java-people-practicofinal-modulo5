package javaPeopleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import javaPeopleModel.Estudiante;

public class EstudianteDAOImp implements EstudianteDAO{

	@Override
	public List<Estudiante> findAllEstudiantes() throws SQLException, NamingException {
		try(
				Connection conexion = DbUtils.getCoenxion();
				Statement declaracion = conexion.createStatement();
			){
			ResultSet rs = declaracion.executeQuery("SELECT * FROM estudiantes");
			List<Estudiante> estudiantes = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String run = rs.getString("run");
				String genero = rs.getString("genero");
				String fono = rs.getString("fono");
				Estudiante estudiante = new Estudiante(id, nombre, apellido, run, genero, fono);
				estudiantes.add(estudiante);
			}
			return estudiantes;
		}
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

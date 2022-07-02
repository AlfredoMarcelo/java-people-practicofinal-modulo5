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
				Connection conexion = DbUtils.getConexion();
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
	public Estudiante findByIdEstudiante(int estudianteId) throws SQLException, NamingException {
		String sql = "SELECT * FROM estudiantes WHERE id = ?";
		try (
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement(sql);
			) {
				declaracion.setInt(1, estudianteId);
				ResultSet rs = declaracion.executeQuery();
				if(rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					String apellido = rs.getString("apellido");
					String run = rs.getString("run");
					String genero = rs.getString("genero");
					String fono = rs.getString("fono");
					return new Estudiante(id, nombre, apellido, run, genero, fono);
				} else {					
					return null;
				}
		}
	}

	@Override
	public void crearEstudiante(Estudiante estudiante) throws SQLException, NamingException {
		String sql = "INSERT INTO estudiantes(nombre, apellido, run, genero, fono) VALUES (?, ?, ?, ?, ?)";
		try (
				Connection conexion = DbUtils.getConexion();
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
	}

	@Override
	public void borrarEstudiante(int id) {
	}

}

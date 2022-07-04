package javaPeopleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import javaPeopleModel.Asignatura;
import javaPeopleModel.Calificacion;
import javaPeopleModel.Estudiante;

public class CalificacionDAOImp implements CalificacionDAO {

	@Override
	public List<Calificacion> findAllCalificaciones() {

		return null;
	}

	@Override
	public Calificacion findByIdCalificacion(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearCalificacion(Calificacion calificacion) throws SQLException, NamingException {
		String sql = "INSERT INTO calificaciones(estudiante_id, asignatura_id, nota, evaluacion) VALUES(?, ?, ?, ?)";
		try(
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement(sql);
			){
				declaracion.setInt(1, calificacion.getEstudiante().getId());
				declaracion.setInt(2, calificacion.getAsignatura().getId());
				declaracion.setFloat(3, calificacion.getNota());
				declaracion.setInt(4, calificacion.getEvaluacion());
				int filasInsertadas = declaracion.executeUpdate();
		}
		
	}

	@Override
	public void editarCalificacion(Calificacion calificacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarCalificacion(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Calificacion findCalificacionByIdEstudiante(int estudianteId) throws SQLException, NamingException {
		String sql = "SELECT nota, evaluacion FROM ordenes WHERE estudiante_id = ?";
		try(
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement(sql);
			){
			declaracion.setInt(1, estudianteId);
			ResultSet rs = declaracion.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				Estudiante estudiante = (Estudiante)rs.getObject("estudiante_id");
				Asignatura asignatura = (Asignatura)rs.getObject("asignatura_id");
				float nota = rs.getFloat("nota");
				int evaluacion = rs.getInt("evaluacion");
				return new Calificacion(id, estudiante, asignatura, nota, evaluacion);
			} else {
				return null;
			}
			
		}
	}

}

package javaPeopleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


import javaPeopleModel.Asignatura;

public class AsignaturaDAOImp implements AsignaturaDAO{

	@Override
	public List<Asignatura> findAllAsignaturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asignatura findAsignaturaById(int asignaturaId) throws SQLException, NamingException {
		String sql = "SELECT * FROM asignaturas WHERE id = ?";
		try (
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement(sql);
			) {
				declaracion.setInt(1, asignaturaId);
				ResultSet rs = declaracion.executeQuery();
				if(rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					return new Asignatura(id, nombre);
				}else {
					return null;
				}
		}
	}

	@Override
	public void crearAsignatura(Asignatura asignatura) throws SQLException, NamingException {
		String sql = "INSERT INTO asignaturas (nombre) VALUES (?)";
		try(
				Connection conexion = DbUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement(sql);
			){
			declaracion.setString(1, asignatura.getNombre());
			int filasInsertadas = declaracion.executeUpdate();
		}
		
	}

	@Override
	public void editarAsignatura(Asignatura asignatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarAsignatura(int id) {
		// TODO Auto-generated method stub
		
	}

}

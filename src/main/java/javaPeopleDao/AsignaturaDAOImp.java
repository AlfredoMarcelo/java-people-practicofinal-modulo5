package javaPeopleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public Asignatura findAsignaturaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearAsignatura(Asignatura asignatura) throws SQLException, NamingException {
		String sql = "INSERT INTO asignaturas (nombre) VALUES (?)";
		try(
				Connection conexion = DbUtils.getCoenxion();
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

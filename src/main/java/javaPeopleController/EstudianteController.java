package javaPeopleController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaPeopleDao.EstudianteDAO;
import javaPeopleDao.EstudianteDAOImp;
import javaPeopleModel.Estudiante;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;


public class EstudianteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private EstudianteDAO estudianteDAO;
	
	
    public EstudianteController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seleccion = request.getParameter("seleccion");
		String vistaJSP = "";
	}
	
	
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.estudianteDAO = new EstudianteDAOImp();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		}catch (NumberFormatException e) {
			System.err.println("todo ok");
		}
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String run = request.getParameter("run");
		String genero = request.getParameter("genero");		
		String fono = request.getParameter("fono");
		
		if(id == 0) {
			Estudiante estudiante = new Estudiante(nombre, apellido, run, genero, fono);
			try {
				estudianteDAO.crearEstudiante(estudiante);
				response.sendRedirect("/java-people/");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
			response.sendRedirect("/java-people/");
		}else {
			Estudiante actualizarEstudiante = new Estudiante(id, nombre, apellido, run, genero, fono);
			try {
				estudianteDAO.editarEstudiante(actualizarEstudiante);
				response.sendRedirect("/java-people/");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		}
		
		
		
		
	}

}

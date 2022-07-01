package javaPeopleController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaPeopleDao.AsignaturaDAO;
import javaPeopleDao.AsignaturaDAOImp;
import javaPeopleModel.Asignatura;
import javaPeopleModel.Estudiante;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;


public class AsignaturaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AsignaturaDAO asignaturaDAO;
    
	
    public AsignaturaController() {
        super();
    }
    
    

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.asignaturaDAO = new AsignaturaDAOImp();
	}




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		}catch (NumberFormatException e) {
			System.err.println("todo ok");
		}

		String nombre = request.getParameter("nombre");
		
		if(id == 0) {
			Asignatura asignatura = new Asignatura(nombre);
			try {
				asignaturaDAO.crearAsignatura(asignatura);
				response.sendRedirect("/java-people/");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		}else {
			Asignatura actualizarAsignatura = new Asignatura(id, nombre);
			try {
				asignaturaDAO.editarAsignatura(actualizarAsignatura);
				response.sendRedirect("/java-people/");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		}
	}

}

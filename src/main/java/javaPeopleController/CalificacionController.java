package javaPeopleController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaPeopleDao.AsignaturaDAO;
import javaPeopleDao.AsignaturaDAOImp;
import javaPeopleDao.CalificacionDAO;
import javaPeopleDao.CalificacionDAOImp;
import javaPeopleDao.EstudianteDAO;
import javaPeopleDao.EstudianteDAOImp;
import javaPeopleModel.Asignatura;
import javaPeopleModel.Estudiante;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


public class CalificacionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EstudianteDAO estudianteDAO;
	private CalificacionDAO calificacionDAO;
	private AsignaturaDAO asignaturaDAO;
	
	
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.calificacionDAO = new CalificacionDAOImp();
		this.estudianteDAO = new EstudianteDAOImp();
		this.asignaturaDAO = new AsignaturaDAOImp();
	}


	public CalificacionController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String seleccion = request.getParameter("seleccion");
	int estudianteId = Integer.parseInt(request.getParameter("id"));
	String vistaJSP = "";
	
	switch(seleccion) {
	case "agregar":
		vistaJSP = "/WEB-INF/vistas/calificacion/formularioCalificacion.jsp";
		Estudiante estudiante = null;
		List<Asignatura> asignaturas = null;
		
		try {
			estudiante = estudianteDAO.findByIdEstudiante(estudianteId);
			asignaturas = asignaturaDAO.findAllAsignaturas();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.sendError(500);
			return;
		}
		request.setAttribute("estudiante", estudiante);
		request.setAttribute("asignaturas", asignaturas);
		request
			.getRequestDispatcher(vistaJSP)
			.forward(request, response)
			;
		break;
	
	
	}
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

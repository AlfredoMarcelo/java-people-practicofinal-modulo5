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
import javaPeopleModel.Calificacion;
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
		this.estudianteDAO = new EstudianteDAOImp();
		this.asignaturaDAO = new AsignaturaDAOImp();
		this.calificacionDAO = new CalificacionDAOImp( this.estudianteDAO, this.asignaturaDAO );
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
	case "consultarPorId":
		Calificacion calificacion = null;
		try {
			calificacion = calificacionDAO.findCalificacionByIdEstudiante(estudianteId);
			request.setAttribute("calificacion", calificacion);
			vistaJSP = "/WEB-INF/vistas/estudiante/notasEstudiante.jsp";
			request
			.getRequestDispatcher(vistaJSP)
			.forward(request, response)
			;
			
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.sendError(500);
		}
		break;
	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e){
			System.err.println("todo ok");
		}
		
		
		Estudiante estudiante = null;
		Asignatura asignatura = null;
		float nota = Float.parseFloat(request.getParameter("nota"));
		int evaluacion = Integer.parseInt(request.getParameter("evaluacion"));
		try {
			int estudianteId = Integer.parseInt(request.getParameter("estudianteId"));
			int asignaturaId = Integer.parseInt(request.getParameter("asignaturaId"));
			estudiante = estudianteDAO.findByIdEstudiante(estudianteId);
			asignatura = asignaturaDAO.findAsignaturaById(asignaturaId);
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.sendError(500);
		}
		
		if(id == 0) {
			Calificacion nuevaCalificacion = new Calificacion(estudiante, asignatura, nota, evaluacion);
			try {
				calificacionDAO.crearCalificacion(nuevaCalificacion);
				response.sendRedirect("/java-people/estudiante?seleccion=listar");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		} else {
			Calificacion editarCalificacion = new Calificacion(id, estudiante, asignatura, nota, evaluacion);
			try {
				calificacionDAO.editarCalificacion(editarCalificacion);
				response.sendRedirect("/java-people/estudiante?seleccion=listar");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		}
		

		
		
		
	}

}

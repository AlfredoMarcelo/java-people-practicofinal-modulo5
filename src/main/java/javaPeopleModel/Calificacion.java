package javaPeopleModel;

public class Calificacion {

	private int id;
	private Estudiante estudiante;
	private Asignatura asignatura;
	private float nota;
	private int evaluacion;
	
	public Calificacion() {
		super();
	}

	public Calificacion(Estudiante estudiante, Asignatura asignatura, float nota, int evaluacion) {
		super();
		this.estudiante = estudiante;
		this.asignatura = asignatura;
		this.nota = nota;
		this.evaluacion = evaluacion;
	}

	public Calificacion(int id, Estudiante estudiante, Asignatura asignatura, float nota, int evaluacion) {
		super();
		this.id = id;
		this.estudiante = estudiante;
		this.asignatura = asignatura;
		this.nota = nota;
		this.evaluacion = evaluacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public int getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
	}

	
	
	
}

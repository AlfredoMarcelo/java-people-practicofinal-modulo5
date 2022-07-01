package javaPeopleModel;

public class Estudiante {

	private int id;
	private String nombre;
	private String apellido;
	private String run;
	private String genero;
	private String fono;
	
	
	public Estudiante() {
	}


	public Estudiante(String nombre, String apellido, String run, String genero, String fono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.run = run;
		this.genero = genero;
		this.fono = fono;
	}


	public Estudiante(int id, String nombre, String apellido, String run, String genero, String fono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.run = run;
		this.genero = genero;
		this.fono = fono;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getRun() {
		return run;
	}


	public void setRun(String run) {
		this.run = run;
	}
	
	public String getGenero() {
		return genero;
	}
	
	
	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getFono() {
		return fono;
	}


	public void setFono(String fono) {
		this.fono = fono;
	}
	
	
	
}

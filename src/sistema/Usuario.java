package sistema;

public class Usuario {
	private String usuario;
	private Password contrasena;
	private String nombre;
	private String apellido;
	private int dni;
	private int edad;
	private final int EDAD_MINIMA = 18;
	
	public Usuario(String usuario, Password contrasena, String nombre, String apellido, int dni, int edad) {
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
	}

	public boolean esMayorDeEdad() {
		if (this.edad >= EDAD_MINIMA) {
			return true;
		}
		else { 
			return false;
		}
	}
	public boolean laContrasenaEsValida(String contrasena) {
		return this.contrasena.esFuerte(contrasena);
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getDni() {
		return dni;
	}

	public Password getContrasena() {
		return contrasena;
	}

	public void setContrasena(Password contrasena) {
		this.contrasena = contrasena;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getUsuario() {
		return usuario;
	}
	
}
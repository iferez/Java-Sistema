package sistema;

public class Sistema {

	private String nombre;

	private Usuario usuarios[];
	private int cantidadDeUsuariosRegistrados;

	public Sistema(String nombre, int cantidadDeUsuarios) {
		this.nombre = nombre;
		this.usuarios = new Usuario[cantidadDeUsuarios];
		cantidadDeUsuariosRegistrados = 0;
	}

	public boolean ingresarUsuario(Usuario nuevoUsuario) {
		boolean sePudoIngresar = false;
		if (!elUsuarioExiste(nuevoUsuario) && cantidadDeUsuariosRegistrados < usuarios.length
				&& nuevoUsuario.laContrasenaEsValida(nuevoUsuario.getContrasena().getValor())) {
			usuarios[cantidadDeUsuariosRegistrados++] = nuevoUsuario;
			sePudoIngresar = true;
		}
		return sePudoIngresar;
	}

	private boolean elUsuarioExiste(Usuario buscado) {
		boolean existe = false;
		for (int i = 0; i < cantidadDeUsuariosRegistrados; i++) {
			if (usuarios[i].getUsuario().equals(buscado.getUsuario())) {
				existe = true;
			}
		}
		return existe;
	}

	public int calcularLaCantidadDeUsuariosMenores() {
		int cantidadDeUsuariosMenores = 0;

		for (int i = 0; i < cantidadDeUsuariosRegistrados; i++) {
			if (!usuarios[i].esMayorDeEdad()) {
				cantidadDeUsuariosMenores++;
			}
		}
		return cantidadDeUsuariosMenores;
	}

	public String getNombre() {
		return nombre;
	}

	public int calcularLaCantidadDeUsuariosMayores() {
		int cantidadDeUsuariosMayores = 0;

		for (int i = 0; i < cantidadDeUsuariosRegistrados; i++) {
			if (usuarios[i].esMayorDeEdad()) {
				cantidadDeUsuariosMayores++;
			}
		}
		return cantidadDeUsuariosMayores;
	}

	public double calcularEdadPromedio() {
		double sumatoriaEdad = 0.0;
		double promedioEdad = 0.0;

		for (int i = 0; i < cantidadDeUsuariosRegistrados; i++) {
			sumatoriaEdad += usuarios[i].getEdad();
		}
		promedioEdad = sumatoriaEdad / cantidadDeUsuariosRegistrados;

		return promedioEdad;
	}

	public boolean loguearUsuario(String usuario, String contrasena) {
		boolean sePudoLoguear = false;
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				if (usuarios[i].getUsuario().equals(usuario)
						&& usuarios[i].getContrasena().getValor().equals(contrasena)) {
					sePudoLoguear = true;
				}
			}
		}
		return sePudoLoguear;
	}

	// ORDENAMIENTO
	public Usuario[] listarUsuarios() {
		Usuario usuariosOrdenados[] = usuarios;
		Usuario auxiliar;

		for (int i = 1; i < cantidadDeUsuariosRegistrados; i++) {
			for (int j = 0; j < cantidadDeUsuariosRegistrados - 1; j++) {
				if (usuariosOrdenados[j].getUsuario().compareTo(usuariosOrdenados[j + 1].getUsuario()) > 0) {
					// valor1 el de la izquieda
					// valor2 el que se envía por parámetro
					auxiliar = usuariosOrdenados[j + 1];
					usuariosOrdenados[j + 1] = usuariosOrdenados[j];
					usuariosOrdenados[j] = auxiliar;
				}
			}

			
		}
		return usuariosOrdenados;
		

	}
	// TERMINÓ ORDENAMIENTO
	
	
}
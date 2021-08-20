package sistema;

import java.util.Scanner;

import sistema.Password;
import sistema.Sistema;
import sistema.Usuario;

public class PruebaSistema {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String nombreDelSistema = "";
		Sistema actual;
		final int CANTIDAD_MAXIMA_DE_USUARIOS = 100;
		int opcionIngresada = 0;

		System.out.println("Bienvenido al Sistema");
		System.out.println("Ingrese el nombre del Sistema:");
		nombreDelSistema = teclado.next();
		actual = new Sistema(nombreDelSistema, CANTIDAD_MAXIMA_DE_USUARIOS);

		do {
			mostrarMenu(actual);
			opcionIngresada = teclado.nextInt();
			switch (opcionIngresada) {
			case 1:
				darDeAltaUnUsuario(teclado, actual);
				break;
			case 2:
				loguearse(teclado, actual);
				break;
			case 3:
				listarUsuariosOrdenados(actual);
				break;
			case 4:
				System.out.println("La cantidad de menores es: " + actual.calcularLaCantidadDeUsuariosMenores());
				break;
			case 5:
				System.out.println("La cantidad de mayores es: " + actual.calcularLaCantidadDeUsuariosMayores());
				break;
			case 9:
				break;
			default:
				System.out.println("La opción ingresada es incorrecta.");
			}
		} while (opcionIngresada != 9);
		
		System.out.println("Hasta luego! Gracias por usar nuestro sistema");
	} 

	private static void listarUsuariosOrdenados(Sistema actual) {
		Usuario ordenados[] = actual.listarUsuarios();
		System.out.println("La lista de usuarios es: ");
		for (int i = 0; i < ordenados.length; i++) {
			if (ordenados[i] != null) {
				System.out.println(ordenados[i].getUsuario() + '\n');
			}
		}

	}

	private static void mostrarMenu(Sistema actual) {
		System.out.println("Bienvenido a: " + actual.getNombre());
		System.out.println("1 - Dar de alta un usuario");
		System.out.println("2 - Loguearse");
		System.out.println("3 - Listar usuarios");
		System.out.println("4 - Mostrar la cantidad de menores");
		System.out.println("5 - Mostrar la cantidad de mayores");
		System.out.println("9 - Salir");
		System.out.println("Ingrese la opción deseada");
	}

	private static void darDeAltaUnUsuario(Scanner teclado, Sistema actual) {
		String nombre, apellido, usuario, contrasena;
		int dni, edad;
		Password password = new Password();
		Usuario nuevo;

		System.out.println("Alta de usuario");
		System.out.println("Ingresar el nombre:");
		nombre = teclado.next();
		System.out.println("Ingresar el apellido:");
		apellido = teclado.next();
		System.out.println("Ingresar el dni:");
		dni = teclado.nextInt();
		System.out.println("Ingresar la edad:");
		edad = teclado.nextInt();
		System.out.println("Ingresar el usuario:");
		usuario = teclado.next();
		do {
			System.out.println("Ingresar el contrasena (Minimo 1 Mayuscula, 1 Minuscula, 2 Numeros): ");
			contrasena = teclado.next();
		} while (!password.esFuerte(contrasena));

		password.setValor(contrasena);
		nuevo = new Usuario(usuario, password, nombre, apellido, dni, edad);
		if (actual.ingresarUsuario(nuevo)) {
			System.out.println("Ingreso exitoso");
		} else {
			System.out.println("No se pudo ingresar (usuario ya existente o no hay más espacio para usuarios nuevos");
		}
	}

	private static void loguearse(Scanner teclado, Sistema actual) {
		String usuario, contrasena;
		System.out.println("Login");
		System.out.println("Ingrese usuario");
		usuario = teclado.next();
		System.out.println("Ingrese contraseña");
		contrasena = teclado.next();

		if (actual.loguearUsuario(usuario, contrasena)) {
			System.out.println("Bienvenido");
		} else {
			System.out.println("Usuario o contraseña inválida.");
		}
	}

}
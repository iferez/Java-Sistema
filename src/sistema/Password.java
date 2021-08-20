package sistema;

public class Password {

		private final int CANTIDAD_DE_MAYUSCULAS_MINIMAS = 1;
		private final int CANTIDAD_DE_MINUSCULAS_MINIMAS = 1;
		private final int CANTIDAD_DE_NUMEROS_MINIMAS = 2;
		private String valor;

		public boolean esFuerte(String deseada) {
			final int PRIMER_CARACTER_NUMERICO = 48;
			final int ULTIMO_CARACTER_NUMERICO = 57;
			final int PRIMER_CARACTER_MAYUSCULA = 65;
			final int ULTIMO_CARACTER_MAYUSCULA = 90;
			final int PRIMER_CARACTER_MINUSCULAS = 97;
			final int ULTIMO_CARACTER_MINUSCULAS = 122;
			int cantidadDeMayusculas = 0, cantidadDeMinusculas = 0, cantidadDeNumeros = 0;
			cantidadDeMayusculas = contarCaracteresSegunSuTipo(deseada, PRIMER_CARACTER_MAYUSCULA,
					ULTIMO_CARACTER_MAYUSCULA);
			cantidadDeMinusculas = contarCaracteresSegunSuTipo(deseada, PRIMER_CARACTER_MINUSCULAS,
					ULTIMO_CARACTER_MINUSCULAS);
			cantidadDeNumeros = contarCaracteresSegunSuTipo(deseada, PRIMER_CARACTER_NUMERICO, ULTIMO_CARACTER_NUMERICO);
			
			boolean resultado = false;

			if (cantidadDeMayusculas >= CANTIDAD_DE_MAYUSCULAS_MINIMAS
					&& cantidadDeMinusculas >= CANTIDAD_DE_MINUSCULAS_MINIMAS
					&& cantidadDeNumeros >= CANTIDAD_DE_NUMEROS_MINIMAS) {
				resultado = true;
			}
				return resultado;
		}

		private int contarCaracteresSegunSuTipo(String conLosCaracteres, int posicionAscciInicial, int posicionAsciiFinal) {

			int cantidadDeCaracteresDeEsteTipo = 0;

			for (int i = 0; i < conLosCaracteres.length(); i++) {
				if (conLosCaracteres.charAt(i) >= posicionAscciInicial
						&& conLosCaracteres.charAt(i) <= posicionAsciiFinal) {
					cantidadDeCaracteresDeEsteTipo++;

				}
			}
			return cantidadDeCaracteresDeEsteTipo;
		}

		public void setValor(String valor) {
			if (esFuerte(valor)) {
				this.valor = valor;
			}
		}

		public String getValor() {
			return valor;
		}
	}


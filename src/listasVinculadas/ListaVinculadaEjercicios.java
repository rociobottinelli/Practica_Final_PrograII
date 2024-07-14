package listasVinculadas;

public class ListaVinculadaEjercicios {
	class Nodo {
		int valor;
		Nodo siguiente;

		public Nodo(int valor) {
			this.valor = valor;
			this.siguiente = null;
		}
	}

	private Nodo cabeza;

	// Constructor
	public ListaVinculadaEjercicios() {
		this.cabeza = null;
	}

	// a. Método para determinar si la lista está vacía
	public boolean listaVacia() {
		return cabeza == null;
	}

	// b. Método para agregar un elemento
	public void agregar(int valor) {
		Nodo nuevoNodo = new Nodo(valor);
		nuevoNodo.siguiente = cabeza;
		cabeza = nuevoNodo;
	}

	// c. Método para eliminar la primera ocurrencia de un valor
	public boolean eliminarPrimeraOcurrencia(int valor) {
		Nodo actual = cabeza;
		Nodo previo = null;

		while (actual != null && actual.valor != valor) {
			previo = actual;
			actual = actual.siguiente;
		}

		if (actual == null) {
			return false; // No se encontró el valor
		}

		if (previo == null) {
			cabeza = actual.siguiente; // Eliminar la cabeza
		} else {
			previo.siguiente = actual.siguiente; // Eliminar nodo intermedio
		}

		actual.siguiente = null; // Desreferenciar nodo eliminado
		return true;
	}

	// d. Método para buscar la primera ocurrencia de un valor
	public Nodo buscar(int valor) {
		Nodo actual = cabeza;

		while (actual != null) {
			if (actual.valor == valor) {
				return actual;
			}
			actual = actual.siguiente;
		}

		return null; // No se encontró el valor
	}

	// e. Método para eliminar TODAS las ocurrencias de un valor
	public void eliminarTodasLasOcurrencias(int valor) {
		Nodo actual = cabeza;
		Nodo previo = null;

		while (actual != null) {
			if (actual.valor == valor) {
				if (previo == null) {
					cabeza = actual.siguiente; // Eliminar la cabeza
				} else {
					previo.siguiente = actual.siguiente; // Eliminar nodo intermedio
				}
				Nodo temp = actual;
				actual = actual.siguiente;
				temp.siguiente = null; // Desreferenciar nodo eliminado
			} else {
				previo = actual;
				actual = actual.siguiente;
			}
		}
	}

	// f. Método para convertir a un solo String
	public String convertirAString() {
		StringBuilder sb = new StringBuilder();
		Nodo actual = cabeza;

		while (actual != null) {
			sb.append(actual.valor);
			if (actual.siguiente != null) {
				sb.append(" -> ");
			}
			actual = actual.siguiente;
		}

		return sb.toString();
	}

}

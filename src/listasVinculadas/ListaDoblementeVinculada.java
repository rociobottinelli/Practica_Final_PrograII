package listasVinculadas;

public class ListaDoblementeVinculada {
	class Nodo {
	    int valor;
	    Nodo siguiente;
	    Nodo anterior;

	    public Nodo(int valor) {
	        this.valor = valor;
	        this.siguiente = null;
	        this.anterior = null;
	    }
	}
	 private Nodo cabeza;
	    private Nodo cola;

	    // Constructor
	    public ListaDoblementeVinculada() {
	        this.cabeza = null;
	        this.cola = null;
	    }

	    // a. Método para determinar si la lista está vacía
	    public boolean listaVacia() {
	        return cabeza == null;
	    }

	    // b. Método para agregar un elemento al final
	    public void agregar(int valor) {
	        Nodo nuevoNodo = new Nodo(valor);
	        if (listaVacia()) {
	            cabeza = nuevoNodo;
	            cola = nuevoNodo;
	        } else {
	            cola.siguiente = nuevoNodo;
	            nuevoNodo.anterior = cola;
	            cola = nuevoNodo;
	        }
	    }

	    // c. Método para eliminar la primera ocurrencia de un valor
	    public boolean eliminarPrimeraOcurrencia(int valor) {
	        Nodo actual = cabeza;

	        while (actual != null && actual.valor != valor) {
	            actual = actual.siguiente;
	        }

	        if (actual == null) {
	            return false; // No se encontró el valor
	        }

	        if (actual.anterior == null) {
	            cabeza = actual.siguiente; // Eliminar la cabeza
	            if (cabeza != null) {
	                cabeza.anterior = null;
	            }
	        } else {
	            actual.anterior.siguiente = actual.siguiente;
	        }

	        if (actual.siguiente == null) {
	            cola = actual.anterior; // Eliminar la cola
	        } else {
	            actual.siguiente.anterior = actual.anterior;
	        }

	        actual.siguiente = null; // Desreferenciar nodo eliminado
	        actual.anterior = null;
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

	        while (actual != null) {
	            if (actual.valor == valor) {
	                Nodo siguiente = actual.siguiente;
	                if (actual.anterior == null) {
	                    cabeza = siguiente; // Eliminar la cabeza
	                    if (cabeza != null) {
	                        cabeza.anterior = null;
	                    }
	                } else {
	                    actual.anterior.siguiente = siguiente;
	                }

	                if (siguiente == null) {
	                    cola = actual.anterior; // Eliminar la cola
	                } else {
	                    siguiente.anterior = actual.anterior;
	                }

	                actual.siguiente = null; // Desreferenciar nodo eliminado
	                actual.anterior = null;
	                actual = siguiente;
	            } else {
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
	                sb.append(" <-> ");
	            }
	            actual = actual.siguiente;
	        }

	        return sb.toString();
	    }

}

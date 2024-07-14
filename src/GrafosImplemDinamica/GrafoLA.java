package GrafosImplemDinamica;

import Grafos.GrafoTDA;
import api.ConjuntoTDA;
import implemDinamica.ConjuntoLD;

public class GrafoLA implements GrafoTDA {
	class NodoGrafo {
		int nodo;
		NodoArista arista;
		NodoGrafo sigNodo;
	}

	class NodoArista {
		int etiqueta; // va a ser el peso
		NodoGrafo nodoDestino;
		NodoArista sigArista;
	}

	NodoGrafo origen;

	// Funcion extra
	// Me pasan un vertice y yo les devuelvo su NodoGrafo
	private NodoGrafo Vert2Nodo(int v) {
		NodoGrafo aux = origen;
		while (aux != null && aux.nodo != v) {
			aux = aux.sigNodo;
		}
		return aux;
	}

	/*
	 * Si en las aristas del nodo que le pasamos existe una arista hacia v , la
	 * elimina
	 */
	private void EliminarAristaNodo(NodoGrafo nodo, int v) {
		NodoArista aux = nodo.arista;

		if (aux != null) {
			// Si la arista a eliminar es la primera en
			// la lista de nodos adyacentes
			if (aux.nodoDestino.nodo == v) {
				nodo.arista = aux.sigArista;
			} else {
				while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v) {
					aux = aux.sigArista;
				}
				if (aux.sigArista != null) {
					// Quita la referencua a la arista hacia v
					aux.sigArista = aux.sigArista.sigArista;
				}
			}
		}
	}

	@Override
	public void InicializarGrafo() {
		// TODO Auto-generated method stub
		origen = null;
	}

	@Override
	public void AgregarVertice(int v) {
		// TODO Auto-generated method stub
		// El vertice se inserta al inicio de la lista de nodos
		NodoGrafo aux = new NodoGrafo();
		aux.nodo = v;
		aux.arista = null;
		aux.sigNodo = origen;
		origen = aux;
	}

	@Override
	public void EliminarVertice(int v) {
		// TODO Auto-generated method stub
		// Se recorre la lista de v´ertices para remover el nodo v
		// y las aristas con este v´ertice.

		// Distingue el caso que sea el primer nodo
		if (origen.nodo == v) {
			origen = origen.sigNodo;
		}

		NodoGrafo aux = origen;
		while (aux != null) {
			// remueve de aux todas las aristas hacia V
			this.EliminarAristaNodo(aux, v);

			if (aux.sigNodo != null && aux.sigNodo.nodo == v) {
				// Si el siguiente nodo de aux es v, lo elimina
				aux.sigNodo = aux.sigNodo.sigNodo;

			}
			aux = aux.sigNodo;
		}

	}
	/*
	 * Si en las aristas del nodo existe una arista hacia v , la elimina
	 */

	@Override
	public ConjuntoTDA Vertices() {
		// TODO Auto-generated method stub
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		NodoGrafo aux = origen;
		while (aux != null) {
			c.Agregar(aux.nodo);
			aux = aux.sigNodo;
		}
		return c;
	}

	/*
	 * Para agregar una nueva arista al grafo , primero se deben buscar los nodos
	 * entre los cuales se va agregar la arista , y luego se inserta sobre la lista
	 * de adyacentes del nodo origen ( en este caso nombrado como v1)
	 */
	@Override
	public void AgregarArista(int v1, int v2, int peso) {
		// TODO Auto-generated method stub
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoGrafo n2 = Vert2Nodo(v2);

		// La nueva arista se inserta al inicio de la
		// lista de nodos adyacentes del nodo origen
		NodoArista aux = new NodoArista();
		aux.etiqueta = peso;
		aux.nodoDestino = n2;
		aux.sigArista = n1.arista;
		n1.arista = aux;

	}

	/*
	 * Se elimina la arista que tiene como origen al v´ertice v1 y destino al
	 * v´ertice v2
	 */

	@Override
	public void EliminarArista(int v1, int v2) {
		// TODO Auto-generated method stub
		NodoGrafo n1 = Vert2Nodo(v1);
		EliminarAristaNodo(n1, v2);

	}

	@Override
	public boolean ExisteArista(int v1, int v2) {
		// TODO Auto-generated method stub
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoArista aux = n1.arista;

		while (aux != null && aux.nodoDestino.nodo != v2) {
			aux = aux.sigArista;
		}
		// Solo si se encontro la arista buscada, aux no esta null
		return aux != null;
	}

	@Override
	public int PesoArista(int v1, int v2) {
		// TODO Auto-generated method stub
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoArista aux = n1.arista;
		while (aux.nodoDestino.nodo != v1) {
			aux = aux.sigArista;
		}
		// Se encontr´o la arista entre los dos nodos
		return aux.etiqueta;
	}

}

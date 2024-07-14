package implemDinamica;

import api.ColaConPrioridadTDA;

class NodoColaPrioridad {
	int info;
	int prioridad;
	NodoColaPrioridad sig;
}

public class ColaConPrioridadLD implements ColaConPrioridadTDA {

	NodoColaPrioridad mayorPrioridad; // puntero al elemento con mayor prioridad

	@Override
	public void InicializarCola() {
		// TODO Auto-generated method stub
		mayorPrioridad = null;

	}

	@Override
	public void AcolarPrioridad(int x, int prioridad) {
		// TODO Auto-generated method stub
		// creo el nuevo nodo a acolar
		NodoColaPrioridad nuevo = new NodoColaPrioridad();
		nuevo.info = x;
		nuevo.prioridad = prioridad;

		// Si la cola esta vacia o bien es mas prioritario que el primero, hay que
		// agregarlo al principio.
		if (mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) {
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
		} else {
			// Sabemos que mayorPrioridad no es null
			NodoColaPrioridad aux = mayorPrioridad;
			while (aux.sig != null && aux.sig.prioridad >= prioridad) {
				aux = aux.sig;
			}
			nuevo.sig = aux.sig;
			aux.sig = nuevo;
		}
	}

	@Override
	public void Desacolar() {
		// TODO Auto-generated method stub
		mayorPrioridad = mayorPrioridad.sig;
	}

	@Override
	public boolean ColaVacia() {
		// TODO Auto-generated method stub
		return (mayorPrioridad == null);
	}

	@Override
	public int Primero() {
		// TODO Auto-generated method stub
		return mayorPrioridad.info;
	}

	@Override
	public int Prioridad() {
		// TODO Auto-generated method stub
		return mayorPrioridad.prioridad;
	}

}

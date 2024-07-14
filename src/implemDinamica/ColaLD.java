package implemDinamica;

import api.ColaTDA;

class NodoCola {
	int info;
	NodoCola sig;
}

public class ColaLD implements ColaTDA {
	NodoCola primero;
	NodoCola ultimo;

	@Override
	public void InicializarCola() {
		// TODO Auto-generated method stub
		primero = null;
		ultimo = null;

	}

	@Override
	public void Acolar(int x) {
		// TODO Auto-generated method stub
		NodoCola aux = new NodoCola();
		aux.info = x;
		aux.sig = null;

		// Si la cola no esta vacia
		if (ultimo != null) {
			ultimo.sig = aux;
		}
		ultimo = aux;

		// Si la cola estaba vacia
		if (primero == null) {
			primero = ultimo;
		}

	}

	@Override
	public void Desacolar() {
		// TODO Auto-generated method stub
		primero = primero.sig;

		// Si la cola queda vacia
		if (primero == null) {
			ultimo = null;
		}

	}

	@Override
	public boolean ColaVacia() {
		// TODO Auto-generated method stub
		return (ultimo == null);
	}

	@Override
	public int Primero() {
		// TODO Auto-generated method stub
		return primero.info;
	}

}

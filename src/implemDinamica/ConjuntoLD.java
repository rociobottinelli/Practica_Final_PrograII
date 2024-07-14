package implemDinamica;

import api.ConjuntoTDA;

class NodoConjunto {
	int info;
	NodoConjunto sig;
}

public class ConjuntoLD implements ConjuntoTDA {
	NodoConjunto c;

	@Override
	public void InicializarConjunto() {
		// TODO Auto-generated method stub
		c = null;

	}

	@Override
	public boolean ConjuntoVacio() {
		// TODO Auto-generated method stub
		return (c == null);
	}

	@Override
	public void Agregar(int x) {
		// TODO Auto-generated method stub
		// Verifica que X no este en el conjunto
		if (!this.Pertenece(x)) {
			NodoConjunto aux = new NodoConjunto();
			aux.info = x;
			aux.sig = c;
			c = aux;
		}
	}

	@Override
	public int Elegir() {
		// TODO Auto-generated method stub
		return c.info;
	}

	@Override
	public void Sacar(int x) {
		// TODO Auto-generated method stub
		if (c != null) {
			// Si es el primer elemento de la lista
			if (c.info == x) {
				c = c.sig;
			} else {
				NodoConjunto aux = c;
				while (aux.sig != null && aux.sig.info != x) {
					aux = aux.sig;
				}
				if (aux.sig != null) {
					aux.sig = aux.sig.sig;
				}
			}
		}

	}

	@Override
	public boolean Pertenece(int x) {
		// TODO Auto-generated method stub
		NodoConjunto aux = c;
		while ((aux != null) && (aux.info != x)) {
			aux = aux.sig;
		}
		return (aux != null);
	}

}

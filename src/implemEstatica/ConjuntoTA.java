package implemEstatica;

import api.ConjuntoTDA;

public class ConjuntoTA implements ConjuntoTDA {
	int[] a;
	int cant;

	@Override
	public void InicializarConjunto() {
		// TODO Auto-generated method stub
		a = new int[100];
		cant = 0;
	}

	@Override
	public boolean ConjuntoVacio() {
		// TODO Auto-generated method stub
		return cant == 0;
	}

	@Override
	public void Agregar(int x) {
		// TODO Auto-generated method stub
		if (!this.Pertenece(x)) {
			a[cant] = x;
			cant++;
		}

	}

	@Override
	public int Elegir() {
		// TODO Auto-generated method stub
		return a[cant - 1];
	}

	@Override
	public void Sacar(int x) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < cant && a[i] != x) {
			i++;
		}
		if (i < cant) {
			a[i] = a[cant - 1];
			cant--;
		}

	}

	@Override
	public boolean Pertenece(int x) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < cant && a[i] != x) {
			i++;
		}
		return (i < cant);
	}

}

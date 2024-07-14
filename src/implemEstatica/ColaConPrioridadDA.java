package implemEstatica;

import api.ColaConPrioridadTDA;

public class ColaConPrioridadDA implements ColaConPrioridadTDA {
	int[] elementos;
	int[] prioridades;
	int indice;

	@Override
	public void InicializarCola() {
		// TODO Auto-generated method stub
		indice = 0;
		elementos = new int[100];
		prioridades = new int[100];
	}

	@Override
	public void AcolarPrioridad(int x, int prioridad) {
		// TODO Auto-generated method stub
		// Desplaza a derecha los elementos de la cola mientras estos tengan mayor o
		// igual prioridad que la de X
		int j = indice;
		for (; j > 0 && prioridades[j - 1] >= prioridad; j--) {
			elementos[j] = elementos[j - 1];
			prioridades[j] = prioridades[j - 1];
		}
		elementos[j] = x;
		prioridades[j] = prioridad;
		indice++;
	}

	@Override
	public void Desacolar() {
		// TODO Auto-generated method stub
		indice--;
	}

	@Override
	public boolean ColaVacia() {
		// TODO Auto-generated method stub
		return (indice == 0);
	}

	@Override
	public int Primero() {
		// TODO Auto-generated method stub
		return elementos[indice - 1];
	}

	@Override
	public int Prioridad() {
		// TODO Auto-generated method stub
		return prioridades[indice - 1];
	}

}

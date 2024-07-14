package implemEstatica;

import api.ColaTDA;

public class ColaPI implements ColaTDA {
	int[] arr; // Arreglo que contiene la información
	int index; // # de elementos en la cola

	@Override
	public void InicializarCola() {
		// TODO Auto-generated method stub
		arr = new int[100];
		index = 0;
	}

	@Override
	public void Acolar(int x) {
		// TODO Auto-generated method stub
		arr[index] = x;
		index++;
	}

	@Override
	public void Desacolar() {
		// TODO Auto-generated method stub
		for (int i = 0; i < index - 1; i++) {
			arr[i] = arr[i + 1]; // Elimina el que esta adelante de todo en la cola y muevo todos los demas una
									// posición hacia adelante
		}
		index--;

	}

	@Override
	public boolean ColaVacia() {
		// TODO Auto-generated method stub
		return (index == 0);
	}

	@Override
	public int Primero() {
		// TODO Auto-generated method stub
		return arr[0];
	}

}

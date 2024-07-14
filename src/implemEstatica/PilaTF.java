package implemEstatica;

import api.PilaTDA;

public class PilaTF implements PilaTDA {

	int[] a; // arreglo donde guardo info
	int indice; // variable donde guardo # de elementos que tengo guardados

	@Override
	public void InicializarPila() {
		// TODO Auto-generated method stub
		a = new int[100];
		indice = 0;
	}

	@Override
	public void Apilar(int x) {
		// TODO Auto-generated method stub
		a[indice] = x;
		indice++;
	}

	@Override
	public void Desapilar() {
		// TODO Auto-generated method stub
		indice--;

	}

	@Override
	public boolean PilaVacia() {
		// TODO Auto-generated method stub
		return (indice == 0);
	}

	@Override
	public int Tope() {
		// TODO Auto-generated method stub
		return a[indice - 1];
	}

}

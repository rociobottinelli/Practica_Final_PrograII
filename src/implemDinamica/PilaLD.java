package implemDinamica;

import api.PilaTDA;

class NodoPila {
	int info;
	NodoPila sig;
}

public class PilaLD implements PilaTDA {
	NodoPila primero; //puntero
	
	@Override
	public void InicializarPila() {
		// TODO Auto-generated method stub
		primero = null;

	}

	@Override
	public void Apilar(int x) {
		// TODO Auto-generated method stub
		NodoPila aux = new NodoPila();
		aux.info = x;
		aux.sig = primero;
		primero = aux;

	}

	@Override
	public void Desapilar() {
		// TODO Auto-generated method stub
		primero = primero.sig;

	}

	@Override
	public boolean PilaVacia() {
		// TODO Auto-generated method stub
		return (primero == null);
	}

	@Override
	public int Tope() {
		// TODO Auto-generated method stub
		return primero.info;
	}

}

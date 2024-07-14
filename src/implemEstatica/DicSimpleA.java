package implemEstatica;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import implemDinamica.ConjuntoLD;

public class DicSimpleA implements DiccionarioSimpleTDA {

	class Elemento {
		int clave;
		int valor;
	}

	Elemento[] elementos;
	int cant;

	private int Clave2Indice(int clave) {
		int i = cant - 1;
		while (i >= 0 && elementos[i].clave != clave) {
			i--;
		}
		return i;

	}

	@Override
	public void InicializarDiccionario() {
		// TODO Auto-generated method stub
		cant = 0;
		elementos = new Elemento[100];
	}

	@Override
	public void Agregar(int clave, int valor) {
		// TODO Auto-generated method stub
		int pos = Clave2Indice(clave);
		if (pos == -1) {
			pos = cant;
			elementos[pos] = new Elemento();
			elementos[pos].clave = clave;
			cant++;
		}
		elementos[pos].valor = valor;
	}

	@Override
	public void Eliminar(int clave) {
		// TODO Auto-generated method stub
		int pos = Clave2Indice(clave);
		if (pos != -1) {
			elementos[pos] = elementos[cant - 1];
			cant--;
		}

	}

	@Override
	public int Recuperar(int clave) {
		// TODO Auto-generated method stub
		int pos = Clave2Indice(clave);
		return elementos[pos].valor;
	}

	@Override
	public ConjuntoTDA Claves() {
		// TODO Auto-generated method stub
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();

		for (int i = 0; i < cant; i++) {
			c.Agregar(elementos[i].clave);

		}
		return c;
	}

}

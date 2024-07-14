package implemEstatica;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import implemDinamica.ConjuntoLD;

public class DicMultipleA implements DiccionarioMultipleTDA {

	class Elemento {
		int clave;
		int[] valores;
		int cantValores;
	}

	Elemento[] elementos;
	int cantClaves;

	private int Clave2Indice(int clave) {
		int i = cantClaves - 1;
		while (i >= 0 && elementos[i].clave != clave) {
			i--;
		}
		return i;
	}

	private int Valor2Indice(Elemento e, int valor) {
		int i = e.cantValores - 1;
		while (i >= 0 && e.valores[i] != valor) {
			i--;
		}
		return i;
	}

	@Override
	public void InicializarDiccionario() {
		// TODO Auto-generated method stub
		elementos = new Elemento[100];
		cantClaves = 0;

	}

	@Override
	public void Agregar(int clave, int valor) {
		// TODO Auto-generated method stub
		int posC = Clave2Indice(clave);
		if (posC == -1) {
			posC = cantClaves;
			elementos[posC] = new Elemento();
			elementos[posC].clave = clave;
			elementos[posC].cantValores = 0;
			elementos[posC].valores = new int[100];
			cantClaves++;
		}
		Elemento e = elementos[posC];
		int posV = Valor2Indice(e, valor);
		if (posV == -1) {
			e.valores[e.cantValores] = valor;
			e.cantValores++;
		}

	}

	@Override
	public void Eliminar(int clave) {
		// TODO Auto-generated method stub
		int pos = Clave2Indice(clave);
		if (pos != -1) {
			elementos[pos] = elementos[cantClaves - 1];
			cantClaves--;
		}

	}

	@Override
	public void EliminarValor(int clave, int valor) {
		// TODO Auto-generated method stub
		int posC = Clave2Indice(clave);
		if (posC != -1) {
			Elemento e = elementos[posC];
			int posV = Valor2Indice(e, valor);
			if (posV != -1) {
				e.valores[posV] = e.valores[e.cantValores - 1];
				e.cantValores--;
				if (e.cantValores == 0) {
					Eliminar(clave);
				}
			}
		}

	}

	@Override
	public ConjuntoTDA Recuperar(int clave) {
		// TODO Auto-generated method stub
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();

		int pos = Clave2Indice(clave);
		if (pos != -1) {
			Elemento e = elementos[pos];
			for (int i = 0; i < e.cantValores; i++) {
				c.Agregar(e.valores[i]);
			}
		}
		return c;
	}

	@Override
	public ConjuntoTDA Claves() {
		// TODO Auto-generated method stub
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();

		for (int i = 0; i < cantClaves; i++) {
			c.Agregar(elementos[i].clave);
		}
		return c;
	}

}

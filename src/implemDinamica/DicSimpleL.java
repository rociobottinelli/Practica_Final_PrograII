package implemDinamica;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DicSimpleL implements DiccionarioSimpleTDA {
	class NodoClave {
		int clave;
		int valor;
		NodoClave sigClave;
	}

	NodoClave origen;

	private NodoClave Clave2NodoClave(int clave) {
		NodoClave aux = origen;
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux;
	}

	@Override
	public void InicializarDiccionario() {
		// TODO Auto-generated method stub
		origen = null;
	}

	@Override
	public void Agregar(int clave, int valor) {
		// TODO Auto-generated method stub
		NodoClave nc = Clave2NodoClave(clave);
		if (nc == null) {
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc;
		}
		nc.valor = valor;

	}

	@Override
	public void Eliminar(int clave) {
		// TODO Auto-generated method stub
		if (origen != null) {
			if (origen.clave == clave) {
				origen = origen.sigClave;
			} else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}

	}

	@Override
	public int Recuperar(int clave) {
		// TODO Auto-generated method stub
		NodoClave n = Clave2NodoClave(clave);
		return n.valor;
	}

	@Override
	public ConjuntoTDA Claves() {
		// TODO Auto-generated method stub
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		
		NodoClave aux = origen;
		while (aux != null) {
			c.Agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;
	}

}

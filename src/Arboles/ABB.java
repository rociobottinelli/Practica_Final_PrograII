package Arboles;

public class ABB implements ABBTDA {
	class NodoABB {
		int info;
		ABBTDA HijoIzq;
		ABBTDA HijoDer;
	}

	NodoABB raiz;

	// METODOS PRIVADOS QUE USAMOS
	// Busca el valor mas grande en un Arbol
	private int mayor(ABBTDA a) {
		if (a.HijoDer().ArbolVacio()) {
			return a.Raiz();
		} else {
			return mayor(a.HijoDer());
			// Si el hijo derecho no está vacío,
			// llama recursivamente a la función mayor
			// con el hijo derecho como argumento.
			// Esto implica que la función buscará el valor más grande
			// en el subárbol derecho de manera recursiva hasta encontrar
			// el nodo más a la derecha (que es el mayor valor en un ABB).
		}
	}

	// Busca el valor menos en un arbol
	private int menor(ABBTDA a) {
		if (a.HijoIzq().ArbolVacio()) {
			return a.Raiz();
		} else {
			return menor(a.HijoIzq());
		}
	}

	@Override
	public void InicializarArbol() {
		// TODO Auto-generated method stub
		raiz = null;
	}

	@Override
	public int Raiz() {
		// TODO Auto-generated method stub
		return raiz.info;
	}

	@Override
	public ABBTDA HijoIzq() {
		// TODO Auto-generated method stub
		return raiz.HijoIzq;
	}

	@Override
	public ABBTDA HijoDer() {
		// TODO Auto-generated method stub
		return raiz.HijoDer;
	}

	@Override
	public boolean ArbolVacio() {
		// TODO Auto-generated method stub
		return (raiz == null);
	}

	@Override
	public void AgregarElem(int x) {
		// TODO Auto-generated method stub
		if (raiz == null) {
			raiz = new NodoABB();
			raiz.info = x;
			// Inicializo subarboles porque estaba en null
			raiz.HijoIzq = new ABB();
			raiz.HijoIzq.InicializarArbol();
			raiz.HijoDer = new ABB();
			raiz.HijoDer.InicializarArbol();

			// Agrego al lado segun si es de un lado o el otro
		} else if (raiz.info > x) {
			raiz.HijoIzq.AgregarElem(x);
		} else if (raiz.info < x) {
			raiz.HijoDer.AgregarElem(x);
		}

	}

	// Si lo encontramos, lo reemplazamos con el mayor elemento de su sub-árbol
	// izquierdo.
	// Si no tiene sub-árbol izquierdo, lo reemplazamos con el menor elemento de su
	// sub-árbol derecho.
	// Si tampoco tiene sub-árbol derecho, es una hoja y lo reemplazamos por null.
	@Override
	public void EliminarElem(int x) {
		// TODO Auto-generated method stub
		if (raiz != null) {
			if (raiz.info == x && raiz.HijoIzq.ArbolVacio() && raiz.HijoDer.ArbolVacio()) {
				raiz = null;
			} else if (raiz.info == x && !raiz.HijoIzq.ArbolVacio()) {
				raiz.info = this.mayor(raiz.HijoIzq); // Asigna al elemento mas grande del subarbol izquiero
				raiz.HijoIzq.EliminarElem(raiz.info); // Y lo elimino del subarbol
			} else if (raiz.info == x && raiz.HijoIzq.ArbolVacio()) {
				raiz.info = this.menor(raiz.HijoDer);
				raiz.HijoDer.EliminarElem(raiz.info);
			} else if (raiz.info < x) {
				// Y finalmente si es mayor q la raiz lo mando a buscarlo recursivamente al lado
				// derecho
				raiz.HijoDer.EliminarElem(x);
			} else {
				raiz.HijoDer.EliminarElem(x);
			}
		}

	}
	
	// RECORRIDOS
	
	//#PRE-ORDER -> se visitan primero el padre y luego cada hijo comenzando por el izquierdo es visitado pre-order
	
	public void preOrder(ABBTDA a) {
		if(!a.ArbolVacio()) {
			System.out.println(a.Raiz());
			preOrder(a.HijoIzq());
			preOrder(a.HijoDer());
		}
	}
	
	//#IN-ORDER -> se visita primero el hijo izquierdo in-order, luego el padre y finalmente el hijo derecho in-order
	public void inOrder(ABBTDA a) {
		if(!a.ArbolVacio()) {
			inOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			inOrder(a.HijoDer());
		}
	}
	
	
	
	//#POST-ORDER -> se visita primero el hijo izquierdo post-order, luego el hijo derecho post-order y finalmente el padre
	public void postOrder(ABBTDA a) {
		if(!a.ArbolVacio()) {
			postOrder(a.HijoIzq());
			postOrder(a.HijoDer());
			System.out.println(a.Raiz());
		}
	}

}

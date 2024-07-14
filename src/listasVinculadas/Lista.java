package listasVinculadas;

public class Lista {
	Nodo primero;
	Nodo ultimo;

	public Lista() {
		this.primero = new Nodo();
	}

	public void add(int x) {
		Nodo nuevo = new Nodo();
		nuevo.setInfo(x);

		Nodo pivote = new Nodo();
		pivote = this.primero;
		while (pivote.getNext() != null) {
			pivote = pivote.getNext();
		}
		pivote.setNext(nuevo);
	}

	@Override
	public String toString() {
		Nodo pivote;
		String out = "";
		pivote = primero.getNext();
		while (pivote != null) {
			out = out + " " + pivote.getInfo();
			pivote = pivote.getNext();
		}
		return out;
	}

	public Nodo existe(int value) {
		Nodo pivote;
		String out = "";

		pivote = primero.getNext();
		while (pivote != null) {
			if (pivote.getInfo() == value) {
				return pivote;
			}
			pivote = pivote.getNext();
		}
		return null;

	}
	
	public void eliminar(int value) {
		Nodo prev;
		Nodo pivote;
		
		prev = this.primero;
		pivote = prev.getNext();
		while((pivote != null) && (pivote.getInfo() != value)) {
			prev = pivote;
			pivote = prev.getNext();
		}
		if(pivote != null) { //Lo circunvala
			prev.setNext(pivote.getNext());
		}
	}

}

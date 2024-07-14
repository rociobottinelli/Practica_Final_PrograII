package Arboles;

public class Main {
	public static void main(String[] args) {
		ABB arbol = new ABB();

		// Agregar elementos al árbol
		arbol.AgregarElem(50);
		arbol.AgregarElem(30);
		arbol.AgregarElem(70);
		arbol.AgregarElem(20);
		arbol.AgregarElem(40);
		arbol.AgregarElem(60);
		arbol.AgregarElem(80);

		// Mostrar la raíz del árbol
		System.out.println("Raíz del árbol: " + arbol.Raiz());

		// Eliminar un elemento del árbol y mostrar el árbol modificado
		int elementoAEliminar = 30;
		System.out.println("Eliminando el elemento " + elementoAEliminar + " del árbol...");
		arbol.EliminarElem(elementoAEliminar);

		// Mostrar el árbol después de eliminar el elemento
		System.out.println("Elementos restantes en el árbol después de eliminar " + elementoAEliminar + ":");
		imprimirArbol(arbol);
		System.out.println("Pre order");
		arbol.preOrder(arbol);
		System.out.println("In order"); //los deja en orden ascendente
		arbol.inOrder(arbol);
		System.out.println("Post order");
		arbol.postOrder(arbol);
	}

	// Función auxiliar para imprimir el árbol
	private static void imprimirArbol(ABBTDA arbol) {
		if (!arbol.ArbolVacio()) {
			imprimirArbol(arbol.HijoIzq());
			System.out.print(arbol.Raiz() + " ");
			imprimirArbol(arbol.HijoDer());
		}
	}
}

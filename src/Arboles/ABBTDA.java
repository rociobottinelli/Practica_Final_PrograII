package Arboles;

public interface ABBTDA {
	void InicializarArbol();

	int Raiz();

	ABBTDA HijoIzq();

	ABBTDA HijoDer();

	boolean ArbolVacio();

	void AgregarElem(int x);

	void EliminarElem(int x);
}

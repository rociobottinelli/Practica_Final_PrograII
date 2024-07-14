package GrafosimplemEstatica;

import java.util.Iterator;

import Grafos.GrafoTDA;
import api.ConjuntoTDA;
import implemDinamica.ConjuntoLD;

//La implementación estatica es con la MATRIZ DE ADAYACENCIA.
//Ahora bien, en Java, los ındices de las matrices van de cero en adelante, en forma
//consecutiva. No es el caso de los nodos, que pueden tener valores no continuos.
//Por lo tanto, vamos a tener que utilizar un mapeo que nos indique en que ındice
//de la matriz est´a el nodo que buscamos. Entonces, al nombre del nodo lo vamos
//a llamar internamente etiqueta

public class GrafoMA implements GrafoTDA {
	static int n = 100;
	int[][] MAdy;
	int[] Etiqs;
	int cantNodos;

	// Funcion extra
	private int Vert2Indice(int v) {
		int i = cantNodos - 1;
		while (i >= 0 && Etiqs[i] != v) {
			i--; // Lo voy restando hasta que coincida y ahi lo devuelvo
		}
		return i; // Retorna en que indice esta el vertice que pase por parametro
	}

	@Override
	public void InicializarGrafo() {
		// TODO Auto-generated method stub
		MAdy = new int[n][n];
		Etiqs = new int[n];
		cantNodos = 0;

	}

	@Override
	public void AgregarVertice(int v) {
		// TODO Auto-generated method stub
		Etiqs[cantNodos] = v;
		for (int i = 0; i <= cantNodos; i++) {
			MAdy[cantNodos][i] = 0; // Inicializa la fila correspondiente al nuevo vértice en la matriz de
									// adyacencia.
			MAdy[i][cantNodos] = 0; // Inicializa la columna correspondiente al nuevo vértice en la matriz de
									// adyacencia.
		}
		cantNodos++;
	}

	@Override
	public void EliminarVertice(int v) {
		// TODO Auto-generated method stub
		int ind = Vert2Indice(v);
		for (int k = 0; k < cantNodos; k++) {
			MAdy[k][ind] = MAdy[k][cantNodos - 1]; // Reemplaza la columna del vértice a eliminar con la última columna.
		}
		for (int k = 0; k < cantNodos; k++) {
			MAdy[ind][k] = MAdy[cantNodos - 1][k]; // Reemplaza la fila del vértice a eliminar con la última fila.
		}
		Etiqs[ind] = Etiqs[cantNodos - 1]; // Reemplaza la etiqueta del vértice a eliminar con la última etiqueta.
		cantNodos--;

	}

	@Override
	public ConjuntoTDA Vertices() {
		// TODO Auto-generated method stub
		ConjuntoTDA Vert = new ConjuntoLD();
		Vert.InicializarConjunto();

		for (int i = 0; i < cantNodos; i++) {
			Vert.Agregar(Etiqs[i]);
		}
		return Vert;
	}

	@Override
	public void AgregarArista(int v1, int v2, int peso) {
		// TODO Auto-generated method stub
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		MAdy[o][d] = peso;

	}

	@Override
	public void EliminarArista(int v1, int v2) {
		// TODO Auto-generated method stub
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		MAdy[o][d] = 0;

	}

	@Override
	public boolean ExisteArista(int v1, int v2) {
		// TODO Auto-generated method stub
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		return MAdy[o][d] != 0;
	}

	@Override
	public int PesoArista(int v1, int v2) {
		// TODO Auto-generated method stub
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		return MAdy[o][d];

	}

}

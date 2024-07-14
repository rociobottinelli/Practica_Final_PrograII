package Grafos;

import GrafosimplemEstatica.GrafoMA;
import api.ConjuntoTDA;

public class MainMA {
	 public static void main(String[] args) {
	        GrafoMA grafo = new GrafoMA();
	        grafo.InicializarGrafo();

	        // Agregar vértices
	        grafo.AgregarVertice(1);
	        grafo.AgregarVertice(2);
	        grafo.AgregarVertice(3);
	        grafo.AgregarVertice(4);

	        // Agregar aristas
	        grafo.AgregarArista(1, 2, 10);
	        grafo.AgregarArista(2, 3, 20);
	        grafo.AgregarArista(3, 4, 30);
	        grafo.AgregarArista(4, 1, 40);

	        // Mostrar vértices
	        System.out.println("Vértices:");
	        ConjuntoTDA vertices = grafo.Vertices();
	        while (!vertices.ConjuntoVacio()) {
	            int vertice = vertices.Elegir();
	            System.out.println(vertice);
	            vertices.Sacar(vertice);
	        }

	        // Mostrar aristas y pesos
	        System.out.println("\nAristas:");
	        for (int i = 1; i <= 4; i++) {
	            for (int j = 1; j <= 4; j++) {
	                if (grafo.ExisteArista(i, j)) {
	                    System.out.println("Arista de " + i + " a " + j + " con peso " + grafo.PesoArista(i, j));
	                }
	            }
	        }

	        // Eliminar una arista
	        grafo.EliminarArista(1, 2);
	        System.out.println("\nArista de 1 a 2 eliminada.");

	        // Mostrar aristas y pesos nuevamente
	        System.out.println("\nAristas después de eliminar:");
	        for (int i = 1; i <= 4; i++) {
	            for (int j = 1; j <= 4; j++) {
	                if (grafo.ExisteArista(i, j)) {
	                    System.out.println("Arista de " + i + " a " + j + " con peso " + grafo.PesoArista(i, j));
	                }
	            }
	        }

	        // Eliminar un vértice
	        grafo.EliminarVertice(3);
	        System.out.println("\nVértice 3 eliminado.");
}
}
package ejecucion;

import implemDinamica.ColaConPrioridadLD;
import implemDinamica.ColaLD;
import implemDinamica.ConjuntoLD;
import implemDinamica.DicMultipleL;
import implemDinamica.DicSimpleL;
import implemDinamica.PilaLD;

public class Ejecucion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// PILA DINAMICA
		System.out.println("Pila dinamica");
		PilaLD pila = new PilaLD();
		pila.InicializarPila();
		pila.Apilar(3);
		pila.Apilar(56);
		System.out.println(pila.Tope());
		pila.Desapilar();
		System.out.println(pila.Tope());

		// COLA DINAMICA
		System.out.println("Cola Dinamica");
		ColaLD cola = new ColaLD();
		cola.InicializarCola();
		cola.Acolar(10);
		cola.Acolar(5);
		cola.Acolar(3);
		System.out.println("Antes de desacolar - primero: " + cola.Primero());
		cola.Desacolar();
		System.out.println("Luego de desacolar - primero: " + cola.Primero());

		// COLA CON PRIORIDAD DINAMICA
		ColaConPrioridadLD colaPrio = new ColaConPrioridadLD();
		colaPrio.InicializarCola();
		colaPrio.AcolarPrioridad(33, 10);
		colaPrio.AcolarPrioridad(36, 18);
		colaPrio.AcolarPrioridad(33, 3);
		System.out.println(colaPrio.Prioridad());
		System.out.println(colaPrio.Primero());
		colaPrio.Desacolar();
		System.out.println(colaPrio.Prioridad());
		System.out.println(colaPrio.Primero());

		// CONJUNTO DINAMICA
		System.out.println("Conjunto");
		ConjuntoLD conjunto = new ConjuntoLD();
		conjunto.InicializarConjunto();
		conjunto.Agregar(5);
		conjunto.Agregar(127);
		conjunto.Agregar(12);
		conjunto.Agregar(11);
		System.out.println(conjunto.Pertenece(1));
		System.out.println(conjunto.Pertenece(127));
		System.out.println(conjunto.Elegir());
		conjunto.Sacar(11);
		System.out.println(conjunto.Pertenece(11));

		// DICCIONARIO SIMPLE DINAMICA
		DicSimpleL dicSim = new DicSimpleL();
		dicSim.InicializarDiccionario();
		dicSim.Agregar(1, 10);
		dicSim.Agregar(5, 20);
		dicSim.Agregar(8, 45);
		System.out.println(dicSim.Recuperar(8));
		System.out.println(dicSim.Claves().Elegir());
		dicSim.Eliminar(1);
		System.out.println(dicSim.Claves().Elegir());

		// DICCIONARIO MULTIPLE DINAMICA
		DicMultipleL dicMul = new DicMultipleL();
		dicMul.InicializarDiccionario();
		dicMul.Agregar(2, 10);
		dicMul.Agregar(2, 40);
		dicMul.Agregar(2, 89);
		System.out.println(dicMul.Recuperar(2).Elegir());
		dicMul.EliminarValor(2, 10);
		dicMul.EliminarValor(2, 89);
		System.out.println(dicMul.Recuperar(2).Elegir());
		dicMul.Agregar(34, 189);
		System.out.println(dicMul.Recuperar(34).Elegir());

	}

}

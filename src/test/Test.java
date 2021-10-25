package test;


import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio3.Par;
import ejercicios.Ejercicio4;
import us.lsi.common.DoublePair;

public class Test {

	public static void main(String[] args) {
		// El predicado sobre String devuelve cierto si dicho String contiene alguna vocal abierta (es decir, a, e Ã³ o)
		// El predicado sobre Integer devuelve cierto si ese entero es par
		// La funciÃ³n String -> Integer devuelve la longitud de la cadena
		System.out.println("##################################################\r\n"
				+ "# Ejercicio 1                                    #\r\n"
				+ "# ficheros/PI1E1_DatosEntrada.txt                #\r\n"
				+ "##################################################");
		List<List<String>> ej1 = Ejercicio1.lector1("ficheros/PI1E1_DatosEntrada.txt");
		Predicate<String> pS = s -> s.contains("a") || s.contains("e") || s.contains("o");
		Predicate<Integer> pI = i -> i%2 == 0;
		Function<String, Integer> f = x -> x.length();
		for (int j = 0; j < ej1.size(); j++) {
			System.out.println("Entrada: " + ej1.get(j));
			System.out.println("1. Iterativa (while):        " + Ejercicio1.ejercicio1It(ej1.get(j), pS, pI, f));
			System.out.println("2. Recursiva final:        " + Ejercicio1.ejercicio1RecFin(ej1.get(j), pS, pI, f, 0));
			System.out.println("3. Funcional:        " + Ejercicio1.ejercicio1(ej1.get(j), pS, pI, f));
		}
		System.out.println("##################################################\n");
		
		System.out.println("##################################################\r\n"
				+ "# Ejercicio 2                                    #\r\n"
				+ "# ficheros/PI1E2_DatosEntrada1.txt               #\r\n"
				+ "##################################################");
		List<List<String>> ej21 = Ejercicio2.lector2("ficheros/PI1E2_DatosEntrada1.txt");
		List<List<String>> ej22 = Ejercicio2.lector2("ficheros/PI1E2_DatosEntrada2.txt");
		System.out.println("Entrada: " + ej21);
		System.out.println("1. Iterativa (while): " + Ejercicio2.ejercicio2It(ej21));
		System.out.println("3. Funcional: " + Ejercicio2.ejercicio2(ej21));
		System.out.println("##################################################\n");
		
		System.out.println("##################################################\r\n"
				+ "# Ejercicio 2                                    #\r\n"
				+ "# ficheros/PI1E2_DatosEntrada2.txt               #\r\n"
				+ "##################################################");
		System.out.println("Entrada: " + ej22);
		System.out.println("1. Iterativa (while): " + Ejercicio2.ejercicio2It(ej22));
		System.out.println("3. Funcional: " + Ejercicio2.ejercicio2(ej22));
		System.out.println("##################################################\n");
		
		List<Par> ej3 = Ejercicio3.lector3("ficheros/PI1E3_DatosEntrada.txt");
		System.out.println("##################################################\r\n"
				+ "# Ejercicio 3                                    #\r\n"
				+ "# ficheros/PI1E3_DatosEntrada.txt                #\r\n"
				+ "##################################################");
		for (int j = 0; j < ej3.size(); j++) {
			System.out.println("Entrada: " + ej3.get(j));
			System.out.println("1. Iterativa (while):        " + Ejercicio3.ejercicio3It(ej3.get(j).v1(), ej3.get(j).v2()));
			System.out.println("2. Recursiva final:        " + Ejercicio3.ejercicio3RecFin(ej3.get(j).v1(), ej3.get(j).v2()));
			System.out.println("3. Funcional:        " + Ejercicio3.ejercicio3(ej3.get(j).v1(), ej3.get(j).v2()));
		}
		System.out.println("##################################################\n");
		
		List<DoublePair> ej4 = Ejercicio4.lector4("ficheros/PI1E4_DatosEntrada.txt");
		System.out.println("##################################################\r\n"
				+ "# Ejercicio 4                                    #\r\n"
				+ "# ficheros/PI1E4_DatosEntrada.txt                #\r\n"
				+ "##################################################");
		for (int j = 0; j < ej4.size(); j++) {
			System.out.println("Entrada: " + ej4.get(j));
			System.out.println("1. Iterativa (while):        " + Ejercicio4.ejercicio4It(ej4.get(j).first(), ej4.get(j).second()));
			System.out.println("2. Recursiva final:        " + Ejercicio4.ejercicio4RecFin(ej4.get(j).first(), ej4.get(j).second()));
			System.out.println("3. Funcional:        " + Ejercicio4.ejercicio4Func(ej4.get(j).first(), ej4.get(j).second()));
		}
		
		
		}
	
		

	}



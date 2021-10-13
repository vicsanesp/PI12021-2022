package ejercicios;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.Files2;

public class Ejercicio3 {
	//Creación de la clase Par mediante record, así como del constructor que necesitamos
	public record Par(int v1, int v2) {
		public static Par of(int v1, int v2) {
			return new Par(v1, v2);
		}
	}
	//El método itera pares desde 0 hasta el límite, estos pares se van añadiendo a una lista
	//el primer valor sigue una secuencia lineal, mientras que el segundo va variando en función
	//de la condición t.v1 % 3 == 1
	//tras lo cual se crea el string de la lista final.
	public static String ejercicio3(Integer a, Integer limit) {
		return Stream
		.iterate(Par.of(0, a),
		t -> t.v1 < limit,
		t -> Par.of(t.v1+1, t.v1 % 3 == 1 ? t.v2 : t.v1+t.v2))
		.collect(Collectors.toList())
		.toString();
		}


	public static String ejercicio3It(Integer a, Integer limit) {
		//Nuestro contador
		int i = 0;
		//Nuestro acumulador
		String res = "";
		//El par que vamos a ir modificando para añadir a nuestro acumulador
		Par par = Par.of(0, a);
		while(i<a) {
			if(par.v1 % 3 == 1) {
				//Si se da la condición se añade al acumulador el string del par que queremos
				res += Par.of(i, par.v2).toString() + ", ";
				//A continuación actualizamos el par
				par = Par.of(i, par.v2);
			}
			else {
				//Si no se da la condición modificamos el par de otra manera, como indica en el enunciado
				res += Par.of(i, par.v1+par.v2).toString() + ", ";
				//A continuación también actualizamos el par
				par = Par.of(i, par.v1+par.v2);
			}
			i++;
		}
		return res;
	}
	
	public static String ejercicio3RecFin(Integer a, Integer limit) {
		return ejercicio3RecFinAux(a, limit, "", 0, Par.of(0, a));
	}
	
	public static String ejercicio3RecFinAux(Integer a, Integer limit, String res, Integer puntero, Par par) {
		if(puntero == limit-1) {
			res += Par.of(puntero, par.v2).toString();
			return res;
		}
		else {
			if(par.v1 % 3 == 1) {
				res += Par.of(puntero, par.v2).toString() + ", ";
				return ejercicio3RecFinAux(a, limit, res, puntero+1, Par.of(puntero, par.v2));
			}
			else {
				res += Par.of(puntero, par.v1 + par.v2).toString() + ", ";
				return ejercicio3RecFinAux(a, limit, res, puntero+1, Par.of(puntero, par.v1 + par.v2));
			}
		}
	}
	
	public static List<Par> lector3(String ruta){
		List<String> listaFichero = Files2.linesFromFile(ruta);
		List<Par> res = new ArrayList<>();
		for(String l:listaFichero) {
			String[] a = l.split(",");
			Par aux = Par.of(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
			res.add(aux);
		}
		return res;
	}
}

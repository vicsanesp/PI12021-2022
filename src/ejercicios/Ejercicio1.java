package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import us.lsi.common.Files2;

public class Ejercicio1 {

	//El método recorre la lista, le pasa un filtro, usa una función para contar las letras
	//de cada string y finalmente cesa cuando encuentra un elemento que coincide con el segundo predicado
	//tras lo cual retorna un true, o un false en caso de no encontrar ninguna coincidencia
	public static boolean ejercicio1(List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String,Integer> f){
			return ls.stream()
			.filter(pS)
			.map(f)
			.anyMatch(pI);
			}

	//Si tiene alguna vocal abierta y además el número de letras de la palabra es par, devuelve true y acaba el bucle
		public static boolean ejercicio1It(List<String> ls, Predicate<String> pS,
				Predicate<Integer> pI, Function<String,Integer> f){
			boolean res = false;
			int i = 0;
			while(i<ls.size()) {
				//filtro del string
				if(pS.test(ls.get(i))) {
					//filtro del integer + uso de la función
					if(pI.test(f.apply(ls.get(i)))) {
						res = true;
						//al dar con un elemento que cumple ambos filtros se acaba la iteración y se devuelve el boolean
						break;
					}
				}
				i++;
			}
			return res;
		}
		
		public static boolean ejercicio1RecFin(List<String> ls, Predicate<String> pS,
				Predicate<Integer> pI, Function<String,Integer> f, Integer puntero) {
			boolean res;
			if(pI.test(f.apply(ls.get(puntero))) && pS.test(ls.get(puntero))) {
				res = true;
				return res;
			}
			
			else {
				if(puntero == ls.size()-1) {
					res = false;
					return res;
				}
				return ejercicio1RecFin(ls, pS, pI, f, puntero+1);
			}
		}
		
		public static List<List<String>> lector1(String ruta){
			List<List<String>> res = new ArrayList<>();
			List<String> listaFichero = Files2.linesFromFile(ruta);
			for(String l:listaFichero) {
				String[] a = l.split(",");
				List<String> aux = new ArrayList<>();
				for (int i = 0; i < a.length; i++) {
					aux.add(a[i]);
				}
				res.add(aux);
			}
			return res;
		}
}

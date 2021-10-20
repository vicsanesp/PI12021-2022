package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import us.lsi.common.Files2;

public class Ejercicio2 {

	public static Map<Integer,List<String>> ejercicio2 (List<List<String>> listas) {
		return listas.stream()
		.flatMap(lista -> lista.stream())
		.collect(Collectors.groupingBy(String::length));
		}
	
	public static Map<Integer,List<String>> ejercicio2It (List<List<String>> listas){
		//a partir de la lista crear un diccionario que agrupe el número de carácteres con una lista con las palabras de ese número de carácteres
		Map<Integer,List<String>> dic = new TreeMap<>();
		int i = 0;
		while(i<listas.size()) {
			int j = 0;
			while(j<listas.get(i).size()) {
				String palabra = listas.get(i).get(j);
				Integer longitudCadena = listas.get(i).get(j).length();
				if(!dic.containsKey(longitudCadena)) {
					List<String> aux = new ArrayList<>();
					aux.add(palabra);
					dic.put(longitudCadena, aux);
				}
				else {
					dic.get(longitudCadena).add(palabra);
				}
				j++;
			}
			i++;
		}
		return dic;
		}
	
	public static Map<Integer, List<String>> ejercicio2RecFin(List<List<String>> listas){
		return ejercicio2RecFinAux(listas, new HashMap<Integer, List<String>>(), 0, 0);
	}
	
	public static Map<Integer, List<String>> ejercicio2RecFinAux(List<List<String>> listas, Map<Integer, List<String>> dic, Integer punteroExt, Integer punteroInt){
		Integer longitudPalabra = listas.get(punteroExt).get(punteroInt).length();
		String palabra = listas.get(punteroExt).get(punteroInt);
		if(punteroExt == listas.size()-1 && punteroInt == listas.get(punteroExt).size()-1) {
			if(!dic.containsKey(longitudPalabra)) {
				List<String> aux = new ArrayList<>();
				aux.add(palabra);
				dic.put(longitudPalabra, aux);
				return dic;
			}
			else {
				dic.get(longitudPalabra).add(palabra);
				return dic;
			}
		}
		else {
			if(!dic.containsKey(longitudPalabra)) {
				List<String> aux = new ArrayList<>();
				aux.add(palabra);
				dic.put(longitudPalabra, aux);
				if(punteroInt == listas.get(punteroExt).size()-1) {
					return ejercicio2RecFinAux(listas, dic, punteroExt + 1, 0);
				}
				else {
					return ejercicio2RecFinAux(listas, dic, punteroExt, punteroInt + 1);
				}
			}
			else {
				dic.get(longitudPalabra).add(palabra);
				if(punteroInt == listas.get(punteroExt).size()-1) {
					return ejercicio2RecFinAux(listas, dic, punteroExt + 1, 0);
				}
				else {
					return ejercicio2RecFinAux(listas, dic, punteroExt, punteroInt + 1);
				}
			}
		}
	}
	
	public static List<List<String>> lector2(String ruta){
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

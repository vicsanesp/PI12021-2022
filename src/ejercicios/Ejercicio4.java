package ejercicios;


import java.util.ArrayList;
import java.util.List;

import us.lsi.common.DoublePair;
import us.lsi.common.Files2;

public class Ejercicio4 {

	//Diseñe un algoritmo que dados dos números n y e (con n real positivo mayor que 1 y
	//e real en el intervalo (0,1)), devuelva un número real que se corresponda con la raíz cúbica
	//de n con un error menor que e
	public static double ejercicio4It(double n, double e) {
        double numeroIzquierdo = 0;
        double numeroDerecho = n;
        double diferencia = 0;
        while(true) {
            double raiz = (numeroIzquierdo + numeroDerecho) / 2;
            double cubo = (raiz * raiz * raiz);
            diferencia = cubo - n;
            if(Math.abs(diferencia) < e){
                return raiz;
                
            }
            else if (cubo > n) {
                numeroDerecho = raiz;
            }else{
                numeroIzquierdo = raiz;
            }
	
        }
	}
	
	public static double ejercicio4RecFin(double n, double e) {
		return ejercicio4RecFinAux(n, e, 0, 0, n);
	}
	
	public static double ejercicio4RecFinAux(double n, double e, double cubo, double izq, double der) {
		if(Math.abs(cubo-n) < e) {
			return (izq+der)/2;
		}
		else {
			double raiz = (izq+der)/2;
			cubo = raiz*raiz*raiz;
			
			if(cubo > n) {
				return ejercicio4RecFinAux(n, e, cubo, izq, raiz);
			}
			else {
				return ejercicio4RecFinAux(n, e, cubo, raiz, der);
			}
		}
	}
	
	
	public static List<DoublePair> lector4(String ruta){
		List<String> listaFichero = Files2.linesFromFile(ruta);
		List<DoublePair> res = new ArrayList<>();
		for (int i = 0; i < listaFichero.size(); i++) {
			res.add(DoublePair.of(Double.valueOf(listaFichero.get(i).split(",")[0]),
					Double.valueOf(listaFichero.get(i).split(",")[1])));
		}
		return res;
	}
	
	
}

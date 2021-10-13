package ejercicios;


import java.util.ArrayList;
import java.util.List;

import us.lsi.common.DoublePair;
import us.lsi.common.Files2;

public class Ejercicio4 {

	//Dise�e un algoritmo que dados dos n�meros n y e (con n real positivo mayor que 1 y
	//e real en el intervalo (0,1)), devuelva un n�mero real que se corresponda con la ra�z c�bica
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

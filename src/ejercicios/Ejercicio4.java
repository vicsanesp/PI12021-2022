package ejercicios;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import us.lsi.common.DoublePair;
import us.lsi.common.Files2;

public class Ejercicio4 {

	public static record RangoDouble(double numeroIzquierdo, double numeroDerecho, double raiz, double n, double e) {
		public static RangoDouble of(double numeroIzquierdo, double numeroDerecho, double n, double e) {
			return new RangoDouble(numeroIzquierdo, numeroDerecho, (numeroDerecho+numeroIzquierdo)/2, n, e);
		}
		public RangoDouble next() {
			double raiz = (numeroIzquierdo + numeroDerecho)/2;
			double cubo = (raiz * raiz * raiz);
			RangoDouble r;
			if(cubo>n) {
				r = RangoDouble.of(numeroIzquierdo, raiz, n, e);
			}
			else {
				r = RangoDouble.of(raiz, numeroDerecho, n, e);
			}
			return r;
		}
	}
	
	//DiseÃƒÂ±e un algoritmo que dados dos nÃƒÂºmeros n y e (con n real positivo mayor que 1 y
	//e real en el intervalo (0,1)), devuelva un nÃƒÂºmero real que se corresponda con la raÃƒÂ­z cÃƒÂºbica
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
		return ejercicio4RecFinAux(n, e, .0, n, n/2);
	}
	
	public static double ejercicio4RecFinAux(double n, double e, double numeroIzquierdo, double numeroDerecho, double raiz) {
		double cubo = (raiz * raiz * raiz); 
		if(Math.abs(n-cubo)>e) {
			if(cubo>n) {
				return ejercicio4RecFinAux(n, e, numeroIzquierdo, raiz, (numeroIzquierdo+numeroDerecho)/2);
			}
			else {
				return ejercicio4RecFinAux(n, e, raiz, numeroDerecho, (numeroIzquierdo+numeroDerecho)/2);
			}
		}
		return raiz;
	}
	
	public static double ejercicio4Func(double n, double e) {
		RangoDouble ir = RangoDouble.of(0, n, n, e);
		Stream<RangoDouble> stream = Stream.iterate(ir, r-> r.next());
		Optional<RangoDouble> res = stream.filter(r->Math.abs(r.n()-(r.raiz()*r.raiz()*r.raiz()))<r.e()).findFirst();
		return res.get().raiz();
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

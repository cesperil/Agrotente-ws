package es.cem.utilidades;

import java.math.BigDecimal;
import java.util.List;

public class TratamientoDeDatos {

	/**
	 * Indica si el valor es null o cadena vacÃ­a
	 * 
	 * @author cesperilla
	 * @param objeto
	 *            - Object
	 * @return true o false
	 */
	public static boolean esNullVacio(Object objeto) {
		if (objeto == null)
			return true;
		if (objeto.toString().equals(""))
			return true;
		if (objeto.toString().equals("null"))
			return true;

		return false;
	}

	/**
	 * @author rquiros
	 * @param Cadena
	 * @return Integer si es numero sino Integer(0)
	 */
	public static Integer iNoNullEsCero(Object Cadena) {
		if (Cadena == null || Cadena.equals("null")
				|| Cadena.equals("undefined")) {
			return Integer.valueOf(0);
		} else {
			try {
				Integer result = 0;

				if (Cadena instanceof BigDecimal) {
					result = ((BigDecimal) Cadena).intValue();
				} else {
					String valorCadena = Cadena.toString();
					if (valorCadena.length() > 0) {
						result = Integer.parseInt(Cadena.toString());
					} else {
						// si la cadena es vacia devolver 0
						result = Integer.valueOf(0);
					}
				}
				return result;
			} catch (Exception e) {
				return Integer.valueOf(0);
			}
		}
	}
	
	
	/**
	 * Indica si el valor es null, cero o cadena vacÃ­a
	 * 
	 * @author rquiros
	 * @param objeto
	 *            - Object
	 * @return true o false
	 */
	public static boolean esNullCeroVacio(Object objeto) {
		if (objeto == null)
			return true;
		if (objeto.toString().equals("0"))
			return true;
		if (objeto.toString().equals("0.0"))
			return true;
		if (objeto.toString().equals("0,0"))
			return true;
		if (objeto.toString().equals("0,00"))
			return true;
		if (objeto.toString().equals("0.00"))
			return true;
		if (objeto.toString().equals(""))
			return true;
		if (objeto.toString().equals("null"))
			return true;
		return false;
	}
	
	/**
	 * @author cesperilla
	 * @param Cadena
	 *            - Object
	 * @return String Devuelve un objeto convertido a string. si el objeto es
	 *         nulo, devuelve una cadena en blanco.
	 */
	public static String sNoNull(Object Cadena) {
		if (Cadena == null || Cadena.equals("null")
				|| Cadena.equals("undefined")) {
			return ("");
		} else {
			return (Cadena.toString());
		}
	}
	
	/**
	 * @author cesperilla
	 * @param Cadena
	 *            - String
	 * @return String Añade tantos ceros a la izquierda como sean necesarios
	 *         hasta alcanzar el tamaño (Tamano)
	 */
	public static String cerosAIzquierda(String stCadena, Integer iTamano) {
		while (stCadena.length() < iTamano)
			stCadena = "0" + stCadena;
		return stCadena;
	}
	
	
	/**
	 * Indica si la lista es null o no tiene elementos
	 * 
	 * @author fjalonso
	 * @param lista
	 *            - List
	 * @return true o false
	 */
	public static boolean esListaNullVacia(List<?> lista) {
		return ((lista == null) || (lista.size() < 1));
	}

	/**
	 * Indica si la lista tiene elementos.
	 * 
	 * @param lista
	 *            - List
	 * @return true o false
	 */
	public static boolean esListaConElementos(List<?> lista) {
		return !esListaNullVacia(lista);
	}

	
}

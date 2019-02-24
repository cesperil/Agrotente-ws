package es.cem.utilidades;

import com.google.gson.Gson;

public class UtilidadesJSON {
	
	/**
	 * Convierte una cadena json a un objeto
	 * @param cadenaJson
	 * @param objeto
	 * @return
	 * @throws Exception 
	 */
	public static Object jsonToObject(String cadenaJson, Class objeto) throws Exception{
		//Class.forName("com.google.gson.Gson");
		Gson gson = new Gson();
		return  gson.fromJson(cadenaJson, objeto);
	}

}

package es.cem.ln;

import java.sql.SQLException;
import java.util.*;

import com.google.gson.Gson;

import es.cem.VO.MedicionesVO;
import es.cem.ad.AdMedicionSensor;
import es.cem.utilidades.Constantes;
import es.cem.utilidades.TratamientoDeDatos;
import es.cem.utilidades.TratamientoFechas;

public class LnMedicionesSensores {

	/**
	 * 
	 * @param idSensor
	 * @param medicion
	 * @throws SQLException 
	 */
	public static void insertaMedicion(int idSensor, String medicion) throws SQLException{
		AdMedicionSensor.insertMedidaSensor(idSensor, medicion);
	}
	
	/**
	 * 
	 * @param idSensor
	 * @param medicion
	 * @throws SQLException 
	 */
	public static void procesaMedicion(String cadenaRecibida) throws SQLException{
		cadenaRecibida = cadenaRecibida.replace("b", "");
		cadenaRecibida = cadenaRecibida.replace("'", "");
		String[] datos  = cadenaRecibida.split(":");
		AdMedicionSensor.insertMedidaSensor(TratamientoDeDatos.iNoNullEsCero(datos[0]), datos[1]);
	}
	
	public static void insertMinMaxTemperatura(Date diaHoy) throws SQLException{
		Date diaAyer = TratamientoFechas.AddDia(diaHoy, -1);
		
		AdMedicionSensor.insertMedidasMaxMinTemperatura(1, Constantes.TIPO_MEDICION_TEMPERATURA, TratamientoFechas.getTimestampDia(diaAyer), TratamientoFechas.getTimestampDia(diaHoy));
	}
	
	public static void insertMinMaxHumedad(Date diaHoy) throws SQLException{
		Date diaAyer = TratamientoFechas.AddDia(diaHoy, -1);
		
		AdMedicionSensor.insertMedidasMaxMinHumedad(1, Constantes.TIPO_MEDICION_HUMEDAD, TratamientoFechas.getTimestampDia(diaAyer), TratamientoFechas.getTimestampDia(diaHoy));
	}
	
	public static String getMedicionesParcela(String idParcela) throws SQLException{
		
		String[][] mediciones = AdMedicionSensor.getMedicionesParcela(idParcela);
		List<MedicionesVO> listaMediciones = getInfoBDList(mediciones);
		final Gson gson = new Gson();
		String medicionesJSON = gson.toJson(listaMediciones);
		return medicionesJSON;
	}
	
	
	public static List<MedicionesVO> getInfoBDList(String[][] mediciones){
		
		List<MedicionesVO> listaMediciones = new ArrayList<MedicionesVO>();
		
		for(int i = 0; i<mediciones.length; i++){
			MedicionesVO medicionesVO = new MedicionesVO();
			
			medicionesVO.setMax(mediciones[i][0]);
			medicionesVO.setMin(mediciones[i][1]);
			medicionesVO.setFechaAlta(mediciones[i][2]);
			medicionesVO.setSensor(mediciones[i][3]);
			
			listaMediciones.add(medicionesVO);
		}
		
		return listaMediciones;
		
	}
	
}
